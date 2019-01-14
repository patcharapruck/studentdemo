package com.example.studentdemo.student;


import com.example.studentdemo.DB.DBConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    StudentService studentService;


    @GetMapping("/select")
    public ArrayList<String> StudentSelect() throws SQLException {

        DBConnect dbConnect = new DBConnect();
        Connection connection = dbConnect.connect();
        StudentDto studentDto = new StudentDto(connection);
        ArrayList<Student> students = studentDto.findAll();
        ArrayList<String> strings = new ArrayList<>();

        String row;
        for(Student student:students){
            row = student.getId()+"|"+student.getStd_id()+"|"
                    +student.getStd_fname()+"|"+student.getStd_lname()+"|"
                    +student.getStd_major()+"|"+student.getStd_gpa();
            strings.add(row);
        }

        connection.close();

        return strings;
    }

    @PostMapping("/insert")
    public String StudentInsert(@RequestBody Student student) throws Exception{
        DBConnect dbConnect = new DBConnect();
        Connection connection = dbConnect.connect();
        Boolean checkked;
        String send="Insert Fail";

        StudentDto studentDto = new StudentDto(connection);

        Student student1 = new Student(student.getStd_id()
        );
        checkked = studentDto.add(student1);

        if (checkked){
            send = "Inset Complete!!";
        }
        connection.close();

        return send;
    }

    @PutMapping("/update")
    public void StudentUpdate(@RequestBody Student student) throws Exception{

        DBConnect db = new DBConnect();
        Connection conn = db.connect();
        StudentDto studentDto = new StudentDto(conn);

        Student student1;
        student1 = new Student(student.getStd_id()
        );
        studentDto.edit(student1);

        conn.close();

    }

    @DeleteMapping("/delete")
    public void StudentDelete(@RequestBody Student student) throws Exception{
        DBConnect dbConnect = new DBConnect();
        Connection connection = dbConnect.connect();
        StudentDto studentDto = new StudentDto(connection);

        Student studentl = new Student(student.getStd_id());
        studentDto.delete(studentl);

        connection.close();
    }

//    @PostMapping("/search")
//    public ArrayList<String> StudentSearch(@RequestBody Student student) throws Exception{
//        DBConnect dbConnect = new DBConnect();
//        Connection connection = dbConnect.connect();
//
//
//    }
}
