/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Commande;
import allforkids.entite.LigneCommande;
import allforkids.entite.Parent;
import allforkids.entite.Produit;
import allforkids.service.CommandeService;
import allforkids.service.LigneCommandeService;
import allforkids.service.ParentService;
import allforkids.service.ProduitService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.shape.Circle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Molka
 */
public class CommandeLivraisonController implements Initializable {

    @FXML
    private TableView<Commande> tableC ; 
    @FXML
    private TableColumn<Commande,Image> client ; 
     @FXML
    private TableColumn<Commande,Image> produit ; 
      @FXML
    private TableColumn<Commande,String> total ; 
       @FXML
    private TableColumn<Commande,String> date ; 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherListeProduits();
        
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
                    return new SimpleObjectProperty<>(new Image(pr.getImage(), 150, 150, true, true, true));
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
      
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
     date.setCellValueFactory(new PropertyValueFactory<>("date"));
      
      
       }
     
    
    
}
