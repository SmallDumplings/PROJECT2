package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class StartClass extends AppCompatActivity {
    TextInputEditText editTextName;
    Button start;
    String e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_srat_layout);
        editTextName = findViewById(R.id.editTextName);

        start = findViewById(R.id.start);
        e1 = editTextName.getText().toString();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartClass.this, TwoClass.class);
                startActivity(intent);
                checked(e1);
            }});

    }
    public String checked(String e){
        e = e1;
        return e;
    }
}
