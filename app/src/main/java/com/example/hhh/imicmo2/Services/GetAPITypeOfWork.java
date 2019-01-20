package com.example.hhh.imicmo2.Services;

import com.example.hhh.imicmo2.Entities.MetaData;
import com.example.hhh.imicmo2.Entities.TypeOfWork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetAPITypeOfWork {
    @GET("api/getTypeOfWorks")
    Call<MetaData<TypeOfWork>>getTypeOfWork();
}
