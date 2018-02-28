/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Covoiturage;
import allforkids.entite.Reservation;
import allforkids.entite.moyen;
import allforkids.service.ReservationService;
import allforkids.service.moyenService;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class MoyenController implements Initializable {
    @FXML
    private ListView liste;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
       afficherListemoyen();
    
    }    
    @FXML
      public void afficherListemoyen()
       {
         moyenService ps = new moyenService() ; 
          ObservableList<moyen> lp = ps.getAll() ; 
          
          liste.setCellFactory(new Callback<ListView<moyen>, ListCell<moyen>>() {
              @Override
              public ListCell<moyen> call(ListView<moyen> param) {
                  ListCell<moyen> cell = new ListCell<moyen>() {
                      @Override
                    protected void updateItem(moyen p , boolean bl) {
                        super.updateItem(p, bl);
                        if(p!=null){
                           /* ParentService ps = new ParentService() ; 
                            Parent p1 =  ps.searchImg(p.getId_user()) ; */
                           //String im = "file:/C:/Users/imen/Desktop/imen.png" ;    
                            Image img = new Image("file:/C:/Users/imen/Desktop/imen.jpg", 100, 100, true, true, true) ; 
                            ImageView imgV = new ImageView(img) ; 
                            setGraphic(imgV); 
                            setText("Heure disponible: " + p.getDescription()+ "\n"+"Nombre de place disponnible : " + p.getNbr()+ "\n" );
                               
                        }
                        
                    }
                  } ; return cell ; 
              }
          });
      liste.setItems(lp);
           
       }
    public void ajouter()
    {
                    
                  moyenService ps= new moyenService();
               
             //  moyen p= new moyen(AuthentificationController.LoggedParent.getId_user());
                ObservableList<moyen> selectedItems = liste.getSelectionModel().getSelectedItems();
              {
                        for(moyen s : selectedItems){
                       
                     if(s.getNbr()==0)
                            {
                                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                                 alert1.setHeaderText("Ce moyen de transport est complet");
                                 Optional<ButtonType> result1 = alert1.showAndWait();
                                 if (result1.get() == ButtonType.OK){
                                    
                                 }
                            }
                                 else  
                              {  
                                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                             alert.setHeaderText("Votre moyen de transport a été ajouté!");
                              Optional<ButtonType> result = alert.showAndWait();
                              if (result.get() == ButtonType.OK)
                              {
                          s.setNbr(s.getNbr()-1);
                         ps.insert(s);
                        
                         System.out.println(ps);
                             }
                                
                            }
                         
        }
      //  afficherListemoyen();
            }
    
            }
}
    

