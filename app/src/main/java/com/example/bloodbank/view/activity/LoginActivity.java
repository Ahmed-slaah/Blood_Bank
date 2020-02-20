package com.example.bloodbank.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.bloodbank.R;
import com.example.bloodbank.view.fragment.loginCycle.Loginn_Fragment;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Loginn_Fragment loginnFragment = new Loginn_Fragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.login_layout,loginnFragment);
        transaction.commit();
    }

}
