package net.test;

import java.sql.*;
import java.util.*;

public class test {
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/missioneats";
        String username = "root";
        String password = "password";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            /*
            String sql = "INSERT INTO student (first_name, last_name, age, email) VALUES('emily','howards', 16,'ehowards@school.edu');";

            PreparedStatement statement = connection.prepareStatement(sql);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A row has been inserted.");
            }
            statement.close();
            connection.close();
            */
            String sql = "select * from student;";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                System.out.println(result.getString(2));
            }
            connection.close();

        } catch (SQLException e) {
            System.out.println("Oops, error!");
            e.printStackTrace();
        }
    }
}

