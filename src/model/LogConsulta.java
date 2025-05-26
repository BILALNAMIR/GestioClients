package model;

import java.time.LocalDateTime;

/**
 * Classe que representa un registre de consulta (log) realitzat sobre una taula
 * de la base de dades.
 *
 * <p>Conté informació sobre la taula consultada, la data de la consulta i un
 * identificador únic del log.</p>
 *
 * <p>Autor: Bilal</p>
 */
public class LogConsulta {
    private int idLog;
    private String taulaConsultada;
    private LocalDateTime dataConsulta;

    /**
     * Constructor per inicialitzar un objecte {@code LogConsulta}.
     *
     * @param idLog           Identificador únic del log.
     * @param taulaConsultada Nom de la taula consultada.
     * @param dataConsulta    Data i hora en què es va fer la consulta.
     */
    public LogConsulta(int idLog, String taulaConsultada, LocalDateTime dataConsulta) {
        this.idLog = idLog;
        this.taulaConsultada = taulaConsultada;
        this.dataConsulta = dataConsulta;
    }

    /**
     * Retorna l'identificador del log.
     *
     * @return ID del log.
     */
    public int getIdLog() {
        return idLog;
    }

    /**
     * Retorna el nom de la taula que s'ha consultat.
     *
     * @return Nom de la taula consultada.
     */
    public String getTaulaConsultada() {
        return taulaConsultada;
    }

    /**
     * Retorna la data i hora de la consulta.
     *
     * @return Data de la consulta com a {@link LocalDateTime}.
     */
    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }
}
