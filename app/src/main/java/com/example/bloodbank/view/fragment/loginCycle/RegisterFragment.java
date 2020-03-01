package com.example.bloodbank.view.fragment.loginCycle;


import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bloodbank.R;
import com.example.bloodbank.adapter.spinnerAdapter;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.graphics.Color.TRANSPARENT;
import static com.example.bloodbank.data.api.RetrofitClient.getClient;
import static com.example.bloodbank.helper.GeneralRequestData.AUTH;
import static com.example.bloodbank.helper.GeneralRequestData.getspinnerData;
import static com.example.bloodbank.helper.GeneralRequestData.onAuth;

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
    @BindView(R.id.register_register)
    Button registerRegister;
    @BindView(R.id.register_layout)
    FrameLayout registerLayout;
    @BindView(R.id.blood)
    ImageView blood;
    @BindView(R.id.relative_spinner_blood)
    RelativeLayout relativeSpinnerBlood;
    @BindView(R.id.home)
    ImageView home;
    @BindView(R.id.relative_spinner_government)
    RelativeLayout relativeSpinnerGovernment;
    @BindView(R.id.home1)
    ImageView home1;
    @BindView(R.id.relative_spinner_city)
    RelativeLayout relativeSpinnerCity;
    private String name;
    private String phone;
    private String Email;
    private String pass;
    private String Passconf;
    private String birthdate;
    private String city;
    private String donationdate;
    private String bloodtype;
    private spinnerAdapter bloodtypespinner, gavernmenttypespinner, cityspinner;
    private String governmentid;
    public TextView displayData = null;
    public static String TAG = null;
    public DatePickerDialog.OnDateSetListener dateSetListener;
    public RegisterFragment() {
        // Required empty public constructor
    }

    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this, view);
        setSpinner();


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


    private boolean Validation() {

        name = registerName.getText().toString();
        phone = registerPhone.getText().toString();
        Email = registerMail.getText().toString();
        pass = registerPassword.getText().toString();
        Passconf = registerPasswordConfirm.getText().toString();
        birthdate = registerBirthday.getText().toString();
        donationdate = registerLastdate.getText().toString();

        boolean valid = true;

        if (name.isEmpty()) {
            Toast.makeText(getContext(), "تاكد من ملئ خانة الاسم", Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (Email.isEmpty()) {
            Toast.makeText(getContext(), "تاكد من ملئ خانة الايميل", Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (birthdate.isEmpty()) {
            Toast.makeText(getContext(), "تاكد من ملئ خانة تاريخ الميلاد", Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (phone.isEmpty()) {
            Toast.makeText(getContext(), "تاكد من ملئ خانة الجوال", Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (pass.isEmpty()) {
            Toast.makeText(getContext(), "تاكد من ملئ رقم المرور", Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (Passconf.isEmpty()) {
            Toast.makeText(getContext(), "تاكد من ملئ تأكيد رقم المرور", Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (!Passconf.equals(pass)) {
            Toast.makeText(getContext(), "تاكد من ان خانة كلمة المرور تساوى خانة التاكيد لها", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        return valid;
    }

    private void getregister() {
        onAuth((AppCompatActivity) getActivity(), getClient().getRegister(name, Email, birthdate, cityspinner.selected, phone, donationdate, pass, Passconf, bloodtypespinner.selected)
                , true, AUTH);
    }

    @OnClick({R.id.register_birthday, R.id.register_lastdate, R.id.register_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_birthday:
                dataBaker();
                TAG = "RegisterFragment";
                registerBirthday.setFocusable(false);
                displayData=registerBirthday;

                break;
            case R.id.register_lastdate:
                registerLastdate.setFocusable(false);
                dataBaker();
                displayData=registerLastdate;
                break;
            case R.id.register_register:
                if (Validation()) {
                    getregister();
                }
                break;
        }
    }

    protected void dataBaker() {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                getContext(),android.R.style.Theme_Holo_Light_Dialog_MinWidth,dateSetListener,year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month+1 ;
                Log.d(TAG, "onDateSet: yyyy-mm-dd: " + year + "-" + month + "-" + day);

                String date =  year + "-" + month + "-" + day;
                displayData.setText(date);

            }
        };
    }
}











