package com.example.bloodbank.view.fragment.loginCycle;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.bloodbank.R;
import com.example.bloodbank.helper.SharedPreferencesManger;
import com.example.bloodbank.adapter.spinnerAdapter;
import com.example.bloodbank.data.model.register.Auth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.bloodbank.helper.SpinnerRequest.getspinnerData;
import static com.example.bloodbank.data.api.RetrofitClient.getClient;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    @BindView(R.id.register_text)
    TextView registerText;
    @BindView(R.id.register_name)
    TextView registerName;
    @BindView(R.id.register_mail)
    TextView registerMail;
    @BindView(R.id.register_birthday)
    TextView registerBirthday;
    @BindView(R.id.register_spinner_blood)
    Spinner registerSpinnerBlood;
    @BindView(R.id.register_lastdate)
    TextView registerLastdate;
    @BindView(R.id.register_spinner_government)
    Spinner registerSpinnerGovernment;
    @BindView(R.id.register_spinner_city)
    Spinner registerSpinnerCity;
    @BindView(R.id.register_phone)
    TextView registerPhone;
    @BindView(R.id.register_password)
    TextView registerPassword;
    @BindView(R.id.register_password_confirm)
    TextView registerPasswordConfirm;
    @BindView(R.id.register_confirmMail)
    EditText registerConfirmMail;
    @BindView(R.id.register_register)
    Button registerRegister;
    @BindView(R.id.register_layout)
    FrameLayout registerLayout;
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




    public RegisterFragment() {
        // Required empty public constructor
    }

    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this, view);
        setSpinner();
        name = registerName.getText().toString();
        phone = registerPhone.getText().toString();
        Email = registerMail.getText().toString();
        EmailConf = registerMail.getText().toString();
        pass = registerPassword.getText().toString();
        Passconf = registerConfirmMail.getText().toString();
        birthdate = registerBirthday.getText().toString();
        donationdate = registerLastdate.getText().toString();

        return view;
    }

    private void setSpinner() {
        bloodtypespinner = new spinnerAdapter(getActivity());
        gavernmenttypespinner = new spinnerAdapter(getActivity());
        cityspinner = new spinnerAdapter(getActivity());

        getspinnerData(getClient().getBloodType(), registerSpinnerBlood, bloodtypespinner,
                0, getString(R.string.get_blood_type));

        AdapterView.OnItemSelectedListener onGavernmentItemSelected = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {

                    getspinnerData(getClient().getCity(governmentid), registerSpinnerCity, cityspinner,
                            0, getString(R.string.get_cityt));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        getspinnerData(getClient().getGovernment(), registerSpinnerGovernment, gavernmenttypespinner,
                0, getString(R.string.get_government), onGavernmentItemSelected);


    }


    @OnClick(R.id.register_register)
    public void onViewClicked() {
        if (Validation()) {
            getregister();
        }
        }



    private boolean Validation() {

        if (pass.equals(Passconf)) {
            if ((Email.equals(EmailConf))) {
                if ((!name.isEmpty() && !phone.isEmpty() && !pass.isEmpty() && !Email.isEmpty())) {
                    return true;
                } else {
                    Toast.makeText(getContext(), "تاكد من ملئ كل الخانات", Toast.LENGTH_SHORT).show();
                    return false;
                }
            } else {
                Toast.makeText(getContext(), "تاكد من ان خانة البريد الالكترونى تساوى لخانة التاكيد لها", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(getContext(), "تاكد من ان خانة كلمة المرور تساوى خانة التاكيد لها", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void getregister() {

        getClient().getRegister(name, Email, birthdate, city, phone, donationdate, pass, Passconf, bloodtype).enqueue(new Callback<Auth>() {
            @Override

            public void onResponse(Call<Auth> call, Response<Auth> response) {
                try {
                    if (response.body().getStatus() == 1) {

                        SharedPreferencesManger.SaveData(getActivity(),SharedPreferencesManger.USER_DATA , response.body().getData());
                        SharedPreferencesManger.SaveData(getActivity(),SharedPreferencesManger.REMMBER_ME , true);

                        Fragment fragment = new Loginn_Fragment();
                        getFragmentManager().beginTransaction().replace(R.id.register_layout, fragment).addToBackStack(null).commit();
                    }else {
                        Toast.makeText(getContext(), ""+response.body().getMsg()+"", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getContext(), ""+e+"", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Auth> call, Throwable t) {
                Toast.makeText(getContext(), ""+t+"", Toast.LENGTH_SHORT).show();


            }
        });

    }

}











