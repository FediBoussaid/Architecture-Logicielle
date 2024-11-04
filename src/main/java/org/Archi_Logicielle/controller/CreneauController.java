package org.Archi_Logicielle.controller;

import org.Archi_Logicielle.dao.CreneauDAO;
import org.Archi_Logicielle.model.Creneau;

import java.time.LocalDateTime;

public class CreneauController {
    private CreneauDAO dao;

    public CreneauController() {
        this.dao = new CreneauDAO();
    }

    public void addCreneau(LocalDateTime debut, LocalDateTime fin) {
        Creneau creneau = new Creneau(debut, fin);
        dao.addCreneau(creneau);
    }

    public void updateCreneau(int id, LocalDateTime debut, LocalDateTime fin) {
        Creneau creneau = new Creneau(id, debut, fin);
        dao.updateCreneau(creneau);
    }

    public void deleteCreneau(int id) {
        dao.deleteCreneau(id);
    }
}