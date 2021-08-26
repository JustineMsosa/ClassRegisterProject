package com.example.finaliproject.ClassListProvider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finaliproject.R;
import com.example.finaliproject.Student;

import java.util.ArrayList;

public class ClassListAdaptor extends RecyclerView.Adapter<com.example.finaliproject.ClassListProvider.ClassListAdaptor.ViewHolder> {
    Context context;
    ArrayList<Student> students;

    public ClassListAdaptor(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public com.example.finaliproject.ClassListProvider.ClassListAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.class_list_model, parent, false);
        return new com.example.finaliproject.ClassListProvider.ClassListAdaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  com.example.finaliproject.ClassListProvider.ClassListAdaptor.ViewHolder holder, int position) {
        holder.name.setText(students.get(position).getName());
        holder.age.setText(students.get(position).getAge());
        holder.sex.setText(students.get(position).getSex());
    }


    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView age;
        TextView sex;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.student_full_name);
            age = itemView.findViewById(R.id.student_age);
            sex = itemView.findViewById(R.id.student_sex);
        }
    }
}
