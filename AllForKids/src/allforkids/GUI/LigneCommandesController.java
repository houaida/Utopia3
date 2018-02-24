/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import static allforkids.GUI.ListViewTestController.LoggedUser;
import allforkids.entite.Commande;
import allforkids.entite.LigneCommande;
import allforkids.entite.Parent;
import allforkids.entite.Produit;
import allforkids.service.CommandeService;
import allforkids.service.LigneCommandeService;
import allforkids.service.ParentService;
import allforkids.service.ProduitService;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import jdk.nashorn.internal.objects.NativeObject;

/**
 * FXML Controller class
 *
 * @author Molka
 */
public class LigneCommandesController implements Initializable {

     public static LigneCommande LoggedUser;
    @FXML 
    private ListView<LigneCommande> wishlist ; 
    @FXML 
    private TextField search ; 
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ToggleButton retire;
    @FXML
    private ToggleButton rechercher;
    @FXML
    private ToggleButton supprimer;
    @FXML
    private ToggleGroup menu;
    @FXML
    private JFXButton commnader;
    @FXML
    private ToggleButton gestionPrduit;
    /*@FXML 
    private ComboBox<Integer> combox ; */
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       /*   ;*/
         
        afficherListeProduits() ; 
          
    }    
    
     public void afficherListeProduits()
       {
           LigneCommandeService ls = new LigneCommandeService() ; 
           ObservableList<LigneCommande> lc = ls.getAll() ; 
        
          
          wishlist.setCellFactory((ListView<LigneCommande> param) -> {
              ListCell<LigneCommande> cell = new ListCell<LigneCommande>() {
                  @Override
                  protected void updateItem(LigneCommande p , boolean bl) {
                      super.updateItem(p, bl);
                      if(p!=null){
                         ProduitService ps = new ProduitService() ; 
                         Produit p2 = ps.search(p.getId_produit()) ;
                          //System.out.println(p2);
                          Image img = new Image(p2.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
                          setText("Nom : "+p2.getNom()+"\n Catégorie : "+p2.getCatégorie()+"\n prix : "+p.getPrix_produit()+"\n"+"Quantite : "+p.getQuantite()+"Description : "+p2.getDescription()); 
                        // setText("Prix : "+p.getPrix_produit());
                      }
                  }
              } ; return cell ;
          });
      wishlist.setItems(lc);
           
       }
     
     @FXML
     public void supprimerProduit(){
         LigneCommandeService ls = new LigneCommandeService()  ; 
        ObservableList<LigneCommande> selection = wishlist.getSelectionModel().getSelectedItems() ; 
        for(LigneCommande l : selection){
            ls.delete(l.getId_ligne()) ; 
        }
       // LigneCommande l = new LigneCommande() ; 
            //ls.delete(l.getId_ligne()) ; 
        

         afficherListeProduits() ;
       
     } 
     
    @FXML 
     public void rechercherProduit(){
         LigneCommandeService ls = new LigneCommandeService()  ; 
       // ObservableList<LigneCommande> selection = wishlist.getSelectionModel().getSelectedItems() ;
       //  for(LigneCommande l : selection){
        ObservableList<LigneCommande> lc =  ls.seachCategorie(search.getText()) ; 
      wishlist.setCellFactory((ListView<LigneCommande> param) -> {
              ListCell<LigneCommande> cell = new ListCell<LigneCommande>() {
                  @Override
                  protected void updateItem(LigneCommande p , boolean bl) {
                      super.updateItem(p, bl);
                      if(p!=null){
                         ProduitService ps = new ProduitService() ; 
                         Produit p2 = ps.search(p.getId_produit()) ;
                          //System.out.println(p2);
                          Image img = new Image(p2.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
                          setText("Nom : "+p2.getNom()+"\n Catégorie : "+p2.getCatégorie()+"\n prix : "+p.getPrix_produit()+"\n"+"Quantite : "+p.getQuantite()+"Description : "+p2.getDescription()); 
                        // setText("Prix : "+p.getPrix_produit());
                      }
                  }
              } ; return cell ;
          });
      wishlist.setItems(lc);
           
       }
     
     @FXML 
     public void onclickCommander(ActionEvent event){
       //   
          LigneCommandeService ls = new LigneCommandeService()  ; 
          ObservableList<LigneCommande> selection = wishlist.getSelectionModel().getSelectedItems() ; 
        for(LigneCommande l : selection){
            Commande c = new Commande(AuthentificationController.LoggedParent.getId_user(), l.getId_ligne(), l.getQuantite()*l.getPrix_produit()) ;
            ParentService ps = new ParentService() ; 
            Parent p = ps.search(AuthentificationController.LoggedParent.getId_user()) ; 
            if(p.getMontant()>=c.getTotal()){
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("commande");
            alert.setHeaderText("Merci d'avoir commander un produit de AllForKids :) we love you ,Do you need a delivery?? ") ; 
     Optional<ButtonType> result = alert.showAndWait();
     if (result.get() == ButtonType.CANCEL) {
      
        
         
         CommandeService cs = new CommandeService() ;
            cs.insert(c);
           
     ProduitService prs = new ProduitService() ; 
     Produit pr = prs.search(l.getId_produit()) ; 
     Produit pr2 = new Produit(pr.getId_produit(), pr.getNom(), pr.getCatégorie(), pr.getPrix_produit(), pr.getDescription(), pr.getImage(), pr.getQuantite()-l.getQuantite()) ; 
     prs.update(pr2) ; 
     Parent p2 = new Parent(p.getId_user(), p.getCin(), p.getNom(), p.getPrenom(), p.getPseudo(), p.getMdp(), p.getEmail(), p.getAdresse(), p.getMontant()-c.getTotal(), p.getType(), p.getImage(),p.getNum_tel()); 
     ps.update(p2) ;  } 
     //else livraison.fxml 
       
        
            } else 
            { Alert alert3 = new Alert(Alert.AlertType.WARNING);
            alert3.setTitle("commande");
            alert3.setHeaderText("VOTRE MONTANT EST INSUFFISANT ! VEUILLEZ RECHARGER VOTRE CARTE BANCAIRE ") ; 
     Optional<ButtonType> result = alert3.showAndWait();}
                 
        }
        afficherListeProduits() ;
        /* try {
       
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeCommandes.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

        } catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } */
                 
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
    private void gotoDemandeTravail(MouseEvent event) {
    }

    @FXML
    private void boutique(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("listViewTest.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
     
     
    
}
