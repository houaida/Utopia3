/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import static allforkids.GUI.GestionGarderieController.LoggedUser;
import allforkids.entite.Garderie;
import allforkids.entite.JardinEnfant;
import allforkids.entite.ProprietaireG;
import allforkids.entite.ProprietaireJ;
import allforkids.service.GarderieService;
import allforkids.service.JardinEnfantService;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class GestionJardinController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btn1;
   @FXML
    private Button btliste;
      @FXML
    private TextField entrer;
     @FXML
    private TextField id_garderie;
     @FXML
    private TextField nom;
    @FXML
    private TextField adresse;
     @FXML
    private TextField num_tel;
    @FXML
    private TextArea description;
     
    public static JardinEnfant LoggedUser;
 @FXML
    private AnchorPane AnchorPane1;
 @FXML
    private TableView<JardinEnfant> table;
 @FXML
    private TableColumn<JardinEnfant, Integer> Cid;
    @FXML
    private TableColumn<JardinEnfant, String> Cnom;
    @FXML
    private TableColumn<JardinEnfant, String> Cadresse;
    @FXML
    private TableColumn<JardinEnfant, Integer> Cnum_tel;
    @FXML
    private TableColumn<JardinEnfant, String> Cdescription;
    @FXML
    private ToggleGroup menu;
    @FXML
    private TextField idEva;
    @FXML
    private Button btretour;
  
    /**
     * Initializes the controller class.
     */
     @FXML
    private TextField id_user;
    @FXML
    private TextField imgPath;
    @FXML
    private TableColumn<JardinEnfant, Image> image;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         afficherEva(AuthentificationController.LoggedProprietaireJ);
    }    
     public void afficherEva(ProprietaireJ u)
       {
        id_user.setText(Integer.toString(u.getId_user()));
           System.out.println("from gestionJardin:"+id_user.getText());
            JardinEnfantService ips = new JardinEnfantService();
            table.setItems(null);
                table.setItems(ips.getAll());
                image.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<JardinEnfant, Image>, ObservableValue<Image>>() {
                @Override
                public ObservableValue<Image> call(TableColumn.CellDataFeatures<JardinEnfant, Image> param) {
                    JardinEnfant p = param.getValue() ; 
                    return new SimpleObjectProperty<>(new Image(p.getImage(), 100, 100, true, true, true));
                }
            }) ; 
            image.setCellFactory(new Callback<TableColumn<JardinEnfant, Image>, TableCell<JardinEnfant, Image>>() {
                @Override
                public TableCell<JardinEnfant, Image> call(TableColumn<JardinEnfant, Image> param) {
                    return new TableCell<JardinEnfant, Image>(){
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
 Cid.setCellValueFactory(new PropertyValueFactory<>("id_jardinEnfant"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          
        Cadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        Cnum_tel.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
              Cdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
             

       }
    @FXML
      public void actionBrowser()throws MalformedURLException {
        
        String imageFile;
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);
            Image image1 = new Image(imageFile);
            //imgV.setImage(image1);
            imgPath.setText(imageFile);
        } else {
            System.out.println("file doesn't exist");
        }
     }
    @FXML
     public void ajouter()
     {
     JardinEnfantService ps=new JardinEnfantService();
        JardinEnfant p= new JardinEnfant(Integer.parseInt(id_user.getText()),nom.getText(),adresse.getText(),Integer.parseInt(num_tel.getText()),description.getText(),imgPath.getText());
        ps.insert(p);
        nom.clear();
        adresse.clear();
        num_tel.clear();
      
       description.clear();
        afficherEva(AuthentificationController.LoggedProprietaireJ);
        
     }
    @FXML
     public void supprimer()
     {
         int i=table.getSelectionModel().getSelectedItem().getId_jardinEnfant();
         System.out.println("id_jardiiiiin"+i);
         
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer cette jardin d'enfant");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
     JardinEnfantService ps=new JardinEnfantService();
        
      ps.delete(i);
      afficherEva(AuthentificationController.LoggedProprietaireJ);}
        
     }
    @FXML
     public void modifier()
     {
          btn1.setDisable(false);
          id_garderie.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getId_jardinEnfant()));
          image.setText(table.getSelectionModel().getSelectedItem().getImage());
     nom.setText(table.getSelectionModel().getSelectedItem().getNom());
     adresse.setText(table.getSelectionModel().getSelectedItem().getAdresse());
     num_tel.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getNum_tel()));
     description.setText(table.getSelectionModel().getSelectedItem().getDescription());
     
    
     }
    @FXML
     public void mod2()
     {
     JardinEnfantService ps=new JardinEnfantService();
        // System.out.println("id_garderie:"+id_garderie.getText());
     JardinEnfant e=new JardinEnfant(Integer.parseInt(id_garderie.getText()),Integer.parseInt(id_user.getText()),
     nom.getText(),adresse.getText(),Integer.parseInt(num_tel.getText()),description.getText());
     ps.update(e);
     afficherEva(AuthentificationController.LoggedProprietaireJ);
     }
    @FXML
    public void rechercher()
{
Garderie e=null;
String nom=entrer.getText();
 JardinEnfantService ps=new JardinEnfantService();


        table.setItems(null);
                table.setItems(ps.getAllByName(nom));
 Cid.setCellValueFactory(new PropertyValueFactory<>("id_jardinEnfant"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          
        Cadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        Cnum_tel.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
              Cdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
              
              if(entrer.getText().isEmpty()){
              afficherEva(AuthentificationController.LoggedProprietaireJ);
              }}
    @FXML
              public void chargerListe()
              {
              LoggedUser = new JardinEnfant();
        LoggedUser.setNom(table.getSelectionModel().getSelectedItem().getNom());
        LoggedUser.setId_jardinEnfant(table.getSelectionModel().getSelectedItem().getId_jardinEnfant());
                  System.out.println(LoggedUser.getNom());
                  System.out.println(LoggedUser.getId_jardinEnfant());
         try {
        
       
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionEnfantJ.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
            

        } catch (IOException ex) {
            Logger.getLogger(GestionJardinController.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
              }

    @FXML
    private void retour(MouseEvent event) throws IOException {
          
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Acceuilkids2.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    
    }

    @FXML
    private void retour(ActionEvent event) {
    }

    

}
