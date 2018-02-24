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
import allforkids.entite.Livraison;

import allforkids.technique.util.DataSource;
import java.util.Map;

/**
 *
 * @author Molka
 */
public class LivraisonService implements IAllForKids<Livraison>{
    
    Connection connexion;
    Statement st;
    ResultSet result;
    static LivraisonService instance;
 public static LivraisonService getInstance()
    {
    if(instance==null)
    {
    instance = new LivraisonService();}
    return instance;
    
    }
 
private LivraisonService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    @Override
    public void insert(Livraison p) {
        String req = "insert into livraisons(id_livreur,id_parent,duree,montant,adresse) values ('" + p.getId_livreur()+ "','" + p.getId_parent()+ "','" + p.getDuree()+ "','" + p.getMontant()+ "','" + p.getAdresse()+ "')";
        //System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    

    @Override
    public List<Livraison> getAll() {
        List<Livraison> list = new ArrayList<>();
        try {
            //result = st.executeQuery("select * from livraisons") ; 
            result = st.executeQuery("select * from livraisons join users on users.id_user=livraisons.id_livreur where users.type='livreur' ");
           /* ResultSetMetaData resultMeta = result.getMetaData() ; 
            System.out.println("**********");
            for(int i = 1 ; i<= resultMeta.getColumnCount() ; i++){
                System.out.println(resultMeta.getColumnName(i).toUpperCase());
            }
            System.out.println("***********"); */
            while (result.next()) {
                Livraison p = new Livraison(result.getInt("id_livraison"),result.getInt("id_livreur"),result.getInt("id_parent"), result.getInt("duree"), result.getInt("montant"),result.getString("adresse"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    @Override
    public Livraison search(int id) {
         Livraison p = null ; 
    String req = "select * from livraisons where id_livraison="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new Livraison(result.getInt("id_livraison"),result.getInt("id_livreur"), result.getInt("id_parent"), result.getInt("duree"),result.getInt("montant"),result.getString("adresse")) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
    }

    @Override
    public boolean delete(int id) {
         Livraison p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from livraisons where id_livraison="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Livraison p) {
        Livraison p1 = search(p.getId_livraison()) ; 
    if(p1!=null){
        try{
            st.executeUpdate("update livraisons set id_livreur='"+p.getId_livreur()+"', id_parent='"+p.getId_parent()+"', duree='"+p.getDuree()+"', montant='"+p.getMontant()+"',adresse='"+p.getAdresse()+"' where id_livraison="+p.getId_livraison()) ; 
        } catch (SQLException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true ; 
    }
    return false ; 
    }

    @Override
    public Map<String, Livraison> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livraison getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
