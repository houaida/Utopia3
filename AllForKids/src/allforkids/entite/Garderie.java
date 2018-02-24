/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MacBook
 */
public class Garderie {
    private int id_garderie;
   private String nom;
    private  String adresse;
    private int num_tel;
private String description;
private String image;
private int id_user;
private List<Enfant> enfants=new ArrayList<>();

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
   
   
public Garderie(int id_garderie,int id_user, String nom, String adresse,int num_tel,String description) {
        this.nom = nom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.id_garderie=id_garderie;
        this.id_user=id_user;
        
        
        this.description=description;
    }
    public Garderie(int id_garderie,int id_user, String nom, String adresse,int num_tel,String description,String image) {
        this.nom = nom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.id_garderie=id_garderie;
        this.image=image;
        this.id_user=id_user;
        this.description=description;
    }
    public Garderie(int id_user, String nom, String adresse,int num_tel,String description,String image) {
        this.nom = nom;
        this.adresse = adresse;
        this.num_tel = num_tel;
  
        this.image=image;
        this.id_user=id_user;
        this.description=description;
    }
     public Garderie(int id_user,String nom, String adresse, int num_tel) {
        this.nom = nom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.id_garderie=id_garderie;
  this.id_user=id_user;
        
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
     public Garderie(int id_user,String nom, String adresse, int num_tel,String description) {
        this.nom = nom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.description=description;
        this.id_user=id_user;
    }
    
 
    public int getId_garderie() {
        return id_garderie;
    }

    public void setId_garderie(int id_garderie) {
        this.id_garderie = id_garderie;
    }
    public Garderie(){
    
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    @Override
    public String toString() {
        return "est le nom de l'enfant::Garderie{" + " nom=" + nom + ", adresse=" + adresse + ", num_tel=" + num_tel +", descritpion=" + description + '}';
    }
    
    
    
    
}

