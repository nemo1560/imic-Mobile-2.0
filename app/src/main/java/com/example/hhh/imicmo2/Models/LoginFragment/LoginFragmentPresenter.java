package com.example.hhh.imicmo2.Models.LoginFragment;

import com.example.hhh.imicmo2.Entities.Result;

public interface LoginFragmentPresenter {
     void GetAPILoginSuccess(Result result, boolean aCheck);
     void GetAPILoginFail(String error);
}
