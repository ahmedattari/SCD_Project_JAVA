package controllers;

import models.BillingModel;
import javax.swing.*;
import java.sql.*;

public class BillingController {

    // Add new bill
    public static void addBill(int patientId, double totalAmount) {
        BillingModel billingModel = new BillingModel();
        boolean success = billingModel.addBill(patientId, totalAmount);
        if (success) {
            JOptionPane.showMessageDialog(null, "Bill added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add bill!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // View bill details by ID
    public static void viewBill(int id) {
        BillingModel billingModel = new BillingModel();
        try {
            ResultSet rs = billingModel.getBill(id);
            if (rs.next()) {
                String billInfo = "Patient ID: " + rs.getInt("patient_id") + "\n" +
                                  "Total Amount: $" + rs.getDouble("total_amount") + "\n" +
                                  "Status: " + rs.getString("status") + "\n" +
                                  "Bill Date: " + rs.getString("bill_date");
                JOptionPane.showMessageDialog(null, billInfo);
            } else {
                JOptionPane.showMessageDialog(null, "Bill not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching bill: " + e.getMessage());
        }
    }

    // Update bill status (Paid/Unpaid)
    public static void updateBillStatus(int id, String status) {
        BillingModel billingModel = new BillingModel();
        boolean success = billingModel.updateBillStatus(id, status);
        if (success) {
            JOptionPane.showMessageDialog(null, "Bill status updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update bill status!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Delete bill
    public static void deleteBill(int id) {
        BillingModel billingModel = new BillingModel();
        boolean success = billingModel.deleteBill(id);
        if (success) {
            JOptionPane.showMessageDialog(null, "Bill deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to delete bill!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Add payment to bill
    public static void addPayment(int billingId, double amount, String paymentMethod) {
        BillingModel billingModel = new BillingModel();
        boolean success = billingModel.addPayment(billingId, amount, paymentMethod);
        if (success) {
            JOptionPane.showMessageDialog(null, "Payment added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add payment!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
