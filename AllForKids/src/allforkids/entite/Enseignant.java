/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

/**
 *
 * @author MacBook
 */
public class Enseignant extends User{
    
   
    private String nom;
    private String prenom;
    private int cin;
    private String nom_club;
    private float montant;
    static Enseignant instance;
    private String image;
 
 public Enseignant( int id_user, int cin,String nom, String prenom, String pseudo, String mdp,String email,float montant, String nom_club) {
        super(id_user, pseudo, mdp, email);
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.nom_club = nom_club;
        this.montant = montant;
       
    }
public Enseignant( int id_user, int cin,String nom, String prenom, String pseudo, String mdp,String email,float montant, String nom_club,String image) {
        super(id_user, pseudo, mdp, email);
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.nom_club = nom_club;
        this.montant = montant;
        this.image=image;
    }

    public Enseignant( int id_user, int cin,String nom, String prenom, String pseudo, String mdp,String email,float montant, String nom_club,String type,String image) {
        super(id_user, pseudo, mdp, email,type);
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.nom_club = nom_club;
        this.montant = montant;
        this.image=image;
    }
public Enseignant(int cin,String nom, String prenom, String pseudo, String mdp,String email,float montant, String nom_club,String image) {
        super(pseudo, mdp, email);
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.nom_club = nom_club;
        this.montant = montant;
        this.image=image;
    }

    public Enseignant(int cin,String nom, String prenom, String pseudo, String mdp,String email,float montant, String nom_club,String type,String image) {
        super(pseudo, mdp, email,type);
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.nom_club = nom_club;
        this.montant = montant;
        this.image=image;
    }

    public Enseignant() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        //super.toString();
        return "Enseignant{"+"cin= "+ cin + ", nom=" + nom + ", prenom=" + prenom + ", "+ super.toString()+", montant=" + montant +", nom_club=" + nom_club + '}';
    
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

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom_club() {
        return nom_club;
    }

    public void setNom_club(String nom_club) {
        this.nom_club = nom_club;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

   
}

