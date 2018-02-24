/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Garderie;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
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
public class GarderieService implements IAllForKids<Garderie> {

    Connection connexion;
Statement st;
ResultSet result;
static GarderieService instance;
 public static GarderieService getInstance()
    {
    if(instance==null)
    {
    instance = new GarderieService();}
    return instance;
    
    }
public GarderieService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @Override
    public void insert(Garderie t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   String req="insert into garderies(id_user,nom,adresse,num_tel,description,image)values('"+t.getId_user()+"','"+t.getNom()+"','"+t.getAdresse()+"','"+t.getNum_tel()+"','"+t.getDescription()+"','"+t.getImage()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public  ObservableList<Garderie> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<Garderie> garderies=FXCollections.observableArrayList();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from garderies");
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            Garderie p=new Garderie(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6),result.getString(7));
            garderies.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  garderies;
    }
@Override
    public  Map<String,Garderie> getAllMap() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Map<String,Garderie> garderies=new HashMap<>();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select nom_enfant,nom,adresse,num_tel from garderies g join enfants e on g.id_enfant=e.id_enfant");
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            Garderie p=new Garderie(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6),result.getString(7));
            garderies.put(result.getString(1),p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  garderies;
    }
public  ObservableList<Garderie> getAllByName(String nom) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<Garderie> Garderies=FXCollections.observableArrayList();
   String requete = "select * from garderies where nom=?";
        //// "select * from user where username like '"+search+"
        
        System.out.println(requete);
        
        PreparedStatement preparedStatement;

        try {
          
             preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, nom);
           result = preparedStatement.executeQuery();
            while (result.next()) {

            Garderie p=new Garderie(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6),result.getString(7));
            Garderies.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Garderies;
    }
    @Override
    public Garderie search(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Garderie p=null;
        try {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        
        result=st.executeQuery("select * from garderies where id_garderie="+id);
          if(result.next())
         p = new Garderie(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6),result.getString(7));
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }
    public Garderie searchGard(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Garderie p=null;
        try {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        
        result=st.executeQuery("select * from garderies  where id_user="+id);
          if(result.next())
         p = new Garderie(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6),result.getString(7));
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Garderie p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from garderies where id_garderie="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }
   return false;
    }

    @Override
    public boolean update(Garderie t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Garderie p1=search(t.getId_garderie());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update garderies set id_garderie='"+t.getId_garderie()+"',nom='"+t.getNom()+"', adresse='"+t.getAdresse()+"', num_tel='"+t.getNum_tel()+"', description='"+t.getDescription()+"' where id_garderie="+t.getId_garderie());
        } catch (SQLException ex) {
            Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

    @Override
    public Garderie getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}

