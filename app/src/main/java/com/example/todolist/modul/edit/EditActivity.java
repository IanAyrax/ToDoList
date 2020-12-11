package com.example.todolist.modul.edit;

import android.view.View;

import com.example.todolist.base.BaseFragmentHolderActivity;


public class EditActivity extends BaseFragmentHolderActivity {
    EditFragment editFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);


        editFragment = new EditFragment();
        String id = getIntent().getExtras().getString("TaskId");
        editFragment.setId(id);
        setCurrentFragment(editFragment, false);

    }
}
