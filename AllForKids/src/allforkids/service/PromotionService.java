/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;


import allforkids.entite.Produit;
import allforkids.entite.Promotion;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
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
public class PromotionService implements IAllForKids<Promotion>{
    
    Connection connexion;
    Statement st;
    ResultSet result;
    static PromotionService instance;
    
 public static PromotionService getInstance()
    {
    if(instance==null)
    {
    instance = new PromotionService();}
    return instance;
    
    }
 
public PromotionService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public void insertTotal(Promotion p) {
        String req = "update promotions set prixPromo = pourcentage*(select prix_produit from produits where id_produit='"+p.getId_produit()+"')";
        //System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public void insert(Promotion p) {
         String req=null;
        try {
            req = "insert into promotions(id_produit,pourcentage,date_debut,date_fin) values ('" + p.getId_produit()+ "','" + p.getPourcentage()+ "','" + p.convert(p.getDate_debut())+ "','" + p.convert(p.getDate_fin())+ "')";
        } catch (ParseException ex) { 
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
        }
     try {
            st.executeUpdate(req);
    }   catch (SQLException ex) { 
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    } 
    
    
    

    @Override
    public ObservableList<Promotion> getAll() {
       
        ObservableList<Promotion> list = FXCollections.observableArrayList();
        try {
            result = st.executeQuery("select * from promotions");
           /* ResultSetMetaData resultMeta = result.getMetaData() ; 
            System.out.println("**********");
            for(int i = 1 ; i<= resultMeta.getColumnCount() ; i++){
                System.out.println(resultMeta.getColumnName(i).toUpperCase());
            }
            System.out.println("***********"); */
            while (result.next()) {
                Promotion p = new Promotion(result.getInt("id_promo"),result.getInt("id_produit"), result.getInt("pourcentage"), result.getString("date_debut"),result.getString("date_fin"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;    }

    @Override
    public Promotion search(int id) {
        Promotion p = null ; 
    String req = "select * from promotions where id_promo="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new Promotion(result.getInt("id_promo"),result.getInt("id_produit"), result.getInt("pourcentage"), result.getString("date_debut"),result.getString("date_fin")) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
    }

    @Override
    public boolean delete(int id) {
        Promotion p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from promotions where id_promo="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Promotion p) {
        Promotion p1 = search(p.getId_promotion()) ; 
    if(p1!=null){
        try{
            st.executeUpdate("update promotions set id_produit='"+p.getId_produit()+"', pourcentage='"+p.getPourcentage()+"', date_debut='"+p.getDate_debut()+"', date_fin='"+p.getDate_fin()+"' where id_promo="+p.getId_promotion()) ; 
        } catch (SQLException ex) {
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true ; 
    }
    return false ; 
    }

    @Override
    public Map<String, Promotion> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public float calculPrixPromo(Promotion p){
        ProduitService ps = new ProduitService() ; 
        Produit p1 = ps.search(p.getId_produit()) ; 
         p.setPrixPromo((p.getPourcentage()*p1.getPrix_produit())/100);
         return p.getPrixPromo() ; 
    }

    @Override
    public Promotion getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    /*public  ObservableList<Promotion>  SearchDate(float f) {
        //Produit p = null ;
        ObservableList<Promotion> liste = FXCollections.observableArrayList();
   
    try{
        result = st.executeQuery("select * from promotions where pourcentage="+f) ; 
      while (result.next()) { 
        Promotion p = new Promotion(result.getInt("id_promo"),result.getInt("id_produit"), result.getFloat("pourcentage"), result.getString("date_debut"),result.getString("date_fin"), result.getFloat("prixPromo"));
                liste.add(p); 
    } }  catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return liste ; 
    }
    */

    
    
}
    

