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
import allforkids.entite.Commande;
import allforkids.entite.Produit;

import allforkids.technique.util.DataSource;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Molka
 */
public class CommandeService implements IAllForKids<Commande> {
    
    Connection connexion;
    Statement st;
    ResultSet result;
    static CommandeService instance;
    
 public static CommandeService getInstance()
    {
    if(instance==null)
    {
    instance = new CommandeService();}
    return instance;
    
    }
 
public CommandeService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void insertTotal(Commande p) {
        String req = "update commandes set total = (select prix_produit*quantite from ligneCommandes where id_ligne='"+p.getId_ligne()+"')";
        //System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void insert(Commande p) {
        String req = "insert into commandes (id_parent,id_ligne,total) values ('" + p.getId_parent()+ "','" + p.getId_ligne()+ "','" + p.getTotal()+ "')";
        //System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Commande> getAll() {
        List<Commande> list = new ArrayList<>();
        try {
            result = st.executeQuery("select * from commandes inner join ligneCommandes on ligneCommandes.id_ligne=commandes.id_ligne inner join users on users.id_user=commandes.id_parent where users.type='parent' ");
           /* ResultSetMetaData resultMeta = result.getMetaData() ; 
            System.out.println("**********");
            for(int i = 1 ; i<= resultMeta.getColumnCount() ; i++){
                System.out.println(resultMeta.getColumnName(i).toUpperCase());
            }
            System.out.println("***********"); */
            while (result.next()) {
                Commande p = new Commande(result.getInt("id_commande"),result.getInt("id_parent"), result.getInt("id_ligne"), result.getFloat("total"),result.getString("date"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
    
     public ObservableList<Commande> getAll2() {
         ObservableList<Commande> list=FXCollections.observableArrayList();
        try {
            result = st.executeQuery("select * from commandes");
          
            while (result.next()) {
                 Commande p = new Commande(result.getInt("id_commande"),result.getInt("id_parent"), result.getInt("id_ligne"), result.getFloat("total"),result.getString("date"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
     public ObservableList<Commande> getDate(){
         ObservableList<Commande> list=FXCollections.observableArrayList();
        try {
            result = st.executeQuery("select date from commandes");
          
            while (result.next()) {
                 Commande p = new Commande(result.getInt("id_commande"),result.getString("date"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
     }

    @Override
    public Commande search(int id) {
        Commande p = null ; 
    String req = "select * from commandes where id_commande="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new Commande(result.getInt("id_commande"),result.getInt("id_parent"), result.getInt("id_ligne"), result.getFloat("total")) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
    }

    @Override
    public boolean delete(int id) {
        Commande p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from commandes where id_commande="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Commande p) {
         Commande p1 = search(p.getId_commande()) ; 
    if(p1!=null){
        try{
            st.executeUpdate("update commandes set id_parent='"+p.getId_parent()+"', id_ligne='"+p.getId_ligne()+"', total='"+p.getTotal()+"' where id_commentaire="+p.getId_commande()) ; 
        } catch (SQLException ex) {
            Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true ; 
    }
    return false ; 
    }

    @Override
    public Map<String, Commande> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Commande getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
