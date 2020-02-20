package com.example.bloodbank.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;

import com.example.bloodbank.R;
import com.example.bloodbank.adapter.pagerAdapter;

public class SplachActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
        ViewPager pager = findViewById(R.id.pager);
        pagerAdapter adapter = new pagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

    }

}

