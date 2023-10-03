package net.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {

    public static void main(String args[]){
        String url = "jdbc:mysql://localhost:3306/missioneats";
        String username = "root";
        String password = "password";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database");
        }
        catch (SQLException e){
            System.out.println("Oops, error!");
            e.printStackTrace();
        }
    }

}
