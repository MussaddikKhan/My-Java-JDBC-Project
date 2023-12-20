package Controller;

import Repository.Customer_DB;
import Repository.PKG_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;     
import java.sql.Statement;
import java.util.Scanner;

public class Customer {
    public static String url = "jdbc:mysql://localhost:3306/tours_and_travels";
    public static String userName = "root";
    public static String Password = "Musa123";

    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Reflection approach
            String jdbcUrl = "jdbc:mysql://localhost:3306/"; // URL to your database server
            String username = "root";
            String password = "Musa123";
            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connection Success" + con);

            Statement stm = con.createStatement();
//            String CreateDB = "CREATE DATABASE IF NOT EXISTS tours_and_travels";

            String CreateTable1 = "CREATE TABLE IF NOT EXISTS customer (Customer_Id int NOT NULL, Customer_Name varchar(255) DEFAULT NULL, Customer_Address varchar(255) DEFAULT NULL, ContactNo varchar(50) DEFAULT NULL, PRIMARY KEY (Customer_Id)); ";

            String CreateTable2 = "CREATE TABLE IF NOT EXISTS pkg (Pkg_Id int NOT NULL, Pkg_Name varchar(255) NOT NULL, Destination varchar(255) DEFAULT NULL, Price int DEFAULT NULL, Member int DEFAULT NULL, PRIMARY KEY (Pkg_Id))";

            String CreateTable3 = "CREATE TABLE IF NOT EXISTS bookcustomer (Booking_ID int NOT NULL, Customer_Id int DEFAULT NULL, pkg_id int DEFAULT NULL, PRIMARY KEY (Booking_ID));";

//            stm.executeUpdate(CreateDB);
            stm.executeUpdate(CreateTable1);
            stm.executeUpdate(CreateTable2);
            stm.executeUpdate(CreateTable3);
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        url = "jdbc:mysql://localhost:3306/tours_and_travels";

    }

    public static void add_Customer() {

        Customer_DB.addCustomerDB(url, userName, Password);
    }

    public static void updateCustomer() {
        int ch;
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Update Customer Name");
        System.out.println("2.Update Customer Address");
        System.out.println("3.Update Customer Mobile Number");
        System.out.println("4.Update Customer Package");
        System.out.println("5.Exit");
        ch = sc.nextInt();
        switch (ch) {
            case 1:

                String Name;
                Integer id;
                System.out.println("Enter The ID");
                id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter new Name");
                Name = sc.nextLine();
                Customer_DB.updateCustomerName(url, userName, Password, Name, id);
                System.out.flush();
                break;
            case 2:

                String Address;
                System.out.println("Enter The ID");
                id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter new Name");
                Address = sc.nextLine();
                Customer_DB.updateCustomerAddress(url, userName, Password, Address, id);
                break;
            case 3:

                System.out.println("Enter The ID");
                id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the Phone Number");
                String phone_no = sc.nextLine();
                Customer_DB.updateCustomerPhoneNo(url, userName, Password, phone_no, id);
                break;
            case 4:

                System.out.println("Enter The ID");
                id = sc.nextInt();
                sc.nextLine();
                System.out.println("Select The New Package");
                PKG_DB.Check_Data(url, userName, Password);
                Integer pkgId = sc.nextInt();
                sc.nextLine();
                Customer_DB.updateCustomerPKG(url, userName, Password, pkgId, id);

        }
        Booking.display();
    }

    public static void deleteCustomer() {
        Scanner sc = new Scanner(System.in);
        Integer id;
        System.out.println("Enter The ID");
        id = sc.nextInt();
        Customer_DB.deleteCutomerDB(url, userName, Password, id);
    }
}
