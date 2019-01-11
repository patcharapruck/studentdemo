package com.example.studentdemo.student;

import java.util.ArrayList;

public class Student {


    public Student(){

    }

    private ArrayList<String> Data;
    private Long id;
    private String std_id;
    private String std_fname;
    private String std_lname;
    private String std_major;
    private float std_gpa;
    public Boolean std_del = false;

    public Student(String std_id, String std_fname, String std_lname
            , String std_major, float std_gpa, Boolean std_del){

        this.id = id;
        this.std_id = std_id;
        this.std_fname = std_fname;
        this.std_lname = std_lname;
        this.std_major = std_major;
        this.std_gpa = std_gpa;
        this.std_del = std_del;
    }

    public Long getId(){
        return id;
    }
    public String getStd_id(){ return std_id; }
    public String getStd_fname(){
        return std_fname;
    }
    public String getStd_lname(){
        return std_lname;
    }
    public String getStd_major(){
        return std_major;
    }
    public float getStd_gpa(){
        return std_gpa;
    }
    public Boolean getStd_del(){
        return std_del;
    }
    public ArrayList<String> getData(){ return Data; }



    public void setId(Long id){ this.id = id; }
    public void setStd_id(String std_id){
        this.std_id = std_id;
    }
    public void setStd_fname(String std_fname){
        this.std_fname = std_fname;
    }
    public void setStd_lname(String std_lname){
        this.std_lname = std_lname;
    }
    public void setStd_major(String std_major){
        this.std_major = std_major;
    }
    public void setStd_gpa(float std_gpa){
        this.std_gpa = std_gpa;
    }
    public void setStd_del(Boolean std_del){ this.std_del = std_del; }
    public void setData(ArrayList<String> data){ this.Data = data; }
}
