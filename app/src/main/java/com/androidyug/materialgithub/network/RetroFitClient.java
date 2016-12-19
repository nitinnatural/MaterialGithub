package com.androidyug.materialgithub.network;

import com.androidyug.materialgithub.model.DataSet;
import com.androidyug.materialgithub.model.GithubResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nicheminds on 12/20/2016.
 */

public class RetroFitClient {


    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();




    // Trailing slash is needed
    public static final String BASE_URL = "https://api.github.com/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();



    GithubApi apiService =
            retrofit.create(GithubApi.class);


    public void getUser(String githubUsername, Callback callback ){
        Call<DataSet> call = apiService.fetchUser(githubUsername);
        call.enqueue(callback);
    }




}
