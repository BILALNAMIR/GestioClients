package model;

import utils.DatabaseConnection;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class ReservaDAO {

	public static List<ReservaDetallada> getReservesAmbServei() {
	    List<ReservaDetallada> reserves = new ArrayList<>();
	    String sql = """
	        SELECT r.id_reserva, r.id_client, r.id_cita, r.data_reserva, c.id_servei
	        FROM reserva r
	        JOIN cita_disponible c ON r.id_cita = c.id_cita
	    """;

	    try (Connection conn = DatabaseConnection.connect();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        while (rs.next()) {
	            ReservaDetallada r = new ReservaDetallada(
	                rs.getInt("id_reserva"),
	                rs.getInt("id_client"),
	                rs.getInt("id_cita"),
	                rs.getTimestamp("data_reserva").toLocalDateTime(),
	                rs.getInt("id_servei")
	            );
	            reserves.add(r);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return reserves;
	}

	
	
    public static List<Reserva> getAllReserves() {
        List<Reserva> reserves = new ArrayList<>();
        String sql = "SELECT * FROM reserva";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Reserva r = new Reserva(
                        rs.getInt("id_reserva"),
                        rs.getInt("id_client"),
                        rs.getInt("id_cita"),
                        rs.getTimestamp("data_reserva").toLocalDateTime()
                );
                reserves.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reserves;
    }

    public static List<Reserva> getReservesPerClient(int idClient) {
        List<Reserva> reserves = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE id_client = ? ORDER BY data_reserva DESC";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idClient);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Reserva r = new Reserva(
                        rs.getInt("id_reserva"),
                        rs.getInt("id_client"),
                        rs.getInt("id_cita"),
                        rs.getTimestamp("data_reserva").toLocalDateTime()
                );
                reserves.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reserves;
    }
}
