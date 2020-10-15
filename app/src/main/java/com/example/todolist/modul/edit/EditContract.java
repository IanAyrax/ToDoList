package com.example.todolist.modul.edit;

import com.example.todolist.base.BasePresenter;
import com.example.todolist.base.BaseView;

/**
 * Created by fahrul on 13/03/19.
 */

public interface EditContract {
    interface View extends BaseView<Presenter> {
        void redirectToMain();
    }

    interface Presenter extends BasePresenter {
        void performLogin(String email, String password);
    }
}
