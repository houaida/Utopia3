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
public class Forum {
    private int id_forum;
    private int id_question;	
    private int id_reponse;
    private String titre;

    public Forum(int id_forum, int id_question, int id_reponse,String titre) {
        this.id_forum = id_forum;
        this.id_question = id_question;
        this.id_reponse = id_reponse;
        this.titre=titre;
    }

    public Forum(int id_question, int id_reponse,String titre) {
        this.id_question = id_question;
        this.id_reponse = id_reponse;
        this.titre=titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public int getId_forum() {
        return id_forum;
    }

    

    public int getId_question() {
        return id_question;
    }

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_forum(int id_forum) {
        this.id_forum = id_forum;
    }

   

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    @Override
    public String toString() {
        return "Forum{" + "id_forum=" + id_forum + ", id_question=" + id_question + ", id_reponse=" + id_reponse + ", titre=" + titre + '}';
    }

   
    
    
}
