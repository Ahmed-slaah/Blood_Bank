package com.example.bloodbank.view.fragment.loginCycle;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bloodbank.R;
import com.example.bloodbank.adapter.spinnerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.bloodbank.data.api.RetrofitClient.getClient;
import static com.example.bloodbank.helper.GeneralRequestData.AUTH;
import static com.example.bloodbank.helper.GeneralRequestData.onAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    @BindView(R.id.imageView7)
    ImageView imageView7;
    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_forgetpassword)
    TextView loginForgetpassword;
    @BindView(R.id.checkBox)
    CheckBox checkBox;
    @BindView(R.id.login_register)
    Button loginRegister;
    @BindView(R.id.login_login)
    Button loginLogin;
    @BindView(R.id.login_fragment_layout)
    RelativeLayout loginFragmentLayout;
    @BindView(R.id.login_fragment_layout1)
    FrameLayout loginFragmentLayout1;

    private String name;
    private String phone;
    private String Email;
    private String EmailConf;
    private String pass;
    private String Passconf;
    private String birthdate;
    private String city;
    private String donationdate;
    private String bloodtype;
    private spinnerAdapter bloodtypespinner, gavernmenttypespinner, cityspinner;
    private String governmentid;
    private boolean saved;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loginn_, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.login_forgetpassword, R.id.login_register, R.id.login_login})
    public void onViewClicked(View view) {
        Fragment fragment = null;
        switch (view.getId()) {

            case R.id.login_forgetpassword:
                fragment = new ConfirmPhoneFragment();
                break;

            case R.id.login_register:
                fragment = new RegisterFragment();
                break;

            case R.id.login_login:
                if (loginValidation()) {
                    getLogin();
                }

                break;
        }
        if (fragment != null) {
            getFragmentManager().beginTransaction().replace(R.id.login_layout, fragment).addToBackStack(null).commit();
        }
    }

    private boolean loginValidation() {
        phone = loginPhone.getText().toString();
        pass = loginPassword.getText().toString();
        if (!loginPhone.getText().toString().isEmpty()) {
            if (!loginPassword.getText().toString().isEmpty()) {
                return true;
            } else {
                Toast.makeText(getContext(), "تأكد من ملئ خانة كلمة المرور", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(getContext(), "تأكد من ملئ خانة رقم الجوال", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    private void getLogin() {
        onAuth((AppCompatActivity) getActivity(), getClient().getlogin(phone, pass), checkBox.isChecked(), AUTH);
    }

}


