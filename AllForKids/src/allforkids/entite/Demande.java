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
public class Demande {
  private int id_demande; 
  private int id_parent;
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

    public Demande(int id_demande, int id_parent, String description, String titre, String date_debut, String date_fin) {
        this.id_demande = id_demande;
        this.id_parent = id_parent;
        this.description = description;
        this.titre = titre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Demande(int id_parent, String description, String titre, String date_debut, String date_fin) {
        this.id_parent = id_parent;
        this.description = description;
        this.titre = titre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId_demande() {
        return id_demande;
    }

    public int getId_parent() {
        return id_parent;
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

    public void setId_demande(int id_demande) {
        this.id_demande = id_demande;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
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
        return "Demande{" + "id_demande=" + id_demande + ", id_parent=" + id_parent + ", date_publication=" + date_publication + ", description=" + description + ", titre=" + titre + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
    }
  
   
    


}