package com.example.bloodbank.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.bloodbank.view.fragment.homeCycle.HomeFragment;
import com.example.bloodbank.view.fragment.homeCycle.Home_Donation_Fragment;
import com.example.bloodbank.view.fragment.homeCycle.Home_artical_Fragment;
import com.example.bloodbank.view.fragment.splachCycle.SlideFragment1;
import com.example.bloodbank.view.fragment.splachCycle.SlideFragment2;
import com.example.bloodbank.view.fragment.splachCycle.SlideFragment3;

public class homepagerAdapter extends FragmentPagerAdapter {
    Fragment fragment [] = {new Home_artical_Fragment() , new Home_Donation_Fragment()};

    public homepagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragment[position];
    }

    @Override
    public int getCount() {
        return fragment.length;
    }

    @Nullable
    @Override

    public CharSequence getPageTitle(int position) {
        String title [] = {"المقالات","طلبات التبرع"};
        return title[position];
    }
}
