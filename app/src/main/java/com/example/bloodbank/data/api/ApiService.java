package com.example.bloodbank.data.api;

import com.example.bloodbank.data.model.city.City;
import com.example.bloodbank.data.model.login.Login;
import com.example.bloodbank.data.model.register.Auth;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @POST("register")
    @FormUrlEncoded
    Call<Auth> getRegister(@Field("name") String name,
                           @Field("email") String email,
                           @Field("birth_date") String birthdate,
                           @Field("city_id") String cityid,
                           @Field("phone") String phone,
                           @Field("donation_last_date") String donationdate,
                           @Field("password") String password,
                           @Field("password_confirmation") String passwordconf,
                           @Field("blood_type_id") String bloodtypeid);


    @POST("login")
    @FormUrlEncoded
    Call<Login> getlogin (@Field("phone") String phone ,
                          @Field("password") String pass );




    @GET("governorates")
    Call<City> getGovernment();

    @GET("cities")
    Call<City> getCity(@Query("governorate_id") String governorateid);

    @GET("blood-types")
    Call<City> getBloodType();

}
