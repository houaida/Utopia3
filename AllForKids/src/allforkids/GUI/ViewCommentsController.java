/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Commentaire;
import allforkids.entite.Parent;
import allforkids.entite.Produit;
import allforkids.service.CommentaireService;
import allforkids.service.ParentService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Molka
 */
public class ViewCommentsController implements Initializable {
    
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private Text nom ; 
    @FXML
    private Text categorie ; 
    @FXML
    private Text prix ; 
    @FXML
    private Text description ; 
    @FXML 
    private ImageView image ; 
    @FXML
    private ListView<Commentaire> listeC ;
    @FXML
    private Text count ; 
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
    private Button btretour;
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
        afficher(ListeProduitsController.LoggedUser) ; 
        System.out.println("imgggggggg"+ListeProduitsController.LoggedUser.getImage());
        afficherCommment(); 
    }    
    
     public void afficher(Produit u)
       {
         
            nom.setText("Nom : "+u.getNom());
            categorie.setText("Catégorie : "+u.getCatégorie());
            prix.setText("Prix : "+u.getPrix_produit()+" DT");
            description.setText("Description : "+u.getDescription());
            String imageFile = u.getImage() ; 
            Image image1 = new Image(imageFile);
            image.setImage(image1);
       } 
    
    public void afficherCommment(){
        CommentaireService cs = new CommentaireService() ; 
        ObservableList<Commentaire>  lc = cs.getAllById(ListeProduitsController.LoggedUser.getId_produit()) ; 
        System.out.println("**********id prod :"+ListeProduitsController.LoggedUser.getId_produit());
        count.setText("Nombre de commentaires total : "+lc.size()+" commentaires");
          listeC.setCellFactory((ListView<Commentaire> param) -> {
              ListCell<Commentaire> cell = new ListCell<Commentaire>() {
                  @Override
                  protected void updateItem(Commentaire p , boolean bl) {
                      super.updateItem(p, bl);
                      if(p!=null){

                          
                          ParentService ps = new ParentService() ; 
                          Parent pr = ps.search(p.getId_parent()) ; 
                          System.out.println("***********************");
                          System.out.println("parents : "+pr);
                          System.out.println("***********************"); 
                          Image img = new Image(pr.getImage(), 80, 80, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
final Circle clip = new Circle(30,40,25);
imgV.setClip(clip);
        
        
                          setGraphic(imgV);
                          setText(pr.getNom()+" a commenté :"+"\n"+p.getContenu()+"\n");
                          
                      }
                  }
              } ; return cell ;
          });
      listeC.setItems(lc);
    }
    
        @FXML 
    public void OnZoomIn2(MouseEvent event){
        
            double w =image.getFitWidth() ;
            double h = image.getFitHeight() ; 
            image.setFitHeight(h+25);
            image.setFitWidth(w+25);
        
    }
    
     @FXML 
    public void OnZoomOut2(MouseEvent event){
        
            double w =image.getFitWidth() ;
            double h = image.getFitHeight() ; 
            image.setFitHeight(h-25);
            image.setFitWidth(w-25);
        
    }

   @FXML
    private void gestionProduit(ActionEvent event) throws IOException {
          AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("listeProduits.fxml"));
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
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeProduits.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    
    private void page1(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilAdmin.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    private void page2(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Page2.fxml"));
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
    private void gotoDemandeTravail(MouseEvent event) {
    }
    
}
