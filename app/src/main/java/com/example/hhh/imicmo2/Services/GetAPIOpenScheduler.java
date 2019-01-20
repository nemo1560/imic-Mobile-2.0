package com.example.hhh.imicmo2.Services;

import com.example.hhh.imicmo2.Entities.MetaData;
import com.example.hhh.imicmo2.Entities.OpeningScheduler;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetAPIOpenScheduler {
    @GET("api/getOpeningScheduler")
    Call<MetaData<OpeningScheduler>> getOpenSchuduler();
}
