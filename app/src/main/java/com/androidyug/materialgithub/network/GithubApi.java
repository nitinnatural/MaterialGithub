package com.androidyug.materialgithub.network;

import com.androidyug.materialgithub.model.GithubResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author nitinnatural@gmail.com
 */

public interface GithubApi {

//     users/nitinnatural/repos

    @GET("users/{username}/repos")
    Call<List<GithubResponse>> fetchUser(@Path("username") String username);

}
