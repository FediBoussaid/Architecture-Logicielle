package org.example.view;

import org.example.model.UniteEnseignement;

public class UniteEnseignementView {
    public void printUniteEnseignementDetails(UniteEnseignement unite) {
        System.out.println("Code: " + unite.getCode());
        System.out.println("Désignation: " + unite.getDesignation());
    }
}
