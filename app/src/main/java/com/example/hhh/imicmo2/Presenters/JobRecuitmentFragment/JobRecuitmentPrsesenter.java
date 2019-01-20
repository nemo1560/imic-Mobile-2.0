package com.example.hhh.imicmo2.Presenters.JobRecuitmentFragment;

import android.widget.ProgressBar;

import com.example.hhh.imicmo2.Entities.Careers;
import com.example.hhh.imicmo2.Entities.Jobs;
import com.example.hhh.imicmo2.Entities.LocationWork;
import com.example.hhh.imicmo2.Entities.TypeOfWork;
import com.example.hhh.imicmo2.Models.JobRecuitmentFragment.JobRecuitmentFragmentPresenter;
import com.example.hhh.imicmo2.Models.JobRecuitmentFragment.JobRecuitmentModel;

import java.util.List;

public class JobRecuitmentPrsesenter implements JobRecuitmentFragmentPresenter{
    private JobRecuitmentFragmentView jobRecuitmentFragmentView;
    private JobRecuitmentModel jobRecuitmentModel;
    private ProgressBar progressBar;

    public JobRecuitmentPrsesenter(JobRecuitmentFragmentView jobRecuitmentFragmentView,ProgressBar progressBar) {
        this.jobRecuitmentFragmentView = jobRecuitmentFragmentView;
        this.progressBar = progressBar;
        jobRecuitmentModel = new JobRecuitmentModel(JobRecuitmentPrsesenter.this,progressBar);
    }

    public void GetAPIgetTypeOfWorks(){
        jobRecuitmentModel.GetAPIgetTypeOfWorks();
    }

    public  void GetAPIgetLocations(){
        jobRecuitmentModel.GetAPILocationWork();
    }

    public void GetAPIgetCareers(){
        jobRecuitmentModel.GetAPICareerWork();
    }

    public void GetAPIJobs(String locationId, String careerId,String typeOfWorkId,ProgressBar progressBar){
        jobRecuitmentModel.getAPIJobs(locationId,careerId,typeOfWorkId,progressBar);
    }

    @Override
    public void GetAPIgetTypeOfWorksList(List<TypeOfWork> typeOfWorkList) {
        jobRecuitmentFragmentView.GetTypeOfWorksList(typeOfWorkList);
    }

    @Override
    public void GetAPIgetLocations(List<LocationWork> locationWorkList) {
        jobRecuitmentFragmentView.GetLocations(locationWorkList);
    }

    @Override
    public void GetAPIgetCareers(List<Careers> careersList) {
        jobRecuitmentFragmentView.GetCareers(careersList);
    }

    @Override
    public void GetAPIJobs(List<Jobs> jobsList) {
        jobRecuitmentFragmentView.GetJobs(jobsList);
    }
}
