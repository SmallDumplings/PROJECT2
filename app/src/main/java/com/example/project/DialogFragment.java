package com.example.project;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class DialogFragment extends AppCompatActivity implements View.OnClickListener {
    Button bb1, bb2, bb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogfragment);
        bb1 = findViewById(R.id.bb1);
        bb2 = findViewById(R.id.bb2);
        bb3 = findViewById(R.id.bb3);

        bb1.setOnClickListener(this);
        bb2.setOnClickListener(this);
        bb3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.bb1:
                fragment = new one_oneFragment();
                break;
            case R.id.bb2:
                fragment = new Fragment_two();
                break;
            case R.id.bb3:
                fragment = new Fragmet_three();
                break;

        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frameLayout,fragment);
        transaction.commit();
    }
}
