package MainPKG;

import StudentDB.StudentDB1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Run Time DataBase
        String url = "jdbc:mysql://localhost:3306";
        String username = "root";
        String Password = "Musa123";
        try{
            // Step 1 :-
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Query For Run Time DB :-
            String CreateDBquery = "Create Database IF Not Exists Student_DB_2023";
            Connection con = DriverManager.getConnection(url, username, Password);
            Statement st = con.createStatement();
            System.out.println("Connection Established...");
            st.executeUpdate(CreateDBquery);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        url =   "jdbc:mysql://localhost:3306/Student_DB_2023";
        StudentDB1.createTable(url, username,Password);
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println("WEL-COME TO STUDENT MANAGEMENT SYSTEM");
        System.out.println("Our guide for building this project: ");
        System.out.println("Guide Name");
        System.out.println("This project is designed by:");
        System.out.println("Name");
        System.out.println("Name");
        System.out.println("Name");
        System.out.println("\n *********Student  Managment  System ***********");
        System.out.println();
        int choice = -1;
        while(choice != 0){
            System.out.println();
            System.out.println("1.Add  Student Information ");
            System.out.println("2.View Student Information");
            System.out.println("3.Update  Student Information");
            System.out.println("4.Delete  Student Information");
            System.out.println("0.Exit");
            System.out.println();
            System.out.printf("Enter The Choice :- ");

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1 : StudentDB1.InsertValues(url, username, Password); break;
                case 2 : StudentDB1.selecValues(url,username,Password); break;
                case 3 : StudentDB1.updateValues(url,username,Password); break;
                case 4 : StudentDB1.deleteValues(url,username,Password); break;
                case 0 : break;
                default:
                    System.out.println("Please Choose Valid Choice !");
            }
        }
    }

}
