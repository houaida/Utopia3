/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.joda.time.DateTime;

/**
 *
 * @author user
 */
public class Reclamation {
    private int id_reclamation;
    private int id_parent;
    private int id_babysitter;
    private String description;
    private Timestamp date_envoi;
    private Time heure_travail;
    private Time heure_pointe;
    private int etat;
    private int diff_heure;
    private int diff_minute;
    private int alerte;

    public int getAlerte() {
        return alerte;
    }

    public void setAlerte(int alerte) {
        this.alerte = alerte;
    }

    public int getDiff_heure() {
        return diff_heure;
    }

    public void setDiff_heure(int diff_heure) {
        this.diff_heure = diff_heure;
    }

    public int getDiff_minute() {
        return diff_minute;
    }

    public void setDiff_minute(int diff_minute) {
        this.diff_minute = diff_minute;
    }

    public Reclamation(int id_reclamation, int id_parent, int id_babysitter, String description, Timestamp date_envoi, Time heure_travail, Time heure_pointe, int etat, int diff_heure, int diff_minute, int alerte) {
        this.id_reclamation = id_reclamation;
        this.id_parent = id_parent;
        this.id_babysitter = id_babysitter;
        this.description = description;
        this.date_envoi = date_envoi;
        this.heure_travail = heure_travail;
        this.heure_pointe = heure_pointe;
        this.etat = etat;
        this.diff_heure = diff_heure;
        this.diff_minute = diff_minute;
        this.alerte = alerte;
    }

    public Reclamation(int id_reclamation, int id_parent, int id_babysitter, String description, Timestamp date_envoi, Time heure_travail, Time heure_pointe, int etat, int diff_heure, int diff_minute) {
        this.id_reclamation = id_reclamation;
        this.id_parent = id_parent;
        this.id_babysitter = id_babysitter;
        this.description = description;
        this.date_envoi = date_envoi;
        this.heure_travail = heure_travail;
        this.heure_pointe = heure_pointe;
        this.etat = etat;
        this.diff_heure = diff_heure;
        this.diff_minute = diff_minute;
    }

    public Reclamation(int id_parent, int id_babysitter, String description, Timestamp date_envoi, Time heure_travail, Time heure_pointe, int etat, int diff_heure, int diff_minute) {
        this.id_parent = id_parent;
        this.id_babysitter = id_babysitter;
        this.description = description;
        this.date_envoi = date_envoi;
        this.heure_travail = heure_travail;
        this.heure_pointe = heure_pointe;
        this.etat = etat;
        this.diff_heure = diff_heure;
        this.diff_minute = diff_minute;
    }

    public Reclamation(int id_parent, int id_babysitter, String description, Timestamp date_envoi, Time heure_travail, Time heure_pointe, int etat) {
        this.id_parent = id_parent;
        this.id_babysitter = id_babysitter;
        this.description = description;
        this.date_envoi = date_envoi;
        this.heure_travail = heure_travail;
        this.heure_pointe = heure_pointe;
        this.etat = etat;
    }

    

    public Reclamation(int id_babysitter, String description, Time heure_travail, Time heure_pointe) {
        this.id_babysitter = id_babysitter;
        this.description = description;
        this.heure_travail = heure_travail;
        this.heure_pointe = heure_pointe;
    }

    public Reclamation(String description, Time heure_travail, Time heure_pointe) {
  
        this.description = description;
        this.heure_travail = heure_travail;
        this.heure_pointe = heure_pointe;
    }

    public Reclamation() {
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

  

    public Timestamp getDate_envoi() {
        return date_envoi;
    }

    public void setDate_envoi(Timestamp date_envoi) {
        this.date_envoi = date_envoi;
    }

    public Time getHeure_travail() {
        return heure_travail;
    }

    public void setHeure_travail(Time heure_travail) {
        this.heure_travail = heure_travail;
    }

    public Time getHeure_pointe() {
        return heure_pointe;
    }

    public void setHeure_pointe(Time heure_pointe) {
        this.heure_pointe = heure_pointe;
    }

    

   
    public int getId_reclamation() {
        return id_reclamation;
    }

  

    public int getId_parent() {
        return id_parent;
    }

    public int getId_babysitter() {
        return id_babysitter;
    }

    public String getDescription() {
        return description;
    }



    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public void setId_babysitter(int id_babysitter) {
        this.id_babysitter = id_babysitter;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_reclamation=" + id_reclamation + ", id_parent=" + id_parent + ", id_babysitter=" + id_babysitter + ", description=" + description + ", date_envoi=" + date_envoi + ", heure_travail=" + heure_travail + ", heure_pointe=" + heure_pointe + ", etat=" + etat + ", diff_heure=" + diff_heure + ", diff_minute=" + diff_minute + '}';
    }

   
   


    

    

}
