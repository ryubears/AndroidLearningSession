package com.yehyunryu.android.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.main_recyclerview);

        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 15; i++) {
            numbers.add(i);
        }
        RecyclerAdapter adapter = new RecyclerAdapter(this, numbers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(gridLayoutManager);
    }
}
