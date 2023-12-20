package LibraryDBpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class LibraryDB {

    public static void viewDB() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Reflection approach
            String jdbcUrl = "jdbc:mysql://localhost:3306/LibraryDB"; // URL to your database server
            String username = "root";
            String password = "Musa123";
            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connection Success" + con);
            Statement stm = con.createStatement();
            String query = "select * from Library";
            ResultSet output = stm.executeQuery(query);
            System.out.println();
            for (int i = 1; i <= 190; i++){
                System.out.printf("-");
            }
            System.out.println();
            System.out.printf("%-20s|%-20s| %-35s| %-35s |%-12s| %-15s| %-15s| %-15s|", "Serial Number", "Book ID","Book Name", "Student Name", "Phone Number", "Issue Date", "Return Date", "Status");
            System.out.println();
            for (int i = 1; i <= 190; i++){
                System.out.printf("-");
            }
            System.out.println();
            while (output.next()) {
                int srNo = output.getInt(1);
                int bookId = output.getInt(2);
                String BookName = output.getString(3);
                String StudentName = output.getString(4);
                String  phoneNumber= output.getString(5);
                String IssuDate = output.getString(6);
                String ReturnDate = output.getString(7);
                String Status = output.getString(8);
                
                System.out.printf("%-20d|%-20d| %-35s| %-35s |%-12s| %-15s| %-15s| %-15s|", srNo, bookId, BookName, StudentName, phoneNumber, IssuDate, ReturnDate, Status);
                System.out.println();
                for (int i = 1; i <= 190; i++){
                    System.out.printf("-");
                }
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
            String jdbcUrl = "jdbc:mysql://localhost:3306/LibraryDB"; // URL to your database server
            String username = "root";
            String password = "Musa123";
            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connection Success" + con);

            Statement stm = con.createStatement();

            String CreateTable = "CREATE TABLE IF NOT EXISTS Library (SerialNo INT AUTO_INCREMENT UNIQUE,Book_Id INT ,  Book_Name VARCHAR(255), Student_Name VARCHAR(255), Phone_Number VARCHAR(12), IssueDate VARCHAR(12),ReturnDate VARCHAR(12), Status VARCHAR(10), PRIMARY KEY(Book_Id));";
            stm.executeUpdate(CreateTable);
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Book Id");
            int bookId = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Book Name + Author :- ");
            String book = sc.nextLine();

            System.out.println("Enter Student Name :- ");
            String sName = sc.nextLine();

            System.out.println("Enter Phone Number  :- ");
            String phoneNumber = sc.nextLine();

            System.out.println("Enter the Issue Date:- ");
            String issuDate = sc.nextLine();

            System.out.println("Enter the Return Date :- ");
            String returnDate = sc.nextLine();

            System.out.println("Enter Status (Issued/Returned):- ");
            String status = sc.nextLine();

            String query = "Insert into Library (Book_Id,Book_Name, Student_Name, Phone_Number, IssueDate,ReturnDate,Status) Values  (?,?,?,?,?,?,?); ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, bookId);
            pst.setString(2, book);
            pst.setString(3, sName);
            pst.setString(4,  phoneNumber);
            pst.setString(5, issuDate);
            pst.setString(6, returnDate);
            pst.setString(7, status);
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

    public static void updateDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Reflection approach
            String jdbcUrl = "jdbc:mysql://localhost:3306/LibraryDB"; // URL to your database server
            String username = "root";
            String password = "Musa123";
            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connection Success" + con);

            Statement stm = con.createStatement();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Book Id Which is Returned :-");
            int bookId = sc.nextInt();
            sc.nextLine();
            String DeleteQuerty = "Update Library Set Status = ?  where Book_Id = ?";

            PreparedStatement pst = con.prepareStatement(DeleteQuerty);

            pst.setString(1,"Return");
            pst.setInt(2,bookId);

            pst.executeUpdate();
            System.out.println("Record Updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
