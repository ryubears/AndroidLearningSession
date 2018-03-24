package com.yehyunryu.android.myweathersevenfinal;

/**
 * Created by Yehyun Ryu on 3/24/2018.
 */

public class Weather {
    private long mTime;
    private int mId;
    private String mWeatherDescription;
    private double mCurrentTemperature;
    private double mLowestTemperature;
    private double mPressure;
    private double mHumidity;
    private double mWindSpeed;

    public Weather(long time, int id, String weatherDescription, double currentTemperature, double lowestTemperature, double pressure, double humidity, double windSpeed) {
        mTime = time;
        mId = id;
        mWeatherDescription = weatherDescription;
        mCurrentTemperature = currentTemperature;
        mLowestTemperature = lowestTemperature;
        mPressure = pressure;
        mHumidity = humidity;
        mWindSpeed = windSpeed;
    }

    public long getTime() {return mTime;}

    public int getId() {return mId;}

    public String getWeatherDescription() {
        return mWeatherDescription;
    }

    public double getCurrentTemperature() {
        return mCurrentTemperature;
    }

    public double getLowestTemperature() {
        return mLowestTemperature;
    }

    public double getPressure() {return mPressure;}

    public double getHumidity() {return mHumidity;}

    public double getWindSpeed() {return mWindSpeed;}
}

