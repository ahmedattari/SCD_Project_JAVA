package models;

import core.BaseModel;
import java.sql.*;

public class InventoryModel extends BaseModel {

    // Add new inventory item
    public boolean addItem(String name, int quantity, double price, String description) {
        try {
            String sql = "INSERT INTO inventory (name, quantity, price, description) VALUES (?, ?, ?, ?)";
            int rows = executeUpdate(sql, name, quantity, price, description);
            return rows > 0; // returns true if insert was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to add inventory item: " + e.getMessage());
            return false;
        }
    }

    // Get inventory item by ID
    public ResultSet getItem(int id) {
        try {
            String sql = "SELECT * FROM inventory WHERE id=?";
            return executeQuery(sql, id);
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch inventory item: " + e.getMessage());
            return null;
        }
    }

    // Get all inventory items
    public ResultSet getAllItems() {
        try {
            String sql = "SELECT * FROM inventory";
            return executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch inventory items: " + e.getMessage());
            return null;
        }
    }

    // Update inventory item
    public boolean updateItem(int id, String name, int quantity, double price, String description) {
        try {
            String sql = "UPDATE inventory SET name=?, quantity=?, price=?, description=? WHERE id=?";
            int rows = executeUpdate(sql, name, quantity, price, description, id);
            return rows > 0; // returns true if update was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to update inventory item: " + e.getMessage());
            return false;
        }
    }

    // Delete inventory item
    public boolean deleteItem(int id) {
        try {
            String sql = "DELETE FROM inventory WHERE id=?";
            int rows = executeUpdate(sql, id);
            return rows > 0; // returns true if deletion was successful
        } catch (SQLException e) {
            System.out.println("❌ Failed to delete inventory item: " + e.getMessage());
            return false;
        }
    }
}
