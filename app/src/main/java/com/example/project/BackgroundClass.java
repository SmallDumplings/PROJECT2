package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class BackgroundClass extends AppCompatActivity  {
    ImageButton ib1, ib2, ib3, ib4, ib5, ib6, ib7,ib8, ib9, ib10, ib11, ib12, ib13, ib14,ib15,ib16,ib17,ib18,ib19,ib20,ib21,ib22,ib23,ib24,ib25,ib26,ib27,ib28;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.background);
        ib1=findViewById(R.id.ib1);
        ib2=findViewById(R.id.ib2);
        ib3=findViewById(R.id.ib3);
        ib4=findViewById(R.id.ib4);
        ib5=findViewById(R.id.ib5);
        ib6=findViewById(R.id.ib6);
        ib7=findViewById(R.id.ib7);
        ib8=findViewById(R.id.ib8);
        ib9=findViewById(R.id.ib9);
        ib10=findViewById(R.id.ib10);
        ib11=findViewById(R.id.ib11);
        ib12=findViewById(R.id.ib12);
        ib13=findViewById(R.id.ib13);
        ib14=findViewById(R.id.ib14);
        ib15=findViewById(R.id.ib15);
        ib16=findViewById(R.id.ib16);
        ib17=findViewById(R.id.ib17);
        ib18=findViewById(R.id.ib18);
        ib19=findViewById(R.id.ib19);
        ib20=findViewById(R.id.ib20);
        ib21=findViewById(R.id.ib21);
        ib22=findViewById(R.id.ib22);
        ib23=findViewById(R.id.ib23);
        ib24=findViewById(R.id.ib24);
        ib25=findViewById(R.id.ib25);
        ib26=findViewById(R.id.ib26);
        ib27=findViewById(R.id.ib27);
        ib28=findViewById(R.id.ib28);
        ib1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onClickk(R.drawable.b1);
        }});
        ib1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onClickk(R.drawable.b2);
            }});
        ib1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onClickk(R.drawable.b3);
            }});
        ib1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onClickk(R.drawable.b4);
            }});
        ib1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onClickk(R.drawable.b5);
            }});
        ib1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onClickk(R.drawable.b6);
            }});
        ib1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onClickk(R.drawable.b7);
            }});
        ib1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onClickk(R.drawable.b8);
            }});
        ib1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onClickk(R.drawable.b9);
            }});





    }
    public void onClickk(int b){
        Intent intent = new Intent(BackgroundClass.this, TwoClass.class);
        intent.putExtra("b", b);
        startActivity(intent);
    }

}
