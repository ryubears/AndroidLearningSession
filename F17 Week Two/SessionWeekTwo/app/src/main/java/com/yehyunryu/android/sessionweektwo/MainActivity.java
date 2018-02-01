package com.yehyunryu.android.sessionweektwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();
    private TextView mTextView;
    private ImageView mImageView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.main_textview);
        mImageView = (ImageView) findViewById(R.id.main_imageview);
        mButton = (Button) findViewById(R.id.main_button);

        mTextView.setText("Hello World!");
        mImageView.setImageResource(R.drawable.random);
        Log.d(TAG, "Testing debugging");
    }

    public void onTestClick(View view) {
        Intent intent = new Intent(this, ConstraintLayoutExample.class);
        startActivity(intent);
    }
}
