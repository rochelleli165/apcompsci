package net.MissionEats;

import java.sql.*;

public class MyJDBC {

    public static void main(String args[]) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/missioneats", "root", "1234wxyz");

            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from drivers");
            while (resultSet.next()) {
                System.out.println("driver_id: " + resultSet.getString(1) + ", driver_name: " + resultSet.getString(2));
            }
        }
        catch (SQLException ex){
            System.out.println("Exception: " + ex);
        }
        finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

}
