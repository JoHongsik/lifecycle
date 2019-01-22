package com.example.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String STAGE_SCORE = "playerScore";
    public static final String Stage_LEVEL = "playerLevel";
    private TextView mLevelText;
    private TextView mScoreText;

    private int mLevel = 0;
    private int mScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLevelText = findViewById(R.id.level_Text);
        mScoreText = findViewById(R.id.score_Text);

        if(savedInstanceState == null){

        }
        else{
            mLevel = savedInstanceState.getInt(Stage_LEVEL);
            mScore = savedInstanceState.getInt(STAGE_SCORE);
            mLevelText.setText("레벨 : "+ mLevel);
            mScoreText.setText("점수 : "+ mScore);

        }

    }

    public void onLevelup(View view) {
        mLevel++;
        mLevelText.setText("레벨 : "+ mLevel);
    }

    public void onScoreup(View view) {
        mScore++;
        mScoreText.setText("점수 : "+ mScore);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STAGE_SCORE,mScore);
        outState.putInt(Stage_LEVEL,mLevel);

        super.onSaveInstanceState(outState);
    }
}
