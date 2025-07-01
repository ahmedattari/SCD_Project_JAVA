package controllers;

import models.InventoryModel;
import javax.swing.*;
import java.sql.*;

public class InventoryController {

    // Add new inventory item
    public static void addItem(String name, int quantity, double price, String description) {
        InventoryModel inventoryModel = new InventoryModel();
        boolean success = inventoryModel.addItem(name, quantity, price, description);
        if (success) {
            JOptionPane.showMessageDialog(null, "Inventory item added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add inventory item!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // View inventory item details by ID
    public static void viewItem(int id) {
        InventoryModel inventoryModel = new InventoryModel();
        try {
            ResultSet rs = inventoryModel.getItem(id);
            if (rs.next()) {
                String itemInfo = "Name: " + rs.getString("name") + "\n" +
                                  "Quantity: " + rs.getInt("quantity") + "\n" +
                                  "Price: $" + rs.getDouble("price") + "\n" +
                                  "Description: " + rs.getString("description");
                JOptionPane.showMessageDialog(null, itemInfo);
            } else {
                JOptionPane.showMessageDialog(null, "Inventory item not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching inventory item: " + e.getMessage());
        }
    }

    // Update inventory item
    public static void updateItem(int id, String name, int quantity, double price, String description) {
        InventoryModel inventoryModel = new InventoryModel();
        boolean success = inventoryModel.updateItem(id, name, quantity, price, description);
        if (success) {
            JOptionPane.showMessageDialog(null, "Inventory item updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update inventory item!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Delete inventory item
    public static void deleteItem(int id) {
        InventoryModel inventoryModel = new InventoryModel();
        boolean success = inventoryModel.deleteItem(id);
        if (success) {
            JOptionPane.showMessageDialog(null, "Inventory item deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to delete inventory item!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
