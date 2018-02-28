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
public class Quiz {
    private int id_quiz;
    private String theme;
     private String rep1;
      private String rep2;
       private String rep3;
        private String repC;
         private String image;
         
         private String question;
private int etat;
    public Quiz(int id_quiz, String theme, String image,String question, String rep1, String rep2, String rep3, String repC,int etat) {
        this.id_quiz = id_quiz;
        this.theme = theme;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.rep3 = rep3;
        this.repC = repC;
        this.image = image;
        this.question=question;
        this.etat=etat;
    }
    public Quiz( String theme, String image,String question, String rep1, String rep2, String rep3, String repC,int etat) {
       this.etat=etat;
        this.theme = theme;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.rep3 = rep3;
        this.repC = repC;
        this.image = image;
        this.question=question;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId_quiz() {
        return id_quiz;
    }

    public void setId_quiz(int id_quiz) {
        this.id_quiz = id_quiz;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getRep1() {
        return rep1;
    }

    public void setRep1(String rep1) {
        this.rep1 = rep1;
    }

    public String getRep2() {
        return rep2;
    }

    public void setRep2(String rep2) {
        this.rep2 = rep2;
    }

    public String getRep3() {
        return rep3;
    }

    public void setRep3(String rep3) {
        this.rep3 = rep3;
    }

    public String getRepC() {
        return repC;
    }

    public void setRepC(String repC) {
        this.repC = repC;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Quiz{" + "id_quiz=" + id_quiz + ", theme=" + theme + ", rep1=" + rep1 + ", rep2=" + rep2 + ", rep3=" + rep3 + ", repC=" + repC + ", image=" + image + ", question=" + question + ", etat=" + etat + '}';
    }

    

    
    
    
}
