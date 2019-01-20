package com.example.hhh.imicmo2.Models.JobRecuitmentFragment;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.hhh.imicmo2.Entities.Careers;
import com.example.hhh.imicmo2.Entities.Jobs;
import com.example.hhh.imicmo2.Entities.LocationWork;
import com.example.hhh.imicmo2.Entities.MetaData;
import com.example.hhh.imicmo2.Entities.TypeOfWork;
import com.example.hhh.imicmo2.Services.GetAPICareer;
import com.example.hhh.imicmo2.Services.GetAPIJob;
import com.example.hhh.imicmo2.Services.GetAPILocaton;
import com.example.hhh.imicmo2.Services.GetAPITypeOfWork;
import com.example.hhh.imicmo2.Services.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobRecuitmentModel {
    private JobRecuitmentFragmentPresenter jobRecuitmentFragmentPresenter;
    private GetAPITypeOfWork getAPITypeOfWork;
    private GetAPICareer getAPICareer;
    private GetAPILocaton getAPILocaton;
    private GetAPIJob getAPIJob;
    private ProgressBar progressBar;

    public JobRecuitmentModel(JobRecuitmentFragmentPresenter jobRecuitmentFragmentPresenter,ProgressBar progressBar) {
        this.jobRecuitmentFragmentPresenter = jobRecuitmentFragmentPresenter;
        this.progressBar = progressBar;
    }

    /*
     * Lay data spinnet
     * */
    public void GetAPIgetTypeOfWorks(){
        getAPITypeOfWork = RetrofitInstance.getRetrofitInstance().create(GetAPITypeOfWork.class);
        Call<MetaData<TypeOfWork>>listCall = getAPITypeOfWork.getTypeOfWork();
        listCall.enqueue(new Callback<MetaData<TypeOfWork>>() {
            @Override
            public void onResponse(Call<MetaData<TypeOfWork>> call, Response<MetaData<TypeOfWork>> response) {
                jobRecuitmentFragmentPresenter.GetAPIgetTypeOfWorksList(response.body().getResult());
            }

            @Override
            public void onFailure(Call<MetaData<TypeOfWork>> call, Throwable t) {
                Log.d("loiWork",t.getMessage());
            }
        });
    }

    /*
     * Lay data spinnet
     * */
    public void GetAPILocationWork() {
        getAPILocaton = RetrofitInstance.getRetrofitInstance().create(GetAPILocaton.class);
        Call<MetaData<LocationWork>> listCall = getAPILocaton.getLocations();
        listCall.enqueue(new Callback<MetaData<LocationWork>>() {
            @Override
            public void onResponse(Call<MetaData<LocationWork>> call, Response<MetaData<LocationWork>> response) {
                jobRecuitmentFragmentPresenter.GetAPIgetLocations(response.body().getResult());
            }

            @Override
            public void onFailure(Call<MetaData<LocationWork>> call, Throwable t) {
                Log.d("loiLocation", t.getMessage());
            }
        });
    }

    /*
     * Lay data spinnet
     * */
    public void GetAPICareerWork() {
        getAPICareer = RetrofitInstance.getRetrofitInstance().create(GetAPICareer.class);
        Call<MetaData<Careers>> listCall = getAPICareer.getCareers();
        listCall.enqueue(new Callback<MetaData<Careers>>() {
            @Override
            public void onResponse(Call<MetaData<Careers>> call, Response<MetaData<Careers>> response) {
                jobRecuitmentFragmentPresenter.GetAPIgetCareers(response.body().getResult());
            }

            @Override
            public void onFailure(Call<MetaData<Careers>> call, Throwable t) {
                Log.d("loiLocation", t.getMessage());
            }
        });
    }

    /*
    * Lay data cong viec
    * */
    public void getAPIJobs(String locationId, String careerId, String typeOfWorkId, final ProgressBar progressBar){
        progressBar.setVisibility(View.VISIBLE);
        getAPIJob = RetrofitInstance.getRetrofitInstance().create(GetAPIJob.class);
        Call<MetaData<Jobs>> listCall = getAPIJob.getJobs(locationId,careerId,typeOfWorkId);
        listCall.enqueue(new Callback<MetaData<Jobs>>() {
            @Override
            public void onResponse(Call<MetaData<Jobs>> call, Response<MetaData<Jobs>> response) {
                jobRecuitmentFragmentPresenter.GetAPIJobs(response.body().getResult());
            }

            @Override
            public void onFailure(Call<MetaData<Jobs>> call, Throwable t) {
                Log.d("loiJob", t.getMessage());
            }
        });
    }
}
