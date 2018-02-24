/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Garderie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import allforkids.entite.Offre;
import allforkids.technique.util.DataSource;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author user
 */
public class OffreService implements IAllForKids<Offre>{
Connection cnx;
Statement st;
ResultSet rs;
static OffreService instance;
private OffreService(){
 cnx=DataSource.getInstance().getConnexion();
    try {
        st=cnx.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    } 
}
public static OffreService getInstance()
    {
        if(instance==null)
        { instance = new OffreService();}
        return instance;
    }

    @Override
    public void insert(Offre p) {
        		
String req = null;
    try {
        req = "insert into offres_babysitter(id_babysitter,description,titre,date_debut,date_fin)values('"+p.getId_babysitter()+"','"+p.getDescription()+"','"+p.getTitre()+"','"+p.convert(p.getDate_debut())+"','"+p.convert(p.getDate_fin())+"')";
    } catch (ParseException ex) {
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    }
     try {
            st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }

    @Override
    public ObservableList<Offre> getAll() {
              ObservableList<Offre> Offres=FXCollections.observableArrayList();

    
        
    try {
        rs=st.executeQuery("SELECT * FROM `offres_babysitter` d join users u on d.id_babysitter=u.id_user where type='babysitter'");
    } catch (SQLException ex) { 
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
      
    try {
        while(rs.next()){
           Offre p;
            p = new Offre(rs.getInt("id_offre"),rs.getInt("id_babysitter"),rs.getString("description"),rs.getString("titre"),rs.getString("date_debut"),rs.getString("date_fin"));
            Offres.add(p);
        }
    } catch (SQLException ex) { 
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return Offres;
    }

    @Override
    public Offre search(int n) {
Offre p=null;
        try {
       
        rs=st.executeQuery("select * from offres_babysitter where id_offre="+n);
          if(rs.next())
            p = new Offre(rs.getInt("id_babysitter"),rs.getString("Description"),rs.getString("titre"),rs.getString("date_debut"),rs.getString("date_fin"));

    } catch (SQLException ex) { 
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
     Offre p1=search(id);
        // System.out.println(p1);
         
   if(p1!=null)
   {
       try {
           st.executeUpdate("delete from offres_babysitter where id_offre="+id);
            return true;
       } catch (SQLException ex) {      
             Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
         }      
  
   }return false;
    }

    @Override
    public boolean update(Offre p) {
Offre p1=search(p.getId_offre());
   if(p1!=null)
   {
        try {
            		

            st.executeUpdate("Update offres_babysitter set description='"+p.getDescription()+"',titre='"+p.getTitre()+"',date_debut='"+p.getDate_debut()+"',date_fin='"+p.getDate_fin()+"'where id_offre="+p.getId_offre());
       	

        } catch (SQLException ex) { 
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    }
       return true ;
   }
   return false;
    }  

    @Override
    public Map<String, Offre> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public ObservableList<Offre> getbyPseudo1(String pseudo) {
    ObservableList<Offre> liste = FXCollections.observableArrayList();
   
    try{
rs = st.executeQuery("select * from offres_babysitter where titre like '%"+pseudo+"%'") ;
      while (rs.next()) { 
            Offre p = new Offre(rs.getInt("id_babysitter"),rs.getString("Description"),rs.getString("titre"),rs.getString("date_debut"),rs.getString("date_fin"));
                liste.add(p); 
    } } catch (SQLException ex) { 
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return liste ; 
    }

    @Override
    public Offre getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    } 


     
        
    
    

   

    
    

 

   
