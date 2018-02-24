/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Enfant;
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
public class EnfantService implements IAllForKids<Enfant> {
    Connection connexion;
Statement st;
ResultSet result;
static EnfantService instance;
 public static EnfantService getInstance()
    {
    if(instance==null)
    {instance = new EnfantService();}
    return instance;
    
    }
public EnfantService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @Override
    public void insert(Enfant t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   String req="insert into enfants(id_parent,id_garderie,nom_enfant,prenom,age)values('"+t.getId_parent()+"','"+t.getId_garderie()+"','"+t.getNom()+"','"+t.getPrenom()+"','"+t.getAge()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Enfant searchGard(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Enfant p=null;
        try {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        
        result=st.executeQuery("select * from enfants  where id_garderie="+id);
          if(result.next())
         p = new Enfant(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),result.getString(5),result.getInt(6));
    } catch (SQLException ex) {
        Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }
 public  ObservableList<Enfant> getAllByName(String nom) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<Enfant> Enfants=FXCollections.observableArrayList();
   String requete = "select * from enfants where nom_enfant=?";
        //// "select * from user where username like '"+search+"
        
        System.out.println(requete);
        
        PreparedStatement preparedStatement;

        try {
          
             preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, nom);
           result = preparedStatement.executeQuery();
            while (result.next()) {

            Enfant p=new Enfant(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),result.getString(5),result.getInt(6));
            Enfants.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Enfants;
    }

    @Override
    public  List<Enfant> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     List<Enfant> Enfants=new ArrayList<>();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from enfants e join users u on e.id_parent= u.id_user where type='parent'");
    } catch (SQLException ex) {
        Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            //Enfant p=new Enfant(result.getInt(2),result.getString(3),result.getString(4),result.getInt(5));
            Enfant p=new Enfant(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),result.getString(5),result.getInt(6));
            Enfants.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Enfants;
    }

    @Override
    public Enfant search(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Enfant p=null;
        try {
       
        result=st.executeQuery("select * from enfants where id_enfant="+id);
          if(result.next())
         p = new Enfant(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),result.getString(5),result.getInt(6));
    } catch (SQLException ex) {
        Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }
    public Enfant searchEnfant(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
       Enfant p=null;
        try {
       
        result=st.executeQuery("select * from enfants where id_parent="+id);
          while(result.next())
          {  p=new Enfant(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),result.getString(5),result.getInt(6));
          } 
        } catch (SQLException ex) {
        Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
       return  p;
    }

    @Override
    public boolean delete(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Enfant p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from enfants where id_enfant="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Enfant t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Enfant p1=search(t.getId_enfant());
        System.out.println(p1);
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update enfants set nom_enfant='"+t.getNom()+"', prenom='"+t.getPrenom()+"', age='"+t.getAge()+"' where id_enfant="+t.getId_enfant());
        } catch (SQLException ex) {
            Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

    @Override
    public Map<String, Enfant> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enfant getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public  ObservableList<Enfant> getListeEnfant(String nom) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     ObservableList<Enfant> garderies=FXCollections.observableArrayList();
        System.out.println(nom);
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from enfants g join garderies e on g.id_garderie=e.id_garderie where e.nom like '%"+nom+"'");
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        
    try {
        while(result.next()){
            Enfant p=new Enfant(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),result.getString(5),result.getInt(6));
            
            System.out.println(p.toString());
            garderies.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
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
}
