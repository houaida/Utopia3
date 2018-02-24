/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Demande;
import allforkids.entite.Offre;
import allforkids.service.DemandeService;
import allforkids.service.OffreService;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class OffreDemandeCompController implements Initializable {

    @FXML
    private TableView<Offre> tbtable1;
      
    @FXML
    private TableColumn<Offre, String> titre1;
    @FXML
    private TableColumn<Offre, String> date_debut1;
    @FXML
    private TableColumn<Offre, String> date_fin1;
    @FXML
    private TableColumn<Offre, String> description1;
    @FXML
    private TableColumn<Demande, Integer> id_demande2;
    @FXML
    private TableView<Demande> tbtable;
    @FXML
    private TableColumn<Demande, String> titre;
    @FXML
    private TableColumn<Demande, String> date_debut;
    @FXML
    private TableColumn<Demande, String> date_fin;
    @FXML
    private TableColumn<Demande, String> description;
    @FXML
    private TableColumn<Offre, Integer> id_offre1;
    @FXML
    private TableColumn<?, ?> titre2;
    @FXML
    private TableColumn<?, ?> titre3;
    @FXML
    private JFXTextField rechercheo;
    @FXML
    private JFXTextField recherched;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ToggleButton gestionUtilisateur;
    @FXML
    private ToggleButton gestionProduit;
    @FXML
    private ToggleButton retire;
    @FXML
    private ToggleButton gestionOffre;
    @FXML
    private ToggleButton gestionUtilisateur1;
    @FXML
    private ToggleButton fleche2;
    @FXML
    private ToggleButton fleche1;
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private BorderPane anB;
    @FXML
    private ToggleButton gestionReclamation;
    @FXML
    private ToggleButton gestionReclamation1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherDemande();
        afficherOffre();
    }  
    public void afficherDemande()
       {
           
             DemandeService Gdemande=DemandeService.getInstance();
            tbtable.setItems(null);
                tbtable.setItems(Gdemande.getAll());

titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
description.setCellValueFactory(new PropertyValueFactory<>("description"));       
id_demande2.setCellValueFactory(new PropertyValueFactory<>("id_demande"));

        


       }
    public void afficherOffre()
       {
           
             OffreService Goffre=OffreService.getInstance();
            tbtable1.setItems(null);
                tbtable1.setItems(Goffre.getAll());

titre1.setCellValueFactory(new PropertyValueFactory<>("titre"));
date_debut1.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
date_fin1.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
description1.setCellValueFactory(new PropertyValueFactory<>("description"));       
id_offre1.setCellValueFactory(new PropertyValueFactory<>("id_offre"));

        


       }

    @FXML
    private void supprimerOffre(ActionEvent event) {
         if (!tbtable1.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("suppression de propriétaire ");
            alert.setHeaderText("Etes-vous sur que vous voulez supprimer cette offre"
                    +tbtable1.getSelectionModel().getSelectedItem().getId_offre());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                     OffreService Goffre=OffreService.getInstance();

                Goffre.delete(tbtable1.getSelectionModel().getSelectedItem().getId_offre());
               afficherOffre();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            
            alert.setTitle("Erreur de selection");
            alert.setHeaderText("Vous etes obligé de selectioner une offre  ");

            Optional<ButtonType> result = alert.showAndWait();
        }

        
    }

    @FXML
    private void supprimerDemande(ActionEvent event) {
            if (!tbtable.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("suppression de propriétaire ");
           alert.setHeaderText("Etes-vous sur que vous voulez supprimer cette offre"
               +tbtable.getSelectionModel().getSelectedItem().getId_demande());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
     DemandeService gDemande=DemandeService.getInstance();

              gDemande.delete(tbtable.getSelectionModel().getSelectedItem().getId_demande());
       afficherDemande();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            
            alert.setTitle("Erreur de selection");
            alert.setHeaderText("Vous etes obligé de selectioner une offre  ");

            Optional<ButtonType> result = alert.showAndWait();
        }

    }

    @FXML
    private void rechercherOffre(ActionEvent event) {
              OffreService Goffre=OffreService.getInstance();

        String a =(rechercheo.getText()) ;

       tbtable1.setItems(Goffre.getbyPseudo1(a));
      titre1.setCellValueFactory(new PropertyValueFactory<>("titre"));
date_debut1.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
date_fin1.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
description1.setCellValueFactory(new PropertyValueFactory<>("description"));     
                      
        
    }

    

    @FXML
    private void rechercherDemande(ActionEvent event)throws IOException, InterruptedException {
              DemandeService gDemande=DemandeService.getInstance();
 
                String a =(recherched.getText()) ;

        tbtable.setItems(gDemande.getbyPseudo1(a));
      titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
description.setCellValueFactory(new PropertyValueFactory<>("description"));       
    
    

    
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
    private void gestionProduit(ActionEvent event) {
    }

   @FXML
    private void retirer(ActionEvent event) {
         AnchorPane2.setVisible(false);
        retire.setVisible(false);
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
    private void gestionReclamation(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListviewReclamation.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        
    }

    @FXML
    private void gestionDemande(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("demandeTravail.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void gestionOffre(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("OffreDemandeComp.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    
}
