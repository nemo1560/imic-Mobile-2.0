package com.example.hhh.imicmo2.Presenters.RegisterFragment;

import com.example.hhh.imicmo2.Entities.RegisterSuccess;

public interface RegisterFragmentView {
    void RegisterSuccess(RegisterSuccess registerSuccess);
    void RegisterFail(String error);
}
