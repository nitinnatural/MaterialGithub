package com.androidyug.materialgithub.network;

import com.androidyug.materialgithub.model.DataSet;
import com.androidyug.materialgithub.model.GithubResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author nitinnatural@gmail.com
 */

public interface GithubApi {

//     users/nitinnatural/repos

    @GET("users/{username}/repos")
    Call<DataSet> fetchUser(@Path("username") String username);

}
