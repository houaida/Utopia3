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
import allforkids.entite.*;

import allforkids.technique.util.DataSource;
import java.util.Map;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Molka
 */
public class LigneCommandeService implements IAllForKids<LigneCommande>{
    
    Connection connexion;
    Statement st;
    ResultSet result;
    static LigneCommandeService instance;
 public static LigneCommandeService getInstance()
    {
    if(instance==null)
    {
    instance = new LigneCommandeService();}
    return instance;
    
    }
 
public LigneCommandeService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(LigneCommandeService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

   /*public Produit selectPrix(){
        Produit p= null ; 
        try {
            result = st.executeQuery("select prix_produit from produits join LigneCommandes on LignesCommandes.id_produit=produits.id_produit ") ; 
            //result.next() ;
              p = new Produit(result.getInt("id_produit"),result.getFloat("prix_produit")) ;  
       } catch (SQLException ex) {
            System.out.println(ex) ;
        }
        return p ; 
    }*/

   /* public void insertPrix(Produit p1) {
       String req = "update ligneCommandes set prix_produit = '" +p1.getPrix_produit()+ "' where id_produit = '" +p1.getId_produit()+ "' " ; 
        //String req = "insert into ligneCommandes(prix_produit) values ('" +p1.getPrix_produit()+ "') where id_produit='2'";
        //System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }*/

    @Override
    public void insert(LigneCommande p) {
         String req = "insert into ligneCommandes(id_produit,prix_produit,quantite) values ('" +p.getId_produit()+ "','" +p.getPrix_produit()+ "','" +p.getQuantite()+ "')";
        //System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public ObservableList<LigneCommande> getAll() {
                ObservableList<LigneCommande> list = FXCollections.observableArrayList();
        try {
            result = st.executeQuery("select * from ligneCommandes");
           
            while (result.next()) {
                LigneCommande p = new LigneCommande(result.getInt("id_ligne"),result.getInt("id_produit"), result.getFloat("prix_produit"), result.getInt("quantite"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
    
    public ObservableList<LigneCommande> seachId(int id) {
                ObservableList<LigneCommande> list = FXCollections.observableArrayList();
        try {
            result = st.executeQuery("select * from ligneCommandes where id_produit="+id);
           
            while (result.next()) {
                LigneCommande p = new LigneCommande(result.getInt("id_ligne"),result.getInt("id_produit"), result.getFloat("prix_produit"), result.getInt("quantite"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
    
     public ObservableList<LigneCommande> seachCategorie(String c) {
                ObservableList<LigneCommande> list = FXCollections.observableArrayList();
        try {
            result = st.executeQuery("select * from ligneCommandes join produits on ligneCommandes.id_produit = produits.id_produit where produits.categorie like '"+c+"' ");
           
            while (result.next()) {
                LigneCommande p = new LigneCommande(result.getInt("id_ligne"),result.getInt("id_produit"), result.getFloat("prix_produit"), result.getInt("quantite"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    @Override
    public LigneCommande search(int id) {
        LigneCommande p = null ; 
    String req = "select * from ligneCommandes where id_ligne="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new LigneCommande(result.getInt("id_ligne"),result.getInt("id_produit"), result.getFloat("prix_produit"), result.getInt("quantite")) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(LigneCommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
    }
    
    /* public LigneCommande searchId(int id) {
        LigneCommande p = null ; 
    String req = "select * from ligneCommandes where id_produit="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new LigneCommande(result.getInt("id_ligne"),result.getInt("id_produit"), result.getFloat("prix_produit"), result.getInt("quantite")) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(LigneCommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
    }*/

    @Override
    public boolean delete(int id) {
         LigneCommande p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from ligneCommandes where id_ligne="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(LigneCommandeService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(LigneCommande p) {
        LigneCommande p1 = search(p.getId_ligne()) ; 
    if(p1!=null){
        try{
            st.executeUpdate("update ligneCommandes set id_produit='"+p.getId_produit()+"', prix_produit='"+p.getPrix_produit()+"', quantite='"+p.getQuantite()+"' where id_ligne="+p.getId_ligne()) ; 
        } catch (SQLException ex) {
            Logger.getLogger(LigneCommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true ; 
    }
    return false ; 
    }

    @Override
    public Map<String, LigneCommande> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LigneCommande getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
