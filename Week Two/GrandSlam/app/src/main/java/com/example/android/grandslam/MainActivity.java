package com.example.android.grandslam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayTeamA(0);
        displayTeamB(0);
    }

    private void displayTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.scoreA);
        scoreView.setText(String.valueOf(score));
    }

    private void displayTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.scoreB);
        scoreView.setText(String.valueOf(score));
    }

    public void addOnePointA(View view) {
        scoreTeamA += 1;
        displayTeamA(scoreTeamA);
    }

    public void addTwoPointsA(View view) {
        scoreTeamA += 2;
        displayTeamA(scoreTeamA);
    }

    public void addThreePointsA(View view) {
        scoreTeamA += 3;
        displayTeamA(scoreTeamA);
    }

    public void addFourPointsA(View view) {
        scoreTeamA += 4;
        displayTeamA(scoreTeamA);
    }

    public void addOnePointB(View view) {
        scoreTeamB += 1;
        displayTeamB(scoreTeamB);
    }

    public void addTwoPointsB(View view) {
        scoreTeamB += 2;
        displayTeamB(scoreTeamB);
    }

    public void addThreePointsB(View view) {
        scoreTeamB += 3;
        displayTeamB(scoreTeamB);
    }

    public void addFourPointsB(View view) {
        scoreTeamB += 4;
        displayTeamB(scoreTeamB);
    }

    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayTeamA(scoreTeamA);
        displayTeamB(scoreTeamB);
    }
}
