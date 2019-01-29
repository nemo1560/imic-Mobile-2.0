package com.example.hhh.imicmo2.Presenters.VideoGroupFragment;

import com.example.hhh.imicmo2.Entities.VideoGroupEntity;
import com.example.hhh.imicmo2.Models.VideoGroupFragment.CallBackVideoGroupFragmentModel;
import com.example.hhh.imicmo2.Models.VideoGroupFragment.VideoGroupModel;

import java.util.List;

public class VideoGroupPresenter implements CallBackVideoGroupFragmentModel {
    private VideoGroupModel videoGroupFragmentModel;
    private VideoGroupFragmentView videoGroupFragmentView;

    public VideoGroupPresenter(VideoGroupFragmentView videoGroupFragmentView) {
        this.videoGroupFragmentView = videoGroupFragmentView;
        videoGroupFragmentModel = new VideoGroupModel(this);
        videoGroupFragmentModel.xuLyGetApiListVideoGroup();
    }

    @Override
    public void xuLyGetApiListVideoGroupThanhCong(List<VideoGroupEntity> listVideoGroup) {
        videoGroupFragmentView.GroupVideoSuccess(listVideoGroup);
    }

    @Override
    public void xuLyGetApiListVideoGroupThatBai(String sThongBao) {
        videoGroupFragmentView.GroupVideoFail(sThongBao);
    }
}
