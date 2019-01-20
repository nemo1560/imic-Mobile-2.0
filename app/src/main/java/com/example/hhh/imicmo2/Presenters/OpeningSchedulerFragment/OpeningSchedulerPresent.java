package com.example.hhh.imicmo2.Presenters.OpeningSchedulerFragment;

import com.example.hhh.imicmo2.Entities.OpeningScheduler;
import com.example.hhh.imicmo2.Models.OpeningSchedulerFragment.OpenSchedulerFragmentPresenter;
import com.example.hhh.imicmo2.Models.OpeningSchedulerFragment.OpenSchedulerModel;

import java.util.List;

public class OpeningSchedulerPresent implements OpenSchedulerFragmentPresenter {
    private OpeningSchedulerFragmentView openingSchedulerFragmentView;
    private OpenSchedulerModel openSchedulerModel;

    public OpeningSchedulerPresent(OpeningSchedulerFragmentView openingSchedulerFragmentView) {
        this.openingSchedulerFragmentView = openingSchedulerFragmentView;
        openSchedulerModel = new OpenSchedulerModel(this);
        openSchedulerModel.getOpenScheduler();
    }

    @Override
    public void getAPIOpenSchedulerSuccess(List<OpeningScheduler> openingScheduler) {
        openingSchedulerFragmentView.OpenSchedulerSucess(openingScheduler);
    }

    @Override
    public void getAPIOpenSchedulerFail(String error) {
        openingSchedulerFragmentView.OpenSchedulerFail(error);
    }

}
