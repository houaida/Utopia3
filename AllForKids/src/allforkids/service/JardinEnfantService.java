/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Garderie;
import allforkids.entite.JardinEnfant;
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
public class JardinEnfantService implements IAllForKids<JardinEnfant>{
     Connection connexion;
Statement st;
ResultSet result;
static JardinEnfantService instance;
 public static JardinEnfantService getInstance()
    {
    if(instance==null)
    {
    instance = new JardinEnfantService();}
    return instance;
    
    }
public JardinEnfantService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @Override
    public void insert(JardinEnfant t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   String req="insert into jardinEnfants(id_user,nom,adresse,num_tel,description,image)values('"+t.getId_user()+"','"+t.getNom()+"','"+t.getAdresse()+"','"+t.getNum_tel()+"','"+t.getDescription()+"','"+t.getImage()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public  ObservableList<JardinEnfant> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<JardinEnfant> JardinEnfants=FXCollections.observableArrayList();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from jardinEnfants");
    } catch (SQLException ex) {
        Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            JardinEnfant p=new JardinEnfant(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6),result.getString(7));
            JardinEnfants.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  JardinEnfants;
    }
@Override
    public  Map<String,JardinEnfant> getAllMap() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Map<String,JardinEnfant> JardinEnfants=new HashMap<>();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select nom_enfant,nom,adresse,num_tel from jardinEnfants g join enfants e on g.id_enfant=e.id_enfant");
    } catch (SQLException ex) {
        Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            JardinEnfant p=new JardinEnfant(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6),result.getString(7));
            JardinEnfants.put(result.getString(1),p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  JardinEnfants;
    }
public  ObservableList<JardinEnfant> getAllByName(String nom) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<JardinEnfant> JardinEnfants=FXCollections.observableArrayList();
   String requete = "select * from jardinEnfants where nom=?";
        //// "select * from user where username like '"+search+"
        
        System.out.println(requete);
        
        PreparedStatement preparedStatement;

        try {
          
             preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, nom);
           result = preparedStatement.executeQuery();
            while (result.next()) {

            JardinEnfant p=new JardinEnfant(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6),result.getString(7));
           JardinEnfants.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return JardinEnfants;
    }
    @Override
    public JardinEnfant search(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    JardinEnfant p=null;
        try {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        
        result=st.executeQuery("select * from jardinEnfants where id_jardinEnfant="+id);
          if(result.next())
         p = new JardinEnfant(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6),result.getString(7));
    } catch (SQLException ex) {
        Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }
    public JardinEnfant searchGard(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    JardinEnfant p=null;
        try {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        
        result=st.executeQuery("select * from jardinEnfants  where id_user="+id);
          if(result.next())
         p = new JardinEnfant(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6),result.getString(7));
    } catch (SQLException ex) {
        Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   JardinEnfant p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from jardinEnfants where id_jardinEnfant="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }
   return false;
    }

    @Override
    public boolean update(JardinEnfant t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    JardinEnfant p1=search(t.getId_jardinEnfant());
     //System.out.println("hayaaa1");
        System.out.println(t.getId_jardinEnfant());
   if(p1!=null)
   {
      // System.out.println("hayaaa2");
        try {
            st.executeUpdate("Update jardinEnfants set id_jardinEnfant='"+t.getId_jardinEnfant()+"',nom='"+t.getNom()+"', adresse='"+t.getAdresse()+"', num_tel='"+t.getNum_tel()+"', description='"+t.getDescription()+"' where id_jardinEnfant="+t.getId_jardinEnfant());
        } catch (SQLException ex) {
            Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

    @Override
    public JardinEnfant getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
