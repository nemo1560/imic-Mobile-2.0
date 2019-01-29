package com.example.hhh.imicmo2.Models.VideoGroupFragment;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.hhh.imicmo2.Entities.MetaData;
import com.example.hhh.imicmo2.Entities.VideoGroupEntity;
import com.example.hhh.imicmo2.Services.GetAPIVGroup;
import com.example.hhh.imicmo2.Services.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class VideoGroupModel {
    private CallBackVideoGroupFragmentModel callBackVideoGroupFragmentModel;

    public VideoGroupModel(CallBackVideoGroupFragmentModel callBackVideoGroupFragmentModel) {
        this.callBackVideoGroupFragmentModel = callBackVideoGroupFragmentModel;
    }

    public void xuLyGetApiListVideoGroup() {
        GetAPIVGroup service = RetrofitInstance.getRetrofitInstance().create(GetAPIVGroup.class);
        Call<MetaData<VideoGroupEntity>> call = service.getVideoGroup();
        call.enqueue(new Callback<MetaData<VideoGroupEntity>>() {
            @Override
            public void onResponse(@NonNull Call<MetaData<VideoGroupEntity>> call, retrofit2.Response<MetaData<VideoGroupEntity>> response) {
                List<VideoGroupEntity> listVideoGroup = response.body().getResult();
                    callBackVideoGroupFragmentModel.xuLyGetApiListVideoGroupThanhCong(listVideoGroup);
            }
            @Override
            public void onFailure(@NonNull Call<MetaData<VideoGroupEntity>> call, @NonNull Throwable t) {
                Log.d("APIVGroupError",t.toString());
            }
        });
    }
}
