/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Produit;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
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
 * @author Molka
 */
public class ProduitService implements IAllForKids<Produit> {

    Connection connexion;
    Statement st;
    ResultSet result;
    static ProduitService instance;
    
 public static ProduitService getInstance()
    {
    if(instance==null)
    {
    instance = new ProduitService();}
    return instance;
    
    }
 
public ProduitService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @Override
    public void insert(Produit p) {
         String req = "insert into produits(nom,categorie,prix_produit,description,image,quantite) values ('" + p.getNom() + "','" + p.getCatégorie()+ "','" + p.getPrix_produit()+ "','" + p.getDescription()+ "','" + p.getImage()+ "','" + p.getQuantite()+ "')";
        //System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public ObservableList<Produit> getAll() {
         ObservableList<Produit> list=FXCollections.observableArrayList();
        try {
            result = st.executeQuery("select * from produits");
          
            while (result.next()) {
                Produit p = new Produit(result.getInt("id_produit"),result.getString("nom"), result.getString("categorie"), result.getFloat("prix_produit"),result.getString("description"),result.getString("image"),result.getInt("quantite"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
       
    public ObservableList<Produit> getAll2() {
         ObservableList<Produit> list=FXCollections.observableArrayList();
        try {
            result = st.executeQuery("select * from produits");
          
            while (result.next()) {
                Produit p = new Produit(result.getString("nom"), result.getString("categorie"), result.getFloat("prix_produit"),result.getString("description"),result.getString("image"),result.getInt("quantite"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
    
   /* public Byte getImage(int id) {
        
        try {
            result = st.executeQuery("select image from produits where id_produit="+id);
          
            while (result.next()) {
                Byte b ; 
                b =result.getByte("image") ;
              
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return b;
    }
    */

    @Override
    public Produit search(int id) {
        Produit p = null ; 
    String req = "select * from produits where id_produit="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new Produit(result.getInt("id_produit"),result.getString("nom"), result.getString("categorie"), result.getFloat("prix_produit"),result.getString("description"),result.getString("image"),result.getInt("quantite")) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
    }
    
    public Produit searchImg(String img) {
        Produit p = null ; 
    String req = "select * from produits where image like '"+img+"' "; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new Produit(result.getInt("id_produit"),result.getString("nom"), result.getString("categorie"), result.getFloat("prix_produit"),result.getString("description"),result.getInt("quantite")) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
    }

    @Override
    public boolean delete(int id) {
        Produit p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from produits where id_produit="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Produit p) {
        Produit p1 = search(p.getId_produit()) ; 
    if(p1!=null){
        try{
            st.executeUpdate("update produits set nom='"+p.getNom()+"', categorie='"+p.getCatégorie()+"', prix_produit='"+p.getPrix_produit()+"', description='"+p.getDescription()+"', image='"+p.getImage()+"', quantite='"+p.getQuantite()+"' where id_produit="+p.getId_produit()) ; 
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true ; 
    }
    return false ; 
    }

    @Override
    public Map<String, Produit> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


     public  ObservableList<Produit>  SearchCatégorie(String s) {
        //Produit p = null ;
        ObservableList<Produit> liste = FXCollections.observableArrayList();
   
    try{
        result = st.executeQuery("select * from produits where categorie like '"+s+"' ") ; 
      while (result.next()) { 
        Produit p = new Produit(result.getInt("id_produit"),result.getString("nom"), result.getString("categorie"), result.getFloat("prix_produit"),result.getString("description"),result.getString("image"),result.getInt("quantite"));
                liste.add(p); 
    } }  catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return liste ; 
    }

    @Override
    public Produit getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
