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
import allforkids.entite.Club;
import allforkids.technique.util.DataSource;
import java.util.Map;


/**
 *
 * @author hammamet
 */

public class ClubService implements IAllForKids<Club>{
    Connection connexion;
    Statement st;
    ResultSet result;
    static ClubService instance;
    public static ClubService getInstance()
    {
        if(instance==null)
        {
    instance = new ClubService();}
          return instance;
    }
    private ClubService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
     @Override
    public void insert(Club c) {
       
    String req="insert into clubs(nom,categorie,lieu,age_min,age_max,nombre_enseignant,nombre_inscrits)values('"+c.getNom()+"','"+c.getCategorie()+"','"+c.getLieu()+"','"+c.getAge_min()+"','"+c.getAge_max()+"','"+c.getNombre_enseignant()+"','"+c.getNombre_inscrits()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Club> getAll() {
         List<Club> Clubs=new ArrayList<>();
        
    try {
        result=st.executeQuery("select * from clubs");
    } catch (SQLException ex) {
        Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            Club c=new Club(result.getString(2),result.getString(3),result.getString(4),result.getInt(5),result.getInt(6),result.getInt(7),result.getInt(8));
            Clubs.add(c);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Clubs;
    }

    @Override
    public Club search(int id) {
        
    Club c=null;
        try {
       
        result=st.executeQuery("select * from clubs where id="+id);
          if(result.next())
         c = new Club(result.getString(2),result.getString(3),result.getString(4),result.getInt(5),result.getInt(6),result.getInt(7),result.getInt(8));
    } catch (SQLException ex) {
        Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return c; 
    }

   
@Override
    public boolean delete(int id) {
    Club c=search(id);
   if(c!=null)
   {
       try {
           st.executeUpdate("delete from clubs where id="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Club c) {
         Club cl=search(c.getId());
   if(cl!=null)
   {
        try {
            st.executeUpdate("Update clubs set  nom='"+c.getNom()+"',categorie='"+c.getCategorie()+"', lieu='"
                    +c.getLieu()+"', age_min='"+c.getAge_min()+"', age_max='"+c.getAge_max()+"', nombre_enseignant='"+c.getNombre_enseignant()+"', nombre_inscrits='"+c.getNombre_inscrits()+"' where id="+c.getId());
        } catch (SQLException ex) {
            Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

    @Override
    public Map<String, Club> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Club getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    }
    
    

