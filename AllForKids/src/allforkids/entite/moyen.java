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
public class moyen {
    private int id;
    private int id_enfant;
 
    private String description;
    private int nbr;

    public moyen(int id, int id_enfant, String description, int nbr) {
        this.id = id;
        this.id_enfant = id_enfant;
        this.description = description;
        this.nbr = nbr;
    }

    public moyen(int id, String description, int nbr) {
        this.id = id;
        this.description = description;
        this.nbr = nbr;
    }

    public moyen(String description, int nbr) {
        this.description = description;
        this.nbr = nbr;
    }

    public moyen(int id_enfant) {
        this.id_enfant = id_enfant;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(int id_enfant) {
        this.id_enfant = id_enfant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }
    
    
    
}
