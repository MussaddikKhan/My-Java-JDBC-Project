package LibraryMainPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import LibraryDBpkg.LibraryDB;

public class Library {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int choiceforexit = 1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Reflection approach
            String jdbcUrl = "jdbc:mysql://localhost:3306/"; // URL to your database server
            String username = "root";
            String password = "Musa123";

            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connection Success" + con);

            Statement stm = con.createStatement();
            String CreateTable = "CREATE DATABASE IF NOT EXISTS LibraryDB";
            stm.executeUpdate(CreateTable);
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (choiceforexit != 0) {
            System.out.println();
            System.out.println("WEL-COME TO Library Managment System STORE");
            System.out.println("Our guide for building this project: ");
            System.out.println("DR.ANITA PATIL MADAM");
            System.out.println("This project is designed by:");
            System.out.println("MAHEK PIYUSH PATEL");
            System.out.println("RUCHITA SANTOSH WATEGAONKAR");1
            System.out.println("\n *********LIBRARY MANAGEMENT ***********");
            System.out.println("\n 1.Add New Entry :");
            System.out.println("\n 2.View Entries :");
            System.out.println("\n 3.Update Entries:");
            System.out.println("\n 4.exit the project:  \n");
            System.out.println("\n PLEASE ENTER YOUR CHOICE:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    LibraryDB.insertDB();
                    break;

                case 2:
                    LibraryDB.viewDB();

                    break;

                case 3:
                    LibraryDB.updateDb();
                    break;

                case 4:
                    System.out.println("\n 5.exit the project:");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println("Do u want to continue,if yes press any no. else 0=(1/0) ");
            choiceforexit = sc.nextInt();
        }
        System.out.println("\n   thank u");
    }
}
