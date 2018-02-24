/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;


import allforkids.entite.Parent;
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
import javafx.scene.control.Alert;

/**
 *
 * @author MacBook
 */
public class ParentService implements IAllForKids<Parent> {
     Connection connexion;
Statement st;
ResultSet result;
static ParentService instance;
 public static ParentService getInstance()
    {
    if(instance==null)
    {
    instance = new ParentService();}
    return instance;
    
    }
public ParentService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public void insert(Parent t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String req="insert into users(cin,nom,prenom,pseudo,mdp,email,adresse,montant,nom_club,num_tel,type,date_naissance,image)values('"+t.getCin()+"','"+t.getNom()+"',"
            + "'"+t.getPrenom()+"','"+t.getPseudo()+"','"+t.getMdp()+"','"+t.getEmail()+"','"+t.getAdresse()+"','"+t.getMontant()+"','','"+t.getNum_tel()+"','parent','00-00-0000','"+t.getImage()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<Parent> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<Parent> Parents=FXCollections.observableArrayList();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from users where type='parent'");
    } catch (SQLException ex) {
        Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            Parent p=new Parent(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getFloat(9),result.getString(12));
            Parents.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Parents;
    }

    @Override
    public Parent search(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Parent p=null;
        try {
            System.out.println(id);
        result=st.executeQuery("select * from users where type='parent' and id_user="+id);
          if(result.next())
         p = new Parent(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getFloat(9),result.getString(12),result.getString(14),result.getString(11));
    } catch (SQLException ex) {
        Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }
public Parent findbyMail(String s) {
       Parent user = null;
        String req = "select * from users where email =? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connexion.prepareStatement(req);
            preparedStatement.setString(1, s);
             result = preparedStatement.executeQuery();
            while (result.next()) {
                user = new Parent(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getFloat(9),result.getString(12),result.getString(13),result.getString(11));
                break;
            }
        } catch (SQLException ex) {
            System.out.println("mail not found ");
        }
        return user;
    }
    @Override
    public boolean delete(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Parent p=search(id);
        System.out.println(id);
   if(p!=null)
   {System.out.println(p);
       try {
           st.executeUpdate("delete from users where id_user="+id);
            return true;
       } catch (SQLException ex) {
           System.out.println("parent ne peut pas être supprimer à cause de son enfant");
           //Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Parent t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  Parent p1=search(t.getId_user());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update users set cin='"+t.getCin()+"',nom='"+t.getNom()+"', prenom='"
                    +t.getPrenom()+"', pseudo='"+t.getPseudo()+"', mdp='"+t.getMdp()+"', email='"+t.getEmail()+"', adresse='"+t.getAdresse()+"', montant='"+t.getMontant()+"' where id_user="+t.getId_user());
        } catch (SQLException ex) {
            Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

    @Override
    public Map<String, Parent> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public  ObservableList<Parent> getAllByName(String nom) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<Parent> Parents=FXCollections.observableArrayList();
   String requete = "select * from users where type='parent' and nom=?";
        //// "select * from user where username like '"+search+"
        
        System.out.println(requete);
        
        PreparedStatement preparedStatement;

        try {
          
             preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, nom);
           result = preparedStatement.executeQuery();
            while (result.next()) {

            Parent p=new Parent(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getFloat(9),result.getString(12));
            Parents.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Parents;
    }

    @Override
    public Parent getbyPseudo(String pseudo) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String requete = "select * from users where pseudo=?";
        //// "select * from user where username like '"+search+"
        
        System.out.println(requete);
        Parent p=null;
        PreparedStatement preparedStatement;

        try {
          
             preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, pseudo);
           result = preparedStatement.executeQuery();
            while (result.next()) {

                
                p = new Parent(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getFloat(9),result.getString(12));
            }
       
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des parents " + ex.getMessage());
            
        }
        return p;
    }
      public Parent findbyLogin(String s) {
        Parent user = null;
        String req = "select * from users where pseudo =? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connexion.prepareStatement(req);
            preparedStatement.setString(1, s);
             result = preparedStatement.executeQuery();
            while (result.next()) {
                user = new Parent(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getFloat(9),result.getString(12));
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
}

