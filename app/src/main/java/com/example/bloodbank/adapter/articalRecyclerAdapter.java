package com.example.bloodbank.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodbank.R;

public class articalRecyclerAdapter extends RecyclerView.Adapter {


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.article_row, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
                public CardView cardView ;
                public TextView textView ;
                public ImageView imageView , imageView2 ;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.articalcardview);
                textView = itemView.findViewById(R.id.articaltextview);
                imageView = itemView.findViewById(R.id.imageView13);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView.setVisibility(View.INVISIBLE);
                        imageView2.setVisibility(View.VISIBLE);
                    }
                });
                imageView2 = itemView.findViewById(R.id.imageView14);
                imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView2.setVisibility(View.INVISIBLE);
                        imageView.setVisibility(View.VISIBLE);
                    }
                });

            }
        }
}
