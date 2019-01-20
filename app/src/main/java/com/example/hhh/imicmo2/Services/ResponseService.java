package com.example.hhh.imicmo2.Services;

import com.example.hhh.imicmo2.Entities.DeveloperEntity;
import com.example.hhh.imicmo2.Entities.MetaData;
import com.example.hhh.imicmo2.Entities.OpeningScheduler;
import com.example.hhh.imicmo2.Entities.VideoGroupEntity;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ResponseService {
    @GET("api/getVGroups")
    Call<MetaData<VideoGroupEntity>> getVideoGroup();

    @GET("api/getOpeningScheduler")
    Call<MetaData<OpeningScheduler>> getOpeningScheduler();

    @GET("api/getDeveloper")
    Call<MetaData<DeveloperEntity>> getDeveloper();

}
