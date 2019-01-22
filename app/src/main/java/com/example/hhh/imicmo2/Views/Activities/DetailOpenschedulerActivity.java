package com.example.hhh.imicmo2.Views.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hhh.imicmo2.Entities.OpeningScheduler;
import com.example.hhh.imicmo2.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailOpenschedulerActivity extends AppCompatActivity {
    @BindView(R.id.Detail_ImageLink) ImageView Detail_ImageLink;
    @BindView(R.id.Detail_Title) TextView Detail_Title;
    @BindView(R.id.Detail_OpenningDate) TextView Detail_OpenningDate;
    @BindView(R.id.Detail_OpenDescription) TextView Detail_OpenDescription;
    private Intent intent;
    private OpeningScheduler openingScheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_openscheduler);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        intent = getIntent();
        if(intent != null){
            openingScheduler = (OpeningScheduler) intent.getSerializableExtra("OpeningScheduler");
            getData(openingScheduler);
        }
    }

    private void getData(OpeningScheduler openingScheduler) {
        Picasso.get().load(openingScheduler.getImageLink()).into(Detail_ImageLink);
        Detail_Title.setText(openingScheduler.getTitle());
        Detail_OpenningDate.setText(openingScheduler.getOpenningDate());
        Detail_OpenDescription.setText(openingScheduler.getOpenDescription());
    }
}
