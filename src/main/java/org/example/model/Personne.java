package org.example.model;

public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private String type;

    public Personne(String nom, String prenom, String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
    }

    public Personne(int id, String nom, String prenom, String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
