/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;


import allforkids.entite.Enfant;
import allforkids.entite.EnfantJ;
import allforkids.entite.Garderie;
import allforkids.entite.User;
import allforkids.service.EnfantJService;
import allforkids.service.EnfantService;
import allforkids.service.LivraisonService;
import allforkids.technique.util.DataSource;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class GestionEnfantController implements Initializable {
 @FXML
    private AnchorPane AnchorPane1;
 @FXML
    private TableView<Enfant> table;
 @FXML
    private TableColumn<Enfant, Integer> Cid;
  @FXML
    private TableColumn<Enfant, Integer> Cid_parent;
    @FXML
    private TableColumn<Enfant, String> Cnom;
     @FXML
    private TableColumn<Enfant, String>Cprenom;
      @FXML
    private TableColumn<Enfant, Integer> Cage;
      @FXML
    private TextField nom;
       @FXML
    private TextField id_garderie;
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
    private ToggleGroup menu;
    @FXML
    private Button btretour1;
    @FXML
    private TableColumn<Enfant, Image> Cimage;
    @FXML
    private JFXTextField path;
    @FXML
    private Label lbimage;
    @FXML
    private JFXComboBox<Integer> comBox3;
   

 

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Integer> ol3 = FXCollections.observableArrayList();
        ol3.add(1) ; 
        ol3.add(2) ; 
        ol3.add(3) ; 
        ol3.add(4) ; 
        ol3.add(5) ;
         ol3.add(6) ;
          ol3.add(7) ;
           ol3.add(8) ;
            ol3.add(9) ;
             ol3.add(10) ;
              ol3.add(11) ;
               ol3.add(12) ;
                ol3.add(13) ;
                 ol3.add(14) ;
        comBox3.setItems(ol3);
        connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
    }
        afficher(GestionGarderieController.LoggedUser);
       
     /*try {
         buildData();
     } catch (SQLException ex) {
         System.out.println("data nooo");
     }*/
    }    
    public void afficher(Garderie u)
       {
           nom_enfant.setDisable(true);
           prenom_enfant.setDisable(true);
           id_parent.setDisable(true);
         comBox3.setDisable(true);
           lbimage.setDisable(true);
           EnfantService ips = new EnfantService();
           
            nom.setText(u.getNom());
            id_garderie.setText(Integer.toString(u.getId_garderie()));
            System.out.println(u.getId_garderie());
            
            table.setItems(null);
                table.setItems(ips.getListeEnfant(nom.getText()));
                Cimage.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Enfant, Image>, ObservableValue<Image>>() {
                @Override
                public ObservableValue<Image> call(TableColumn.CellDataFeatures<Enfant, Image> param) {
                    Enfant p = param.getValue() ; 
                  EnfantService ps = new EnfantService() ; 
                    Enfant pr = ps.search(p.getId_enfant()) ; 
                    
                    return new SimpleObjectProperty<>(new Image(pr.getImage(), 80, 80, true, true, true));
                }
            }) ; 
             Cimage.setCellFactory(new Callback<TableColumn<Enfant, Image>, TableCell<Enfant, Image>>() {
                @Override
                public TableCell<Enfant, Image> call(TableColumn<Enfant, Image> param) {
                    return new TableCell<Enfant, Image>(){
                        @Override
                    protected void updateItem(Image i, boolean empty) {
                        super.updateItem(i, empty);
                        setText(null);
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        ImageView imageView = (i == null || empty) ? null : ImageViewBuilder.create().image(i).build();
                        setGraphic(imageView);
                    }
                } ; 
                }
            });
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
    EnfantService ps=new EnfantService();
    
        
      ps.delete(i);
      afficher(GestionGarderieController.LoggedUser);}
        
     }
    @FXML
     public void modifier()
     {
          btn1.setDisable(false);
          id_parent.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getId_parent()));
          id_parent.setDisable(true);
          nom_enfant.setDisable(false);
          prenom_enfant.setDisable(false);
         comBox3.setDisable(false);
         lbimage.setDisable(false);
          id_enfant.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getId_enfant()));
     nom_enfant.setText(table.getSelectionModel().getSelectedItem().getNom());
     prenom_enfant.setText(table.getSelectionModel().getSelectedItem().getPrenom());
    comBox3.setValue(table.getSelectionModel().getSelectedItem().getAge());
  path.setText(table.getSelectionModel().getSelectedItem().getImage());
     
    
     }
    @FXML
     public void mod2()
     {
     EnfantService ps=new EnfantService();
     
     Enfant e=new Enfant(Integer.parseInt(id_enfant.getText()),Integer.parseInt(id_parent.getText()),Integer.parseInt(id_garderie.getText()),
     nom_enfant.getText(),prenom_enfant.getText(),comBox3.getValue(),path.getText());
     ps.update(e);
     afficher(GestionGarderieController.LoggedUser);
     }
    @FXML
    public void rechercher()
{
Garderie e=null;
String nom=entrer.getText();
EnfantService ps=new EnfantService();


        table.setItems(null);
                table.setItems(ps.getAllByName(nom));
                 Cimage.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Enfant, Image>, ObservableValue<Image>>() {
                @Override
                public ObservableValue<Image> call(TableColumn.CellDataFeatures<Enfant, Image> param) {
                    Enfant p = param.getValue() ; 
                  EnfantService ps = new EnfantService() ; 
                    Enfant pr = ps.search(p.getId_enfant()) ; 
                    
                    return new SimpleObjectProperty<>(new Image(pr.getImage(), 80, 80, true, true, true));
                }
            }) ; 
             Cimage.setCellFactory(new Callback<TableColumn<Enfant, Image>, TableCell<Enfant, Image>>() {
                @Override
                public TableCell<Enfant, Image> call(TableColumn<Enfant, Image> param) {
                    return new TableCell<Enfant, Image>(){
                        @Override
                    protected void updateItem(Image i, boolean empty) {
                        super.updateItem(i, empty);
                        setText(null);
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        ImageView imageView = (i == null || empty) ? null : ImageViewBuilder.create().image(i).build();
                        setGraphic(imageView);
                    }
                } ; 
                }
            });
 Cid.setCellValueFactory(new PropertyValueFactory<>("id_enfant"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          
        Cage.setCellValueFactory(new PropertyValueFactory<>("age"));
        Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
              Cid_parent.setCellValueFactory(new PropertyValueFactory<>("id_parent"));
              
              if(entrer.getText().isEmpty()){
              afficher(GestionGarderieController.LoggedUser);

              }}

    @FXML
    private void retour(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionGarderie.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void actionBrowse(ActionEvent event) throws MalformedURLException {
        String imageFile;
      
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);
            Image image1 = new Image(imageFile);
            //imgV.setImage(image1);
            path.setText(imageFile);
        } else {
            System.out.println("file doesn't exist");
        }
     
    }
    
}
