package views;

import controllers.PatientController;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientView extends JFrame {
    private final JTextField nameField, dobField, genderField, contactField, addressField, medicalHistoryField;
    private final JButton addButton, updateButton, deleteButton, viewButton;
    private final JTextArea patientListArea;

    public PatientView() {
        setTitle("Patient Management");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        nameField = new JTextField();
        dobField = new JTextField();
        genderField = new JTextField();
        contactField = new JTextField();
        addressField = new JTextField();
        medicalHistoryField = new JTextField();

        inputPanel.add(new JLabel("Name:")); inputPanel.add(nameField);
        inputPanel.add(new JLabel("DOB:")); inputPanel.add(dobField);
        inputPanel.add(new JLabel("Gender:")); inputPanel.add(genderField);
        inputPanel.add(new JLabel("Contact:")); inputPanel.add(contactField);
        inputPanel.add(new JLabel("Address:")); inputPanel.add(addressField);
        inputPanel.add(new JLabel("Medical History:")); inputPanel.add(medicalHistoryField);

        addButton = new JButton("Add Patient");
        addButton.addActionListener(e -> PatientController.addPatient(nameField.getText(), dobField.getText(), genderField.getText(),
            contactField.getText(), addressField.getText(), medicalHistoryField.getText()));
        
        updateButton = new JButton("Update Patient");
        updateButton.addActionListener(e -> PatientController.updatePatient(Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID")), 
            nameField.getText(), dobField.getText(), genderField.getText(), contactField.getText(), addressField.getText(), medicalHistoryField.getText()));
        
        deleteButton = new JButton("Delete Patient");
        deleteButton.addActionListener(e -> PatientController.deletePatient(Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID"))));
        
        viewButton = new JButton("View Patient");
        viewButton.addActionListener(e -> PatientController.viewPatient(Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID"))));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewButton);

        patientListArea = new JTextArea();
        patientListArea.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(patientListArea), BorderLayout.SOUTH);
    }
}
