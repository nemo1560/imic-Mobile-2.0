package com.example.hhh.imicmo2.Models.RegisterFragment;

import com.example.hhh.imicmo2.Entities.RegisterSuccess;

public interface RegisterFragmentPresenter {
    void GetAPIregisterSuccess(RegisterSuccess registerSuccess);
    void GetAPIregisterFail(String error);
}
