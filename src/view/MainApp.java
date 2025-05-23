package view;

import controller.ClientController;
import controller.LogConsultesController;
import controller.ServeiController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.*;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        // ---------- Pestanya CLIENTS ----------
        TableView<Client> taulaClients = new TableView<>();

        TableColumn<Client, String> colIdClient = new TableColumn<>("ID");
        colIdClient.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cell.getValue().getId())));
        TableColumn<Client, String> colNom = new TableColumn<>("Nom");
        colNom.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getNom()));
        TableColumn<Client, String> colCognoms = new TableColumn<>("Cognoms");
        colCognoms.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getCognoms()));
        TableColumn<Client, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getEmail()));
        TableColumn<Client, String> colTelefon = new TableColumn<>("Telèfon");
        colTelefon.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getTelefon()));

        taulaClients.getColumns().addAll(colIdClient, colNom, colCognoms, colEmail, colTelefon);

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

        TableView<Reserva> taulaMiniReserves = new TableView<>();
        taulaMiniReserves.setPrefHeight(250);

        TableColumn<Reserva, String> miniCita = new TableColumn<>("ID Cita");
        miniCita.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cell.getValue().getIdCita())));
        TableColumn<Reserva, String> miniData = new TableColumn<>("Data");
        miniData.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getDataReserva().toString()));

        taulaMiniReserves.getColumns().addAll(miniCita, miniData);

        taulaClients.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                nomField.setText(newSel.getNom());
                cognomsField.setText(newSel.getCognoms());
                emailField.setText(newSel.getEmail());
                telefonField.setText(newSel.getTelefon());

                taulaMiniReserves.getItems().setAll(ReservaDAO.getReservesPerClient(newSel.getId()));
            }
        });

        VBox formClients = new VBox(5, nomField, cognomsField, emailField, telefonField, afegirBtn, eliminarBtn, modificarBtn);
        VBox layoutClients = new VBox(10,
                new Label("Formulari de client"), formClients,
                new Label("Llista de clients"), taulaClients,
                new Label("Reserves del client seleccionat"), taulaMiniReserves
        );
        Tab tabClients = new Tab("Clients", layoutClients);

        // ---------- Pestanya SERVEIS ----------
        TableView<Servei> taulaServeis = new TableView<>();

        TableColumn<Servei, String> colIdServei = new TableColumn<>("ID");
        colIdServei.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cell.getValue().getId())));
        TableColumn<Servei, String> colServeiNom = new TableColumn<>("Nom Servei");
        colServeiNom.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getNom()));
        TableColumn<Servei, String> colServeiPreu = new TableColumn<>("Preu");
        colServeiPreu.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cell.getValue().getPreu())));

        taulaServeis.getColumns().addAll(colIdServei, colServeiNom, colServeiPreu);

        TextField nomServeiField = new TextField(); nomServeiField.setPromptText("Nom del Servei");
        TextField preuServeiField = new TextField(); preuServeiField.setPromptText("Preu");

        Button afegirServeiBtn = new Button("Afegir Servei");
        Button eliminarServeiBtn = new Button("Eliminar Servei");

        ServeiController serveiController = new ServeiController(taulaServeis, nomServeiField, preuServeiField);
        serveiController.carregarServeis();

        afegirServeiBtn.setOnAction(e -> serveiController.afegirServei());
        eliminarServeiBtn.setOnAction(e -> serveiController.eliminarServei());

        VBox formServeis = new VBox(5, nomServeiField, preuServeiField, afegirServeiBtn, eliminarServeiBtn);
        VBox layoutServeis = new VBox(10, new Label("Formulari de Servei"), formServeis, taulaServeis);
        Tab tabServeis = new Tab("Serveis", layoutServeis);

        // ---------- Pestanya LOG CONSULTES ----------
        TableView<LogConsulta> taulaLogs = new TableView<>();

        TableColumn<LogConsulta, String> colIdLog = new TableColumn<>("ID Log");
        colIdLog.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cell.getValue().getIdLog())));
        TableColumn<LogConsulta, String> colTaula = new TableColumn<>("Taula");
        colTaula.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getTaulaConsultada()));
        TableColumn<LogConsulta, String> colData = new TableColumn<>("Data Consulta");
        colData.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getDataConsulta().toString()));

        taulaLogs.getColumns().addAll(colIdLog, colTaula, colData);

        LogConsultesController logController = new LogConsultesController(taulaLogs);
        logController.carregarLogs();

        VBox layoutLogs = new VBox(10, taulaLogs);
        Tab tabLogs = new Tab("Logs", layoutLogs);

        // ---------- Pestanya RESERVES ----------
        TableView<ReservaDetallada> taulaReserves = new TableView<>();

        TableColumn<ReservaDetallada, String> colResId = new TableColumn<>("ID Reserva");
        colResId.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cell.getValue().getIdReserva())));
        TableColumn<ReservaDetallada, String> colResClient = new TableColumn<>("ID Client");
        colResClient.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cell.getValue().getIdClient())));
        TableColumn<ReservaDetallada, String> colResCita = new TableColumn<>("ID Cita");
        colResCita.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cell.getValue().getIdCita())));
        TableColumn<ReservaDetallada, String> colResServei = new TableColumn<>("ID Servei");
        colResServei.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cell.getValue().getIdServei())));
        TableColumn<ReservaDetallada, String> colResData = new TableColumn<>("Data Reserva");
        colResData.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getDataReserva().toString()));

        taulaReserves.getColumns().addAll(colResId, colResClient, colResCita, colResServei, colResData);
        taulaReserves.getItems().setAll(ReservaDAO.getReservesAmbServei());

        VBox layoutReserva = new VBox(10, taulaReserves);
        Tab tabReserves = new Tab("Reserves", layoutReserva);

        // ---------- Pestanyes ----------
        TabPane pestanyes = new TabPane(tabClients, tabServeis, tabLogs, tabReserves);
        pestanyes.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Scene escena = new Scene(pestanyes, 1000, 750);
        stage.setScene(escena);
        stage.setTitle("Gestió Bilstyl - Clients, Serveis, Logs i Reserves");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
