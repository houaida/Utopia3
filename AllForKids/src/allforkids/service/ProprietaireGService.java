/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Admin;
import allforkids.entite.Enfant;
import allforkids.entite.ProprietaireG;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class ProprietaireGService implements IAllForKids<ProprietaireG>{
    
Connection connexion;
     public static ProprietaireG LoggedUser;
Statement st;
ResultSet result;
static ProprietaireGService instance;
 public static ProprietaireGService getInstance()
    {
    if(instance==null)
    {
    instance = new ProprietaireGService();}
    return instance;
    
    }
public ProprietaireGService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @Override
    public void insert(ProprietaireG t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   String req="insert into users(cin,nom,prenom,pseudo,mdp,email,adresse,montant,nom_club,num_tel,type,image)values('0','','','"+t.getPseudo()+"','"+t.getMdp()+"','"+t.getEmail()+"','','0','','0','proprietaireg','"+t.getImage()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireGService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ProprietaireG findbyMail(String s) {
        ProprietaireG user = null;
        String req = "select * from users where email =? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connexion.prepareStatement(req);
            preparedStatement.setString(1, s);
             result = preparedStatement.executeQuery();
            while (result.next()) {
                user = new ProprietaireG(result.getInt(1),result.getString(5),result.getString(6),result.getString(7),result.getString(12),result.getString(13));
                break;
            }
        } catch (SQLException ex) {
            System.out.println("mail not found ");
        }
        return user;
    }

    @Override
    public   ObservableList<ProprietaireG> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     ObservableList<ProprietaireG> ProprietaireGs=FXCollections.observableArrayList();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from users where type='proprietaireg'");
    } catch (SQLException ex) {
        Logger.getLogger(ProprietaireGService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
           ProprietaireG p=new ProprietaireG(result.getInt(1),result.getString(5),result.getString(6),result.getString(7),result.getString(12));
            ProprietaireGs.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProprietaireGService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  ProprietaireGs;
    }

    @Override
    public ProprietaireG search(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    ProprietaireG p=null;
        try {
       
        result=st.executeQuery("select * from users where id_user="+id);
          if(result.next())
         p = new ProprietaireG(result.getString(5),result.getString(6),result.getString(7),result.getString(12));
    } catch (SQLException ex) {
        Logger.getLogger(ProprietaireGService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   ProprietaireG p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from users where id_user="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(ProprietaireGService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(ProprietaireG t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   ProprietaireG p1=search(t.getId_user());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update users set  pseudo='"+t.getPseudo()+"', mdp='"+t.getMdp()+"', email='"+t.getEmail()+"' where id_user="+t.getId_user());
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireGService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    } 
  
    public ProprietaireG findbyLogin(String s) {
        ProprietaireG user = null;
        String req = "select * from users where pseudo =? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connexion.prepareStatement(req);
            preparedStatement.setString(1, s);
             result = preparedStatement.executeQuery();
            while (result.next()) {
                user = new ProprietaireG(result.getString(5),result.getString(6),result.getString(7),result.getString(12));
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
public  ProprietaireG Login(String pseudo) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     // ObservableList<Admin> Evaluations=FXCollections.observableArrayList();
   String requete = "select * from users where pseudo=?";
        //// "select * from user where username like '"+search+"
        
        System.out.println(requete);
        
        PreparedStatement preparedStatement;

          
             preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, pseudo);
           result = preparedStatement.executeQuery();
            
 if (result.next()) {

                LoggedUser = new ProprietaireG();
                LoggedUser.setId_user(result.getInt("id_user"));
               
                LoggedUser.setPseudo(result.getString("pseudo"));
                LoggedUser.setMdp(result.getString("mdp"));
                LoggedUser.setEmail(result.getString("email"));
                LoggedUser.setType(result.getString("type"));
                

 }
return LoggedUser;
}

    
    @Override
    public Map<String, ProprietaireG> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProprietaireG getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public  ObservableList<ProprietaireG> getAllByName(String nom) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<ProprietaireG> ProprietaireGs=FXCollections.observableArrayList();
   String requete = "select * from users where type='proprietaireg' and nom=?";
        //// "select * from user where username like '"+search+"
        
        System.out.println(requete);
        
        PreparedStatement preparedStatement;

        try {
          
             preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, nom);
           result = preparedStatement.executeQuery();
            while (result.next()) {

            ProprietaireG p=new ProprietaireG(result.getInt(1),result.getString(5),result.getString(6),result.getString(7),result.getString(13));
            ProprietaireGs.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProprietaireGService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ProprietaireGs;
    }
}

