package com.example.hhh.imicmo2.Models.OpeningSchedulerFragment;

import com.example.hhh.imicmo2.Entities.OpeningScheduler;

import java.util.List;

public interface OpenSchedulerFragmentPresenter {
    void getAPIOpenSchedulerSuccess(List<OpeningScheduler> openingScheduler);
    void getAPIOpenSchedulerFail(String error);
}
