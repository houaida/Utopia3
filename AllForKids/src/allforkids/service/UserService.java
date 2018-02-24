/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Admin;
import allforkids.entite.User;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MacBook
 */
public class UserService {
     Connection connexion;
    
Statement st;
ResultSet result;
static UserService instance;
 public static UserService getInstance()
    {
    if(instance==null)
    {
    instance = new UserService();}
    return instance;
    
    }
public UserService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
  
    public User findbyMail(String s) {
        User user = null;
        String req = "select * from users where email =? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connexion.prepareStatement(req);
            preparedStatement.setString(1, s);
             result = preparedStatement.executeQuery();
            while (result.next()) {
                user = new User(result.getInt(1),result.getString(5),result.getString(6),result.getString(7),result.getString(12),result.getString(14));
                break;
            }
        } catch (SQLException ex) {
            System.out.println("mail not found ");
        }
        return user;
    }


    
}
