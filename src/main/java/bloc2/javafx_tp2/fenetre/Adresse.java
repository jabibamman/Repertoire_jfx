package bloc2.javafx_tp2.fenetre;

public class Adresse {
    private String rue;
    private String codePostal;
    private String ville;

    public Adresse() {
        this.rue = "";
        this.codePostal = "";
        this.ville = "";
    }

    public Adresse(String uneRue,String unCp,String uneVille) {
        this.rue = uneRue;
        this.codePostal = unCp;
        this.ville = uneVille;
    }

    public void affiche() {
        System.out.println(this.rue+" "+this.codePostal+" "+this.ville);
    }

    public String toString() {
        return this.rue+","+this.codePostal+","+this.ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }


}
