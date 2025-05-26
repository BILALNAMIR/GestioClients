package model;

/**
 * Representa un client amb informació personal com el nom, cognoms, email i telèfon.
 *
 * <p>Utilitzat en la gestió de clients dins del sistema Bilstyl.</p>
 *
 * @author Bilal
 */
public class Client {
    private int id;
    private String nom;
    private String cognoms;
    private String email;
    private String telefon;

    /**
     * Constructor per crear una instància de {@code Client}.
     *
     * @param id       L'identificador únic del client.
     * @param nom      El nom del client.
     * @param cognoms  Els cognoms del client.
     * @param email    L'adreça electrònica del client.
     * @param telefon  El número de telèfon del client.
     */
    public Client(int id, String nom, String cognoms, String email, String telefon) {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
        this.email = email;
        this.telefon = telefon;
    }

    /**
     * Retorna l'ID del client.
     *
     * @return L'identificador del client.
     */
    public int getId() { return id; }

    /**
     * Estableix l'ID del client.
     *
     * @param id L'identificador a assignar.
     */
    public void setId(int id) { this.id = id; }

    /**
     * Retorna el nom del client.
     *
     * @return El nom del client.
     */
    public String getNom() { return nom; }

    /**
     * Estableix el nom del client.
     *
     * @param nom El nom a assignar.
     */
    public void setNom(String nom) { this.nom = nom; }

    /**
     * Retorna els cognoms del client.
     *
     * @return Els cognoms del client.
     */
    public String getCognoms() { return cognoms; }

    /**
     * Estableix els cognoms del client.
     *
     * @param cognoms Els cognoms a assignar.
     */
    public void setCognoms(String cognoms) { this.cognoms = cognoms; }

    /**
     * Retorna l'email del client.
     *
     * @return L'adreça electrònica del client.
     */
    public String getEmail() { return email; }

    /**
     * Estableix l'email del client.
     *
     * @param email L'adreça electrònica a assignar.
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Retorna el número de telèfon del client.
     *
     * @return El telèfon del client.
     */
    public String getTelefon() { return telefon; }

    /**
     * Estableix el número de telèfon del client.
     *
     * @param telefon El telèfon a assignar.
     */
    public void setTelefon(String telefon) { this.telefon = telefon; }
}
