package com.example.sqliteproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sqliteproject.Model.Student;
import com.example.sqliteproject.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Student> arrayList;
    public MyAdapter(Context context,ArrayList<Student> arrayList){
        this.context=context;
        this.arrayList = arrayList;
    }
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.mycustomlistview,null);
            TextView t1_name = (TextView)view.findViewById(R.id.name_txt);
            TextView t2_rollNo = (TextView)view.findViewById(R.id.rollNo_txt);
            TextView t3_address = (TextView)view.findViewById(R.id.address_txt);

            Student student = arrayList.get(i);

            t1_name.setText(student.getName());
            t2_rollNo.setText(student.getRoll_no());
            t3_address.setText(student.getAddress());

        return view;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }
}
