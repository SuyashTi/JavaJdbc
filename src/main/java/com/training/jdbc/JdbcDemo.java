package com.training.jdbc;

import java.sql.*;

public class JdbcDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException  {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/infinite";
        String user = "root";
        String password = "suyash123";


        Connection com = DriverManager.getConnection(url, user, password);

        Statement stmt = com.createStatement();
        ResultSet rs = stmt.executeQuery("select * from product");

        while(rs.next()){
            System.out.println(rs.getInt(1)+":"+ rs.getString(3));
        }


        }


    }



