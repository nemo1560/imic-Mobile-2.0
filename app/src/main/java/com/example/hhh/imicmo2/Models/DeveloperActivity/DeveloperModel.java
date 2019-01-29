package com.example.hhh.imicmo2.Models.DeveloperActivity;

import android.util.Log;

import com.example.hhh.imicmo2.Entities.DeveloperEntity;
import com.example.hhh.imicmo2.Entities.MetaData;
import com.example.hhh.imicmo2.Services.GetAPIDevelopers;
import com.example.hhh.imicmo2.Services.RetrofitInstance;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeveloperModel {
    private CallBackDeveloperModel callBackDeveloperModel;

    public DeveloperModel(CallBackDeveloperModel callBackDeveloperModel) {
        this.callBackDeveloperModel = callBackDeveloperModel;
    }

    public void getApiDeveloper() {
        GetAPIDevelopers service = RetrofitInstance.getRetrofitInstance().create(GetAPIDevelopers.class);
        Call<MetaData<DeveloperEntity>> call = service.getDeveloper();
        call.enqueue(new Callback<MetaData<DeveloperEntity>>() {
            @Override
            public void onResponse(Call<MetaData<DeveloperEntity>> call, Response<MetaData<DeveloperEntity>> response) {
                List<DeveloperEntity> listDeveloper = response.body().getResult();
                    callBackDeveloperModel.getApiListDeviloperSuccess(listDeveloper);
            }

            @Override
            public void onFailure(Call<MetaData<DeveloperEntity>> call, Throwable t) {

            }
        });
    }
}
