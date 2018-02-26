/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;


import allforkids.entite.Reservation;
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
public class ReservationService implements IAllForKids<Reservation>{
     Connection connexion;
    Statement st;
    ResultSet result;
    static ReservationService instance;
 public static ReservationService getInstance()
    {
    if(instance==null)
    {
    instance = new ReservationService();}
    return instance;
    
    }
 

    public ReservationService() {
        try {
            DataSource ds = DataSource.getInstance();
            connexion= ds.getConnexion();
            System.out.println("Connection: "+ds.getConnexion());
            System.out.println(connexion);
            st = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public Reservation getReservationbyId(int id) {
     Reservation p = null ; 
    String req = "select * from reservations where id_reservation="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new Reservation(result.getInt(1),result.getInt(2),result.getInt(3),result.getInt(4)); 
    }   catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
     }

    @Override
    public void insert(Reservation p) {
        String req = "insert into reservations (id_user,nbre_place) values ('" + p.getId_user()+ "','" + p.getNbre_place()+ "')";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
       
    public void insert1(Reservation p,int v) {
        String req = "insert into reservations (id_user,nbre_place,idC) values ('" + p.getId_user()+ "','" + p.getNbre_place()+"','"+v+"')";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
   


    @Override
    public  ObservableList<Reservation> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ObservableList<Reservation>list=FXCollections.observableArrayList();
        try {
            result = st.executeQuery("select * from reservations join users on users.id_user=reservations.id_user where users.type='parent'");
         
            while (result.next()) {
                Reservation p = new Reservation(result.getInt(1), result.getInt(2), result.getInt(3));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
    
     public  Reservation search1(int id) {
                   Reservation p = null ; 
    String req = "select * from reservations where id_user="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new Reservation(result.getInt(1), result.getInt(2), result.getInt(3),result.getInt(4));
        }   catch (SQLException ex) {
            Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ;
    }

    @Override
    public Reservation search(int id) {
                  Reservation p = null ; 
    String req = "select * from reservations where idC="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
       p = new Reservation(result.getInt(1), result.getInt(2), result.getInt(3),result.getInt(4));
        }   catch (SQLException ex) {
            Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ;
    }
       public  Reservation search2(int id) {
                   Reservation p = null ; 
    String req = "select * from reservations where id_reservation="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new Reservation(result.getInt(1), result.getInt(2), result.getInt(3),result.getInt(4));
        }   catch (SQLException ex) {
            Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ;
    }


    @Override
    public boolean delete(int id) {
        Reservation p1=search(id);
      
   if(p1!=null)
   {
       try {
           st.executeUpdate("delete from reservations where idC="+id);
            return true;
           }catch (SQLException ex) {    
                Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
            }    
  
   }return false;
     
    }


    public boolean update1(Reservation p,int v) {
         Reservation p1= search2(p.getId()); 
    if(p1!=null){
        try{
            st.executeUpdate("update reservations set id_user='"+p.getId_user()+"',nbre_place='"+p.getNbre_place()+"',idC='"+v+"'where id_reservation="+p1) ; 
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true ; 
    }
    return false ; 
    }

    @Override
    public Map<String, Reservation> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public Reservation getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Reservation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    }
    
    



