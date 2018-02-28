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

import allforkids.entite.Membre;
import allforkids.technique.util.DataSource;
import java.text.ParseException;
import java.util.Map;

/**
 *
 * @author hammamet
 */
public class MembreService implements IAllForKids<Membre>{
    Connection connexion;
    Statement st;
    ResultSet result;
    static MembreService instance;
    public static MembreService getInstance()
    {
        if(instance==null)
        {
    instance = new MembreService();}
          return instance;
    }
    private MembreService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public void insert(Membre m) {
        String req=null;
        try {
            req = "insert into membres(id_user,id_club,nom,prenom,num_parent,email_parent,date_naissance)values('"+m.getId_user()+"','"+m.getId_club()+"','"+m.getNom()+"','"+m.getPrenom()+"','"+m.getNum_parent()+"','"+m.getEmail_parent()+"','"+m.convert(m.getDate_naissance())+"')";
            System.out.println(req);
        } catch (ParseException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Membre> getAll() {
        List<Membre> Membres=new ArrayList<>();
        
    try {
        result=st.executeQuery("select * from membres");
    } catch (SQLException ex) {
        Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            Membre m=new Membre(result.getInt("id_user"),result.getInt("id_club"),result.getString("nom"),result.getString("prenom"),result.getInt("num_parent"),result.getString("email_parent"),result.getString("date_naissance"));
            Membres.add(m);
        }
    } catch (SQLException ex) {
        Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Membres;
    }

    @Override
    public Membre search(int id) {
        Membre m=null;
        try {
       
        result=st.executeQuery("select * from membres where id="+id);
          if(result.next())
         m = new Membre(result.getInt("id_user"),result.getInt("id_club"),result.getString("nom"),result.getString("prenom"),result.getInt("num_parent"),result.getString("email_parent"),result.getString("date_naissance"));
    } catch (SQLException ex) {
        Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return m; 
        
    }

    @Override
    public boolean delete(int id) {
        Membre m=search(id);
   if(m!=null)
   {
       try {
           st.executeUpdate("delete from membres where id="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Membre m) {
       Membre me=search(m.getId());
   if(me!=null)
   {
        try {
            st.executeUpdate("Update membres set  nom='"+m.getNom()+"',prenom='"+m.getPrenom()+"', num_parent='"+m.getNum_parent()+"', email_parent='"+m.getEmail_parent()+"', date_naissance='"+m.getDate_naissance()+"' where id="+m.getId());
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

    @Override
    public Map<String, Membre> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Membre getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
