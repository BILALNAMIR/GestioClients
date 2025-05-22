package model;

import utils.DatabaseConnection;
import java.sql.*;
import java.util.*;

public class ServeiDAO {

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
