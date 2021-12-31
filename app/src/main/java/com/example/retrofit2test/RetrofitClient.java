package com.example.retrofit2test;


import com.tickaroo.tikxml.TikXml;
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private final static String COVID_URL = "http://openapi.data.go.kr/openapi/service/rest/Covid19/";
    private final static String WEATHER_URL = "https://api.openweathermap.org/data/2.5/";

    private static Retrofit covidRetrofit = null;
    private static Retrofit weatherRetrofit = null;

    private RetrofitClient(){}


    private static  Retrofit initRetrofit(String base_url, Converter.Factory factory){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();

        if(base_url==COVID_URL){
            if(covidRetrofit == null){
                covidRetrofit = new Retrofit.Builder()
                        .baseUrl(base_url)
                        .addConverterFactory(factory)
                        .client(client)
                        .build();
            }
            return covidRetrofit;
        }else{
            if(weatherRetrofit == null){
                weatherRetrofit = new Retrofit.Builder()
                        .baseUrl(base_url)
                        .addConverterFactory(factory)
                        .client(client)
                        .build();
            }
            return weatherRetrofit;
        }
    }
    //GSON
    public static Retrofit getWeatherRetrofit() { return initRetrofit(WEATHER_URL, GsonConverterFactory.create()); }

    //XML
    public static Retrofit getCovidRetrofit() { return initRetrofit(COVID_URL, TikXmlConverterFactory.create(new TikXml.Builder().exceptionOnUnreadXml(false).build())); }

}
