package model;

import java.time.LocalDateTime;

/**
 * Classe que representa una reserva amb informació addicional sobre el servei associat.
 *
 * <p>Extén la classe {@link Reserva} afegint el camp {@code idServei} que identifica el servei reservat.</p>
 *
 * <p>Autor: Bilal</p>
 */
public class ReservaDetallada extends Reserva {
    private int idServei;

    /**
     * Constructor per inicialitzar una reserva detallada amb tota la informació necessària.
     *
     * @param idReserva     Identificador de la reserva.
     * @param idClient      Identificador del client.
     * @param idCita        Identificador de la cita.
     * @param dataReserva   Data i hora en què es va fer la reserva.
     * @param idServei      Identificador del servei associat.
     */
    public ReservaDetallada(int idReserva, int idClient, int idCita, LocalDateTime dataReserva, int idServei) {
        super(idReserva, idClient, idCita, dataReserva);
        this.idServei = idServei;
    }

    /**
     * Retorna l'identificador del servei associat a la reserva.
     *
     * @return id del servei.
     */
    public int getIdServei() {
        return idServei;
    }

    /**
     * Assigna un nou identificador de servei a la reserva.
     *
     * @param idServei Nou id del servei.
     */
    public void setIdServei(int idServei) {
        this.idServei = idServei;
    }
}
