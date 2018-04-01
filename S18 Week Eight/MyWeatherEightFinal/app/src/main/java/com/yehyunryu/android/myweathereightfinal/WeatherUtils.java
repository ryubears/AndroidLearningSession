package com.yehyunryu.android.myweathereightfinal;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WeatherUtils {

    public static int getWeatherIcon(int id) {
        if (id >= 200 && id < 300) {
            return R.drawable.storm;
        } else if (id >= 300 && id < 400) {
            return R.drawable.rain;
        } else if (id >= 500 && id < 600) {
            return R.drawable.rain;
        } else if (id >= 600 && id < 700) {
            return R.drawable.snow;
        } else if (id >= 700 && id < 800) {
            return R.drawable.windy;
        } else if (id == 800) {
            return R.drawable.clear;
        } else if (id > 800 && id < 900) {
            return R.drawable.cloudy;
        } else if (id >= 900 && id < 1000) {
            return R.drawable.extreme;
        } else {
            return -1;
        }
    }

    public static String formatDescription(String description) {
        if (description == null) return null;
        String[] split = description.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            result.append(Character.toUpperCase(split[i].charAt(0)));
            result.append(split[i].substring(1));
            if (i < split.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static double convertTemperature(double temp, boolean isCelsius) {
        if (isCelsius) {
            return temp - 273.15;
        } else {
            return (temp - 273.15) * 1.8 + 32;
        }
    }

    public static String formatTemperature(double temp) {
        DecimalFormat df = new DecimalFormat("0.0");
        String tempString = df.format(convertTemperature(temp, true));
        return tempString + "°";
    }

    public static String formatDate(long time) {
        Date resultDate = new Date(time * 1000);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        //milliseconds till midnight
        long timeApartFromMidnight = (time * 1000) - calendar.getTimeInMillis();

        String dateString = "";
        if(timeApartFromMidnight < 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
            dateString = "Today, " + sdf.format(resultDate);
        } else if(timeApartFromMidnight < TimeUnit.DAYS.toMillis(1)) {
            SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
            dateString = "Tomorrow, " + sdf.format(resultDate);
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, h:mm a");
            dateString = sdf.format(resultDate);
        }
        return dateString;
    }
}
