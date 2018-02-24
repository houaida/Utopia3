/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Enfant;
import allforkids.entite.EnfantJ;
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
public class EnfantJService implements IAllForKids<EnfantJ> {
    Connection connexion;
Statement st;
ResultSet result;
static EnfantJService instance;
 public static EnfantJService getInstance()
    {
    if(instance==null)
    {instance = new EnfantJService();}
    return instance;
    
    }
public EnfantJService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(EnfantJService.class.getName()).log(Level.SEVERE, null, ex);
    }
}public EnfantJ searchGard(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    EnfantJ p=null;
        try {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        
        result=st.executeQuery("select * from enfantsJ  where id_jardinEnfant="+id);
          if(result.next())
         p = new EnfantJ(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),result.getString(5),result.getInt(6));
    } catch (SQLException ex) {
        Logger.getLogger(EnfantJService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }
    @Override
    public void insert(EnfantJ t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   String req="insert into enfantsJ(id_parent,id_jardinEnfant,nom_enfant,prenom,age)values('"+t.getId_parent()+"','"+t.getId_jardinEnfant()+"','"+t.getNom()+"','"+t.getPrenom()+"','"+t.getAge()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EnfantJService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public  ObservableList<EnfantJ> getAllByName(String nom) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<EnfantJ> Enfants=FXCollections.observableArrayList();
   String requete = "select * from enfantsJ where nom_enfant=?";
        //// "select * from user where username like '"+search+"
        
        System.out.println(requete);
        
        PreparedStatement preparedStatement;

        try {
          
             preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, nom);
           result = preparedStatement.executeQuery();
            while (result.next()) {

            EnfantJ p=new EnfantJ(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),result.getString(5),result.getInt(6));
            Enfants.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EnfantJService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Enfants;
    }

    @Override
    public  List<EnfantJ> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     List<EnfantJ> Enfants=new ArrayList<>();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from enfantsJ e join users u on e.id_parent= u.id_user where type='parent'");
    } catch (SQLException ex) {
        Logger.getLogger(EnfantJService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            //Enfant p=new Enfant(result.getInt(2),result.getString(3),result.getString(4),result.getInt(5));
            EnfantJ p=new EnfantJ(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),result.getString(5),result.getInt(6));
            Enfants.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EnfantJService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Enfants;
    }

    @Override
    public EnfantJ search(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    EnfantJ p=null;
        try {
       
        result=st.executeQuery("select * from enfantsJ where id_enfant="+id);
          if(result.next())
         p = new EnfantJ(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),result.getString(5),result.getInt(6));
    } catch (SQLException ex) {
        Logger.getLogger(EnfantJService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    EnfantJ p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from enfantsJ where id_enfant="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(EnfantJService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(EnfantJ t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    EnfantJ p1=search(t.getId_enfant());
        System.out.println(p1);
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update enfantsJ set nom_enfant='"+t.getNom()+"', prenom='"+t.getPrenom()+"', age='"+t.getAge()+"' where id_enfant="+t.getId_enfant());
        } catch (SQLException ex) {
            Logger.getLogger(EnfantJService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

    @Override
    public Map<String, EnfantJ> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EnfantJ getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public  ObservableList<EnfantJ> getListeEnfant(String nom) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     ObservableList<EnfantJ> garderies=FXCollections.observableArrayList();
        System.out.println(nom);
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from enfantsJ g join jardinEnfants e on g.id_jardinEnfant=e.id_jardinEnfant where e.nom like '%"+nom+"'");
    } catch (SQLException ex) {
        Logger.getLogger(EnfantJService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        
    try {
        while(result.next()){
            EnfantJ p=new EnfantJ(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),result.getString(5),result.getInt(6));
            
            System.out.println(p.toString());
            garderies.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EnfantJService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  garderies;
    }
    /*public  ObservableList<Enfant> getListeEnfantJ(String nom) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     ObservableList<Enfant> garderies=FXCollections.observableArrayList();
        System.out.println(nom);
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from enfants g join jardinEnfants e on g.id_jardinEnfant=e.id_jardinEnfant where e.nom like '%"+nom+"'");
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        
    try {
        while(result.next()){
            Enfant p=new Enfant(result.getInt(1),result.getInt(2),result.getInt(3),result.getInt(4),result.getString(5),result.getString(6),result.getInt(7));
            
            System.out.println(p.toString());
            garderies.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  garderies;
    }*/
    public EnfantJ searchEnfantJ(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
       EnfantJ p=null;
        try {
       
        result=st.executeQuery("select * from enfantsJ where id_parent="+id);
          while(result.next())
          {  p=new EnfantJ(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),result.getString(5),result.getInt(6));
          } 
        } catch (SQLException ex) {
        Logger.getLogger(EnfantJService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
       return  p;
    }
}



