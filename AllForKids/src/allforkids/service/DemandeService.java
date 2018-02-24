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

import allforkids.entite.Demande;
import allforkids.entite.Offre;

import allforkids.technique.util.DataSource;
import java.text.ParseException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class DemandeService implements IAllForKids<Demande>{
Connection cnx;
Statement st;
ResultSet rs;
static DemandeService instance;
private DemandeService(){
 cnx=DataSource.getInstance().getConnexion();
    try {
        st=cnx.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
    } 
}
public static DemandeService getInstance()
    {
        if(instance==null)
            instance = new DemandeService();
        return instance;
    }

    @Override
    public void insert(Demande p) {
        String req = null;

    try {
        req = "insert into demandes_parent(id_parent,description,titre,date_debut,date_fin)values('"+p.getId_parent()+"','"+p.getDescription()+"','"+p.getTitre()+"','"+p.convert(p.getDate_debut())+"','"+p.convert(p.getDate_fin())+"')";
    } catch (ParseException ex) {
        Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
    }
     try {
            st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }

    @Override
    public ObservableList<Demande> getAll() {
ObservableList<Demande> Demandes=FXCollections.observableArrayList();
        
    try {
        rs=st.executeQuery("SELECT * FROM `demandes_parent` d join users u on d.id_parent=u.id_user where type='parent'");
    } catch (SQLException ex) { 
        Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
      
    try {
        while(rs.next()){
            Demande p;
        
            p = new Demande(rs.getInt("id_demande"),rs.getInt("id_parent"),rs.getString("description"),rs.getString("titre"),rs.getString("date_debut"),rs.getString("date_fin"));
             Demandes.add(p);
        }
    } catch (SQLException ex) { 
        Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Demandes;
    }

    @Override
    public Demande search(int n) {
    Demande p=null;
        try {
       
        rs=st.executeQuery("select * from demandes_parent where id_demande="+n);
          if(rs.next())
            p = new Demande(rs.getInt("id_parent"),rs.getString("description"),rs.getString("titre"),rs.getString("date_debut"),rs.getString("date_fin"));

              } catch (SQLException ex) { 
        Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
     Demande p1=search(id);
        // System.out.println(p1);
         
   if(p1!=null)
   {
       try {
           st.executeUpdate("delete from demandes_parent where id_demande="+id);
            return true;
       } catch (SQLException ex) {     
             Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
         }     
  
   }return false;
    }

    @Override
    public boolean update(Demande p) {
        Demande p1=search(p.getId_demande());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update demandes_parent set id_parent='"+p.getId_parent()+"',description='"+p.getDescription()+"' where id_demande="+p.getId_demande());
       	

        }   catch (SQLException ex) { 
                Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
            }
       return true ;
   }
   return false;
    }

    @Override
    public Map<String, Demande> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public ObservableList<Demande> getbyPseudo1(String pseudo) {

   ObservableList<Demande> liste = FXCollections.observableArrayList();
   
    try{
rs = st.executeQuery("select * from demandes_parent where titre like '%"+pseudo+"%'") ;
      while (rs.next()) { 
            Demande p = new Demande(rs.getInt("id_parent"),rs.getString("Description"),rs.getString("titre"),rs.getString("date_debut"),rs.getString("date_fin"));
                liste.add(p); 
    } } catch (SQLException ex) { 
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return liste ; 
    }

    @Override
    public Demande getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }

    
    
    



   

