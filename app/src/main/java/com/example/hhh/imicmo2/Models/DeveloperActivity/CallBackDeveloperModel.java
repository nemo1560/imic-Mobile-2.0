package com.example.hhh.imicmo2.Models.DeveloperActivity;

import com.example.hhh.imicmo2.Entities.DeveloperEntity;

import java.util.List;
/*
 * lớp CallBack cho Model*/
public interface CallBackDeveloperModel {
    void getApiListDeviloperSuccess(List<DeveloperEntity> listDeveloper);
    void getApiListDeviloperFailure(String message);
}
