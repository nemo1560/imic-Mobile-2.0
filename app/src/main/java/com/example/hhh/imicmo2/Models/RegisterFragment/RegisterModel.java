package com.example.hhh.imicmo2.Models.RegisterFragment;

import com.example.hhh.imicmo2.Entities.RegisterSuccess;
import com.example.hhh.imicmo2.Services.RegisterUserAPI;
import com.example.hhh.imicmo2.Services.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterModel {
    private RegisterFragmentPresenter registerFragmentPresenter;
    private RegisterUserAPI registerUserAPI;
    private RegisterSuccess registerSuccess;

    public RegisterModel(RegisterFragmentPresenter registerFragmentPresenter) {
        this.registerFragmentPresenter = registerFragmentPresenter;
        registerSuccess = new RegisterSuccess();
    }

    public void RegisterUser(String fullname, String email,String mobile, String address, String user, String pass){
        registerUserAPI = RetrofitInstance.getRetrofitInstance().create(RegisterUserAPI.class);
        final Call<String> stringCall = registerUserAPI.registerUser(fullname,email,mobile,address,user,pass);
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String result = "true";
                registerSuccess.setRegister(result);
                registerFragmentPresenter.GetAPIregisterSuccess(registerSuccess);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                registerFragmentPresenter.GetAPIregisterFail(t.toString());
            }
        });
    }
}
