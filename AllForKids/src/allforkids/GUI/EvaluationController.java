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
import javafx.scene.control.cell.PropertyValueFactory;
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
    
}
