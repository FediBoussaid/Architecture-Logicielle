package org.example.view;

import org.example.controller.PersonneController;
import org.example.model.Personne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonneGUI extends JFrame {
    private JTextField idField;
    private JTextField nomField;
    private JTextField prenomField;
    private JComboBox<String> typeComboBox;
    private JLabel messageLabel;
    private PersonneController controller;

    public PersonneGUI() {
        setTitle("Gestion des Personnes - UVSQ");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        controller = new PersonneController();

        // Haut : choix de l'action
        JPanel topPanel = new JPanel();
        JButton addButton = new JButton("Ajouter");
        JButton updateButton = new JButton("Modifier");
        JButton deleteButton = new JButton("Supprimer");

        addButton.addActionListener(e -> openForm("add"));
        updateButton.addActionListener(e -> openForm("update"));
        deleteButton.addActionListener(e -> openForm("delete"));

        topPanel.add(addButton);
        topPanel.add(updateButton);
        topPanel.add(deleteButton);
        add(topPanel, BorderLayout.NORTH);

        // Centre : formulaire de saisie
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(new JLabel("ID (pour modifier/supprimer) :"));
        idField = new JTextField();
        formPanel.add(idField);

        formPanel.add(new JLabel("Nom :"));
        nomField = new JTextField();
        formPanel.add(nomField);

        formPanel.add(new JLabel("Prénom :"));
        prenomField = new JTextField();
        formPanel.add(prenomField);

        formPanel.add(new JLabel("Type :"));
        typeComboBox = new JComboBox<>(new String[]{"enseignant", "eleve"});
        formPanel.add(typeComboBox);

        add(formPanel, BorderLayout.CENTER);

        // Bas : message et actions
        JPanel bottomPanel = new JPanel();
        JButton actionButton = new JButton("Confirmer");
        messageLabel = new JLabel("");

        actionButton.addActionListener(e -> performAction());
        bottomPanel.add(actionButton);
        bottomPanel.add(messageLabel);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void openForm(String action) {
        // Ouvrir le formulaire et activer le champ ID uniquement pour modifier/supprimer
        idField.setEnabled(action.equals("update") || action.equals("delete"));
        nomField.setEnabled(!action.equals("delete"));
        prenomField.setEnabled(!action.equals("delete"));
        typeComboBox.setEnabled(!action.equals("delete"));
    }

    private void performAction() {
        // Logique pour ajouter, modifier ou supprimer une personne
        try {
            int id = idField.getText().isEmpty() ? 0 : Integer.parseInt(idField.getText());
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            String type = (String) typeComboBox.getSelectedItem();

            if (idField.isEnabled()) {
                controller.updatePersonne(new Personne(id, nom, prenom, type));
                messageLabel.setText("Personne mise à jour.");
            } else {
                controller.addPersonne(new Personne(nom, prenom, type));
                messageLabel.setText("Personne ajoutée.");
            }
        } catch (Exception e) {
            messageLabel.setText("Erreur : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PersonneGUI().setVisible(true));
    }
}
