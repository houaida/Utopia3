/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Garderie;
import allforkids.entite.JardinEnfant;
import allforkids.entite.ProprietaireG;
import allforkids.entite.ProprietaireJ;
import allforkids.service.JardinEnfantService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class AccueilPropJController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private ImageView profil;
    @FXML
    private Label pseudo;
    @FXML
    private ListView<JardinEnfant> Ljardin;
    @FXML
    private Label lb;
    @FXML
    private AnchorPane AnchorPane1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherUser(AuthentificationController.LoggedProprietaireJ);
        afficher();
    }    
    private void afficherUser(ProprietaireJ a) {
        pseudo.setText(a.getPseudo());
        
        
        String imageFile =a.getImage();
        Image img=new Image(imageFile,280,280,true,true,true);
        profil.setImage(img);
        final Circle clip = new Circle(60, 60, 55);
        profil.setClip(clip);
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
                          
                          setText(" Nom : "+p.getNom()+"\n Adresse : "+p.getAdresse()+"\n Numero : "+p.getNum_tel()+"\n Description : "+p.getDescription());
                      }
                  }
              } ; return cell ;
          });
      Ljardin.setItems(lp);
           
       } 

    @FXML
 public void changerStyle()
 {
  lb.setTextFill(Color.BLUE);
 }
 @FXML
 public void changerStyle2()
 {
  lb.setTextFill(Color.BLACK);
 }

    @FXML
    private void gestion(MouseEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionJardin.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
}
