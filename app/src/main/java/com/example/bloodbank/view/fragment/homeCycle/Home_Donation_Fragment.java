package com.example.bloodbank.view.fragment.homeCycle;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bloodbank.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Donation_Fragment extends Fragment {


    public Home_Donation_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home__donation_, container, false);

        return view;
    }

}
