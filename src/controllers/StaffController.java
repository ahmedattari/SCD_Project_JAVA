package controllers;

import models.StaffModel;
import javax.swing.*;
import java.sql.*;

public class StaffController {

    // Add new staff
    public static void addStaff(String name, String role, int departmentId, String contact) {
        StaffModel staffModel = new StaffModel();
        boolean success = staffModel.addStaff(name, role, departmentId, contact);
        if (success) {
            JOptionPane.showMessageDialog(null, "Staff added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add staff!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // View staff details by ID
    public static void viewStaff(int id) {
        StaffModel staffModel = new StaffModel();
        try {
            ResultSet rs = staffModel.getStaff(id);
            if (rs.next()) {
                String staffInfo = "Name: " + rs.getString("name") + "\n" +
                                   "Role: " + rs.getString("role") + "\n" +
                                   "Department ID: " + rs.getInt("department_id") + "\n" +
                                   "Contact: " + rs.getString("contact");
                JOptionPane.showMessageDialog(null, staffInfo);
            } else {
                JOptionPane.showMessageDialog(null, "Staff not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching staff data: " + e.getMessage());
        }
    }

    // Update staff information
    public static void updateStaff(int id, String name, String role, int departmentId, String contact) {
        StaffModel staffModel = new StaffModel();
        boolean success = staffModel.updateStaff(id, name, role, departmentId, contact);
        if (success) {
            JOptionPane.showMessageDialog(null, "Staff updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update staff!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Delete staff
    public static void deleteStaff(int id) {
        StaffModel staffModel = new StaffModel();
        boolean success = staffModel.deleteStaff(id);
        if (success) {
            JOptionPane.showMessageDialog(null, "Staff deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to delete staff!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
