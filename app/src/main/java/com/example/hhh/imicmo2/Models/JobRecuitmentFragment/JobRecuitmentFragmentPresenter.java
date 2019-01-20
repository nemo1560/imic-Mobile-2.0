package com.example.hhh.imicmo2.Models.JobRecuitmentFragment;

import com.example.hhh.imicmo2.Entities.Careers;
import com.example.hhh.imicmo2.Entities.Jobs;
import com.example.hhh.imicmo2.Entities.LocationWork;
import com.example.hhh.imicmo2.Entities.TypeOfWork;

import java.util.List;

public interface JobRecuitmentFragmentPresenter {
    void GetAPIgetTypeOfWorksList(List<TypeOfWork> typeOfWorkList);
    void GetAPIgetLocations(List<LocationWork> locationWorkList);
    void GetAPIgetCareers(List<Careers> careersList);
    void GetAPIJobs(List<Jobs> jobsList);
}
