package com.example.hhh.imicmo2.Models.LoginFragment;

import com.example.hhh.imicmo2.Entities.Account;
import com.example.hhh.imicmo2.Entities.Result;
import com.example.hhh.imicmo2.Services.GetUserAPI;
import com.example.hhh.imicmo2.Services.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel {

    private LoginFragmentPresenter loginFragmentPresenter;
    private GetUserAPI getUserAPI;

    public LoginModel(LoginFragmentPresenter loginFragmentPresenter) {
        this.loginFragmentPresenter = loginFragmentPresenter;
    }

    /*
    * lay API account
    * */
    public void getInfoUser(String user,String password){
        getUserAPI = RetrofitInstance.getRetrofitInstance().create(GetUserAPI.class);
        Call<Account> accountCall = getUserAPI.getUer(user,password);
        accountCall.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                Result result = response.body().getResult();
                if(result != null){
                    loginFragmentPresenter.GetAPILoginSuccess(result, true);
                }
                else {
                    loginFragmentPresenter.GetAPILoginFail("error");
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                String error = t.getMessage();

            }
        });
    }
}
