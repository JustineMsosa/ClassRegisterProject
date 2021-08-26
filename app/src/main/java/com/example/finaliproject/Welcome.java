package com.example.finaliproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {
    Button RegisterStudent;
    Button ViewStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        RegisterStudent = (Button) findViewById(R.id.btnRegisterStudents);
        RegisterStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent =  new Intent(Welcome.this, MainActivity2.class);
                startActivity(aboutIntent);

            }
        });

        ViewStudent = (Button) findViewById(R.id.btnViewStudents);
        ViewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent =  new Intent(Welcome.this, StudentList.class);
                startActivity(aboutIntent);

            }
        });


    }
}