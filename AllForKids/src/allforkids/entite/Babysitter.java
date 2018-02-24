/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author user
 */
public class Babysitter extends User{
  private String date_naissance;
    private int cin;
    private String nom;
    private String prenom;
    private String adresse;
    private String num_tel;
    private String image;
public java.sql.Date convert(String date) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date1 = sdf1.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        return sqlDate;
    }

    public String getImage() {
        return image;
    }

    public String getDate_naissance() {
        return date_naissance;
    }
    public Babysitter(int id_user,int cin, String nom, String prenom, String adresse,  String pseudo, String mdp, String Email,String num_tel,String type,String date_naissance,String image ) {
        super(id_user, pseudo, mdp, Email,type);
        this.date_naissance=date_naissance;
        this.image=image;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.num_tel = num_tel;
    }
public Babysitter(int id_user,int cin, String nom, String prenom, String adresse,  String pseudo, String mdp, String Email,String num_tel,String date_naissance,String image ) {
        super(id_user, pseudo, mdp, Email);
        this.date_naissance=date_naissance;
        this.image=image;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.num_tel = num_tel;
    }
    public Babysitter(int cin, String nom, String prenom, String pseudo,String mdp,String Email,String adresse, String num_tel,String date_naissance,String type,String image) {
        super(pseudo, mdp, Email,type);
        this.cin = cin;
     this.image=image;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.num_tel = num_tel;
    }

    public Babysitter(int cin, String nom, String prenom, String pseudo,String mdp,String Email,String adresse, String num_tel,String date_naissance,String image) {
        super(pseudo, mdp, Email);
             this.image=image;

        this.date_naissance=date_naissance;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.num_tel = num_tel;
    }   

    public Babysitter() {
    }


    public int getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    

    @Override
    public String toString() {
        return "Babysitter{" + "date_naissance=" + date_naissance + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", num_tel=" + num_tel + ", image=" + image + '}';
    }

    

  

    

    
    
 

}