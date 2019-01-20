package com.example.hhh.imicmo2.Views.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hhh.imicmo2.Adapters.JobsAdapter;
import com.example.hhh.imicmo2.Entities.Careers;
import com.example.hhh.imicmo2.Entities.Jobs;
import com.example.hhh.imicmo2.Entities.LocationWork;
import com.example.hhh.imicmo2.Entities.TypeOfWork;
import com.example.hhh.imicmo2.Presenters.JobRecuitmentFragment.JobRecuitmentFragmentView;
import com.example.hhh.imicmo2.Presenters.JobRecuitmentFragment.JobRecuitmentPrsesenter;
import com.example.hhh.imicmo2.Presenters.JobRecuitmentFragment.SendData;
import com.example.hhh.imicmo2.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JobRecruitmentsFragment extends Fragment implements JobRecuitmentFragmentView, AdapterView.OnItemSelectedListener,SendData {
    private List<String> getTypeOfWorksList,
            getLocations,
            getCareers;
    private List<String> getTypeOfWorksListID,
            getLocationsID,
            getCareersID;
    private String locationId = "",
            careerId = "",
            typeOfWorkId = "";
    private JobsAdapter jobsAdapter;
    private JobRecuitmentPrsesenter jobRecuitmentPrsesenter;
    private Handler handler;
    @BindView(R.id.cong_viec_list)ListView listView;
    @BindView(R.id.noi_lam_viec_spinner)Spinner getNoi_lam_viec_spinner;
    @BindView(R.id.nganh_nghe_spinner)Spinner getNganh_nghe_spinner;
    @BindView(R.id.loai_cv_spinner)Spinner getLoai_cv_spinner;
    @BindView(R.id.loading)ProgressBar loading;

    public JobRecruitmentsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job_recruitment,container,false);
        ButterKnife.bind(this,view);
        getNoi_lam_viec_spinner.setOnItemSelectedListener(this);
        getNganh_nghe_spinner.setOnItemSelectedListener(this);
        getLoai_cv_spinner.setOnItemSelectedListener(this);
        handler = new Handler();
        getTypeOfWorksList = new ArrayList<>();
        getLocations = new ArrayList<>();
        getCareers = new ArrayList<>();
        getTypeOfWorksListID = new ArrayList<>();
        getLocationsID = new ArrayList<>();
        getCareersID = new ArrayList<>();
        listView.setVisibility(View.INVISIBLE);
        getAPI();
        return view;
    }

    public void getAPI(){
        jobRecuitmentPrsesenter = new JobRecuitmentPrsesenter(JobRecruitmentsFragment.this,loading);
        jobRecuitmentPrsesenter.GetAPIgetTypeOfWorks();
        jobRecuitmentPrsesenter.GetAPIgetCareers();
        jobRecuitmentPrsesenter.GetAPIgetLocations();
    }

    @Override
    public void GetTypeOfWorksList(final List<TypeOfWork> typeOfWorkList) {
        getTypeOfWorksList.add("Tất cả");
        getTypeOfWorksListID.add("");
        for(int i=0;i<typeOfWorkList.size();i++){
            getTypeOfWorksList.add(typeOfWorkList.get(i).getTypeOfWorkName());
            getTypeOfWorksListID.add(typeOfWorkList.get(i).getTypeOfWorkId());
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayAdapter<String>arrayAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,getTypeOfWorksList);
                getLoai_cv_spinner.setAdapter(arrayAdapter);
            }
        }, 500);
    }

    @Override
    public void GetLocations(List<LocationWork> locationWorkList) {
        getLocations.add("Tất cả");
        getLocationsID.add("");
        for(int i=0;i<locationWorkList.size();i++){
            getLocations.add(locationWorkList.get(i).getLocationName());
            getLocationsID.add(locationWorkList.get(i).getLocationId());
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayAdapter<String>arrayAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,getLocations);
                getNoi_lam_viec_spinner.setAdapter(arrayAdapter);
            }
        }, 500);
    }

    @Override
    public void GetCareers(List<Careers> careersList) {
        getCareers.add("Tất cả");
        getCareersID.add("");
        for(int i=0;i<careersList.size();i++){
            getCareers.add(careersList.get(i).getCareerName());
            getCareersID.add(careersList.get(i).getCareerId());
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayAdapter<String>arrayAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,getCareers);
                getNganh_nghe_spinner.setAdapter(arrayAdapter);
            }
        }, 500);
    }

    @Override
    public void GetJobs(final List<Jobs> jobsList) {
        Handler handler = new Handler();
        //set time sau 1s de chay animation
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.setVisibility(View.GONE);
                jobsAdapter = new JobsAdapter(getActivity(),R.layout.layout_jobs_row,jobsList,JobRecruitmentsFragment.this);
                listView.setAdapter(jobsAdapter);
                listView.setVisibility(View.VISIBLE);
                listView.deferNotifyDataSetChanged();
            }
        },1000);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == getNoi_lam_viec_spinner.getId()){
            locationId = getLocationsID.get(position);
            listView.setVisibility(View.INVISIBLE);
            jobRecuitmentPrsesenter.GetAPIJobs(locationId,careerId,typeOfWorkId,loading);

        }
        else if (parent.getId() == getNganh_nghe_spinner.getId()){
            careerId = getCareersID.get(position);
            listView.setVisibility(View.INVISIBLE);
            jobRecuitmentPrsesenter.GetAPIJobs(locationId,careerId,typeOfWorkId,loading);
        }
        else if(parent.getId() == getLoai_cv_spinner.getId()){
            typeOfWorkId = getTypeOfWorksListID.get(position);
            listView.setVisibility(View.INVISIBLE);
            jobRecuitmentPrsesenter.GetAPIJobs(locationId,careerId,typeOfWorkId,loading);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    //Gui position qua interface.
    @Override
    public void SendPosition(int position) {
        Toast.makeText(getActivity(),String.valueOf(position),Toast.LENGTH_SHORT).show();
    }
}
