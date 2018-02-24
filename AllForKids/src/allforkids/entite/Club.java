/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

/**
 *
 * @author hammamet
 */
public class Club {
    
    public int id;

    public int getId() {
        return id;
    }
    public String nom;
    public String categorie;
    public String lieu;
    public int age_min;
    public int age_max;
    public int nombre_enseignant;
    public int nombre_inscrits;

    public Club(String nom, String categorie, String lieu, int age_min, int age_max, int nombre_enseignant, int nombre_inscrits) {
        this.nom = nom;
        this.categorie = categorie;
        this.lieu = lieu;
        this.age_min = age_min;
        this.age_max = age_max;
        this.nombre_enseignant = nombre_enseignant;
        this.nombre_inscrits = nombre_inscrits;
    }

    public String getNom() {
        return nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getLieu() {
        return lieu;
    }

    public int getAge_min() {
        return age_min;
    }

    public int getAge_max() {
        return age_max;
    }

    public int getNombre_enseignant() {
        return nombre_enseignant;
    }

    public int getNombre_inscrits() {
        return nombre_inscrits;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setAge_min(int age_min) {
        this.age_min = age_min;
    }

    public void setAge_max(int age_max) {
        this.age_max = age_max;
    }

    public void setNombre_enseignant(int nombre_enseignant) {
        this.nombre_enseignant = nombre_enseignant;
    }

    public void setNombre_inscrits(int nombre_inscrits) {
        this.nombre_inscrits = nombre_inscrits;
    }

    
    
    
    
}
