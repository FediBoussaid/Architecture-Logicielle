package org.Archi_Logicielle.view;

import org.Archi_Logicielle.controller.UniteEnseignementController;
import org.Archi_Logicielle.model.UniteEnseignement;
import org.Archi_Logicielle.dao.UniteEnseignementDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UniteEnseignementGUI extends JFrame {

    private UniteEnseignementController controller;
    private JTextField codeField;
    private JTextField designationField;
    private JLabel messageLabel;

    public UniteEnseignementGUI() {
        setTitle("Gestion des Unités d'Enseignement - UVSQ");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Couleur bordeaux de l'UVSQ
        Color bordeaux = new Color(102, 0, 0);

        // Panneau supérieur pour le logo
        JPanel topPanel = new JPanel();
        topPanel.setBackground(bordeaux);
        JLabel logoLabel = new JLabel(new ImageIcon("path/to/uvsq_logo.png")); // Remplacez "path/to/uvsq_logo.png" par le chemin de votre logo
        topPanel.add(logoLabel);
        add(topPanel, BorderLayout.NORTH);

        // Panneau central pour les champs de saisie
        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        centerPanel.setBackground(Color.WHITE);

        JLabel codeLabel = new JLabel("Code:");
        codeLabel.setForeground(bordeaux);
        centerPanel.add(codeLabel);

        codeField = new JTextField(10);
        centerPanel.add(codeField);

        JLabel designationLabel = new JLabel("Désignation:");
        designationLabel.setForeground(bordeaux);
        centerPanel.add(designationLabel);

        designationField = new JTextField(20);
        centerPanel.add(designationField);

        add(centerPanel, BorderLayout.CENTER);

        // Panneau inférieur pour les boutons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(bordeaux);

        JButton addButton = new JButton("Ajouter");
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(bordeaux);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterUniteEnseignement();
            }
        });

        bottomPanel.add(addButton);

        messageLabel = new JLabel("");
        messageLabel.setForeground(bordeaux);
        bottomPanel.add(messageLabel);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void ajouterUniteEnseignement() {
        String code = codeField.getText();
        String designation = designationField.getText();

        if (code.isEmpty() || designation.isEmpty()) {
            messageLabel.setText("Veuillez remplir tous les champs.");
            return;
        }

        UniteEnseignement unite = new UniteEnseignement(code, designation);
        UniteEnseignementDAO dao = new UniteEnseignementDAO();

        dao.addUniteEnseignement(unite); // Ajouter l'unité d'enseignement à la base de données

        messageLabel.setText("Unité d'enseignement ajoutée avec succès !");
        codeField.setText("");
        designationField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UniteEnseignementGUI frame = new UniteEnseignementGUI();
            frame.setVisible(true);
        });
    }
}
