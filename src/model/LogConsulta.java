package model;

import java.time.LocalDateTime;

public class LogConsulta {
    private int idLog;
    private String taulaConsultada;
    private LocalDateTime dataConsulta;

    public LogConsulta(int idLog, String taulaConsultada, LocalDateTime dataConsulta) {
        this.idLog = idLog;
        this.taulaConsultada = taulaConsultada;
        this.dataConsulta = dataConsulta;
    }

    public int getIdLog() { return idLog; }
    public String getTaulaConsultada() { return taulaConsultada; }
    public LocalDateTime getDataConsulta() { return dataConsulta; }
}
