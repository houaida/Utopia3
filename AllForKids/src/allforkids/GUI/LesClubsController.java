/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Club;
import allforkids.service.ClubService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author hammamet
 */
public class LesClubsController implements Initializable {
public static Club LoggedParent;
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ToggleButton gestionPrduit;
    @FXML
    private ToggleButton retire;
    @FXML
    private ToggleButton clubs;
    @FXML
    private ToggleButton evenements;
    @FXML
    private JFXButton retour;
    @FXML
    private JFXTextField rechercher2;
    @FXML
    private JFXListView<Club> liste1;

    /**
     * Initializes the controller class.
     */
     
    @FXML
    private JFXButton inscriptionClub;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherClub();
        
       
       LoggedParent = new Club();
       
       liste1.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends Club> ov,  Club old_val, 
            Club new_val) -> {
                System.out.println(new_val);
        LoggedParent.setId_club(new_val.getId_club());
        LoggedParent.setNom_club(new_val.getNom_club());
        LoggedParent.setCategorie(new_val.getCategorie());
        LoggedParent.setCin_proprietaire(new_val.getCin_proprietaire()); 
        LoggedParent.setDescription(new_val.getDescription());
        LoggedParent.setImage(new_val.getImage());
        LoggedParent.setLieu(new_val.getLieu());
        LoggedParent.setEmail(new_val.getEmail());
        
            System.out.println(LoggedParent.getNom_club());
    }); 
       
       
        // TODO
    }    

    @FXML
    private void gotoDemandeTravail(MouseEvent event) {
    }
    

    @FXML
    private void boutique(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("listViewTest.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void retirer(ActionEvent event) {
    }
    
    @FXML
    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Clubs.fxml"));
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
    private void onselect(MouseEvent event) {
        if(event.getClickCount() == 2){
        try {
       
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ClubsDetails.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

        } catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
          }
        
    }

    private void afficherClub() {
         ClubService cs = ClubService.getInstance() ;
          ObservableList<Club> lc = cs.Search();
          
          
          
          liste1.setCellFactory((ListView<Club> param) -> {
              ListCell<Club> cell = new ListCell<Club>() {
    @Override
                  protected void updateItem(Club c , boolean bl) {
                      super.updateItem(c, bl);
                      if(c!=null){
                          Image img = new Image(c.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
                          setText("Nom : "+c.getNom_club()+"\n Email : "+c.getEmail()+"\n Lieu: "+c.getLieu()+"\n Description : "+c.getDescription());
                      }
                  }
              } ; return cell ;
          });
      liste1.setItems(lc);
        
    }

    @FXML
    private void rechercher2(ActionEvent event) {
        ClubService cs = ClubService.getInstance();
                String a =(rechercher2.getText()) ;
                
                
          ObservableList<Club> lc = cs.getbyPseudo1(a);
          
          
          
          liste1.setCellFactory((ListView<Club> param) -> {
              ListCell<Club> cell = new ListCell<Club>() {
    @Override
                  protected void updateItem(Club c , boolean bl) {
                      super.updateItem(c, bl);
                      if(c!=null){
                         Image img = new Image(c.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
                          setText("Nom : "+c.getNom_club()+"\n Email : "+c.getEmail()+"\n Lieu: "+c.getLieu()+"\n Description : "+c.getDescription());
                      }
                  }
              } ; return cell ;
          });
      liste1.setItems(lc);
    }

    @FXML
    private void InscriptionClub(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("InscriptionClub.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    

    
}
