package views;

import javax.swing.*;

public class PrescriptionView extends JFrame {
    public PrescriptionView() {
        setTitle("Prescription Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("This is the Prescription Management View");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);
    }
}
