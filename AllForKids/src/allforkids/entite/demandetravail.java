/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

/**
 *
 * @author user
 */
public class demandetravail {
    private int id_babysitter;
    private int id_demandeTravail;
    private String niveau_etude;
    private String poste_actuel;
    private String langue;
    private String nom;
    private String prenom;
    private String image;
       private String num_tel;


    public demandetravail(int id_babysitter, int id_demandeTravail, String niveau_etude, String poste_actuel, String langue) {
        this.id_babysitter = id_babysitter;
        this.id_demandeTravail = id_demandeTravail;
        this.niveau_etude = niveau_etude;
        this.poste_actuel = poste_actuel;
        this.langue = langue;
    }

    public demandetravail(String niveau_etude, String poste_actuel, String langue) {
        this.niveau_etude = niveau_etude;
        this.poste_actuel = poste_actuel;
        this.langue = langue;
    }

    public demandetravail(String niveau_etude, String poste_actuel, String langue, String nom, String prenom, String image, String num_tel) {
        this.id_babysitter = id_babysitter;
        this.id_demandeTravail = id_demandeTravail;
        this.niveau_etude = niveau_etude;
        this.poste_actuel = poste_actuel;
        this.langue = langue;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
        this.num_tel = num_tel;
    }

    public demandetravail(int id_babysitter, int id_demandeTravail, String niveau_etude, String poste_actuel, String langue, String nom, String prenom, String image, String num_tel) {
        this.id_babysitter = id_babysitter;
        this.id_demandeTravail = id_demandeTravail;
        this.niveau_etude = niveau_etude;
        this.poste_actuel = poste_actuel;
        this.langue = langue;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
        this.num_tel = num_tel;
    }

 
 

   

   
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getId_babysitter() {
        return id_babysitter;
    }

    public int getId_demandeTravail() {
        return id_demandeTravail;
    }

    public String getNiveau_etude() {
        return niveau_etude;
    }

    public String getPoste_actuel() {
        return poste_actuel;
    }

    public String getLangue() {
        return langue;
    }

    public void setId_babysitter(int id_babysitter) {
        this.id_babysitter = id_babysitter;
    }

    public void setId_demandeTravail(int id_demandeTravail) {
        this.id_demandeTravail = id_demandeTravail;
    }

    public void setNiveau_etude(String niveau_etude) {
        this.niveau_etude = niveau_etude;
    }

    public void setPoste_actuel(String poste_actuel) {
        this.poste_actuel = poste_actuel;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    @Override
    public String toString() {
        return "demandetravail{" + "id_babysitter=" + id_babysitter + ", id_demandeTravail=" + id_demandeTravail + ", niveau_etude=" + niveau_etude + ", poste_actuel=" + poste_actuel + ", langue=" + langue + ", nom=" + nom + ", prenom=" + prenom + ", image=" + image + '}';
    }

    public String getImage() {
        return image;
    }

    public String getNum_tel() {
        return num_tel;
    }

   
    
}
