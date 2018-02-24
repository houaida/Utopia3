/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Enfant;
import allforkids.entite.Garderie;
import allforkids.entite.Parent;
import allforkids.service.EnfantService;

import allforkids.service.GarderieService;
import allforkids.service.ParentService;
import java.io.IOException;

import java.net.URL;
import java.util.Optional;

import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class ListeGardJardController implements Initializable {
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private ListView<Garderie> Lgarderie;
    @FXML
    private TextField id_parent;
    @FXML
    private TextField id_garderie;
     
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       afficherId(InscriptionUserController.LoggedParent);
        afficher();
        aff();
    }    
   
 

   public void afficher()
       {
          GarderieService ps = new GarderieService() ;
          ObservableList<Garderie> lp = ps.getAll(); 
          
          Lgarderie.setCellFactory((ListView<Garderie> param) -> {
              ListCell<Garderie> cell = new ListCell<Garderie>() {
                  @Override
                  protected void updateItem(Garderie p , boolean bl) {
                      super.updateItem(p, bl);
                      
                      if(p!=null){
                          Image img = new Image(p.getImage(), 200, 200, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
                          
                          setText("id : "+p.getId_garderie()+"\n Nom : "+p.getNom()+"\n Adresse : "+p.getAdresse()+"\n Numero : "+p.getNum_tel()+"\n Description : "+p.getDescription());
                      }
                  }
              } ; return cell ;
          });
      Lgarderie.setItems(lp);
           
       } 
   public void IdGard(){
    Enfant e=new Enfant();
    Lgarderie.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends Garderie> ov,  Garderie old_val, 
            Garderie new_val) -> {
                System.out.println(new_val);
               
        e.setId_garderie(new_val.getId_garderie());
        
        
            System.out.println("garderie id:"+e.getId_garderie());
            id_garderie.setText(Integer.toString(e.getId_garderie()));
    }); 
    
   }
   public void aff()
   {
   IdGard();
   }
public void confirmerEnfant(Enfant e)
{
   
  Enfant p= new Enfant(Integer.parseInt(id_parent.getText()),Integer.parseInt(id_garderie.getText()),e.getNom(),e.getPrenom(),e.getAge());
          EnfantService es=new EnfantService();
          es.insert(p);
}

public void afficherId(Parent e){
    ParentService ps= new ParentService();
     
     Parent pa=ps.findbyLogin(e.getPseudo());
     id_parent.setText(Integer.toString(pa.getId_user()));

}

    @FXML
    private void choisir(ActionEvent event) throws IOException {
      
        confirmerEnfant(InscriptionUserController.LoggedEnfant);
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Inscription");
            alert.setHeaderText("Inscription términée bienvenue à AllForKids");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                 AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("InscriptionUser.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
            }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Annuler");
            alert.setHeaderText("voulez-vous vraiment aanuler l'inscription");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
     ParentService ps=new ParentService();
        ps.delete(Integer.parseInt(id_parent.getText()));
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("InscriptionUser.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);}
    }
    
    
}

