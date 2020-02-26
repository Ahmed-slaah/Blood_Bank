package com.example.bloodbank.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.bloodbank.R;
import com.example.bloodbank.view.fragment.loginCycle.LoginFragment;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        LoginFragment loginnFragment = new LoginFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.login_layout,loginnFragment);
        transaction.commit();
    }

}
