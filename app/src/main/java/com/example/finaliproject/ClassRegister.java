package com.example.finaliproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.finaliproject.ClassRegisterProvider.ClassRegisterAdaptor;
import com.example.finaliproject.Model.Student;

import java.util.ArrayList;

public class ClassRegister extends AppCompatActivity {
    ArrayList<Student> students;
    RecyclerView students_register_rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_register);
        students = new ArrayList<>();
        students_register_rcv = (RecyclerView) findViewById(R.id.students_register_rcv);

        Cursor cursor = AddStudent.sqLiteHelper.getData("SELECT * FROM STUDENT");

        if (cursor.getCount() == 0){

        }else {
            while (cursor.moveToNext()){
                students.add(new Student(1, cursor.getString(1), (cursor.getInt(0)+1021)));
            }

            ClassRegisterAdaptor adaptor = new ClassRegisterAdaptor(ClassRegister.this, students);
            students_register_rcv.setAdapter(adaptor);
            students_register_rcv.setLayoutManager(new LinearLayoutManager(ClassRegister.this));
        }

    }
}