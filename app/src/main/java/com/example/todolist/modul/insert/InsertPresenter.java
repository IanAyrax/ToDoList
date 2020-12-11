package com.example.todolist.modul.insert;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.todolist.data.model.Task;
import com.example.todolist.data.source.local.TableHandler;
import com.example.todolist.data.source.session.SessionRepository;

/**
 * Created by fahrul on 13/03/19.
 */

public class InsertPresenter implements InsertContract.Presenter{
    private final InsertContract.View view;
    private final SessionRepository sessionRepository;
    private final TableHandler tableHandler;
    //private final SharedPreferences sharedPreferences;
    //public static final String PREFERENCE_KEY = "mvp_android";
    //public static final String EMAIL = "email";
    //public static final String PASSWORD = "password";

    public InsertPresenter(InsertContract.View view, SessionRepository sessionRepository,  TableHandler tableHandler) {
        //this.sharedPreferences = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
        this.tableHandler = tableHandler;
        this.sessionRepository = sessionRepository;
        this.view = view;
    }

    @Override
    public void start() {}

    public void saveData(final String title, final String description){
        Task newTask = new Task(title, description);
        //save new task
        tableHandler.create(newTask);

        //then go back to task list
        view.redirectToMain();
    }
    //@Override
    //public void performLogin(final String email, final String password){
        //proses login
        //if login success call redirect to profile
        //saveUser(email, password);
        //view.redirectToMain();
    //}

    //public void saveUser(String email, String password){
        //SharedPreferences.Editor editor = this.sharedPreferences.edit();
        //editor.putString(EMAIL, email);
        //editor.putString(PASSWORD, password);
        //editor.commit();
    //}

}
