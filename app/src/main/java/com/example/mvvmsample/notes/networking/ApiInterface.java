package com.example.mvvmsample.notes.networking;

import com.example.mvvmsample.notes.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api/users")
    Call<User> getUser(@Query("page") int pageno);
}
