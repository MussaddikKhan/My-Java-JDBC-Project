package MainFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import projectDB.BillDB;

public class ProjecMain {
	public static void main(String[] args) {
		int choice = -1;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// Reflection approach
			String jdbcUrl = "jdbc:mysql://localhost:3306/"; // URL to your database server
			String username = "root";
			String password = "Musa123";

			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Database connection Success" + con);

			Statement stm = con.createStatement();
			String CreateTable = "CREATE DATABASE IF NOT EXISTS BillingSysDB";
			stm.executeUpdate(CreateTable);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		while (choice != 0) {
			System.out.println("1.Enter The New Bill");
			System.out.println("2.View The Bills");
			System.out.println("3.Delete The Bill");
			System.out.println("0.Exit");
			System.out.printf("Enter the Choice :- ");
			
			choice = sc.nextInt(); 
			sc.nextLine(); 
			switch (choice) {
				case 1: 
					BillDB.create(); 
					break;
				case 2:
					BillDB.display();
					break; 
				case 3: 
					BillDB.deleteDB();
					break; 
				case 0: 
					break; 
				 default:
		              System.out.println("Invalid choice");
		              break;
			}
		}
		System.out.println("Thank You...!");
	}
}
