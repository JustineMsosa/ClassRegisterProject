package com.example.finaliproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
public class MainActivity2 extends AppCompatActivity {

    EditText edtName, edtAge, edtVillage, studentCode;
    Button btnChoose, btnAdd, btnList;
    ImageView imageView;
    String sex;
    final int REQUEST_CODE_GALLERY = 999;

    public static SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnChoose = (Button) findViewById(R.id.btnChoose);
        edtName = (EditText) findViewById(R.id.editName);
        edtVillage = (EditText) findViewById(R.id.editResidents);
        edtAge = (EditText) findViewById(R.id.editAge);
        studentCode = (EditText) findViewById(R.id.student_number);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnList = (Button) findViewById(R.id.btnList);
        imageView = (ImageView) findViewById(R.id.imageView);

        sqLiteHelper = new SQLiteHelper(this, "StudentDB.sqlite", null, 1);

        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS STUDENT(Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR, age VARCHAR, present VARCHAR, image BLOB, sex VARCHAR, " +
                "village VARCHAR, studentCode NUMBER)");

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        MainActivity2.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY

                );

            }
        });



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String present = "0";
                    if (TextUtils.isEmpty(edtName.getText().toString().trim()) ||
                            TextUtils.isEmpty(edtAge.getText().toString().trim())  ||
                            TextUtils.isEmpty(edtVillage.getText().toString().trim()) ){
                        Toast.makeText(getApplicationContext(), "please fill all the fields!", Toast.LENGTH_SHORT).show();
                        return;

                    }
                    else {

                        try {
                            sqLiteHelper.insertData(edtName.getText().toString().trim(),
                                    edtAge.getText().toString().trim(), present,
                                    imageViewToByte(imageView), sex.trim(),edtVillage.getText().toString().trim(),
                                    Integer.parseInt(studentCode.getText().toString().trim())
                            );
                            Toast.makeText(getApplicationContext(), "Added successfully!", Toast.LENGTH_SHORT).show();
                            edtName.setText("");
                            edtAge.setText("");
                            edtVillage.setText("");
                            imageView.setImageResource(R.drawable.username);
                            studentCode.setText("");

                            Intent intent = new Intent(MainActivity2.this, StudentList.class);
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }


        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, StudentList.class);
                startActivity(intent);
            }
        });



    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length >0 && grantResults[0] == getPackageManager().PERMISSION_GRANTED){

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
            else {

                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){


            if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
                Uri uri = data.getData();

                try {
                    InputStream inputStream = getContentResolver().openInputStream(uri);

                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 50, out);

                    imageView.setImageBitmap(bitmap);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            super.onActivityResult(requestCode, resultCode, data);

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public  void onSexClicked(View view){
        boolean sexChecked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.male:
                if (sexChecked){
                    sex = "Male";

                }
                break;
            case R.id.female:
                if(sexChecked){
                   sex = "Female";
                }
                break;
            case R.id.other:
                if (sexChecked){
                    sex = "Other";
                }
                break;
        }
    }
}