package com.example.hhh.imicmo2.Views.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hhh.imicmo2.Entities.Result;
import com.example.hhh.imicmo2.Entities.StatusUser;
import com.example.hhh.imicmo2.Main_Activity;
import com.example.hhh.imicmo2.Presenters.LoginFragment.LoginFragmentView;
import com.example.hhh.imicmo2.R;
import com.example.hhh.imicmo2.Views.Activities.SigninActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * code by Hao
 * */
public class InfoUserFragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    private FrameLayout log_in_frameLayout;
    private FrameLayout logged_in_frameLayout;
    @BindView(R.id.log_in) Button log_in;
    @BindView(R.id.log_out) Button log_out;
    @BindView(R.id.user_logged_in) TextView user_logged_in;
    private static boolean aCheck;
    private Result result;

    public InfoUserFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_info_user,container,false);
        ButterKnife.bind(this,view);
        log_in_frameLayout = view.findViewById(R.id.log_in_framelayout);
        logged_in_frameLayout = view.findViewById(R.id.logged_in_framelayout);
        initLayout();
        return view;
    }

    public void initLayout(){
        if(aCheck == false){
            log_in_frameLayout.setVisibility(View.VISIBLE);
            logged_in_frameLayout.setVisibility(View.INVISIBLE);
            log_in.setOnClickListener(this);
        }
        else {
            if(getArguments()!= null){ // get bundle from activity for set userName
                String name = getArguments().getString("accountName");
                Toast.makeText(getActivity(),name,Toast.LENGTH_SHORT).show();
                user_logged_in.setText(name);
                log_in_frameLayout.setVisibility(View.INVISIBLE);
                logged_in_frameLayout.setVisibility(View.VISIBLE);
                log_out.setOnClickListener(this);
            }
        }
    }

    //Class get intent feedback
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == 100){
            aCheck = data.getBooleanExtra("aCheck",false);
            Intent intent = new Intent(getActivity(),Main_Activity.class); // put intent to main_Activity
            intent.putExtra("result",data.getSerializableExtra("result"));
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == log_in.getId()) {
            Intent intent = new Intent(getActivity(),SigninActivity.class);
            startActivityForResult(intent,100); //intent waiting to feedback
        }
        if (v.getId() == log_out.getId()) {
            aCheck = false;
            Intent intent = new Intent(getActivity(), Main_Activity.class);
            startActivity(intent);
        }
    }

}
