package controller;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Servei;
import model.ServeiDAO;

/**
 * Controlador per gestionar la interfície i les operacions relacionades amb els serveis.
 * Permet carregar, afegir i eliminar serveis mostrats en una taula.
 */
public class ServeiController {

    private TableView<Servei> taulaServeis;
    private TextField nomField;
    private TextField preuField;

    /**
     * Constructor que inicialitza el controlador amb els components de la UI.
     *
     * @param taulaServeis Taula on es mostraran els serveis.
     * @param nomField Camp de text per introduir el nom del servei.
     * @param preuField Camp de text per introduir el preu del servei.
     */
    public ServeiController(TableView<Servei> taulaServeis, TextField nomField, TextField preuField) {
        this.taulaServeis = taulaServeis;
        this.nomField = nomField;
        this.preuField = preuField;
    }

    /**
     * Carrega tots els serveis des de la base de dades i els mostra a la taula.
     */
    public void carregarServeis() {
        taulaServeis.getItems().setAll(ServeiDAO.getAllServeis());
    }

    /**
     * Afegeix un nou servei a la base de dades amb les dades introduïdes pels camps de text.
     * Valida que tots els camps estiguin plens i que el preu sigui un número vàlid.
     * Mostra un missatge d'error en cas contrari.
     */
    public void afegirServei() {
        String nom = nomField.getText();
        String preuText = preuField.getText();

        if (nom.isEmpty() || preuText.isEmpty()) {
            mostrarError("Tots els camps han d'estar plens.");
            return;
        }

        try {
            double preu = Double.parseDouble(preuText);
            Servei servei = new Servei(0, nom, preu);
            ServeiDAO.insertServei(servei);
            carregarServeis();
        } catch (NumberFormatException e) {
            mostrarError("El preu ha de ser un número vàlid.");
        }
    }

    /**
     * Elimina el servei seleccionat a la taula de la base de dades.
     */
    public void eliminarServei() {
        Servei serveiSeleccionat = taulaServeis.getSelectionModel().getSelectedItem();
        if (serveiSeleccionat != null) {
            ServeiDAO.deleteServei(serveiSeleccionat.getId());
            carregarServeis();
        }
    }

    /**
     * Mostra un missatge d'error.
     * Actualment escriu a la sortida d'error, però es pot substituir per una alerta de JavaFX.
     *
     * @param missatge El missatge d'error a mostrar.
     */
    private void mostrarError(String missatge) {
        System.err.println("ERROR: " + missatge);
        // Pots utilitzar una Alert de JavaFX si vols mostrar l'error a l'usuari.
    }
}
