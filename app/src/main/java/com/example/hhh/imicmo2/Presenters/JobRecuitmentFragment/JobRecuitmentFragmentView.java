package com.example.hhh.imicmo2.Presenters.JobRecuitmentFragment;

import com.example.hhh.imicmo2.Entities.Careers;
import com.example.hhh.imicmo2.Entities.Jobs;
import com.example.hhh.imicmo2.Entities.LocationWork;
import com.example.hhh.imicmo2.Entities.TypeOfWork;

import java.util.List;

public interface JobRecuitmentFragmentView {
    void GetTypeOfWorksList(List<TypeOfWork> typeOfWorkList);
    void GetLocations(List<LocationWork> locationWorkList);
    void GetCareers(List<Careers> careersList);
    void GetJobs(List<Jobs> jobsList);
}
