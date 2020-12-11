package com.example.todolist.modul.login;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.todolist.data.model.User;
import com.example.todolist.data.source.session.SessionRepository;

/**
 * Created by fahrul on 13/03/19.
 */

public class LoginPresenter implements LoginContract.Presenter{
    private final LoginContract.View view;
    private final SharedPreferences sharedPreferences;
    public static final String PREFERENCE_KEY = "mvp_android";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    private final SessionRepository sessionRepository;

    public LoginPresenter(LoginContract.View view, Context context, SessionRepository sessionRepository) {
        this.sharedPreferences = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
        this.view = view;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void start() {
        if(sessionRepository.getSessionData() != null){                                             //new
            view.redirectToMain();                                                               //jika sudah login langsung masuk profile
        }
    }

    @Override
    public void performLogin(final String email, final String password){
        //proses login
        //if login success call redirect to profile
        saveUser(email, "TOKEN123456");
        view.redirectToMain();
    }

    public void saveUser(String email, String token){
        //SharedPreferences.Editor editor = this.sharedPreferences.edit();
        User loggedUser = new User(email, token);
        sessionRepository.setSessionData(loggedUser);
        //editor.putString(EMAIL, email);
        //editor.putString(PASSWORD, token);
        //editor.commit();
    }

}
