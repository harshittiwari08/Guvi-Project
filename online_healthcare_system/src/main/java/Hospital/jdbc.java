package Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {

    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/healthcaresystem";
        String username = "root";
        String password = "harshit@@08";

        // Try-with-resources for auto-closing resources
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection created successfully");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
