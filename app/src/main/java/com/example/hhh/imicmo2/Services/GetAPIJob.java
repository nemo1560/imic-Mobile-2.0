package com.example.hhh.imicmo2.Services;

import com.example.hhh.imicmo2.Entities.Jobs;
import com.example.hhh.imicmo2.Entities.MetaData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetAPIJob {
    @GET("api/getJobRecruiment/")
    Call<MetaData<Jobs>>getJobs(@Query("id")String locationId,@Query("id1")String careerId,@Query("id2")String typeOfWorkId);
}
