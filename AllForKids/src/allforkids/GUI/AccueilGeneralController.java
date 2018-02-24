/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import static allforkids.GUI.AuthentificationController.LoggedParent;
import static allforkids.GUI.ListeProduitsController.LoggedUser;
import allforkids.entite.Babysitter;
import allforkids.entite.Produit;
import allforkids.entite.User;
import allforkids.service.AdminService;
import allforkids.service.BabysitterService;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.walk;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.animation.TranslateTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class AccueilGeneralController implements Initializable {
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ImageView imgView;
    @FXML
    private ImageView imgView1;
    @FXML
    private ImageView imgView2;
   
    @FXML
    private ToggleButton bt1;
    @FXML
    private ToggleButton bt;
    @FXML
    private AnchorPane bt2;
    @FXML
    private ToggleButton retire;
    @FXML
    private TextField id_user;
    
  


 

    /**
     * Initializes the controller class.
     */
   
    @FXML
    private void changer2(ActionEvent event) {
       
        imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/enfant.jpg"));
       
        imgView1.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/garderie.jpg"));
         imgView2.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/children-4.jpg"));
     bt1.setDisable(true);
     bt.setDisable(false);
    }
    @FXML
    private void changer1(ActionEvent event) {
       
          imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/1.jpg"));
         imgView1.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/2.jpg"));
   imgView2.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/3.jpg"));
    bt1.setDisable(false);
     bt.setDisable(true);
    }
      
    @FXML
    private void afficher(ActionEvent event) {
       AnchorPane2.setVisible(true);
       retire.setVisible(true);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

       

         imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/enfant.jpg"));
         imgView1.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/garderie.jpg"));
         imgView2.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/children-4.jpg"));
    bt1.setDisable(true);
     bt.setDisable(false);
    }

    

    @FXML
    private void retirer(ActionEvent event) {
        AnchorPane2.setVisible(false);
        retire.setVisible(false);
    }

    @FXML
    private void changer2(MouseEvent event) {
    }

    @FXML
    private void gotoDemandeTravail(MouseEvent event) throws IOException {
    
        bt2.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("demandeTravail.fxml"));
            bt2.getChildren().add(newLoadedPane);
    }

}
    

