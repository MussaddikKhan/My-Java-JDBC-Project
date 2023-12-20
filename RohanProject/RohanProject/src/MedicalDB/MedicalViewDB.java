package MedicalDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class MedicalViewDB {

    public static void viewDB() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Reflection approach
            String jdbcUrl = "jdbc:mysql://localhost:3306/MedicalDB"; // URL to your database server
            String username = "root";
            String password = "Musa123";
            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connection Success" + con);
            Statement stm = con.createStatement();
            String query = "select * from Medicine";
            ResultSet output = stm.executeQuery(query);
            while (output.next()) {
                int srNo = output.getInt(1);
                int medId = output.getInt(2);
                String mediName = output.getString(3);
                int Quantity = output.getInt(4);
                int Mrp = output.getInt(5);
                String pkgDate = output.getString(6);
                String expDate = output.getString(7);
                String medCompany = output.getString(8);

                System.out.printf("%-12d|%-15d| %-25s| %-10d |%-15d| %-25s| %-25s| %-25s|", srNo, medId, mediName, Quantity, Mrp, pkgDate, expDate, medCompany);
                System.out.println();
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Reflection approach
            String jdbcUrl = "jdbc:mysql://localhost:3306/MedicalDB"; // URL to your database server
            String username = "root";
            String password = "Musa123";
            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connection Success" + con);

            Statement stm = con.createStatement();

            String CreateTable = "CREATE TABLE IF NOT EXISTS Medicine (SerialNo INT PRIMARY KEY, MedicinNo VARCHAR(255), MedName VARCHAR(255), MedQuantiy INT, MedPrice DECIMAL(10, 2), MedPkg_Date VARCHAR(10), MedExp_date VARCHAR(10), meCompany_Name VARCHAR(255));";
            stm.executeUpdate(CreateTable);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Serial No :- ");
            int srNo = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Medicine Id");
            int medId = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Price (MRP)");
            int Mrp = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Units");
            int Units = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Medicine Name :- ");
            String mediName = sc.nextLine();
            System.out.println("Enter the Medicine Company :- ");
            String medCompany = sc.nextLine();

            System.out.println("Enter the Menu Date :- ");
            String pkgDate = sc.nextLine();

            System.out.println("Enter the Expiry Date :- ");
            String expDate = sc.nextLine();

            String query = "Insert into Medicine VALUES (?,?,?,?,?,?,?,?); ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, srNo);
            pst.setInt(2, medId);
            pst.setString(3, mediName);
            pst.setInt(4, Units);
            pst.setInt(5, Mrp);
            pst.setString(8, medCompany);
            pst.setString(6, pkgDate);
            pst.setString(7, expDate);
            pst.executeUpdate();
            System.out.println("Value Insert Successfully");
            con.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void deleteDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Reflection approach
            String jdbcUrl = "jdbc:mysql://localhost:3306/MedicalDB"; // URL to your database server
            String username = "root";
            String password = "Musa123";
            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connection Success" + con);

            Statement stm = con.createStatement();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Serial Number To Remove Medicine");
            int SrNo = sc.nextInt();
            sc.nextLine();
            String DeleteQuerty = "Delete From Medicine where SerialNo = ?";

            PreparedStatement pst = con.prepareStatement(DeleteQuerty);
            pst.setInt(1,SrNo);

            pst.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
