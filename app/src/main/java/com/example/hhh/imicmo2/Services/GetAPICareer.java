package com.example.hhh.imicmo2.Services;

import com.example.hhh.imicmo2.Entities.Careers;
import com.example.hhh.imicmo2.Entities.MetaData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetAPICareer {
    @GET("api/getCareers")
    Call<MetaData<Careers>>getCareers();
}
