package com.example.hhh.imicmo2.Presenters.LoginFragment;

import com.example.hhh.imicmo2.Entities.Result;

public interface LoginFragmentView {
     void LoginSuccess(Result result, boolean aCheck);
     void LoginFail(String error);
}
