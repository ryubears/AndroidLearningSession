package com.yehyunryu.android.myweathersixfinal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yehyun Ryu on 3/17/2018.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherHolder> {
    private Context mContext;
    private ArrayList<Weather> mWeathers;

    public WeatherAdapter(Context context, ArrayList<Weather> weathers) {
        mContext = context;
        mWeathers = weathers;
    }

    @Override
    public WeatherAdapter.WeatherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = R.layout.weather_item;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        boolean attachToParentImmediately = false;

        View view = layoutInflater.inflate(layoutId, parent, attachToParentImmediately);
        return new WeatherHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherAdapter.WeatherHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (mWeathers == null) return 0;
        return mWeathers.size();
    }

    public void swapWeather(ArrayList<Weather> newWeathers) {
        mWeathers = newWeathers;
        notifyDataSetChanged();
    }

    public class WeatherHolder extends RecyclerView.ViewHolder {
        private ImageView mWeatherIcon;
        private TextView mWeatherDate;
        private TextView mWeatherDescription;
        private TextView mCurrentTemperature;
        private TextView mLowestTemperature;

        public WeatherHolder(View view) {
            super(view);
            mWeatherIcon = (ImageView) view.findViewById(R.id.weather_icon);
            mWeatherDate = (TextView) view.findViewById(R.id.weather_date);
            mWeatherDescription = (TextView) view.findViewById(R.id.weather_description);
            mCurrentTemperature = (TextView) view.findViewById(R.id.weather_current_temperature);
            mLowestTemperature = (TextView) view.findViewById(R.id.weather_lowest_temperature);
        }

        public void bind(int position) {
            Weather weather = mWeathers.get(position);

            String weatherDescription = weather.getWeatherDescription();
            double currentTemperature = weather.getCurrentTemperature();
            double lowestTemperature = weather.getLowestTemperature();

            mWeatherDescription.setText(weatherDescription);
            mCurrentTemperature.setText(String.valueOf(currentTemperature));
            mLowestTemperature.setText(String.valueOf(lowestTemperature));
        }
    }
}
