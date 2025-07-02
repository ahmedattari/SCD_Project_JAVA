package controllers;

import javax.swing.JOptionPane;
import models.UserModel;
import views.AdminDashboardView;
import views.DoctorDashboardView;
import views.PharmacistDashboardView;
import views.ReceptionistDashboardView;

public class LoginController {

    public static void handleLogin(String username, String password) {
        UserModel userModel = new UserModel();
        String role = userModel.login(username, password);

        if (role != null) {
            JOptionPane.showMessageDialog(null, "Welcome " + role + "!");

            if (role.equalsIgnoreCase("admin")) {
                new AdminDashboardView().setVisible(true);
            } else if (role.equalsIgnoreCase("doctor")) {
                new DoctorDashboardView().setVisible(true);
            } else if (role.equalsIgnoreCase("pharmacist")) {
                new PharmacistDashboardView().setVisible(true);
            } else if (role.equalsIgnoreCase("receptionist")) {
                new ReceptionistDashboardView().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Unknown role! Access denied.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid credentials!", "Login Failed", 0);
        }
    }
}
