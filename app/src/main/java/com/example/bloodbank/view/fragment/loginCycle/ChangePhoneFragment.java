package com.example.bloodbank.view.fragment.loginCycle;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bloodbank.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.bloodbank.data.api.RetrofitClient.getClient;
import static com.example.bloodbank.helper.GeneralRequestData.AUTH;
import static com.example.bloodbank.helper.GeneralRequestData.onAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangePhoneFragment extends Fragment {


    @BindView(R.id.imageView9)
    ImageView imageView9;
    @BindView(R.id.code)
    EditText code;
    @BindView(R.id.new_password)
    EditText newPassword;
    @BindView(R.id.change_confirm_code)
    EditText changeConfirmCode;
    @BindView(R.id.change)
    Button change;
    private String password ;
    private String confirmpassword ;
    private String Code ;
    private String phone ;
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_phone, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.change)
    public void onViewClicked() {
        password=newPassword.getText().toString();
        confirmpassword=changeConfirmCode.getText().toString();
        Code=code.getText().toString();
        if (Validation()) {
           getChangePassword();
        }
    }


    private boolean Validation() {
        if (password.equals(confirmpassword)) {
            return true;
        }else {
            Toast.makeText(getContext(), "تأكد من ان خانة كلمة المرور الجديده تساوى خانة التأكيد لها", Toast.LENGTH_SHORT).show();
            return false;
        }
        
    }
    private void getChangePassword() {
        onAuth((AppCompatActivity) getActivity(),getClient().getnewpassword(password,confirmpassword,Code,phone),true,AUTH);
    }

}
