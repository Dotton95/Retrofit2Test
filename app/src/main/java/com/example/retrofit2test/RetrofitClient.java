package com.example.retrofit2test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private final static String COVID_URL = "http://openapi.data.go.kr/openapi/service/rest/Covid19/";
    private final static String WEATHER_URL = "https://api.openweathermap.org/data/2.5/";
    private static Retrofit retrofit = null;

    private RetrofitClient(){}
//XML
//    public static Retrofit getCovidRetrofit() {
//
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();
//        if(retrofit == null){
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(COVID_URL)
//                    .addConverterFactory(GsonConverterFactory.create(gson))
//                    .build();
//        }
//        return retrofit;
//    }
//
    private static  Retrofit initRetrofit(String base_url){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }
    public static Retrofit getWeatherRetrofit() { return initRetrofit(WEATHER_URL); }
}
