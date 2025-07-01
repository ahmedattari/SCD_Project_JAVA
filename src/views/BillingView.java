package views;

import controllers.BillingController;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BillingView extends JFrame {
    private final JTextField patientIdField, totalAmountField, paymentAmountField, paymentMethodField;
    private final JButton addButton, updateButton, deleteButton, viewButton, addPaymentButton;

    public BillingView() {
        setTitle("Billing and Payments");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        patientIdField = new JTextField();
        totalAmountField = new JTextField();
        paymentAmountField = new JTextField();
        paymentMethodField = new JTextField();

        inputPanel.add(new JLabel("Patient ID:")); inputPanel.add(patientIdField);
        inputPanel.add(new JLabel("Total Amount:")); inputPanel.add(totalAmountField);
        inputPanel.add(new JLabel("Payment Amount:")); inputPanel.add(paymentAmountField);
        inputPanel.add(new JLabel("Payment Method:")); inputPanel.add(paymentMethodField);

        addButton = new JButton("Add Bill");
        addButton.addActionListener(e -> BillingController.addBill(Integer.parseInt(patientIdField.getText()), 
                Double.parseDouble(totalAmountField.getText())));
        
        updateButton = new JButton("Update Bill");
        updateButton.addActionListener(e -> BillingController.updateBillStatus(Integer.parseInt(JOptionPane.showInputDialog("Enter Bill ID")), "Paid"));
        
        deleteButton = new JButton("Delete Bill");
        deleteButton.addActionListener(e -> BillingController.deleteBill(Integer.parseInt(JOptionPane.showInputDialog("Enter Bill ID"))));
        
        viewButton = new JButton("View Bill");
        viewButton.addActionListener(e -> BillingController.viewBill(Integer.parseInt(JOptionPane.showInputDialog("Enter Bill ID"))));

        addPaymentButton = new JButton("Add Payment");
        addPaymentButton.addActionListener(e -> BillingController.addPayment(Integer.parseInt(JOptionPane.showInputDialog("Enter Bill ID")), 
                Double.parseDouble(paymentAmountField.getText()), paymentMethodField.getText()));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(addPaymentButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
