/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Admin;
import allforkids.entite.Commande;
import allforkids.entite.LigneCommande;
import allforkids.entite.Livraison;
import allforkids.entite.Livreur;
import allforkids.entite.Parent;
import allforkids.entite.Produit;
import allforkids.service.AdminService;
import allforkids.service.CommandeService;
import allforkids.service.LigneCommandeService;
import allforkids.service.LivraisonService;
import allforkids.service.LivreurService;
import allforkids.service.ParentService;
import allforkids.service.ProduitService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;

import java.sql.Timestamp;

import java.util.Optional;

import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class AccueilAdminController implements Initializable {

    MediaPlayer mediaPlayer;
    Media musicFile;
    
    @FXML
    private AnchorPane AnchorPane1;
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
    private TextField id_user;
    @FXML
    private ImageView profil;
    @FXML
    private Label pseudo;
    @FXML
    private TableView<Commande> tableC;
    @FXML
    private TableColumn<Commande, Image> client;
    @FXML
    private TableColumn<Commande, Image> produit;
    @FXML
    private TableColumn<Commande, Float> total;
    @FXML
    private TableColumn<Commande, Timestamp> date;
    @FXML
    private ToggleButton page1;
    @FXML
    private ToggleButton page2;
    
    @FXML
    private ToggleButton gestionReclamation;

    @FXML
    private TableView<Livraison> tableL;
    @FXML
    private TableColumn<Livraison, Image> livreur;
    @FXML
    private TableColumn<Livraison, Image> produit1;
    @FXML
    private TableColumn<Livraison, String> duree;
    @FXML
    private TableColumn<Livraison, String> adresse;

    
    @FXML
    private ToggleButton Compte;
    @FXML
    private ToggleButton Deco;
    @FXML
    private ImageView flou;
    @FXML
    private AnchorPane anCompte;
    @FXML
    private JFXTextField Tpseudo;
    @FXML
    private JFXPasswordField Amdp;
    @FXML
    private JFXPasswordField Nmdp;
    @FXML
    private JFXButton annul;
    @FXML
    private JFXButton enregistrer;
    @FXML
    private AnchorPane Param;
    @FXML
    private ToggleButton fermer;
    @FXML
    private ToggleButton param1;
    @FXML
    private ToggleButton param2;
    @FXML
    private ToggleButton triangle;
    @FXML
    private ToggleButton triangle1;
    @FXML
    private ImageView Tparam;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AnchorPane1.setPrefSize(1329,866);
        
        /* musicFile=new Media("file:/C:/Users/user/Desktop/PI/Utopia/AllForKids/src/allforkids/GUI/musique/wael.mp3");
        mediaPlayer=new MediaPlayer(musicFile);
        mediaPlayer.setAutoPlay(true) ; */
               
        afficherUser(AuthentificationController.LoggedAdmin);
        afficherListeProduits();
        afficherListeLivraisons() ; 
    }    
    @FXML
private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) Deco.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    @FXML
    private void afficher(ActionEvent event) {
         AnchorPane2.setVisible(true);
       retire.setVisible(true);
    }
    private void afficherUser(Admin a) {
        pseudo.setText(a.getPseudo());
        
         String s="file:/C:/wamp/www/ressources/";
        String imageFile =s+a.getImage();
        Image img=new Image(imageFile,280,280,true,true,true);
        profil.setImage(img);
        final Circle clip = new Circle(60, 60, 55);
        profil.setClip(clip);
    }
public void afficherListeProduits()
       {
           
            CommandeService ps = new CommandeService() ;
            tableC.setItems(null);
            tableC.setItems(ps.getAll2());
              //client.setCellFactory(new PropertyValueFactory<>("id_parent"));
            client.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Commande, Image>, ObservableValue<Image>>() {
                @Override
                public ObservableValue<Image> call(TableColumn.CellDataFeatures<Commande, Image> param) {
                    Commande p = param.getValue() ; 
                    ParentService ps = new ParentService() ; 
                    Parent pr = ps.search(p.getId_parent()) ; 
                    String s="file:/C:/wamp/www/ressources/";
                    return new SimpleObjectProperty<>(new Image(s+pr.getImage(), 80, 80, true, true, true));
                }
            }) ; 
            client.setCellFactory(new Callback<TableColumn<Commande, Image>, TableCell<Commande, Image>>() {
                @Override
                public TableCell<Commande, Image> call(TableColumn<Commande, Image> param) {
                    return new TableCell<Commande, Image>(){
                        @Override
                    protected void updateItem(Image i, boolean empty) {
                        super.updateItem(i, empty);
                        setText(null);
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        //ImageView imageV =  new ImageView() ; 
                        ImageView imageV = (i == null || empty) ? null : ImageViewBuilder.create().image(i).build();
                        //final Circle clip = new Circle(30,40,25);
                        //imageV.setClip(clip);
                        setGraphic(imageV);
                    }
                } ; 
                }
            });
           
            produit.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Commande, Image>, ObservableValue<Image>>() {
                @Override
                public ObservableValue<Image> call(TableColumn.CellDataFeatures<Commande, Image> param) {
                    Commande p = param.getValue() ; 
                    LigneCommandeService ls = new LigneCommandeService() ; 
                    LigneCommande l = ls.search(p.getId_ligne()) ; 
                    ProduitService ps = new ProduitService() ; 
                    Produit pr = ps.search(l.getId_produit()) ; 
                    String s="file:/C:/wamp/www/ressources/";
                    return new SimpleObjectProperty<>(new Image(s+pr.getImage(), 80, 80, true, true, true));
                }
            }) ; 
            produit.setCellFactory(new Callback<TableColumn<Commande, Image>, TableCell<Commande, Image>>() {
                @Override
                public TableCell<Commande, Image> call(TableColumn<Commande, Image> param) {
                    return new TableCell<Commande, Image>(){
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
            
            //produit.setCellValueFactory(new PropertyValueFactory<>("id_produit")) ;
            
      date.setCellValueFactory(new PropertyValueFactory<>("date"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
     date.setCellValueFactory(new PropertyValueFactory<>("date"));
      
      
       }
     
    
    @FXML
    private void gotoDemandeTravail(MouseEvent event) {
    }

    @FXML
    private void retirer(ActionEvent event) {
         AnchorPane2.setVisible(false);
        retire.setVisible(false);
    }

    @FXML
    private void page1(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilAdmin.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void page2(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Page2.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void gestionProduit(ActionEvent event) throws IOException {
          AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("listeProduits.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

   

    @FXML
    private void gestionReclamation(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListviewReclamation.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        
    }

    

    @FXML
    private void gestionOffre(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("OffreDemandeComp.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void gestionUtilisateur(ActionEvent event) throws IOException {
          AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionUser.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        
    }

    @FXML
    private void approbation(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListviewApprouver.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        
    }
    @FXML
    public void CompteCouleur1(){
    Compte.setTextFill(Color.WHITE);
    }
    @FXML
    public void CompteCouleur2(){
    Compte.setTextFill(Color.BLUE);
    }
    @FXML
     public void DecoCouleur1(){
    Deco.setTextFill(Color.WHITE);
    }
    @FXML
    public void DecoCouleur2(){
    Deco.setTextFill(Color.BLUE);
    }
    

    @FXML
    private void parametrage(ActionEvent event) {
        Param.setVisible(true);
       Tparam.setVisible(true);
        param1.setVisible(false);
        param2.setVisible(true);
        triangle.setVisible(true);
        triangle1.setVisible(false);
    }

    @FXML
    private void Compte(ActionEvent event) {
       flou.setVisible(true);
       anCompte.setVisible(true);
        System.out.println("pseudo:"+AuthentificationController.LoggedAdmin.getPseudo());
        Tpseudo.setText(AuthentificationController.LoggedAdmin.getPseudo());
        Tpseudo.setDisable(true);
        Tparam.setVisible(false);
       Param.setVisible(false);
    }

    @FXML
    private void annul(ActionEvent event) {
         flou.setVisible(false);
       anCompte.setVisible(false);
       Tparam.setVisible(true);
       Param.setVisible(true);
    }

    @FXML
    private void enregistrer(ActionEvent event) {
       
       
        if(Amdp.getText().equals(AuthentificationController.LoggedAdmin.getMdp())){
        Admin a= new Admin(AuthentificationController.LoggedAdmin.getId_user(),AuthentificationController.LoggedAdmin.getPseudo(),Nmdp.getText(),AuthentificationController.LoggedAdmin.getEmail());
        AdminService as=new AdminService();
        as.update(a);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Sécurité");
            alert.setHeaderText("Votre mot de passe a été changé");
            Optional<ButtonType> result = alert.showAndWait();
        Tpseudo.clear();
        Amdp.clear();
            Nmdp.clear();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Mot de passe");
            alert.setHeaderText("Mot de passe incorrecte");
            Optional<ButtonType> result = alert.showAndWait();
            Amdp.clear();
            Nmdp.clear();
        }
    }

    @FXML
    private void fermer(ActionEvent event) {
        flou.setVisible(false);
       anCompte.setVisible(false);
       Tparam.setVisible(true);
       Param.setVisible(true);
    }

    @FXML
    private void parametrage2(ActionEvent event) {
        Param.setVisible(false);
        Tparam.setVisible(false);
        param2.setVisible(false);
        param1.setVisible(true);
        triangle.setVisible(false);
        triangle1.setVisible(true);
    }

    @FXML
    private void gestionQuiz(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionQuiz.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        
    }
    
    
    private void afficherListeLivraisons()
    {
         LivraisonService ps = new LivraisonService() ; 
            tableL.setItems(null);
            tableL.setItems(ps.getAll2());
              //client.setCellFactory(new PropertyValueFactory<>("id_parent"));
            livreur.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Livraison, Image>, ObservableValue<Image>>() {
                @Override
                public ObservableValue<Image> call(TableColumn.CellDataFeatures<Livraison, Image> param) {
                    Livraison p = param.getValue() ; 
                    LivreurService ps = new LivreurService() ; 
                    Livreur pr = ps.search(p.getId_livreur()) ; 
                    String s="file:/C:/wamp/www/ressources/";
                    return new SimpleObjectProperty<>(new Image(s+pr.getImage(), 80, 80, true, true, true));
                }
            }) ; 
            livreur.setCellFactory(new Callback<TableColumn<Livraison, Image>, TableCell<Livraison, Image>>() {
                @Override
                public TableCell<Livraison, Image> call(TableColumn<Livraison, Image> param) {
                    return new TableCell<Livraison, Image>(){
                        @Override
                    protected void updateItem(Image i, boolean empty) {
                        super.updateItem(i, empty);
                        setText(null);
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        //ImageView imageV =  new ImageView() ; 
                        ImageView imageV = (i == null || empty) ? null : ImageViewBuilder.create().image(i).build();
                        //final Circle clip = new Circle(30,40,25);
                        //imageV.setClip(clip);
                        setGraphic(imageV);
                    }
                } ; 
                }
            });
            produit1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Livraison, Image>, ObservableValue<Image>>() {
                @Override
                public ObservableValue<Image> call(TableColumn.CellDataFeatures<Livraison, Image> param) {
                    Livraison p = param.getValue() ;
                    ProduitService ps = new ProduitService() ; 
                    Produit pr = ps.search(p.getId_produit()) ; 
                    String s="file:/C:/wamp/www/ressources/";
                    return new SimpleObjectProperty<>(new Image(s+pr.getImage(), 80, 80, true, true, true));
                }
            }) ; 
            produit1.setCellFactory(new Callback<TableColumn<Livraison, Image>, TableCell<Livraison, Image>>() {
                @Override
                public TableCell<Livraison, Image> call(TableColumn<Livraison, Image> param) {
                    return new TableCell<Livraison, Image>(){
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
      duree.setCellValueFactory(new PropertyValueFactory<>("duree"));
     adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        
      
      
        
    }
    
}
