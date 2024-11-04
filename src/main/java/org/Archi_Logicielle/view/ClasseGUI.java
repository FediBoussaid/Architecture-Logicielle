package org.Archi_Logicielle.view;

import org.Archi_Logicielle.controller.ClasseController;
import javax.swing.*;
import java.awt.*;

public class ClasseGUI extends JFrame {
    private ClasseController controller;
    private JTextField idField, promotionField;
    private JComboBox<String> specialiteComboBox;
    private JLabel messageLabel;

    public ClasseGUI() {
        controller = new ClasseController();
        initComponents();
    }

    private void initComponents() {
        setTitle("Gestion des Classes");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();

        JLabel promotionLabel = new JLabel("Promotion:");
        promotionField = new JTextField();

        JLabel specialiteLabel = new JLabel("Spécialité:");
        specialiteComboBox = new JComboBox<>(new String[]{"MT", "IATIC", "TEST"});

        messageLabel = new JLabel("");

        JButton addButton = new JButton("Ajouter");
        addButton.addActionListener(e -> addClasse());

        JButton updateButton = new JButton("Modifier");
        updateButton.addActionListener(e -> updateClasse());

        JButton deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(e -> deleteClasse());

        add(idLabel); add(idField);
        add(promotionLabel); add(promotionField);
        add(specialiteLabel); add(specialiteComboBox);
        add(addButton); add(updateButton);
        add(deleteButton); add(messageLabel);
    }

    private void addClasse() {
        try {
            int promotion = Integer.parseInt(promotionField.getText());
            String specialite = (String) specialiteComboBox.getSelectedItem();
            controller.addClasse(promotion, specialite);
            messageLabel.setText("Classe ajoutée.");
        } catch (Exception e) {
            messageLabel.setText("Erreur: " + e.getMessage());
        }
    }

    private void updateClasse() {
        try {
            int id = Integer.parseInt(idField.getText());
            int promotion = Integer.parseInt(promotionField.getText());
            String specialite = (String) specialiteComboBox.getSelectedItem();
            controller.updateClasse(id, promotion, specialite);
            messageLabel.setText("Classe mise à jour.");
        } catch (Exception e) {
            messageLabel.setText("Erreur: " + e.getMessage());
        }
    }

    private void deleteClasse() {
        try {
            int id = Integer.parseInt(idField.getText());
            controller.deleteClasse(id);
            messageLabel.setText("Classe supprimée.");
        } catch (Exception e) {
            messageLabel.setText("Erreur: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClasseGUI().setVisible(true));
    }
}
