package com.example.todolist.modul.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.todolist.R;
import com.example.todolist.base.BaseFragment;
import com.example.todolist.modul.edit.EditActivity;
import com.example.todolist.modul.insert.InsertActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * Created by fahrul on 13/03/19.
 */

public class MainFragment extends BaseFragment<MainActivity, MainContract.Presenter> implements MainContract.View {

    EditText etEmail;
    EditText etPassword;
    Button btnList;
    FloatingActionButton btnAdd;


    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_main, container, false);
        mPresenter = new MainPresenter(this, requireContext());
        mPresenter.start();

        //etEmail = fragmentView.findViewById(R.id.et_email);
        //etPassword = fragmentView.findViewById(R.id.et_password);
        btnList = fragmentView.findViewById(R.id.checkBox3);
        btnAdd = fragmentView.findViewById(R.id.addBtn);
        //btnLogin.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        setBtLoginClick();
        //    }
        //});

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToEdit();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToInsert();
            }
        });

        setTitle("My Main View");

        return fragmentView;
    }

    //public void setBtLoginClick(){
    //    String email = etEmail.getText().toString();
    //    String password = etPassword.getText().toString();
    //    mPresenter.performLogin(email,password);
    //}

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToEdit() {
            Intent intent = new Intent(activity, EditActivity.class);
            startActivity(intent);
            activity.finish();
    }

    @Override
    public void redirectToInsert() {
        Intent intent = new Intent(activity, InsertActivity.class);
        startActivity(intent);
        activity.finish();
    }
}
