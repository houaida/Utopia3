/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;


import allforkids.entite.Enseignant;
import allforkids.entite.Evaluation;

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
public class EvaluationService implements IAllForKids<Evaluation> {

     Connection connexion;
Statement st;
ResultSet result;
static EvaluationService instance;
 public static EvaluationService getInstance()
    {
    if(instance==null)
    
    {instance = new EvaluationService();}
    return instance;
    
    }
 
public EvaluationService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(EvaluationService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public void insert(Evaluation t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String req="insert into evaluations(id_enseignant,matiere,moyenne,nom_enseignant,nom_enfant,prenom_enfant)values('"+t.getId_enseignant()+"','"+t.getMatiere()+"','"+t.getMoyenne()+"',"
            + "'"+t.getNom_enseignant()+"','"+t.getNom_enfant()+"','"+t.getPrenom_enfant()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public  ObservableList<Evaluation> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<Evaluation> Evaluations=FXCollections.observableArrayList();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from evaluations");
    } catch (SQLException ex) {
        Logger.getLogger(EvaluationService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            Evaluation p=new Evaluation(result.getInt(1),result.getInt(2),result.getString(3),result.getFloat(4),result.getString(5),result.getString(6),result.getString(7));
            Evaluations.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EvaluationService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Evaluations;
    }
    
    public  ObservableList<Evaluation> getAllByName(String nom) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<Evaluation> Evaluations=FXCollections.observableArrayList();
   String requete = "select * from evaluations where nom_enfant=?";
        //// "select * from user where username like '"+search+"
        
        System.out.println(requete);
        
        PreparedStatement preparedStatement;

        try {
          
             preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, nom);
           result = preparedStatement.executeQuery();
            while (result.next()) {

            Evaluation p=new Evaluation(result.getInt(1),result.getInt(2),result.getString(3),result.getFloat(4),result.getString(5),result.getString(6),result.getString(7));
            Evaluations.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EvaluationService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Evaluations;
    }
    public  ObservableList<Evaluation> getAllByIDEns(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<Evaluation> Evaluations=FXCollections.observableArrayList();
   try {
       
        result=st.executeQuery("select * from evaluations where id_enseignant="+id);
          
            while (result.next()) {

            Evaluation p=new Evaluation(result.getInt(1),result.getInt(2),result.getString(3),result.getFloat(4),result.getString(5),result.getString(6),result.getString(7));
            Evaluations.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EvaluationService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Evaluations;
    }

    @Override
    public Evaluation search(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Evaluation p=null;
        try {
       
        result=st.executeQuery("select * from evaluations where id_evaluation="+id);
          if(result.next())
         p = new Evaluation(result.getInt(1),result.getInt(2),result.getString(3),result.getFloat(4),result.getString(5),result.getString(6),result.getString(7));
    } catch (SQLException ex) {
        Logger.getLogger(EvaluationService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Evaluation p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from evaluations where id_evaluation="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(EvaluationService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Evaluation t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  Evaluation p1=search(t.getId_evaluation());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update evaluations set  matiere='"+t.getMatiere()+"',moyenne='"+t.getMoyenne()+"', nom_enseignant='"+t.getNom_enseignant()+"',nom_enfant='"
                    +t.getNom_enfant()+"', prenom_enfant='"
                    +t.getPrenom_enfant()+"' where id_evaluation="+t.getId_evaluation());
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

    @Override
    public Map<String, Evaluation> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Evaluation getbyPseudo(String Nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
 public  ObservableList<Evaluation> getAllEvaluations(String nom,String prenom) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<Evaluation> Evaluations=FXCollections.observableArrayList();
   String requete = "select * from evaluations where nom_enfant=? and prenom_enfant=?";
        //// "select * from user where username like '"+search+"
        
        System.out.println(requete);
        
        PreparedStatement preparedStatement;

        try {
          
             preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, prenom);
           result = preparedStatement.executeQuery();
            while (result.next()) {

            Evaluation p=new Evaluation(result.getInt(1),result.getInt(2),result.getString(3),result.getFloat(4),result.getString(5),result.getString(6),result.getString(7));
            Evaluations.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EvaluationService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Evaluations;
    }
    
    }