package com.example.todolist.modul.insert;

import com.example.todolist.base.BasePresenter;
import com.example.todolist.base.BaseView;

/**
 * Created by fahrul on 13/03/19.
 */

public interface InsertContract {
    interface View extends BaseView<Presenter> {
        void redirectToMain();
    }

    interface Presenter extends BasePresenter {
        void saveData(String title, String description);
        //void performLogin(String email, String password);
    }
}
