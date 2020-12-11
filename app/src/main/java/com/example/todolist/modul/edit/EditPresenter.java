package com.example.todolist.modul.edit;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.todolist.data.model.Task;
import com.example.todolist.data.source.local.TableHandler;
import com.example.todolist.data.source.session.SessionRepository;

import java.util.ArrayList;

/**
 * Created by fahrul on 13/03/19.
 */

public class EditPresenter implements EditContract.Presenter{
    private final EditContract.View view;
    private final SessionRepository sessionRepository;
    private final TableHandler tableHandler;
    private Task editedTask;
    //private final SharedPreferences sharedPreferences;
    //public static final String PREFERENCE_KEY = "mvp_android";
    //public static final String EMAIL = "email";
    //public static final String PASSWORD = "password";

    public EditPresenter(EditContract.View view, SessionRepository sessionRepository, TableHandler tableHandler) {
        //this.sharedPreferences = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
        this.view = view;
        this.sessionRepository = sessionRepository;
        this.tableHandler = tableHandler;
    }

    public void updateData(final String title, final String description){
        editedTask.setTitle(title);
        editedTask.setDescription(description);
        //save new task
        tableHandler.update(editedTask);

        //then go back to task list
        view.redirectToMain();
    }

    public void deleteTask(String id){
        tableHandler.delete(tableHandler.readById(id));
        view.redirectToMain();
    }

    public void getData(String id){
        //data.add(new Task("1","Task 1", "Kerjakan task satu"));
        //data.add(new Task("2", "Task 2", "Kerjakan task dua"));
        editedTask = (Task) tableHandler.readById(id);

        view.setData(editedTask);
    }

    @Override
    public void start() {}
}
