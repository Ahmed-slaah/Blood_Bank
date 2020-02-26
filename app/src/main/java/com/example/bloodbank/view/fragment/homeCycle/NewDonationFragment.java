package com.example.bloodbank.view.fragment.homeCycle;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bloodbank.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewDonationFragment extends Fragment {


    @BindView(R.id.newdobation_name2)
    EditText newdobationName2;
    @BindView(R.id.newdobation_age2)
    EditText newdobationAge2;
    @BindView(R.id.bloodtypr_spinner)
    Spinner bloodtyprSpinner;
    @BindView(R.id.relative1)
    RelativeLayout relative1;
    @BindView(R.id.textView7)
    TextView textView7;
    @BindView(R.id.newdobation_needs2)
    EditText newdobationNeeds2;
    @BindView(R.id.map)
    ImageView map;
    @BindView(R.id.government_spinner)
    Spinner governmentSpinner;
    @BindView(R.id.relative2)
    RelativeLayout relative2;
    @BindView(R.id.city_spinner)
    Spinner citySpinner;
    @BindView(R.id.relative3)
    RelativeLayout relative3;
    @BindView(R.id.editText6)
    EditText editText6;
    @BindView(R.id.editText7)
    EditText editText7;
    @BindView(R.id.button)
    Button button;

    public NewDonationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_donation, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
