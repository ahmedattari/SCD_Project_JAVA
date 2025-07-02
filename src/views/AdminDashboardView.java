package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminDashboardView extends JFrame {
    public AdminDashboardView() {
        setTitle("Admin Dashboard");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 3, 10, 10));

        JButton usersBtn = new JButton("Manage Users");
        JButton staffBtn = new JButton("Manage Staff");
        JButton inventoryBtn = new JButton("Manage Inventory");
        JButton billingBtn = new JButton("Manage Billing");
        JButton reportsBtn = new JButton("View Reports");

        usersBtn.addActionListener((ActionEvent e) -> {
            new UserView().setVisible(true);
        });

        staffBtn.addActionListener((ActionEvent e) -> {
            new StaffView().setVisible(true);
        });

        inventoryBtn.addActionListener((ActionEvent e) -> {
            new InventoryView().setVisible(true);
        });

        billingBtn.addActionListener((ActionEvent e) -> {
            new BillingView().setVisible(true);
        });

        reportsBtn.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Reports module coming soon!");
        });

        add(usersBtn);
        add(staffBtn);
        add(inventoryBtn);
        add(billingBtn);
        add(reportsBtn);
    }
}
