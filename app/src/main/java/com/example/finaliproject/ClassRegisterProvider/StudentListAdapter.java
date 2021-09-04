package com.example.finaliproject.ClassRegisterProvider;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finaliproject.R;
import com.example.finaliproject.Model.Student;

import java.util.ArrayList;

public class StudentListAdapter extends BaseAdapter implements Filterable {

    private Context context;
    private  int layout;
    private ArrayList<Student> studentList;
    private ArrayList<Student> studentListFilter;

    public StudentListAdapter(Context context, int layout, ArrayList<Student> studentList) {
        this.context = context;
        this.layout = layout;
        this.studentList = studentList;
        studentListFilter = studentList;
    }

    @Override
    public int getCount() {
        return studentListFilter.size();
    }

    @Override
    public Object getItem(int position) {
        return studentListFilter.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){
                    filterResults.count = studentListFilter.size();
                    filterResults.values = studentListFilter;
                }
                else {
                    String searchStr = constraint.toString().toLowerCase();
                    ArrayList<Student> resultData = new ArrayList<>();
                    for(Student student:studentListFilter){
                        if(student.getName().contains(searchStr) || student.getAge().contains(searchStr)){
                            resultData.add(student);
                        }
                        filterResults.count = resultData.size();
                        filterResults.values = resultData;
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        };
        return filter;
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

        Student student = studentListFilter.get(position);

        holder.txtName.setText(student.getName());
        holder.txtAge.setText(student.getAge());

        byte[] studentImage = student.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(studentImage, 0, studentImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;

    }

}
