package com.example.mvvmsample.notes.viewmodel;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmsample.notes.model.Datum;
import com.example.mvvmsample.notes.model.User;
import com.example.mvvmsample.notes.repo.LoadUserrepo;

import java.util.ArrayList;
import java.util.List;


public class MainViewModel extends ViewModel{
    LoadUserrepo ls = LoadUserrepo.getInstance();
    public MainViewModel() {
        users = new MutableLiveData<List<Datum>>();
        users.setValue(new ArrayList<Datum>());
    }
    private MutableLiveData<List<Datum>> users;
    public LiveData<List<Datum>> getUsers() {
        ls.populateList(users);
        return users;
    }

    public void buttonclicked(View view)
    {
        Log.d("koushik","buttonclicked");
        users.postValue(getUsers().getValue());
     // getUsers();
    }
}
