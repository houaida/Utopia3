<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Admin;
import allforkids.entite.Covoiturage;
import allforkids.entite.Enfant;
import allforkids.entite.Parent;
import allforkids.entite.Quiz;
import allforkids.entite.UQuiz;
import allforkids.entite.User;
import allforkids.service.AdminService;
import allforkids.service.CovoiturageService;
import allforkids.service.ParentService;
import allforkids.service.QuizService;
import allforkids.service.UQuizService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
//import com.twilio.rest.api.v2010.account.message.Media;
import javafx.scene.media.Media ; 
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Scene;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

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

import javafx.stage.Stage;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;


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
    private ToggleButton clubs;
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
    private ToggleButton param1;
    @FXML
    private ToggleButton param2;
    @FXML
    private AnchorPane Param;
    @FXML
    private ToggleButton Compte;
    @FXML
    private ToggleButton Deco;
    @FXML
    private ToggleButton Montant;
    @FXML
    private ImageView flou;
    @FXML
    private AnchorPane anCompte;
    @FXML
    private JFXTextField Tpseudo;
    @FXML
    private JFXPasswordField Amdp;
    @FXML
    private JFXPasswordField Nmdp;
    @FXML
    private JFXButton annul;
    @FXML
    private JFXButton enregistrer;
    @FXML
    private ToggleButton fermer;
    @FXML
    private Label lbMontant;
    @FXML
    private AnchorPane anMontant;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private ToggleButton fermer1;
    @FXML
    private ToggleButton triangle;
    @FXML
    private ToggleButton triangle1;
    @FXML
    private ImageView Tparam;
    @FXML
    private ToggleButton fleche21;
    @FXML
    private ToggleButton fleche11;
    @FXML
    private AnchorPane AnRes;
@FXML
    private void changer2(ActionEvent event) {
       /*
        imgView.setImage(new Image("file:/C:/wamp/www/ressources/garderie1.jpg"));
       

        imgView1.setImage(new Image("file:/C:/wamp/www/ressources/boutique1.jpg"));
         imgView2.setImage(new Image("file:/C:/wamp/www/ressources/event1.jpg"));
     bt1.setDisable(true);

      /*  imgView1.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/boutique1.jpg"));
         imgView2.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/event1.jpg"));*/
     bt1.setDisable(true);
     bt.setDisable(false);
    }
    @FXML
    private void changer1(ActionEvent event) {

       
          /*imgView.setImage(new Image("file:/C:/wamp/www/ressources/garderie2.jpg"));
         imgView1.setImage(new Image("file:/C:/wamp/www/ressources/boutique2.jpg"));
   imgView2.setImage(new Image("file:/C:/wamp/www/ressources/event2.jpg"));
    bt1.setDisable(false);*/

       /*
          imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/garderie2.jpg"));
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

       



        //imgView.setImage(new Image("file:/C:/wamp/www/ressources/garderie1.jpg"));

    //imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/garderie1.jpg"));

       
      /* imgView1.setImage(new Image("file:/C:/wamp/www/ressources/boutique1.jpg"));
         imgView2.setImage(new Image("file:/C:/wamp/www/ressources/event1.jpg"));
     bt1.setDisable(true);
     bt.setDisable(false);*/
     

     //String Vurl="file:/C:/wamp/www/ressources/video.mp4";

       /* imgView.setImage(new Image("file:/C:/wamp/www/ressources/garderie1.jpg"));
        imgView1.setImage(new Image("file:/C:/wamp/www/ressources/boutique1.jpg"));
         imgView2.setImage(new Image("file:/C:/wamp/www/ressources/event1.jpg"));*/


    /*String Vurl="file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/video.mp4";

    // String Vurl="file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/video.mp4";


        imgView.setImage(new Image("file:/C:/Users/user/Desktop/3A5/FinalAllforkids/Utopia3/AllForKids/src/allforkids/GUI/img/hodahadher/garderie1.jpg"));
        imgView1.setImage(new Image("file:/C:/Users/user/Desktop/3A5/FinalAllforkids/Utopia3/AllForKids/src/allforkids/GUI/img/hodahadher/boutique1.jpg"));
         imgView2.setImage(new Image("file:/C:/Users/user/Desktop/3A5/FinalAllforkids/Utopia3/AllForKids/src/allforkids/GUI/img/hodahadher/event1.jpg"));

     bt1.setDisable(true);
     bt.setDisable(false);*/
     

    // String Vurl="file:/C:/Users/user/Desktop/3A5/FinalAllforkids/Utopia3/AllForKids/src/allforkids/GUI/img/hodahadher/video.mp4";


     //String Vurl="file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/video.mp4";

    // String Vurl="file:/C:/Users/user/Desktop/3A5/FinalAllforkids/Utopia3/AllForKids/src/allforkids/GUI/img/hodahadher/video.mp4";


/*        Media media = new Media(Vurl);
     MediaPlayer mediaplayer=new MediaPlayer(media);
     video.setFitHeight(400);
     video.setFitWidth(700);
     video.setMediaPlayer(mediaplayer);

      mediaplayer.setAutoPlay(true);

     /*String urlv = "file:/C:/Users/pacha/Videos/fifa-world-cup-russia-2018-official-video.mp4";
        media = new Media(urlv);
        mediaPlayer = new MediaPlayer(media);
        view.setFitHeight(600);
        view.setFitWidth(400);
        view.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);*/


     // mediaplayer.setAutoPlay(true);*/

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
    private void clubs(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Clubs.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    private void evenements(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Evenements.fxml"));
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
   
    private void Demandes(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("demande.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void ListeOffre(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("OffreParentFront.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void ConseilsGoogle(ActionEvent event) {
    }

    @FXML
    private void Evaluation(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Evaluation.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void onclickCov(ActionEvent event)throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Cov.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void gotoPaint(ActionEvent event) throws IOException {
          AnchorPane1.setPrefSize(600,600);
                 Stage stage = new Stage();
                     //  ((Node) event.getSource()).getScene().getWindow().hide();
                        javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("Paint.fxml"));
                        Scene scene = new Scene(root);

                        

                        stage.setScene(scene);
                        stage.show();
    }

    @FXML
    private void parametrage(ActionEvent event) {
        Param.setVisible(true);
        param1.setVisible(false);
        param2.setVisible(true);
         Tparam.setVisible(true);
        triangle.setVisible(true);
        triangle1.setVisible(false);
    }

@FXML
    private void parametrage2(ActionEvent event) {
        Param.setVisible(false);
        param2.setVisible(false);
        param1.setVisible(true);
        Tparam.setVisible(false);
        triangle.setVisible(false);
        triangle1.setVisible(true);
       
    }

   

    @FXML
    private void Compte(ActionEvent event) {
       flou.setVisible(true);
       anCompte.setVisible(true);
        System.out.println("pseudo:"+AuthentificationController.LoggedParent.getPseudo());
        Tpseudo.setText(AuthentificationController.LoggedParent.getPseudo());
        Tpseudo.setDisable(true);
        Tparam.setVisible(false);
       Param.setVisible(false);
    }

   @FXML
    public void CompteCouleur1(){
    Compte.setTextFill(Color.WHITE);
    }
    @FXML
    public void CompteCouleur2(){
    Compte.setTextFill(Color.BLUE);
    }
    @FXML
     public void DecoCouleur1(){
    Deco.setTextFill(Color.WHITE);
    }
    @FXML
    public void DecoCouleur2(){
    Deco.setTextFill(Color.BLUE);
    }
    @FXML
     public void MontantCouleur1(){
    Montant.setTextFill(Color.WHITE);
    }
    @FXML
    public void MontantCouleur2(){
    Montant.setTextFill(Color.BLUE);
    }

    @FXML
private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) Deco.getScene().getWindow();
    // do what you have to do
    stage.close();
}

    @FXML
    private void Montant(ActionEvent event) {
        flou.setVisible(true);
        anMontant.setVisible(true);
        Param.setVisible(false);
        Tparam.setVisible(false);
    }

    @FXML
    private void annul(ActionEvent event) {
         flou.setVisible(false);
       anCompte.setVisible(false);
       Tparam.setVisible(true);
       Param.setVisible(true);
    }

    @FXML
    private void enregistrer(ActionEvent event) {
       
       
        if(Amdp.getText().equals(AuthentificationController.LoggedParent.getMdp())){
        Parent a= new Parent(AuthentificationController.LoggedParent.getId_user(),AuthentificationController.LoggedParent.getPseudo(),Nmdp.getText(),AuthentificationController.LoggedParent.getEmail());
        ParentService as=new ParentService();
        as.update(a);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Sécurité");
            alert.setHeaderText("Votre mot de passe a été changé");
            Optional<ButtonType> result = alert.showAndWait();
        Tpseudo.clear();
        Amdp.clear();
            Nmdp.clear();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Mot de passe");
            alert.setHeaderText("Mot de passe incorrecte");
            Optional<ButtonType> result = alert.showAndWait();
            Amdp.clear();
            Nmdp.clear();
        }
    }

    @FXML
    private void fermer(ActionEvent event) {
        flou.setVisible(false);
       anCompte.setVisible(false);
       Tparam.setVisible(true);
       Param.setVisible(true);
       
    }

    @FXML
    private void voirMontant(ActionEvent event) {
        if(pass.getText().equals(AuthentificationController.LoggedParent.getMdp())){
        lbMontant.setText("Cher parent votre montant est : "+AuthentificationController.LoggedParent.getMontant()+"Dt");
        
        }
        else{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Sécurité");
            alert.setHeaderText("mot de passe incorrecte");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @FXML
    private void fermer2(ActionEvent event) {
        flou.setVisible(false);
        anMontant.setVisible(false);
        Tparam.setVisible(true);
       Param.setVisible(true);
    }

    @FXML
    private void quiz(ActionEvent event) throws IOException {
        QuizService qs=new QuizService();
      Quiz  q=null;
        q=qs.findbyEtat(1);
        UQuizService uqs=new UQuizService();
        UQuiz uq=null;
        uq=uqs.findbyId(AuthentificationController.LoggedParent.getId_user(), q.getId_quiz());
        if(uq!=null){
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Quiz");
            alert.setHeaderText("Vous avez déjà tenté votre chance ,essayez demain avec un nouveau quiz");
            Optional<ButtonType> result = alert.showAndWait();
        }else{
       if(q!=null){
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Quiz.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);}
             else {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Quiz");
            alert.setHeaderText("désolé mais aujourd'hui y a pas de quiz");
            Optional<ButtonType> result = alert.showAndWait();
           
    }
        }
    
    

    }

    @FXML
    private void notification(ActionEvent event) {
       
       // System.out.println("Click mee!!");
       CovoiturageService cs= new CovoiturageService();
       ObservableList<Covoiturage> listeC=cs.getAll();
       for(Covoiturage c:listeC){
           ParentService ps=new ParentService();
           
           Parent p=ps.search(c.getId_user());
        Notifications.create()
                .title("L'utilisateur "+p.getNom()+" a  ajouté un covoiturage")
                .text("Destination "+c.getDestination()).position(Pos.TOP_RIGHT)
                .showInformation();
       }
    }

    @FXML
    private void bus(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Moyen.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void aff1R(ActionEvent event) {
    AnRes.setVisible(true);
        fleche21.setVisible(false);
        fleche11.setVisible(true);
    }

    @FXML
    private void aff2R(ActionEvent event) {
        AnRes.setVisible(false);
        fleche21.setVisible(true);
        fleche11.setVisible(false);
    }

    @FXML
    private void ApprouverRes(ActionEvent event) throws IOException {
          CovoiturageService ps = new CovoiturageService() ; 
          Covoiturage lp = null;
                  lp=ps.search2(AuthentificationController.LoggedParent.getId_user());
          if(lp!=null){
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeReservation.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);}
            else{
              Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ATTENTION");
            alert.setHeaderText("vous n'avez pas un covoiturage pour le gérer");
            Optional<ButtonType> result = alert.showAndWait();
          
          }
    }
    

    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Admin;
import allforkids.entite.Covoiturage;
import allforkids.entite.Enfant;
import allforkids.entite.Parent;
import allforkids.entite.Quiz;
import allforkids.entite.UQuiz;
import allforkids.entite.User;
import allforkids.service.AdminService;
import allforkids.service.CovoiturageService;
import allforkids.service.ParentService;
import allforkids.service.QuizService;
import allforkids.service.UQuizService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
//import com.twilio.rest.api.v2010.account.message.Media;
import javafx.scene.media.Media ; 
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Scene;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javafx.stage.Stage;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.controlsfx.control.Notifications;
import org.opencv.core.Core;


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
    private ToggleButton clubs;
    @FXML
    private ToggleButton evenements;
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
    private ToggleButton param1;
    @FXML
    private ToggleButton param2;
    @FXML
    private AnchorPane Param;
    @FXML
    private ToggleButton Compte;
    @FXML
    private ToggleButton Deco;
    @FXML
    private ToggleButton Montant;
    @FXML
    private ImageView flou;
    @FXML
    private AnchorPane anCompte;
    @FXML
    private JFXTextField Tpseudo;
    @FXML
    private JFXPasswordField Amdp;
    @FXML
    private JFXPasswordField Nmdp;
    @FXML
    private JFXButton annul;
    @FXML
    private JFXButton enregistrer;
    @FXML
    private ToggleButton fermer;
    @FXML
    private Label lbMontant;
    @FXML
    private AnchorPane anMontant;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private ToggleButton fermer1;
    @FXML
    private ToggleButton triangle;
    @FXML
    private ToggleButton triangle1;
    @FXML
    private ImageView Tparam;
@FXML
    private void changer2(ActionEvent event) {
       
        imgView.setImage(new Image("file:/C:/wamp/www/ressources/garderie1.jpg"));
       

        imgView1.setImage(new Image("file:/C:/wamp/www/ressources/boutique1.jpg"));
         imgView2.setImage(new Image("file:/C:/wamp/www/ressources/event1.jpg"));
     bt1.setDisable(true);

      /*  imgView1.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/boutique1.jpg"));
         imgView2.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/event1.jpg"));*/
     bt1.setDisable(true);
     bt.setDisable(false);
    }
    @FXML
    private void changer1(ActionEvent event) {

       
          imgView.setImage(new Image("file:/C:/wamp/www/ressources/garderie2.jpg"));
         imgView1.setImage(new Image("file:/C:/wamp/www/ressources/boutique2.jpg"));
   imgView2.setImage(new Image("file:/C:/wamp/www/ressources/event2.jpg"));
    bt1.setDisable(false);

       /*
          imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/garderie2.jpg"));
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
 System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
       



        imgView.setImage(new Image("file:/C:/wamp/www/ressources/garderie1.jpg"));

    //imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/garderie1.jpg"));

       
       imgView1.setImage(new Image("file:/C:/wamp/www/ressources/boutique1.jpg"));
         imgView2.setImage(new Image("file:/C:/wamp/www/ressources/event1.jpg"));
     bt1.setDisable(true);
     bt.setDisable(false);
     

     String Vurl="file:/C:/wamp/www/ressources/video.mp4";

        imgView.setImage(new Image("file:/C:/wamp/www/ressources/garderie1.jpg"));
        imgView1.setImage(new Image("file:/C:/wamp/www/ressources/boutique1.jpg"));
         imgView2.setImage(new Image("file:/C:/wamp/www/ressources/event1.jpg"));


    /*String Vurl="file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/video.mp4";

    // String Vurl="file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/video.mp4";


        imgView.setImage(new Image("file:/C:/Users/user/Desktop/3A5/FinalAllforkids/Utopia3/AllForKids/src/allforkids/GUI/img/hodahadher/garderie1.jpg"));
        imgView1.setImage(new Image("file:/C:/Users/user/Desktop/3A5/FinalAllforkids/Utopia3/AllForKids/src/allforkids/GUI/img/hodahadher/boutique1.jpg"));
         imgView2.setImage(new Image("file:/C:/Users/user/Desktop/3A5/FinalAllforkids/Utopia3/AllForKids/src/allforkids/GUI/img/hodahadher/event1.jpg"));

     bt1.setDisable(true);
     bt.setDisable(false);*/
     

    // String Vurl="file:/C:/Users/user/Desktop/3A5/FinalAllforkids/Utopia3/AllForKids/src/allforkids/GUI/img/hodahadher/video.mp4";


     //String Vurl="file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/hodahadher/video.mp4";

    // String Vurl="file:/C:/Users/user/Desktop/3A5/FinalAllforkids/Utopia3/AllForKids/src/allforkids/GUI/img/hodahadher/video.mp4";


        Media media = new Media(Vurl);
     MediaPlayer mediaplayer=new MediaPlayer(media);
     video.setFitHeight(400);
     video.setFitWidth(700);
     video.setMediaPlayer(mediaplayer);

      mediaplayer.setAutoPlay(true);

     /*String urlv = "file:/C:/Users/pacha/Videos/fifa-world-cup-russia-2018-official-video.mp4";
        media = new Media(urlv);
        mediaPlayer = new MediaPlayer(media);
        view.setFitHeight(600);
        view.setFitWidth(400);
        view.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);*/


     // mediaplayer.setAutoPlay(true);*/

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
    private void clubs(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Clubs.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    @FXML
    private void evenements(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Evenements.fxml"));
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
   
    private void Demandes(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("demande.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void ListeOffre(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("OffreParentFront.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void ConseilsGoogle(ActionEvent event) {
    }

    @FXML
    private void Evaluation(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Evaluation.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void onclickCov(ActionEvent event)throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Cov.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void gotoPaint(ActionEvent event) throws IOException {
          AnchorPane1.setPrefSize(600,600);
                 Stage stage = new Stage();
                     //  ((Node) event.getSource()).getScene().getWindow().hide();
                        javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("Paint.fxml"));
                        Scene scene = new Scene(root);

                        

                        stage.setScene(scene);
                        stage.show();
    }

    @FXML
    private void parametrage(ActionEvent event) {
        Param.setVisible(true);
        param1.setVisible(false);
        param2.setVisible(true);
         Tparam.setVisible(true);
        triangle.setVisible(true);
        triangle1.setVisible(false);
    }

@FXML
    private void parametrage2(ActionEvent event) {
        Param.setVisible(false);
        param2.setVisible(false);
        param1.setVisible(true);
        Tparam.setVisible(false);
        triangle.setVisible(false);
        triangle1.setVisible(true);
       
    }

   

    @FXML
    private void Compte(ActionEvent event) {
       flou.setVisible(true);
       anCompte.setVisible(true);
        System.out.println("pseudo:"+AuthentificationController.LoggedParent.getPseudo());
        Tpseudo.setText(AuthentificationController.LoggedParent.getPseudo());
        Tpseudo.setDisable(true);
        Tparam.setVisible(false);
       Param.setVisible(false);
    }

   @FXML
    public void CompteCouleur1(){
    Compte.setTextFill(Color.WHITE);
    }
    @FXML
    public void CompteCouleur2(){
    Compte.setTextFill(Color.BLUE);
    }
    @FXML
     public void DecoCouleur1(){
    Deco.setTextFill(Color.WHITE);
    }
    @FXML
    public void DecoCouleur2(){
    Deco.setTextFill(Color.BLUE);
    }
    @FXML
     public void MontantCouleur1(){
    Montant.setTextFill(Color.WHITE);
    }
    @FXML
    public void MontantCouleur2(){
    Montant.setTextFill(Color.BLUE);
    }

    @FXML
private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) Deco.getScene().getWindow();
    // do what you have to do
    stage.close();
}

    @FXML
    private void Montant(ActionEvent event) {
        flou.setVisible(true);
        anMontant.setVisible(true);
        Param.setVisible(false);
        Tparam.setVisible(false);
    }

    @FXML
    private void annul(ActionEvent event) {
         flou.setVisible(false);
       anCompte.setVisible(false);
       Tparam.setVisible(true);
       Param.setVisible(true);
    }

    @FXML
    private void enregistrer(ActionEvent event) {
       
       
        if(Amdp.getText().equals(AuthentificationController.LoggedParent.getMdp())){
        Parent a= new Parent(AuthentificationController.LoggedParent.getId_user(),AuthentificationController.LoggedParent.getPseudo(),Nmdp.getText(),AuthentificationController.LoggedParent.getEmail());
        ParentService as=new ParentService();
        as.update(a);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Sécurité");
            alert.setHeaderText("Votre mot de passe a été changé");
            Optional<ButtonType> result = alert.showAndWait();
        Tpseudo.clear();
        Amdp.clear();
            Nmdp.clear();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Mot de passe");
            alert.setHeaderText("Mot de passe incorrecte");
            Optional<ButtonType> result = alert.showAndWait();
            Amdp.clear();
            Nmdp.clear();
        }
    }

    @FXML
    private void fermer(ActionEvent event) {
        flou.setVisible(false);
       anCompte.setVisible(false);
       Tparam.setVisible(true);
       Param.setVisible(true);
       
    }

    @FXML
    private void voirMontant(ActionEvent event) {
        if(pass.getText().equals(AuthentificationController.LoggedParent.getMdp())){
        lbMontant.setText("Cher parent votre montant est : "+AuthentificationController.LoggedParent.getMontant()+"Dt");
        
        }
        else{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Sécurité");
            alert.setHeaderText("mot de passe incorrecte");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @FXML
    private void fermer2(ActionEvent event) {
        flou.setVisible(false);
        anMontant.setVisible(false);
        Tparam.setVisible(true);
       Param.setVisible(true);
    }

    @FXML
    private void quiz(ActionEvent event) throws IOException {
        QuizService qs=new QuizService();
      Quiz  q=null;
        q=qs.findbyEtat(1);
        UQuizService uqs=new UQuizService();
        UQuiz uq=null;
        uq=uqs.findbyId(AuthentificationController.LoggedParent.getId_user(), q.getId_quiz());
        if(uq!=null){
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Quiz");
            alert.setHeaderText("Vous avez déjà tenté votre chance ,essayez demain avec un nouveau quiz");
            Optional<ButtonType> result = alert.showAndWait();
        }else{
       if(q!=null){
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Quiz.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);}
             else {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Quiz");
            alert.setHeaderText("désolé mais aujourd'hui y a pas de quiz");
            Optional<ButtonType> result = alert.showAndWait();
           
    }
        }
    
    

    }

    @FXML
    private void notification(ActionEvent event) {
       
       // System.out.println("Click mee!!");
       CovoiturageService cs= new CovoiturageService();
       ObservableList<Covoiturage> listeC=cs.getAll();
       for(Covoiturage c:listeC){
           ParentService ps=new ParentService();
           
           Parent p=ps.search(c.getId_user());
        Notifications.create()
                .title("L'utilisateur "+p.getNom()+" a  ajouté un covoiturage")
                .text("Destination "+c.getDestination()).position(Pos.TOP_RIGHT)
                .showInformation();
       }
    }

   
    @FXML
    private void capture(ActionEvent event) throws IOException {
             Stage primaryStage=new Stage();
              // load the FXML resource
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Capture.fxml"));
			// store the root element so that the controllers can use it
			     BorderPane rootElement = (BorderPane) loader.load();
			// create and style a scene
			//
                        Scene scene = new Scene(rootElement, 800, 600);
			// create the stage with the given title and the previously created
			// scene
			primaryStage.setTitle("Photo");
			primaryStage.setScene(scene);
			// show the GUI
			primaryStage.show();
			
			// set the proper behavior on closing the application
			CaptureController controller = loader.getController();
			primaryStage.setOnCloseRequest((new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we)
				{
					controller.setClosed();
				}
			}));
		
    }
    

    
}
>>>>>>> 3049ec7efcded067c6bf369cc60623cf3a057d93
