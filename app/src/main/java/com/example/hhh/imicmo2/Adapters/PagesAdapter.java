package com.example.hhh.imicmo2.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.hhh.imicmo2.Views.Fragments.InfoUserFragment;
import com.example.hhh.imicmo2.Views.Fragments.JobRecruitmentsFragment;
import com.example.hhh.imicmo2.Views.Fragments.OpeningSchedulerFragment;
import com.example.hhh.imicmo2.Views.Fragments.VideoGroupFragment;
import com.example.hhh.imicmo2.Views.Fragments.IntroducesFragment;


import java.util.ArrayList;
import java.util.List;

public class PagesAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentManagers;
    private getDataUser getDataUser;

    public PagesAdapter(FragmentManager fm, getDataUser getDataUser) {
        super(fm);
        this.getDataUser = getDataUser;
        fragmentManagers = new ArrayList<>();
        fragmentManagers.add(new VideoGroupFragment());
        fragmentManagers.add(new JobRecruitmentsFragment());
        fragmentManagers.add(new OpeningSchedulerFragment());
        fragmentManagers.add(new IntroducesFragment());

        // active fragement object in interface class
        InfoUserFragment infoUserFragment = new InfoUserFragment();
        fragmentManagers.add(infoUserFragment);
        getDataUser.getDataUser(infoUserFragment);
    }

    @Override
    public int getCount() {
        return fragmentManagers.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentManagers.get(position);
    }

}
