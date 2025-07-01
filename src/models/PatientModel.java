package models;

import core.BaseModel;
import java.sql.*;

public class PatientModel extends BaseModel {

    // Add a new patient
    public boolean addPatient(String name, String dob, String gender, String contact, String address, String medicalHistory) {
        try {
            String sql = "INSERT INTO patients (name, dob, gender, contact, address, medical_history) VALUES (?, ?, ?, ?, ?, ?)";
            int rows = executeUpdate(sql, name, dob, gender, contact, address, medicalHistory);
            return rows > 0; // returns true if insert was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to add patient: " + e.getMessage());
            return false;
        }
    }

    // Get patient details by ID
    public ResultSet getPatient(int id) {
        try {
            String sql = "SELECT * FROM patients WHERE id=?";
            return executeQuery(sql, id);
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch patient: " + e.getMessage());
            return null;
        }
    }

    // Get all patients
    public ResultSet getAllPatients() {
        try {
            String sql = "SELECT * FROM patients";
            return executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch patients: " + e.getMessage());
            return null;
        }
    }

    // Update patient information
    public boolean updatePatient(int id, String name, String dob, String gender, String contact, String address, String medicalHistory) {
        try {
            String sql = "UPDATE patients SET name=?, dob=?, gender=?, contact=?, address=?, medical_history=? WHERE id=?";
            int rows = executeUpdate(sql, name, dob, gender, contact, address, medicalHistory, id);
            return rows > 0; // returns true if update was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to update patient: " + e.getMessage());
            return false;
        }
    }

    // Delete patient
    public boolean deletePatient(int id) {
        try {
            String sql = "DELETE FROM patients WHERE id=?";
            int rows = executeUpdate(sql, id);
            return rows > 0; // returns true if deletion was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to delete patient: " + e.getMessage());
            return false;
        }
    }
}
