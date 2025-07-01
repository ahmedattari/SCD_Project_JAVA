package models;

import core.BaseModel;
import java.sql.*;

public class AppointmentModel extends BaseModel {

    // Add a new appointment
    public boolean addAppointment(int patientId, int doctorId, String appointmentDate) {
        try {
            String sql = "INSERT INTO appointments (patient_id, doctor_id, appointment_date, status) VALUES (?, ?, ?, 'Scheduled')";
            int rows = executeUpdate(sql, patientId, doctorId, appointmentDate);
            return rows > 0; // returns true if insert was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to add appointment: " + e.getMessage());
            return false;
        }
    }

    // Get appointment details by ID
    public ResultSet getAppointment(int id) {
        try {
            String sql = "SELECT * FROM appointments WHERE id=?";
            return executeQuery(sql, id);
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch appointment: " + e.getMessage());
            return null;
        }
    }

    // Get all appointments
    public ResultSet getAllAppointments() {
        try {
            String sql = "SELECT * FROM appointments";
            return executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch appointments: " + e.getMessage());
            return null;
        }
    }

    // Update appointment status
    public boolean updateAppointmentStatus(int id, String status) {
        try {
            String sql = "UPDATE appointments SET status=? WHERE id=?";
            int rows = executeUpdate(sql, status, id);
            return rows > 0; // returns true if update was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to update appointment status: " + e.getMessage());
            return false;
        }
    }

    // Delete appointment
    public boolean deleteAppointment(int id) {
        try {
            String sql = "DELETE FROM appointments WHERE id=?";
            int rows = executeUpdate(sql, id);
            return rows > 0; // returns true if deletion was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to delete appointment: " + e.getMessage());
            return false;
        }
    }
}
