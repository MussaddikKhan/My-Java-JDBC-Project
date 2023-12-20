package MedProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import MedicalDB.MedicalViewDB;
public class MedicalStore {
    public static void main(String[] args) throws ClassNotFoundException {
         Scanner sc= new Scanner(System.in);
        int choiceforexit=1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Reflection approach
            String jdbcUrl = "jdbc:mysql://localhost:3306/"; // URL to your database server
            String username = "root";
            String password = "Musa123";

            Connection con = DriverManager.getConnection(jdbcUrl,username,password);
            System.out.println("Database connection Success"+con);

            Statement stm = con.createStatement();
            String CreateTable = "CREATE DATABASE IF NOT EXISTS MedicalDB";
            stm.executeUpdate(CreateTable);
        }
        catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(choiceforexit!=0){
        System.out.println("WEL-COME TO VIRTUAL MEDICAL STORE");
        System.out.println("Our guide for building this project: ");
        System.out.println("DR.ANITA PATIL MADAM");
        System.out.println("This project is designed by:");
        System.out.println("ROHAN RAJENDRA DESHMUKH");
        System.out.println("VIKRANT PRADIP MANE");
        System.out.println("SIRAJ VIJAY KADAM");
        System.out.println("\n *********virtual medical store***********");
        System.out.println("\n 1.view medicine report:");   
        System.out.println("\n 2.add new medicine's:");   
        System.out.println("\n 3.remove medicine:");
        System.out.println("\n 4.about project :");   
        System.out.println("\n 5.exit the project:  \n");
        System.out.println("\n PLEASE ENTER YOUR CHOICE:");
           int choice = sc.nextInt();
          switch (choice) {
            case 1:
              MedicalViewDB.viewDB();
              break;

            case 2:
            	MedicalViewDB.insertDB();
                break;

            case 3:
                MedicalViewDB.deleteDB();
                break;

            case 4:
                System.out.println("\n 4.about project:");
                break;

            case 5:
                System.out.println("\n 5.exit the project:");
                break;

            default:
              System.out.println("Invalid choice");
              break;
        }
        System.out.println("Do u want to continue,if yes press any no. else 0=(1/0) ");
      choiceforexit=sc.nextInt();
        }
        System.out.println("\n   thank u");   
      }
    }
