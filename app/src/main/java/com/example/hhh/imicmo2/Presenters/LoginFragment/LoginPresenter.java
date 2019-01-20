package com.example.hhh.imicmo2.Presenters.LoginFragment;

import com.example.hhh.imicmo2.Entities.Result;
import com.example.hhh.imicmo2.Models.LoginFragment.LoginFragmentPresenter;
import com.example.hhh.imicmo2.Models.LoginFragment.LoginModel;

public class LoginPresenter implements LoginFragmentPresenter{
    private LoginFragmentView loginFragmentView;
    private LoginModel loginModel;

    public LoginPresenter(LoginFragmentView loginFragmentView) {
        this.loginFragmentView = loginFragmentView;
        loginModel = new LoginModel(LoginPresenter.this);

    }

    public void getInfoUserModel(String user, String password) {
        loginModel.getInfoUser(user, password);
    }

    @Override
    public void GetAPILoginSuccess(Result result, boolean aCheck) {
        loginFragmentView.LoginSuccess(result,aCheck);
    }

    @Override
    public void GetAPILoginFail(String error) {
        loginFragmentView.LoginFail(error);
    }
}
