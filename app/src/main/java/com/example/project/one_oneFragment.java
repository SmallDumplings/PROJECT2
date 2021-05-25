package com.example.project;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import android.widget.LinearLayout;
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

        View view = inflater.inflate(R.layout.fragment_one_one, container, false);

        ib1 = view.findViewById(R.id.ib1);
        ib2 =view.findViewById(R.id.ib2);
        ib3 =view.findViewById(R.id.ib3);
        ib4 =view.findViewById(R.id.ib4);
        ib5 =view.findViewById(R.id.ib5);
        ib6 =view.findViewById(R.id.ib6);
        ib7 =view.findViewById(R.id.ib7);
        ib8 =view.findViewById(R.id.ib8);
        ib9 =view.findViewById(R.id.ib9);
        ib10 = view.findViewById(R.id.ib10);
        ib11 = view.findViewById(R.id.ib11);
        ib12 = view.findViewById(R.id.ib12);
        ib13 = view.findViewById(R.id.ib13);
        ib14 = view.findViewById(R.id.ib14);
        ib15 = view.findViewById(R.id.ib15);
        ib16 = view.findViewById(R.id.ib16);
        ib17 = view.findViewById(R.id.ib17);
        ib18 = view.findViewById(R.id.ib18);
        ib19 = view.findViewById(R.id.ib19);
        ib20 = view.findViewById(R.id.ib20);
        ib21 = view.findViewById(R.id.ib21);
        ib22 = view.findViewById(R.id.ib22);
        ib23 = view.findViewById(R.id.ib23);
        ib24 = view.findViewById(R.id.ib24);
        ib25 = view.findViewById(R.id.ib25);
        ib26 = view.findViewById(R.id.ib26);
        ib27 = view.findViewById(R.id.ib27);
        ib28 = view.findViewById(R.id.ib28);


        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m1);
            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m2);
            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m3);
            }
        });
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m4);
            }
        });
        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m5);
            }
        });
        ib6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m6);
            }
        });
        ib7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m7);
            }
        });
        ib8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m8);
            }
        });
        ib9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m9);
            }
        });
        ib10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m10);
            }
        });
        ib11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m11);
            }
        });
        ib12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m12);
            }
        });
        ib13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m13);
            }
        });
        ib14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m14);
            }
        });
        ib15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m15);
            }
        });
        ib16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m16);
            }
        });
        ib17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m17);
            }
        });
        ib18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m18);
            }
        });
        ib19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m19);
            }
        });
        ib20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m20);
            }
        });
        ib21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m21);
            }
        });
        ib22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m22);
            }
        });
        ib23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m23);
            }
        });
        ib24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m24);
            }
        });
        ib25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m25);
            }
        });
        ib26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m26);
            }
        });
        ib27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m27);
            }
        }); ib28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickk(R.drawable.m28);
            }
        });
      return view;

    }


    public void onClickk(int i){
        Intent intent = new Intent(getContext(), TwoClass.class);
        intent.putExtra("v", i);
        startActivity(intent);

//        infoLayout.removeAllViews();
//        infoLayout.addView(view);
    }
}