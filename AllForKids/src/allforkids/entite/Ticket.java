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
public class Ticket {
    public int id_evenement;
    public int id_ticket;
    public String type;
    public float prix;
    public String etat;

    public Ticket(int id_evenement, String type, float prix, String etat) {
        this.id_evenement = id_evenement;
        this.type = type;
        this.prix = prix;
        this.etat = etat;
    }

    public int getId_evenement() {
        return id_evenement;
    }
    public int getId_ticket() {
        return id_ticket;
    }

    

    public String getType() {
        return type;
    }

    public float getPrix() {
        return prix;
    }

    public String getEtat() {
        return etat;
    }

    public void setRef_evenement(int ref_evenement) {
        this.id_evenement = ref_evenement;
    }

   

    public void setType(String type) {
        this.type = type;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    
    
}
