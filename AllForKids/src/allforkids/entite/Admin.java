/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

/**
 *
 * @author MacBook
 */
public class Admin extends User{
    public Admin(int id_user, String pseudo, String mdp, String email) {
        super(id_user, pseudo, mdp, email);
    }
   
    public Admin(int id_user, String pseudo, String mdp, String email,String type) {
        super(id_user, pseudo, mdp, email,type);
    }
   public Admin(int id_user, String pseudo, String mdp, String email,String type,String image) {
        super(id_user, pseudo, mdp, email,type,image);
    }
   
public Admin( String pseudo, String mdp, String email,String type) {
        super( pseudo, mdp, email,type);
    }
public Admin( String pseudo, String mdp, String email) {
        super( pseudo, mdp, email);
    }

    public Admin() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
       return "Admin{" + super.toString()+ '}';
        }
    
}