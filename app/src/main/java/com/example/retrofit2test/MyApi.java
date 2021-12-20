package com.example.retrofit2test;

import com.example.retrofit2test.model.CovidResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    @GET("getCovid19InfStateJson")
    Call<CovidResponse> getCovid();
}
