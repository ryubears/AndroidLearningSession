package com.yehyunryu.android.myweatherstartfour;

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
        weathers.add(new Weather("Today", "Snowy", -13.1, -18.0));
        weathers.add(new Weather("Tomorrow", "Windy", -11.1, -14.2));
        weathers.add(new Weather("February 16", "Cloudy", -8.7, -9.0));
        weathers.add(new Weather("February 17", "Snowy", -5.4, -7.8));
        weathers.add(new Weather("February 18", "Clear", -2.1, -3.4));
        weathers.add(new Weather("February 19", "Blizzard", -6.7, -8.5));
        weathers.add(new Weather("February 20", "Rainy", 2.4, 1.4));

        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);

        WeatherAdapter weatherAdapter = new WeatherAdapter(this, weathers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setAdapter(weatherAdapter);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    //TODO 4. Create NetworkUtils.java
    //TODO 5. Add API Key as a static final String variable
    //TODO 6. Add Base URL
    //TODO 7. Create buildURL() method
    //TODO 8. Create makeHTTPConnection() method
}
