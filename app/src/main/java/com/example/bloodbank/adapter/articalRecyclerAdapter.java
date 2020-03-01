package com.example.bloodbank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodbank.R;
import com.example.bloodbank.articleData;
import com.example.bloodbank.data.model.posts.PostsData;

import java.util.ArrayList;
import java.util.List;

public class articalRecyclerAdapter extends RecyclerView.Adapter<articalRecyclerAdapter.ArticleHolder> {
    Context context;
    List<PostsData> postsData = new ArrayList<>();

    public articalRecyclerAdapter(Context c, List<PostsData> postsData) {
        this.context = c;
        this.postsData = postsData;
    }

    @NonNull
    @Override
    public ArticleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.article_row, parent, false);
        ArticleHolder holder = new ArticleHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleHolder holder, int position) {
        holder.title.setText(postsData.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return postsData != null ? postsData.size() : 0;
    }

    public void setDataSource(ArrayList<PostsData> postsData) {
        this.postsData = postsData;
    }

    class ArticleHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView title;
        CheckBox like;

        public ArticleHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.articalcardview);
            title = itemView.findViewById(R.id.articaltextview);
            like = itemView.findViewById(R.id.like);
        }
    }
}


























