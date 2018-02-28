/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.moyen;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
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
 * @author imen
 */
public class moyenService implements IAllForKids<moyen>{
     Connection connexion;
    Statement st;
    ResultSet result;
static moyenService instance;
 
public static moyenService getInstance()
    {
    if(instance==null)
    {
    instance = new moyenService();}
    return instance;
    
    }
 
    public moyenService() {
        try {
            DataSource ds = DataSource.getInstance();
            connexion= ds.getConnexion();
            System.out.println("Connection: "+ds.getConnexion());
            System.out.println(connexion);
            st = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MoyendeTransportService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  @Override
     public  ObservableList<moyen> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<moyen>list=FXCollections.observableArrayList();
        
        try {
            result = st.executeQuery("select * from moyen LIMIT 0,4");
            while (result.next()) {
               moyen t = new moyen(result.getString(3),result.getInt(4));
                list.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    
    }

    @Override
    public void insert(moyen t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String req = "insert into moyen(id_enfant,description,nbr) values ('" + t.getId_enfant()+"','"+ t.getDescription()+"','"+ t.getNbr()+"')";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }}

    @Override
    public Map<String, moyen> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public moyen search(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(moyen t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public moyen getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
    
}
