package controller;

import javafx.scene.control.TableView;
import model.LogConsulta;
import model.LogConsultaDAO;

public class LogConsultesController {
    private TableView<LogConsulta> taulaLogs;

    public LogConsultesController(TableView<LogConsulta> taulaLogs) {
        this.taulaLogs = taulaLogs;
    }

    public void carregarLogs() {
        taulaLogs.getItems().setAll(LogConsultaDAO.getAllLogs());
    }
}
