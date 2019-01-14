package com.example.studentdemo.student;

import com.example.studentdemo.DB.DBConnect;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;

public class StudentDtoTest {

    @Test
    public void findAll() throws Exception {
        DBConnect dbConnect = new DBConnect();
        Connection connection = dbConnect.connect();

        StudentDto studentDto = new StudentDto(connection);

        ArrayList<Student> students = studentDto.findAll();

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

        StudentDto studentDto = new StudentDto(connection);
        Student student = new Student("ABC-000003");
        studentDto.add(student);

        connection.close();
    }

    @Test
    public void edit() throws Exception{
        DBConnect dbConnect = new DBConnect();
        Connection connection = dbConnect.connect();

        StudentDto studentDto = new StudentDto(connection);
        Student student = new Student("ABC-000003");
        studentDto.edit(student);

        connection.close();
    }

    @Test
    public void delete() throws Exception{
        DBConnect dbConnect = new DBConnect();
        Connection connection = dbConnect.connect();

        StudentDto studentDto = new StudentDto(connection);
        Student student = new Student("ABC-000002");
        studentDto.delete(student);

        connection.close();
    }
}