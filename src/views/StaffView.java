package views;

import controllers.StaffController;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffView extends JFrame {
    private final JTextField nameField, roleField, departmentField, contactField;
    private final JButton addButton, updateButton, deleteButton, viewButton;

    public StaffView() {
        setTitle("Staff Management");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        nameField = new JTextField();
        roleField = new JTextField();
        departmentField = new JTextField();
        contactField = new JTextField();

        inputPanel.add(new JLabel("Name:")); inputPanel.add(nameField);
        inputPanel.add(new JLabel("Role:")); inputPanel.add(roleField);
        inputPanel.add(new JLabel("Department ID:")); inputPanel.add(departmentField);
        inputPanel.add(new JLabel("Contact:")); inputPanel.add(contactField);

        addButton = new JButton("Add Staff");
        addButton.addActionListener(e -> StaffController.addStaff(nameField.getText(), roleField.getText(),
                Integer.parseInt(departmentField.getText()), contactField.getText()));
        
        updateButton = new JButton("Update Staff");
        updateButton.addActionListener(e -> StaffController.updateStaff(Integer.parseInt(JOptionPane.showInputDialog("Enter Staff ID")), 
                nameField.getText(), roleField.getText(), Integer.parseInt(departmentField.getText()), contactField.getText()));
        
        deleteButton = new JButton("Delete Staff");
        deleteButton.addActionListener(e -> StaffController.deleteStaff(Integer.parseInt(JOptionPane.showInputDialog("Enter Staff ID"))));
        
        viewButton = new JButton("View Staff");
        viewButton.addActionListener(e -> StaffController.viewStaff(Integer.parseInt(JOptionPane.showInputDialog("Enter Staff ID"))));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
