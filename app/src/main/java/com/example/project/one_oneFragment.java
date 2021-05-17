package com.example.project;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;


public class one_oneFragment extends Fragment {
    ImageButton ib1, ib2, ib3, ib4, ib5, ib6, ib7,ib8, ib9, ib10, ib11, ib12, ib13, ib14,ib15,ib16,ib17,ib18,ib19,ib20,ib21,ib22,ib23,ib24,ib25,ib26,ib27,ib28;
    String s;

   //фрагмент с картинками 1 типа

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        ib1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                forButton(s ="R.logo1.");
//            }
//        });
       return inflater.inflate(R.layout.fragment_one_one, container, false);
    }


//    public void onClick(View view){
//        ImageButton imageButton = (ImageButton) view;
//        Intent intent = new Intent(getContext(), TwoClass.class);
//        intent.putExtra("image", );
//        startActivity(intent);
//    }
}