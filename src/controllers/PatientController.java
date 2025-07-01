package controllers;

import models.PatientModel;
import javax.swing.*;
import java.sql.*;

public class PatientController {
    
    // Add new patient
    public static void addPatient(String name, String dob, String gender, String contact, String address, String medicalHistory) {
        PatientModel patientModel = new PatientModel();
        boolean success = patientModel.addPatient(name, dob, gender, contact, address, medicalHistory);
        if (success) {
            JOptionPane.showMessageDialog(null, "Patient added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add patient!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // View patient details by ID
    public static void viewPatient(int id) {
        PatientModel patientModel = new PatientModel();
        try {
            ResultSet rs = patientModel.getPatient(id);
            if (rs.next()) {
                String patientInfo = "Name: " + rs.getString("name") + "\n" +
                                     "DOB: " + rs.getString("dob") + "\n" +
                                     "Gender: " + rs.getString("gender") + "\n" +
                                     "Contact: " + rs.getString("contact") + "\n" +
                                     "Address: " + rs.getString("address") + "\n" +
                                     "Medical History: " + rs.getString("medical_history");
                JOptionPane.showMessageDialog(null, patientInfo);
            } else {
                JOptionPane.showMessageDialog(null, "Patient not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching patient data: " + e.getMessage());
        }
    }

    // Update patient information
    public static void updatePatient(int id, String name, String dob, String gender, String contact, String address, String medicalHistory) {
        PatientModel patientModel = new PatientModel();
        boolean success = patientModel.updatePatient(id, name, dob, gender, contact, address, medicalHistory);
        if (success) {
            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update patient!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Delete patient
    public static void deletePatient(int id) {
        PatientModel patientModel = new PatientModel();
        boolean success = patientModel.deletePatient(id);
        if (success) {
            JOptionPane.showMessageDialog(null, "Patient deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to delete patient!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
