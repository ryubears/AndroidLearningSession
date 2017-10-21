package com.yehyunryu.android.scoreboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mScoreATextView;
    private TextView mScoreBTextView;
    private Button mAPoint1;
    private Button mAPoint2;
    private Button mAPoint3;
    private Button mBPoint1;
    private Button mBPoint2;
    private Button mBPoint3;
    private Button mReset;

    private static int mTeamAScore = 0;
    private static int mTeamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreATextView = (TextView) findViewById(R.id.teamA_score);
        mScoreBTextView = (TextView) findViewById(R.id.teamB_score);
        mAPoint1 = (Button) findViewById(R.id.teamA_point1);
        mAPoint2 = (Button) findViewById(R.id.teamA_point2);
        mAPoint3 = (Button) findViewById(R.id.teamA_point3);
        mBPoint1 = (Button) findViewById(R.id.teamB_point1);
        mBPoint2 = (Button) findViewById(R.id.teamB_point2);
        mBPoint3 = (Button) findViewById(R.id.teamB_point3);
        mReset = (Button) findViewById(R.id.reset_button);
    }

    public void onTeamAPoint1(View view) {
        mTeamAScore = mTeamAScore + 1;
        mScoreATextView.setText(String.valueOf(mTeamAScore));
    }

    public void onTeamAPoint2(View view) {
        mTeamAScore = mTeamAScore + 2;
        mScoreATextView.setText(String.valueOf(mTeamAScore));
    }

    public void onTeamAPoint3(View view) {
        mTeamAScore = mTeamAScore + 3;
        mScoreATextView.setText(String.valueOf(mTeamAScore));
    }

    public void onTeamBPoint1(View view) {
        mTeamBScore = mTeamBScore + 1;
        mScoreBTextView.setText(String.valueOf(mTeamBScore));
    }

    public void onTeamBPoint2(View view) {
        mTeamBScore = mTeamBScore + 2;
        mScoreBTextView.setText(String.valueOf(mTeamBScore));
    }

    public void onTeamBPoint3(View view) {
        mTeamBScore = mTeamBScore + 3;
        mScoreBTextView.setText(String.valueOf(mTeamBScore));
    }

    public void onReset(View view) {
        mTeamAScore = 0;
        mTeamBScore = 0;
        mScoreATextView.setText(String.valueOf(mTeamAScore));
        mScoreBTextView.setText(String.valueOf(mTeamBScore));
    }
}
