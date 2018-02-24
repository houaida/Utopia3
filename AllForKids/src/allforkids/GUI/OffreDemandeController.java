/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Offre;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author user
 */
public class OffreDemandeController implements Initializable {

    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ToggleButton menu_babysitter;
    @FXML
    private ToggleGroup grupoMenus;
    @FXML
    private ToggleButton Education;
    @FXML
    private AnchorPane anchor_offre;
    @FXML
    private Label lbTitulo1;
    @FXML
    private ToggleButton ajout;
    @FXML
    private ToggleGroup menu;
    @FXML
    private Text txtnom;
    @FXML
    private Text txtType;
    @FXML
    private Text txtPrix;
    @FXML
    private Text txtDescription;
    @FXML
    private TextField ttitre;
    @FXML
    private DatePicker tdate_debut;
    @FXML
    private TextArea tdescription;
    @FXML
    private TableView<Offre> tbtable;
    
    
    @FXML
    private DatePicker tdate_fin;
 
    @FXML
    private TableColumn<Offre, String> titre;
    @FXML
    private TableColumn<Offre, String> date_debut;
    @FXML
    private TableColumn<Offre, String> date_fin;
    @FXML
    private TableColumn<Offre, String> description;
    @FXML
    private TableColumn<Offre, String> id_offre;
    @FXML
    private ToggleButton supp;
    @FXML
    private ToggleButton modifier;
    @FXML
    private Button btn1;
    @FXML
    private TextField id_offre1;
    @FXML
    private TextField trecherche;
    @FXML
    private ToggleButton recherche;
     

    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO int i;
         afficherOffre();
     
    }    
    @FXML
    public void retour() throws IOException
    {
    
    AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilKids.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
 public void afficherOffre()
       {
           
             OffreService Goffre=OffreService.getInstance();
            tbtable.setItems(null);
                tbtable.setItems(Goffre.getAll());

titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
description.setCellValueFactory(new PropertyValueFactory<>("description"));       
id_offre.setCellValueFactory(new PropertyValueFactory<>("id_offre"));

        


       }
    @FXML
    private void menu_babysitter(ActionEvent event) {
    }

    @FXML
    private void Education(ActionEvent event) {
    }

    @FXML
    private void ajouter(ActionEvent event) throws ParseException{
     OffreService Goffre=OffreService.getInstance();
     Offre offre=new Offre(7,tdescription.getText(),ttitre.getText(),tdate_debut.getEditor().getText(),tdate_fin.getEditor().getText());
    Goffre.insert(offre);
     tdescription.clear();
      ttitre.clear();
     tdate_debut.getEditor().clear();
      tdate_fin.getEditor().clear();
        
   afficherOffre();
    
    }
@FXML
    
        
        public void modifier()
     {
          btn1.setDisable(false);
          id_offre1.setText(Integer.toString(tbtable.getSelectionModel().getSelectedItem().getId_offre()));
     ttitre.setText(tbtable.getSelectionModel().getSelectedItem().getTitre());
     tdate_debut.getEditor().setText((tbtable.getSelectionModel().getSelectedItem().getDate_debut()));
     tdate_fin.getEditor().setText((tbtable.getSelectionModel().getSelectedItem().getDate_fin()));
     tdescription.setText((tbtable.getSelectionModel().getSelectedItem().getDescription()));
    
     }
    
    
   @FXML
     public void mod2()
     {
     OffreService Goffre=OffreService.getInstance();
     Offre offre=new Offre(Integer.parseInt(id_offre1.getText()),7,tdescription.getText(),ttitre.getText(),tdate_debut.getEditor().getText(),tdate_fin.getEditor().getText());

     Goffre.update(offre);
     afficherOffre();
     }

    @FXML
    private void supprimer(ActionEvent event) {
      
        if (!tbtable.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("suppression de propriétaire ");
            alert.setHeaderText("Etes-vous sur que vous voulez supprimer cette offre"
                    +tbtable.getSelectionModel().getSelectedItem().getId_offre());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                     OffreService Goffre=OffreService.getInstance();

                Goffre.delete(tbtable.getSelectionModel().getSelectedItem().getId_offre());
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
    private void recherche(ActionEvent event)throws IOException, InterruptedException {
                OffreService Goffre=OffreService.getInstance();
                String a =(trecherche.getText()) ;

        tbtable.setItems(Goffre.getbyPseudo1(a));
      titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
description.setCellValueFactory(new PropertyValueFactory<>("description"));       
        
    }

    }
    

