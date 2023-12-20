package Repository;

import Controller.Booking;

import javax.sound.midi.Soundbank;
import java.awt.print.Book;
import java.sql.*;
import java.util.Scanner;

public class Customer_DB {
    public static void main(String[] args) {

    }

    public static void addCustomerDB(String url, String userName, String Password) {
        try {

            Connection connection = DriverManager.getConnection(url, userName, Password);
            Scanner Sc = new Scanner(System.in);
            System.out.println("Enter the Customer ID");
            Integer customer_id = Sc.nextInt();
            Sc.nextLine();
            System.out.println("Enter the Customer Name");
            String customer_name = Sc.nextLine();
            System.out.println("Enter the Customer address");
            String customer_address = Sc.nextLine();
            System.out.println("Enter the Phone Number");
            String phone_no = Sc.nextLine();
            String insertQuery = "INSERT INTO CUSTOMER VALUES (?, ? , ? , ?)";
            Statement statement = connection.createStatement();
            PreparedStatement insertData = connection.prepareStatement(insertQuery);
            insertData.setInt(1, customer_id);
            insertData.setString(2, customer_name);
            insertData.setString(3, customer_address);
            insertData.setString(4, phone_no);
            PKG_DB.Check_Data(url, userName, Password);
            int pkg_id;
            while (true) {
                System.out.println("Please Select Valid PKG ID between 1 to 5");
                pkg_id = Sc.nextInt();
                Sc.nextLine(); 
                if (pkg_id <= 5 && pkg_id >= 1) {
                    break;
                } else {
                    System.out.println("Wrong ID Plz enter right one");
                }
            }
            int num = insertData.executeUpdate();
            Booking_DB.bookCustomer(url, userName, Password, customer_id, pkg_id);
            if (num > 0) {
                System.out.println("Value Insert SucessFully...!");
            } else {
                System.out.println("Vale is Not Insert");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Booking.display();
    }
    public static void updateCustomerName(String url, String userName, String Password,
                                          String name, Integer id) {
        try {

            String Name = name;
            Integer Id = id;
            Connection connection = DriverManager.getConnection(url, userName, Password);
            Statement statement = connection.createStatement();
            String insertQuery = "UPDATE CUSTOMER SET Customer_Name = ? WHERE Customer_Id = ?;";
            PreparedStatement UpdateStatement = connection.prepareStatement(insertQuery);
            UpdateStatement.setString(1, name);
            UpdateStatement.setInt(2, id);
            int num = UpdateStatement.executeUpdate();
            if (num > 0) {
                System.out.println("Value Update SucessFully...!");
            } else {
                System.out.println("Vale is Not Updated");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Booking.display();
    }

    public static void updateCustomerAddress(String url, String userName, String Password,
                                             String name, Integer id) {
        try {

            String Name = name;
            Integer Id = id;
            Connection connection = DriverManager.getConnection(url, userName, Password);
            Statement statement = connection.createStatement();
            String insertQuery = "UPDATE CUSTOMER SET Customer_Address = ? WHERE Customer_Id = ?;";
            PreparedStatement UpdateStatement = connection.prepareStatement(insertQuery);
            UpdateStatement.setString(1, name);
            UpdateStatement.setInt(2, id);
            int num = UpdateStatement.executeUpdate();
            if (num > 0) {
                System.out.println("Value Update SucessFully...!");
            } else {
                System.out.println("Vale is Not Updated");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Booking.display();
    }

    public static void updateCustomerPhoneNo(String url, String userName, String Password,
                                             String name, Integer id) {
        try {

            String Name = name;
            Integer Id = id;
            Connection connection = DriverManager.getConnection(url, userName, Password);
            Statement statement = connection.createStatement();
            String insertQuery = "UPDATE CUSTOMER SET ContactNo = ? WHERE Customer_Id = ?;";
            PreparedStatement UpdateStatement = connection.prepareStatement(insertQuery);
            UpdateStatement.setString(1, name);
            UpdateStatement.setInt(2, id);
            int num = UpdateStatement.executeUpdate();
            if (num > 0) {
                System.out.println("Value Update SucessFully...!");
            } else {
                System.out.println("Vale is Not Updated");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Booking.display();
    }

    public static void updateCustomerPKG(String url, String userName, String Password,
                                         Integer name, Integer id) {
        try {

            Integer Name = name;
            Integer Id = id;
            Connection connection = DriverManager.getConnection(url, userName, Password);
            Statement statement = connection.createStatement();
            System.out.println();
            String insertQuery = "UPDATE bookcustomer SET pkg_id = ? WHERE Customer_Id = ?;";
            PreparedStatement UpdateStatement = connection.prepareStatement(insertQuery);
            UpdateStatement.setInt(1, name);
            UpdateStatement.setInt(2, id);
            int num = UpdateStatement.executeUpdate();
            if (num > 0) {
                System.out.println("Value Update SucessFully...!");
            } else {
                System.out.println("Vale is Not Updated");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Booking.display();
    }

    public static void deleteCutomerDB(String url, String UserName, String Password, Integer id) {
        try {

            Integer Id = id;
            Connection connection = DriverManager.getConnection(url, UserName, Password);
            Statement statement = connection.createStatement();
            System.out.println();
            String insertQuery = "DELETE FROM CUSTOMER WHERE Customer_Id = ?";
            String insertQuery1 = "DELETE FROM bookcustomer WHERE Booking_Id = ?";
            PreparedStatement UpdateStatement = connection.prepareStatement(insertQuery);
            PreparedStatement UpdateStatement1 = connection.prepareStatement(insertQuery1);

            UpdateStatement.setInt(1, id);
            UpdateStatement1.setInt(1,id);
            int num = UpdateStatement.executeUpdate();
            int num2 = UpdateStatement1.executeUpdate();

            if (num > 0) {
                System.out.println("Customer Deleted SucessFully...!");
            } else {
                System.out.println("Customer is Not Deleted");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Booking.display();
    }

}

