package com.yehyunryu.android.myweatherfinalfour;

/**
 * Created by Yehyun Ryu on 2/21/2018.
 */

public class Weather {
    private String mDate;
    private String mWeatherDescription;
    private double mCurrentTemperature;
    private double mLowestTemperature;

    public Weather(String date, String weatherDescription, double currentTemperature, double lowestTemperature) {
        mDate = date;
        mWeatherDescription = weatherDescription;
        mCurrentTemperature = currentTemperature;
        mLowestTemperature = lowestTemperature;
    }

    public String getDate() {
        return mDate;
    }

    public String getWeatherDescription() {
        return mWeatherDescription;
    }

    public double getCurrentTemperature() {
        return mCurrentTemperature;
    }

    public double getLowestTemperature() {
        return mLowestTemperature;
    }
}