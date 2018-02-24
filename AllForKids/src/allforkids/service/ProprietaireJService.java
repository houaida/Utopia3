/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.ProprietaireG;
import allforkids.entite.ProprietaireJ;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MacBook
 */
public class ProprietaireJService implements IAllForKids<ProprietaireJ>{
    
Connection connexion;
     public static ProprietaireJ LoggedUser;
Statement st;
ResultSet result;
static ProprietaireJService instance;
 public static ProprietaireJService getInstance()
    {
    if(instance==null)
    {
    instance = new ProprietaireJService();}
    return instance;
    
    }
public ProprietaireJService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(ProprietaireJService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @Override
    public void insert(ProprietaireJ t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   String req="insert into users(cin,nom,prenom,pseudo,mdp,email,adresse,montant,nom_club,num_tel,type,image)values('0','','','"+t.getPseudo()+"','"+t.getMdp()+"','"+t.getEmail()+"','','0','','0','proprietairej','"+t.getImage()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireJService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ProprietaireJ findbyMail(String s) {
        ProprietaireJ user = null;
        String req = "select * from users where email =? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connexion.prepareStatement(req);
            preparedStatement.setString(1, s);
             result = preparedStatement.executeQuery();
            while (result.next()) {
                user = new ProprietaireJ(result.getInt(1),result.getString(5),result.getString(6),result.getString(7),result.getString(12),result.getString(13));
                break;
            }
        } catch (SQLException ex) {
            System.out.println("mail not found ");
        }
        return user;
    }

    @Override
    public   ObservableList<ProprietaireJ> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     ObservableList<ProprietaireJ> ProprietaireJs=FXCollections.observableArrayList();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from users where type='proprietairej'");
    } catch (SQLException ex) {
        Logger.getLogger(ProprietaireJService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
           ProprietaireJ p=new ProprietaireJ(result.getInt(1),result.getString(5),result.getString(6),result.getString(7),result.getString(12));
            ProprietaireJs.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProprietaireGService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  ProprietaireJs;
    }

    @Override
    public ProprietaireJ search(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    ProprietaireJ p=null;
        try {
       
        result=st.executeQuery("select * from users where id_user="+id);
          if(result.next())
         p = new ProprietaireJ(result.getString(5),result.getString(6),result.getString(7),result.getString(12));
    } catch (SQLException ex) {
        Logger.getLogger(ProprietaireJService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   ProprietaireJ p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from users where id_user="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(ProprietaireJService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(ProprietaireJ t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   ProprietaireJ p1=search(t.getId_user());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update users set  pseudo='"+t.getPseudo()+"', mdp='"+t.getMdp()+"', email='"+t.getEmail()+"' where id_user="+t.getId_user());
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireJService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    } 
  
    public ProprietaireJ findbyLogin(String s) {
        ProprietaireJ user = null;
        String req = "select * from users where pseudo =? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connexion.prepareStatement(req);
            preparedStatement.setString(1, s);
             result = preparedStatement.executeQuery();
            while (result.next()) {
                user = new ProprietaireJ(result.getString(5),result.getString(6),result.getString(7),result.getString(12));
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
public  ProprietaireJ Login(String pseudo) throws SQLException {
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

                LoggedUser = new ProprietaireJ();
                LoggedUser.setId_user(result.getInt("id_user"));
               
                LoggedUser.setPseudo(result.getString("pseudo"));
                LoggedUser.setMdp(result.getString("mdp"));
                LoggedUser.setEmail(result.getString("email"));
                LoggedUser.setType(result.getString("type"));
                

 }
return LoggedUser;
}

    
    @Override
    public Map<String, ProprietaireJ> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProprietaireJ getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public  ObservableList<ProprietaireJ> getAllByName(String nom) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<ProprietaireJ> ProprietaireJs=FXCollections.observableArrayList();
   String requete = "select * from users where type='proprietairej' and nom=?";
        //// "select * from user where username like '"+search+"
        
        System.out.println(requete);
        
        PreparedStatement preparedStatement;

        try {
          
             preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, nom);
           result = preparedStatement.executeQuery();
            while (result.next()) {

            ProprietaireJ p=new ProprietaireJ(result.getInt(1),result.getString(5),result.getString(6),result.getString(7),result.getString(13));
            ProprietaireJs.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProprietaireJService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ProprietaireJs;
    }
}

