/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.MoyenDetransport;
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
public class MoyendeTransportService implements IAllForKids<MoyenDetransport>  {
  Connection connexion;
    Statement st;
    ResultSet result;
static MoyendeTransportService instance;
 public static MoyendeTransportService getInstance()
    {
    if(instance==null)
    {
    instance = new MoyendeTransportService();}
    return instance;
    
    }
 
    public MoyendeTransportService() {
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
   
    public MoyenDetransport getMoyenById(int id_moyenTransport) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    MoyenDetransport t= null ; 
    String req = "select * from  moyens_de_transport where id_moyenTransport="+id_moyenTransport ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
         t = new MoyenDetransport(result.getInt(1),result.getString(2),result.getString(3),result.getInt("nombre_de_place")) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(MoyendeTransportService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return t ; 
    }

    @Override
    public void insert(MoyenDetransport t) {
       String req = "insert into moyens_de_transport(type,immatriculation,nombre_de_place) values ('" + t.getType()+"','" + t.getImmatriculation()+"','" + t.getNombre_de_place()+  "')";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    }

    @Override
    public  ObservableList<MoyenDetransport> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<MoyenDetransport>list=FXCollections.observableArrayList();
        
        try {
            result = st.executeQuery("select * from moyens_de_transport");
            while (result.next()) {
               MoyenDetransport t = new MoyenDetransport(result.getInt(1), result.getString("type"), result.getString("immatriculation"),result.getInt("nombre_de_place"));
                list.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    
    }

    @Override
    public MoyenDetransport search(int id) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

         MoyenDetransport p = null ; 
    String req = "select * from moyens_de_transport where id_moyenTransport="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new MoyenDetransport(result.getInt(1),result.getString(2), result.getString(3), result.getInt(4)) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(MoyendeTransportService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
    }
    

    
    public boolean delete(MoyenDetransport t) {
         String req = "delete from moyens_de_transport where id_moyenTransport="+t.getId_moyenTransport(); 
    if(t!=null){
        try{
            st.executeUpdate(req) ;
            return true ; 
        } catch (SQLException ex) {
            Logger.getLogger(MoyendeTransportService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return false ; 
       }

    @Override
    public boolean update(MoyenDetransport t) {
         MoyenDetransport t1 = getMoyenById(t.getId_moyenTransport()) ; 
    if(t1!=null){
        try{
// "update personne set nom='"+p.getNom()+"', prenom='"+p.getPrenom()+"'where id="+p.getId())
            st.executeUpdate("update moyens_de_transport set type='" + t.getType()+"', immatriculation='"+ t.getImmatriculation()+"', nombre_de_place='" + t.getNombre_de_place()+"'where id_moyenTransport="+t.getId_moyenTransport()) ; 
        } catch (SQLException ex) {
            Logger.getLogger(MoyendeTransportService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true ; 
    }
    return false ; 
    }

    @Override
    public Map<String, MoyenDetransport> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
       //" throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
        MoyenDetransport p1=search(id);
        // System.out.println(p1);
         
   if(p1!=null)
   {
       try {
           st.executeUpdate("delete from moyens_de_transport where id_moyenTransport="+id);
            return true;
           }catch (SQLException ex) {    
                Logger.getLogger(ForumService.class.getName()).log(Level.SEVERE, null, ex);
            }    
  
   }return false;
    }

    @Override
    public MoyenDetransport getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

    
     
   
    
   
    
 
    
    
