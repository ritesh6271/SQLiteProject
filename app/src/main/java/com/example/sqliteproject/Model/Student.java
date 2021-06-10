package com.example.sqliteproject.Model;

public class Student {
    String name,roll_no,address;

    public Student(String name, String roll_no, String address) {
        this.name = name;
        this.roll_no = roll_no;
        this.address = address;
    }
    public Student(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
