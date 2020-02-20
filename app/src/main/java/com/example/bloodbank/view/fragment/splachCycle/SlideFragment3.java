package com.example.bloodbank.view.fragment.splachCycle;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.bloodbank.R;
import com.example.bloodbank.view.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SlideFragment3 extends Fragment {


    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.slide3)
    LinearLayout slide3;

    public SlideFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_slide_fragment3, container, false);
        ButterKnife.bind(this, view);
        return view;

    }


    @OnClick(R.id.imageView2)
    public void onViewClicked() {
        Intent i = new Intent(getContext(), LoginActivity.class);
        startActivity(i);
    }
}
