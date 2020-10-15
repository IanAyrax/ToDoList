package com.example.todolist.modul.main;

import com.example.todolist.base.BasePresenter;
import com.example.todolist.base.BaseView;

/**
 * Created by fahrul on 13/03/19.
 */

public interface MainContract {
    interface View extends BaseView<Presenter> {
        void redirectToEdit();
        void redirectToInsert();
    }

    interface Presenter extends BasePresenter {
        //void performLogin(String email, String password);
    }
}
