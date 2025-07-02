package models;

import core.Database;
import java.sql.*;

public class UserModel {
    Database db;

    public UserModel() {
        db = new Database();
    }

    public String login(String username, String password) {
        String query = "SELECT u.*, r.role_name FROM users u JOIN roles r ON u.role_id = r.id WHERE u.username = ? AND u.password = ?";
        try {
            PreparedStatement stmt = db.getConnection().prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Return role name
                return rs.getString("role_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
