/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Club;
import allforkids.entite.Membre;
import allforkids.entite.User;
import allforkids.service.ClubService;
import allforkids.service.MembreService;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author hammamet
 */
public class InscriptionClubController implements Initializable {
    

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
    private JFXComboBox<String> nomClub;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField num;
    @FXML
    private JFXButton confirmer;
    @FXML
    private JFXDatePicker dateNaissance;
    @FXML
    private JFXButton retour;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ClubService cs= ClubService.getInstance();
        try {
            nomClub.setItems(cs.fillCombo());
           
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionClubController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

       
        
        
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
    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Clubs.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void retirer(ActionEvent event) {
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
    private String nomClub(ActionEvent event) throws SQLException {
        
        ClubService cs= ClubService.getInstance();
        
        String a= nomClub.getSelectionModel().getSelectedItem();
        return a;
        
    }

   
    


    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
        MembreService ms= MembreService.getInstance();
        
       ClubService cs= ClubService.getInstance();
       int id_user= AuthentificationController.LoggedParent.getId_user();
        System.out.println("id_user====="+id_user);
       int id_club=cs.getByName(nomClub.getValue()).getId_club();
      System.out.println("id_club====="+id_club);
       int result=Integer.parseInt(num.getText());
       Membre m= new Membre(id_user,id_club,nom.getText(),prenom.getText(),result,email.getText(),dateNaissance.getEditor().getText());
      /*  m.setId_club(id_club);
        m.setId_user(id_user);
        m.setEmail_parent(email.getText());
        m.setNom(nom.getText());
        m.setPrenom(prenom.getText());
        m.setNum_parent(result);*/
        
       ms.insert(m);
      
       prenom.clear();
       email.clear();
       num.clear();
       
    }

    @FXML
    private void nom(ActionEvent event) {
    }

    @FXML
    private void num(ActionEvent event) {
        
    }

    @FXML
    private void dateNaissance(ActionEvent event) {
    }

    

    

    
    
}
