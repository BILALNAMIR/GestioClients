package controller;

import javafx.scene.control.*;
import model.Client;
import model.ClientDAO;

public class ClientController {

    private TableView<Client> taulaClients;
    private TextField nomField;
    private TextField cognomsField;
    private TextField emailField;
    private TextField telefonField;

    public ClientController(TableView<Client> taulaClients, TextField nomField, TextField cognomsField, TextField emailField, TextField telefonField) {
        this.taulaClients = taulaClients;
        this.nomField = nomField;
        this.cognomsField = cognomsField;
        this.emailField = emailField;
        this.telefonField = telefonField;
    }

    public void carregarClients() {
        taulaClients.getItems().setAll(ClientDAO.getAllClients());
    }

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

    public void eliminarClient() {
        Client seleccionat = taulaClients.getSelectionModel().getSelectedItem();
        if (seleccionat != null) {
            ClientDAO.deleteClient(seleccionat.getId());
            carregarClients();
            buidarCamps();
        }
    }

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
            ClientDAO.deleteClient(seleccionat.getId());  // Elimina antic
            ClientDAO.insertClient(actualitzat);          // Insereix actualitzat
            carregarClients();
            buidarCamps();
        } catch (Exception e) {
            mostrarError("Error en modificar el client. Potser el nou client ja existeix.");
        }
    }

    private void buidarCamps() {
        nomField.clear();
        cognomsField.clear();
        emailField.clear();
        telefonField.clear();
    }

    private void mostrarError(String missatge) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(missatge);
        alert.showAndWait();
    }
}
