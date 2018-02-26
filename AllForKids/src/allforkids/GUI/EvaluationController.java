/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Enfant;
import allforkids.entite.EnfantJ;
import allforkids.entite.Enseignant;
import allforkids.entite.Evaluation;
import allforkids.entite.Garderie;
import allforkids.entite.JardinEnfant;
import allforkids.entite.Parent;
import allforkids.service.EnfantJService;
import allforkids.service.EnfantService;
import allforkids.service.EvaluationService;
import allforkids.service.JardinEnfantService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class EvaluationController implements Initializable {
 @FXML
    private TableView<Evaluation> table1;
    @FXML
    private TableColumn<Evaluation, String> matiere;
    @FXML
    private TableColumn<Evaluation, Float> moyenne;
    @FXML
    private TableColumn<Evaluation, String> remarque;
    @FXML
    private Label nomEnfant;
    @FXML
    private Button btretour;
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private Label lbnom;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ToggleButton gestionPrduit;
    @FXML
    private ToggleButton retire;
    @FXML
    private ToggleButton fleche2;
    @FXML
    private ToggleButton fleche1;
    @FXML
    private AnchorPane anB;
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherEvaluation(AuthentificationController.LoggedParent);
    }    
    public void afficherEvaluation(Parent u)
       {
           EnfantService es=new EnfantService();
            EnfantJService esJ=new EnfantJService();
           Enfant e=null;
           EnfantJ en=null;
           System.out.println(u.getId_user());
           e=es.searchEnfant(u.getId_user());
           en=esJ.searchEnfantJ(u.getId_user());
           // System.out.println(e.getNom());
           if(e!=null)
           {
          lbnom.setText(e.getNom()+" "+e.getPrenom());
            EvaluationService ips = new EvaluationService();
            
            table1.setItems(null);
                table1.setItems(ips.getAllEvaluations(e.getNom(), e.getPrenom()));

        matiere.setCellValueFactory(new PropertyValueFactory<>("matiere"));
       
        
        moyenne.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
        remarque.setCellValueFactory(new PropertyValueFactory<>("nom_enseignant"));
              
           }
           if(en!=null){
               lbnom.setText(en.getNom()+" "+en.getPrenom());
            EvaluationService ips = new EvaluationService();
            
            table1.setItems(null);
                table1.setItems(ips.getAllEvaluations(en.getNom(), en.getPrenom()));

        matiere.setCellValueFactory(new PropertyValueFactory<>("matiere"));
       
        
        moyenne.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
        remarque.setCellValueFactory(new PropertyValueFactory<>("nom_enseignant"));
              
           
           }
       }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilParent.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void afficher(ActionEvent event) {
        AnchorPane2.setVisible(true);
       retire.setVisible(true);
    }

    @FXML
    private void ConseilsGoogle(ActionEvent event) {
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
        AnchorPane2.setVisible(false);
        retire.setVisible(false);
    }

    @FXML
    private void Evaluation(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Evaluation.fxml"));
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


    @FXML
    private void ServiceAllForKids(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("babysitterPersonnel.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    
}
