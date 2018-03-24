package com.yehyunryu.android.myweathersevenfinal;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by Yehyun Ryu on 3/24/2018.
 */

public class NetworkUtils {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private static final String API_KEY_PARAM = "&appid=";
    private static final String API_KEY = BuildConfig.OPEN_WEATHER_MAP_API_KEY;

    public static URL buildURL(String cityName) {
        String urlString = BASE_URL + cityName + API_KEY_PARAM + API_KEY;
        URL url = null;
        try {
            url = new URL(urlString);
        } catch(MalformedURLException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
        return url;
    }

    public static String makeHTTPConnection(URL url) throws IOException {
        String jsonReponse = null;
        if(url == null) return null;

        HttpURLConnection connection = null;
        InputStream inputStream = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(10000);;
            connection.connect();
            if(connection.getResponseCode() == 200) {
                inputStream = connection.getInputStream();
                jsonReponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error Response Code: " + String.valueOf(connection.getResponseCode()));
            }
        } catch(IOException e) {
            Log.e(LOG_TAG, "Error with establishing a HTTP connection: " + e.getMessage());
        } finally {
            if(inputStream != null) inputStream.close();
            if(connection != null) connection.disconnect();
            return jsonReponse;
        }
    }

    public static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if(inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while(line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    public static ArrayList<Weather> extractFromJSON(String jsonResponse) {
        if(jsonResponse == null) return null;
        ArrayList<Weather> weathers = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(jsonResponse);
            JSONArray list = root.getJSONArray("list");
            for(int i = 0; i < list.length(); i++) {
                JSONObject weather = list.getJSONObject(i);
                long time = weather.getLong("dt");

                JSONObject main = weather.getJSONObject("main");
                double currentTemp = main.getDouble("temp");
                double minTemp = main.getDouble("temp_min");
                double pressure = main.getDouble("pressure");
                double humidity = main.getDouble("humidity");

                JSONObject weatherInfo = weather.getJSONArray("weather").getJSONObject(0);
                int weatherId = weatherInfo.getInt("id");
                String description = weatherInfo.getString("description");

                JSONObject wind = weather.getJSONObject("wind");
                double windSpeed = wind.getDouble("speed");

                weathers.add(new Weather(time, weatherId, description, currentTemp, minTemp, pressure, humidity, windSpeed));
            }
        } catch(JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
        return weathers;
    }

    public static ArrayList<Weather> fetchWeather(String cityName) {
        URL url = buildURL(cityName);
        String jsonResponse = null;
        try {
            jsonResponse = makeHTTPConnection(url);
        } catch(IOException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
        return extractFromJSON(jsonResponse);
    }
}
