package models;

import core.BaseModel;
import java.sql.*;

public class UserModel extends BaseModel {
    public String login(String username, String password) {
        try {
            ResultSet rs = executeQuery(
                "SELECT roles.role_name FROM users JOIN roles ON users.role_id = roles.id WHERE username=? AND password=?",
                username, password
            );
            if (rs.next()) {
                return rs.getString("role_name"); // returns role if login successful
            }
        } catch (SQLException e) {
            System.out.println("❌ Login failed: " + e.getMessage());
        }
        return null;
    }
}
