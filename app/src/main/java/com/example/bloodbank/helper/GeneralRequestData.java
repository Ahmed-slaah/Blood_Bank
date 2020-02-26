package com.example.bloodbank.helper;

import android.content.Intent;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bloodbank.adapter.spinnerAdapter;
import com.example.bloodbank.data.model.auth.Auth;
import com.example.bloodbank.data.model.city.City;
import com.example.bloodbank.view.activity.HomeCycleActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class GeneralRequestData {
    public static final String AUTH = "AUTH";

    public static void getspinnerData(Call<City> call, Spinner spinner, spinnerAdapter adapter,
                                      Integer selected, String hint, AdapterView.OnItemSelectedListener listner) {
        call.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                try {
                    adapter.setData(response.body().getData(), hint);
                    spinner.setAdapter(adapter);

                    for (int i = 0; i < adapter.cityData.size(); i++) {
                        if (adapter.cityData.get(i).getId().equals(selected)) {
                            spinner.setSelection(i);
                            break;
                        }
                    }

                    spinner.setOnItemSelectedListener(listner);
                } catch (Exception e) {

                }

            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {

            }
        });
    }

    public static void getspinnerData(Call<City> call, Spinner spinner, spinnerAdapter adapter, Integer selected, String hint) {
        call.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                try {
                    adapter.setData(response.body().getData(), hint);
                    spinner.setAdapter(adapter);

                    for (int i = 0; i < adapter.cityData.size(); i++) {
                        if (adapter.cityData.get(i).getId().equals(selected)) {
                            spinner.setSelection(i);
                            break;
                        }
                    }
                } catch (Exception e) {

                }

            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }

    public static void onAuth(AppCompatActivity activity, Call<Auth> call, boolean remmberMe, String type){
        call.enqueue(new Callback<Auth>() {
            @Override

            public void onResponse(Call<Auth> call, Response<Auth> response) {
                try {
                    if (response.body().getStatus() == 1) {

                        SharedPreferencesManger.SaveData(activity,SharedPreferencesManger.USER_DATA , response.body().getData());
                        SharedPreferencesManger.SaveData(activity,SharedPreferencesManger.REMMBER_ME , remmberMe);

                        if (type.equals(AUTH)) {
                            activity.startActivity(new Intent(activity, HomeCycleActivity.class));
                            activity.finish();
                        }

                    }else{
                        Toast.makeText(activity, ""+response.body().getMsg()+"", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(activity, ""+e+"", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Auth> call, Throwable t) {
                Toast.makeText(activity, ""+t+"", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
