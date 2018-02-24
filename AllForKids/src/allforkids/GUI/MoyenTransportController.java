/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;


import allforkids.entite.MoyenDetransport;

import allforkids.service.MoyendeTransportService;
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
import javafx.scene.control.Label;
/*import javafx.scene.control.Label;*/
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
/*import javafx.scene.control.ToggleGroup;*/
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class MoyenTransportController implements Initializable {

     
      @FXML
    private Button btn1;
     @FXML
      private TextField idMoy;
     @FXML
    private TextField type;
     @FXML
    private TextField immatriculation;
     @FXML
    private TextField nbr;

   
 @FXML
    private TableView<MoyenDetransport> table;
 @FXML
    private TableColumn<MoyenDetransport, Integer> Cid;
 @FXML
    private TableColumn<MoyenDetransport, String> Ctype;
 @FXML
    private TableColumn<MoyenDetransport, String> Cim;
 @FXML
    private TableColumn<MoyenDetransport, Integer> Cnbr;
    @FXML
    private Label lbTitulo1;
    @FXML
    private TextField afficher_entry;
    @FXML
    private ToggleGroup menu;
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private Button btretour;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherEva();
    }    
     public void afficherEva()
       {
           
           MoyendeTransportService ips=new MoyendeTransportService();
            table.setItems(null);
            table.setItems(ips.getAll());
 Cid.setCellValueFactory(new PropertyValueFactory<>("id_moyenTransport"));
        Ctype.setCellValueFactory(new PropertyValueFactory<>("type"));  
        Cim.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));
        Cnbr.setCellValueFactory(new PropertyValueFactory<>("nombre_de_place"));
              
       }
    @FXML
    public void retour() throws IOException
    {
    
    AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilKids.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    @FXML
     public void ajouter()
     {
        MoyendeTransportService ps=new MoyendeTransportService();
        MoyenDetransport p= new MoyenDetransport(type.getText(),immatriculation.getText(),Integer.parseInt(nbr.getText()));
        ps.insert(p);
        type.clear();
        immatriculation.clear();
        nbr.clear();
        
        afficherEva();
        
     }
    @FXML
     public void supprimer()
     {
         int i=table.getSelectionModel().getSelectedItem().getId_moyenTransport();
         System.out.println(i);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer ce vehicule");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
 
        MoyendeTransportService ps=new MoyendeTransportService();
      ps.delete(i);
      afficherEva();}
        
     }
    @FXML
     public void modifier()
     {
          btn1.setDisable(false);
          idMoy.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getId_moyenTransport()));
          type.setText(table.getSelectionModel().getSelectedItem().getType());
          immatriculation.setText(table.getSelectionModel().getSelectedItem().getImmatriculation());
          nbr.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getNombre_de_place()));
   
    
     }
    @FXML
     public void mod2()
     {
     MoyendeTransportService ps=new MoyendeTransportService();
     MoyenDetransport e=new MoyenDetransport(Integer.parseInt(idMoy.getText()),
     type.getText(),immatriculation.getText(),Integer.parseInt(nbr.getText()));
     ps.update(e);
     afficherEva();
     }
}
