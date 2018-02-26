/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hammamet
 */
public class ClubsController implements Initializable {

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
    private AnchorPane AnchorPane3;
    @FXML
    private JFXButton lesClubs;
    @FXML
    private JFXButton partenaire;
    @FXML
    private JFXButton galerie;
    @FXML
    private JFXButton mesClubs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    private void clubs(ActionEvent event)  throws IOException {
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
    private void lesClubs(ActionEvent event) throws IOException {
        Parent homepage_parent = FXMLLoader.load(getClass().getResource("LesClubs.fxml"));
       Scene homepage_scene= new Scene(homepage_parent);
       Stage app_stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
       app_stage.setScene(homepage_scene);
       app_stage.show();
    }
    @FXML
    private void mesClubs(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("MesClubs.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    @FXML
    private void devenirPartenaire(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("DevenirPartenaire.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    @FXML
    private void galerie(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Galerie.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
}
