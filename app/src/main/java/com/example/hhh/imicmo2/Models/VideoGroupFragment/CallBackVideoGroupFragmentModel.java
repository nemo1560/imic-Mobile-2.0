package com.example.hhh.imicmo2.Models.VideoGroupFragment;

import com.example.hhh.imicmo2.Entities.VideoGroupEntity;

import java.util.List;

/*
* lớp CallBack cho Model*/
public interface CallBackVideoGroupFragmentModel {
    void xuLyGetApiListVideoGroupThanhCong(List<VideoGroupEntity> listVideoGroup);

    void xuLyGetApiListVideoGroupThatBai(String sThongBao);
}
