package org.example;

import org.example.model.UniteEnseignement;
import org.example.view.UniteEnseignementView;
import org.example.controller.UniteEnseignementController;
import org.example.dao.UniteEnseignementDAO;

public class Main {
    public static void main(String[] args) {
        UniteEnseignement model = new UniteEnseignement("UE001", "Introduction à la Programmation");
        UniteEnseignementView view = new UniteEnseignementView();
        UniteEnseignementController controller = new UniteEnseignementController(model, view);

        // Ajouter l'unité d'enseignement à la base de données
        UniteEnseignementDAO dao = new UniteEnseignementDAO();
        dao.addUniteEnseignement(model);

        // Afficher les détails de l'unité d'enseignement
        controller.updateView();
    }
}
