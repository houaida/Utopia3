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
import allforkids.entite.*;
import allforkids.technique.util.DataSource;
import java.util.Map;

/**
 *
 * @author Molka
 */
public class LivreurService implements IAllForKids<Livreur>{
    
    Connection connexion;
    Statement st;
    ResultSet result;
    static LivreurService instance;
 public static LivreurService getInstance()
    {
    if(instance==null)
    {
    instance = new LivreurService();}
    return instance;
    
    }
 
private LivreurService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(LivreurService.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    @Override
    public void insert(Livreur p) {
       // String req = "insert into users(cin,nom,prenom,pseudo,mdp,email,adresse,montant,nom_club,num_tel,disponibilite,type) values ('0','','','" + p.getPseudo()+ "','" + p.getMdp()+ "''" + p.getMail()+ "','','0','','0','" + p.getDisponibilite()+ "','enseignant')";
       String req = "insert into users(cin,nom,prenom,pseudo,mdp,email,adresse,montant,nom_club,num_tel,type,disponibilite) values ('0','','','" + p.getPseudo()+ "','" + p.getMdp()+ "','" + p.getEmail()+ "','','0','','0','livreur','" + p.getDisponibilite()+ "')";
        //System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Livreur> getAll() {
        List<Livreur> list = new ArrayList<>();
        try {
            result = st.executeQuery("select id_user,pseudo,mdp,email,disponibilite from users");
           /* ResultSetMetaData resultMeta = result.getMetaData() ; 
            System.out.println("**********");
            for(int i = 1 ; i<= resultMeta.getColumnCount() ; i++){
                System.out.println(resultMeta.getColumnName(i).toUpperCase());
            }
            System.out.println("***********"); */
            while (result.next()) {
                Livreur p = new Livreur(result.getInt("id_user"),result.getString("pseudo"), result.getString("mdp"), result.getString("email"),result.getInt("disponibilite"),result.getString(12));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    @Override
    public Livreur search(int id) {
        Livreur p = null ; 
    String req = "select id_user,pseudo,mdp,email,disponibilite from users where id_user="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new Livreur(result.getInt("id_user"),result.getString("pseudo"), result.getString("mdp"), result.getString("email"),result.getInt("disponibilite"),result.getString(12)) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(LivreurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
    }

    @Override
    public boolean delete(int id) {
         Livreur p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from livreurs where id_livreur="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(LivreurService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Livreur p) {
       Livreur p1 = search(p.getId_user()) ; 
    if(p1!=null){
        try{
            st.executeUpdate("update users set pseudo='"+p.getPseudo()+"', mdp='"+p.getMdp()+"', email='"+p.getEmail()+"', disponibilite='"+p.getDisponibilite()+"' where id_user="+p.getId_user()) ; 
        } catch (SQLException ex) {
            Logger.getLogger(LivreurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true ; 
    }
    return false ; 
    }

    @Override
    public Map<String, Livreur> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livreur getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
