/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;



import allforkids.entite.Covoiturage;
import allforkids.technique.util.DataSource;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author imen
 */
public class CovoiturageService implements IAllForKids<Covoiturage>{
     Connection connexion;
    Statement st;
    ResultSet result;
   static CovoiturageService instance;
 public static CovoiturageService getInstance()
    {
    if(instance==null)
    
    instance = new CovoiturageService();
    return instance;
    
    }

    public CovoiturageService() {
        try {
            DataSource ds = DataSource.getInstance();
            connexion= ds.getConnexion();
            System.out.println("Connection: "+ds.getConnexion());
            System.out.println(connexion);
            st = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public Covoiturage getMoyenById(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Covoiturage t= null ; 
    String req = "select * from  covoiturages where id="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
         t = new Covoiturage(result.getInt(1),result.getInt(2), result.getString(3),result.getString(4), result.getString(5),result.getString(6),result.getInt(7)) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return t ; 
    }

    @Override
    public void insert(Covoiturage p) {
           String req=null;
         try {
             req = "insert into covoiturages (id_user,depart,DateDepart,HeureD,destination,DateArrive,HeureA,nbre_place_dispo) values ('" + p.getId_user()+"','" +p.getDepart()+"','" + p.convert(p.getDateDepart())+"','" +p.getHeureD()+"','" + p.getDestination()+"','" + p.convert(p.getDateArrive())+"','" +p.getHeureA()+"','" + p.getNbre_place_dispo()+  "')";
         } catch (ParseException ex) {
             Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
         }
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    }

     @Override
    public ObservableList<Covoiturage> getAll() {
              ObservableList<Covoiturage>list =FXCollections.observableArrayList();
        try {
            result = st.executeQuery("select * from covoiturages join users on users.id_user=covoiturages.id_user where users.type='parent'");
         
            while (result.next()) {
               Covoiturage t = new Covoiturage(result.getInt(1),result.getInt(2),result.getString("depart"),result.getString("DateDepart"),result.getString(5),result.getString("destination"),result.getString("DateArrive"),result.getString(8),result.getInt("nbre_place_dispo"));
                list.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    @Override
    public Covoiturage search(int id){
             Covoiturage p = null ; 
 
    try{
        
        result=st.executeQuery("select * from covoiturages where id="+id);
       if( result.next())
       { p = new Covoiturage(result.getInt(1),result.getInt(2), result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getInt(9)) ; }
    }   catch (SQLException ex) {
            Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
    }

     public  ObservableList<Covoiturage> search1(int id){
      ObservableList<Covoiturage>list =FXCollections.observableArrayList(); 
      
    try{
        System.out.println("id **********************"+id);
        result=st.executeQuery("select * from covoiturages where id_user="+id);
       while( result.next())
       {  Covoiturage t = new Covoiturage(result.getInt(1),result.getInt(2), result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getInt(9)) ;
           System.out.println("from servce:"+t.toString());
       list.add(t);}
    }   catch (SQLException ex) {
            Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list ; 
    }
    /*@Override
    public boolean delete(Covoiturage p) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String req = "delete from covoiturages where id="+p.getId(); 
    if(p!=null){
        try{
            st.executeUpdate(req) ;
            return true ; 
        } catch (SQLException ex) {
            Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return false ; 
    }*/

    @Override
    public boolean update(Covoiturage t) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  //  Covoiturage t1 = getMoyenById(t.getId()) ; 
        Covoiturage t1 = search(t.getId()) ;
        //System.out.println("coooooo:"+t1.toString());
    if(t1!=null){
        try{
//           "update personne set nom='"+p.getNom()+"', prenom='"+p.getPrenom()+"'where id="+p.getId())
            st.executeUpdate("update covoiturages set id_user='"+ t.getId_user()+"',depart='"+ t.getDepart()+"',DateDepart='"+ t.getDateDepart()+"',HeureD='"+ t.getHeureD()+"',destination='"+ t.getDestination()+"',DateArrive='"+ t.getDateArrive()+ "',HeureA='"+ t.getHeureA()+"',nbre_place_dispo='" + t.getNbre_place_dispo()+"'where id="+t1.getId()) ; 
        } catch (SQLException ex) {
            Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true ; 
    }
    return false ;
    }
    
  
    public boolean delete(int id) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      Covoiturage p1=search(id);
        // System.out.println(p1);
         
   if(p1!=null)
   {
       try {
           st.executeUpdate("delete from covoiturages where id="+id);
            return true;
           }catch (SQLException ex) {    
                Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
            }    
  
   }return false;
    
}

   
    public Map<String, Covoiturage> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public Covoiturage getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ObservableList<Covoiturage> getAll1() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     ObservableList<Covoiturage>list =FXCollections.observableArrayList();
        try {
            result = st.executeQuery("select * from covoiturages join users on users.id_user=covoiturages.id_user where users.type='parent'");
         
            while (result.next()) {
               Covoiturage t = new Covoiturage(result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getInt("nbre_place_dispo"));
                list.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

   
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     public void insert1(Covoiturage p,int v) throws ParseException {
String req;
req = "insert into covoiturages (id_user,depart,DateDepart,HeureD,destination,DateArrive,HeureA,nbre_place_dispo) values ('"+v+"','"+p.getDepart()+"','" + p.convert(p.getDateDepart())+"','" +p.getHeureD()+"','" + p.getDestination()+"','" + p.convert(p.getDateArrive())+"','" +p.getHeureA()+"','" + p.getNbre_place_dispo()+  "')";


    try {
        st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
    }
     
    }
    }

