package views;

import controllers.LoginController;
import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private final JTextField usernameField;
    private final JPasswordField passwordField;

    public LoginView() {
        setTitle("Hospital Login");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(e -> LoginController.handleLogin(usernameField.getText(), new String(passwordField.getPassword())));

        add(userLabel); add(usernameField);
        add(passLabel); add(passwordField);
        add(new JLabel()); add(loginBtn);
    }
}
