package com.example.hhh.imicmo2.Presenters.VideoGroupFragment;

import com.example.hhh.imicmo2.Entities.VideoGroupEntity;

import java.util.List;

public interface VideoGroupFragmentView {
    void GroupVideoSuccess(List<VideoGroupEntity> videoGroupEntities);
    void GroupVideoFail(String error);
}
