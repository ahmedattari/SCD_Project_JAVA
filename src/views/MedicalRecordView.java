package views;

import controllers.MedicalRecordController;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicalRecordView extends JFrame {
    private final JTextField patientIdField, diagnosisField, treatmentField, prescriptionField;
    private final JButton addButton, updateButton, deleteButton, viewButton;

    public MedicalRecordView() {
        setTitle("Medical Records Management");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        patientIdField = new JTextField();
        diagnosisField = new JTextField();
        treatmentField = new JTextField();
        prescriptionField = new JTextField();

        inputPanel.add(new JLabel("Patient ID:")); inputPanel.add(patientIdField);
        inputPanel.add(new JLabel("Diagnosis:")); inputPanel.add(diagnosisField);
        inputPanel.add(new JLabel("Treatment:")); inputPanel.add(treatmentField);
        inputPanel.add(new JLabel("Prescription:")); inputPanel.add(prescriptionField);

        addButton = new JButton("Add Record");
        addButton.addActionListener(e -> MedicalRecordController.addRecord(
            Integer.parseInt(patientIdField.getText()), 
            diagnosisField.getText(), 
            treatmentField.getText(), 
            prescriptionField.getText()));
        
        updateButton = new JButton("Update Record");
        updateButton.addActionListener(e -> MedicalRecordController.updateRecord(
            Integer.parseInt(JOptionPane.showInputDialog("Enter Record ID")), 
            diagnosisField.getText(), 
            treatmentField.getText(), 
            prescriptionField.getText()));
        
        deleteButton = new JButton("Delete Record");
        deleteButton.addActionListener(e -> MedicalRecordController.deleteRecord(
            Integer.parseInt(JOptionPane.showInputDialog("Enter Record ID"))));
        
        viewButton = new JButton("View Record");
        viewButton.addActionListener(e -> MedicalRecordController.viewRecord(
            Integer.parseInt(JOptionPane.showInputDialog("Enter Record ID"))));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
