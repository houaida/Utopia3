/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hammamet
 */
public class Membre {
    
    private int id;
    private String nom;
    private String prenom;
    private Date date_inscription;
    private int age;
    private int num_parent;
    private String email_parent;

    public Membre(String nom, String prenom, Date date_inscription, int age, int num_parent, String email_parent) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_inscription = date_inscription;
        this.age = age;
        this.num_parent = num_parent;
        this.email_parent = email_parent;
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

    public Date getDate_inscription() {
        return date_inscription;
    }

    public int getAge() {
        return age;
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

    public void setDate_inscription(Date date_inscription) {
        this.date_inscription = date_inscription;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNum_parent(int num_parent) {
        this.num_parent = num_parent;
    }

    public void setEmail_parent(String email_parent) {
        this.email_parent = email_parent;
    }
    
    
    
    
    
}
