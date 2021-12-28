package com.example.retrofit2test;

import com.example.retrofit2test.model.CovidResponse;
import com.example.retrofit2test.model.WeatherResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyApi {
    //JSON
//    @GET("weather")
//    Call<WeatherResponse> getWeather(@Query("q")String q,@Query("appid")String appid);

    @GET("weather")
    Call<WeatherResponse> getWeatherLatLon(@Query("lat")String lat,@Query("lon")String lon,@Query("appid")String appid);

    //XML
    @GET("getCovid19InfStateJson")
    Call<CovidResponse> getCovid(@Query("serviceKey") String serviceKey);
}
