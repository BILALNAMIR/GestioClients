package model;

import java.time.LocalDateTime;

public class Reserva {
    private int idReserva;
    private int idClient;
    private int idCita;
    private LocalDateTime dataReserva;

    public Reserva(int idReserva, int idClient, int idCita, LocalDateTime dataReserva) {
        this.idReserva = idReserva;
        this.idClient = idClient;
        this.idCita = idCita;
        this.dataReserva = dataReserva;
    }

    public int getIdReserva() { return idReserva; }
    public int getIdClient() { return idClient; }
    public int getIdCita() { return idCita; }
    public LocalDateTime getDataReserva() { return dataReserva; }

    public void setIdReserva(int idReserva) { this.idReserva = idReserva; }
    public void setIdClient(int idClient) { this.idClient = idClient; }
    public void setIdCita(int idCita) { this.idCita = idCita; }
    public void setDataReserva(LocalDateTime dataReserva) { this.dataReserva = dataReserva; }
}
