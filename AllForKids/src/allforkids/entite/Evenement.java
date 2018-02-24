/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

import java.sql.Date;

/**
 *
 * @author hammamet
 */
public class Evenement {
    public int id_evenement;
    public String nom;
    public Date date;
    public String lieu;
    public int heure;
    public int duree;
    public float prix_ticket;

    public Evenement( String nom, Date date, String lieu, int heure, int duree, float prix_ticket) {
      
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.heure = heure;
        this.duree = duree;
        this.prix_ticket = prix_ticket;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public String getNom() {
        return nom;
    }

    public Date getDate() {
        return date;
    }

    public String getLieu() {
        return lieu;
    }

    public int getHeure() {
        return heure;
    }

    public int getDuree() {
        return duree;
    }

    public float getPrix_ticket() {
        return prix_ticket;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setPrix_ticket(float prix_ticket) {
        this.prix_ticket = prix_ticket;
    }
    
    
    
    
}
