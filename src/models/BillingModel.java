package models;

import core.BaseModel;
import java.sql.*;

public class BillingModel extends BaseModel {

    // Add a new bill
    public boolean addBill(int patientId, double totalAmount) {
        try {
            String sql = "INSERT INTO billing (patient_id, total_amount) VALUES (?, ?)";
            int rows = executeUpdate(sql, patientId, totalAmount);
            return rows > 0; // returns true if insert was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to add bill: " + e.getMessage());
            return false;
        }
    }

    // Get bill details by ID
    public ResultSet getBill(int id) {
        try {
            String sql = "SELECT * FROM billing WHERE id=?";
            return executeQuery(sql, id);
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch bill: " + e.getMessage());
            return null;
        }
    }

    // Get all bills for a patient
    public ResultSet getAllBillsForPatient(int patientId) {
        try {
            String sql = "SELECT * FROM billing WHERE patient_id=?";
            return executeQuery(sql, patientId);
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch bills: " + e.getMessage());
            return null;
        }
    }

    // Update bill status (Paid/Unpaid)
    public boolean updateBillStatus(int id, String status) {
        try {
            String sql = "UPDATE billing SET status=? WHERE id=?";
            int rows = executeUpdate(sql, status, id);
            return rows > 0; // returns true if update was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to update bill status: " + e.getMessage());
            return false;
        }
    }

    // Delete bill
    public boolean deleteBill(int id) {
        try {
            String sql = "DELETE FROM billing WHERE id=?";
            int rows = executeUpdate(sql, id);
            return rows > 0; // returns true if deletion was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to delete bill: " + e.getMessage());
            return false;
        }
    }

    // Add payment for a bill
    public boolean addPayment(int billingId, double amount, String paymentMethod) {
        try {
            String sql = "INSERT INTO payments (billing_id, amount, payment_method) VALUES (?, ?, ?)";
            int rows = executeUpdate(sql, billingId, amount, paymentMethod);
            return rows > 0; // returns true if payment was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to add payment: " + e.getMessage());
            return false;
        }
    }
}
