package com.example.retrofit2test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView seq,stateDt,stateTime,decideCnt,deathCnt,accExamCnt,accDefRate,createDt,updateDt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seq = findViewById(R.id.seq);
        stateDt = findViewById(R.id.stateDt);
        stateTime = findViewById(R.id.stateTime);
        decideCnt = findViewById(R.id.decideCnt);
        deathCnt = findViewById(R.id.deathCnt);
        accExamCnt = findViewById(R.id.accExamCnt);
        accDefRate = findViewById(R.id.accDefRate);
        createDt = findViewById(R.id.createDt);
        updateDt = findViewById(R.id.updateDt);


    }
}