package com.example.bloodbank.view.fragment.homeCycle;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bloodbank.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationSettingFragment extends Fragment {


    public NotificationSettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification_setting, container, false);
    }

}
