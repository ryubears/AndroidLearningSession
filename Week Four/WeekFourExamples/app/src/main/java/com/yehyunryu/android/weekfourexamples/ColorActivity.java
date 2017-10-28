package com.yehyunryu.android.weekfourexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ColorActivity extends AppCompatActivity {
    private TextView mNumberTextView;

    private int mNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mNumberTextView = findViewById(R.id.color_textview);

        Intent intent = getIntent();
        if(intent != null) {
            mNumber = intent.getIntExtra("Number", 0);
        }

        mNumberTextView.setText(String.valueOf(mNumber));
        int colorNum = mNumber % 10;
        switch(colorNum) {
            case 9:
                mNumberTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.green1));
                break;
            case 8:
                mNumberTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.green2));
                break;
            case 7:
                mNumberTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.green3));
                break;
            case 6:
                mNumberTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.green4));
                break;
            case 5:
                mNumberTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.green5));
                break;
            case 4:
                mNumberTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.green5));
                break;
            case 3:
                mNumberTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.green4));
                break;
            case 2:
                mNumberTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.green3));
                break;
            case 1:
                mNumberTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.green2));
                break;
            default:
                mNumberTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.green1));
        }
    }
}
