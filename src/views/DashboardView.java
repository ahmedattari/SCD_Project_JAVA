package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import views.PatientView;
import views.AppointmentView;
import views.StaffView;
import views.InventoryView;
import views.BillingView;
// You can also add ReportsView if needed

public class DashboardView extends JFrame {
    public DashboardView(String role) {
        setTitle("Dashboard - " + role);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Welcome to the " + role + " Dashboard!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3, 10, 10));

        JButton patientsBtn = new JButton("Manage Patients");
        JButton appointmentsBtn = new JButton("Appointments");
        JButton staffBtn = new JButton("Staff");
        JButton inventoryBtn = new JButton("Inventory");
        JButton billingBtn = new JButton("Billing");
        JButton reportsBtn = new JButton("Reports");

        // Existing working button
        patientsBtn.addActionListener((ActionEvent e) -> {
            new PatientView().setVisible(true);
        });

        // Appointments
        appointmentsBtn.addActionListener((ActionEvent e) -> {
            new AppointmentView().setVisible(true);
        });

        // Staff
        staffBtn.addActionListener((ActionEvent e) -> {
            new StaffView().setVisible(true);
        });

        // Inventory
        inventoryBtn.addActionListener((ActionEvent e) -> {
            new InventoryView().setVisible(true);
        });

        // Billing
        billingBtn.addActionListener((ActionEvent e) -> {
            new BillingView().setVisible(true);
        });

        // Reports
        reportsBtn.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Reports module coming soon!");
        });

        buttonPanel.add(patientsBtn);
        buttonPanel.add(appointmentsBtn);
        buttonPanel.add(staffBtn);
        buttonPanel.add(inventoryBtn);
        buttonPanel.add(billingBtn);
        buttonPanel.add(reportsBtn);

        add(buttonPanel, BorderLayout.CENTER);
    }
}
