/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import allforkids.entite.Question;
import allforkids.technique.util.DataSource;

/**
 *
 * @author user
 */
public class QuestionService implements IAllForKids<Question>{
Connection cnx;
Statement st;
ResultSet rs;
static QuestionService instance;
private QuestionService(){
 cnx=DataSource.getInstance().getConnexion();
    try {
        st=cnx.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
    } 
}
public static QuestionService getInstance()
    {
        if(instance==null)
        { instance = new QuestionService();}
        return instance;
    }

    @Override
    public void insert(Question p) {
        		
String req="insert into questions(id_user,date_question,description_question)values('"+p.getId_user()+"','"+p.getDate_creation()+"','"+p.getDescription()+"')";
     try {
            st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }

    @Override
    public List<Question> getAll() {
    List<Question> questions=new ArrayList<>();
        
    try {
        rs=st.executeQuery("select * from questions");
    } catch (SQLException ex) { 
        Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
      
    try {
        while(rs.next()){
           Question p;
        
            p = new Question(rs.getInt("id_user"),rs.getDate("date_question"),rs.getString("Description_question"));
            questions.add(p);
        }
    } catch (SQLException ex) { 
        Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return questions;
    }

    @Override
    public Question search(int n) {
Question p=null;
        try {
       
        rs=st.executeQuery("select * from questions where id_question="+n);
          if(rs.next())
   p = new Question(rs.getInt("id_user"),rs.getDate("date_question"),rs.getString("Description"));

    } catch (SQLException ex) { 
        Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
     Question p1=search(id);
        // System.out.println(p1);
         
   if(p1!=null)
   {
       try {
           st.executeUpdate("delete from questions where id_question="+id);
            return true;
       } catch (SQLException ex) {      
             Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
         }      
  
   }return false;
    }

    @Override
    public boolean update(Question p) {
Question p1=search(p.getId_question());
   if(p1!=null)
   {
        try {
            		

            st.executeUpdate("Update questions set id_question='"+p.getId_user()+"',date_question='"+p.getDate_creation()+"',description_question='"+p.getDescription()+"'where id_question="+p.getId_question());
       	

        } catch (SQLException ex) { 
        Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
    }
       return true ;
   }
   return false;
    }  

    @Override
    public Map<String, Question> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Question getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    }

 

   

