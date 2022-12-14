package com.training.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
    import java.util.Scanner;
    public class Insertrecord {

        static String USER_NAME;
        static int USER_PASSWORD;
        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/infinite";

            String name = "root";
            String password = "suyash123";;
            Connection com = null;
            Scanner keyboardInput=new Scanner(System.in);
            PreparedStatement pstmt = null;
            String query = "INSERT INTO USER(USER_NAME,USER_PASSWORD)" + "VALUES (?, ? )";
            try {
                com = DriverManager.getConnection(url,name,  password);
                input(keyboardInput);
                pstmt = com.prepareStatement(query);

                pstmt.setString(1,USER_NAME );
                pstmt.setInt(2, USER_PASSWORD);
                int status = pstmt.executeUpdate();
                if(status > 0) {
                    System.out.println("Record is inserted successfully !!!");
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        public static void input(Scanner keyboardInput) {

            System.out.println("Enter the user:");
            USER_NAME = keyboardInput.next();
            System.out.println("Enter the password:");
            USER_PASSWORD = keyboardInput.nextInt();

        }

}
