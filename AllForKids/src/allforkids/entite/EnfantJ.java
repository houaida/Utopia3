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
public class EnfantJ {
    private int id_enfant;
    private int id_parent;
    
     private int id_jardinEnfant;

    
    public void setId_jardinEnfant(int id_jardinEnfant) {
        this.id_jardinEnfant = id_jardinEnfant;
    }
    public int getId_jardinEnfant() {
        return id_jardinEnfant;
    }

    
    private String nom;
    private String prenom;
    private int age;

    public EnfantJ( int id_parent, String nom, String prenom, int age) {
        //this.id_enfant = id_enfant;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.id_parent=id_parent;
    }
    public EnfantJ(  String nom, String prenom) {
        //this.id_enfant = id_enfant;
        this.nom = nom;
        this.prenom = prenom;
        
    }
public EnfantJ(int id_parent,int id_jardinEnfant, String nom, String prenom, int age) {
       
        this.id_parent = id_parent;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
       
        this.id_jardinEnfant=id_jardinEnfant;
    }
    public EnfantJ(int id_enfant,int id_jardinEnfant, int id_parent, String nom, String prenom, int age) {
        this.id_enfant = id_enfant;
        this.id_parent = id_parent;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
       
        this.id_jardinEnfant=id_jardinEnfant;
    }

    public EnfantJ() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    @Override
    public String toString() {
        return "Enfant{"+"id_parent="+id_parent+ " nom=" + nom + ", prenom=" + prenom + ", age=" + age + '}';
    }

    public int getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(int id_enfant) {
        this.id_enfant = id_enfant;
    }

    public int getId_parent() {
        return id_parent;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

   

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
