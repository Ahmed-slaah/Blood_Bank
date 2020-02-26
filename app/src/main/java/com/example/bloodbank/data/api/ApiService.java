package com.example.bloodbank.data.api;

import com.example.bloodbank.data.model.city.City;
import com.example.bloodbank.data.model.auth.Auth;
import com.example.bloodbank.data.model.donationRequests.DonationRequests;
import com.example.bloodbank.data.model.posts.Posts;
import com.example.bloodbank.data.model.reset.Reset;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @POST("signup")
    @FormUrlEncoded
    Call<Auth> getRegister(@Field("name") String name,
                           @Field("email") String email,
                           @Field("birth_date") String birthdate,
                           @Field("city_id") int cityid,
                           @Field("phone") String phone,
                           @Field("donation_last_date") String donationdate,
                           @Field("password") String password,
                           @Field("password_confirmation") String passwordconf,
                           @Field("blood_type_id") int bloodtypeid);


    @POST("login")
    @FormUrlEncoded
    Call<Auth> getlogin(@Field("phone") String phone,
                        @Field("password") String pass);

    @POST("reset-password")
    @FormUrlEncoded
    Call<Reset> getreset(@Field("phone") String phone);


    @POST("new-password")
    @FormUrlEncoded
    Call<Auth> getnewpassword(@Field("password") String password,
                                     @Field("password_confirmation") String passconf,
                                     @Field("pin_code") String code,
                                     @Field("phone") String phone);

    @GET("posts")
    Call<List<Posts>> getposts(@Query("api_token") String api_token,
                              @Query("page") int page);

    @GET("donation-requests")
    Call<List<DonationRequests>> getRequest (@Query("api_token")String api_token,
                                       @Query("blood_type_id")int bloodtypeid,
                                       @Query("city_id")int cityid,
                                       @Query("page")int page);




    @GET("governorates")
    Call<City> getGovernment();

    @GET("cities")
    Call<City> getCity(@Query("governorate_id") String governorateid);

    @GET("blood-types")
    Call<City> getBloodType();

}
