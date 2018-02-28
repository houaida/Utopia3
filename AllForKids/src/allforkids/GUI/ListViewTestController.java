/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import static allforkids.GUI.ListeProduitsController.LoggedUser;
import allforkids.entite.Produit;
import allforkids.entite.Promotion;
import allforkids.service.ProduitService;
import allforkids.service.PromotionService;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Molka
 */
public class ListViewTestController implements Initializable {
    
     public static Produit LoggedUser;
     
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
   private ListView<Produit> liste1 ;
    @FXML
   private ListView<Produit> liste2 ;
    @FXML
   private ListView<Produit> liste3 ;
    @FXML
   private ListView<Produit> liste4 ;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ToggleButton gestionPrduit;
    @FXML
    private ToggleButton retire;
    @FXML
    private Button btretour;
    @FXML
    private ToggleButton fleche2;
    @FXML
    private ToggleButton fleche1;
    @FXML
    private AnchorPane anB;
   
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
        afficherListeProduits1() ;
        afficherListeProduits2() ;
        afficherListeProduits3() ;
        afficherListeProduits() ;
        //onSelect(); 
        LoggedUser = new Produit();
       
      /*  LoggedUser.setId_produit(liste1.getSelectionModel().getSelectedItem().getId_produit());
        LoggedUser.setNom(liste1.getSelectionModel().getSelectedItem().getNom());
        LoggedUser.setCatégorie(liste1.getSelectionModel().getSelectedItem().getCatégorie());
        LoggedUser.setPrix_produit(liste1.getSelectionModel().getSelectedItem().getPrix_produit()); 
        LoggedUser.setDescription(liste1.getSelectionModel().getSelectedItem().getDescription());*/
     
       liste1.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends Produit> ov,  Produit old_val, 
            Produit new_val) -> {
                System.out.println(new_val);
                LoggedUser.setId_produit(new_val.getId_produit());
        LoggedUser.setNom(new_val.getNom());
        LoggedUser.setCatégorie(new_val.getCatégorie());
        LoggedUser.setPrix_produit(new_val.getPrix_produit()); 
        LoggedUser.setDescription(new_val.getDescription());
        LoggedUser.setImage(new_val.getImage());
        LoggedUser.setQuantite(new_val.getQuantite());
        
            System.out.println(LoggedUser.getNom());
    }); 
       
        liste2.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends Produit> ov,  Produit old_val, 
            Produit new_val) -> {
                System.out.println(new_val);
                 LoggedUser.setId_produit(new_val.getId_produit());
        LoggedUser.setNom(new_val.getNom());
        LoggedUser.setCatégorie(new_val.getCatégorie());
        LoggedUser.setPrix_produit(new_val.getPrix_produit()); 
        LoggedUser.setDescription(new_val.getDescription());
        LoggedUser.setImage(new_val.getImage());
        LoggedUser.setQuantite(new_val.getQuantite());
        
            System.out.println(LoggedUser.getNom());
    }); 
        
         liste3.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends Produit> ov,  Produit old_val, 
            Produit new_val) -> {
                System.out.println(new_val);
                 LoggedUser.setId_produit(new_val.getId_produit());
        LoggedUser.setNom(new_val.getNom());
        LoggedUser.setCatégorie(new_val.getCatégorie());
        LoggedUser.setPrix_produit(new_val.getPrix_produit()); 
        LoggedUser.setDescription(new_val.getDescription());
        LoggedUser.setImage(new_val.getImage());
        LoggedUser.setQuantite(new_val.getQuantite());
        
            System.out.println(LoggedUser.getNom());
    }); 
          liste4.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends Produit> ov,  Produit old_val, 
            Produit new_val) -> {
                System.out.println(new_val);
                 LoggedUser.setId_produit(new_val.getId_produit());
        LoggedUser.setNom(new_val.getNom());
        LoggedUser.setCatégorie(new_val.getCatégorie());
        LoggedUser.setPrix_produit(new_val.getPrix_produit()); 
        LoggedUser.setDescription(new_val.getDescription());
        LoggedUser.setImage(new_val.getImage());
        LoggedUser.setQuantite(new_val.getQuantite());
        
            System.out.println(LoggedUser.getNom());
    }); 
        
        
    }  
    

   public void afficherListeProduits1()
       {
          ProduitService ps = new ProduitService() ;
          ObservableList<Produit> lp = ps.SearchCatégorie("jouets"); 
          
          liste1.setCellFactory((ListView<Produit> param) -> {
              ListCell<Produit> cell = new ListCell<Produit>() {
                  @Override
                  protected void updateItem(Produit p , boolean bl) {
                      super.updateItem(p, bl);
                      
                      if(p!=null){
                           AnchorPane pane=new AnchorPane();
                           //AnchorPane pane2=new AnchorPane();
                          PromotionService pss = new PromotionService() ; 
                          Promotion p1 =null;
                          p1= pss.searchIdProd(p.getId_produit()) ; 
                          Image img1 = new Image("file:/C:/wamp/www/ressources/promo.png", 50,50, true, true, true) ;
                              ImageView iv = new ImageView(img1);
                              String s="file:/C:/wamp/www/ressources/";
                          Image img = new Image(s+p.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          System.out.println("pppppppppppppppppppppppp1111111111111"+p1);
                          if(p1!=null){
                             
                         iv.setY(5);
                         iv.setX(300);
                        //  pane2.getChildren().addAll(iv);
                         pane.getChildren().addAll(iv,imgV);
                        // setGraphic(pane2);
  
                         
                          }
                          else {
                          
                          pane.getChildren().addAll(imgV);
                         //setGraphic(pane);
                      }
                          setGraphic(pane);
                         setText("Nom : "+p.getNom()+"\n Catégorie : "+p.getCatégorie()+"\n Quantite disponible : "+p.getQuantite()+"\n Prix : "+p.getPrix_produit()+"\n Description : "+p.getDescription());


                      }                


                  }
              } ; return cell ;
          });
      liste1.setItems(lp);
           
       } 
    
     public void afficherListeProduits2()
       {
          ProduitService ps = new ProduitService() ;
          ObservableList<Produit> lp = ps.SearchCatégorie("vêtements"); 
          
          liste2.setCellFactory((ListView<Produit> param) -> {
              ListCell<Produit> cell = new ListCell<Produit>() {
                  @Override
                  protected void updateItem(Produit p , boolean bl) {
                      super.updateItem(p, bl);
                     if(p!=null){
                           AnchorPane pane=new AnchorPane();
                           //AnchorPane pane2=new AnchorPane();
                          PromotionService pss = new PromotionService() ; 
                          Promotion p1 =null;
                          p1= pss.searchIdProd(p.getId_produit()) ; 
                          Image img1 = new Image("file:/C:/wamp/www/ressources/promo.png", 50,50, true, true, true) ;
                              ImageView iv = new ImageView(img1);
                              String s="file:/C:/wamp/www/ressources/";
                          Image img = new Image(s+p.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          System.out.println("pppppppppppppppppppppppp1111111111111"+p1);
                          if(p1!=null){
                             
                         iv.setY(5);
                         iv.setX(300);
                        //  pane2.getChildren().addAll(iv);
                         pane.getChildren().addAll(iv,imgV);
                        // setGraphic(pane2);
  
                         
                          }
                          else {
                          
                          pane.getChildren().addAll(imgV);
                         //setGraphic(pane);
                      }
                          setGraphic(pane);
                         setText("Nom : "+p.getNom()+"\n Catégorie : "+p.getCatégorie()+"\n Quantite disponible : "+p.getQuantite()+"\n Prix : "+p.getPrix_produit()+"\n Description : "+p.getDescription());


                      } }
              } ; return cell ;
          });
      liste2.setItems(lp);
           
       }
     public void afficherListeProduits3()
       {
          ProduitService ps = new ProduitService() ;
          ObservableList<Produit> lp = ps.SearchCatégorie("fournitures"); 
          
          liste3.setCellFactory((ListView<Produit> param) -> {
              ListCell<Produit> cell = new ListCell<Produit>() {
                  @Override
                  protected void updateItem(Produit p , boolean bl) {
                      super.updateItem(p, bl);
                      if(p!=null){
                           AnchorPane pane=new AnchorPane();
                           //AnchorPane pane2=new AnchorPane();
                          PromotionService pss = new PromotionService() ; 
                          Promotion p1 =null;
                          p1= pss.searchIdProd(p.getId_produit()) ; 
                          Image img1 = new Image("file:/C:/wamp/www/ressources/promo.png", 50,50, true, true, true) ;
                              ImageView iv = new ImageView(img1);
                              String s="file:/C:/wamp/www/ressources/";
                          Image img = new Image(s+p.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          System.out.println("pppppppppppppppppppppppp1111111111111"+p1);
                          if(p1!=null){
                             
                         iv.setY(5);
                         iv.setX(300);
                        //  pane2.getChildren().addAll(iv);
                         pane.getChildren().addAll(iv,imgV);
                        // setGraphic(pane2);
  
                         
                          }
                          else {
                          
                          pane.getChildren().addAll(imgV);
                         //setGraphic(pane);
                      }
                          setGraphic(pane);
                         setText("Nom : "+p.getNom()+"\n Catégorie : "+p.getCatégorie()+"\n Quantite disponible : "+p.getQuantite()+"\n Prix : "+p.getPrix_produit()+"\n Description : "+p.getDescription());


                      } }
              } ; return cell ;
          });
      liste3.setItems(lp);
           
       }
     
      public void afficherListeProduits()
       {
          ProduitService ps = new ProduitService() ;
          ObservableList<Produit> lp = ps.getAll() ; 
          
          liste4.setCellFactory((ListView<Produit> param) -> {
              ListCell<Produit> cell = new ListCell<Produit>() {
                  @Override
                  protected void updateItem(Produit p , boolean bl) {
                      super.updateItem(p, bl);
                     if(p!=null){
                           AnchorPane pane=new AnchorPane();
                           //AnchorPane pane2=new AnchorPane();
                          PromotionService pss = new PromotionService() ; 
                          Promotion p1 =null;
                          p1= pss.searchIdProd(p.getId_produit()) ; 
                          Image img1 = new Image("file:/C:/wamp/www/ressources/promo.png", 50,50, true, true, true) ;
                              ImageView iv = new ImageView(img1);
                              String s="file:/C:/wamp/www/ressources/";
                          Image img = new Image(s+p.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          System.out.println("pppppppppppppppppppppppp1111111111111"+p1);
                          if(p1!=null){
                             
                         iv.setY(5);
                         iv.setX(300);
                        //  pane2.getChildren().addAll(iv);
                         pane.getChildren().addAll(iv,imgV);
                        // setGraphic(pane2);
  
                         
                          }
                          else {
                          
                          pane.getChildren().addAll(imgV);
                         //setGraphic(pane);
                      }
                          setGraphic(pane);
                         setText("Nom : "+p.getNom()+"\n Catégorie : "+p.getCatégorie()+"\n Quantite disponible : "+p.getQuantite()+"\n Prix : "+p.getPrix_produit()+"\n Description : "+p.getDescription());


                      } }
              } ; return cell ;
          });
      liste4.setItems(lp);
           
       }
  //listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    @FXML
      public void onselect(MouseEvent event){
          if(event.getClickCount() == 2){
        try {
       
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ProduitDetails.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

        } catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
          }
      }
    

    @FXML
    private void gotoDemandeTravail(MouseEvent event) {
    }

    @FXML
    private void boutique(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("listViewTest.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void retirer(ActionEvent event) {
         AnchorPane2.setVisible(false);
        retire.setVisible(false);
    }

    @FXML
    private void afficher(ActionEvent event) {
        AnchorPane2.setVisible(true);
       retire.setVisible(true);
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilParent.fxml"));
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
    private void Offres(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("OffreDemande.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
   
    private void Demandes(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("demande.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    } 

    @FXML
    private void voirWishlist(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("LigneCommandes.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }


   
    
    
    
}
