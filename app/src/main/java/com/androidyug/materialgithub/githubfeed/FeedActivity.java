package com.androidyug.materialgithub.githubfeed;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidyug.materialgithub.R;
import com.androidyug.materialgithub.model.GithubResponse;
import com.androidyug.materialgithub.model.Owner;
import com.androidyug.materialgithub.network.RetroFitClient;
import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedActivity extends AppCompatActivity {

    public static final String INTENT_USERNAME = "intent_username";

    RecyclerView rvFeed;
    TextView tvUsername;
    ImageView ivAvatar;


//    FloatingActionButton fab;
//    ContentLoadingProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        initViews();

        String username = getIntent().getStringExtra(INTENT_USERNAME);
        RetroFitClient rfClient = new RetroFitClient();
        rfClient.getUser(username, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                List<GithubResponse> ghResponse = (List<GithubResponse>) response.body();
                initFeedRecyclerView(ghResponse);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
            }
        });
    }


    void initFeedRecyclerView(List<GithubResponse> githubResponseList){
        Owner owner = githubResponseList.get(0).getOwner();
        Glide.with(this).load(owner.getAvatar_url()).into(ivAvatar);
        tvUsername.setText(owner.getLogin());
        rvFeed.setAdapter(new RvFeedAdapter(githubResponseList, this));
        rvFeed.setLayoutManager(new LinearLayoutManager(this));
    }

    void initViews(){
        rvFeed = (RecyclerView) findViewById(R.id.rv_feed);
        tvUsername = (TextView) findViewById(R.id.tv_username);
        ivAvatar = (ImageView) findViewById(R.id.iv_avatar);

//        fab = (FloatingActionButton) findViewById(R.id.fab);
//        progressBar = (ContentLoadingProgressBar) findViewById(R.id.progressbar);
    }

}
