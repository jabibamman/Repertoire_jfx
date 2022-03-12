package bloc2.javafx_tp2.fenetre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Passerrelle {
    public static ArrayList<Personne> chargeRepertoire() throws SQLException {
        ArrayList<Personne> listeDePersonne;

        listeDePersonne = new ArrayList<Personne>();

        try {
            String req = "SELECT nom, prenom, adresse, ville, cp, tel, email FROM contact";

            Statement statement = Connect.get().createStatement();
            ResultSet res = statement.executeQuery(req);


            while (res.next()) {
                String nom = res.getString("nom");
                String prenom = res.getString("prenom");
                String adresse = res.getString("adresse");
                String ville = res.getString("ville");
                String cp = res.getString("cp");
                String tel = res.getString("tel");
                String email = res.getString("email");

                Adresse A = new Adresse(adresse, cp, ville);
                Personne P = new Personne(nom, prenom, A, tel, email);

                listeDePersonne.add(P);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeDePersonne;
    }

    public static void ajoutePersonne (Personne p) throws SQLException {
        try {
            String req = "INSERT INTO contact (nom, prenom, adresse, ville, cp, tel, email) VALUES ('" + p.getNom() +"','"+ p.getPrenom() +"','"+ p.getAdresse().getRue() +"','"
                    + p.getAdresse().getVille() + "','"+ p.getAdresse().getCodePostal() + "','" + p.getTelephone() + "','" + p.getEmail()+"')";

            Statement statement = Connect.get().createStatement();
            statement.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
