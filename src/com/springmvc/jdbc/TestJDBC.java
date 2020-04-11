package com.springmvc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {


    public static void main(String[] args) {

        String connectionURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String  user = "hbstudent";
        String pass = "hbstudent";

        try{
            System.out.println("Connecting to database: " + connectionURL);

            Connection myConn = DriverManager.getConnection(connectionURL, user, pass);

            System.out.println("Connection Successfull");


        }
        catch (Exception exc){
            exc.printStackTrace();

        }

    }

}
