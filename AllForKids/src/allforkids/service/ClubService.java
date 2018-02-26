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
import java.sql.PreparedStatement;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;


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
    
    instance = new ClubService();
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
       
       String req="insert into clubs(cin_proprietaire,email,nom_club,categorie,description,nombre_personnels,lieu,image)values('"+c.getCin_proprietaire()+"','"+c.getEmail()+"','"+c.getNom_club()+"','"+c.getCategorie()+"','"+c.getDescription()+"','"+c.getNombre_personnel()+"','"+c.getLieu()+"','"+c.getImage()+"')";
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
            Club c=new Club(result.getLong("cin_proprietaire"),result.getString("email"),result.getString("nom_club"),result.getString("categorie"),result.getString("description"),result.getInt("nombre_personnels"),result.getString("lieu"),result.getString("image"));
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
       
        result=st.executeQuery("select * from clubs where id_club="+id);
          if(result.next())
         c = new Club(result.getLong("cin_proprietaire"),result.getString("email"),result.getString("nom_club"),result.getString("categorie"),result.getString("description"),result.getInt("nombre_personnels"),result.getString("lieu"),result.getString("image"));
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
           st.executeUpdate("delete from clubs where id_club="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Club c) {
         Club cl=search(c.getId_club());
   if(cl!=null)
   {
        try {
            st.executeUpdate("Update clubs set  cin_proprietaire='"+c.getCin_proprietaire()+"',email='"+c.getEmail()+"', nom_club='"+c.getNom_club()+"', categorie='"+c.getCategorie()+"', description='"+c.getDescription()+"', nombre_membre='"+c.getNombre_membre()+"', nombre_epersonnels='"+c.getNombre_personnel()+"',lieu='"+c.getLieu()+"',image='"+c.getImage()+"' where id_club="+c.getId_club());
        } catch (SQLException ex) {
            Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }
    public  ObservableList<Club>  SearchCatégorie(String s) {
        
        ObservableList<Club> liste = FXCollections.observableArrayList();
   
    try{
        result = st.executeQuery("select * from clubss where categorie like '"+s+"' ") ; 
      while (result.next()) { 
        Club c = new Club(result.getLong("cin_proprietaire"),result.getString("email"),result.getString("nom_club"),result.getString("categorie"),result.getString("description"),result.getInt("nombre_personnels"),result.getString("lieu"),result.getString("image"));
                liste.add(c); 
    } }  catch (SQLException ex) {
            Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return liste ; 
    }

    public ObservableList<Club> SearchCategorie(String s) {
 ObservableList<Club> liste = FXCollections.observableArrayList();
   
    try{
        result = st.executeQuery("select * from clubs where categorie like '"+s+"' ") ; 
      while (result.next()) { 
        Club c = new Club(result.getLong("cin_proprietaire"),result.getString("email"),result.getString("nom_club"),result.getString("categorie"),result.getString("description"),result.getInt("nombre_personnels"),result.getString("lieu"),result.getString("image"));
                liste.add(c); 
    } }  catch (SQLException ex) {
            Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return liste ;     }

    public ObservableList<Club> Search() {
        ObservableList<Club> liste = FXCollections.observableArrayList();
   
    try{
        result = st.executeQuery("select * from clubs") ; 
      while (result.next()) { 
        Club c = new Club(result.getLong("cin_proprietaire"),result.getString("email"),result.getString("nom_club"),result.getString("categorie"),result.getString("description"),result.getInt("nombre_personnels"),result.getString("lieu"),result.getString("image"));
                liste.add(c); 
    } }  catch (SQLException ex) {
            Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return liste ; 
}

    public ObservableList<Club> getAllByName(String nom) {
        ObservableList<Club> Clubs=FXCollections.observableArrayList();
   String requete = "select * from clubs where nom_club=?";
        //// "select * from user where username like '"+search+"
        
        System.out.println(requete);
        
        PreparedStatement preparedStatement;

        try {
          
             preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, nom);
           result = preparedStatement.executeQuery();
            while (result.next()) {

            Club c=new Club(result.getLong("cin_proprietaire"),result.getString("email"),result.getString("nom_club"),result.getString("categorie"),result.getString("description"),result.getInt("nombre_personnels"),result.getString("lieu"),result.getString("image"));
            Clubs.add(c);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Clubs;
    }

    @Override
    public Club getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Club> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
public ObservableList<Club> getbyPseudo1(String pseudo) {
    ObservableList<Club> liste = FXCollections.observableArrayList();
   
    try{
 result = st.executeQuery("select * from clubs where nom_club like '%"+pseudo+"%'") ;
      while (result.next()) { 
            Club c = new Club(result.getLong("cin_proprietaire"),result.getString("email"),result.getString("nom_club"),result.getString("categorie"),result.getString("description"),result.getInt("nombre_personnels"),result.getString("lieu"),result.getString("image"));
                liste.add(c); 
    } } catch (SQLException ex) { 
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return liste ; 
    }
   public ObservableList<String> fillCombo() throws SQLException
   {
       ObservableList<String> liste = FXCollections.observableArrayList();
       try {
        result=st.executeQuery("select * from clubs");
        while(result.next())
        {
            String s= result.getString("nom_club");
            liste.add(s);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
       return liste;
       
   
}

    public Club getByName(String nom) {
        
         Club c=null;
        try {
       
        result=st.executeQuery("select * from clubs where nom_club like'"+nom+"'");
          if(result.next())
              
         c = new Club(result.getInt("id_club"), result.getLong("cin_proprietaire"), result.getString("email"), result.getString("nom_club"), result.getString("categorie"), result.getString("description"), result.getInt("nombre_personnels"), result.getString("lieu"), result.getString("image"));
          
         
    } catch (SQLException ex) {  
        Logger.getLogger(ClubService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        return c; 
    }
    
    }
