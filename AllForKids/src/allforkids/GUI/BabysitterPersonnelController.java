/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Babysitter;
import allforkids.service.BabysitterService;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author user
 */
public class BabysitterPersonnelController implements Initializable {

    @FXML
    private JFXListView<Babysitter> listebabysitter;

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
    
   
    
}
