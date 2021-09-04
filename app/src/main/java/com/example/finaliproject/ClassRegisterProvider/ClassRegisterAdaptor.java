package com.example.finaliproject.ClassRegisterProvider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finaliproject.R;
import com.example.finaliproject.Model.Student;

import java.util.ArrayList;

public class ClassRegisterAdaptor extends RecyclerView.Adapter<ClassRegisterAdaptor.ViewHolder> {
    Context context;
    ArrayList<Student> students;

    public ClassRegisterAdaptor(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.class_register_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ClassRegisterAdaptor.ViewHolder holder, int position) {
        holder.name.setText(students.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        Spinner presentAbsent;
       public ViewHolder(@NonNull View itemView) {
           super(itemView);

           name = itemView.findViewById(R.id.student_name);
           presentAbsent = itemView.findViewById(R.id.present_absent_id);
       }
   }
}
