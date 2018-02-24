/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;


import java.util.List;
import allforkids.entite.Evenement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import allforkids.technique.util.DataSource;
import java.util.Map;

/**
 *
 * @author hammamet
 */
public class EvenementService implements IAllForKids<Evenement>{
     Connection connexion;
    Statement st;
    ResultSet result;
    static EvenementService instance;
     public static EvenementService getInstance()
    {
        if(instance==null)
        {
    instance = new EvenementService();}
          return instance;
    }
      private EvenementService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public void insert(Evenement e) {
        String req="insert into evenements(nom,date,lieu,heure,duree,prix_ticket)values('"+e.getNom()+"','"+e.getDate()+"','"+e.getLieu()+"','"+e.getHeure()+"','"+e.getDuree()+"','"+e.getPrix_ticket()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Evenement> getAll() {
       List<Evenement> Evenements=new ArrayList<>();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from evenements");
    } catch (SQLException ex) {
        Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            Evenement e=new Evenement(result.getString(2),result.getDate(3),result.getString(4),result.getInt(5),result.getInt(6),result.getFloat(7));
            Evenements.add(e);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Evenements;
    }

    @Override
    public Evenement search(int id) {
        Evenement e=null;
        try {
       
        result=st.executeQuery("select * from evenements where id_evenement="+id);
          if(result.next())
         e = new Evenement(result.getString(2),result.getDate(3),result.getString(4),result.getInt(5),result.getInt(6),result.getFloat(7));
    } catch (SQLException ex) {
        Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return e; 
    }

    @Override
    public boolean delete(int id) {
        Evenement e=search(id);
   if(e!=null)
   {
       try {
           st.executeUpdate("delete from tickets where id_evenement="+id);
           st.executeUpdate("delete from evenements where id_evenement="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Evenement e) {
 Evenement ev=search(e.getId_evenement());
   if(ev!=null)
   {
        try {
            st.executeUpdate("Update evenements set  nom='"+e.getNom()+"',date='"+e.getDate()+"', lieu='"
                    +e.getLieu()+"', heure='"+e.getHeure()+"', duree='"+e.getDuree()+"', prix_ticket='"+e.getPrix_ticket()+"' where id_evenement="+e.getId_evenement());
        } catch (SQLException ex) {
            Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    
    }

    @Override
    public Map<String, Evenement> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Evenement getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
