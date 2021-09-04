package com.example.finaliproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finaliproject.Model.Student;

import java.util.ArrayList;

public class StudentDetails extends AppCompatActivity {
    TextView name, age, attendance, code, village;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        Intent intent = getIntent();
        Student data = intent.getParcelableExtra("student");
        int id = Integer.parseInt(intent.getStringExtra(Intent.EXTRA_TEXT));

        name = (TextView) findViewById(R.id.TextViewName);
        age = (TextView) findViewById(R.id.TextViewAge);
        attendance = (TextView) findViewById(R.id.TextViewSex);
        village = (TextView) findViewById(R.id.TextViewVillage);
        code = (TextView) findViewById(R.id.TextViewCode);
        imageView = (ImageView) findViewById(R.id.imageViewStu);
        code.setText("Student Id Number: 0012"+id);

        Cursor cursor = MainActivity2.sqLiteHelper.getData("SELECT * FROM STUDENT");
        while (cursor.moveToNext()) {
            int id1 = cursor.getInt(0);
            String name1 = cursor.getString(1);
            String age1 = cursor.getString(2);
            byte[] image1 = cursor.getBlob(4);
            String present1 = cursor.getString(3);
            String sex1 = cursor.getString(5);
            String village1 = cursor.getString(6);
            Integer studentCode1 = cursor.getInt(7);
            if (id1 == id){
                name.setText("  Name: "+name1);
                age.setText("   Age: "+age1+"  | Sex: "+sex1);
                attendance.setText("  Attendance: "+present1);
                village.setText("  Village: "+village1);
                code.setText("  Student Code: 0"+id1+""+studentCode1);
                imageView.setImageBitmap( BitmapFactory.decodeByteArray(image1, 0 , image1.length));

            }
        }


    }
}