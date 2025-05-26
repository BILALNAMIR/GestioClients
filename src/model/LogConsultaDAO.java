package model;

import utils.DatabaseConnection;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO (Data Access Object) per accedir a les dades de la taula
 * {@code log_consultes} de la base de dades.
 *
 * <p>Permet recuperar tots els logs registrats, ordenats per data de consulta
 * en ordre descendent.</p>
 *
 * <p>Autor: Bilal</p>
 */
public class LogConsultaDAO {

    /**
     * Recupera tots els logs de consultes registrats a la base de dades.
     *
     * @return Llista de {@link LogConsulta} amb totes les consultes registrades.
     */
    public static List<LogConsulta> getAllLogs() {
        List<LogConsulta> llista = new ArrayList<>();
        String sql = "SELECT * FROM log_consultes ORDER BY data_consulta DESC";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                LogConsulta log = new LogConsulta(
                    rs.getInt("id_log"),
                    rs.getString("taula_consultada"),
                    rs.getTimestamp("data_consulta").toLocalDateTime()
                );
                llista.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return llista;
    }
}
