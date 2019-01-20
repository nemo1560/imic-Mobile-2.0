package com.example.hhh.imicmo2.Presenters.RegisterFragment;

import com.example.hhh.imicmo2.Entities.RegisterSuccess;
import com.example.hhh.imicmo2.Models.RegisterFragment.RegisterFragmentPresenter;
import com.example.hhh.imicmo2.Models.RegisterFragment.RegisterModel;

public class RegisterPresenter implements RegisterFragmentPresenter {
    private RegisterFragmentView registerFragmentView;
    private RegisterModel registerModel;

    public RegisterPresenter(RegisterFragmentView registerFragmentView) {
        this.registerFragmentView = registerFragmentView;
        registerModel = new RegisterModel(RegisterPresenter.this);
    }

    public void Register(String fullname, String email, String mobile, String address, String user, String pass){
        registerModel.RegisterUser(fullname,email,mobile,address,user,pass);
    }

    @Override
    public void GetAPIregisterSuccess(RegisterSuccess registerSuccess) {
      registerFragmentView.RegisterSuccess(registerSuccess);
    }

    @Override
    public void GetAPIregisterFail(String error) {
        registerFragmentView.RegisterFail(error);
    }
}
