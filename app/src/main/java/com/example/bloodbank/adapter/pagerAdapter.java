package com.example.bloodbank.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.bloodbank.view.fragment.splachCycle.SlideFragment1;
import com.example.bloodbank.view.fragment.splachCycle.SlideFragment2;
import com.example.bloodbank.view.fragment.splachCycle.SlideFragment3;

public class pagerAdapter extends FragmentPagerAdapter {

    Fragment fragment [] = {new SlideFragment1(), new SlideFragment2() , new SlideFragment3()};
    public pagerAdapter(FragmentManager fm) {
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
}
