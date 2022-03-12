module bloc2.javafx_tp2.fenetre {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires mysql.connector.java;
    requires java.sql;

    opens bloc2.javafx_tp2.fenetre to javafx.fxml;
    exports bloc2.javafx_tp2.fenetre;
}