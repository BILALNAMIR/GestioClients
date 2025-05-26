package model;

import java.time.LocalDateTime;

/**
 * Classe que representa una reserva realitzada per un client per una cita específica.
 *
 * <p>Inclou informació sobre el client, la cita i la data de la reserva.</p>
 *
 * <p>Autor: Bilal</p>
 */
public class Reserva {
    private int idReserva;
    private int idClient;
    private int idCita;
    private LocalDateTime dataReserva;

    /**
     * Constructor per crear una instància de {@code Reserva}.
     *
     * @param idReserva    Identificador únic de la reserva.
     * @param idClient     Identificador del client que ha fet la reserva.
     * @param idCita       Identificador de la cita reservada.
     * @param dataReserva  Data i hora en què s'ha fet la reserva.
     */
    public Reserva(int idReserva, int idClient, int idCita, LocalDateTime dataReserva) {
        this.idReserva = idReserva;
        this.idClient = idClient;
        this.idCita = idCita;
        this.dataReserva = dataReserva;
    }

    /**
     * Retorna l'identificador de la reserva.
     *
     * @return ID de la reserva.
     */
    public int getIdReserva() {
        return idReserva;
    }

    /**
     * Estableix l'identificador de la reserva.
     *
     * @param idReserva Nou ID de la reserva.
     */
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    /**
     * Retorna l'identificador del client associat a la reserva.
     *
     * @return ID del client.
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Estableix l'identificador del client.
     *
     * @param idClient Nou ID del client.
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Retorna l'identificador de la cita reservada.
     *
     * @return ID de la cita.
     */
    public int getIdCita() {
        return idCita;
    }

    /**
     * Estableix l'identificador de la cita.
     *
     * @param idCita Nou ID de la cita.
     */
    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    /**
     * Retorna la data i hora de la reserva.
     *
     * @return Data i hora de la reserva.
     */
    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    /**
     * Estableix la data i hora de la reserva.
     *
     * @param dataReserva Nova data i hora de la reserva.
     */
    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }
}
