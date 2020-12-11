package com.example.todolist.modul.edit;

import com.example.todolist.base.BasePresenter;
import com.example.todolist.base.BaseView;
import com.example.todolist.data.model.Task;

import java.util.ArrayList;

/**
 * Created by fahrul on 13/03/19.
 */

public interface EditContract {
    interface View extends BaseView<Presenter> {
        void redirectToMain();
        void setData(Task task);
    }

    interface Presenter extends BasePresenter {
        //void performLogin(String email, String password);
        void updateData(String title, String description);
        void deleteTask(String id);
        void getData(String id);
    }
}
