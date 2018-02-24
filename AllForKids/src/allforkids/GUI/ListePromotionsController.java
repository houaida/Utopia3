/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Produit;
import allforkids.entite.Promotion;
import allforkids.service.ProduitService;
import allforkids.service.PromotionService;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Molka
 */
public class ListePromotionsController implements Initializable {

    //ListeProduitsController l = new ListeProduitsController() ; 
    
      /* @FXML
    private TextField id_produit;*/
       
       
       
       
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private TableView<Promotion> tableP;
    @FXML
    private TableColumn<Promotion, String> Identifiant ;
    @FXML
    private TableColumn<Promotion, Integer> produit;
    @FXML
    private TableColumn<Promotion, Integer> pourcentage;
      @FXML
    private TableColumn<Promotion, String> date_d;
       @FXML
    private TableColumn<Promotion, String> date_f;
    String id ; 
     @FXML
     private TextField prod ; 
      @FXML
     private ComboBox<Integer> pourc ; 
       @FXML
     private DatePicker dated ;
        @FXML
     private DatePicker datef ; 
         @FXML
     private ImageView imgV ; 
         @FXML
     private TextField imagePath ;
         @FXML
     private Text textSearch ;
    @FXML
    private Button retour;
    @FXML
    private ToggleButton ajouter;
    @FXML
    private ToggleButton supprimer;
    @FXML
    private ToggleButton modifier;
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
    private ToggleGroup menu;
    @FXML
    private BorderPane anB;
    @FXML
    private ToggleButton gestionReclamation;
    @FXML
    private ToggleButton gestionReclamation1;
    @FXML
    private ToggleButton fleche2;
    @FXML
    private ToggleButton fleche1;
      
    /**
     * Initializes the controller class.
     */
         
         
    
            @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        /*ObservableList<Integer> ol2 = FXCollections.observableArrayList();
        ol2.add(1) ; 
        ol2.add(2) ;
        ol2.add(3) ;
        ol2.add(4) ;
        ol2.add(5) ;*/
        
        afficher(ListeProduitsController.LoggedUser);
        
        ObservableList<Integer> ol = FXCollections.observableArrayList();
        ol.add(10) ; 
        ol.add(20) ; 
        ol.add(25) ;
        ol.add(30) ;
        ol.add(50) ;
        ol.add(70) ;
        ol.add(75) ;

        pourc.setItems(ol);
        //prod.setItems(ol2);

        tableP.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
            try {
                showDetails(newValue);
            } catch (ParseException ex) {
                Logger.getLogger(ListePromotionsController.class.getName()).log(Level.SEVERE, null, ex);
            }
                });
        
     /*   Identifiant.setCellValueFactory(new Callback<CellDataFeatures<Promotion, Image>, ObservableValue<Image>>() {
            @Override
            public ObservableValue<Image> call(CellDataFeatures<Promotion, Image> param) {
                Promotion p = param.getValue() ; 
                return new SimpleObjectProperty<>(new Image(.toURI().toString(), 100, 100, true, true, true));
            }
            
        });*/
         
         afficherListePromotions() ; 
    }    
    
    public void afficher(Produit u)
       {
            //nom.setText(u.getNom());
            prod.setText(Integer.toString(u.getId_produit()));
            String imageFile = u.getImage() ; 
            Image image1 = new Image(imageFile);
            imgV.setImage(image1);
       }
     
    public void showDetails(Promotion e) throws ParseException{
        //int id = e.getId_produit() ; 
      /* ListeProduitsController lp = new ListeProduitsController() ; 
        System.out.println(lp.returnId()) ;*/ 
        
        id = Integer.toString(e.getId_promotion());
        PromotionService ps = new PromotionService();
       float pr =  ps.calculPrixPromo(e) ; 
       ps.insertTotal(e);
        textSearch.setText("prix du produit après promotion : "+pr+"DT");
        //prod.setText;
        pourc.setValue(e.getPourcentage()) ; 
        dated.getEditor().setText(e.getDate_debut());
        datef.getEditor().setText(e.getDate_fin());
             /*ProduitService ps = new ProduitService() ; 
            Produit p = ps.search(e.getId_produit()) ; 
              imagePath.setText(p.getImage())  ;
                   */
        
    }
    
    
    
    public void afficherListePromotions()
       {
            PromotionService ps = new PromotionService();
//            tableP.setItems(null);
            tableP.setItems(ps.getAll());
        
        Identifiant.setCellValueFactory(new PropertyValueFactory<>("id_promotion"));
        produit.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
        pourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));     
        date_d.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        date_f.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
     
       }
    
    @FXML
    public void ajouterPromotion(ActionEvent event)throws IOException, InterruptedException{
        PromotionService ps = new PromotionService(); 
        System.out.println(pourc.getValue());
        Promotion p = new Promotion(Integer.parseInt(prod.getText()),pourc.getValue(),dated.getEditor().getText(),datef.getEditor().getText()); 
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("promotion ajoutée.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            ps.insert(p);
         //prod.setText(null);
         pourc.setValue(null);
         dated.setValue(null); 
         datef.setValue(null);
       afficherListePromotions() ;
        }
    }
     @FXML
    public void supprimerPromotion(ActionEvent event)throws IOException, InterruptedException{
        if (!tableP.getSelectionModel().isEmpty()) {
         
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("suppression d'une promotion");
            alert.setHeaderText("etes-vous sur que vous voulez supprimer cette promotion?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                PromotionService ps = new PromotionService();
                ps.delete(tableP.getSelectionModel().getSelectedItem().getId_promotion());
                afficherListePromotions() ;
         //prod.setValue(null); 
         pourc.setValue(null);
         dated.setValue(null); 
         datef.setValue(null);
         textSearch.setText("");
            }
        } }
    
    
    
    public void onclickRetour(ActionEvent event)throws IOException, InterruptedException{
      ///if(!listeP.getSelectionModel().isEmpty()){
          //Produit p = new Produit(NomP.getText(), comBox.getValue(),comBox2.getValue(),Desc.getText(),imgPath.getText()) ; 
       // int a = Integer.parseInt(Identifiant.getText()) ; 
        try {
       // int id=a;
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeProduits.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

        } catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
   // } 
    }
    
    @FXML
    public void modifierProduit(ActionEvent event)throws IOException, InterruptedException{
     if (!tableP.getSelectionModel().isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
     alert.setTitle("modification d'un produit");
            alert.setHeaderText("etes-vous sur que vous voulez modifier le produit?") ;
     Optional<ButtonType> result = alert.showAndWait();
     if (result.get() == ButtonType.OK) {
            Promotion n = new Promotion(Integer.parseInt(prod.getText()),pourc.getValue(),dated.getEditor().getText(),datef.getEditor().getText());
            n.setId_promotion(Integer.parseInt(id));
            PromotionService ps = new PromotionService();
            ps.update(n);
            afficherListePromotions(); 
     //PromotionService ps = new PromotionService();
       float pr =  ps.calculPrixPromo(n) ; 
       ps.insertTotal(n);
        textSearch.setText("prix du produit après promotion : "+pr+"DT");
     
     
     } 
       
    }
    }

     @FXML
    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeProduits.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
         @FXML 
    public void OnZoomIn2(MouseEvent event){
        
            double w =imgV.getFitWidth() ;
            double h = imgV.getFitHeight() ; 
            imgV.setFitHeight(h+50);
            imgV.setFitWidth(w+50);
        
    }
    
     @FXML 
    public void OnZoomOut2(MouseEvent event){
        
            double w =imgV.getFitWidth() ;
            double h = imgV.getFitHeight() ; 
            imgV.setFitHeight(h-50);
            imgV.setFitWidth(w-50);
        
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
    private void gotoDemandeTravail(MouseEvent event) {
    }

   @FXML
    private void gestionOffre(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("OffreDemandeComp.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    
}
