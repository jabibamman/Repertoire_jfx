package bloc2.javafx_tp2.fenetre;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private VBox vbox;

    @FXML
    private Button bQuitter, bAjout, bAffprec, bAffsuiv;

    @FXML
    private TextField nom, prenom, rue, cp, ville, tel, email;

    private Repertoire rep;

    private int numCourant;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // on instancie le repertoire des le lancement de l'app
        try {
            rep = new Repertoire();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Ici on initialise numCourant à 0...
        numCourant = 0;
    }

    // Ici on utilise la fonction qui va nous faire quitter l'application
    @FXML
    private void onButtonQuitter(ActionEvent e) {
        System.out.println(" Votre fenêtre à été fermé avec succès !");
        Platform.exit();
    }

    @FXML
    private void onButtonAjout(ActionEvent e) throws SQLException {
        // ici on crée une adresse, la personne puis on l'ajoute au repertoire...
        Adresse a1 = new Adresse(rue.getText(), cp.getText(), ville.getText());
        Personne p1 = new Personne(nom.getText(), prenom.getText(), a1, tel.getText(), email.getText());
        rep.ajoutePersonne(p1);

        System.out.println(p1.getPrenom() + " à bien été rajouté au repertoire");

        // Lors de chaque ajout on affecte la taille de la colletion au numcourant, pour pouvoir afficher la dernière personne crée..
        numCourant = rep.getTailleCollection();

        // [DEBUG ONLY] Permet de vérifier le repertoire et de voir si les perosnnes sont bien ajoutés ou non
        // System.out.println(rep);

        // Permet de remettre les textarea en vide lors d'un ajout d'une personne
        this.setAllTextEmpty();
    }

    @FXML
    private void onButtonPrec(ActionEvent e) {
        // Cette condition permet de dire qu'il faut absolument que l'index "numCourant" soit superieur à 0 car un index negatif est impossible...
        if (numCourant > 0) {
            // On incrémente de - 1 num courant dès que l'user clique sur le bouton precedent
            numCourant -= 1;

            // On affecte donc les coordonnées de la personne précédente, avec la fonction recherche_personne que l'on avait crée en amont
            nom.setText(rep.recherche_personne(numCourant).getNom());
            prenom.setText(rep.recherche_personne(numCourant).getPrenom());
            rue.setText(rep.recherche_personne(numCourant).getAdresse().getRue());
            cp.setText(rep.recherche_personne(numCourant).getAdresse().getCodePostal());
            ville.setText(rep.recherche_personne(numCourant).getAdresse().getVille());
            tel.setText(rep.recherche_personne(numCourant).getTelephone());
            email.setText(rep.recherche_personne(numCourant).getEmail());


            // Ce else if permet de retourner une erreur si le numéro de l'index est inferieur a 0 ce qui serait impossible
        } else if (numCourant - 1 < 0) {
            System.err.println("Error 258: Vous êtes arrivé à la première page.");

            // On crée une alerte pour bien indiquer au client qu'il est sur la première page (le point bonus ^^)
            Alert alert = new Alert(Alert.AlertType.ERROR, "ERREUR");
            alert.setContentText("Vous êtes a la première page, vous ne pouvez pas aller à une page précédente...");
            alert.show();

        }
    }

    @FXML
    private void onButtonSuiv(ActionEvent e) {
        // Ici, c'est le même procédé, mais on incrémente de + 1
        if (numCourant < rep.getTailleCollection() && numCourant + 1 < rep.getTailleCollection()) {
            numCourant += 1;

            nom.setText(rep.recherche_personne(numCourant).getNom());
            prenom.setText(rep.recherche_personne(numCourant).getPrenom());
            rue.setText(rep.recherche_personne(numCourant).getAdresse().getRue());
            cp.setText(rep.recherche_personne(numCourant).getAdresse().getCodePostal());
            ville.setText(rep.recherche_personne(numCourant).getAdresse().getVille());
            tel.setText(rep.recherche_personne(numCourant).getTelephone());
            email.setText(rep.recherche_personne(numCourant).getEmail());

            // Ici on indique une erreur pour dire que l'on est à la dernière page.
        } else if (numCourant + 1 >= rep.getTailleCollection()) {
            System.err.println("Error 404: Vous êtes arrivé à la denière page.");

            Alert alert = new Alert(Alert.AlertType.ERROR, "ERREUR");
            alert.setContentText("Vous êtes arrivé à la denière page, vous ne pouvez pas aller à une page suivante...");
            alert.show();
        }
    }

    @FXML
    public void onButtonRaz(ActionEvent e) {
        // Permet de remettre les textarea en vide lors d'un ajout d'une personne
        this.setAllTextEmpty();
    }

    public void setAllTextEmpty() {
        nom.setText("");
        prenom.setText("");
        rue.setText("");
        cp.setText("");
        ville.setText("");
        tel.setText("");
        email.setText("");
    }

}