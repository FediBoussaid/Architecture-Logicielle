package org.example.model;

public class UniteEnseignement {
    private int id;
    private String code;
    private String designation;

    // Constructeur
    public UniteEnseignement(String code, String designation) {
        this.code = code;
        this.designation = designation;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
