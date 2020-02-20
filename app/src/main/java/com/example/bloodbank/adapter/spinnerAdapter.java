package com.example.bloodbank.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bloodbank.R;
import com.example.bloodbank.data.model.city.CityData;

import java.util.ArrayList;
import java.util.List;

public class spinnerAdapter extends BaseAdapter {
    private Context context;
    public List<CityData> cityData = new ArrayList<>();
    private LayoutInflater inflater;
    public int selected = 0;

    public spinnerAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater.from(context));
    }

    public void setData(List<CityData> cityData, String hint) {
        cityData.add(0, new CityData(0, hint));
        this.cityData = cityData;
    }

    @Override
    public int getCount() {
        return cityData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.spinner_item, null);

        TextView names = view.findViewById(R.id.textView5);

        names.setText(cityData.get(i).getName());
        selected = cityData.get(i).getId();

        return view;
    }
}
