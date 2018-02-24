/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Enfant;
import allforkids.entite.EnfantJ;

import allforkids.entite.JardinEnfant;
import allforkids.entite.Parent;
import allforkids.service.EnfantJService;
import allforkids.service.EnfantService;

import allforkids.service.JardinEnfantService;
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
public class ListeJardinController implements Initializable {
 @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private ListView<JardinEnfant> Ljardin;
    @FXML
    private TextField id_parent;
    @FXML
    private TextField id_jardin;
     
 
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
          JardinEnfantService ps = new JardinEnfantService() ;
          ObservableList<JardinEnfant> lp = ps.getAll(); 
          
          Ljardin.setCellFactory((ListView<JardinEnfant> param) -> {
              ListCell<JardinEnfant> cell = new ListCell<JardinEnfant>() {
                  @Override
                  protected void updateItem(JardinEnfant p , boolean bl) {
                      super.updateItem(p, bl);
                      
                      if(p!=null){
                          Image img = new Image(p.getImage(), 200, 200, true, true, true) ;
                          ImageView imgV = new ImageView(img);
                          setGraphic(imgV);
                          
                          setText("id : "+p.getId_jardinEnfant()+"\n Nom : "+p.getNom()+"\n Adresse : "+p.getAdresse()+"\n Numero : "+p.getNum_tel()+"\n Description : "+p.getDescription());
                      }
                  }
              } ; return cell ;
          });
      Ljardin.setItems(lp);
           
       } 
   public void IdGard(){
    EnfantJ e=new EnfantJ();
    Ljardin.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends JardinEnfant> ov,  JardinEnfant old_val, 
            JardinEnfant new_val) -> {
                System.out.println(new_val);
               
        e.setId_jardinEnfant(new_val.getId_jardinEnfant());
        
        
            System.out.println("jardin d'enfant id:"+e.getId_jardinEnfant());
            id_jardin.setText(Integer.toString(e.getId_jardinEnfant()));
    }); 
    
   }
   public void aff()
   {
   IdGard();
   }
public void confirmerEnfant(EnfantJ e)
{
   
  EnfantJ p= new EnfantJ(Integer.parseInt(id_parent.getText()),Integer.parseInt(id_jardin.getText()),e.getNom(),e.getPrenom(),e.getAge());
          EnfantJService es=new EnfantJService();
          es.insert(p);
}

public void afficherId(Parent e){
    ParentService ps= new ParentService();
     
     Parent pa=ps.findbyLogin(e.getPseudo());
     id_parent.setText(Integer.toString(pa.getId_user()));

}

    @FXML
    private void choisir(ActionEvent event) throws IOException {
      
        confirmerEnfant(InscriptionUserController.LoggedEnfantJ);
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
