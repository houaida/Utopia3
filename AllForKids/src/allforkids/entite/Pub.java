/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author hammamet
 */
public class Pub {
    private int id_pub;
    private String nom_societe;
    private String nom_pub;
    private Date date_debut;
    private Date date_fin;
    private int duree;
    private String etat;

    public Pub(String nom_societe, String nom_pub, Date date_debut, Date date_fin, int duree, String etat) {
        this.nom_societe = nom_societe;
        this.nom_pub = nom_pub;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.duree = duree;
         this.etat=etat;
    }
 
    public int getId_pub() {
        return id_pub;
    }

    public String getNom_societe() {
        return nom_societe;
    }

    public String getNom_pub() {
        return nom_pub;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public int getDuree() {
        return duree;
    }

    public String getEtat() {
        return etat;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

    public void setNom_societe(String nom_societe) {
        this.nom_societe = nom_societe;
    }

    public void setNom_pub(String nom_pub) {
        this.nom_pub = nom_pub;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Pub{" + "nom_societe=" + nom_societe + ", nom_pub=" + nom_pub + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", duree=" + duree + ", etat=" + etat + '}';
    }
    
    
}
