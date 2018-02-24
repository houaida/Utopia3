/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;
import allforkids.entite.Covoiturage;
import allforkids.service.CovoiturageService;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class CovoiturageController implements Initializable {
    @FXML
    private Label lbTitulo1;
    @FXML
    private TextField afficher_entry;
    @FXML
    private ToggleGroup menu;
       @FXML
    private Button btn1;
    @FXML
    private TableView<Covoiturage> table;
     @FXML
    private TableColumn<Covoiturage, Integer> Cid;
    @FXML
    private TableColumn<Covoiturage, Integer> Cidu;
    @FXML
    private TableColumn<Covoiturage, String> Cdepart;
    @FXML
    private TableColumn<Covoiturage, Integer> Cddepart;
    @FXML
    private TableColumn<Covoiturage, String> Cdestination;
    @FXML
    private TableColumn<Covoiturage, Integer> Cdarrive;
    @FXML
    private TableColumn<Covoiturage, Integer> Cnbr;
    @FXML
    private TextField depart;
    @FXML
    private TextField nbr;
    @FXML
    private TextField destination;
    @FXML
    private TextField id;
       @FXML
    private TextField iduser;
   /* @FXML
    private AnchorPane date_arrivee;*/
    @FXML
    private DatePicker date_depart;
    @FXML
    private DatePicker datearrivee;
    @FXML
    private AnchorPane AnchorPane1;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO   
    afficherEva();
    }   
    public void retour() throws IOException
    {
    
    AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilKids.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
     public void afficherEva()
       {
       CovoiturageService ips=new CovoiturageService();
            table.setItems(null);
            table.setItems(ips.getAll());
        Cid.setCellValueFactory(new PropertyValueFactory<>("id"));
        Cidu.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        Cdepart.setCellValueFactory(new PropertyValueFactory<>("depart")); 
         Cddepart.setCellValueFactory(new PropertyValueFactory<>("DateDepart"));
        Cdestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        Cdarrive.setCellValueFactory(new PropertyValueFactory<>("DateArrive"));
        Cnbr.setCellValueFactory(new PropertyValueFactory<>("nbre_place_dispo"));
       }
    @FXML
    private void ajouter() 
    {
        CovoiturageService ps=new CovoiturageService();
        int i=Integer.parseInt(iduser.getText());
        int u=Integer.parseInt(nbr.getText());
        Covoiturage p= new Covoiturage(i,depart.getText(),date_depart.getEditor().getText(),destination.getText(),datearrivee.getEditor().getText(),Integer.parseInt(nbr.getText()));
        ps.insert(p);
        depart.clear();
        destination.clear();
        nbr.clear();
        date_depart.setValue(null);
        datearrivee.setValue(null);
        iduser.clear();
        
        
        afficherEva();
        
    }

    @FXML
  public void supprimer()
     {
         int i=table.getSelectionModel().getSelectedItem().getId();
         System.out.println(i);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer ce covoiturage");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
 
        CovoiturageService ps=new CovoiturageService();
      ps.delete(i);
      afficherEva();}
        
     }
    @FXML
     public void modifier()
     {
          btn1.setDisable(false);
          
            id.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getId()));
          iduser.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getId_user()));
          depart.setText(table.getSelectionModel().getSelectedItem().getDepart());
          date_depart.getEditor().setText((table.getSelectionModel().getSelectedItem().getDateDepart()));
          destination.setText(table.getSelectionModel().getSelectedItem().getDestination());
          datearrivee.getEditor().setText((table.getSelectionModel().getSelectedItem().getDateArrive()));

           nbr.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getNbre_place_dispo()));
   
    
     }
    @FXML
     public void mod2()
     {
    CovoiturageService ps=new CovoiturageService();
   
    Covoiturage e= new Covoiturage(Integer.parseInt(id.getText()),Integer.parseInt(iduser.getText()),depart.getText(),date_depart.getEditor().getText(),destination.getText(),datearrivee.getEditor().getText(),Integer.parseInt(nbr.getText()));

     ps.update(e);
     afficherEva();
     }

   
    
}
