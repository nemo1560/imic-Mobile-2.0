package com.example.hhh.imicmo2.Models.OpeningSchedulerFragment;

import com.example.hhh.imicmo2.Entities.MetaData;
import com.example.hhh.imicmo2.Entities.OpeningScheduler;
import com.example.hhh.imicmo2.Services.GetAPIOpenScheduler;
import com.example.hhh.imicmo2.Services.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OpenSchedulerModel {
    private OpenSchedulerFragmentPresenter openSchedulerFragmentPresenter;
    private GetAPIOpenScheduler getAPIOpenScheduler;

    public OpenSchedulerModel(OpenSchedulerFragmentPresenter openSchedulerFragmentPresenter) {
        this.openSchedulerFragmentPresenter = openSchedulerFragmentPresenter;
    }

    public void getOpenScheduler(){
        getAPIOpenScheduler = RetrofitInstance.getRetrofitInstance().create(GetAPIOpenScheduler.class);
        Call<MetaData<OpeningScheduler>> metaDataCall = getAPIOpenScheduler.getOpenSchuduler();
        metaDataCall.enqueue(new Callback<MetaData<OpeningScheduler>>() {
            @Override
            public void onResponse(Call<MetaData<OpeningScheduler>> call, Response<MetaData<OpeningScheduler>> response) {
                openSchedulerFragmentPresenter.getAPIOpenSchedulerSuccess(response.body().getResult());
            }

            @Override
            public void onFailure(Call<MetaData<OpeningScheduler>> call, Throwable t) {
                openSchedulerFragmentPresenter.getAPIOpenSchedulerFail(t.toString());
            }
        });
    }
}
