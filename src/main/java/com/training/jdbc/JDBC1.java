package com.training.jdbc;
import java.util.Scanner;
import java.sql.*;

public class JDBC1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/infinite";
        String user = "root";
        String password = "suyash123";


        Connection com = DriverManager.getConnection(url, user, password);

        Statement stmt = com.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user");

        boolean namematch = false;
        boolean usermatch = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        String uname=sc.next();
        System.out.println("Enter password");
        String pass=sc.next();
        while (rs.next()) {
            if (rs.getString(1).equals(uname)) {
                namematch = true;
            }

        if (rs.getString(2).equals(pass)) {
            usermatch = true;

        }
        }

        if((namematch && usermatch)){
            System.out.println("Logged Sucess");

        } else {
            System.out.println("Incorrect Credential");
        }

    }
}
