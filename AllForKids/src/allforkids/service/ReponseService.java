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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import allforkids.entite.Reponse;
import allforkids.technique.util.DataSource;

/**
 *
 * @author user
 */
public class ReponseService implements IAllForKids<Reponse>{
Connection cnx;
Statement st;
ResultSet rs;
static ReponseService instance;
private ReponseService(){
 cnx=DataSource.getInstance().getConnexion();
    try {
        st=cnx.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(ReponseService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public static ReponseService getInstance()
    {
        if(instance==null)
        { instance = new ReponseService();}
        return instance;
    }

    @Override
    public void insert(Reponse p) {
 String req="insert into reponses(id_question,id_user,date_reponse,description_reponse)values('"+p.getId_question()+"','"+p.getId_user()+"','"+p.getDate_creation()+"','"+p.getDesciption()+"')";
     try {
            st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(ReponseService.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }

    @Override
    public List<Reponse> getAll() {
         List<Reponse> Reponses=new ArrayList<>();
        
    try {
        rs=st.executeQuery("select * from reponses");
    } catch (SQLException ex) { 
        Logger.getLogger(ReponseService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
      
    try {
        while(rs.next()){
          Reponse p;
            p = new Reponse(rs.getInt("id_question"),rs.getInt("id_user"),rs.getDate("date_reponse")
                    ,rs.getString("description_reponse"));
            Reponses.add(p);
        }
    } catch (SQLException ex) { 
        Logger.getLogger(ReponseService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return Reponses;
    }
    

    @Override
    public Reponse search(int n) {
Reponse p=null;
        try {
       
        rs=st.executeQuery("select * from reponses where id_reponse="+n);
          if(rs.next())
   p = new Reponse(rs.getInt("id_question"),rs.getInt("id_user"),rs.getDate("date_reponse")
                    ,rs.getString("description_reponse"));
    } catch (SQLException ex) { 
        Logger.getLogger(ReponseService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
Reponse p1=search(id);
        // System.out.println(p1);
         
   if(p1!=null)
   {
       try {
           st.executeUpdate("delete from reponses where id_reponse="+id);
            return true;
       } catch (SQLException ex) { 
        Logger.getLogger(ReponseService.class.getName()).log(Level.SEVERE, null, ex);
    } 
  
   }return false;    }

    @Override
    public boolean update(Reponse p) {
Reponse p1=search(p.getId_reponse());
   if(p1!=null)
   {
        try {
        st.executeUpdate("Update reponses set id_question='"+p.getId_question()+"',id_user='"+p.getId_user()+"',date_reponse='"+p.getDate_creation()+"',description_reponse='"+p.getDesciption()+"'where id_reponse="+p.getId_reponse());
       	

        } catch (SQLException ex) { 
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;}

    @Override
    public Map<String, Reponse> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    }

  

