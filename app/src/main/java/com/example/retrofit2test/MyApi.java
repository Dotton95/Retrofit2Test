package com.example.retrofit2test;

import com.example.retrofit2test.model.CovidResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyApi {
    @GET("getCovid19InfStateJson")
    Call<CovidResponse> getCovid(@Query("serviceKey") String serviceKey);
}
