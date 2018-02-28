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
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.scene.Scene;
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
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.NativeObject;

/**
 * FXML Controller class
 *
 * @author Molka
 */
public class LigneCommandesController implements Initializable {

     public static LigneCommande LoggedCommande;
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
    private JFXButton imprimer;
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
                         CommandeService cs = new CommandeService() ; 
                         Commande c = cs.searchIdLigne(p.getId_ligne()) ; 
                         if(c!=null){
                          //System.out.println(p2);
                          String s="file:/C:/wamp/www/ressources/";
                          Image img = new Image(s+p2.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
                          setText("Nom : "+p2.getNom()+"\n Catégorie : "+p2.getCatégorie()+"\n prix : "+p.getPrix_produit()+"\n"+"Quantite : "+p.getQuantite()+"\n"+"Description : "+p2.getDescription()+"\n\n\n"+"                                                                                                                      Commandé! "); 
                        // setText("Prix : "+p.getPrix_produit());
                         } else {
                              String s="file:/C:/wamp/www/ressources/";
                          Image img = new Image(s+p2.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
                          setText("Nom : "+p2.getNom()+"\n Catégorie : "+p2.getCatégorie()+"\n prix : "+p.getPrix_produit()+"\n"+"Quantite : "+p.getQuantite()+"\n"+"Description : "+p2.getDescription()); 
                             
                         }
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
                          String s="file:/C:/wamp/www/ressources/";
                          Image img = new Image(s+p2.getImage(), 300, 300, true, true, true) ;
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
     public void onclickCommander(ActionEvent event) throws IOException{
       //   
          LigneCommandeService ls = new LigneCommandeService()  ; 
          ObservableList<LigneCommande> selection = wishlist.getSelectionModel().getSelectedItems() ; 
        for(LigneCommande l : selection){
           
            Commande c = new Commande(AuthentificationController.LoggedParent.getId_user(), l.getId_ligne(), l.getQuantite()*l.getPrix_produit()) ;
            ParentService ps = new ParentService() ; 
            Parent p = ps.search(AuthentificationController.LoggedParent.getId_user()) ; 
            if(p.getMontant()>=c.getTotal()){
                //////label
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("commande");
            alert.setHeaderText("Merci d'avoir commander un produit de AllForKids :) Voulez-vous une livraison ?") ; 
     Optional<ButtonType> result = alert.showAndWait();
     if (result.get() == ButtonType.CANCEL) {
         CommandeService cs = new CommandeService() ;
            cs.insert(c);
     ProduitService prs = new ProduitService() ; 
     Produit pr = prs.search(l.getId_produit()) ; 
     int qte ; 
     qte = pr.getQuantite()-l.getQuantite() ;
     
     Parent p2 = new Parent(p.getId_user(), p.getCin(), p.getNom(), p.getPrenom(), p.getPseudo(), p.getMdp(), p.getEmail(), p.getAdresse(), p.getMontant()-c.getTotal(), p.getType(), p.getImage(),p.getNum_tel()); 
      ps.update(p2) ; 
     if(qte==0){
         prs.delete(pr.getId_produit()) ; 
     }else {
              Produit pr2 = new Produit(pr.getId_produit(), pr.getNom(), pr.getCatégorie(), pr.getPrix_produit(), pr.getDescription(), pr.getImage(),qte) ; 
        
     prs.update(pr2) ; } }
     //////livraison
     else {
          CommandeService cs = new CommandeService() ;
            cs.insert(c);
     ProduitService prs = new ProduitService() ; 
     Produit pr = prs.search(l.getId_produit()) ; 
     int qte  ; 
     qte = pr.getQuantite()-l.getQuantite() ; 
         
     Parent p2 = new Parent(p.getId_user(), p.getCin(), p.getNom(), p.getPrenom(), p.getPseudo(), p.getMdp(), p.getEmail(), p.getAdresse(), p.getMontant()-c.getTotal(), p.getType(), p.getImage(),p.getNum_tel()); 
    ps.update(p2) ; 
     if(qte==0){
         prs.delete(pr.getId_produit()) ; 
     }else {
              Produit pr2 = new Produit(pr.getId_produit(), pr.getNom(), pr.getCatégorie(), pr.getPrix_produit(), pr.getDescription(), pr.getImage(), qte) ; 
     prs.update(pr2) ;  } 
        /*  AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Livraison.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);*/
     AnchorPane1.setPrefSize(600,400);
                 Stage stage = new Stage();
                     //  ((Node) event.getSource()).getScene().getWindow().hide();
                        javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("Livraison.fxml"));
                        Scene scene = new Scene(root);

                        

                        stage.setScene(scene);
                        stage.show();}
            } else 
            { Alert alert3 = new Alert(Alert.AlertType.WARNING);
            alert3.setTitle("commande");
            alert3.setHeaderText("Votre montant est insuffisant :( Veuillez recharger votre carte bancaire !") ; 
     Optional<ButtonType> result = alert3.showAndWait();}       
        }
        afficherListeProduits() ;
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

    
    @FXML
    private void onclickImprimer(ActionEvent event) throws FileNotFoundException, DocumentException, IOException {
       
        
        
        
         LigneCommandeService ls = new LigneCommandeService()  ; 
          ObservableList<LigneCommande> selection = wishlist.getSelectionModel().getSelectedItems() ; 
        for(LigneCommande l : selection){
            
                  CommandeService cs = new CommandeService() ; 
           Commande c = cs.searchIdLigne(l.getId_ligne()) ; 
            if(c!=null){
            
            Document doc = new Document() ; 
        PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Molka\\Desktop\\Commande2.pdf")) ;
        doc.open() ; 
             ProduitService ps = new ProduitService() ; 
                         Produit p2 = ps.search(l.getId_produit()) ;
                         doc.add(new Paragraph("**********************************")) ; 
            doc.add(new Paragraph("Commande sur le produit : "+p2.getNom())) ; 
            doc.add(new Paragraph("Catégorie : "+p2.getCatégorie())) ; 
            doc.add(new Paragraph("Prix : "+p2.getPrix_produit())) ; 
            doc.add(new Paragraph("Quantite : "+l.getQuantite())) ; 
            doc.add(new Paragraph("Description : "+p2.getDescription())) ; 
             doc.add(new Paragraph("**********************************")) ;
              doc.add(new Paragraph("Merci d'avoir commander un produit de AllForKids :) Maintenant vous pouvez partager avec nous vos avis dans des petits commentaires dans des buts d'amélioration")) ; 
            String s="file:/C:/wamp/www/ressources/";
            Image img = new Image(s+p2.getImage()) ; 
            System.out.println("image"+img);
            /*Image img = new Image(s+p2.getImage(), 300, 300, true, true, true) ;
            doc.add(img); */
            doc.close();
            Desktop.getDesktop().open(new File("C:\\Users\\Molka\\Desktop\\Commande2.pdf"));
            }
            else {
                 Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.setTitle("Imprimer Commande");
            alert.setHeaderText("Vous n'avez pas encore commander ce produit") ; 
     Optional<ButtonType> result = alert.showAndWait();
            }
            
        }
        
    }
     
     
    
}
