/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Parent;
import allforkids.entite.User;
import allforkids.service.AdminService;
import allforkids.service.ParentService;
//import com.twilio.rest.api.v2010.account.message.Media;
import javafx.scene.media.Media ; 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author MacBook
 */

public class AccueilParentController implements Initializable {
    @FXML
    private MediaView video;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ToggleButton gestionPrduit;
    @FXML
    private ToggleButton retire;
    @FXML
    private ImageView imgView;
    @FXML
    private ToggleButton bt;
    @FXML
    private ToggleButton bt1;
    @FXML
    private ImageView imgView1;
    @FXML
    private ImageView imgView2;
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private ToggleButton fleche2;
    @FXML
    private ToggleButton fleche1;
    @FXML
    private AnchorPane anB;
@FXML
    private void changer2(ActionEvent event) {
       
        /*imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/garderie1.jpg"));
       
        imgView1.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/boutique1.jpg"));
         imgView2.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/event1.jpg"));*/
     bt1.setDisable(true);
     bt.setDisable(false);
    }
    @FXML
    private void changer1(ActionEvent event) {
       
         /* imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/garderie2.jpg"));
         imgView1.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/boutique2.jpg"));
   imgView2.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/event2.jpg"));
   */ bt1.setDisable(false);
     bt.setDisable(true);
    }
      
    @FXML
    private void afficher(ActionEvent event) {
       AnchorPane2.setVisible(true);
       retire.setVisible(true);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

       

<<<<<<< HEAD
      /*  imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/garderie1.jpg"));
       
        imgView1.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/boutique1.jpg"));
         imgView2.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/event1.jpg"));
     */bt1.setDisable(true);
     bt.setDisable(false);
     
    /* String Vurl="file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/video.mp4";
=======
        imgView.setImage(new Image("file:/C:/Users/user/Desktop/3A5/FinalAllforkids/Utopia3/AllForKids/src/allforkids/GUI/img/hodahadher/garderie1.jpg"));
        imgView1.setImage(new Image("file:/C:/Users/user/Desktop/3A5/FinalAllforkids/Utopia3/AllForKids/src/allforkids/GUI/img/hodahadher/boutique1.jpg"));
         imgView2.setImage(new Image("file:/C:/Users/user/Desktop/3A5/FinalAllforkids/Utopia3/AllForKids/src/allforkids/GUI/img/hodahadher/event1.jpg"));
     bt1.setDisable(true);
     bt.setDisable(false);
     
     String Vurl="file:/C:/Users/user/Desktop/3A5/FinalAllforkids/Utopia3/AllForKids/src/allforkids/GUI/img/hodahadher/video.mp4";
>>>>>>> 8e8aa203b9185b8f18b5a9b2e99eda9d8fad9847
        Media media = new Media(Vurl);
     MediaPlayer mediaplayer=new MediaPlayer(media);
     video.setFitHeight(400);
     video.setFitWidth(700);
     video.setMediaPlayer(mediaplayer);
<<<<<<< HEAD
      mediaplayer.setAutoPlay(true);*/
     
=======
      mediaplayer.setAutoPlay(true);

>>>>>>> 8e8aa203b9185b8f18b5a9b2e99eda9d8fad9847
    }

    

    @FXML
    private void retirer(ActionEvent event) {
        AnchorPane2.setVisible(false);
        retire.setVisible(false);
    }

    @FXML
    private void gotoDemandeTravail(MouseEvent event) {
    }

    @FXML
    private void changer2(MouseEvent event) {
    }

    @FXML
    private void boutique(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("listViewTest.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void aff1(ActionEvent event) {
        anB.setVisible(true);
        fleche2.setVisible(false);
        fleche1.setVisible(true);
    }

    @FXML
    private void aff2(ActionEvent event) {
        anB.setVisible(false);
        fleche2.setVisible(true);
        fleche1.setVisible(false);
    }

    @FXML
    private void PostulerTravail(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("demandeTravail.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void Reclamation(ActionEvent event) throws IOException {
        
           AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

   

    @FXML
    private void ServiceAllForKids(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("babysitterPersonnel.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void Offres(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("OffreDemande.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
   
    private void Demandes(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("demande.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    

    
}
