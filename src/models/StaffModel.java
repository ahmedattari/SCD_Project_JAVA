package models;

import core.BaseModel;
import java.sql.*;

public class StaffModel extends BaseModel {

    // Add new staff
    public boolean addStaff(String name, String role, int departmentId, String contact) {
        try {
            String sql = "INSERT INTO staff (name, role, department_id, contact) VALUES (?, ?, ?, ?)";
            int rows = executeUpdate(sql, name, role, departmentId, contact);
            return rows > 0; // returns true if insert was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to add staff: " + e.getMessage());
            return false;
        }
    }

    // Get staff details by ID
    public ResultSet getStaff(int id) {
        try {
            String sql = "SELECT * FROM staff WHERE id=?";
            return executeQuery(sql, id);
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch staff: " + e.getMessage());
            return null;
        }
    }

    // Get all staff members
    public ResultSet getAllStaff() {
        try {
            String sql = "SELECT * FROM staff";
            return executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch staff: " + e.getMessage());
            return null;
        }
    }

    // Update staff information
    public boolean updateStaff(int id, String name, String role, int departmentId, String contact) {
        try {
            String sql = "UPDATE staff SET name=?, role=?, department_id=?, contact=? WHERE id=?";
            int rows = executeUpdate(sql, name, role, departmentId, contact, id);
            return rows > 0; // returns true if update was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to update staff: " + e.getMessage());
            return false;
        }
    }

    // Delete staff
    public boolean deleteStaff(int id) {
        try {
            String sql = "DELETE FROM staff WHERE id=?";
            int rows = executeUpdate(sql, id);
            return rows > 0; // returns true if deletion was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to delete staff: " + e.getMessage());
            return false;
        }
    }
}
