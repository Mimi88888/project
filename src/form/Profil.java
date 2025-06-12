package form;

public class Profil {
    String  nom,prenom,pseudo;

    Profil(String nom, String prenom, String pseudo){
        this.nom=nom;
        this.prenom=prenom;
        this.pseudo=pseudo;
    }

    public Profil() {
        this.nom="";
        this.prenom="";
        this.pseudo="";

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPseudo() {
        return nom;
    }

    public void setPseudo(String pseudo) {
        this.nom = nom;
    }
    public String getPrenom() {
        return nom;
    }

    public void setPrenom(String prenom) {
        this.nom = nom;
    }
}
