package com.example.todolist.modul.insert;

import android.view.View;

import com.example.todolist.base.BaseFragmentHolderActivity;


public class InsertActivity extends BaseFragmentHolderActivity {
    InsertFragment insertFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);


        insertFragment = new InsertFragment();
        setCurrentFragment(insertFragment, false);

    }



}
