package com.example.todolist.modul.main;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.base.BasePresenter;
import com.example.todolist.base.BaseView;
import com.example.todolist.data.model.Task;

import java.util.ArrayList;

/**
 * Created by fahrul on 13/03/19.
 */

public interface MainContract {
    interface View extends BaseView<Presenter> {
        void redirectToEdit(String id);
        void redirectToInsert();
    }

    interface Presenter extends BasePresenter {
        //void performLogin(String email, String password);
        ArrayList<Task> getDataSet();
    }
}
