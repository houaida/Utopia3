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
import allforkids.entite.Ticket;
import allforkids.technique.util.DataSource;
import java.util.Map;

/**
 *
 * @author hammamet
 */
public class TicketService implements IAllForKids<Ticket>{
     Connection connexion;
    Statement st;
    ResultSet result;
    static TicketService instance;
    public static TicketService getInstance()
    {
        if(instance==null)
        {
    instance = new TicketService();}
          return instance;
    }
    private TicketService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public void insert(Ticket t) {
        String req="insert into tickets(id_evenement,type,prix,etat)values('"+t.getId_evenement()+"','"+t.getType()+"','"+t.getPrix()+"','"+t.getEtat()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public List<Ticket> getAll() {
         List<Ticket> Tickets=new ArrayList<>();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from tickets");
    } catch (SQLException ex) {
        Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            Ticket t=new Ticket(result.getInt(2),result.getString(3),result.getFloat(4),result.getString(5));
            Tickets.add(t);
        }
    } catch (SQLException ex) {
        Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Tickets;
    }

    @Override
    public Ticket search(int id) {
Ticket t=null;
        try {
       
        result=st.executeQuery("select * from tickets where id_ticket="+id);
          if(result.next())
         t = new Ticket(result.getInt(2),result.getString(3),result.getFloat(4),result.getString(5));
    } catch (SQLException ex) {
        Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return t;     }

    @Override
    public boolean delete(int id) {
        Ticket t=search(id);
   if(t!=null)
   {
       try {
           st.executeUpdate("delete from tickets where id="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Ticket t) {
           Ticket ti=search(t.getId_ticket());
   if(ti!=null)
   {
        try {
            st.executeUpdate("Update tickets set  id_evenement='"+t.getId_evenement()+"',type='"+t.getType()+"', prix='"
                    +t.getPrix()+"', etat='"+t.getEtat()+"' where id="+t.getId_ticket());
        } catch (SQLException ex) {
            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

    @Override
    public Map<String, Ticket> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ticket getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

    
    
    

    
}
