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
public class UQuiz {
    private int id_userquiz;
    private int id_user;
    private int id_quiz;

    public UQuiz(int id_userquiz, int id_user, int id_quiz) {
        this.id_userquiz = id_userquiz;
        this.id_user = id_user;
        this.id_quiz = id_quiz;
    }

    public UQuiz(int id_user, int id_quiz) {
        this.id_user = id_user;
        this.id_quiz = id_quiz;
    }

    @Override
    public String toString() {
        return "UQuiz{" + "id_userquiz=" + id_userquiz + ", id_user=" + id_user + ", id_quiz=" + id_quiz + '}';
    }

    public int getId_userquiz() {
        return id_userquiz;
    }

    public void setId_userquiz(int id_userquiz) {
        this.id_userquiz = id_userquiz;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_quiz() {
        return id_quiz;
    }

    public void setId_quiz(int id_quiz) {
        this.id_quiz = id_quiz;
    }
    
    
}
