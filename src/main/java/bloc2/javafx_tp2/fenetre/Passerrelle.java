package bloc2.javafx_tp2.fenetre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Passerrelle {
    /**
     * @return Arraylist<Personne> - elle retourne uniquement le tableau des personnes (le repertoire entier..)
     * @desc cette fonction charge le repertoire via la Base de donnée dans une ArrayList
     */
    public static ArrayList<Personne> chargeRepertoire() throws SQLException {
        // Il n'y a pas de public static, car ça retournait une erreur
        ArrayList<Personne> listeDePersonne;

        listeDePersonne = new ArrayList<Personne>();

        try {
            String req = "SELECT nom, prenom, adresse, ville, cp, tel, email FROM contact";

            Statement statement = Connect.get().createStatement();
            ResultSet res = statement.executeQuery(req);

            // La boucle permet de transformer le résultat de la requête en variable
            while (res.next()) {
                String nom = res.getString("nom");
                String prenom = res.getString("prenom");
                String adresse = res.getString("adresse");
                String ville = res.getString("ville");
                String cp = res.getString("cp");
                String tel = res.getString("tel");
                String email = res.getString("email");

                // On instancie une adresse et une personne pour chaque tour de boucle
                Adresse A = new Adresse(adresse, cp, ville);
                Personne P = new Personne(nom, prenom, A, tel, email);

                // Finalement on ajoute bien la personne à l'arrayList
                listeDePersonne.add(P);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeDePersonne;
    }

    /**
     * @param p - la personne en paramètre
     * @return void - aucun return car la fonction est void
     * @desc permet le rajout d'une personne "p" inscrite dans les paramètres de l'ajouter à la BDD
     */
    public static void ajoutePersonne(Personne p) throws SQLException {
        try {
            String req = "INSERT INTO contact (nom, prenom, adresse, ville, cp, tel, email) VALUES ('" + p.getNom() + "','" + p.getPrenom() + "','" + p.getAdresse().getRue() + "','"
                    + p.getAdresse().getVille() + "','" + p.getAdresse().getCodePostal() + "','" + p.getTelephone() + "','" + p.getEmail() + "')";

            Statement statement = Connect.get().createStatement();
            statement.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
