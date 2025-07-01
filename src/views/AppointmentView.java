package views;

import controllers.AppointmentController;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentView extends JFrame {
    private final JTextField patientIdField, doctorIdField, appointmentDateField;
    private final JButton addButton, updateButton, deleteButton, viewButton;

    public AppointmentView() {
        setTitle("Appointment Management");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        patientIdField = new JTextField();
        doctorIdField = new JTextField();
        appointmentDateField = new JTextField();

        inputPanel.add(new JLabel("Patient ID:")); inputPanel.add(patientIdField);
        inputPanel.add(new JLabel("Doctor ID:")); inputPanel.add(doctorIdField);
        inputPanel.add(new JLabel("Appointment Date:")); inputPanel.add(appointmentDateField);

        addButton = new JButton("Add Appointment");
        addButton.addActionListener(e -> AppointmentController.addAppointment(
            Integer.parseInt(patientIdField.getText()), 
            Integer.parseInt(doctorIdField.getText()), 
            appointmentDateField.getText()));
        
        updateButton = new JButton("Update Appointment");
        updateButton.addActionListener(e -> AppointmentController.updateAppointmentStatus(
            Integer.parseInt(JOptionPane.showInputDialog("Enter Appointment ID")), 
            "Completed"));
        
        deleteButton = new JButton("Delete Appointment");
        deleteButton.addActionListener(e -> AppointmentController.deleteAppointment(
            Integer.parseInt(JOptionPane.showInputDialog("Enter Appointment ID"))));
        
        viewButton = new JButton("View Appointment");
        viewButton.addActionListener(e -> AppointmentController.viewAppointment(
            Integer.parseInt(JOptionPane.showInputDialog("Enter Appointment ID"))));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
