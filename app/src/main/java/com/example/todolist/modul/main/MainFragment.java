package com.example.todolist.modul.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.base.BaseFragment;
import com.example.todolist.data.model.Task;
import com.example.todolist.data.source.local.TaskTableHandler;
import com.example.todolist.data.source.session.TaskSessionRepository;
import com.example.todolist.modul.edit.EditActivity;
import com.example.todolist.modul.insert.InsertActivity;
import com.example.todolist.utils.RecyclerViewAdapterTodolist;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Console;
import java.util.ArrayList;

/**
 * Created by fahrul on 13/03/19.
 */

public class MainFragment extends BaseFragment<MainActivity, MainContract.Presenter> implements MainContract.View {

    EditText etEmail;
    EditText etPassword;
    Button btnList;
    FloatingActionButton btnAdd;
    RecyclerView mRecyclerView;


    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_main, container, false);
        mPresenter = new MainPresenter(this, new TaskSessionRepository(getActivity()), new TaskTableHandler(getActivity()));
        mPresenter.start();

        mRecyclerView = fragmentView.findViewById(R.id.rv_id);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(activity));

        final ArrayList<Task> data = mPresenter.getDataSet();
        //Toast.makeText(getActivity(), data.get(0).getId(), Toast.LENGTH_LONG);
        RecyclerViewAdapterTodolist mAdapter = new RecyclerViewAdapterTodolist(data);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new RecyclerViewAdapterTodolist.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                String id = data.get(position).getId();
                redirectToEdit(id);
            }
        });

        btnAdd = fragmentView.findViewById(R.id.addBtn);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToInsert();
            }
        });

        setTitle("My Main View");

        return fragmentView;
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToEdit(String id) {
        Intent intent = new Intent(activity, EditActivity.class);
        intent.putExtra("TaskId", id);
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
