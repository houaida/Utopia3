/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import static allforkids.GUI.ListViewTestController.LoggedUser;
import static allforkids.GUI.ListeProduitsController.LoggedUser;
import allforkids.entite.Commentaire;
import allforkids.entite.LigneCommande;
import allforkids.entite.Parent;
import allforkids.entite.Produit;
import allforkids.service.CommentaireService;
import allforkids.service.LigneCommandeService;
import allforkids.service.ParentService;
import allforkids.service.ProduitService;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
//import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Molka
 */
public class ProduitDetailsController implements Initializable {

      public static LigneCommande LoggedUser;
    @FXML 
    private ImageView image ; 
    @FXML 
    private Text nom ; 
    @FXML 
    private Text categorie ; 
    @FXML 
    private Text prix ; 
    @FXML 
    private Text desc ; 
    @FXML 
    private ComboBox<Integer> comb ;
    @FXML 
    private ListView<Commentaire> listeC ; 
    @FXML 
    private TextArea commentaire ; 
   
     
    
   //  private ScrollPane scrollPane = new ScrollPane();
   // final DoubleProperty zoomProperty = new SimpleDoubleProperty(200);
    
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ToggleButton gestionPrduit;
    @FXML
    private ToggleButton retire;
    @FXML
    private Button btretour;
    @FXML
    private ToggleButton ajoutbt;
    @FXML
    private ToggleButton btmod;
    @FXML
    private ToggleGroup menu;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Integer> ol = FXCollections.observableArrayList();
        for(int i = 0 ; i<ListViewTestController.LoggedUser.getQuantite(); i++){
            ol.add(i) ; 
        }
         comb.setItems(ol);
       
        afficher(ListViewTestController.LoggedUser) ; 
        afficherCommment();
        
        
       
       
    }    
    
    
   public void afficher(Produit u)
       {
         
            nom.setText("Nom : "+u.getNom());
            categorie.setText("Catégorie : "+u.getCatégorie());
            prix.setText("Prix : "+u.getPrix_produit()+" DT");
            desc.setText("Description : "+u.getDescription());
            String imageFile = u.getImage() ; 
            Image image1 = new Image(imageFile);
            image.setImage(image1);
       } 
   
    @FXML
    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListViewTest.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    
    @FXML
    private void onclick(ActionEvent event) throws IOException {
        ProduitService ps = new ProduitService()  ;
        LigneCommandeService ls = new LigneCommandeService() ; 
        Produit p = ps.searchImg(ListViewTestController.LoggedUser.getImage()) ;
       // System.out.println(p);
        LigneCommande l = new LigneCommande(p.getId_produit(),p.getPrix_produit(),comb.getValue()) ; 
      //  System.out.println(l);
        ls.insert(l);
        LoggedUser = new LigneCommande(); 
        LoggedUser.setId_produit(l.getId_produit());
      //  System.out.println(LoggedUser.getId_produit());
        try {
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ligneCommandes.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        }catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @FXML 
    public void supprimerCommentaire(ActionEvent event){
        CommentaireService cs = new CommentaireService() ; 
        ObservableList<Commentaire> selection = listeC.getSelectionModel().getSelectedItems() ; 
        for(Commentaire l : selection){
            if(l.getId_parent()==AuthentificationController.LoggedParent.getId_user()){
            cs.delete(l.getId_commentaire()) ; }
            else {Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setHeaderText("Sorry you cannot edit someone else's comment!");
            Optional<ButtonType> result = alert.showAndWait();} 
        }
        afficherCommment();
    }
    
    @FXML 
    public void modifierCommentaire(ActionEvent event){
        CommentaireService cs = new CommentaireService() ; 
        ObservableList<Commentaire> selection = listeC.getSelectionModel().getSelectedItems() ; 
        for(Commentaire l : selection){
             if(l.getId_parent()==AuthentificationController.LoggedParent.getId_user()){
                 Commentaire c = new Commentaire(l.getId_commentaire(),l.getId_produit(), l.getId_parent(), commentaire.getText()) ; 
                 cs.update(c) ; 
             }else {Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setHeaderText("Sorry you cannot edit someone else's comment!");
            Optional<ButtonType> result = alert.showAndWait();} 
        }
        afficherCommment(); 
    }

    
    public void afficherCommment(){
        CommentaireService cs = new CommentaireService() ; 
        ObservableList<Commentaire>  lc = cs.getAllById(ListViewTestController.LoggedUser.getId_produit()) ; 
        
      
// System.out.println("********** id produit supposé 1 : "+ListViewTestController.LoggedUser.getId_produit());
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
                          Image img = new Image(pr.getImage(), 50, 55, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          final Circle clip = new Circle(20,30,15);
                          imgV.setClip(clip);
                          setGraphic(imgV);
                          setText(pr.getNom()+" a commenté :"+"\n"+p.getContenu()+"\n");
                           /*HBox hbox = new HBox() ; 
       Label label = new Label("");
        Pane pane = new Pane();
        Button button = new Button("Del");
        button.setLayoutX(10);
        hbox.getChildren().addAll(label, pane, button);
            HBox.setHgrow(pane, Priority.ALWAYS);
            button.setOnAction(event -> { ObservableList<Commentaire> selection = listeC.getSelectionModel().getSelectedItems() ; 
        for(Commentaire l : selection){
            cs.delete(l.getId_commentaire()) ; 
        }
            });
                  setGraphic(hbox);*/
                      }
                  }
              } ; return cell ;
          });
      listeC.setItems(lc);
    }
    
    @FXML 
    public void ajouterCommentaire(ActionEvent event){
        CommentaireService cs = new CommentaireService() ;
        System.out.println(AuthentificationController.LoggedParent.getId_user());
        Commentaire c = new Commentaire(AuthentificationController.LoggedParent.getId_user(),ListViewTestController.LoggedUser.getId_produit(), commentaire.getText()) ;
        System.out.println(c);//AuthentificationController.LoggedParent.getId_user()
        cs.insert(c);
        afficherCommment(); 
    }
    
   /* @FXML
     public void start(ScrollEvent event, Stage stage) throws Exception {

        zoomProperty.addListener(new InvalidationListener() {
            

            @Override
            public void invalidated(javafx.beans.Observable observable) {
                image.setFitWidth(zoomProperty.get() * 4);
                image.setFitHeight(zoomProperty.get() * 3);
            }
        });

        scrollPane.addEventFilter(ScrollEvent.ANY, new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                if (event.getDeltaY() > 0) {
                    zoomProperty.set(zoomProperty.get() * 1.1);
                } else if (event.getDeltaY() < 0) {
                    zoomProperty.set(zoomProperty.get() / 1.1);
                }
            }
        });

       // image.setImage(new Image("http://yourImageURL"));
        image.preserveRatioProperty().set(true);
        scrollPane.setContent(image);
        
       stage.setScene(new Scene(scrollPane, 400, 300));
        stage.show();

    }*/
    
    
   /* public Image zoomImage(int w,int h,Image img){
        BufferedImage buf = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB) ; 
        Graphics2D grf = buf.createGraphics() ; 
        grf.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        grf.drawImage(img, 0, 0, w, h,null) ; 
        grf.dispose();
        return buf ; 
    }*/
    
 
    
    public void OnZoomIn2(MouseEvent event){
        
            double w =image.getFitWidth() ;
            double h = image.getFitHeight() ; 
            image.setFitHeight(h+100);
            image.setFitWidth(w+100);
        
    }
    
    public void OnZoomOut2(MouseEvent event){
        
            double w =image.getFitWidth() ;
            double h = image.getFitHeight() ; 
            image.setFitHeight(h-100);
            image.setFitWidth(w-100);
        
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
    private void retirer(ActionEvent event) {
        AnchorPane2.setVisible(false);
        retire.setVisible(false);
    }
    
    
   
}
