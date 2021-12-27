package com.example.retrofit2test;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Geocoder;
import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofit2test.model.CovidResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        MyApi api = RetrofitClient.getCovidRetrofit().create(MyApi.class);

        Call<CovidResponse> call = api.getCovid(BuildConfig.COVID_API_KEY);
        call.enqueue(new Callback<CovidResponse>() {
            @Override
            public void onResponse(Call<CovidResponse> call, Response<CovidResponse> response) {
                if(!response.isSuccessful()){
                    //임시
                    deathCnt.setText(response.message()+response.errorBody()+response.code()+"");
                    return;
                }
                CovidResponse test = response.body();
                CovidResponse.Item item = test.response.body.items.item.get(0);
                seq.setText(item.seq+"");
                stateDt.setText(item.stateDt+"");
                stateTime.setText(item.stateTime+"");
                decideCnt.setText(item.decideCnt+"");
                deathCnt.setText(item.deathCnt+"");
                accExamCnt.setText(item.accExamCnt+"");
                accDefRate.setText(item.accDefRate+"");
                createDt.setText(item.createDt+"");
                updateDt.setText(item.updateDt+"");
            }

            @Override
            public void onFailure(Call<CovidResponse> call, Throwable t) {
                updateDt.setText(t.getMessage());
            }
        });

        //TODO GEOCODER

    }
}