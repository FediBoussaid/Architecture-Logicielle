package org.example.controller;

import org.example.model.UniteEnseignement;
import org.example.view.UniteEnseignementView;

public class UniteEnseignementController {
    private UniteEnseignement model;
    private UniteEnseignementView view;

    public UniteEnseignementController(UniteEnseignement model, UniteEnseignementView view) {
        this.model = model;
        this.view = view;
    }

    public void setUniteEnseignementCode(String code) {
        model.setCode(code);
    }

    public String getUniteEnseignementCode() {
        return model.getCode();
    }

    public void setUniteEnseignementDesignation(String designation) {
        model.setDesignation(designation);
    }

    public String getUniteEnseignementDesignation() {
        return model.getDesignation();
    }

    public void updateView() {
        view.printUniteEnseignementDetails(model);
    }
}
