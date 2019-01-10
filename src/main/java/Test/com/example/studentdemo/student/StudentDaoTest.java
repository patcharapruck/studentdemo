package com.example.studentdemo.student;

import com.example.studentdemo.DB.DBConnect;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentDaoTest {

    @Test
    public void findAll() throws Exception {
        DBConnect dbConnect = new DBConnect();
        Connection connection = dbConnect.connect();

        StudentDao studentDao = new StudentDao(connection);

        ArrayList<Student> students = studentDao.findAll();

        for(Student student:students){
            System.out.println(student.getId()+"|"+student.getStd_id()+"|"
                            +student.getStd_fname()+"|"+student.getStd_lname()+"|"
                            +student.getStd_major()+"|"+student.getStd_gpa());
        }

        connection.close();
    }

    @Test
    public void add() throws Exception{
        DBConnect dbConnect = new DBConnect();
        Connection connection = dbConnect.connect();

        StudentDao studentDao = new StudentDao(connection);
        Student student = new Student("ABC-000003","patcharapruck","Sukjindastane","CS",2.65f,false);
        studentDao.add(student);

        connection.close();
    }
}