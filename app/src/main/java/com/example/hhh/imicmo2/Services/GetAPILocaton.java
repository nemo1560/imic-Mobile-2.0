package com.example.hhh.imicmo2.Services;

import com.example.hhh.imicmo2.Entities.LocationWork;
import com.example.hhh.imicmo2.Entities.MetaData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetAPILocaton {
    @GET("api/getLocations")
    Call<MetaData<LocationWork>>getLocations();
}
