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

import allforkids.entite.Forum;
import allforkids.technique.util.DataSource;

/**
 *
 * @author user
 */
public class ForumService implements IAllForKids<Forum>{
Connection cnx;
Statement st;
ResultSet rs;
static ForumService instance;
private ForumService(){
 cnx=DataSource.getInstance().getConnexion();
    try {
        st=cnx.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(ForumService.class.getName()).log(Level.SEVERE, null, ex);
    } 
}
public static ForumService getInstance()
    {
        if(instance==null)
        {  instance = new ForumService();}
        return instance;
    }

    @Override
    public void insert(Forum p) {
    String req="insert into forums(id_question,id_reponse,titre)values('"+p.getId_question()+"','"+p.getId_reponse()+"','"+p.getTitre()+"')";
     try {
            st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(ForumService.class.getName()).log(Level.SEVERE, null, ex);
    }   }

    @Override
    public List<Forum> getAll() {
    List<Forum> Forums=new ArrayList<>();
        
    try {
        rs=st.executeQuery("select * from forums");
    } catch (SQLException ex) { 
        Logger.getLogger(ForumService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
      
    try {
        while(rs.next()){
            Forum p;
        
            p = new Forum(rs.getInt("id_question"),rs.getInt("id_reponse"),rs.getString("titre"));
             Forums.add(p);
        }
    } catch (SQLException ex) { 
        Logger.getLogger(ForumService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Forums;
    }

    @Override
    public Forum search(int n) {
        Forum p=null;
        try {
       
        rs=st.executeQuery("select * from forums where id_forum="+n);
          if(rs.next())
            p = new Forum(rs.getInt("id_question"),rs.getInt("id_reponse"),rs.getString("titre"));
    } catch (SQLException ex) { 
        Logger.getLogger(ForumService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
        Forum p1=search(id);
        // System.out.println(p1);
         
   if(p1!=null)
   {
       try {
           st.executeUpdate("delete from forums where id_forum="+id);
            return true;
       }    catch (SQLException ex) {    
                Logger.getLogger(ForumService.class.getName()).log(Level.SEVERE, null, ex);
            }    
  
   }return false;
    }

    @Override
    public boolean update(Forum p) {
    Forum p1=search(p.getId_forum());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update forums set id_question='"+p.getId_question()+"',id_reponse='"+p.getId_reponse()+"',titre='"+p.getTitre()+"' where id_forum="+p.getId_forum());
       	

        } catch (SQLException ex) {   
            Logger.getLogger(ForumService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

    @Override
    public Map<String, Forum> getAllMap() {
        //select titre,date_question,description_question,date_reponse,description_reponse from forums f join questions q on (f.id_question=q.id_question) join reponses r on (f.id_reponse=r.id_reponse)"
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Forum getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
 }

   

