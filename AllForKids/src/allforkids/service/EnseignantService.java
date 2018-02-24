/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Enseignant;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class EnseignantService implements IAllForKids<Enseignant>{
     Connection connexion;
Statement st;
ResultSet result;
static EnseignantService instance;
 public static EnseignantService getInstance()
    {
    if(instance==null)
    
    {instance = new EnseignantService();}
    return instance;
    
    }
 
public EnseignantService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(EnseignantService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public void insert(Enseignant t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String req="insert into users(cin,nom,prenom,pseudo,mdp,email,adresse,montant,nom_club,num_tel,type,image)values('"+t.getCin()+"','"+t.getNom()+"',"
            + "'"+t.getPrenom()+"','"+t.getPseudo()+"','"+t.getMdp()+"','"+t.getEmail()+"','','"+t.getMontant()+"','"+t.getNom_club()+"','0','enseignant','"+t.getImage()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<Enseignant> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       ObservableList<Enseignant> Enseignants=FXCollections.observableArrayList();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from users where type='enseignant'");
    } catch (SQLException ex) {
        Logger.getLogger(EnseignantService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            Enseignant p=new Enseignant(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getFloat(9),result.getString(10),result.getString(12),result.getString(13));
            Enseignants.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EnseignantService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Enseignants;
    }

    @Override
    public Enseignant search(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Enseignant p=null;
        try {
       
        result=st.executeQuery("select * from users where id_user="+id);
          if(result.next())
         p = new Enseignant(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getFloat(9),result.getString(10),result.getString(12),result.getString(13));
    } catch (SQLException ex) {
        Logger.getLogger(EnseignantService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }
    

    @Override
    public boolean delete(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Enseignant p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from users where id_user="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(EnseignantService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Enseignant t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  Enseignant p1=search(t.getId_user());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update users set  cin='"+t.getCin()+"',nom='"+t.getNom()+"', prenom='"
                    +t.getPrenom()+"', pseudo='"+t.getPseudo()+"', mdp='"+t.getMdp()+"', email='"+t.getEmail()+"', montant='"+t.getMontant()+"', nom_club='"+t.getNom_club()+"' where id_user="+t.getId_user());
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }
@Override
    public Enseignant getbyPseudo(String pseudo) {
        
        String requete = "select * from users where pseudo=?";
        //// "select * from user where username like '"+search+"
        
        System.out.println(requete);
        Enseignant p=null;
        PreparedStatement preparedStatement;

        try {
          
             preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, pseudo);
           result = preparedStatement.executeQuery();
            while (result.next()) {

                
                p = new Enseignant(result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getFloat(9),result.getString(10),result.getString(13));
            }
       
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des enseignants " + ex.getMessage());
            
        }
        return p;
    }
    public Enseignant getbyNom(String nom) {
        
        String requete = "select * from users where nom=?";
        //// "select * from user where username like '"+search+"
        
        System.out.println(requete);
        Enseignant p=null;
        PreparedStatement preparedStatement;

        try {
          
             preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, nom);
           result = preparedStatement.executeQuery();
            while (result.next()) {

                
                p = new Enseignant(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getFloat(9),result.getString(10),result.getString(13));
            }
       
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des enseignants " + ex.getMessage());
            
        }
        return p;
    }
    public  ObservableList<Enseignant> getAllByName(String nom) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<Enseignant> Enseignants=FXCollections.observableArrayList();
   String requete = "select * from users where type='enseignant' and nom=?";
        //// "select * from user where username like '"+search+"
        
        System.out.println(requete);
        
        PreparedStatement preparedStatement;

        try {
          
             preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, nom);
           result = preparedStatement.executeQuery();
            while (result.next()) {

           Enseignant p=new Enseignant(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getFloat(9),result.getString(10),result.getString(12));
            Enseignants.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EnseignantService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Enseignants;
    }
    @Override
    public Map<String, Enseignant> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public Enseignant findbyMail(String s) {
        Enseignant user = null;
        String req = "select * from users where email =? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connexion.prepareStatement(req);
            preparedStatement.setString(1, s);
             result = preparedStatement.executeQuery();
            while (result.next()) {
                user = new Enseignant(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getFloat(9),result.getString(10),result.getString(12),result.getString(13));
                break;
            }
        } catch (SQLException ex) {
            System.out.println("mail not found ");
        }
        return user;
    }
    
    }
    
