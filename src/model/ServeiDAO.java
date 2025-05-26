package model;

import utils.DatabaseConnection;
import java.sql.*;
import java.util.*;

/**
 * Classe per gestionar l'accés a dades de la taula "servei".
 * Proporciona operacions per obtenir, inserir i eliminar serveis.
 * 
 * <p>Autor: Bilal</p>
 */
public class ServeiDAO {

    /**
     * Retorna una llista amb tots els serveis de la base de dades.
     * 
     * @return Llista de serveis.
     */
    public static List<Servei> getAllServeis() {
        List<Servei> serveis = new ArrayList<>();
        String sql = "SELECT id_servei, nom_servei, preu FROM servei";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Servei s = new Servei(
                    rs.getInt("id_servei"),
                    rs.getString("nom_servei"),
                    rs.getDouble("preu")
                );
                serveis.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return serveis;
    }

    /**
     * Insereix un nou servei a la base de dades.
     * 
     * @param s Servei a inserir.
     */
    public static void insertServei(Servei s) {
        String sql = "INSERT INTO servei(nom_servei, preu) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, s.getNom());
            stmt.setDouble(2, s.getPreu());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un servei de la base de dades segons el seu identificador.
     * 
     * @param id Identificador del servei a eliminar.
     */
    public static void deleteServei(int id) {
        String sql = "DELETE FROM servei WHERE id_servei = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
