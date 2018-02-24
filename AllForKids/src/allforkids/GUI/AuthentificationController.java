/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import Browser.Browser;
import static allforkids.GUI.AuthentificationController.LoggedUser;
import allforkids.entite.Admin;
import allforkids.entite.Babysitter;
import allforkids.entite.Enseignant;
import allforkids.entite.Parent;
import allforkids.entite.ProprietaireG;
import allforkids.entite.ProprietaireJ;
import allforkids.entite.User;
import allforkids.service.AdminService;
import static allforkids.service.AdminService.LoggedUser;
import allforkids.service.Email;
import allforkids.service.EnseignantService;
import allforkids.service.ParentService;
import allforkids.service.ProprietaireGService;
import allforkids.service.ProprietaireJService;
import allforkids.service.UserService;
import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class AuthentificationController implements Initializable {

@FXML
    private AnchorPane AnchorPane1;
@FXML
    public TextField tfPseudo;
@FXML
    private PasswordField tfMdp;


public static Parent LoggedParent;
public static ProprietaireG LoggedProprietaireG;
public static Enseignant LoggedEnseignant;
public static ProprietaireJ LoggedProprietaireJ;
public static Babysitter LoggedBabysitter;
public static User LoggedUser;
public static Admin LoggedAdmin;
    @FXML
    private Button btn;
    @FXML
    private Label mdp;
    @FXML
    private AnchorPane an2;
    @FXML
    private AnchorPane anMail;
    @FXML
    private TextField tfmail;
    @FXML
    private Button annuler;
    @FXML
    private AnchorPane an3;
    @FXML
    private Label pseudo;
    @FXML
    private TextField mail;
    @FXML
    private ImageView img;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    
    @FXML
    public void Education() throws SQLException, IOException{
      
       AdminService ips = new AdminService();
       // System.out.println(ips.search(a));
       
       // System.out.println(tfPseudo.getText()+tfMdp.getText());
       String pseudo=tfPseudo.getText();
     String mdp=tfMdp.getText();
     User u=ips.Login(pseudo);
     
                  
   if (u.getMdp().equals(mdp)){
            System.out.println(pseudo);
                
             String type=  u.getType();
      System.out.println(type);
          if(type.equals("parent")){
              
                LoggedParent = new Parent();
                LoggedParent.setId_user(u.getId_user());
       System.out.println(u);
           /* AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilParent.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);*/
            AnchorPane1.setPrefSize(1329,866);
                 Stage stage = new Stage();
                     //  ((Node) event.getSource()).getScene().getWindow().hide();
                        javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("AccueilParent.fxml"));
                        Scene scene = new Scene(root);

                        

                        stage.setScene(scene);
                        stage.show();

        

              }
          else if(type.equals("enseignant")){
           LoggedEnseignant = new Enseignant();
                LoggedEnseignant.setId_user(u.getId_user());
                
      // System.out.println(u);
        System.out.println(tfPseudo.getText());
       
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionEvaluation.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
         

    }
        
          else if(type.equals("admin")){
        System.out.println(tfPseudo.getText());
             
                LoggedAdmin = new Admin();
                LoggedAdmin.setId_user(u.getId_user());
                LoggedAdmin.setPseudo(u.getPseudo());
                LoggedAdmin.setImage(u.getImage());
                AnchorPane1.setPrefSize(1329,866);
                 Stage stage = new Stage();
                     //  ((Node) event.getSource()).getScene().getWindow().hide();
                        javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("AccueilAdmin.fxml"));
                        Scene scene = new Scene(root);

                        

                        stage.setScene(scene);
                        stage.show();
                        
            /*AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilAdmin.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
         */

       
    
    }
                    else if(type.equals("babysitter")){
                        LoggedBabysitter = new Babysitter();
                LoggedBabysitter.setId_user(u.getId_user());
       //System.out.println(u.getId_user());
       // System.out.println(tfPseudo.getText());
             
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilGeneral.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
         

       
    
    }
          
                    else if(type.equals("proprietaireg")){
                        LoggedProprietaireG = new ProprietaireG();
               LoggedProprietaireG.setId_user(u.getId_user());
       //System.out.println(u.getId_user());
       // System.out.println(tfPseudo.getText());
             
           /* AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionGarderie.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);*/
       Stage stage = new Stage();
                     //  ((Node) event.getSource()).getScene().getWindow().hide();
                        javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("GestionGarderie.fxml"));
                        Scene scene = new Scene(root);

                        

                        stage.setScene(scene);
                        stage.show();
    
    }
             else if(type.equals("proprietairej")){
                        LoggedProprietaireJ = new ProprietaireJ();
               LoggedProprietaireJ.setId_user(u.getId_user());
               System.out.println("id:"+LoggedProprietaireJ.getId_user());
       //System.out.println(u.getId_user());
       // System.out.println(tfPseudo.getText());
             
            /*AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionJardin.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
       */
     Stage stage = new Stage();
                     //  ((Node) event.getSource()).getScene().getWindow().hide();
                        javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("GestionJardin.fxml"));
                        Scene scene = new Scene(root);

                        

                        stage.setScene(scene);
                        stage.show();
    }
    }
   
    if (!u.getMdp().equals(mdp))
    {
    
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Authentification ");
            alert.setHeaderText("vérifiez vos parametres");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                 tfPseudo.clear();
        tfMdp.clear();
       
    }
   if (result.get() == ButtonType.CANCEL) {
       try {
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("accueil.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

        } catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
   }
   }}

    @FXML
    private void inscrire(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("InscriptionUser.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    @FXML
 public void changerStyle()
 {
  mdp.setTextFill(Color.BLUE);
 }
    @FXML
 public void PARAMMDP(){
     an2.setVisible(false);
  anMail.setVisible(true);
  an3.setVisible(false);
 }

    @FXML
    private void retour(ActionEvent event) {
        an2.setVisible(true);
  anMail.setVisible(false);
  an3.setVisible(false);
    }
public static String adress;
public static String motdepasse;
    @FXML
    private void continuer(ActionEvent event) {
    
        Email emailS = new Email();
        
        String[] to = {adress};
        /*from = "Tunisia Mall administration";
             subject = "This is confirmation number for your expertprogramming account. Please insert this number to activate your account.";
            String messageText = "Bonjour, félicitation nous avons pris votre demande d'emploi en considération et vous êtes accepté pour ce poste\n Responsable ";
         */
        String adresse = "espritmail2@gmail.com";
        System.out.println(adresse);
        String subject = "AllForKids";
        String messageText = "Bonjour, notre cher utilisateur vous avez réclamez que vous avez oubliez votre mot de passe et afin de continuer d'utiliser votre compte AllForKids, on vous accorde votre mot de passe qui est le suivant : "+motdepasse ;

        if (emailS.sendMail(adresse,"Esprit15", messageText, subject, to)) {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //alert.initOwner(adresse.getScene().getWindow());
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Email Envoyer Avec Succées ");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
 an2.setVisible(true);
  anMail.setVisible(false);
  an3.setVisible(false);
            }
        });}

    }

    @FXML
    private void annuler(ActionEvent event) {
        an2.setVisible(false);
  anMail.setVisible(true);
  an3.setVisible(false);
    }
public static Image image1=null;
    @FXML
    private void rechercher(ActionEvent event) {
        UserService us=new UserService();
        String Mail=tfmail.getText();
        User u=null;
         u=us.findbyMail(Mail);
        if(u==null) {Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Mail introuvable");
            alert.setHeaderText("veuillez vérifiez votre mail");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                an2.setVisible(false);
  anMail.setVisible(true);
  an3.setVisible(false);
            }}
        else if(!u.equals(null)){
         an2.setVisible(false);
  anMail.setVisible(false);
  an3.setVisible(true);
  
  String m=u.getEmail();
        System.out.println(m);

  mail.setText(u.getEmail());
  adress=u.getEmail();
  motdepasse=u.getMdp();
  pseudo.setText(u.getPseudo());
        if(u.getType().equals("parent")){
        ParentService ps=new ParentService();
        Parent p=ps.findbyMail(Mail);
        
        Image image1 = new Image(p.getImage());
        //final Circle clip = new Circle(50, 40, 40);
        //img.setClip(clip); 
        img.setImage(image1);
        
            
        
        }
          else if(u.getType().equals("enseignant")){
        EnseignantService ps=new EnseignantService();
        Enseignant p=ps.findbyMail(Mail);
         
        Image image1 = new Image(p.getImage());
        final Circle clip = new Circle(50, 40, 40);
        img.setClip(clip); 
            img.setImage(image1);
        
        }
        else if(u.getType().equals("proprietaireg")){
        ProprietaireGService ps=new ProprietaireGService();
        ProprietaireG p=ps.findbyMail(Mail);
         
        Image image1 = new Image(p.getImage());
        final Circle clip = new Circle(50, 40, 40);
        img.setClip(clip); 
            img.setImage(image1);
        
        }
          else if(u.getType().equals("proprietairej")){
        ProprietaireJService ps=new ProprietaireJService();
        ProprietaireJ p=ps.findbyMail(Mail);
         
        Image image1 = new Image(p.getImage());
        final Circle clip = new Circle(50, 40, 40);
        img.setClip(clip); 
            img.setImage(image1);
        
        }
        }

    }

    @FXML
    private void google(ActionEvent event) {
                Browser.load("http://www.google.com", new Dimension(1329, 866), new Point(30, 20));

    }
   
    
}
