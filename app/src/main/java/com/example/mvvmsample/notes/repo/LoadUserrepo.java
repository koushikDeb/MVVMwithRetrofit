package com.example.mvvmsample.notes.repo;

import android.os.CountDownTimer;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmsample.notes.model.Datum;
import com.example.mvvmsample.notes.model.User;
import com.example.mvvmsample.notes.networking.ApiInterface;
import com.example.mvvmsample.notes.networking.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadUserrepo {

    private static LoadUserrepo loadUserRepo;
    ApiInterface  myInterface;

    public static LoadUserrepo getInstance(){
        if (loadUserRepo == null){
            loadUserRepo = new LoadUserrepo();
        }
        return loadUserRepo;
    }

    LoadUserrepo(){
        myInterface = RetrofitService.getInterface();
    }


    public void populateList(final MutableLiveData<List<Datum>> users) {

        Call<User> callAsync = myInterface.getUser(2);

        callAsync.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                users.setValue(user.getData());
            }

            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
                System.out.println(throwable);
            }
        });


    }


    }

