/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Enseignant;
import allforkids.entite.ProprietaireG;
import allforkids.entite.Quiz;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MacBook
 */
public class QuizService implements IAllForKids<Quiz> {
 Connection connexion;
Statement st;
ResultSet result;
static QuizService instance;
 public static QuizService getInstance()
    {
    if(instance==null)
    
    {instance = new QuizService();}
    return instance;
    
    }
 
public QuizService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(QuizService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @Override
    public void insert(Quiz t) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     String req="insert into Quiz(theme,image,question,rep1,rep2,rep3,repC,etat)values('"+t.getTheme()+"','"+t.getImage()+"','"+t.getQuestion()+"','"+t.getRep1()+"','"+t.getRep2()+"','"+t.getRep3()+"','"+t.getRepC()+"','0')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(QuizService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<Quiz> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     ObservableList<Quiz> Quizs=FXCollections.observableArrayList();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from Quiz ");
    } catch (SQLException ex) {
        Logger.getLogger(QuizService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
           Quiz p=new Quiz(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getInt(9));
            Quizs.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(QuizService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Quizs;
    
    }

    @Override
    public Map<String, Quiz> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Quiz search(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   Quiz p=null;
        try {
       
        result=st.executeQuery("select * from Quiz where id_quiz="+id);
          if(result.next())
         p = new Quiz(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getInt(9));
    } catch (SQLException ex) {
        Logger.getLogger(QuizService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }
public Quiz findbyEtat(int s) {
        Quiz user = null;
        String req = "select * from Quiz where etat=? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connexion.prepareStatement(req);
            preparedStatement.setInt(1, s);
             result = preparedStatement.executeQuery();
            while (result.next()) {
                user =new Quiz(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getInt(9));
                break;
            }
        } catch (SQLException ex) {
            System.out.println("Quiz not found ");
        }
        return user;
    }

    @Override
    public boolean delete(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Quiz p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from Quiz where id_quiz="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(QuizService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Quiz t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Quiz p1=search(t.getId_quiz());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update Quiz set  theme='"+t.getTheme()+"',image='"+t.getImage()+"',question='"+t.getQuestion()+"', rep1='"
                    +t.getRep1()+"', rep2='"+t.getRep2()+"', rep3='"+t.getRep3()+"', repC='"+t.getRepC()+"', etat='"+t.getEtat()+"' where id_quiz="+t.getId_quiz());
        } catch (SQLException ex) {
            Logger.getLogger(QuizService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }
public boolean update2(Quiz t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Quiz p1=search(t.getId_quiz());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update Quiz set  theme='"+t.getTheme()+"',image='"+t.getImage()+"',question='"+t.getQuestion()+"', rep1='"
                    +t.getRep1()+"', rep2='"+t.getRep2()+"', rep3='"+t.getRep3()+"', repC='"+t.getRepC()+"', etat='0' where id_quiz="+t.getId_quiz());
        } catch (SQLException ex) {
            Logger.getLogger(QuizService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

    @Override
    public Quiz getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
