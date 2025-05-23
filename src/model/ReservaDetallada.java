package model;

import java.time.LocalDateTime;

public class ReservaDetallada extends Reserva {
    private int idServei;

    public ReservaDetallada(int idReserva, int idClient, int idCita, LocalDateTime dataReserva, int idServei) {
        super(idReserva, idClient, idCita, dataReserva);
        this.idServei = idServei;
    }

    public int getIdServei() {
        return idServei;
    }

    public void setIdServei(int idServei) {
        this.idServei = idServei;
    }
}
