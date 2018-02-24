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
import java.util.logging.Level;
import java.util.logging.Logger;

import allforkids.entite.Pub;
import allforkids.technique.util.DataSource;
import java.util.Map;

/**
 *
 * @author hammamet
 */
public class PubService implements IAllForKids<Pub>{
     Connection connexion;
    Statement st;
    ResultSet result;
    static PubService instance;
    public static PubService getInstance()
    {
        if(instance==null)
        {
    instance = new PubService();}
          return instance;
    }
    private PubService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public void insert(Pub p) {
       
        String req="insert into pubs(nom_societe,nom_pub,date_debut,date_fin,duree,etat)values('"+p.getNom_societe()+"','"+p.getNom_pub()+"','"+p.getDate_debut()+"','"+p.getDate_fin()+"','"+p.getDuree()+"','"+p.getEtat()+"')";
            System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
        }
           
         
    }

    @Override
    public List<Pub> getAll() {
        List<Pub> Pubs=new ArrayList<>();
        
    try {
        result=st.executeQuery("select * from pubs");
    } catch (SQLException ex) {
        Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            Pub p=new Pub(result.getString(2),result.getString(3),result.getDate(4),result.getDate(5),result.getInt(6),result.getString(7));
            Pubs.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Pubs;
    }

    @Override
    public Pub search(int id) {
        Pub p=null;
        try {
       
        result=st.executeQuery("select * from pubs where id_pub="+id);
          if(result.next())
         p = new Pub(result.getString(2),result.getString(3),result.getDate(4),result.getDate(5),result.getInt(6),result.getString(7));
    } catch (SQLException ex) {
        Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
        Pub p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from pubs where id_pub="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Pub p) {
   Pub pu=search(p.getId_pub());
   if(pu!=null)
   {
        try {
            st.executeUpdate("Update pubs set  nom_societe='"+p.getNom_societe()+"',nom_pub='"+p.getNom_pub()+"', date_debut='"
                    +p.getDate_debut()+"', date_fin='"+p.getDate_fin()+"', duree='"+p.getDuree()+"', etat='"+p.getEtat()+"' where id_pub="+p.getId_pub());
        } catch (SQLException ex) {
            Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }    

    @Override
    public Map<String, Pub> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pub getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
