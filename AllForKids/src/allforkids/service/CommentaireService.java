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
import allforkids.entite.Commentaire;

import allforkids.technique.util.DataSource;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Molka
 */
public class CommentaireService implements IAllForKids<Commentaire> {
    
    Connection connexion;
    Statement st;
    ResultSet result;
    static CommentaireService instance;
 public static CommentaireService getInstance()
    {
    if(instance==null)
    {
    instance = new CommentaireService();}
    return instance;
    
    }
 
public CommentaireService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public void insert(Commentaire p) {
         String req = "insert into commentaires (id_parent,id_produit,contenu) values ('" + p.getId_parent()+ "','" + p.getId_produit()+ "','" + p.getContenu()+ "')";
        //System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ObservableList<Commentaire> getAllById(int id) {
       ObservableList<Commentaire> list = FXCollections.observableArrayList();
        try {
            result = st.executeQuery("select * from commentaires where id_produit="+id);
           /* ResultSetMetaData resultMeta = result.getMetaData() ; 
            System.out.println("**********");
            for(int i = 1 ; i<= resultMeta.getColumnCount() ; i++){
                System.out.println(resultMeta.getColumnName(i).toUpperCase());
            }
            System.out.println("***********"); */
            while (result.next()) {
                Commentaire p = new Commentaire(result.getInt("id_commentaire"),result.getInt("id_produit"), result.getInt("id_parent"), result.getString("contenu"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
    
    @Override
    public List<Commentaire> getAll() {
        List<Commentaire> list = new ArrayList<>();
        try {
            result = st.executeQuery("select * from commentaires");
           /* ResultSetMetaData resultMeta = result.getMetaData() ; 
            System.out.println("**********");
            for(int i = 1 ; i<= resultMeta.getColumnCount() ; i++){
                System.out.println(resultMeta.getColumnName(i).toUpperCase());
            }
            System.out.println("***********"); */
            while (result.next()) {
                Commentaire p = new Commentaire(result.getInt("id_commentaire"),result.getInt("id_parent"), result.getInt("id_produit"), result.getString("contenu"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    @Override
    public Commentaire search(int id) {
         Commentaire p = null ; 
    String req = "select * from commentaires where id_commentaire="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new Commentaire(result.getInt("id_commentaire"),result.getInt("id_parent"), result.getInt("id_produit"), result.getString("contenu")) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
    }

    @Override
    public boolean delete(int id) {
        Commentaire p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from commentaires where id_commentaire="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Commentaire p) {
        Commentaire p1 = search(p.getId_commentaire()) ; 
    if(p1!=null){
        try{
            st.executeUpdate("update commentaires set id_produit='"+p.getId_produit()+"', id_parent='"+p.getId_parent()+"', contenu='"+p.getContenu()+"' where id_commentaire="+p.getId_commentaire()) ; 
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true ; 
    }
    return false ; 
    }

    @Override
    public Map<String, Commentaire> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Commentaire getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
