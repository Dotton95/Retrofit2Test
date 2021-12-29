package com.example.retrofit2test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit2test.model.CovidResponse;
import com.example.retrofit2test.model.WeatherResponse;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView tv_weather,tv_degree,seq,stateDt,stateTime,decideCnt,deathCnt,accExamCnt,accDefRate,createDt,updateDt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_weather = findViewById(R.id.tv_weather);
        tv_degree = findViewById(R.id.tv_degree);
        seq = findViewById(R.id.seq);
        stateDt = findViewById(R.id.stateDt);
        stateTime = findViewById(R.id.stateTime);
        decideCnt = findViewById(R.id.decideCnt);
        deathCnt = findViewById(R.id.deathCnt);
        accExamCnt = findViewById(R.id.accExamCnt);
        accDefRate = findViewById(R.id.accDefRate);
        createDt = findViewById(R.id.createDt);
        updateDt = findViewById(R.id.updateDt);

        Geocoder geo = new Geocoder(getApplicationContext(), Locale.KOREA);
        try {
            List<Address> address = geo.getFromLocationName(" 경기도 하남시",2);
            double lat = Math.round(address.get(0).getLatitude()*100)/100;
            double lon = Math.round(address.get(0).getLongitude()*100)/100;

            MyApi weatherApi = RetrofitClient.getWeatherRetrofit().create(MyApi.class);

            Call<WeatherResponse> weatherCall = weatherApi.getWeatherLatLon(lat+"",lon+"",BuildConfig.WEATHER_API_KEY);
            weatherCall.enqueue(new Callback<WeatherResponse>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                    if (response.isSuccessful()){
                        WeatherResponse test = response.body();
                        tv_weather.setText("현재날씨 - "+test.weather.get(0).main);
                        tv_degree.setText("현재온도 - "+(int)(test.main.temp-273.15)+"℃");
                    }
                }
                @Override
                public void onFailure(Call<WeatherResponse> call, Throwable t) {
                    call.cancel();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


//        MyApi api = RetrofitClient.getCovidRetrofit().create(MyApi.class);

//        Call<CovidResponse> call = api.getCovid(BuildConfig.COVID_API_KEY);
//        call.enqueue(new Callback<CovidResponse>() {
//            @Override
//            public void onResponse(Call<CovidResponse> call, Response<CovidResponse> response) {
//                if(!response.isSuccessful()){
//                    //임시
//                    deathCnt.setText(response.message()+response.errorBody()+response.code()+"");
//                    return;
//                }
//                CovidResponse test = response.body();
//                CovidResponse.Item item = test.response.body.items.item.get(0);
//                seq.setText(item.seq+"");
//                stateDt.setText(item.stateDt+"");
//                stateTime.setText(item.stateTime+"");
//                decideCnt.setText(item.decideCnt+"");
//                deathCnt.setText(item.deathCnt+"");
//                accExamCnt.setText(item.accExamCnt+"");
//                accDefRate.setText(item.accDefRate+"");
//                createDt.setText(item.createDt+"");
//                updateDt.setText(item.updateDt+"");
//            }
//
//            @Override
//            public void onFailure(Call<CovidResponse> call, Throwable t) {
//                updateDt.setText(t.getMessage());
//            }
//        });

    }
}