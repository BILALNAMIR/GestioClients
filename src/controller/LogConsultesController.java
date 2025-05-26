package controller;

import javafx.scene.control.TableView;
import model.LogConsulta;
import model.LogConsultaDAO;

/**
 * Controlador per gestionar la visualització dels logs de consultes.
 * Permet carregar i mostrar els logs a la taula associada.
 */
public class LogConsultesController {
    private TableView<LogConsulta> taulaLogs;

    /**
     * Constructor que inicialitza el controlador amb la taula on es mostraran els logs.
     * 
     * @param taulaLogs Taula on es mostraran els logs de consultes.
     */
    public LogConsultesController(TableView<LogConsulta> taulaLogs) {
        this.taulaLogs = taulaLogs;
    }

    /**
     * Carrega tots els logs de consultes des de la base de dades i els mostra a la taula.
     */
    public void carregarLogs() {
        taulaLogs.getItems().setAll(LogConsultaDAO.getAllLogs());
    }
}
