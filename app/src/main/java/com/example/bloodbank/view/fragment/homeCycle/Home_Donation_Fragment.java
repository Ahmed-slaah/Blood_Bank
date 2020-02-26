package com.example.bloodbank.view.fragment.homeCycle;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodbank.R;
import com.example.bloodbank.adapter.spinnerAdapter;
import com.example.bloodbank.data.model.donationRequests.DonationRequests;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.bloodbank.data.api.RetrofitClient.getClient;
import static com.example.bloodbank.helper.GeneralRequestData.getspinnerData;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Donation_Fragment extends Fragment {


    @BindView(R.id.government_spinner)
    Spinner spinnergovernment;
    @BindView(R.id.blood_type_spinner)
    Spinner spinnerbloodtype;
    @BindView(R.id.linear1)
    LinearLayout linear1;
    @BindView(R.id.recycler_donation_request)
    RecyclerView recyclerDonationRequest;



    private spinnerAdapter bloodtypespinner, gavernmenttypespinner;
    private String api_token;
    private int cityid;
    private int blodtypeid;
    private int page;

    public Home_Donation_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home__donation_, container, false);
        ButterKnife.bind(this, view);
        onSelesct();
        return view;
    }

    private void onSelesct() {
        bloodtypespinner = new spinnerAdapter(getActivity());
        gavernmenttypespinner = new spinnerAdapter(getActivity());
        getspinnerData(getClient().getBloodType(), spinnerbloodtype, bloodtypespinner,
                0, getString(R.string.get_blood_type));
        getspinnerData(getClient().getGovernment(),spinnergovernment,gavernmenttypespinner,0
                ,getString(R.string.get_government));
        onRequest();
    }

    private void onRequest() {
        getClient().getRequest(api_token,blodtypeid,cityid,page).enqueue(new Callback<List<DonationRequests>>() {
            @Override
            public void onResponse(Call<List<DonationRequests>> call, Response<List<DonationRequests>> response) {

            }

            @Override
            public void onFailure(Call<List<DonationRequests>> call, Throwable t) {

            }
        });
    }

}
