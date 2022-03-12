package bloc2.javafx_tp2.fenetre;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Repertoire {
    ArrayList<Personne> liste;

    public Repertoire() throws SQLException {
        this.liste = Passerrelle.chargeRepertoire();
    }

    public void ajoutePersonne(Personne p) throws SQLException {
        this.liste.add(p);

        Passerrelle.ajoutePersonne(p);

        Collections.sort(liste);
    }

    public Personne rechercheNom(String unNom) {
        Personne laPersonne = null; //Variable de retour
        for(Personne p : liste) {
            if(p.getNom().equals(unNom)) { //Si personne existe, on affecte a la variable de retour
                laPersonne = p;
            }
        }
        return laPersonne;
    }

    public Personne rechercheNomPrenom(String unNom,String unPrenom) {
        Personne laPersonne = null; //Variable de retour
        for(Personne p : liste) {
            if(p.getNom().equals(unNom) && p.getPrenom().equals(unPrenom)) { //Si personne existe, on affecte a la variable de retour
                laPersonne = p;
            }
        }
        return laPersonne;
    }

    // On recherche une personne via son idice, il nous retournera donc cette personne
    public Personne recherche_personne(int indice) {
        return liste.get(indice);
    }

    // Cette méthode permet de retourner la taille de la collection comportant toutes les personnes
    public int getTailleCollection(){
        return liste.size();
    }

    public String toString() {
        String laListe="Repertoire: \n";
        for(Personne p : liste) {
            laListe += p+"\n";
        }
        return laListe;
    }

}