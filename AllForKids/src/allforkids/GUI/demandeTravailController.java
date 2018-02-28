/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Babysitter;
import allforkids.entite.demandetravail;
import allforkids.service.BabysitterService;
import allforkids.service.demande_travailService;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.opencv.core.Core;

/**
 * FXML Controller class
 *
 * @author user
 */
public class demandeTravailController implements Initializable {

    @FXML
    private TextField tnom1;
    @FXML
    private TextField id_user;
    private AnchorPane AnchorPane;
    @FXML
    private TextField tadresse;
    @FXML
    private TextField tprenom;
    @FXML
    private TextField tnum_tel;
    @FXML
    private TextField tmail;
    @FXML
    private DatePicker tdate_naissance;
    private ComboBox<String> langue;
    @FXML
    private ComboBox<String> tlangue;
    @FXML
    private TextField tetude;
    @FXML
    private TextField tposte;
    @FXML
    private TextField path;
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ToggleButton retire;
    private ToggleButton fleche2;
    private ToggleButton fleche1;
    private BorderPane anB;
    @FXML
    private Button btretour;

 
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        try {     
        ObservableList<String> ol = FXCollections.observableArrayList();
        ol.add("Francais") ; 
        ol.add("Anglais") ; 
        ol.add("Espagnol") ;
        ol.add("Allemand") ;
        ol.add("Turc") ;
        ol.add("Japonais") ;
        ol.add("Italien") ;

        tlangue.setItems(ol);
            affichage();
            // T
            
            //   
        } catch (ParseException ex) {
            Logger.getLogger(demandeTravailController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    private void affichage() throws ParseException {
      
        BabysitterService as=BabysitterService.getInstance();
        Babysitter b=  as.search(AuthentificationController.LoggedBabysitter.getId_user());
        tnom1.setDisable(true);
        tadresse.setDisable(true);
        tdate_naissance.setDisable(true);
        tmail.setDisable(true);
        tnum_tel.setDisable(true);
        tprenom.setDisable(true);
     tnom1.setText(b.getNom());
    tadresse.setText(b.getAdresse());
  tmail.setText(b.getEmail());
   tnum_tel.setText(b.getNum_tel());
       tprenom.setText(b.getPrenom());
       tdate_naissance.getEditor().setText(b.getDate_naissance());
         String s="file:/C:/wamp/www/ressources/";
           path.setText(s+b.getImage());
       
       
      

              
        
        
    

    

    
    }
    @FXML

    private void ajouter(ActionEvent event) throws ParseException, IOException{
      Stage primaryStage=new Stage();
        try
		{
			
                        	
           demande_travailService Gd=new demande_travailService();
        demandetravail demande=new demandetravail(tetude.getText(),tposte.getText(),tlangue.getValue(),tnom1.getText(),tprenom.getText(),path.getText(),tnum_tel.getText());
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setHeaderText("Les demandes des sont sacrés on doit verifier votre identité.");
       Optional<ButtonType> result = alert.showAndWait();
       
        if (result.get() == ButtonType.OK){
            // load the FXML resource
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Capture.fxml"));
			// store the root element so that the controllers can use it
			BorderPane rootElement = (BorderPane) loader.load();
			// create and style a scene
			Scene scene = new Scene(rootElement, 800, 600);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// create the stage with the given title and the previously created
			// scene
			primaryStage.setTitle("Verification");
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
     Gd.insert1(demande,AuthentificationController.LoggedBabysitter.getId_user());
         
    tetude.clear();
    tposte.clear();
    tlangue.setValue(null);
    
           AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilParent.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
     
    }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

 
    }

    @FXML
    private void afficher(ActionEvent event) {
       AnchorPane2.setVisible(true);
       retire.setVisible(true);
    }
    

    @FXML
    private void gotoDemandeTravail(MouseEvent event) {
        
    }


    @FXML
    private void retirer(ActionEvent event) {
        AnchorPane2.setVisible(false);
        retire.setVisible(false);
    }

   

    @FXML
    private void demandeB(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("DemandeBabysitterFront.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void offresB(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("OffreDemande.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

     @FXML
    private void PostulerTravail(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("demandeTravail.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("OffreDemande.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
}

    

   

    
