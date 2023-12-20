package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BillDB {

	public static void create() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// Reflection approach
			String jdbcUrl = "jdbc:mysql://localhost:3306/BillingSysDB"; // URL to your database server
			String username = "root";
			String password = "Musa123";
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Database connection Success" + con);

			Statement stm = con.createStatement();

			String CreateTable = "CREATE TABLE IF NOT EXISTS Bill (Bill_Id INT PRIMARY KEY, ProductName VARCHAR(255), Quantity INT, Price DECIMAL(10, 2), Paid DECIMAL(10, 2), Amount DECIMAL(10, 2), Total DECIMAL(10, 2));";
			stm.executeUpdate(CreateTable);
			Scanner sc = new Scanner(System.in);
			System.out.printf("Enter Product Code :- ");
			int ProductCode = sc.nextInt();
			sc.nextLine();
			System.out.printf("Enter Prodcut Quantity :- ");
			int Qnty = sc.nextInt();
			sc.nextLine();
			System.out.printf("Enter the Product Price (MRP) :-");
			int Mrp = sc.nextInt();
			sc.nextLine();
			System.out.printf("Enter The The Amount Which is Paid :-");
			int pay = sc.nextInt();
			sc.nextLine();
			System.out.printf("Enter the Product Name :- ");
			String ProductName = sc.nextLine();
			int Amount = Qnty * Mrp;
			int Total = Amount - pay;
			String query = "Insert into Bill VALUES (?,?,?,?,?,?,?); ";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, ProductCode);
			pst.setString(2, ProductName);
			pst.setInt(3, Qnty);
			pst.setInt(4, Mrp);
			pst.setInt(5, pay);
			pst.setInt(6, Amount);
			pst.setInt(7, Total);
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

	public static void display() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// Reflection approach
			String jdbcUrl = "jdbc:mysql://localhost:3306/BillingSysDB"; // URL to your database server
			String username = "root";
			String password = "Musa123";
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Database connection Success" + con);
			Statement stm = con.createStatement();
			String query = "select * from Bill";
			ResultSet output = stm.executeQuery(query);
			for (int i = 1; i <= 115; i++) {
				System.out.printf("-");
			}
			System.out.println();
			System.out.printf("%-12s|%-25s| %-12s| %-15s| %-12s| %-12s| %-12s| \n", "Bill_Id", "Product_Name",
					"Quantity", "Price(Per Unit)", "Paid", "Total_Amount", "Remng_Paid_Amt");
			while (output.next()) {
				int ProductId = output.getInt(1);
				String Product_Name = output.getString(2);
				int Qnty = output.getInt(3);
				int Mrp = output.getInt(4);
				int Paid = output.getInt(5);
				int Amount = output.getInt(6);
				int Total = output.getInt(7);
				for (int i = 1; i <= 115; i++) {
					System.out.printf("-");
				}
				System.out.println();

				System.out.printf("%-12d|%-25s| %-12d| %-15d |%-12d| %-12d| %-12d|", ProductId, Product_Name, Qnty, Mrp,
						Paid, Amount, Total);
				System.out.println();
			}
			for (int i = 1; i <= 115; i++) {
				System.out.printf("-");
			}
			System.out.println();
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void deleteDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// Reflection approach
			String jdbcUrl = "jdbc:mysql://localhost:3306/BillingSysDB"; // URL to your database server
			String username = "root";
			String password = "Musa123";
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Database connection Success" + con);

			Statement stm = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.printf("Enter the Bill Number To Delete :-");
			int SrNo = sc.nextInt();
			sc.nextLine();
			String DeleteQuerty = "Delete From Bill where Bill_Id= ?";
			PreparedStatement pst = con.prepareStatement(DeleteQuerty);
			pst.setInt(1, SrNo);

			pst.executeUpdate();
			System.out.println("Record deleted.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}
}
