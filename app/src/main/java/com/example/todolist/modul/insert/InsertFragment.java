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
import com.example.todolist.data.source.local.TaskTableHandler;
import com.example.todolist.data.source.session.TaskSessionRepository;
import com.example.todolist.modul.main.MainActivity;
//import com.example.todolist.modul.profile.ProfileActivity;


/**
 * Created by fahrul on 13/03/19.
 */

public class InsertFragment extends BaseFragment<InsertActivity, InsertContract.Presenter> implements InsertContract.View {

    EditText etTaskTitle;
    EditText etTaskDescription;
    Button btnCancel;
    Button btnSave;

    public InsertFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_insert, container, false);
        mPresenter = new InsertPresenter(this, new TaskSessionRepository(getActivity()), new TaskTableHandler(getActivity()));
        mPresenter.start();

        etTaskTitle = fragmentView.findViewById(R.id.editTextTextTitle);
        etTaskDescription = fragmentView.findViewById(R.id.editTextTextDescription);

        btnCancel = fragmentView.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtCancelClick();
            }
        });

        btnSave = fragmentView.findViewById(R.id.btn_done);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnSaveClick();
            }
        });

        setTitle("My Insert View");

        return fragmentView;
    }

    public void setBtnSaveClick(){
        String title = etTaskTitle.getText().toString();
        String description = etTaskDescription.getText().toString();
        mPresenter.saveData(title,description);
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
