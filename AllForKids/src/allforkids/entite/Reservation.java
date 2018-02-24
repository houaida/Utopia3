/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

/**
 *
 * @author imen
 */
public class Reservation {
    
    private int id;
    private int id_user; 
    private int nbre_place;
    private int idC;

    public Reservation(int idC) {
        this.idC = idC;
    }
    
    
    public Reservation(int id, int id_user, int nbre_place) {
        this.id = id;
        this.id_user = id_user;
        this.nbre_place = nbre_place;
    }

    public Reservation(int id_user, int nbre_place) {
        this.id_user = id_user;
        this.nbre_place = nbre_place;
    }

   /* public Reservation(int id, int id_user, int nbre_place, int idC) {
        this.id = id;
        this.id_user = id_user;
        this.nbre_place = nbre_place;
        this.idC = idC;
    }*/

    public Reservation(int id, int id_user, int nbre_place, int idC) {
        this.id = id;
        this.id_user = id_user;
        this.nbre_place = nbre_place;
        this.idC = idC;
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

    public int getNbre_place() {
        return nbre_place;
    }

    public void setNbre_place(int nbre_place) {
        this.nbre_place = nbre_place;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", id_user=" + id_user + ", nbre_place=" + nbre_place + ", idC=" + idC + '}';
    }
    
    
}
