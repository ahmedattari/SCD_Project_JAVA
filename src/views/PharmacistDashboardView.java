package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PharmacistDashboardView extends JFrame {
    public PharmacistDashboardView() {
        setTitle("Pharmacist Dashboard");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2, 10, 10));

        JButton inventoryBtn = new JButton("Manage Inventory");
        JButton prescriptionsBtn = new JButton("Manage Prescriptions");

        inventoryBtn.addActionListener((ActionEvent e) -> {
            new InventoryView().setVisible(true);
        });

        prescriptionsBtn.addActionListener((ActionEvent e) -> {
            new PrescriptionView().setVisible(true);
        });

        add(inventoryBtn);
        add(prescriptionsBtn);
    }
}
