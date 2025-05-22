package model;

public class Servei {
    private int id;
    private String nom;
    private double preu;

    public Servei(int id, String nom, double preu) {
        this.id = id;
        this.nom = nom;
        this.preu = preu;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public double getPreu() { return preu; }

    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPreu(double preu) { this.preu = preu; }
}
