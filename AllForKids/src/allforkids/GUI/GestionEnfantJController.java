/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Enfant;
import allforkids.entite.EnfantJ;
import allforkids.entite.Garderie;
import allforkids.entite.JardinEnfant;
import allforkids.service.EnfantJService;
import allforkids.service.EnfantService;
import allforkids.service.LivraisonService;
import allforkids.technique.util.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
 * @author MacBook
 */
public class GestionEnfantJController implements Initializable {

   @FXML
    private AnchorPane AnchorPane1;
 @FXML
    private TableView<EnfantJ> table;
 @FXML
    private TableColumn<EnfantJ, Integer> Cid;
  @FXML
    private TableColumn<EnfantJ, Integer> Cid_parent;
    @FXML
    private TableColumn<EnfantJ, String> Cnom;
     @FXML
    private TableColumn<EnfantJ, String>Cprenom;
      @FXML
    private TableColumn<EnfantJ, Integer> Cage;
      @FXML
    private TextField nom;
       @FXML
    private TextField id_garderie;
       @FXML
    private TextField age;
       @FXML
    private TextField entrer;
       @FXML
    private TextField nom_enfant;
       @FXML
    private Button btn1;
       @FXML
    private TextField id_enfant;
       @FXML
    private TextField prenom_enfant;
       @FXML
    private TextField id_parent;
     
    /**
     * Initializes the controller class.
     */
       Connection connexion;
    Statement st;
    ResultSet result;
    @FXML
    private Label lbTitulo1;
    @FXML
    private ToggleGroup menu;
    @FXML
    private Button btretour;
   

 

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(GestionEnfantJController.class.getName()).log(Level.SEVERE, null, ex);
    }
        afficher(GestionJardinController.LoggedUser);
       
     /*try {
         buildData();
     } catch (SQLException ex) {
         System.out.println("data nooo");
     }*/
    }    
    public void afficher(JardinEnfant u)
       {
           nom_enfant.setDisable(true);
           prenom_enfant.setDisable(true);
           id_parent.setDisable(true);
           age.setDisable(true);
           EnfantJService ips = new EnfantJService();
           
            nom.setText(u.getNom());
            id_garderie.setText(Integer.toString(u.getId_jardinEnfant()));
            System.out.println(u.getId_jardinEnfant());
            
            table.setItems(null);
                table.setItems(ips.getListeEnfant(nom.getText()));
 Cid.setCellValueFactory(new PropertyValueFactory<>("id_enfant"));
  Cid_parent.setCellValueFactory(new PropertyValueFactory<>("id_parent"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          
        Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Cage.setCellValueFactory(new PropertyValueFactory<>("age"));
             
             

       }
    
/*public void buildData() throws SQLException{    
    ObservableList<Integer>  data = FXCollections.observableArrayList();
st= connexion.createStatement(); 
result = st.executeQuery("Select id_user from users where type='parent'"); 
while (result.next()) 
{ 
       //Pour affecter une valeur de base de données à un Combobox  
       data.add(result.getInt("id_user"));
    idCombo.setItems(data);
}

    }  */  
   
  
    @FXML
     public void supprimer()
     {
         int i=table.getSelectionModel().getSelectedItem().getId_enfant();
         System.out.println(i);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer cet enfant");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
    EnfantJService ps=new EnfantJService();
    
        
      ps.delete(i);
      afficher(GestionJardinController.LoggedUser);}
        
     }
    @FXML
     public void modifier()
     {
          btn1.setDisable(false);
          id_parent.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getId_parent()));
          id_parent.setDisable(true);
          nom_enfant.setDisable(false);
          prenom_enfant.setDisable(false);
         age.setDisable(false);
          id_enfant.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getId_enfant()));
     nom_enfant.setText(table.getSelectionModel().getSelectedItem().getNom());
     prenom_enfant.setText(table.getSelectionModel().getSelectedItem().getPrenom());
     age.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getAge()));
  
     
    
     }
    @FXML
     public void mod2()
     {
     EnfantService ps=new EnfantService();
     Enfant e=new Enfant(Integer.parseInt(id_enfant.getText()),Integer.parseInt(id_parent.getText()),Integer.parseInt(id_garderie.getText()),
     nom_enfant.getText(),prenom_enfant.getText(),Integer.parseInt(age.getText()));
     ps.update(e);
     afficher(GestionJardinController.LoggedUser);
     }
    @FXML
    public void rechercher()
{
Garderie e=null;
String nom=entrer.getText();
EnfantJService ps=new EnfantJService();


        table.setItems(null);
                table.setItems(ps.getAllByName(nom));
 Cid.setCellValueFactory(new PropertyValueFactory<>("id_enfant"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          
        Cage.setCellValueFactory(new PropertyValueFactory<>("age"));
        Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
              Cid_parent.setCellValueFactory(new PropertyValueFactory<>("id_parent"));
              
              if(entrer.getText().isEmpty()){
              afficher(GestionJardinController.LoggedUser);

              }}

    @FXML
    private void retour(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionJardin.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    
    
}
