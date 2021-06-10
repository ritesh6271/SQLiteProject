package com.example.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqliteproject.Adapters.MyAdapter;
import com.example.sqliteproject.Model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText editName,editRollNo,editAddress;
    Button btnAddStudent;
    ListView listView1;

    ArrayList<Student> arrayList;
    ArrayAdapter arrayAdapter;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //arrayList = myDb.getAllText();
        //arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
        //listView.setAdapter(arrayAdapter);

        editName = (EditText)findViewById(R.id.edtUsername);
        editRollNo = (EditText)findViewById(R.id.edtRollNo);
        editAddress = (EditText)findViewById(R.id.edtAddress);
        btnAddStudent = (Button)findViewById(R.id.addStudent);
        listView1 = (ListView)findViewById(R.id.listView);
        databaseHelper = new DatabaseHelper(this);
        arrayList = new ArrayList<>();
        loadDataInListView();
        AddData();

    }

    private void loadDataInListView() {
        arrayList = databaseHelper.getAllData();
        myAdapter = new MyAdapter(this,arrayList);
        listView1.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    public void AddData(){
        btnAddStudent.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = databaseHelper.insertData(editName.getText().toString(),editRollNo.getText().toString(),editAddress.getText().toString());
                        if(isInserted = true)
                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        //arrayList.clear();
                        //arrayList.addAll(databaseHelper.getAllText());
                        //arrayAdapter.notifyDataSetChanged();
                        //listView.invalidateViews();
                        //listView.refreshDrawableState();
                        else
                            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
