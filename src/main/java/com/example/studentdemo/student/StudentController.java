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
    public void StudentSelect() throws SQLException {

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

    @PostMapping("/insert")
    public void StudentInsert(@RequestBody Student student) throws Exception{
        DBConnect dbConnect = new DBConnect();
        Connection connection = dbConnect.connect();

        StudentDao studentDao = new StudentDao(connection);

        Student student1 = new Student(student.getStd_id(),student.getStd_fname(),student.getStd_lname()
                ,student.getStd_major(),student.getStd_gpa(),false);
        studentDao.add(student1);

        connection.close();
    }

    @PutMapping("/update")
    public void StudentUpdate(@RequestBody Student student){
        

    }

    @DeleteMapping("/delete")
    public void StudentDelete(@RequestBody Student student){

    }


}
