/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;
import javafx.scene.image.Image ;
import allforkids.entite.Produit;
import allforkids.service.ProduitService;
//import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
//import java.util.logging.Logger ; 
/**
 * FXML Controller class
 *
 * @author Molka
 */

public class ListeProduitsController implements Initializable {

     public static Produit LoggedUser;
     /*@FXML
    private AnchorPane AnchorPane;*/
       @FXML
    private AnchorPane AnchorPane1;
 @FXML
    private TableView<Produit> listeP;
            //= new TableColumn<Produit, String>("image") ;
    @FXML
    private TableColumn<Produit, Image> Identifiant;
    @FXML
    private TableColumn<Produit, String> Nom;
    @FXML
    private TableColumn<Produit, String> Cat;
    @FXML
    private TableColumn<Produit, Float> Prix;
    @FXML
    private TableColumn<Produit, String> Description;
    @FXML
    private TableColumn<Produit, String> Quantite;
     @FXML
     private ComboBox<String> comBox ; 
     @FXML
     private TextField imgPath ; 
     @FXML
     private TextField NomP ; 
     @FXML
     private TextArea Desc ;
     @FXML
     private TextField comBox2 ; 
     @FXML 
     private ImageView imgV ; 
     @FXML 
     private TextField search ; 
     @FXML 
     private Text textSearch ;
     String id ; 
     @FXML
     private ComboBox<Integer> comBox3 ; 
    @FXML
    private Button btretour;
    @FXML
    private ToggleButton ajouter;
    @FXML
    private ToggleButton modifier;
    @FXML
    private ToggleButton supprimer;
    @FXML
    private ToggleGroup menu;
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
    private BorderPane anB;
    @FXML
    private ToggleButton gestionReclamation;
    @FXML
    private ToggleButton gestionReclamation1;
    @FXML
    private ToggleButton fleche2;
    @FXML
    private ToggleButton fleche1;
     
     
    // int id_prod ; 
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //initialisation quantite
       ObservableList<Integer> ol3 = FXCollections.observableArrayList();
        ol3.add(1) ; 
        ol3.add(2) ; 
        ol3.add(3) ; 
        ol3.add(4) ; 
        ol3.add(5) ; 

//initialisation comBox2
        /*ObservableList<Float> ol2 = FXCollections.observableArrayList();
        ol2.add((float)10.2) ; 
        ol2.add((float)24.99) ; 
        ol2.add((float)72) ; */
        
        //initialisation ComboBox 
        ObservableList<String> ol = FXCollections.observableArrayList();
        ol.add("jouets") ; 
        ol.add("vêtements") ; 
        ol.add("fournitures") ; 
        
        comBox.setItems(ol);
       // comBox2.setItems(ol2);
        comBox3.setItems(ol3);
       
        listeP.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    showDetails(newValue);
                });
        
   //id_prod = listeP.getSelectionModel().getSelectedItem().getId_produit() ; 
       
       // img.textProperty().addListener(listener);
                
        afficherListeProduits() ;
        //onSelect();
        
    }  
    
    public void showDetails(Produit e){
        //int id = e.getId_produit() ; 
        id = Integer.toString(e.getId_produit());
        NomP.setText(e.getNom());
        comBox.setValue(e.getCatégorie());
        comBox2.setText(Float.toString(e.getPrix_produit()));
        Desc.setText(e.getDescription());
        imgPath.setText(e.getImage());
        comBox3.setValue(e.getQuantite());
        
        
    }
    @FXML
    public void retour() throws IOException
    {
    
    AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilAdmin.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    public void afficherListeProduits()
       {
           
            ProduitService ps = new ProduitService();
            listeP.setItems(null);
            listeP.setItems(ps.getAll());
            
            Identifiant.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Produit, Image>, ObservableValue<Image>>() {
                @Override
                public ObservableValue<Image> call(TableColumn.CellDataFeatures<Produit, Image> param) {
                    Produit p = param.getValue() ; 
                    return new SimpleObjectProperty<>(new Image(p.getImage(), 100, 100, true, true, true));
                }
            }) ; 
            Identifiant.setCellFactory(new Callback<TableColumn<Produit, Image>, TableCell<Produit, Image>>() {
                @Override
                public TableCell<Produit, Image> call(TableColumn<Produit, Image> param) {
                    return new TableCell<Produit, Image>(){
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
      
   
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
     
        Cat.setCellValueFactory(new PropertyValueFactory<>("catégorie"));
          
        Prix.setCellValueFactory(new PropertyValueFactory<>("prix_produit"));
     
        Description.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        Quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
      
      
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
            imgV.setImage(image1);
            imgPath.setText(imageFile);
        } else {
            System.out.println("file doesn't exist");
        }
     }
    
    
     @FXML
    public void ajouterProduit(ActionEvent event)throws IOException, InterruptedException{
        ProduitService ps = new ProduitService(); 
        Produit p = new Produit(NomP.getText() ,comBox.getValue(),Float.parseFloat(comBox2.getText()),Desc.getText(),imgPath.getText(),comBox3.getValue()); 
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setHeaderText("produit ajouté, merci.");
       Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        ps.insert(p);
         afficherListeProduits() ;
         NomP.clear() ; 
         comBox.setValue("Veuillez choirsir une catégorie");
         comBox2.clear(); 
         Desc.clear();
         imgPath.clear(); 
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
    
    @FXML
    public void supprimerProduit(ActionEvent event)throws IOException, InterruptedException{
        if (!listeP.getSelectionModel().isEmpty()) {
         
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("suppression d'un produit");
            alert.setHeaderText("etes-vous sur que vous voulez supprimer le produit: "
                    + listeP.getSelectionModel().getSelectedItem().getNom());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                ProduitService ps = new ProduitService();
                ps.delete(listeP.getSelectionModel().getSelectedItem().getId_produit());
                afficherListeProduits() ;
                NomP.clear() ; 
         comBox.setValue("Veuillez choirsir une catégorie");
         comBox2.clear(); 
         Desc.clear();
         
            }
        } 
        
    }
    
     @FXML
    public void modifierProduit(ActionEvent event)throws IOException, InterruptedException{
     if (!listeP.getSelectionModel().isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
     alert.setTitle("modification d'un produit");
            alert.setHeaderText("etes-vous sur que vous voulez modifier le produit: "
                    + listeP.getSelectionModel().getSelectedItem().getNom());
     Optional<ButtonType> result = alert.showAndWait();
     if (result.get() == ButtonType.OK) {
            Produit n = new Produit(NomP.getText(), comBox.getValue(),Float.parseFloat(comBox2.getText()),Desc.getText(),imgPath.getText(),comBox3.getValue());
            n.setId_produit(Integer.parseInt(id));
            ProduitService ps = new ProduitService();
            ps.update(n);
            afficherListeProduits(); } 
       
    }
    }
    
    @FXML
    private void rechercherProduit(ActionEvent event)throws IOException, InterruptedException {
          ProduitService ps = new ProduitService();
                String a =(search.getText()) ;

        listeP.setItems(ps.SearchCatégorie(a));
        textSearch.setText("Résultat de votre recherche : "+ps.SearchCatégorie(a).size()+" produits");
      
        Identifiant.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Cat.setCellValueFactory(new PropertyValueFactory<>("catégorie"));
        Prix.setCellValueFactory(new PropertyValueFactory<>("prix_produit"));
        Description.setCellValueFactory(new PropertyValueFactory<>("description"));
        Quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        
    }
    
    @FXML
    private void afficherimage(MouseEvent event){
        if (event.getClickCount() == 1) //Checking double click
       {
            imgV.setImage(null);
            //int S = listeP.getSelectionModel().getSelectedItem().getId_produit();
            //Produit p = new Produit() ; 
            /*ProduitService ps = new ProduitService();
            Produit p = ps.search(S) ; */
            String imageFile = imgPath.getText() ; 
            //String imageFile = p.getImage() ; 
            //String imageFile = (ps.search(listeP.getSelectionModel().getSelectedItem().getId_produit()).getImage());
            System.out.println(imageFile);
            Image image1 = new Image(imageFile);
            imgV.setImage(image1);
      }
    }
    
    
    @FXML 
    public void onclickPromotion(ActionEvent event)throws IOException, InterruptedException{
     if(!listeP.getSelectionModel().isEmpty()){
         /* Produit p = new Produit(NomP.getText(), comBox.getValue(),comBox2.getValue(),Desc.getText(),imgPath.getText()) ; 
       int id = Integer.parseInt(Identifiant.getText()) ; */
         LoggedUser = new Produit();
       
        LoggedUser.setId_produit(listeP.getSelectionModel().getSelectedItem().getId_produit());
        LoggedUser.setImage(listeP.getSelectionModel().getSelectedItem().getImage());
                  System.out.println(LoggedUser.getImage());
                  System.out.println(LoggedUser.getId_produit());
        try {
       
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListePromotions.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

        } catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    } 
    }
    
    @FXML
    public void onclickComment(ActionEvent event){
        if(!listeP.getSelectionModel().isEmpty()){
         LoggedUser = new Produit();
       
        LoggedUser.setId_produit(listeP.getSelectionModel().getSelectedItem().getId_produit());
        LoggedUser.setImage(listeP.getSelectionModel().getSelectedItem().getImage());
        LoggedUser.setCatégorie(listeP.getSelectionModel().getSelectedItem().getCatégorie());
         LoggedUser.setNom(listeP.getSelectionModel().getSelectedItem().getNom());
          LoggedUser.setDescription(listeP.getSelectionModel().getSelectedItem().getDescription());
           LoggedUser.setPrix_produit(listeP.getSelectionModel().getSelectedItem().getPrix_produit());
            LoggedUser.setQuantite(listeP.getSelectionModel().getSelectedItem().getQuantite());
        try {
       
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ViewComments.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

        } catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    } 
    }
           
    /*public int returnId(){
        if(!listeP.getSelectionModel().isEmpty()){
       Produit p = new Produit(NomP.getText(), comBox.getValue(),comBox2.getValue(),Desc.getText(),imgPath.getText()) ; 
       return p.getId_produit() ; 
        }return -1 ; 
    }*/
    
   /*@FXML 
    public void onkeytype(KeyEvent event)throws IOException, InterruptedException{
        char c = event.getKeyChar() ; 
        if(!(Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE)){
            event.consume();
        }
    }*/
    
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
    private void gestionOffre(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("OffreDemandeComp.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void gotoDemandeTravail(MouseEvent event) {
    }
    
    
}
