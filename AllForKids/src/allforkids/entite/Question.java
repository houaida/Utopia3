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
public class Question {
    private int id_question;
    private int id_user;
    private Date date_creation;
    private String description;

    public Question(int id_question, int id_user, Date date_creation, String description) {
        this.id_question = id_question;
        this.id_user = id_user;
        this.date_creation = date_creation;
        this.description = description;
    }

    public Question(int id_user, Date date_creation, String description) {
        this.id_user = id_user;
        this.date_creation = date_creation;
        this.description = description;
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

    public String getDescription() {
        return description;
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

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Question{" + "id_question=" + id_question + ", id_user=" + id_user + ", date_creation=" + date_creation + ", description=" + description + '}';
    }
    
    
}
