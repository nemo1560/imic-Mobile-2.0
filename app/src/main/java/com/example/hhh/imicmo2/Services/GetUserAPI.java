package com.example.hhh.imicmo2.Services;

import com.example.hhh.imicmo2.Entities.Account;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
//API co yeu cau param
public interface GetUserAPI {
    @GET("api/getProfilePerson/")
    Call<Account> getUer(
            @Query("user") String user,@Query("pass") String pass
            );
}
