package controller;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Servei;
import model.ServeiDAO;

public class ServeiController {

    private TableView<Servei> taulaServeis;
    private TextField nomField;
    private TextField preuField;

    public ServeiController(TableView<Servei> taulaServeis, TextField nomField, TextField preuField) {
        this.taulaServeis = taulaServeis;
        this.nomField = nomField;
        this.preuField = preuField;
    }

    public void carregarServeis() {
        taulaServeis.getItems().setAll(ServeiDAO.getAllServeis());
    }

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

    public void eliminarServei() {
        Servei serveiSeleccionat = taulaServeis.getSelectionModel().getSelectedItem();
        if (serveiSeleccionat != null) {
            ServeiDAO.deleteServei(serveiSeleccionat.getId());
            carregarServeis();
        }
    }

    private void mostrarError(String missatge) {
        System.err.println("ERROR: " + missatge);
        // Pots utilitzar una Alert de JavaFX si vols mostrar l'error a l'usuari.
    }
}
