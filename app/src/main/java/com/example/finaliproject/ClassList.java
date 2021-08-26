package com.example.finaliproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.finaliproject.ClassListProvider.ClassListAdaptor;
import com.example.finaliproject.ClassRegisterProvider.ClassRegisterAdaptor;

import java.util.ArrayList;

public class ClassList extends AppCompatActivity {

    ArrayList<Student> students;
    RecyclerView students_list_rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);
        students = new ArrayList<>();
        students_list_rcv = (RecyclerView) findViewById(R.id.students_list_rcv);

        Cursor cursor = MainActivity2.sqLiteHelper.getData("SELECT * FROM STUDENT");

        if (cursor.getCount() == 0){

        }else {
            while (cursor.moveToNext()){
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String age = cursor.getString(2);
                String sex = cursor.getString(5);
                students.add(new Student(1, name, age, sex));
            }

            ClassListAdaptor adaptor = new ClassListAdaptor(ClassList.this, students);
            students_list_rcv.setAdapter(adaptor);
            students_list_rcv.setLayoutManager(new LinearLayoutManager(ClassList.this));
        }

    }
}