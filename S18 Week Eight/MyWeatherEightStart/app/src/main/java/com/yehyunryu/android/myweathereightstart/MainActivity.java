package com.yehyunryu.android.myweathereightstart;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

// TODO: 1. Add Weather Icons
// TODO: 2. Create WeatherUtils.java
// TODO: 3. Add getWeatherIcon() method
// TODO: 4. Add divider in weather_item.xml
// TODO: 5. Add formatDescription() method
// TODO: 6. Add formatTemperature() method
// TODO: 7. Add formatDate() method
// TODO: 8. Change App Name in strings.xml
// TODO: 9. Change color theme in colors.xml
// TODO: 10. Modify WeatherAdapter to use the WeatherUtils.java methods

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Weather>> {
    private RecyclerView mRecyclerView;

    private static final int WEATHER_LOADER = 101;
    private static final String WEATHER_QUERY_KEY = "weather_query";

    private WeatherAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);

        mAdapter = new WeatherAdapter(this, null);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(layoutManager);

        Bundle args = new Bundle();
        args.putString(WEATHER_QUERY_KEY, "Minneapolis");

        LoaderManager loaderManager = getSupportLoaderManager();
        if (loaderManager.getLoader(WEATHER_LOADER) == null) {
            loaderManager.initLoader(WEATHER_LOADER, args, this).forceLoad();
        } else {
            loaderManager.restartLoader(WEATHER_LOADER, args, this).forceLoad();
        }

    }

    @Override
    public Loader<ArrayList<Weather>> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case WEATHER_LOADER:
                return new WeatherLoader(this, args);
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Weather>> loader, ArrayList<Weather> weathers) {
        mAdapter.swapWeather(weathers);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Weather>> loader) {
        mAdapter.swapWeather(null);
    }

    private static class WeatherLoader extends AsyncTaskLoader<ArrayList<Weather>> {
        private String mCityName;

        public WeatherLoader(Context context, Bundle args) {
            super(context);
            mCityName = args.getString(WEATHER_QUERY_KEY);
        }

        @Override
        public ArrayList<Weather> loadInBackground() {
            return NetworkUtils.fetchWeather(mCityName);
        }
    }
}
