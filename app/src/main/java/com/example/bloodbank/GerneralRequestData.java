package com.example.bloodbank;

import androidx.fragment.app.Fragment;

import com.example.bloodbank.R;
import com.example.bloodbank.data.model.register.Auth;
import com.example.bloodbank.helper.SharedPreferencesManger;
import com.example.bloodbank.view.fragment.loginCycle.Loginn_Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.bloodbank.data.api.RetrofitClient.getClient;

public class GerneralRequestData {
    public static String name;
    public static String phone;
    public static String Email;
    public static String EmailConf;
    public static String pass;
    public static String Passconf;
    public static String birthdate;
    public static String city;
    public static String donationdate;
    public static String bloodtype;
    
    public static void getregister() {

        getClient().getRegister(name, Email, birthdate, city, phone, donationdate, pass, Passconf, bloodtype).enqueue(new Callback<Auth>() {
            @Override

            public void onResponse(Call<Auth> call, Response<Auth> response) {
                try {
                    if (response.body().getStatus() == 1) {
                        

                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<Auth> call, Throwable t) {


            }
        });

    }


}
