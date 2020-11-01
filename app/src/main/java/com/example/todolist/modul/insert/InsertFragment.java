package com.example.todolist.modul.insert;

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
import com.example.todolist.modul.main.MainActivity;
//import com.example.todolist.modul.profile.ProfileActivity;


/**
 * Created by fahrul on 13/03/19.
 */

public class InsertFragment extends BaseFragment<InsertActivity, InsertContract.Presenter> implements InsertContract.View {

    //EditText etEmail;
    //EditText etPassword;
    Button btnCancel;


    public InsertFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_insert, container, false);
        mPresenter = new InsertPresenter(this, requireContext());
        mPresenter.start();

        //etEmail = fragmentView.findViewById(R.id.et_email);
        //etPassword = fragmentView.findViewById(R.id.et_password);
        btnCancel = fragmentView.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtCancelClick();
            }
        });

        setTitle("My Insert View");

        return fragmentView;
    }

    public void setBtCancelClick(){
    //    String email = etEmail.getText().toString();
    //    String password = etPassword.getText().toString();
    //    mPresenter.performLogin(email,password);
        redirectToMain();
    }

    @Override
    public void setPresenter(InsertContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToMain() {
            Intent intent = new Intent(activity, MainActivity.class);
            startActivity(intent);
            activity.finish();
    }


}
