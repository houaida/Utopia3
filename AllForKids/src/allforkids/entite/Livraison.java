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
public class Livraison {
    
    private int id_livraison ; 
    private int id_livreur ; 
    private int id_parent ; 
    private int duree ; 
    private int montant ; 
    private String adresse ; 

    public Livraison(int id_livraison, int id_livreur, int id_parent, int duree, int montant, String adresse) {
        this.id_livraison = id_livraison;
        this.id_livreur = id_livreur;
        this.id_parent = id_parent;
        this.duree = duree;
        this.montant = montant;
        this.adresse = adresse;
    }

    public Livraison(int id_livreur, int id_parent, int duree, int montant, String adresse) {
        this.id_livreur = id_livreur;
        this.id_parent = id_parent;
        this.duree = duree;
        this.montant = montant;
        this.adresse = adresse;
    }

    public int getId_livraison() {
        return id_livraison;
    }

    public int getId_livreur() {
        return id_livreur;
    }

    public int getId_parent() {
        return id_parent;
    }

    public int getDuree() {
        return duree;
    }

    public int getMontant() {
        return montant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }

    public void setId_livreur(int id_livreur) {
        this.id_livreur = id_livreur;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id_livraison=" + id_livraison + ", id_livreur=" + id_livreur + ", id_parent=" + id_parent + ", duree=" + duree + ", montant=" + montant + ", adresse=" + adresse + '}';
    }
    
    
    
}
