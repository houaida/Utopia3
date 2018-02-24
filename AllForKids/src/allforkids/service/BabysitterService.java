/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Babysitter;
import allforkids.entite.Demande;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author user
 */
public class BabysitterService implements IAllForKids<Babysitter>{
Connection cnx;
Statement st;
ResultSet rs;
static BabysitterService instance;

public BabysitterService(){
 cnx=DataSource.getInstance().getConnexion();
    try {
        st=cnx.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public static BabysitterService getInstance()
    {
        if(instance==null){
            instance = new BabysitterService();}
        return instance;
    }
public ObservableList<Babysitter> getAll2() {
ObservableList<Babysitter> Babysitters=FXCollections.observableArrayList();
        
    try {
        rs=st.executeQuery("select * from users where type='babysitterPersonnel'");
    } catch (SQLException ex) { 
        Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);}
  
      
    try {
        while(rs.next()){
            Babysitter p;
        
            p = new Babysitter(rs.getInt("id_user"),rs.getInt("cin"),rs.getString("nom"),rs.getString("prenom"),
                    rs.getString("pseudo"),rs.getString("mdp"),rs.getString("email"),rs.getString("adresse"),rs.getString("num_tel"),rs.getString("type"),rs.getString("date_naissance"),rs.getString("image"));
             Babysitters.add(p);
        }
    } catch (SQLException ex) { 
        Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Babysitters;
    }

    @Override
    public void insert(Babysitter p) {
    String req=null;
    try {  
req = "insert into users(cin,nom,prenom,pseudo,mdp,email,adresse,montant,nom_club,num_tel,type,date_naissance,image)values('"+p.getCin()+"','"+p.getNom()+"','"+p.getPrenom()+"','"+p.getPseudo()+"','"+p.getMdp()+"','"+p.getEmail()+"','"+p.getAdresse()+"','0',' ','"+p.getNum_tel()+"','babysitter','"+p.convert(p.getDate_naissance())+"','"+p.getImage()+"')";
    } catch (ParseException ex) {
        Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
    }
     try {
            st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
    }}

    @Override
   public ObservableList<Babysitter> getAll() {
ObservableList<Babysitter> Babysitters=FXCollections.observableArrayList();
        
    try {
        rs=st.executeQuery("select * from users where type='babysitter'");
    } catch (SQLException ex) { 
        Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
      
    try {
        while(rs.next()){
            Babysitter p;
        
            p = new Babysitter(rs.getInt("id_user"),rs.getInt("cin"),rs.getString("nom"),rs.getString("prenom"),
                    rs.getString("pseudo"),rs.getString("mdp"),rs.getString("email"),rs.getString("adresse"),rs.getString("num_tel"),rs.getString("type"),rs.getString("date_naissance"),rs.getString("image"));
             Babysitters.add(p);
        }
    } catch (SQLException ex) { 
        Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Babysitters;
    }

    
    @Override
    public Babysitter search(int n) {
Babysitter p=null;
        try {
       
        rs=st.executeQuery("select * from users where id_user="+n);
          if(rs.next())
         p = new Babysitter(rs.getInt("cin"),rs.getString("nom"),rs.getString("prenom"),
                    rs.getString("pseudo"),rs.getString("mdp"),rs.getString("email"),rs.getString("adresse"),rs.getString("num_tel"),rs.getString("date_naissance"),rs.getString("image"));
    } catch (SQLException ex) {  
        Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
       
         Babysitter p1=search(id);
         //System.out.println(p1);
         
   if(p1!=null)
   {
       try {
           st.executeUpdate("delete from users where id_user="+id);
            return true;
       }     catch (SQLException ex) {
                 Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
             }
  
   }return false;
    }

    @Override
    public boolean update(Babysitter t) {
     Babysitter p1=search(t.getId_user());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update users set cin='"+t.getCin()+"',nom='"+t.getNom()+"', prenom='"+t.getPrenom()+"', pseudo='"+t.getPseudo()+"', mdp='"+t.getMdp()+"', email='"+t.getEmail()+"', adresse='"+t.getAdresse()+"', num_tel='"+t.getNum_tel()+"', date_naissance='"+t.getDate_naissance()+"', image='"+t.getImage()+"' where id_user="+t.getId_user());
        } catch (SQLException ex) { 
             Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
         }
       return true ;
   }
   return false;
    }
    
    public boolean update1(int id) {
     Babysitter p1=search(id);
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update users set type='babysitterPersonnel' where id_user="+id);
        } catch (SQLException ex) { 
             Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
         }
       return true ;
   }
   return false;
    }

    @Override
    public Map<String, Babysitter> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


        public ObservableList<Babysitter> getbyPseudo1(String pseudo) {

   ObservableList<Babysitter> liste = FXCollections.observableArrayList();
   
    try{
rs = st.executeQuery("select * from users where type='babysitter' and nom like '%"+pseudo+"%'") ;
      while (rs.next()) { 
           Babysitter p = new Babysitter(rs.getInt("id_user"),rs.getInt("cin"),rs.getString("nom"),rs.getString("prenom"),
                    rs.getString("pseudo"),rs.getString("mdp"),rs.getString("email"),rs.getString("adresse"),rs.getString("num_tel"),rs.getString("type"),rs.getString("date_naissance"),rs.getString("image"));                liste.add(p); 
    } } catch (SQLException ex) { 
        Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return liste ; 
    }

    @Override
    public Babysitter getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }

    

    
    
    

