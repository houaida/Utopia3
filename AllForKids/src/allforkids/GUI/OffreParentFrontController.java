/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Offre;
import allforkids.service.OffreService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class OffreParentFrontController implements Initializable {

    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private Button retour;
    @FXML
    private TextField search;
    @FXML
    private ToggleButton fleche2;
    @FXML
    private ToggleButton fleche1;
    @FXML
    private TableView<Offre> tbtable;
    @FXML
    private TableColumn<?, ?> id_offre;
    @FXML
    private TableColumn<?, ?> titre1;
    @FXML
    private TableColumn<?, ?> date_debut1;
    @FXML
    private TableColumn<?, ?> date_fin1;
    @FXML
    private TableColumn<?, ?> description1;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ToggleButton gestionPrduit;
    @FXML
    private ToggleButton retire;
    @FXML
    private ToggleButton fleche21;
    @FXML
    private ToggleButton fleche11;
    @FXML
    private AnchorPane anB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     afficherOffre();
     
    }    
   
 public void afficherOffre()
       {
           
             OffreService Goffre=OffreService.getInstance();
            tbtable.setItems(null);
                tbtable.setItems(Goffre.getAll());

titre1.setCellValueFactory(new PropertyValueFactory<>("titre"));
date_debut1.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
date_fin1.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
description1.setCellValueFactory(new PropertyValueFactory<>("description"));       
id_offre.setCellValueFactory(new PropertyValueFactory<>("id_offre"));

        


       }  

    @FXML
    private void afficher(ActionEvent event) {
    }

    @FXML
    private void retour(ActionEvent event) {
    }

    @FXML
    private void rechercheOffre(ActionEvent event) {
    Offre e=null;
String nom=search.getText();
OffreService ps=OffreService.getInstance();


        tbtable.setItems(null);
        tbtable.setItems(ps.getbyPseudo1(nom));
titre1.setCellValueFactory(new PropertyValueFactory<>("titre"));
date_debut1.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
date_fin1.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
description1.setCellValueFactory(new PropertyValueFactory<>("description"));       
id_offre.setCellValueFactory(new PropertyValueFactory<>("id_offre"));
              
              if(search.getText().isEmpty()){
              afficherOffre();

    }}

    @FXML
    private void aff1(ActionEvent event) {
    }

    @FXML
    private void aff2(ActionEvent event) {
    }

    @FXML
    private void gotoDemandeTravail(MouseEvent event) {
    }

    @FXML
    private void boutique(ActionEvent event) {
    }

    @FXML
    private void retirer(ActionEvent event) {
    }

    @FXML
    private void Reclamation(ActionEvent event) {
    }

    @FXML
    private void ListeOffre(ActionEvent event) {
    }

    @FXML
    private void Demandes(ActionEvent event) {
    }

    @FXML
    private void ServiceAllForKids(ActionEvent event) {
    }
    
}
