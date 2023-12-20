package Repository;

import Controller.Booking;

import java.lang.reflect.Member;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class Booking_DB {
    public static void bookCustomer(String url, String username, String password, int CustID, int pkgID) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            int v1 = CustID;
            int v3 = pkgID;
            int v2 = CustID;
            String insertQuery = "INSERT INTO bookcustomer (Booking_Id, customer_id, pkg_id) Values (?, ?, ?)";
            PreparedStatement insertData = connection.prepareStatement(insertQuery);
            insertData.setInt(1, v1);
            insertData.setInt(2, v2);
            insertData.setInt(3, v3);

            int num = insertData.executeUpdate();
            if (num > 0) {
                System.out.println("Data is Update  in Booking Table");
            } else {
                System.out.println("Customer is Added But Data is Not Updata in Booking ");
            }
            connection.close();
            Booking.display();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewBooking(String url, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String SelectQuery =
                    "SELECT B.Booking_ID, C.Customer_Name,C.Customer_Address,C.ContactNo,P.Pkg_Name, P.Destination,P.Price, P.Member FROM  bookcustomer B JOIN  customer C ON B.Customer_Id = C.Customer_Id JOIN  pkg P ON B.pkg_id = P.Pkg_Id ";
            ResultSet selectData = statement.executeQuery(SelectQuery);
            for (int i = 0; i < 160; i++) {
                System.out.printf("-");
            }
            System.out.println();
            System.out.printf("%-12s| %-30s| %-20s| %-12s| %-25s| %-20s| %-10s| %-10s| \n", "Booking Id", "Customer_Name", "Customer_Address", "Contact_No", "Pkg_Name", "Destination", "Price", "Member");
            for (int i = 0; i < 160; i++) {
                System.out.printf("-");
            }
            System.out.println();
            while (selectData.next()) {
                Integer Booking_id = selectData.getInt(1);
                String Customer_Name = selectData.getString(2);
                String Customer_Address = selectData.getString(3);
                String ContactNo = selectData.getString(4);
                String Pkg_Name = selectData.getString(5);
                String Destination = selectData.getString(6);
                String Price = selectData.getString(7);
                Integer member = selectData.getInt(8);
                System.out.printf("%-12s| %-30s| %-20s| %-12s| %-25s| %-20s| %-10s| %-10s| \n", Booking_id, Customer_Name, Customer_Address, ContactNo, Pkg_Name, Destination, Price, member);
                for (int i = 0; i < 160; i++) {
                    System.out.printf("-");
                }
                System.out.println();
            }

            Booking.display();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
