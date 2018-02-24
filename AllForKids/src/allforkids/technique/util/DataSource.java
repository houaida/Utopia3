/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.technique.util;

/**
 *
 * @author MacBook
 */
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MacBook
 */
public class DataSource {



   //final String url="jdbc:mysql://127.0.0.1:3306/pidev";

  // final String url="jdbc:mysql://localhost:8889/PIDEV";
  final String url="jdbc:mysql://127.0.0.1:3306/pidev";


   //final String url="jdbc:mysql://localhost:8889/PIDEV";
//   final String url="jdbc:mysql://127.0.0.1:3306/pidev";
  //final String url="jdbc:mysql://127.0.0.1:3306/pidev";

  // final String url="jdbc:mysql://localhost:8889/PIDEV";



    final String login="root";
    final String password="";
     Connection connexion=null;
     static DataSource instance;
     
     
    private DataSource(){
    try{
    connexion=DriverManager.getConnection(url, login, password);
    
    }   catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public Connection getConnexion()
   {
     return this.connexion;
    }
    public static DataSource getInstance()
    {
    if(instance==null)
    {
    instance = new DataSource();
    }
    return instance;
    }
    
}

