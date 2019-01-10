package com.example.studentdemo.DB;

import org.junit.Test;

import static org.junit.Assert.*;

public class DBConnectTest {

    @Test
    public void connect() throws Exception {
        DBConnect dbConnect = new DBConnect();
        dbConnect.connect();
    }
}