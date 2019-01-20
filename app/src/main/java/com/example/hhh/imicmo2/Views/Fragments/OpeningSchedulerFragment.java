package com.example.hhh.imicmo2.Views.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hhh.imicmo2.Adapters.OpeningSchedulerAdapter;
import com.example.hhh.imicmo2.Entities.OpeningScheduler;
import com.example.hhh.imicmo2.Presenters.OpeningSchedulerFragment.OpeningSchedulerFragmentView;
import com.example.hhh.imicmo2.Presenters.OpeningSchedulerFragment.OpeningSchedulerPresent;
import com.example.hhh.imicmo2.R;

import java.util.List;

public class OpeningSchedulerFragment extends Fragment implements OpeningSchedulerFragmentView {
    private OpeningSchedulerPresent openingSchedulerPresent;
    private OpeningSchedulerAdapter openingSchedulerAdapter;

    public OpeningSchedulerFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opening_scheduler,container,false);
        openingSchedulerPresent = new OpeningSchedulerPresent(this);
        return view;
    }

    @Override
    public void OpenSchedulerSucess(List<OpeningScheduler> openingScheduler) {

    }

    @Override
    public void OpenSchedulerFail(String error) {

    }
}
