package org.Archi_Logicielle.view;

import org.Archi_Logicielle.model.UniteEnseignement;

public class UniteEnseignementView {
    public void printUniteEnseignementDetails(UniteEnseignement unite) {
        System.out.println("Code: " + unite.getCode());
        System.out.println("Désignation: " + unite.getDesignation());
    }
}
