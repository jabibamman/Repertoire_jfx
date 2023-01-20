package bloc2.javafx_tp2.fenetre;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class Repertoire {
    ArrayList<Personne> liste;

    public Repertoire() throws SQLException {
        this.liste = Passerrelle.chargeRepertoire();  // Ici on instance la la liste par ce que l'on a récupéré dans la BDD avec la methode chargeRepertoire()
    }

    // Permet d'ajouter une perssonne dans le repertoire
    public void ajoutePersonne(Personne p) throws SQLException {
        this.liste.add(p);

        Passerrelle.ajoutePersonne(p);    // Dès qu'une personne est ajoutée elle est aussi ajoutée via cette fonction dans la bdd
        Collections.sort(liste);
    }

    public Optional<Personne> rechercheNom(String unNom) {
        return liste.stream()
                .filter(p -> p.getNom().equals(unNom))
                .findFirst();
    }

    public Optional<Personne> rechercheNomPrenom(String unNom,String unPrenom) {
        return liste.stream()
                .filter(p -> p.getNom().equals(unNom) && p.getPrenom().equals(unPrenom))
                .findFirst();
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
        StringBuilder laListe= new StringBuilder("Repertoire: \n");
        liste.forEach(p -> laListe.append(p).append("\n"));
        
        return laListe.toString();
    }

}