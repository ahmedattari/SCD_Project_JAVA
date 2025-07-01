package controllers;

import models.AppointmentModel;
import javax.swing.*;
import java.sql.*;

public class AppointmentController {

    // Add new appointment
    public static void addAppointment(int patientId, int doctorId, String appointmentDate) {
        AppointmentModel appointmentModel = new AppointmentModel();
        boolean success = appointmentModel.addAppointment(patientId, doctorId, appointmentDate);
        if (success) {
            JOptionPane.showMessageDialog(null, "Appointment added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add appointment!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // View appointment details by ID
    public static void viewAppointment(int id) {
        AppointmentModel appointmentModel = new AppointmentModel();
        try {
            ResultSet rs = appointmentModel.getAppointment(id);
            if (rs.next()) {
                String appointmentInfo = "Patient ID: " + rs.getInt("patient_id") + "\n" +
                                         "Doctor ID: " + rs.getInt("doctor_id") + "\n" +
                                         "Appointment Date: " + rs.getString("appointment_date") + "\n" +
                                         "Status: " + rs.getString("status");
                JOptionPane.showMessageDialog(null, appointmentInfo);
            } else {
                JOptionPane.showMessageDialog(null, "Appointment not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching appointment data: " + e.getMessage());
        }
    }

    // Update appointment status (e.g., Scheduled -> Completed)
    public static void updateAppointmentStatus(int id, String status) {
        AppointmentModel appointmentModel = new AppointmentModel();
        boolean success = appointmentModel.updateAppointmentStatus(id, status);
        if (success) {
            JOptionPane.showMessageDialog(null, "Appointment status updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update appointment status!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Delete appointment
    public static void deleteAppointment(int id) {
        AppointmentModel appointmentModel = new AppointmentModel();
        boolean success = appointmentModel.deleteAppointment(id);
        if (success) {
            JOptionPane.showMessageDialog(null, "Appointment deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to delete appointment!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
