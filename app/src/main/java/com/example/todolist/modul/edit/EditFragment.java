package com.example.todolist.modul.edit;

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
import com.example.todolist.data.model.Task;
import com.example.todolist.data.source.local.TaskTableHandler;
import com.example.todolist.data.source.session.TaskSessionRepository;
import com.example.todolist.modul.main.MainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.example.todolist.modul.profile.ProfileActivity;


/**
 * Created by fahrul on 13/03/19.
 */

public class EditFragment extends BaseFragment<EditActivity, EditContract.Presenter> implements EditContract.View {
    String id;
    EditText etTaskTitle;
    EditText etTaskDescription;
    Button btnCancel;
    Button btnSave;
    FloatingActionButton btnDelete;

    public EditFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_edit, container, false);
        mPresenter = new EditPresenter(this, new TaskSessionRepository(getActivity()), new TaskTableHandler(getActivity()));
        mPresenter.start();

        etTaskTitle = fragmentView.findViewById(R.id.editTextTextTitle);
        etTaskDescription = fragmentView.findViewById(R.id.editTextTextDescription);

        btnCancel = fragmentView.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnCancelClick();
            }
        });

        btnSave = fragmentView.findViewById(R.id.btn_done);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnSaveClick();
            }
        });

        btnDelete = fragmentView.findViewById(R.id.delete_btn);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnDeleteClick();
            }
        });

        setTitle("My Edit View");
        mPresenter.getData(this.id);

        return fragmentView;
    }

    public void setBtnCancelClick(){
    //    String email = etEmail.getText().toString();
    //    String password = etPassword.getText().toString();
    //    mPresenter.performLogin(email,password);
        redirectToMain();
    }

    public void setBtnDeleteClick(){
        //    String email = etEmail.getText().toString();
        //    String password = etPassword.getText().toString();
        //    mPresenter.performLogin(email,password);
        mPresenter.deleteTask(this.id);
    }

    public void setBtnSaveClick(){
        String title = etTaskTitle.getText().toString();
        String description = etTaskDescription.getText().toString();
        mPresenter.updateData(title,description);
    }

    @Override
    public void setPresenter(EditContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToMain() {
            Intent intent = new Intent(activity, MainActivity.class);
            startActivity(intent);
            activity.finish();
    }

    public void setData(Task task){
        this.etTaskDescription.setText(task.getDescription());
        this.etTaskTitle.setText(task.getTitle());
    }

    public void setId(String id){
        this.id = id;
    }
}
