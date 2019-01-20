package com.example.hhh.imicmo2.Views.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hhh.imicmo2.Entities.RegisterSuccess;
import com.example.hhh.imicmo2.Presenters.RegisterFragment.RegisterFragmentView;
import com.example.hhh.imicmo2.Presenters.RegisterFragment.RegisterPresenter;
import com.example.hhh.imicmo2.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RegisterFragment extends Fragment implements View.OnClickListener, RegisterFragmentView {
    @BindView(R.id.user_register)EditText user_register;
    @BindView(R.id.pass_register)EditText pass_register;
    @BindView(R.id.email_register)EditText email_register;
    @BindView(R.id.fullname_register)EditText fullname_register;
    @BindView(R.id.mobile_register)EditText mobile_register;
    @BindView(R.id.register_btn)Button register_btn;
    private RegisterPresenter registerPresenter;

    public RegisterFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register,container,false);
        ButterKnife.bind(this,view);
        registerPresenter = new RegisterPresenter(RegisterFragment.this);
        initEvent();
        return view;
    }

    public void initEvent(){
        register_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == register_btn.getId()){
            String user = user_register.getText().toString();
            String pass = pass_register.getText().toString();
            String email = email_register.getText().toString();
            String fullname = fullname_register.getText().toString();
            String mobile = mobile_register.getText().toString();
            String address = "";

            if(user.isEmpty()){
                user_register.setHint("Vui lòng nhập user");
                user_register.setHintTextColor(Color.RED);
            }
            else {
                if(pass.isEmpty()){
                    pass_register.setHint("Vui lòng nhập password");
                    pass_register.setHintTextColor(Color.RED);
                }
                else {
                    if (email.isEmpty()) {
                        email_register.setHint("Vui lòng nhập email");
                        email_register.setHintTextColor(Color.RED);
                    } else {
                        registerPresenter.Register(fullname,email,mobile,address,user,pass);
                    }
                }
            }
        }
    }

    @Override
    public void RegisterSuccess(RegisterSuccess registerSuccess) {
        Toast.makeText(getActivity(),registerSuccess.isRegister(),Toast.LENGTH_SHORT).show();
        getActivity().finish();
    }

    @Override
    public void RegisterFail(String error) {
        Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
    }
}



