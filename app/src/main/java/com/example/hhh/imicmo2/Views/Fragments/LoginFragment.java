package com.example.hhh.imicmo2.Views.Fragments;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hhh.imicmo2.Entities.Result;
import com.example.hhh.imicmo2.Main_Activity;
import com.example.hhh.imicmo2.Presenters.LoginFragment.LoginFragmentView;
import com.example.hhh.imicmo2.Presenters.LoginFragment.LoginPresenter;
import com.example.hhh.imicmo2.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginFragment extends Fragment implements View.OnClickListener, LoginFragmentView{
    @BindView(R.id.user_Txt)EditText user_Txt;
    @BindView(R.id.pass_Txt)EditText pass_Txt;
    @BindView(R.id.dang_ky_Btn)Button dang_ky_Btn;
    @BindView(R.id.dang_nhap_Btn)Button dang_nhap_Btn;
    String user = "";
    String pass = "";
    LoginPresenter loginPresenter;

    public LoginFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);
        ButterKnife.bind(this,view);
        loginPresenter = new LoginPresenter(LoginFragment.this);
        initEvent();
        return view;
    }

    public void initEvent(){
        dang_ky_Btn.setOnClickListener(this);
        dang_nhap_Btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == dang_ky_Btn.getId()){
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_layout,new RegisterFragment());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        if(v.getId() == dang_nhap_Btn.getId()){
            user = user_Txt.getText().toString();
            if(user.isEmpty()){
                Toast.makeText(getActivity(),"Vui lòng nhập vào username",Toast.LENGTH_SHORT).show();
            }
            else {
                pass = pass_Txt.getText().toString();
                if(pass.isEmpty()){
                    user_Txt.setText("");
                    Toast.makeText(getActivity(),"Vui lòng nhập vào password",Toast.LENGTH_SHORT).show();
                }
                else {
                    loginPresenter.getInfoUserModel(user,pass);
                    }
                }
            }
        }

    @Override
    public void LoginSuccess(Result result, boolean aCheck) {
        Intent intent = new Intent();
        intent.putExtra("aCheck",aCheck);
        intent.putExtra("result",result);
        getActivity().setResult(100,intent); //create intent feedback
        getActivity().finish();
    }

    @Override
    public void LoginFail(String error) {
        Toast.makeText(getActivity(),"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
        user_Txt.setText("");
        pass_Txt.setText("");
    }

}
