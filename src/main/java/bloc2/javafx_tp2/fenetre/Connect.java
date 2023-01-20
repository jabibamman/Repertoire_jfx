package bloc2.javafx_tp2.fenetre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection conn; // Variable qui enregistre la connexion à la base de données

    public Connect(Connection conn) {
        Connect.conn = conn;
    }

    /**
     * @return Connection - on return la connexion
     * @desc crée la connexion à la base de donnée si nécessaire et qui la renvoie
     */
    public static Connection get() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/repertoire", "root", "root");

        return conn;
    }
}
