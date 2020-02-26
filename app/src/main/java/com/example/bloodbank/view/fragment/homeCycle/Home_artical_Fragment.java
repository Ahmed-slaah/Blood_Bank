package com.example.bloodbank.view.fragment.homeCycle;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodbank.R;
import com.example.bloodbank.adapter.articalRecyclerAdapter;
import com.example.bloodbank.data.model.posts.Posts;
import com.example.bloodbank.data.model.posts.PostsData;

import java.util.ArrayList;
import java.util.List;

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
public class Home_artical_Fragment extends Fragment {


    @BindView(R.id.searchview)
    SearchView searchview;
    @BindView(R.id.recycleartical)
    RecyclerView recycleartical;
    @BindView(R.id.add)
    ImageView add;
    @BindView(R.id.article_layout)
    RelativeLayout articleLayout;
    @BindView(R.id.articleframe_layout)
    FrameLayout articleframeLayout;
    private String api_token;
    private int page;

    ArrayList<PostsData> postsData;
    private articalRecyclerAdapter recycleAdapter;

    public Home_artical_Fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_artical_, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        onPosts();
    }

    private void onPosts() {

        getClient().getposts(api_token,page).enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                try {
                    if (response.body().get(page).getStatus()==1) {
                        GridLayoutManager mngr = new GridLayoutManager(getContext(),1);
                        recycleartical.setLayoutManager(mngr);
                        recycleAdapter = new articalRecyclerAdapter(getContext());
                        recycleartical.setAdapter(recycleAdapter);
                        recycleAdapter.setDataSource(postsData);
                        recycleAdapter.notifyDataSetChanged();

                    }else {
                        Toast.makeText(getContext(), ""+response.body().get(page).getMsg()+"", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    Toast.makeText(getContext(), ""+e+"", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Toast.makeText(getContext(),  "  فيليااار"+t+"  ", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @OnClick(R.id.add)
    public void onViewClicked() {
        NewDonationFragment fragment = new NewDonationFragment();
        getFragmentManager().beginTransaction().replace(R.id.homecyclelayout1, fragment).addToBackStack(null)
                .commit();
    }
}
