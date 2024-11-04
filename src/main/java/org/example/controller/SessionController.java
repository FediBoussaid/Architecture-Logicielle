package org.example.controller;

import org.example.dao.SessionDAO;
import org.example.model.Session;

public class SessionController {
    private SessionDAO dao;

    public SessionController() {
        this.dao = new SessionDAO();
    }

    public void addSession(String identifiant, int idUE, int idClasse, int idCreneau) {
        Session session = new Session(identifiant, idUE, idClasse, idCreneau);
        dao.addSession(session);
    }

    public void updateSession(int id, String identifiant, int idUE, int idClasse, int idCreneau) {
        Session session = new Session(id, identifiant, idUE, idClasse, idCreneau);
        dao.updateSession(session);
    }

    public void deleteSession(int id) {
        dao.deleteSession(id);
    }
}
