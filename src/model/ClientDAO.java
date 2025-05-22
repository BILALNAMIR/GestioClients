package model;

import utils.DatabaseConnection;

import java.sql.*;
import java.util.*;

public class ClientDAO {

    public static List<Client> getAllClients() {
        List<Client> llista = new ArrayList<>();
        String sql = "SELECT * FROM client";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Client c = new Client(
                        rs.getInt("id_client"),
                        rs.getString("nom"),
                        rs.getString("cognoms"),
                        rs.getString("email"),
                        rs.getString("telefon")
                );
                llista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llista;
    }

    public static void insertClient(Client c) {
        String sql = "INSERT INTO client(nom, cognoms, email, telefon) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getNom());
            stmt.setString(2, c.getCognoms());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getTelefon());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteClient(int id) {
        String sql = "DELETE FROM client WHERE id_client = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
