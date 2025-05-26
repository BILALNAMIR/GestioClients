package controller;

import javafx.scene.control.*;
import model.Client;
import model.ClientDAO;

/**
 * Controlador per gestionar la interfície i operacions relacionades amb clients.
 * Permet carregar, afegir, modificar i eliminar clients, així com gestionar els camps de text i mostrar errors.
 */
public class ClientController {

    private TableView<Client> taulaClients;
    private TextField nomField;
    private TextField cognomsField;
    private TextField emailField;
    private TextField telefonField;

    /**
     * Constructor que inicialitza el controlador amb els components gràfics.
     * 
     * @param taulaClients Taula on es mostren els clients.
     * @param nomField Camp de text per al nom.
     * @param cognomsField Camp de text per als cognoms.
     * @param emailField Camp de text per a l'email.
     * @param telefonField Camp de text per al telèfon.
     */
    public ClientController(TableView<Client> taulaClients, TextField nomField, TextField cognomsField, TextField emailField, TextField telefonField) {
        this.taulaClients = taulaClients;
        this.nomField = nomField;
        this.cognomsField = cognomsField;
        this.emailField = emailField;
        this.telefonField = telefonField;
    }

    /**
     * Carrega tots els clients de la base de dades i els mostra a la taula.
     */
    public void carregarClients() {
        taulaClients.getItems().setAll(ClientDAO.getAllClients());
    }

    /**
     * Afegeix un nou client amb les dades dels camps de text.
     * Si algun camp està buit, mostra un missatge d'error.
     */
    public void afegirClient() {
        String nom = nomField.getText();
        String cognoms = cognomsField.getText();
        String email = emailField.getText();
        String telefon = telefonField.getText();

        if (nom.isEmpty() || cognoms.isEmpty() || email.isEmpty() || telefon.isEmpty()) {
            mostrarError("Tots els camps han d'estar plens.");
            return;
        }

        Client client = new Client(0, nom, cognoms, email, telefon);

        try {
            ClientDAO.insertClient(client);
            carregarClients();
            buidarCamps();
        } catch (Exception e) {
            mostrarError("No s'ha pogut afegir el client. Potser ja existeix.");
        }
    }

    /**
     * Elimina el client seleccionat a la taula.
     * Si no hi ha cap client seleccionat, no fa res.
     */
    public void eliminarClient() {
        Client seleccionat = taulaClients.getSelectionModel().getSelectedItem();
        if (seleccionat != null) {
            ClientDAO.deleteClient(seleccionat.getId());
            carregarClients();
            buidarCamps();
        }
    }

    /**
     * Modifica el client seleccionat amb les dades dels camps de text.
     * Si no hi ha cap client seleccionat o algun camp està buit, mostra un error.
     */
    public void modificarClient() {
        Client seleccionat = taulaClients.getSelectionModel().getSelectedItem();
        if (seleccionat == null) {
            mostrarError("Has de seleccionar un client per modificar-lo.");
            return;
        }

        String nom = nomField.getText();
        String cognoms = cognomsField.getText();
        String email = emailField.getText();
        String telefon = telefonField.getText();

        if (nom.isEmpty() || cognoms.isEmpty() || email.isEmpty() || telefon.isEmpty()) {
            mostrarError("Tots els camps han d'estar plens.");
            return;
        }

        Client actualitzat = new Client(seleccionat.getId(), nom, cognoms, email, telefon);

        try {
            // No hi ha un mètode update, per això es fa delete + insert
            ClientDAO.deleteClient(seleccionat.getId());
            ClientDAO.insertClient(actualitzat);
            carregarClients();
            buidarCamps();
        } catch (Exception e) {
            mostrarError("Error en modificar el client. Potser el nou client ja existeix.");
        }
    }

    /**
     * Neteja els camps de text.
     */
    private void buidarCamps() {
        nomField.clear();
        cognomsField.clear();
        emailField.clear();
        telefonField.clear();
    }

    /**
     * Mostra una alerta d'error amb el missatge indicat.
     * 
     * @param missatge Missatge d'error a mostrar.
     */
    private void mostrarError(String missatge) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(missatge);
        alert.showAndWait();
    }
}
