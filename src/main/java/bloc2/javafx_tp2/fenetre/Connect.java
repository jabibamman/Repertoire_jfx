package bloc2.javafx_tp2.fenetre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection conn;

    public Connect(Connection conn) {
        this.conn = conn;
    }

    public static Connection get() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/repertoire    ","root","root");

        return conn;
    }
}
