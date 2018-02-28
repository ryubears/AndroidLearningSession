package com.yehyunryu.android.myweatherfivestart;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Yehyun Ryu on 2/27/2018.
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

    public static String readFromStream(InputStream inputStream) {
        //not filled out yet
        return "";
    }
}
