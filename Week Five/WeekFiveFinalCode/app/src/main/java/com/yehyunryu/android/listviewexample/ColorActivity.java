package com.yehyunryu.android.listviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ColorActivity extends AppCompatActivity {
    private TextView mNumberTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mNumberTV = (TextView) findViewById(R.id.color_textview);

        Intent intent = getIntent();
        int number = 0;
        if(intent != null) {
            number = intent.getIntExtra("NUMBER", 0);
        }
        mNumberTV.setText(String.valueOf(number));
        switch(number%9) {
            case 0:
                mNumberTV.setBackgroundColor(ContextCompat.getColor(this, R.color.greenZero));
                break;
            case 1:
                mNumberTV.setBackgroundColor(ContextCompat.getColor(this, R.color.greenOne));
                break;
            case 2:
                mNumberTV.setBackgroundColor(ContextCompat.getColor(this, R.color.greenTwo));
                break;
            case 3:
                mNumberTV.setBackgroundColor(ContextCompat.getColor(this, R.color.greenThree));
                break;
            case 4:
                mNumberTV.setBackgroundColor(ContextCompat.getColor(this, R.color.greenFour));
                break;
            case 5:
                mNumberTV.setBackgroundColor(ContextCompat.getColor(this, R.color.greenThree));
                break;
            case 6:
                mNumberTV.setBackgroundColor(ContextCompat.getColor(this, R.color.greenTwo));
                break;
            case 7:
                mNumberTV.setBackgroundColor(ContextCompat.getColor(this, R.color.greenOne));
                break;
            default:
                mNumberTV.setBackgroundColor(ContextCompat.getColor(this, R.color.greenZero));
        };
    }
}
