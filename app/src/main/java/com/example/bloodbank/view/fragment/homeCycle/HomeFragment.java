package com.example.bloodbank.view.fragment.homeCycle;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.bloodbank.R;
import com.example.bloodbank.adapter.homepagerAdapter;
import com.example.bloodbank.adapter.pagerAdapter;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.home_view_pager)
    ViewPager homeViewPager;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        homepagerAdapter adapter = new homepagerAdapter(getChildFragmentManager());
        homeViewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(homeViewPager);
         return view;

    }

}
