package com.example.bloodbank.helper;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class helperMethod {


    public static void dataBaker( String TAG , TextView textView, DatePickerDialog dialog) {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
         DatePickerDialog.OnDateSetListener dateSetListener;
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month+1 ;
                Log.d(TAG, "onDateSet: yyyy-mm-dd: " + year + "-" + month + "-" + day);

                String date =  year + "-" + month + "-" + day;
                textView.setText(date);

            }
        };
    }
}
