package model;

/**
 * Representa un servei disponible amb un identificador, nom i preu.
 * 
 * <p>Autor: Bilal</p>
 */
public class Servei {
    private int id;
    private String nom;
    private double preu;

    /**
     * Constructor per crear un servei amb id, nom i preu.
     * 
     * @param id Identificador del servei.
     * @param nom Nom descriptiu del servei.
     * @param preu Preu del servei.
     */
    public Servei(int id, String nom, double preu) {
        this.id = id;
        this.nom = nom;
        this.preu = preu;
    }

    /**
     * Retorna l'identificador del servei.
     * 
     * @return id del servei.
     */
    public int getId() { return id; }

    /**
     * Retorna el nom del servei.
     * 
     * @return nom del servei.
     */
    public String getNom() { return nom; }

    /**
     * Retorna el preu del servei.
     * 
     * @return preu del servei.
     */
    public double getPreu() { return preu; }

    /**
     * Assigna un nou identificador al servei.
     * 
     * @param id Nou id del servei.
     */
    public void setId(int id) { this.id = id; }

    /**
     * Assigna un nou nom al servei.
     * 
     * @param nom Nou nom del servei.
     */
    public void setNom(String nom) { this.nom = nom; }

    /**
     * Assigna un nou preu al servei.
     * 
     * @param preu Nou preu del servei.
     */
    public void setPreu(double preu) { this.preu = preu; }
}
