/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Admin;
import allforkids.entite.User;
import allforkids.technique.util.DataSource;
import allforkids.util.BCrypt;
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



/**
 *
 * @author MacBook
 */
public class AdminService implements IAllForKids<Admin> {
   Connection connexion;
     public static Admin LoggedUser;
Statement st;
ResultSet result;
static AdminService instance;
 public static AdminService getInstance()
    {
    if(instance==null)
    {
    instance = new AdminService();}
    return instance;
    
    }
public AdminService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @Override
    public void insert(Admin t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   String req="insert into users(cin,nom,prenom,pseudo,mdp,email,adresse,montant,nom_club,num_tel,type,image)values('0','','','"+t.getPseudo()+"','"+t.getMdp()+"','"+t.getEmail()+"','','0','','0','admin','"+t.getImage()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public  List<Admin> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     List<Admin> Admins=new ArrayList<>();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from users");
    } catch (SQLException ex) {
        Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
           Admin p=new Admin(result.getInt(1),result.getString(5),result.getString(6),result.getString(7),result.getString(12),result.getString(14));
            Admins.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Admins;
    }

    @Override
    public Admin search(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Admin p=null;
        try {
       
        result=st.executeQuery("select * from users where id_user="+id);
          if(result.next())
         p = new Admin(result.getString(5),result.getString(6),result.getString(7),result.getString(12));
    } catch (SQLException ex) {
        Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   Admin p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from users where id_user="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Admin t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Admin p1=search(t.getId_user());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update users set  pseudo='"+t.getPseudo()+"', mdp='"+t.getMdp()+"', email='"+t.getEmail()+"' where id_user="+t.getId_user());
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    } 
  
    public Admin findbyLogin(String s) {
        Admin user = null;
        String req = "select * from users where pseudo =? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connexion.prepareStatement(req);
            preparedStatement.setString(1, s);
             result = preparedStatement.executeQuery();
            while (result.next()) {
                user = new Admin(result.getString(5),result.getString(6),result.getString(7),result.getString(12));
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
public  Admin Login(String pseudo) throws SQLException {
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

                LoggedUser = new Admin();
                LoggedUser.setId_user(result.getInt("id_user"));
               
                LoggedUser.setPseudo(result.getString("pseudo"));
                LoggedUser.setMdp(result.getString("mdp"));
                LoggedUser.setEmail(result.getString("email"));
                LoggedUser.setType(result.getString("type"));
                LoggedUser.setImage(result.getString("image"));
                

 }
return LoggedUser;
}

    
    @Override
    public Map<String, Admin> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admin getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
