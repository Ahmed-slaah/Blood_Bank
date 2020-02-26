package com.example.bloodbank.view.fragment.loginCycle;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.bloodbank.R;
import com.example.bloodbank.data.model.reset.Reset;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.bloodbank.data.api.RetrofitClient.getClient;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmPhoneFragment extends Fragment {


    @BindView(R.id.imageView8)
    ImageView imageView8;
    @BindView(R.id.Confirm_Confirm)
    EditText ConfirmConfirm;
    @BindView(R.id.send)
    Button send;
    private String phone ;

    public ConfirmPhoneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirm_phone, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.send)
    public void onViewClicked() {
        phone = ConfirmConfirm.getText().toString();
        getClient().getreset(phone).enqueue(new Callback<Reset>() {
            @Override
            public void onResponse(Call<Reset> call, Response<Reset> response) {
                try {
                if (response.body().getStatus()==1) {
                    Toast.makeText(getContext(), "نحقق من ارسال الكود", Toast.LENGTH_SHORT).show();
                        Fragment fragment = new ChangePhoneFragment();
                        getFragmentManager().beginTransaction().replace(R.id.confirm_layout, fragment).addToBackStack(null).commit();
                }else{
                    Toast.makeText(getContext(), "هذا الرقم غير صحيح", Toast.LENGTH_SHORT).show();
                }
                }catch (Exception e){

                }

            }

            @Override
            public void onFailure(Call<Reset> call, Throwable t) {

            }
        });
    }
}
