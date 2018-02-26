/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

import java.sql.Timestamp;

/**
 *
 * @author hammamet
 */
public class Club {
    
  private int id_club;
  private long cin_proprietaire;
  private String email;
  private String nom_club;
  private String categorie;
  private String description;
  private int nombre_membre;
  private int nombre_personnel;
  private Timestamp date_ajout;
  private String lieu;
  private String image;

    public Club(int id_club, long cin_proprietaire, String email, String nom_club, String categorie, String description, int nombre_personnel, String lieu, String image) {
        this.id_club = id_club;
        this.cin_proprietaire = cin_proprietaire;
        this.email = email;
        this.nom_club = nom_club;
        this.categorie = categorie;
        this.description = description;
        this.nombre_membre = nombre_membre;
        this.nombre_personnel = nombre_personnel;
        this.date_ajout = date_ajout;
        this.lieu = lieu;
        this.image = image;
    }
    
    public Club(long cin_proprietaire, String email, String nom_club, String categorie, String description, int nombre_personnel,String lieu,String image) {
        this.cin_proprietaire = cin_proprietaire;
        this.email = email;
        this.nom_club = nom_club;
        this.categorie = categorie;
        this.description = description;
       this.image = image;
        this.nombre_personnel = nombre_personnel;
        this.lieu=lieu;
     
        
    }

    public Club() {
        cin_proprietaire=0;
        email="";
        nom_club="";
        categorie="";
        description="";
        nombre_personnel=0;
        image="";
        lieu="";
       
    }

    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

   

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    public String getCategorie() {
        return categorie;
    }

    public void setCin_proprietaire(long cin_proprietaire) {
        this.cin_proprietaire = cin_proprietaire;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    

    public int getId_club() {
        return id_club;
    }

    public long getCin_proprietaire() {
        return cin_proprietaire;
    }

    public String getEmail() {
        return email;
    }

    public String getNom_club() {
        return nom_club;
    }

    public String getDescription() {
        return description;
    }

    public int getNombre_membre() {
        return nombre_membre;
    }

    public int getNombre_personnel() {
        return nombre_personnel;
    }

  

    public void setCin_proprietaire(int cin_proprietaire) {
        this.cin_proprietaire = cin_proprietaire;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNom_club(String nom_club) {
        this.nom_club = nom_club;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNombre_membre(int nombre_membre) {
        this.nombre_membre = nombre_membre;
    }

    public void setNombre_personnel(int nombre_personnel) {
        this.nombre_personnel = nombre_personnel;
    }

    public Timestamp getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(Timestamp date_ajout) {
        this.date_ajout = date_ajout;
    }
  
  
    
    
}
