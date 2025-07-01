package controllers;

import models.MedicalRecordModel;
import javax.swing.*;
import java.sql.*;

public class MedicalRecordController {

    // Add new medical record
    public static void addRecord(int patientId, String diagnosis, String treatment, String prescription) {
        MedicalRecordModel medicalRecordModel = new MedicalRecordModel();
        boolean success = medicalRecordModel.addRecord(patientId, diagnosis, treatment, prescription);
        if (success) {
            JOptionPane.showMessageDialog(null, "Medical record added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add medical record!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // View medical record details by ID
    public static void viewRecord(int id) {
        MedicalRecordModel medicalRecordModel = new MedicalRecordModel();
        try {
            ResultSet rs = medicalRecordModel.getRecord(id);
            if (rs.next()) {
                String recordInfo = "Patient ID: " + rs.getInt("patient_id") + "\n" +
                                    "Diagnosis: " + rs.getString("diagnosis") + "\n" +
                                    "Treatment: " + rs.getString("treatment") + "\n" +
                                    "Prescription: " + rs.getString("prescription") + "\n" +
                                    "Record Date: " + rs.getString("record_date");
                JOptionPane.showMessageDialog(null, recordInfo);
            } else {
                JOptionPane.showMessageDialog(null, "Medical record not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching medical record: " + e.getMessage());
        }
    }

    // Update medical record
    public static void updateRecord(int id, String diagnosis, String treatment, String prescription) {
        MedicalRecordModel medicalRecordModel = new MedicalRecordModel();
        boolean success = medicalRecordModel.updateRecord(id, diagnosis, treatment, prescription);
        if (success) {
            JOptionPane.showMessageDialog(null, "Medical record updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update medical record!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Delete medical record
    public static void deleteRecord(int id) {
        MedicalRecordModel medicalRecordModel = new MedicalRecordModel();
        boolean success = medicalRecordModel.deleteRecord(id);
        if (success) {
            JOptionPane.showMessageDialog(null, "Medical record deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to delete medical record!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
