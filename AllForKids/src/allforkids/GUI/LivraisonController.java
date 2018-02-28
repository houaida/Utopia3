/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Livraison;
import allforkids.entite.Livreur;
import allforkids.service.LivraisonService;
import allforkids.service.LivreurService;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Molka
 */
public class LivraisonController implements Initializable {

    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXComboBox<String> region;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> ol = FXCollections.observableArrayList();
        ol.add("Tunis") ; 
        ol.add("Ariana") ; 
        ol.add("Ben Arous") ; 
        ol.add("Manouba") ; 
        ol.add("Bizerte") ; 
        ol.add("Nabeul") ; 
        
        region.setItems(ol);
    }    

    String CalculDuree(String v){
        String duree = "" ; 
        if(v=="Tunis"){
            duree="40 minutes" ; 
        }
        if(v=="Ariana"){
            duree="20 minutes" ; 
        }
        if(v=="Ben Arous"){
            duree="1 heure" ; 
        }
        if(v=="Manouba"){
            duree="1 heure 30" ; 
        }
        if(v=="Bizerte"){
            duree="2 heures" ; 
        }
         if(v=="Nabeul"){
            duree="2 heures" ; 
        }
         return duree ; 
     
    }
    

    @FXML
    private void onclickConfirm(ActionEvent event) {
        
        LivraisonService ls = new LivraisonService() ; 
        LivreurService lss = new LivreurService() ; 
        Livreur liv = lss.AffecterLivreur() ; 
        if(liv!=null) {
        Livreur liv2 = new Livreur(liv.getId_user(),liv.getPseudo(), liv.getMdp(), liv.getEmail(), 0) ;
        Livraison l = new Livraison(liv.getId_user(),AuthentificationController.LoggedParent.getId_user(),ProduitDetailsController.LoggedUser.getId_produit(),CalculDuree(region.getValue()),adresse.getText())   ;
        ls.insert(l);
        LivreurService ls2 = new LivreurService() ; 
        ls2.update(liv2) ; 
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("livraison");
            alert.setHeaderText("Votre produit sera livrer dans environ "+CalculDuree(region.getValue())+", merci :)") ; 
             Optional<ButtonType> result = alert.showAndWait();
        } 
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("livraison");
            alert.setHeaderText("Nos livreurs ne sont pas disponibles pour le moment, veuillez patienter...") ; 
             Optional<ButtonType> result = alert.showAndWait();
    }

    @FXML
    private void afficher(ActionEvent event) {
    }
    
}
