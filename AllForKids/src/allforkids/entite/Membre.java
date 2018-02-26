/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hammamet
 */
public class Membre {
    
    private int id;
    private int id_user;
    private int id_club;
    private String nom;
    private String prenom;
    private int num_parent;
    private String email_parent;
    private String date_naissance;

    public Membre() {
        id_user=0;
        id_club=0;
        nom="";
        prenom="";
        num_parent=0;
        email_parent="";
        date_naissance="";
    }
    public java.sql.Date convert(String date) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date1 = sdf1.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        return sqlDate;
    }

    public Membre(int id_user, int id_club, String nom, String prenom, int num_parent, String email_parent, String date_naissance) {
        this.id_user = id_user;
        this.id_club = id_club;
        this.nom = nom;
        this.prenom = prenom;
        this.num_parent = num_parent;
        this.email_parent = email_parent;
        this.date_naissance = date_naissance;
    }
   
   

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_club() {
        return id_club;
    }

    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }
   
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    

   

    public int getNum_parent() {
        return num_parent;
    }

    public String getEmail_parent() {
        return email_parent;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

   

    public void setNum_parent(int num_parent) {
        this.num_parent = num_parent;
    }

    public void setEmail_parent(String email_parent) {
        this.email_parent = email_parent;
    }
    
    
    
    
    
}
