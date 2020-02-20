package com.example.bloodbank.helper;

import android.util.Log;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.bloodbank.adapter.spinnerAdapter;
import com.example.bloodbank.data.model.city.City;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class SpinnerRequest {
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
}
