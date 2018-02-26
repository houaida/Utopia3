/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Babysitter;
import allforkids.service.BabysitterService;
import com.jfoenix.controls.JFXListView;
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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class BabysitterPersonnelController implements Initializable {

    @FXML
    private JFXListView<Babysitter> listebabysitter;
    @FXML
    private TextField search;
    @FXML
    private ToggleButton rechercher;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ToggleButton gestionPrduit;
    @FXML
    private ToggleButton retire;
    @FXML
    private ToggleButton fleche2;
    @FXML
    private ToggleButton fleche1;
    @FXML
    private AnchorPane anB;
    @FXML
    private Button btretour;
    @FXML
    private AnchorPane AnchorPane1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherBabysitterPersonnel();
    } 
    public void afficherBabysitterPersonnel()
       {
          BabysitterService ps = BabysitterService.getInstance() ;
          ObservableList<Babysitter> lp = ps.getAll2(); 
          
          listebabysitter.setCellFactory((ListView<Babysitter> param) -> {
              ListCell<Babysitter> cell = new ListCell<Babysitter>() {
                  @Override
                  protected void updateItem(Babysitter p , boolean bl) {
                      super.updateItem(p, bl);
                      if(p!=null){
                          Image img = new Image(p.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
                          setText(" Cin: "+p.getCin()+"\n Nom : "+p.getNom()+"\n Prenom : "+p.getPrenom()+"\n Mail : "+p.getEmail()+"\n Adresse : "+p.getAdresse()
                          +"\n Numero telephone : "+p.getNum_tel()+"\n Date de naissance : "+p.getDate_naissance());
                      }
                  }
              } ; return cell ;
          });
      listebabysitter.setItems(lp);
           
       } 

    @FXML
    private void rechercherProduit(ActionEvent event) {
    }

    @FXML
    private void gotoDemandeTravail(MouseEvent event) {
    }

    @FXML
    private void boutique(ActionEvent event) {
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
    private void ListeOffre(ActionEvent event) {
    }

    @FXML
   
    private void Demandes(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("demande.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
  

    @FXML
    private void rechercherPersonnel(ActionEvent event) {
         BabysitterService ls = new BabysitterService()  ; 
    
        ObservableList<Babysitter> lc =  ls.search2(search.getText()) ; 
      
      listebabysitter.setCellFactory((ListView<Babysitter> param) -> {
              ListCell<Babysitter> cell = new ListCell<Babysitter>() {
                  @Override
                  protected void updateItem(Babysitter p , boolean bl) {
                      super.updateItem(p, bl);
                      if(p!=null){
                          Image img = new Image(p.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
    setText(" Cin: "+p.getCin()+"\n Nom : "+p.getNom()+"\n Prenom : "+p.getPrenom()+"\n Mail : "+p.getEmail()+"\n Adresse : "+p.getAdresse()
                          +"\n Numero telephone : "+p.getNum_tel()+"\n Date de naissance : "+p.getDate_naissance());
                      }
                  }
              } ; return cell ;
          });
      listebabysitter.setItems(lc);
     }
    
   
    
}
