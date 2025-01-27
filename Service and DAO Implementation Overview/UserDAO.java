package Hospital;

import java.sql.*;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addUser(String username, String password, String role) throws SQLException {
        String query = "INSERT INTO Users (username, password, role) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);
            return ps.executeUpdate() > 0;
        }
    }

    public ResultSet findUserById(int userId) throws SQLException {
        String query = "SELECT * FROM Users WHERE user_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, userId);
        return ps.executeQuery();
    }
}
