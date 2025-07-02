package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DoctorDashboardView extends JFrame {
    public DoctorDashboardView() {
        setTitle("Doctor Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2, 10, 10));

        JButton patientsBtn = new JButton("Manage Patients");
        JButton recordsBtn = new JButton("Medical Records");
        JButton appointmentsBtn = new JButton("Appointments");

        patientsBtn.addActionListener((ActionEvent e) -> {
            new PatientView().setVisible(true);
        });

        recordsBtn.addActionListener((ActionEvent e) -> {
            new MedicalRecordView().setVisible(true);
        });

        appointmentsBtn.addActionListener((ActionEvent e) -> {
            new AppointmentView().setVisible(true);
        });

        add(patientsBtn);
        add(recordsBtn);
        add(appointmentsBtn);
    }
}
