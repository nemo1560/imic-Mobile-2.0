package com.example.hhh.imicmo2.Presenters.OpeningSchedulerFragment;

import com.example.hhh.imicmo2.Entities.OpeningScheduler;

import java.util.List;

public interface OpeningSchedulerFragmentView {
    void OpenSchedulerSucess(List<OpeningScheduler> openingScheduler);
    void OpenSchedulerFail(String error);
}
