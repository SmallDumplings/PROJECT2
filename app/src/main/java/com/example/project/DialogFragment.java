package com.example.project;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class DialogFragment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogfragment);


    }

    public void Change(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.bb1:
                fragment = new one_oneFragment();
                break;
            case R.id.bb2:
                fragment = new Fragment_two();
                break;
            case R.id.bb3:

                break;
            case R.id.bb4:
                break;

        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.f1,fragment);
        transaction.commit();
    }
}
