/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

/**
 *
 * @author Molka
 */
public class Livreur extends User {
    
    private int disponibilite ; 
 public Livreur(int id, String pseudo, String mdp, String mail,int disponibilite) {
        super(id, pseudo, mdp, mail);
        this.disponibilite = disponibilite ;
    }
    public Livreur( String pseudo, String mdp, String mail,int disponibilite) {
        super( pseudo, mdp, mail);
        this.disponibilite = disponibilite ;
    }

    public Livreur(int id, String pseudo, String mdp, String mail,int disponibilite,String type) {
        super(id, pseudo, mdp, mail,type);
        this.disponibilite = disponibilite ;
    }
    public Livreur( String pseudo, String mdp, String mail,int disponibilite,String type) {
        super( pseudo, mdp, mail,type);
        this.disponibilite = disponibilite ;
    }

    public int getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }

    @Override
    public String toString() {
        return super.toString()+"Livreur{" + "disponibilite=" + disponibilite + '}';
    }

    
    
    
    
}
