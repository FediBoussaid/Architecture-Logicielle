package org.Archi_Logicielle.model;

public class Session {
    private int id;
    private String identifiant;
    private int idUE;        // Référence à l'unité d'enseignement
    private int idClasse;    // Référence à la classe
    private int idCreneau;   // Référence au créneau

    public Session(int id, String identifiant, int idUE, int idClasse, int idCreneau) {
        this.id = id;
        this.identifiant = identifiant;
        this.idUE = idUE;
        this.idClasse = idClasse;
        this.idCreneau = idCreneau;
    }

    public Session(String identifiant, int idUE, int idClasse, int idCreneau) {
        this.identifiant = identifiant;
        this.idUE = idUE;
        this.idClasse = idClasse;
        this.idCreneau = idCreneau;
    }

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getIdentifiant() { return identifiant; }
    public void setIdentifiant(String identifiant) { this.identifiant = identifiant; }

    public int getIdUE() { return idUE; }
    public void setIdUE(int idUE) { this.idUE = idUE; }

    public int getIdClasse() { return idClasse; }
    public void setIdClasse(int idClasse) { this.idClasse = idClasse; }

    public int getIdCreneau() { return idCreneau; }
    public void setIdCreneau(int idCreneau) { this.idCreneau = idCreneau; }


}
