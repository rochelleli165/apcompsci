package net.MissionEats;

import java.sql.*;
import java.util.*;

public class main
{

    public static void main(String args[]) throws Exception
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        Scanner pencil = new Scanner(System.in);
        System.out.println("Welcome to MissionEats! Are you a driver or customer?");
        System.out.println("1. Driver 2. Customer");

        int consumer;
        consumer = pencil.nextInt();
        pencil.nextLine();


        if (consumer == 1) //Driver
        {
            System.out.println("Are you here to set up an account or check your commissions?");
            System.out.println("1. Set up account 2. Check commissions.");

            int choice = pencil.nextInt();
            pencil.nextLine();

            if (choice == 1) {

                System.out.println("Welcome to MissionEat's community of drivers! To get started with your commission, please answer these questions below.");

                System.out.println("What is your name?");
                String name = pencil.nextLine();

                System.out.println("What grade are you in?");
                int grade = pencil.nextInt();
                pencil.nextLine();

                System.out.println("What is the max # of orders/customers you would be willing to take (in one lunch period)");
                int maxOrders = pencil.nextInt();
                pencil.nextLine();

                System.out.println("How much do you charge for commission?");
                double commission = pencil.nextDouble();
                pencil.nextLine();

                System.out.println("Finally, where are you going for lunch?");
                String restaurantName = pencil.nextLine();

                driver x = new driver(name, grade, maxOrders, restaurantName, commission);
                add_driver(x);

                System.out.println("Thank you for registering! Check back before lunch to see your commissions :");

            }
            else if(choice == 2){
                System.out.println("Enter your name");
                String name = pencil.nextLine();
                System.out.println("Here are your current clients: ");

                System.out.println("Rochelle : Passion Fruit Tea 50/50");
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/missioneats", "root", "1234wxyz");

                    statement = connection.createStatement();

                    resultSet = statement.executeQuery("SELECT * FROM customers WHERE customer_driver = \'" + name + " \'");
                    while (resultSet.next()) {
                        System.out.println("Name: " + resultSet.getString(2) + " Order: " + resultSet.getString(5));
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

        if (consumer == 2) //Customer
        {
            System.out.println("Welcome to MissionEats, an experience you can savor! To get started with your order, please answer these questions below.");

            System.out.println("What is your name");
            String name;
            name = pencil.nextLine();
            System.out.println("What grade are you in?");
            int grade = pencil.nextInt();
            pencil.nextLine();


            System.out.println("Welcome, " + name + " ! Here are the available drivers for today.");

            //prints all current drivers in array list
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/missioneats", "root", "1234wxyz");

                statement = connection.createStatement();

                resultSet = statement.executeQuery("select * from drivers");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + ". Name: " + resultSet.getString(2) + " Slots Open: " + resultSet.getString(4) + " Location: " + resultSet.getString(5) + " Commission Price: " + resultSet.getString(6));
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

            //ex: {1. Angela, McDonalds, 3 comissions 2. Blake, Poke House, 2 commissions}

            System.out.println("Would you like to choose a driver? Enter the number.");
            int driverNumber = pencil.nextInt();
            pencil.nextLine();

                //selects a driver and checks for slots open
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/missioneats", "root", "1234wxyz");

                    statement = connection.createStatement();

                    resultSet = statement.executeQuery("select * from `missioneats`.`drivers` WHERE driver_id = " + driverNumber + ";");
                    resultSet.next();
                    int driverSlots = resultSet.getInt(4);
                    String driverName = resultSet.getString(2);

                    if (driverSlots <= 0)
                    {
                        System.out.println("Choose another person.");
                    }

                    //driver chosen, sets new customer in table, updates driver slot numbers
                    else
                    {
                        System.out.println("What do you want to order?");
                        String order = pencil.nextLine();
                        customer x = new customer(name, grade, driverName, order);
                        driverSlots -= 1;

                        try {
                            System.out.println("Driver chosen");
                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/missioneats", "root", "1234wxyz");

                            statement = connection.createStatement();

                            String customer = "INSERT INTO `missioneats`.`customers` (customer_name, customer_grade, customer_driver, customer_food_item) \n" +
                                    "VALUES\n" +
                                    "(\"" + name + "\", " + grade + ", \"" + driverName + "\", \"" + order + "\" );";

                            statement.executeUpdate(customer);
                            statement.executeUpdate("UPDATE `missioneats`.`drivers` SET `driver_slots_open` = " + driverSlots + " WHERE driver_id = " + driverNumber + ";");
                        } catch (SQLException ex) {
                            System.out.println("Exception: " + ex);
                        } finally {
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

                } catch (SQLException ex) {
                    System.out.println("Exception: " + ex);
                } finally {
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

    public static void add_driver(driver x) throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/missioneats", "root", "1234wxyz"); //change password and username

            statement = connection.createStatement();

            String sql = "INSERT INTO `missioneats`.`drivers` (driver_name, driver_grade, driver_slots_open, driver_location, driver_commission) \n" +
                    "VALUES\n" +
                    "(\"" + x.getName() + "\", " + x.getGrade() + ", " + x.getSlotsOpen() + ", \"" + x.getLocation() + "\", " + x.getCommission() + ");";

            statement.executeUpdate(sql);

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