package com.example.bloodbank.view.fragment.homeCycle;


import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bloodbank.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class EdiFragment extends Fragment {


    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_mail)
    EditText editMail;
    @BindView(R.id.edit_birthday)
    EditText editBirthday;
    @BindView(R.id.blood)
    ImageView blood;
    @BindView(R.id.edit_spinner_blood)
    Spinner editSpinnerBlood;
    @BindView(R.id.relative_spinner_blood)
    RelativeLayout relativeSpinnerBlood;
    @BindView(R.id.edit_lastdate)
    EditText editLastdate;
    @BindView(R.id.home)
    ImageView home;
    @BindView(R.id.edit_spinner_government)
    Spinner editSpinnerGovernment;
    @BindView(R.id.relative_spinner_government)
    RelativeLayout relativeSpinnerGovernment;
    @BindView(R.id.home1)
    ImageView home1;
    @BindView(R.id.spinner3)
    Spinner spinner3;
    @BindView(R.id.edit_spinner_city)
    RelativeLayout editSpinnerCity;
    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.edit_password_confirm)
    EditText editPasswordConfirm;
    @BindView(R.id.edit_edit)
    Button editEdit;

    public TextView displayData = null;
    public static String TAG = null;
    public DatePickerDialog.OnDateSetListener dateSetListener;

    public EdiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edi, container, false);


        return view;
    }

    @OnClick({R.id.edit_birthday, R.id.edit_lastdate, R.id.edit_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.edit_birthday:
                TAG="EditFragment";
                displayData=editBirthday;
                break;
            case R.id.edit_lastdate:
                TAG="EditFragment";
                displayData=editLastdate;
                break;
            case R.id.edit_edit:
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
