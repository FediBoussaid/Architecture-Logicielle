package org.Archi_Logicielle.controller;

import org.Archi_Logicielle.dao.ClasseDAO;
import org.Archi_Logicielle.model.Classe;

public class ClasseController {
    private ClasseDAO dao;

    public ClasseController() {
        this.dao = new ClasseDAO();
    }

    public void addClasse(int promotion, String specialite) {
        Classe classe = new Classe(promotion, specialite);
        dao.addClasse(classe);
    }

    public void updateClasse(int id, int promotion, String specialite) {
        Classe classe = new Classe(id, promotion, specialite);
        dao.updateClasse(classe);
    }

    public void deleteClasse(int id) {
        dao.deleteClasse(id);
    }
}
