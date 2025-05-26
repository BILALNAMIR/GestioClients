package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe utilitària per establir connexions amb la base de dades MySQL.
 * <p>
 * Utilitza el connector JDBC per accedir a la base de dades anomenada "bilstyl"
 * ubicada al servidor local.
 * </p>
 *
 * <p>Autor: Bilal</p>
 */
public class DatabaseConnection {

    /** URL de connexió JDBC a la base de dades. */
    private static final String URL = "jdbc:mysql://localhost:3306/bilstyl";

    /** Nom d'usuari per accedir a la base de dades. */
    private static final String USER = "root";

    /** Contrasenya per accedir a la base de dades (deixa-la buida si no en tens). */
    private static final String PASSWORD = ""; // Canvia si tens contrasenya

    /**
     * Estableix i retorna una connexió a la base de dades MySQL.
     *
     * @return Una instància de {@link Connection} per interactuar amb la base de dades.
     * @throws SQLException Si hi ha un error en connectar-se a la base de dades.
     */
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
