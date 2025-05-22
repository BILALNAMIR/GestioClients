package view;

import controller.ClientController;
import controller.ServeiController;
import controller.LogConsultesController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Client;
import model.Servei;
import model.LogConsulta;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        // ----------- PESTANYA CLIENTS -----------
        TableView<Client> taulaClients = new TableView<>();

        TableColumn<Client, String> colNom = new TableColumn<>("Nom");
        colNom.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getNom()));
        TableColumn<Client, String> colCognoms = new TableColumn<>("Cognoms");
        colCognoms.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getCognoms()));
        TableColumn<Client, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getEmail()));
        TableColumn<Client, String> colTelefon = new TableColumn<>("Telèfon");
        colTelefon.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getTelefon()));

        taulaClients.getColumns().addAll(colNom, colCognoms, colEmail, colTelefon);

        TextField nomField = new TextField(); nomField.setPromptText("Nom");
        TextField cognomsField = new TextField(); cognomsField.setPromptText("Cognoms");
        TextField emailField = new TextField(); emailField.setPromptText("Email");
        TextField telefonField = new TextField(); telefonField.setPromptText("Telèfon");

        Button afegirBtn = new Button("Afegir");
        Button eliminarBtn = new Button("Eliminar");
        Button modificarBtn = new Button("Modificar");

        ClientController clientController = new ClientController(taulaClients, nomField, cognomsField, emailField, telefonField);
        clientController.carregarClients();

        afegirBtn.setOnAction(e -> clientController.afegirClient());
        eliminarBtn.setOnAction(e -> clientController.eliminarClient());
        modificarBtn.setOnAction(e -> clientController.modificarClient());

        taulaClients.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                nomField.setText(newSel.getNom());
                cognomsField.setText(newSel.getCognoms());
                emailField.setText(newSel.getEmail());
                telefonField.setText(newSel.getTelefon());
            }
        });

        VBox formClients = new VBox(5, nomField, cognomsField, emailField, telefonField, afegirBtn, eliminarBtn, modificarBtn);
        VBox layoutClients = new VBox(10, formClients, taulaClients);
        Tab tabClients = new Tab("Clients", layoutClients);

        // ----------- PESTANYA SERVEIS -----------
        TableView<Servei> taulaServeis = new TableView<>();

        TableColumn<Servei, String> colNomServei = new TableColumn<>("Nom Servei");
        colNomServei.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getNom()));
        TableColumn<Servei, String> colPreuServei = new TableColumn<>("Preu");
        colPreuServei.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cell.getValue().getPreu())));

        taulaServeis.getColumns().addAll(colNomServei, colPreuServei);

        TextField nomServeiField = new TextField(); nomServeiField.setPromptText("Nom del Servei");
        TextField preuServeiField = new TextField(); preuServeiField.setPromptText("Preu");

        Button afegirServeiBtn = new Button("Afegir Servei");
        Button eliminarServeiBtn = new Button("Eliminar Servei");

        ServeiController serveiController = new ServeiController(taulaServeis, nomServeiField, preuServeiField);
        serveiController.carregarServeis();

        afegirServeiBtn.setOnAction(e -> serveiController.afegirServei());
        eliminarServeiBtn.setOnAction(e -> serveiController.eliminarServei());

        VBox formServeis = new VBox(5, nomServeiField, preuServeiField, afegirServeiBtn, eliminarServeiBtn);
        VBox layoutServeis = new VBox(10, formServeis, taulaServeis);
        Tab tabServeis = new Tab("Serveis", layoutServeis);

        // ----------- PESTANYA LOG CONSULTES -----------
        TableView<LogConsulta> taulaLogs = new TableView<>();

        TableColumn<LogConsulta, String> colTaula = new TableColumn<>("Taula");
        colTaula.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getTaulaConsultada()));
        TableColumn<LogConsulta, String> colData = new TableColumn<>("Data Consulta");
        colData.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getDataConsulta().toString()));

        taulaLogs.getColumns().addAll(colTaula, colData);

        LogConsultesController logController = new LogConsultesController(taulaLogs);
        logController.carregarLogs();

        VBox layoutLogs = new VBox(10, taulaLogs);
        Tab tabLogs = new Tab("Logs", layoutLogs);

        // ----------- TABS PRINCIPALS -----------
        TabPane pestanyes = new TabPane(tabClients, tabServeis, tabLogs);
        pestanyes.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Scene escena = new Scene(pestanyes, 900, 600);
        stage.setScene(escena);
        stage.setTitle("Gestió Bilstyl - Clients, Serveis i Logs");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
