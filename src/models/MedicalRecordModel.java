package models;

import core.BaseModel;
import java.sql.*;

public class MedicalRecordModel extends BaseModel {

    // Add a new medical record
    public boolean addRecord(int patientId, String diagnosis, String treatment, String prescription) {
        try {
            String sql = "INSERT INTO medical_records (patient_id, diagnosis, treatment, prescription) VALUES (?, ?, ?, ?)";
            int rows = executeUpdate(sql, patientId, diagnosis, treatment, prescription);
            return rows > 0; // returns true if insert was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to add medical record: " + e.getMessage());
            return false;
        }
    }

    // Get medical record details by ID
    public ResultSet getRecord(int id) {
        try {
            String sql = "SELECT * FROM medical_records WHERE id=?";
            return executeQuery(sql, id);
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch medical record: " + e.getMessage());
            return null;
        }
    }

    // Get all medical records for a patient
    public ResultSet getAllRecordsForPatient(int patientId) {
        try {
            String sql = "SELECT * FROM medical_records WHERE patient_id=?";
            return executeQuery(sql, patientId);
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch medical records: " + e.getMessage());
            return null;
        }
    }

    // Update medical record
    public boolean updateRecord(int id, String diagnosis, String treatment, String prescription) {
        try {
            String sql = "UPDATE medical_records SET diagnosis=?, treatment=?, prescription=? WHERE id=?";
            int rows = executeUpdate(sql, diagnosis, treatment, prescription, id);
            return rows > 0; // returns true if update was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to update medical record: " + e.getMessage());
            return false;
        }
    }

    // Delete medical record
    public boolean deleteRecord(int id) {
        try {
            String sql = "DELETE FROM medical_records WHERE id=?";
            int rows = executeUpdate(sql, id);
            return rows > 0; // returns true if deletion was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to delete medical record: " + e.getMessage());
            return false;
        }
    }
}
