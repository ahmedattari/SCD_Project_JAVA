package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ReceptionistDashboardView extends JFrame {
    public ReceptionistDashboardView() {
        setTitle("Receptionist Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2, 10, 10));

        JButton appointmentsBtn = new JButton("Manage Appointments");
        JButton registrationBtn = new JButton("Patient Registration");
        JButton billingBtn = new JButton("Billing");

        appointmentsBtn.addActionListener((ActionEvent e) -> {
            new AppointmentView().setVisible(true);
        });

        registrationBtn.addActionListener((ActionEvent e) -> {
            new PatientView().setVisible(true);
        });

        billingBtn.addActionListener((ActionEvent e) -> {
            new BillingView().setVisible(true);
        });

        add(appointmentsBtn);
        add(registrationBtn);
        add(billingBtn);
    }
}
