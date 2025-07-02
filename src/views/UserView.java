package views;

import javax.swing.*;

public class UserView extends JFrame {
    public UserView() {
        setTitle("User Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("This is the User Management View");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);
    }
}
