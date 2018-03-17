package com.yehyunryu.android.myweathersixstart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Weather> weathers = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);

        WeatherAdapter weatherAdapter = new WeatherAdapter(this, weathers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setAdapter(weatherAdapter);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    // TODO: 1. Create custom AsyncTask class within MainActivity.class
    // TODO: 2. Implement doInBackground()
    // TODO: 3. Add swapWeather() method in WeatherAdapter
    // TODO: 4. Override and implement onPostExecute()
    // TODO: 5. Add ProgressBar in activity_main.xml
    // TODO: 6. Show ProgressBar while loading by overriding and implementing onPreExecute()
}
