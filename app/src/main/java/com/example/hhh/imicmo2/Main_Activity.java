package com.example.hhh.imicmo2;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.hhh.imicmo2.Adapters.PagesAdapter;
import com.example.hhh.imicmo2.Adapters.getDataUser;
import com.example.hhh.imicmo2.Custom.SwipeDisableViewPager;
import com.example.hhh.imicmo2.Entities.Account;
import com.example.hhh.imicmo2.Entities.Result;
import com.example.hhh.imicmo2.Views.DeveloperActivity.DeveloperActivity;

public class Main_Activity extends AppCompatActivity implements getDataUser {
    private TabLayout tabLayout;
    private SwipeDisableViewPager viewPager;
    private PagesAdapter pagesAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initEvents();

    }

    private void initEvents() {
        viewPager.setOffscreenPageLimit(5);
        viewPager.setAllowedSwipeDirection(SwipeDisableViewPager.SwipeDirection.none);
        pagesAdapter = new PagesAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(pagesAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(2);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                String s1 = getResources().getString(R.string.Videos);
                String s2 = getResources().getString(R.string.Job_Recruitments);
                String s3 = getResources().getString(R.string.Opening_Scheduler);
                String s4 = getResources().getString(R.string.Introduction);
                String s5 = getResources().getString(R.string.Account);
                String[] titles = {s1, s2, s3, s4, s5};
                String titleChanged = titles[viewPager.getCurrentItem()];
                setActionBarTitle(titleChanged);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_video_library_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_business_center_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_home_black_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_help_black_24dp);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_account_box_black_24dp);
    }

    private void initControls() {
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @SuppressLint("ObsoleteSdkInt")
    private void hideNavigationBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        hideNavigationBar();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(Main_Activity.this, DeveloperActivity.class);
                startActivity(intent);
                return true;
            case R.id.help:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setTitle("Version 1.0");
                alertDialog.setMessage("Made by Android-team");
                alertDialog.setNegativeButton("OK", null);
                alertDialog.create().show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //implements interface
    /* _get intent from InfoUserFragment
     * _get userName, userID when user login success and send from activity to InfoUser fragment for change status info layout.
     * _set fragment object for active fragment in adapter class
     * */
    @Override
    public void getDataUser(Fragment fragment) {
        Intent intent = getIntent();
        Result result = (Result) intent.getSerializableExtra("result");
        if (result !=null) {
            Bundle bundle = new Bundle();
            bundle.putString("accountName", result.getFullName());
            bundle.putString("accountProfileId", result.getProfileId());
            fragment.setArguments(bundle);
            viewPager.setCurrentItem(4);
        }
    }
}
