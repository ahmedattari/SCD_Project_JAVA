package controllers;

import models.UserModel;
import javax.swing.*;
import core.ViewManager;

public class LoginController {
    public static void handleLogin(String username, String password) {
        UserModel userModel = new UserModel();
        String role = userModel.login(username, password);

        if (role != null) {
            JOptionPane.showMessageDialog(null, "Welcome " + role + "!");
            // For now just show a role-based message or open dummy home page
            // ViewManager.show("home_" + role);  <-- Future
        } else {
            JOptionPane.showMessageDialog(null, "Invalid credentials!", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
}
