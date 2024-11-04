package org.example.view;

import org.example.controller.CreneauController;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreneauGUI extends JFrame {
    private CreneauController controller;
    private JTextField idField, debutField, finField;
    private JLabel messageLabel;

    public CreneauGUI() {
        controller = new CreneauController();
        initComponents();
    }

    private void initComponents() {
        setTitle("Gestion des Créneaux");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();

        JLabel debutLabel = new JLabel("Début (yyyy-MM-dd HH:mm:ss):");
        debutField = new JTextField();

        JLabel finLabel = new JLabel("Fin (yyyy-MM-dd HH:mm:ss):");
        finField = new JTextField();

        messageLabel = new JLabel("");

        JButton addButton = new JButton("Ajouter");
        addButton.addActionListener(e -> addCreneau());

        JButton updateButton = new JButton("Modifier");
        updateButton.addActionListener(e -> updateCreneau());

        JButton deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(e -> deleteCreneau());

        add(idLabel); add(idField);
        add(debutLabel); add(debutField);
        add(finLabel); add(finField);
        add(addButton); add(updateButton);
        add(deleteButton); add(messageLabel);
    }

    private void addCreneau() {
        try {
            LocalDateTime debut = LocalDateTime.parse(debutField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime fin = LocalDateTime.parse(finField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            controller.addCreneau(debut, fin);
            messageLabel.setText("Créneau ajouté.");
        } catch (Exception e) {
            messageLabel.setText("Erreur: " + e.getMessage());
        }
    }

    private void updateCreneau() {
        try {
            int id = Integer.parseInt(idField.getText());
            LocalDateTime debut = LocalDateTime.parse(debutField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime fin = LocalDateTime.parse(finField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            controller.updateCreneau(id, debut, fin);
            messageLabel.setText("Créneau mis à jour.");
        } catch (Exception e) {
            messageLabel.setText("Erreur: " + e.getMessage());
        }
    }

    private void deleteCreneau() {
        try {
            int id = Integer.parseInt(idField.getText());
            controller.deleteCreneau(id);
            messageLabel.setText("Créneau supprimé.");
        } catch (Exception e) {
            messageLabel.setText("Erreur: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CreneauGUI().setVisible(true));
    }
}
