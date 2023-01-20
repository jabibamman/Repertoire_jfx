package bloc2.javafx_tp2.fenetre;

public class Personne implements Comparable<Personne>{
    private String nom;
    private String prenom;
    private Adresse adresse;
    private String telephone;
    private String email;

    public Personne(String unNom,String unPrenom) {
        this.nom = unNom;
        this.prenom = unPrenom;
        this.adresse = new Adresse();
        this.telephone = "";
    }

    public Personne(String unNom,String unPrenom,Adresse uneAdresse,String unTel, String unEmail) {
        this.nom = unNom;
        this.prenom = unPrenom;
        this.adresse = uneAdresse;
        this.telephone = unTel;
        this.email = unEmail;
    }

    //Affichage de l'addresse
    public void affiche() {
        System.out.println(this.nom+" "+this.prenom+" "+this.adresse+" "+this.telephone);
    }

    //Retour coordonées
    public String toString() {
        return this.nom+";"+this.prenom+";"+this.adresse+";"+this.telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Personne p) {
        return this.nom.equals(p.getNom()) ? prenom.compareTo(p.getPrenom()) : nom.compareTo(p.getNom());
    }

}
