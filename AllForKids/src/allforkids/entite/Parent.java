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
public class Parent extends User{
    
     private int cin;
    private String nom;
    private String prenom;
     private String adresse;
    private float montant;
    private String image;
    private String num_tel;
     
   public Parent(int id_user,int cin, String nom, String prenom,String pseudo, String mdp,String email,String adresse, float montant,String type,String image,String num_tel) {
        super(id_user, pseudo, mdp, email,type);
        this.image=image;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.montant = montant;
        this.num_tel = num_tel;
    }
/*public Parent(int id_user,int cin, String nom, String prenom,String pseudo, String mdp,String email,String adresse, float montant,String type,String image,String num_tel) {
        super(id_user, pseudo, mdp, email,type);
        this.image=image;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.montant = montant;
        this.num_tel = num_tel;
    }*/
    public Parent(String pseudo, String mdp,String email,String num_tel) {
        super( pseudo, mdp, email);
        
    }public Parent(int id_user,int cin, String nom, String prenom, String pseudo, String mdp, 
            String email, String adresse,float montant,String num_tel) {
        super(id_user,pseudo, mdp, email);
      
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.montant = montant;
        this.num_tel = num_tel;

    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public Parent(int cin, String nom, String prenom, String pseudo, String mdp, 
            String email, String adresse,float montant,String image,String num_tel) {
        super(pseudo, mdp, email);
        this.image=image;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.montant = montant;
      this.num_tel = num_tel;

    }
   
    

   
    public Parent() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Parent(int parseInt, String text, String text0, String text1, String text2, String text3, String text4, float parseFloat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Parent{" + "cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", "+ super.toString()+", adresse=" + adresse + ", montant=" + montant + '}';
    }
    

   
}