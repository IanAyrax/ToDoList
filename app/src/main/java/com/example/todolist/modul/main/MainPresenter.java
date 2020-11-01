package com.example.todolist.modul.main;

import android.content.Context;

import com.example.todolist.data.model.Task;
import java.util.ArrayList;

/**
 * Created by fahrul on 13/03/19.
 */

public class MainPresenter implements MainContract.Presenter{
    private final MainContract.View view;
    //private final SharedPreferences sharedPreferences;
    //public static final String PREFERENCE_KEY = "mvp_android";
    //public static final String EMAIL = "email";
    //public static final String PASSWORD = "password";

    public MainPresenter(MainContract.View view, Context context) {
        //this.sharedPreferences = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public ArrayList<Task> getDataSet() {
        //get Data from DB
        ArrayList<Task> data = new ArrayList<Task> ();
        data.add(new Task("1","Task 1", "Kerjakan task satu"));
        data.add(new Task("2", "Task 2", "Kerjakan task dua"));

        return data;
    }

   // @Override
   // public void performLogin(final String email, final String password){
        //proses login
        //if login success call redirect to profile
        //saveUser(email, password);
    //    view.redirectToEdit();
    //}

    /*public void saveUser(String email, String password){
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString(EMAIL, email);
        editor.putString(PASSWORD, password);
        editor.commit();
    }*/
}
