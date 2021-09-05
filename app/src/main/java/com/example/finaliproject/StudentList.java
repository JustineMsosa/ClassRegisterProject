package com.example.finaliproject;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.finaliproject.ClassRegisterProvider.StudentListAdapter;
import com.example.finaliproject.Model.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class  StudentList extends AppCompatActivity {

    GridView gridView;
    ArrayList<Student> list;
    StudentListAdapter adapter = null;

    FloatingActionButton fab, fab1, fab2, fab3;
    boolean isVisi;
    TextView text_student, text_student1, text_student2;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.students_list_activity);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);

        text_student = (TextView) findViewById(R.id.text_student);
        text_student1 = (TextView) findViewById(R.id.text_student1);
        text_student2 = (TextView) findViewById(R.id.text_student2);

        fab1.setVisibility(View.GONE);
        fab2.setVisibility(View.GONE);
        fab3.setVisibility(View.GONE);
        text_student.setVisibility(View.GONE);
        text_student1.setVisibility(View.GONE);
        text_student2.setVisibility(View.GONE);

        isVisi = false;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isVisi){
//                    android:src="@drawable/ic_baseline_fact_check_24"
                    fab.setImageResource(R.drawable.ic_baseline_cancel_24);

                    fab1.show();
                    fab2.show();
                    fab3.show();
                    text_student.setVisibility(View.VISIBLE);
                    text_student1.setVisibility(View.VISIBLE);
                    text_student2.setVisibility(View.VISIBLE);

                    isVisi = true;
                }else {
                    fab1.hide();
                    fab2.hide();
                    fab3.hide();
                    fab.setImageResource(R.drawable.ic_baseline_add_24);


                    text_student.setVisibility(View.GONE);
                    text_student1.setVisibility(View.GONE);
                    text_student2.setVisibility(View.GONE);
                    isVisi = false;
                }
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentList.this, MainActivity2.class));

            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(StudentList.this, ClassList.class));
            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentList.this, ClassRegister.class));
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Registered Students");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLUE));


        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new StudentListAdapter(this, R.layout.student_items, list);
        gridView.setAdapter(adapter);

        // get all data from sqlite
        Cursor cursor = MainActivity2.sqLiteHelper.getData("SELECT * FROM STUDENT");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String age = cursor.getString(2);
            byte[] image = cursor.getBlob(4);
            String present = cursor.getString(3);
            String sex = cursor.getString(5);
            String village = cursor.getString(6);
            Integer studentCode = cursor.getInt(7);

            list.add(new Student(id, name, "Age : "+age, present, image, sex, village, studentCode));

        }

        adapter.notifyDataSetChanged();

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                CharSequence[] items = {"Update", "Delete", "Present"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(StudentList.this);

                dialog.setTitle("Choose an action");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (item == 0) {
                            // updating student
                            Cursor c = MainActivity2.sqLiteHelper.getData("SELECT id FROM STUDENT");
                             ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            // show dialog update at here
                            showDialogUpdate(StudentList.this, arrID.get(position));


                        }
                        else if (item == 1){
                            // deleting student
                            Cursor c = MainActivity2.sqLiteHelper.getData("SELECT id FROM STUDENT");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            showDialogDelete(arrID.get(position));
                        }

                        else {

                            Cursor c = MainActivity2.sqLiteHelper.getData("SELECT id FROM STUDENT");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            ShowDialogPresent(StudentList.this,arrID.get(position));
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Cursor c = MainActivity2.sqLiteHelper.getData("SELECT id FROM STUDENT");
                ArrayList<Integer> arrID = new ArrayList<Integer>();
                while (c.moveToNext()){
                    arrID.add(c.getInt(0));
                }
                int j = arrID.get(position);

                Intent intent = new Intent(StudentList.this, StudentDetails.class);
                intent.putExtra(Intent.EXTRA_TEXT, ""+j);
                startActivity(intent);

            }
        });

        }


    private void ShowDialogPresent(Activity activity,final int position){
        final Dialog dialog = new Dialog(activity);
        dialog.setTitle("Mark Student as Present");
        dialog.setContentView(R.layout.present);
        // set width for dialog
        int width = (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.95);

        // set height for dialog
        int height = (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.2);
        dialog.getWindow().setLayout(width, height);
        dialog.show();

        final Button btn = (Button) dialog.findViewById(R.id.confirm);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                updateStudentPresentList(position);
                dateTimeConfiguration();
            }
        });
    }
    ImageView imageViewStudent;
    private void showDialogUpdate(Activity activity, final int  position){

            final Dialog dialog = new Dialog(activity);
            dialog.setContentView(R.layout.update_student_activity);
            dialog.setTitle("Update");

            imageViewStudent = (ImageView) dialog.findViewById(R.id.imageViewStudent);
            final TextView edtName = (TextView) dialog.findViewById(R.id.edtName);
            final TextView edtAge = (TextView) dialog.findViewById(R.id.edtAge);
            Button btnUpdate = (Button) dialog.findViewById(R.id.btnUpdate);

        Cursor cursor = MainActivity2.sqLiteHelper.getData("SELECT * FROM STUDENT");
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            if (id == position){
                String name = cursor.getString(1);
                int id2 = cursor.getInt(0);
                String age = cursor.getString(2);
                String present = cursor.getString(3);
                byte[] image = cursor.getBlob(4);
                String sex = cursor.getString(5);

                edtName.setText(name);
                edtAge.setText(age);
                imageViewStudent.setImageBitmap( BitmapFactory.decodeByteArray(image, 0 , image.length));
            }
        }
        adapter.notifyDataSetChanged();

            // set width for dialog
            int width = (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.95);

            // set height for dialog
            int height = (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.7);
            dialog.getWindow().setLayout(width, height);
            dialog.show();

            //Image functionality
            imageViewStudent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // request photo library
                    ActivityCompat.requestPermissions(
                            StudentList.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            888
                    );
                }
            });
            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cursor cursor = MainActivity2.sqLiteHelper.getData("SELECT * FROM STUDENT");
                    while (cursor.moveToNext()) {
                        int id = cursor.getInt(0);
                        String sex = cursor.getString(5);
                        String village = cursor.getString(6);
                        Integer studentCode = cursor.getInt(7);
                        if (id == position){
                            String present = cursor.getString(3);
                            try {
                                MainActivity2.sqLiteHelper.updateData(
                                        edtName.getText().toString().trim(),
                                        edtAge.getText().toString().trim(),
                                        present,
                                        MainActivity2.imageViewToByte(imageViewStudent), sex, village, studentCode,
                                        position
                                );
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), "Update successfully!!!",Toast.LENGTH_SHORT).show();
                            }
                            catch (Exception error) {
                                Log.e("Update error", error.getMessage());
                            }
                            updateStudentList();
                        }
                    }
                }
            });

        }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//
//        Log.w("myApp", "onCreateOptionsMenu -started- ");
//
//        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
//        MenuItem menuItem = menu.findItem(R.id.item_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
//
//        searchView.setSearchableInfo( searchManager.getSearchableInfo(getComponentName()));
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
//
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return true;
//            }
//        });
//         return true;
//
//
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_search){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void dateTimeConfiguration(){
        String date = DateFormat.getDateInstance().format(new Date());
        String time = DateFormat.getTimeInstance().format(new Date());
        Toast.makeText(getApplicationContext(), "Student Marked as Present on, Date: "+date+" Time: "+time,Toast.LENGTH_LONG).show();
    }

    private void showDialogDelete(final int idStudent){
        final AlertDialog.Builder dialogDelete = new AlertDialog.Builder(StudentList.this);

        dialogDelete.setTitle("Warning!!");
        dialogDelete.setMessage("Are you sure you want to delete the selected student?");
        dialogDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    MainActivity2.sqLiteHelper.deleteData(idStudent);
                    Toast.makeText(getApplicationContext(), "Delete successfully!!!",Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Log.e("error", e.getMessage());
                }
                updateStudentList();
            }
        });

        dialogDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogDelete.show();
    }

    private void updateStudentList(){
        // get all data from sqlite
        Cursor cursor = MainActivity2.sqLiteHelper.getData("SELECT * FROM STUDENT");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String age = cursor.getString(2);
            byte[] image = cursor.getBlob(4);
            String present = cursor.getString(3);
            String sex = cursor.getString(5);
            String village = cursor.getString(6);
            Integer studentCode = cursor.getInt(7);

            list.add(new Student(id, name, "Age : "+age, present, image, sex, village, studentCode));
        }
        adapter.notifyDataSetChanged();
    }

    private void updateStudentPresentList(final int position1){
        // get all data from sqlite
        Cursor cursor = MainActivity2.sqLiteHelper.getData("SELECT * FROM STUDENT");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String age = cursor.getString(2);
            String present = cursor.getString(3);
            byte[] image = cursor.getBlob(4);
            String sex = cursor.getString(5);
            String village = cursor.getString(6);
            Integer studentCode = cursor.getInt(7);
                if (id == position1){
                    int presentUpdate = 1 + Integer.parseInt(present);
                    String p = String.format("%s", presentUpdate);

                    MainActivity2.sqLiteHelper.updateData(
                            name,
                            age,
                            p,
                            image, sex, village, studentCode,
                            id
                    );


                    list.add(new Student(id, name, "Age : "+age, p, image, sex, village, studentCode));
                     }
                else {

                    list.add(new Student(id, name, "Age : "+age, present, image, sex, village, studentCode));
                }
        }
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 888){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 888);
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

        if(requestCode == 888 && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageViewStudent.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


}
