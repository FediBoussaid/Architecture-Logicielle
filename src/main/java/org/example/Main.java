package org.example;

import org.example.view.ClasseGUI;
import org.example.view.CreneauGUI;
import org.example.view.SessionGUI;
import org.example.view.UniteEnseignementGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenuGUI mainMenu = new MainMenuGUI();
            mainMenu.setVisible(true);
        });
    }
}


class MainMenuGUI extends JFrame {

    public MainMenuGUI() {
        setTitle("Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        // Définir la mise en page
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Créer les boutons
        JButton unitButton = new JButton("Gestion Unité d'Enseignement");
        unitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new UniteEnseignementGUI().setVisible(true);
            }
        });

        JButton classButton = new JButton("Gestion Classe");
        classButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ClasseGUI().setVisible(true);
            }
        });

        JButton creneauButton = new JButton("Gestion Créneau");
        creneauButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CreneauGUI().setVisible(true);
            }
        });

        JButton sessionButton = new JButton("Gestion Session");
        sessionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SessionGUI().setVisible(true);
            }
        });

        // Ajouter les boutons à la fenêtre
        gbc.gridx = 0; gbc.gridy = 0; add(unitButton, gbc);
        gbc.gridx = 0; gbc.gridy = 1; add(classButton, gbc);
        gbc.gridx = 0; gbc.gridy = 2; add(creneauButton, gbc);
        gbc.gridx = 0; gbc.gridy = 3; add(sessionButton, gbc);
    }
}
