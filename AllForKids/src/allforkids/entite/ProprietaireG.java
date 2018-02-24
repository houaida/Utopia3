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
public class ProprietaireG extends User{
    private String image;
    public ProprietaireG(int id_user, String pseudo, String mdp, String email,String image) {
        super(id_user, pseudo, mdp, email);
        this.image=image;
    }
     public ProprietaireG(int id_user, String pseudo, String mdp, String email) {
        super(id_user, pseudo, mdp, email);
        
    }
   
    public ProprietaireG(int id_user, String pseudo, String mdp, String email,String type,String image) {
        super(id_user, pseudo, mdp, email,type);
        this.image=image;
    }
   
public ProprietaireG( String pseudo, String mdp, String email,String type,String image) {
        super( pseudo, mdp, email,type);
        this.image=image;
    }
public ProprietaireG( String pseudo, String mdp, String email,String image) {
        super( pseudo, mdp, email);
        this.image=image;
    }

    public ProprietaireG() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
       return "ProprietaireG{" + super.toString()+ '}';
        }
    
}
