package org.example.model;

public class Classe {
    private int id;
    private int promotion;
    private String specialite;

    public Classe(int id, int promotion, String specialite) {
        this.id = id;
        this.promotion = promotion;
        this.specialite = specialite;
    }

    public Classe(int promotion, String specialite) {
        this.promotion = promotion;
        this.specialite = specialite;
    }

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPromotion() { return promotion; }
    public void setPromotion(int promotion) { this.promotion = promotion; }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }
}
