package com.example.todolist.modul.edit;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by fahrul on 13/03/19.
 */

public class EditPresenter implements EditContract.Presenter{
    private final EditContract.View view;
    private final SharedPreferences sharedPreferences;
    public static final String PREFERENCE_KEY = "mvp_android";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    public EditPresenter(EditContract.View view, Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void performLogin(final String email, final String password){
        //proses login
        //if login success call redirect to profile
        saveUser(email, password);
        view.redirectToMain();
    }

    public void saveUser(String email, String password){
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString(EMAIL, email);
        editor.putString(PASSWORD, password);
        editor.commit();
    }

}
