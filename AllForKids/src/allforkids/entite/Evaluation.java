/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

/**
 *
 * @author MacBook
 */
public class Evaluation {
    private int id_evaluation;
    private int id_enseignant;
    private String matiere;
    private float moyenne;
    private String nom_enseignant;
    private String nom_enfant;

  private String prenom_enfant;
    public Evaluation(int id_evaluation,int id_enseignant, String matiere, float moyenne, String nom_enseignant,String nom_enfant,String prenom_enfant) {
        this.id_evaluation = id_evaluation;
        this.matiere = matiere;
        this.moyenne = moyenne;
        this.nom_enseignant = nom_enseignant;
         this.nom_enfant=nom_enfant;
        this.prenom_enfant=prenom_enfant;
        this.id_enseignant=id_enseignant;
    }

    public Evaluation(int id_enseignant,String matiere, float moyenne, String nom_enseignant,String nom_enfant,String prenom_enfant) {
        this.matiere = matiere;
        this.moyenne = moyenne;
        this.nom_enseignant = nom_enseignant;
        this.nom_enfant=nom_enfant;
        this.prenom_enfant=prenom_enfant;
        this.id_enseignant=id_enseignant;
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    
    public int getId_evaluation() {
        return id_evaluation;
    }

    public void setId_evaluation(int id_evaluation) {
        this.id_evaluation = id_evaluation;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public String getNom_enfant() {
        return nom_enfant;
    }

    public void setNom_enfant(String nom_enfant) {
        this.nom_enfant = nom_enfant;
    }

    public String getPrenom_enfant() {
        return prenom_enfant;
    }

    public void setPrenom_enfant(String prenom_enfant) {
        this.prenom_enfant = prenom_enfant;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public String getNom_enseignant() {
        return nom_enseignant;
    }

    public void setNom_enseignant(String nom_enseignant) {
        this.nom_enseignant = nom_enseignant;
    }

    @Override
    public String toString() {
        return "Evaluation{" + "id_evaluation=" + id_evaluation + ", matiere=" + matiere + ", moyenne=" + moyenne + ", nom_enseignant=" + nom_enseignant + ", nom_enfant=" + nom_enfant + ", prenom_enfant=" + prenom_enfant + '}';
    }

    
    
}
