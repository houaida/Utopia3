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
        String req="insert into membres(nom,prenom,date_inscription,age,num_parent,email_parent)values('"+m.getNom()+"','"+m.getPrenom()+"','"+m.getDate_inscription()+"','"+m.getAge()+"','"+m.getNum_parent()+"','"+m.getEmail_parent()+"')";
    System.out.println(req);
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
            Membre m=new Membre(result.getString(2),result.getString(3),result.getDate(4),result.getInt(5),result.getInt(6),result.getString(7));
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
         m = new Membre(result.getString(2),result.getString(3),result.getDate(4),result.getInt(5),result.getInt(6),result.getString(7));
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
            st.executeUpdate("Update membres set  nom='"+m.getNom()+"',prenom='"+m.getPrenom()+"', date_inscription='"
                    +m.getDate_inscription()+"', age='"+m.getAge()+"', num_parent='"+m.getNum_parent()+"', email_parent='"+m.getEmail_parent()+"' where id="+m.getId());
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
