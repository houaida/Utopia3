/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Offre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import allforkids.entite.Reclamation;
import allforkids.technique.util.DataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class ReclamationService implements IAllForKids<Reclamation>{
Connection cnx;
Statement st;
ResultSet rs;
static ReclamationService instance;
private ReclamationService(){
 cnx=DataSource.getInstance().getConnexion();
    try {
        st=cnx.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
    } 
}
public static ReclamationService getInstance()
    {
        if(instance==null)
        {instance = new ReclamationService();}
        return instance;
    }


  
    public void insert1(Reclamation p,int v) {
        			
    String req="insert into reclamations(id_parent,id_babysitter,description,heure_travail,heure_pointe)values('"+v+"','"+p.getId_babysitter()+"','"+p.getDescription()+"','"+p.getHeure_travail()+"','"+p.getHeure_pointe()+"')";
    
    System.out.println(req); 
    try {
            st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }
 public ObservableList<Reclamation> getAll1(int id) {
         ObservableList<Reclamation> Reclamations = FXCollections.observableArrayList();
   
    try {
        rs=st.executeQuery("select * from reclamations where id_parent="+id);
    } catch (SQLException ex) { 
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
      
    try {
        while(rs.next()){
          Reclamation p;
          p = new Reclamation(rs.getInt("id_parent"),rs.getInt("id_babysitter"),rs.getString("Description")
                  ,rs.getTimestamp("date_envoi"),rs.getTime("heure_travail"),rs.getTime("heure_pointe"),rs.getInt("etat"));
            Reclamations.add(p);
        }
    } catch (SQLException ex) { 
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return Reclamations;
    }
    @Override
    public ObservableList<Reclamation> getAll() {
         ObservableList<Reclamation> Reclamations = FXCollections.observableArrayList();
   
    try {
        rs=st.executeQuery("select * from reclamations");
    } catch (SQLException ex) { 
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
      
    try {
        while(rs.next()){
          Reclamation p;
          p = new Reclamation(rs.getInt("id_parent"),rs.getInt("id_babysitter"),rs.getString("Description")
                  ,rs.getTimestamp("date_envoi"),rs.getTime("heure_travail"),rs.getTime("heure_pointe"),rs.getInt("etat"));
            Reclamations.add(p);
        }
    } catch (SQLException ex) { 
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return Reclamations;
    }

    

    @Override
    public Reclamation search(int n) {
    
    Reclamation p=null;
      

    try {
                   String req = "select * from reclamations where id_parent="+n; 

        rs=st.executeQuery(req);
        if(rs.next())
        p = new Reclamation(rs.getInt("id_reclamation"),rs.getInt("id_parent"),rs.getInt("id_babysitter"),rs.getString("Description")
                  ,rs.getTimestamp("date_envoi"),rs.getTime("heure_travail"),rs.getTime("heure_pointe"),rs.getInt("etat"),rs.getInt("diff_heure"),rs.getInt("diff_minute"));
    } catch (SQLException ex) {
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
    }
          
    
        return p; 
}
    public Reclamation search3(int n) {
    
    Reclamation p=null;
      
          

    try {
         String req = "select * from reclamations where id_reclamation="+n; 
        rs=st.executeQuery(req);
        if(rs.next())
        p = new Reclamation(rs.getInt(1),rs.getInt("id_parent"),rs.getInt("id_babysitter"),rs.getString("Description")
                  ,rs.getTimestamp("date_envoi"),rs.getTime("heure_travail"),rs.getTime("heure_pointe"),rs.getInt("etat"),rs.getInt("diff_heure"),rs.getInt("diff_minute"));
    } catch (SQLException ex) {
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
    }
          
    
        return p; 
}
      public Reclamation search2(int n) {
    
    Reclamation p=null;
      
          

    try {
         String req = "select * from reclamations where id_babysitter="+n; 
        rs=st.executeQuery(req);
        if(rs.next())
        p = new Reclamation(rs.getInt(1),rs.getInt("id_parent"),rs.getInt("id_babysitter"),rs.getString("Description")
                  ,rs.getTimestamp("date_envoi"),rs.getTime("heure_travail"),rs.getTime("heure_pointe"),rs.getInt("etat"),rs.getInt("diff_heure"),rs.getInt("diff_minute"));
    } catch (SQLException ex) {
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
    }
          
    
        return p; 
}

    @Override
    public boolean delete(int id) {
Reclamation p1=search3(id);
        // System.out.println(p1);
         
   if(p1!=null)
   {
       try {
           st.executeUpdate("delete from reclamations where id_reclamation="+id);
            return true;
       } catch (SQLException ex) {      
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
    }      
  
   }return false;
    }
public boolean delete1(int id) {
Reclamation p1=search(id);
        // System.out.println(p1);
         
   if(p1!=null)
   {
       try {
           st.executeUpdate("delete from reclamations where id_parent="+id);
            return true;
       } catch (SQLException ex) {      
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
    }      
  
   }return false;
    }

    @Override
    public boolean update(Reclamation p) {
    Reclamation p1=search3(p.getId_reclamation());
   if(p1!=null)
   {
        try {
        st.executeUpdate("Update reclamations set id_parent='"+p.getId_parent()+"',id_babysitter='"+p.getId_babysitter()+"',description='"+p.getDescription()+"'where id_reclamation="+p.getId_reclamation());
       	

        } catch (SQLException ex) { 
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }  

    public boolean update2(int id,int alerte) {
    Reclamation p1=search3(id);
   
   if(p1!=null)
   {
        try {
        st.executeUpdate("Update reclamations set etat='1',alerte='"+alerte+"'where id_reclamation="+id);
       	

        } catch (SQLException ex) { 
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }  
    public boolean update1(int v) {
    Reclamation p1=search(v);
   if(p1!=null)
   {
        try {
        st.executeUpdate("Update reclamations set diff_heure=hour(heure_pointe)-hour(heure_travail),diff_minute=minute(heure_pointe)-minute(heure_travail) where id_parent="+v);
       	

        } catch (SQLException ex) { 
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }  
    @Override
    public Map<String, Reclamation> getAllMap() {
    Map<String,Reclamation> reclamations=new HashMap<>();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        rs=st.executeQuery("select nom,id_parent,id_babysitter,description,date_envoi from reclamations r join users u on r.id_parent=u.id_user where type='parent'");
    } catch (SQLException ex) {
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
    try {
        while(rs.next()){
              //Reclamation p = new Reclamation(rs.getInt("id_parent"),rs.getInt("id_babysitter"),rs.getString("Description")
                  //  ,rs.getDate("date_envoi"));
         //   reclamations.put(rs.getString(1),p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  reclamations;
    }

    @Override
    public Reclamation getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Reclamation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    }
    

