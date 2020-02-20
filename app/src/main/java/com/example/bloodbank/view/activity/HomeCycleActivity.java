package com.example.bloodbank.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.bloodbank.R;
import com.example.bloodbank.adapter.homepagerAdapter;
import com.example.bloodbank.view.fragment.homeCycle.EdiFragment;
import com.example.bloodbank.view.fragment.homeCycle.HomeFragment;
import com.example.bloodbank.view.fragment.homeCycle.Home_Donation_Fragment;
import com.example.bloodbank.view.fragment.homeCycle.Home_artical_Fragment;
import com.example.bloodbank.view.fragment.homeCycle.MoreFragment;
import com.example.bloodbank.view.fragment.homeCycle.NotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeCycleActivity extends AppCompatActivity {


    @BindView(R.id.btn_nav)
    BottomNavigationView btnNav;
    @BindView(R.id.homecyclelayout)
    FrameLayout homecyclelayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cycle);
        ButterKnife.bind(this);
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.homecyclelayout, homeFragment);
        transaction.commit();


        btnNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();


                if (id == R.id.home) {
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.homecyclelayout, homeFragment);
                    transaction.commit();

                }
                if (id == R.id.edit) {
                    EdiFragment editfragment = new EdiFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.homecyclelayout, editfragment);
                    transaction.commit();
                }
                if (id == R.id.notification) {
                    NotificationFragment notificationFragment = new NotificationFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.homecyclelayout, notificationFragment);
                    transaction.commit();
                }
                if (id == R.id.more) {
                    MoreFragment moreFragment = new MoreFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.homecyclelayout, moreFragment);
                    transaction.commit();

                }
                return true;
            }
        });

//

    }

}
