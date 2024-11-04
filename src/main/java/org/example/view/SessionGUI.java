package org.example.view;

import org.example.controller.SessionController;
import javax.swing.*;
import java.awt.*;

public class SessionGUI extends JFrame {
    private SessionController controller;
    private JTextField idField, identifiantField, idUEField, idClasseField, idCreneauField;
    private JLabel messageLabel;

    public SessionGUI() {
        controller = new SessionController();
        initComponents();
    }

    private void initComponents() {
        setTitle("Gestion des Sessions");
        setSize(400, 300);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Espacement autour des composants

        // Ajout du logo (assurez-vous d'avoir l'image dans le bon chemin)
        JLabel logoLabel = new JLabel(new ImageIcon("path/to/uvsq_logo.png"));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        add(logoLabel, gbc);

        // ID Field
        JLabel idLabel = new JLabel("ID:");
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; gbc.anchor = GridBagConstraints.EAST;
        add(idLabel, gbc);
        idField = new JTextField(20);
        idField.setEditable(false); // Non modifiable
        gbc.gridx = 1; add(idField, gbc);

        // Identifiant Field
        JLabel identifiantLabel = new JLabel("Identifiant:");
        gbc.gridx = 0; gbc.gridy = 2; add(identifiantLabel, gbc);
        identifiantField = new JTextField(20);
        gbc.gridx = 1; add(identifiantField, gbc);

        // ID Unité d'Enseignement Field
        JLabel idUELabel = new JLabel("ID Unité d'Enseignement:");
        gbc.gridx = 0; gbc.gridy = 3; add(idUELabel, gbc);
        idUEField = new JTextField(20);
        gbc.gridx = 1; add(idUEField, gbc);

        // ID Classe Field
        JLabel idClasseLabel = new JLabel("ID Classe:");
        gbc.gridx = 0; gbc.gridy = 4; add(idClasseLabel, gbc);
        idClasseField = new JTextField(20);
        gbc.gridx = 1; add(idClasseField, gbc);

        // ID Créneau Field
        JLabel idCreneauLabel = new JLabel("ID Créneau:");
        gbc.gridx = 0; gbc.gridy = 5; add(idCreneauLabel, gbc);
        idCreneauField = new JTextField(20);
        gbc.gridx = 1; add(idCreneauField, gbc);

        // Buttons
        JButton addButton = new JButton("Ajouter");
        addButton.addActionListener(e -> addSession());
        gbc.gridx = 0; gbc.gridy = 6; add(addButton, gbc);

        JButton updateButton = new JButton("Modifier");
        updateButton.addActionListener(e -> updateSession());
        gbc.gridx = 1; add(updateButton, gbc);

        JButton deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(e -> deleteSession());
        gbc.gridx = 0; gbc.gridy = 7; add(deleteButton, gbc);

        // Message Label
        messageLabel = new JLabel("");
        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        add(messageLabel, gbc);

        // Finaliser la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void addSession() {
        try {
            String identifiant = identifiantField.getText();
            int idUE = Integer.parseInt(idUEField.getText());
            int idClasse = Integer.parseInt(idClasseField.getText());
            int idCreneau = Integer.parseInt(idCreneauField.getText());
            controller.addSession(identifiant, idUE, idClasse, idCreneau);
            messageLabel.setText("Session ajoutée.");
        } catch (Exception e) {
            messageLabel.setText("Erreur: " + e.getMessage());
        }
    }

    private void updateSession() {
        try {
            int id = Integer.parseInt(idField.getText());
            String identifiant = identifiantField.getText();
            int idUE = Integer.parseInt(idUEField.getText());
            int idClasse = Integer.parseInt(idClasseField.getText());
            int idCreneau = Integer.parseInt(idCreneauField.getText());
            controller.updateSession(id, identifiant, idUE, idClasse, idCreneau);
            messageLabel.setText("Session mise à jour.");
        } catch (Exception e) {
            messageLabel.setText("Erreur: " + e.getMessage());
        }
    }

    private void deleteSession() {
        try {
            int id = Integer.parseInt(idField.getText());
            controller.deleteSession(id);
            messageLabel.setText("Session supprimée.");
        } catch (Exception e) {
            messageLabel.setText("Erreur: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SessionGUI().setVisible(true));
    }
}
