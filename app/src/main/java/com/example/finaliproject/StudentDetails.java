package com.example.finaliproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.finaliproject.Model.Student;

import java.util.ArrayList;

public class StudentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        Intent intent = getIntent();
        ArrayList<Student> data = intent.getParcelableExtra("student");
        data.get(0).getAge();
    }
}