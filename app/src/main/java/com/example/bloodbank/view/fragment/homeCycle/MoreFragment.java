package com.example.bloodbank.view.fragment.homeCycle;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bloodbank.R;
import com.example.bloodbank.view.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {


    @BindView(R.id.fav)
    TextView fav;
    @BindView(R.id.contact)
    TextView contact;
    @BindView(R.id.about)
    TextView about;
    @BindView(R.id.estimate)
    TextView estimate;
    @BindView(R.id.notifsetting)
    TextView notifsetting;
    @BindView(R.id.logout)
    TextView logout;
    private Fragment fragment;

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.fav, R.id.contact, R.id.about, R.id.estimate, R.id.notifsetting, R.id.logout})
    public void onViewClicked(View view) {
        Fragment fragment = null;
        switch (view.getId()) {

            case R.id.fav:
                fragment = new FavouriteFragment();
                break;
            case R.id.contact:
                fragment = new ContactUsFragment();
                break;
            case R.id.about:
                fragment = new AboutFragment();
                break;
            case R.id.estimate:
                break;
            case R.id.notifsetting:
                fragment = new NotificationSettingFragment();
                break;
            case R.id.logout:
                Intent i = new Intent(getContext(), LoginActivity.class);
                startActivity(i);
                break;
        }
        if (fragment != null)
        {
            getFragmentManager().beginTransaction().replace(R.id.homecyclelayout, fragment).addToBackStack(null).commit();
        }
    }
}
