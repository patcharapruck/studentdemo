package com.example.studentdemo.student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDao {

    Connection conn;

    public StudentDao(Connection connection){
        this.conn = connection;
    }

    public ArrayList<Student> findAll() throws SQLException{

        ArrayList<Student> students = new ArrayList<>();
        Student student = null;

        Statement statement = conn.createStatement();
        String sqlText = "SELECT * FROM student";
        ResultSet resultSet = statement.executeQuery(sqlText);

        while (resultSet.next()){
            student = new Student();
            student.setId(resultSet.getLong("id"));
            student.setStd_id(resultSet.getString("std_id"));
            student.setStd_fname(resultSet.getString("std_fname"));
            student.setStd_lname(resultSet.getString("std_lname"));
            student.setStd_major(resultSet.getString("std_major"));
            student.setStd_gpa(resultSet.getFloat("std_gpa"));

            students.add(student);
        }

        resultSet.close();
        statement.close();

        return students;
    }

    public boolean add(Student student) throws SQLException{
        boolean addResult = false;
        Student newStd = student;

        String sqlText = "INSERT INTO student(std_id, std_fname, std_lname, std_major, std_gpa, std_del) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = this.conn.prepareStatement(sqlText);
        preparedStatement.setString(1,newStd.getStd_id());
        preparedStatement.setString(2,newStd.getStd_fname());
        preparedStatement.setString(3,newStd.getStd_lname());
        preparedStatement.setString(4,newStd.getStd_major());
        preparedStatement.setFloat(5,newStd.getStd_gpa());
        preparedStatement.setBoolean(6,newStd.getStd_del());

        if (preparedStatement.executeUpdate() == 1){
            addResult = true;
        }

        preparedStatement.close();
        return addResult;
    }

}
