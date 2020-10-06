package com.example.mvvmsample.notes.networking;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String BASE_URL = "https://reqres.in/";

    private  static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
// .client(httpClient.build())

    public static ApiInterface getInterface() {
        return retrofit.create(ApiInterface.class);
    }
}