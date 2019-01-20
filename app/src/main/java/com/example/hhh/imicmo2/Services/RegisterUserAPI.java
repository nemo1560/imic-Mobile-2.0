package com.example.hhh.imicmo2.Services;

import com.example.hhh.imicmo2.Entities.RegisterSuccess;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RegisterUserAPI {
    @GET("api/insertProfilePerson/")
    Call<String>registerUser(
            @Query("fullname")String fullname,@Query("email")String email,@Query("mobile")String mobile,@Query("address")String address,@Query("user")String user,@Query("pass")String pass
    );
}
