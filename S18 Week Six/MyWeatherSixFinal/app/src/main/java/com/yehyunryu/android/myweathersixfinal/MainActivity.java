package com.yehyunryu.android.myweathersixfinal;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    private WeatherAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);
        mProgressBar = (ProgressBar) findViewById(R.id.main_progress_bar);

        mAdapter = new WeatherAdapter(this, null);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(layoutManager);

        new WeatherAsyncTask().execute("Seoul");
    }

    private class WeatherAsyncTask extends AsyncTask<String, Void, ArrayList<Weather>> {

        @Override
        protected void onPreExecute() {
            mProgressBar.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected ArrayList<Weather> doInBackground(String... cityNames) {
            String cityName = cityNames[0];
            return NetworkUtils.fetchWeather(cityName);
        }

        @Override
        protected void onPostExecute(ArrayList<Weather> weathers) {
            mProgressBar.setVisibility(View.GONE);
            mAdapter.swapWeather(weathers);
            super.onPostExecute(weathers);
        }
    }
}
