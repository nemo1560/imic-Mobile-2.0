package com.example.hhh.imicmo2.Views.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.hhh.imicmo2.Adapters.VideoGroupAdapter;
import com.example.hhh.imicmo2.Entities.VideoGroupEntity;
import com.example.hhh.imicmo2.Models.OpeningSchedulerFragment.OpenSchedulerFragmentPresenter;
import com.example.hhh.imicmo2.Presenters.OpeningSchedulerFragment.OpeningSchedulerPresent;
import com.example.hhh.imicmo2.Presenters.VideoGroupFragment.VideoGroupFragmentView;
import com.example.hhh.imicmo2.Presenters.VideoGroupFragment.VideoGroupPresenter;
import com.example.hhh.imicmo2.R;

import java.util.List;

public class VideoGroupFragment extends Fragment implements VideoGroupFragmentView {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private VideoGroupAdapter videoGroupAdapter;
    private VideoGroupPresenter videoGroupPresenter;

    /*
    * Tái sữ dung lại layout cũ.
    * */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_group,container,false);
        recyclerView = view.findViewById(R.id.recyclerview);
        progressBar = view.findViewById(R.id.load);
        progressBar.setVisibility(View.VISIBLE);
        videoGroupPresenter = new VideoGroupPresenter(this);
        return view;
    }

    @Override
    public void GroupVideoSuccess(List<VideoGroupEntity> videoGroupEntities) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        videoGroupAdapter = new VideoGroupAdapter(getContext(),videoGroupEntities);
        recyclerView.setLayoutManager(linearLayoutManager);
        progressBar.setVisibility(View.GONE);
        recyclerView.setAdapter(videoGroupAdapter);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void GroupVideoFail(String error) {
        Log.d("GroupVideoAdapter",error);
    }
}
