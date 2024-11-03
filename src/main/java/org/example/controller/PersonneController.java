package org.example.controller;

import org.example.dao.PersonneDAO;
import org.example.model.Personne;

public class PersonneController {
    private PersonneDAO dao = new PersonneDAO();

    public void addPersonne(Personne personne) {
        dao.addPersonne(personne);
    }

    public void updatePersonne(Personne personne) {
        dao.updatePersonne(personne);
    }

    public void deletePersonne(int id) {
        dao.deletePersonne(id);
    }
}
