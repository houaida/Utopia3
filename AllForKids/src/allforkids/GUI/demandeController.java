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
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.opencv.core.Core;

/**
 * FXML Controller class
 *
 * @author user
 */
public class demandeController implements Initializable {

    /**
     * Initializes the controller class.
     */
       @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private Text txtnom;
    @FXML
    private Text txtType;
    @FXML
    private Text txtPrix;
    @FXML
    private Text txtDescription;
    private TableView<Demande> tbtable;
    
    
 
    private TableColumn<Demande, String> titre;
    private TableColumn<Demande, String> date_debut;
    private TableColumn<Demande, String> date_fin;
    private TableColumn<Demande, String> description;
    private Button btn1;
    private TableColumn<?, ?> id_offre1;
    @FXML
    private TextField trecherche1;
    @FXML
    private TextField ttitre1;
    @FXML
    private DatePicker tdate_debut1;
    @FXML
    private TextArea tdescription1;
    @FXML
    private TableView<Demande> tbtable1;
    @FXML
    private TableColumn<Demande, String> titre1;
    @FXML
    private TableColumn<Demande, String> date_debut1;
    @FXML
    private TableColumn<Demande,String> date_fin1;
    @FXML
    private TableColumn<Demande,String> description1;
    @FXML
    private DatePicker tdate_fin1;
    @FXML
    private Button btn2;
    @FXML
    private TextField id_demande1;
    @FXML
    private TableColumn<Demande, String> id_demande2;
    @FXML
    private Button btretour1;
    @FXML
    private ToggleButton ajouter;
    @FXML
    private ToggleButton modifier;
    @FXML
    private ToggleButton supprimer;
    @FXML
    private ToggleGroup menu1;
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
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        		//System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // TODO int i;
         afficherDemande();
     
    }    
    @FXML
    public void retour() throws IOException
    {
    
    AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilParent.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
 public void afficherDemande()
       {
           
             DemandeService Gdemande=DemandeService.getInstance();
            tbtable1.setItems(null);
                tbtable1.setItems(Gdemande.getAll());

titre1.setCellValueFactory(new PropertyValueFactory<>("titre"));
date_debut1.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
date_fin1.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
description1.setCellValueFactory(new PropertyValueFactory<>("description"));       
id_demande2.setCellValueFactory(new PropertyValueFactory<>("id_demande"));

        


       }

    @FXML
    private void ajouterdemande(ActionEvent event) throws ParseException{
     DemandeService gDemande=DemandeService.getInstance();
     Demande demande=new Demande(AuthentificationController.LoggedParent.getId_user(),tdescription1.getText(),ttitre1.getText(),tdate_debut1.getEditor().getText(),tdate_fin1.getEditor().getText());
    gDemande.insert(demande);
     tdescription1.clear();
      ttitre1.clear();
     tdate_debut1.getEditor().clear();
      tdate_fin1.getEditor().clear();
        
  afficherDemande();
    
    }
    @FXML
        public void modifierdemande()
     {
          btn2.setDisable(false);
        id_demande1.setText(Integer.toString(tbtable1.getSelectionModel().getSelectedItem().getId_demande()));
     ttitre1.setText(tbtable1.getSelectionModel().getSelectedItem().getTitre());
     tdate_debut1.getEditor().setText((tbtable1.getSelectionModel().getSelectedItem().getDate_debut()));
     tdate_fin1.getEditor().setText((tbtable1.getSelectionModel().getSelectedItem().getDate_fin()));
     tdescription1.setText((tbtable1.getSelectionModel().getSelectedItem().getDescription()));
    
     }
    
    
   @FXML
     public void mod2()
     {
     DemandeService gDemande=DemandeService.getInstance();
     Demande demande=new Demande(Integer.parseInt(id_demande1.getText()),AuthentificationController.LoggedParent.getId_user(),tdescription1.getText(),ttitre1.getText(),tdate_debut1.getEditor().getText(),tdate_fin1.getEditor().getText());

     gDemande.update(demande);
         afficherDemande();
           btn2.setDisable(true);
     }
    @FXML
    private void supprimerdemande(ActionEvent event) {
      
        if (!tbtable1.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("suppression de propriétaire ");
           alert.setHeaderText("Etes-vous sur que vous voulez supprimer cette l'offre --"
               +tbtable1.getSelectionModel().getSelectedItem().getTitre()+"--");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
     DemandeService gDemande=DemandeService.getInstance();

              gDemande.delete(tbtable1.getSelectionModel().getSelectedItem().getId_demande());
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
    private void recherchedemande(ActionEvent event)throws IOException, InterruptedException {
     DemandeService gDemande=DemandeService.getInstance();
                String a =(trecherche1.getText()) ;

       tbtable1.setItems(gDemande.getbyPseudo1(a));
      titre1.setCellValueFactory(new PropertyValueFactory<>("titre"));
date_debut1.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
date_fin1.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
description1.setCellValueFactory(new PropertyValueFactory<>("description"));       
        
    }

     @FXML
    private void afficher(ActionEvent event) {
        AnchorPane2.setVisible(true);
       retire.setVisible(true);
    }

    @FXML
    private void retirer(ActionEvent event) {
        AnchorPane2.setVisible(false);
        retire.setVisible(false);
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
   
    private void Demandes(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("demande.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void gotoDemandeTravail(MouseEvent event) {
    }

    @FXML
    private void ListeOffre(ActionEvent event) {
    }

}
    

