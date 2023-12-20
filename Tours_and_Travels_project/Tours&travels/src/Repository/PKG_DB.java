package Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PKG_DB {
    public static void main(String[] args) {

    }

    public static void Check_Data(String url, String userName, String Password) {
        try {
            Connection connection = DriverManager.getConnection(url, userName, Password);

            Statement statement = connection.createStatement();

            String SelectQuery = "SELECT * FROM PKG";

            ResultSet selectData = statement.executeQuery(SelectQuery);
            System.out.println();
            for (int i = 0; i < 90; i++) {
                System.out.printf("-");
            }
            System.out.println();
            System.out.println("Select The Package....");
            System.out.printf("%-10s| %-25s| %-25s| %-12s| %-10s", "PKG_ID ", "PKG_NAME", "PKG_DESTINATION", "PRICE", "MEMBER");
            System.out.println();
            for (int i = 0; i < 90; i++) {
                System.out.printf("-");
            }
            System.out.println();
            while (selectData.next()) {
                Integer pkg_id = selectData.getInt(1);
                String pkg_name = selectData.getString(2);
                String destination = selectData.getString(3);
                Integer price = selectData.getInt(4);
                Integer member = selectData.getInt(5);
                System.out.printf("%-10s| %-25s| %-25s| %-12s| %-10s", pkg_id, pkg_name, destination, price, member);
                System.out.println();
                for (int i = 0; i < 90; i++) {
                    System.out.printf("-");
                }
                System.out.println();
            }
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
