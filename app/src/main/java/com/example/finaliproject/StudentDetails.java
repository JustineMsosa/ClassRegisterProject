package com.example.finaliproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.finaliproject.Model.Student;

import java.util.ArrayList;

public class StudentDetails extends AppCompatActivity {
    TextView name, age, sex, code, village;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        Intent intent = getIntent();
        Student data = intent.getParcelableExtra("student");
        int id = Integer.parseInt(intent.getStringExtra(Intent.EXTRA_TEXT));

        name = (TextView) findViewById(R.id.TextViewName);
        age = (TextView) findViewById(R.id.TextViewAge);
        sex = (TextView) findViewById(R.id.student_sex);
        code = (TextView) findViewById(R.id.TextViewCode);
        code.setText("Student Id Number: 0012"+id);

    }
}