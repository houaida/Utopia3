/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Admin;
import allforkids.entite.Garderie;
import allforkids.entite.ProprietaireG;
import allforkids.service.GarderieService;
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
public class AccueilPropGController implements Initializable {

    @FXML
    private ImageView profil;
    @FXML
    private Label pseudo;
    @FXML
    private ListView<Garderie> Lgarderie;
    @FXML
    private Label lb;
    @FXML
    private AnchorPane AnchorPane1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherUser(AuthentificationController.LoggedProprietaireG);
        afficher();
    }    
    private void afficherUser(ProprietaireG a) {
        pseudo.setText(a.getPseudo());
        
        
        String imageFile =a.getImage();
        Image img=new Image(imageFile,280,280,true,true,true);
        profil.setImage(img);
        final Circle clip = new Circle(60, 60, 55);
        profil.setClip(clip);
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
                          
                          setText(" Nom : "+p.getNom()+"\n Adresse : "+p.getAdresse()+"\n Numero : "+p.getNum_tel()+"\n Description : "+p.getDescription());
                      }
                  }
              } ; return cell ;
          });
      Lgarderie.setItems(lp);
           
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
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionGarderie.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
}
