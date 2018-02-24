/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import static allforkids.GUI.ListeProduitsController.LoggedUser;
import allforkids.entite.Produit;
import allforkids.service.ProduitService;
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
                          Image img = new Image(p.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
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
                          Image img = new Image(p.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
                          setText("Nom : "+p.getNom()+"\n Catégorie : "+p.getCatégorie()+"\n Quantite disponible : "+p.getQuantite()+"\n Prix : "+p.getPrix_produit()+"\n Description : "+p.getDescription());                      }
                  }
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
                          Image img = new Image(p.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
                          setText("Nom : "+p.getNom()+"\n Catégorie : "+p.getCatégorie()+"\n Quantite disponible : "+p.getQuantite()+"\n Prix : "+p.getPrix_produit()+"\n Description : "+p.getDescription());                      }
                  }
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
                          Image img = new Image(p.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
                          setText("Nom : "+p.getNom()+"\n Catégorie : "+p.getCatégorie()+"\n Quantite disponible : "+p.getQuantite()+"\n Prix : "+p.getPrix_produit()+"\n Description : "+p.getDescription());                      }
                  }
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
    
   
    
    /*@FXML 
    public void onSelect (){
           if (!listeP.getSelectionModel().isEmpty()){
           NomP.setText(listeP.getSelectionModel().getSelectedItem().getNom());
           comBox.setValue(listeP.getSelectionModel().getSelectedItem().getCatégorie()) ; 
           comBox2.setValue(listeP.getSelectionModel().getSelectedItem().getPrix_produit());
           Desc.setText(listeP.getSelectionModel().getSelectedItem().getDescription());
            //imgPath.setText(listeP.getSelectionModel().getSelectedItem().getImage().toString());
           }
    }*/
    
  
  /*  @FXML
    private void afficherimage(MouseEvent event){
        if (event.getClickCount() == 1) //Checking double click
       {
            imgV.setImage(null);
            //int S = listeP.getSelectionModel().getSelectedItem().getId_produit();
            //Produit p = new Produit() ; 
            /*ProduitService ps = new ProduitService();
            Produit p = ps.search(S) ; */
        //    String imageFile = imgPath.getText() ; 
            //String imageFile = p.getImage() ; 
            //String imageFile = (ps.search(listeP.getSelectionModel().getSelectedItem().getId_produit()).getImage());
    /*        System.out.println(imageFile);
            Image image1 = new Image(imageFile);
            imgV.setImage(image1);
      }
    }*/

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
    
    
    
}
