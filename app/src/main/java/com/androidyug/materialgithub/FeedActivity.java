package com.androidyug.materialgithub;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.androidyug.materialgithub.model.DataSet;
import com.androidyug.materialgithub.model.GithubResponse;
import com.androidyug.materialgithub.network.RetroFitClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedActivity extends AppCompatActivity {

    public static final String INTENT_USERNAME = "intent_username";

    RecyclerView rvFeed;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        initViews();

        String username = getIntent().getStringExtra(INTENT_USERNAME);
        RetroFitClient rfClient = new RetroFitClient();
        rfClient.getUser("nitinnatural", new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                DataSet ghResponse = (DataSet) response.body();
                Log.d("hello", "som");
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("hello", "tom");
            }
        });
    }




    void initViews(){
        rvFeed = (RecyclerView) findViewById(R.id.rv_feed);
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

}
