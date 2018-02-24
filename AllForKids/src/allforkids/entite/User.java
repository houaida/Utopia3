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
public class User {
    private int id_user;
   
    private String pseudo;
    private String mdp;
   
    private String email;
    private String type;

    

     private String image ; 


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User() {
    }
   
     public User(int id_user, String pseudo, String mdp, String email) {
        this.id_user = id_user;
       
        this.pseudo = pseudo;
        this.mdp = mdp;
        
        this.email = email;
       
       
    }

    public User(int id_user, String pseudo, String mdp, String email,String type) {
        this.id_user = id_user;
       
        this.pseudo = pseudo;
        this.mdp = mdp;
        
        this.email = email;
       this.type=type;
       
    }
    
     public User(int id_user, String pseudo, String mdp, String email,String type,String image) {
        this.id_user = id_user;
       
        this.pseudo = pseudo;
        this.mdp = mdp;
        
        this.email = email;
       this.type=type;
       
       this.image = image ; 
       
    }
    

    public User(String pseudo, String mdp, String email,String type) {
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email = email;
        this.type=type;
        
    }
     public User(String pseudo, String mdp, String email) {
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email = email;
        
        
    }

    @Override
    public String toString() {
        return  " pseudo=" + pseudo + ", mdp=" +mdp + ", email=" + email ;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

  

   
}

