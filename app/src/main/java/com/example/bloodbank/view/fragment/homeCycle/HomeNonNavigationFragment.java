package com.example.bloodbank.view.fragment.homeCycle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bloodbank.R;
import com.example.bloodbank.view.fragment.homeCycle.NewDonationFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeNonNavigationFragment extends Fragment {

    public HomeNonNavigationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home_non_navigation, container, false);
        Fragment fragment = new NewDonationFragment();
        getFragmentManager().beginTransaction().replace(R.id.new_donation_layout, fragment).addToBackStack(null)
                .commit();
        return view;
    }
}
