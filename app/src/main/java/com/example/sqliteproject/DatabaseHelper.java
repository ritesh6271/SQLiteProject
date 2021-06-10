package com.example.sqliteproject;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sqliteproject.Model.Student;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";

    public static final String COL_1 = "NAME";
    public static final String COL_2 = "ROLL_NO";
    public static final String COL_3 = "ADDRESS";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TABLE_NAME +" (NAME TEXT,ROLL_NO INTEGER NOT NULL,ADDRESS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name,String roll_no,String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,roll_no);
        contentValues.put(COL_3,address);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    //public ArrayList getAllText(){
        //SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //ArrayList<String> arrayList = new ArrayList<String>();
        //Cursor cursor = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        //cursor.moveToFirst();
        //while (!cursor.isAfterLast()){
            //arrayList.add(cursor.getString(cursor.getColumnIndex("txt")));
            //cursor.moveToNext();
        //}
        //return arrayList;
    //}

    @SuppressLint("Recycle")
    public ArrayList<Student> getAllData(){
        ArrayList<Student> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM student_table", null);
        while (cursor.moveToNext()){
            String name = cursor.getString(0);
            String rollNo = cursor.getString(1);
            String address = cursor.getString(2);

            Student student = new Student(name,rollNo,address);

            arrayList.add(student);
        }

        return arrayList;
    }


}
