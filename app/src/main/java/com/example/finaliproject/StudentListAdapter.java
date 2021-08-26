package com.example.finaliproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Student> studentList;

    public StudentListAdapter(Context context, int layout, ArrayList<Student> studentList) {
        this.context = context;
        this.layout = layout;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtAge;
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = new ViewHolder();

        if (row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtAge = (TextView) row.findViewById(R.id.txtAge);
            holder.imageView = (ImageView) row.findViewById(R.id.imgStudent);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

                Student student = studentList.get(position);

        holder.txtName.setText(student.getName());
        holder.txtAge.setText(student.getAge());

        byte[] studentImage = student.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(studentImage, 0, studentImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;

    }

}
