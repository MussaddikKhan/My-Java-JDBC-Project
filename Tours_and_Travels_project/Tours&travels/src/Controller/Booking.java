package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Repository.Booking_DB;

public class Booking {


    public static void main(String[] args) {
        display();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Reflection approach
            String jdbcUrl = "jdbc:mysql://localhost:3306/"; // URL to your database server
            String username = "root";
            String password = "Musa123";

            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connection Success" + con);

            Statement stm = con.createStatement();
            String CreateDB = "CREATE DATABASE IF NOT EXISTS tours_and_travels";
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void display() {
        Integer Choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Book Customer ");
            System.out.println("2. Update Customer_Info");
            System.out.println("3. Delete Customer");
            System.out.println("4. View Booking");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            Choice = sc.nextInt();
            switch (Choice) {
                case 1:
                    System.out.println();
                    System.out.println("Please Enter Valid Data");
                    Customer.add_Customer();
                    break;
                case 2:
                    Customer.updateCustomer();
                    break;
                case 3:
                    Customer.deleteCustomer();
                    break;

                case 4:
                    Booking_DB.viewBooking(Customer.url, Customer.userName, Customer.Password);
                case 5:
                    System.exit(0);
            }
            System.out.flush();
        }
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            // Handle exceptions or ignore them
        }
    }
}
