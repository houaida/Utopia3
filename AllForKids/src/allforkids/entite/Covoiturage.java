/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author imen
 */
public class Covoiturage {
    
   private int id;
   private int id_user;
   private String depart;
   private String dateDepart;
   private String heureD;
   private String destination;
   private String dateArrive;
   private String heureA;
   private int nbre_place_dispo; 
 public Covoiturage (){}

    public Covoiturage(int id, int id_user, String depart, String dateDepart, String heureD, String destination, String dateArrive, String heureA, int nbre_place_dispo) {
        this.id = id;
        this.id_user = id_user;
        this.depart = depart;
        this.dateDepart = dateDepart;
        this.heureD = heureD;
        this.destination = destination;
        this.dateArrive = dateArrive;
        this.heureA = heureA;
        this.nbre_place_dispo = nbre_place_dispo;
    }

    public Covoiturage(int id_user, String depart, String dateDepart, String heureD,String destination, String dateArrive, String heureA, int nbre_place_dispo) {
        this.id_user = id_user;
        this.depart = depart;
        this.dateDepart = dateDepart;
        
        this.heureD = heureD;
        this.destination = destination;
        this.dateArrive = dateArrive;
        this.heureA = heureA;
        this.nbre_place_dispo = nbre_place_dispo;
    }

    public Covoiturage(String depart, String dateDepart,String heureD,String destination, String dateArrive, String heureA, int nbre_place_dispo) {
        this.depart = depart;
        this.dateDepart = dateDepart;
          this.heureD = heureD;
        this.destination = destination;
      
        this.dateArrive = dateArrive;
        this.heureA = heureA;
        this.nbre_place_dispo = nbre_place_dispo;
    }
   
   
   
   public java.sql.Date convert(String date) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date1 = sdf1.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        return sqlDate;
    }

    public String getHeureD() {
        return heureD;
    }

    public void setHeureD(String heureD) {
        this.heureD = heureD;
    }

    public String getHeureA() {
        return heureA;
    }

    public void setHeureA(String heureA) {
        this.heureA = heureA;
    }

    public Covoiturage(int id, int id_user, String depart, String dateDepart, String destination, String dateArrive, int nbre_place_dispo) {
        this.id = id;
        this.id_user = id_user;
        this.depart = depart;
        this.dateDepart = dateDepart;
        this.destination = destination;
        this.dateArrive = dateArrive;
        this.nbre_place_dispo = nbre_place_dispo;
    }

    public Covoiturage(int id_user, String depart, String dateDepart, String destination, String dateArrive, int nbre_place_dispo) {
        this.id_user = id_user;
        this.depart = depart;
        this.dateDepart = dateDepart;
        this.destination = destination;
        this.dateArrive = dateArrive;
        this.nbre_place_dispo = nbre_place_dispo;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(String dateArrive) {
        this.dateArrive = dateArrive;
    }

    public int getNbre_place_dispo() {
        return nbre_place_dispo;
    }

    public void setNbre_place_dispo(int nbre_place_dispo) {
        this.nbre_place_dispo = nbre_place_dispo;
    }

    @Override
    public String toString() {
        return "Covoiturage{" + "id=" + id + ", id_user=" + id_user + ", depart=" + depart + ", dateDepart=" + dateDepart + ", destination=" + destination + ", heureD=" + heureD + ", dateArrive=" + dateArrive + ", heureA=" + heureA + ", nbre_place_dispo=" + nbre_place_dispo + '}';
    }

   
    

    
   
}
