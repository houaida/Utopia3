/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Admin;
import allforkids.entite.Commande;
import allforkids.entite.LigneCommande;
import allforkids.entite.Parent;
import allforkids.entite.Produit;
import allforkids.service.CommandeService;
import allforkids.service.LigneCommandeService;
import allforkids.service.ParentService;
import allforkids.service.ProduitService;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import javafx.scene.shape.Circle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class AccueilAdminController implements Initializable {

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
    private TableColumn<Commande, String> date;
    @FXML
    private ToggleButton page1;
    @FXML
    private ToggleButton page2;
    @FXML
    private ToggleButton fleche2;
    @FXML
    private ToggleButton fleche1;
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
        AnchorPane1.setPrefSize(1329,866);
               
        afficherUser(AuthentificationController.LoggedAdmin);
        afficherListeProduits();
    }    

    @FXML
    private void afficher(ActionEvent event) {
         AnchorPane2.setVisible(true);
       retire.setVisible(true);
    }
    private void afficherUser(Admin a) {
        pseudo.setText(a.getPseudo());
        
        
        String imageFile =a.getImage();
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
                    
                    return new SimpleObjectProperty<>(new Image(pr.getImage(), 80, 80, true, true, true));
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
                    return new SimpleObjectProperty<>(new Image(pr.getImage(), 80, 80, true, true, true));
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

    @FXML
    private void gestionUtilisateur(ActionEvent event) throws IOException {
          AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionUser.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        
    }
    
}
