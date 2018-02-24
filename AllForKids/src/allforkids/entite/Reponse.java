/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Reponse {
    private int id_reponse;
    private int id_question;
    private int id_user;
    private Date date_creation;
    private String desciption;

    public Reponse(int id_reponse, int id_question, int id_user, Date date_creation, String desciption) {
        this.id_reponse = id_reponse;
        this.id_question = id_question;
        this.id_user = id_user;
        this.date_creation = date_creation;
        this.desciption = desciption;
    }

    public Reponse(int id_question, int id_user, Date date_creation, String desciption) {
        this.id_question = id_question;
        this.id_user = id_user;
        this.date_creation = date_creation;
        this.desciption = desciption;
    }

    public int getId_reponse() {
        return id_reponse;
    }

   

    public int getId_question() {
        return id_question;
    }

    public int getId_user() {
        return id_user;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    
    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Override
    public String toString() {
        return "Reponse{" + "id_reponse=" + id_reponse + ", id_question=" + id_question + ", id_user=" + id_user + ", date_creation=" + date_creation + ", desciption=" + desciption + '}';
    }
    
}
