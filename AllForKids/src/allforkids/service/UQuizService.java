/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Quiz;
import allforkids.entite.UQuiz;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MacBook
 */
public class UQuizService implements IAllForKids<UQuiz>{
    Connection connexion;
Statement st;
ResultSet result;
static UQuizService instance;
 public static UQuizService getInstance()
    {
    if(instance==null)
    
    {instance = new UQuizService();}
    return instance;
    
    }
 
public UQuizService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(UQuizService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @Override
    public void insert(UQuiz t) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     String req="insert into UserQuiz(id_user,id_quiz)values('"+t.getId_user()+"','"+t.getId_quiz()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(UQuizService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<UQuiz> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     ObservableList<UQuiz> Quizs=FXCollections.observableArrayList();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from UserQuiz ");
    } catch (SQLException ex) {
        Logger.getLogger(UQuizService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
           UQuiz p=new UQuiz(result.getInt(1),result.getInt(2),result.getInt(3));
            Quizs.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(UQuizService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Quizs;
    
    }

    @Override
    public Map<String, UQuiz> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UQuiz search(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   UQuiz p=null;
        try {
       
        result=st.executeQuery("select * from UserQuiz where id_userquiz="+id);
          if(result.next())
         p = new UQuiz(result.getInt(1),result.getInt(2),result.getInt(3));
    } catch (SQLException ex) {
        Logger.getLogger(QuizService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }
public UQuiz findbyId(int s,int s1) {
        UQuiz user = null;
        String req = "select * from UserQuiz where id_user=? and id_quiz=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connexion.prepareStatement(req);
            preparedStatement.setInt(1, s);
             preparedStatement.setInt(2, s1);
             result = preparedStatement.executeQuery();
            while (result.next()) {
                user =new UQuiz(result.getInt(1),result.getInt(2),result.getInt(3));
                break;
            }
        } catch (SQLException ex) {
            System.out.println("UQuiz not found ");
        }
        return user;
    }

    @Override
    public boolean delete(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    UQuiz p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from UserQuiz where id_userquiz="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(QuizService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(UQuiz t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }

    @Override
    public UQuiz getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
