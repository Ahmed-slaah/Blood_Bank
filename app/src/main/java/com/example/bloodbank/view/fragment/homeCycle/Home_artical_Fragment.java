package com.example.bloodbank.view.fragment.homeCycle;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bloodbank.R;
import com.example.bloodbank.adapter.articalRecyclerAdapter;

import java.util.List;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_artical_Fragment extends Fragment {


    @BindView(R.id.searchview)
    EditText searchview;

    @BindView(R.id.imageView10)
    ImageView imageView10;

    public Home_artical_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_artical_, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            RecyclerView recycleartical = view.findViewById(R.id.recycleartical);
        articalRecyclerAdapter recycleAdapter = new articalRecyclerAdapter();
        recycleartical.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleartical.setAdapter(recycleAdapter);
        recycleartical.setHasFixedSize(true);
        super.onViewCreated(view, savedInstanceState);
    }



}
