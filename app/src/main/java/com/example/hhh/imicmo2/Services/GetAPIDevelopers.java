package com.example.hhh.imicmo2.Services;

import com.example.hhh.imicmo2.Entities.DeveloperEntity;
import com.example.hhh.imicmo2.Entities.MetaData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetAPIDevelopers {
    @GET("api/getDeveloper")
    Call<MetaData<DeveloperEntity>> getDeveloper();
}
