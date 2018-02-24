/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author user
 */
public class Offre {
  private int id_offre;
  private int id_babysitter;
  private String date_publication;
  private String description;
  private String titre;
  private String date_debut;
  private String date_fin;


   
public java.sql.Date convert(String date) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date1 = sdf1.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        return sqlDate;
    }
    public Offre(int id_offre, int id_babysitter, String description, String titre, String date_debut, String date_fin) {
        this.id_offre = id_offre;
        this.id_babysitter = id_babysitter;
        this.date_publication = date_publication;
        this.description = description;
        this.titre = titre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Offre(int id_babysitter,  String description, String titre, String date_debut, String date_fin) {
        this.id_babysitter = id_babysitter;
        this.date_publication = date_publication;
        this.description = description;
        this.titre = titre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }
    


    public int getId_offre() {
        return id_offre;
    }

    public int getId_babysitter() {
        return id_babysitter;
    }

    public String getDate_publication() {
        return date_publication;
    }

    public String getDescription() {
        return description;
    }

    public String getTitre() {
        return titre;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public void setId_babysitter(int id_babysitter) {
        this.id_babysitter = id_babysitter;
    }

    public void setDate_publication(String date_publication) {
        this.date_publication = date_publication;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    

    @Override
    public String toString() {
        return "Offre{" + "id_offre=" + id_offre + ", id_babysitter=" + id_babysitter + ", date_publication=" + date_publication + ", description=" + description + '}';
    }

    
    
}
