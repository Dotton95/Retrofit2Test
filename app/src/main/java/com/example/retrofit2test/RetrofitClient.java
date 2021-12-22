package com.example.retrofit2test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private final static String COVID_URL = "http://openapi.data.go.kr/openapi/service/rest/Covid19/";
    private static Retrofit retrofit = null;

    private RetrofitClient(){}



    public static Retrofit getRetrofit() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(COVID_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
