package StudentDB;

import java.nio.file.attribute.UserPrincipal;
import java.sql.*;
import java.util.Scanner;

public class StudentDB1 {
    // Create Table  While Run The Program :-
    public static void createTable(String url, String Username, String Password) {

        String createTable = "Create Table if not exists Student_Data(Student_ID int Primary key,  Roll_No int, Student_Name varchar(255), Student_Adress varchar(255), MobileName varchar(13));";
        try {
            Connection con = DriverManager.getConnection(url, Username, Password);
            Statement st = con.createStatement();
            st.executeUpdate(createTable);
            System.out.println("Table is Created Successfully..");
        } catch (SQLException e) {
            System.out.println("Error while Creaating Table");
            throw new RuntimeException(e);
        }

    }

    public static void InsertValues(String url, String Username, String Password) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the Student ID :- ");
        Integer SID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Roll No");
        Integer RollNo = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Student Name ");
        String Sname = sc.nextLine();
        System.out.println("Enter the Student Adress ");
        String Saddress = sc.nextLine();
        System.out.println("Enter the Student Mobile Number");
        String SphnNumber = sc.nextLine();

        try {
            Connection con = DriverManager.getConnection(url, Username, Password);
            Statement st = con.createStatement();
            String insertQuery = "Insert Into Student_Data values (?, ?, ?, ?, ?); ";

            PreparedStatement pst = con.prepareStatement(insertQuery);    // when we create object or prepared statement that time we will execute our Query .
            pst.setInt(1, SID);
            pst.setInt(2, RollNo);
            pst.setString(3, Sname);
            pst.setString(4, Saddress);
            pst.setString(5, SphnNumber);
            pst.executeUpdate();
            System.out.println("value is inserted Successfully..");
        } catch (SQLException e) {
            System.out.println("Error while Creaating Table");
            throw new RuntimeException(e);
        }
    }
    // Reuslt Set  :- exucuterQuery();

    public static void selecValues(String url, String Username, String Password) {
        try {
            Connection con = DriverManager.getConnection(url, Username, Password);
            String selectQuery = "Select * from  Student_Data";
            PreparedStatement pst = con.prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();

            System.out.println("\t\t\t\t\t Dispalyed");
            System.out.println();
            for (int i = 1; i <= 150; i++) {
                System.out.printf("-");
            }
            System.out.println();
            System.out.printf("%-20s|%-20s| %-35s| %-35s |%-12s|", "Student Id", "Roll No", "Student Name", "Student Address", "Phone Number");
            System.out.println();
            for (int i = 1; i <= 150; i++) {
                System.out.printf("-");
            }
            System.out.println();
            while (rs.next()) {
                int a = rs.getInt(1);
                int b = rs.getInt(2);
                String x = rs.getString(3);
                String y = rs.getString(4);
                String z = rs.getString(5);

                System.out.printf("%-20d|%-20d| %-35s| %-35s |%-12s|", a, b, x, y, z);
                System.out.println();
                for (int i = 1; i <= 150; i++) {
                    System.out.printf("-");
                }
                System.out.println();
            }
            System.out.println("value is inserted Successfully..");
            con.close();
        } catch (SQLException e) {
            System.out.println("Error while Creaating Table");
            throw new RuntimeException(e);
        }
    }

    public static void updateValues(String url, String Username, String Password) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Update The Student Roll No ");
        System.out.println("2.Update The Student Name");
        System.out.println("3.Update the Student Address");
        System.out.println("4.Update the Student Phone Number");
        System.out.println();
        System.out.printf("Enter The Choice :- ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter The Student Id :-");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter The New Roll No :- ");
                Integer rn = sc.nextInt();
                sc.nextLine();
                try {
                    Integer Roll_NO = rn;
                    Integer Id = id;
                    Connection connection = DriverManager.getConnection(url, Username, Password);
                    Statement statement = connection.createStatement();
                    String insertQuery = "UPDATE Student_Data SET Roll_No = ? WHERE Student_ID = ?;";
                    PreparedStatement UpdateStatement = connection.prepareStatement(insertQuery);
                    UpdateStatement.setInt(1, Roll_NO);
                    UpdateStatement.setInt(2, Id);
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
                break;
            case 2:
                System.out.println("Enter The Student Id :-");
                id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter The New Name :- ");
                String name = sc.nextLine();
                try {
                    String Name = name;
                    Integer Id = id;
                    Connection connection = DriverManager.getConnection(url, Username, Password);
                    Statement statement = connection.createStatement();
                    String insertQuery = "UPDATE Student_Data SET Student_Name = ? WHERE Student_ID = ?;";
                    PreparedStatement UpdateStatement = connection.prepareStatement(insertQuery);
                    UpdateStatement.setString(1, Name);
                    UpdateStatement.setInt(2, Id);
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
                break;
            case 3:
                System.out.println("Enter The Student Id :-");
                id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter The New Address :- ");
                String address = sc.nextLine();
                try {
                    String Address = address;
                    Integer Id = id;
                    Connection connection = DriverManager.getConnection(url, Username, Password);
                    Statement statement = connection.createStatement();
                    String insertQuery = "UPDATE Student_Data SET Student_Adress = ? WHERE Student_ID = ?;";
                    PreparedStatement UpdateStatement = connection.prepareStatement(insertQuery);
                    UpdateStatement.setString(1, Address);
                    UpdateStatement.setInt(2, Id);
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
                break;
            case 4:
                System.out.println("Enter The Student Id :-");
                id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter The New Phone Number :- ");
                String phnNum = sc.nextLine();
                try {
                    String PhneNum = phnNum;
                    Integer Id = id;
                    Connection connection = DriverManager.getConnection(url, Username, Password);
                    Statement statement = connection.createStatement();
                    String insertQuery = "UPDATE Student_Data SET MobileName = ? WHERE Student_ID = ?;";
                    PreparedStatement UpdateStatement = connection.prepareStatement(insertQuery);
                    UpdateStatement.setString(1, PhneNum);
                    UpdateStatement.setInt(2, Id);
                    int num = UpdateStatement.executeUpdate();
                    if (num > 0) {
                        System.out.println("Value Update SucessFully...!");
                    } else {
                        System.out.println("Value is Not Updated");
                    }
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break; 

             default :
                System.out.println("Please Enter Valid Number");
                break;
        }
    }
    public static void deleteValues(String url, String Username, String Password) {
        try {
            Connection con = DriverManager.getConnection(url, Username, Password);
            String deleteQuery = "Delete From Student_Data where Student_ID = ? ";
            System.out.println();
            System.out.printf("Enter The Student Id Which You have to Remove :- ");
            Scanner sc = new Scanner(System.in);
            int val = sc.nextInt();
            System.out.println();
            PreparedStatement pst = con.prepareStatement(deleteQuery);
            pst.setInt(1, val);
            int a = pst.executeUpdate();
            if(a > 0) System.out.println("value is deleted Successfully..");
            else System.out.println("Value is not deleted");
            con.close();
        } catch (SQLException e) {
            System.out.println("Error while Creaating Table");
            throw new RuntimeException(e);
        }
    }
}
