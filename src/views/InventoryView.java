package views;

import controllers.InventoryController;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryView extends JFrame {
    private final JTextField nameField, quantityField, priceField, descriptionField;
    private final JButton addButton, updateButton, deleteButton, viewButton;

    public InventoryView() {
        setTitle("Inventory Management");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        nameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();
        descriptionField = new JTextField();

        inputPanel.add(new JLabel("Name:")); inputPanel.add(nameField);
        inputPanel.add(new JLabel("Quantity:")); inputPanel.add(quantityField);
        inputPanel.add(new JLabel("Price:")); inputPanel.add(priceField);
        inputPanel.add(new JLabel("Description:")); inputPanel.add(descriptionField);

        addButton = new JButton("Add Item");
        addButton.addActionListener(e -> InventoryController.addItem(nameField.getText(), Integer.parseInt(quantityField.getText()),
                Double.parseDouble(priceField.getText()), descriptionField.getText()));
        
        updateButton = new JButton("Update Item");
        updateButton.addActionListener(e -> InventoryController.updateItem(Integer.parseInt(JOptionPane.showInputDialog("Enter Item ID")), 
                nameField.getText(), Integer.parseInt(quantityField.getText()), 
                Double.parseDouble(priceField.getText()), descriptionField.getText()));
        
        deleteButton = new JButton("Delete Item");
        deleteButton.addActionListener(e -> InventoryController.deleteItem(Integer.parseInt(JOptionPane.showInputDialog("Enter Item ID"))));
        
        viewButton = new JButton("View Item");
        viewButton.addActionListener(e -> InventoryController.viewItem(Integer.parseInt(JOptionPane.showInputDialog("Enter Item ID"))));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
