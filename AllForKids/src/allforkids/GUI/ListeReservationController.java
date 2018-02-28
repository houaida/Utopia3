/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;



import allforkids.entite.Covoiturage;
import allforkids.entite.Reservation;
import allforkids.service.CovoiturageService;
import allforkids.service.ReservationService;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
/**
 * FXML Controller class
 *
 * @author imen
 */
public class ListeReservationController implements Initializable {
    @FXML
    private ListView listeR;
    @FXML
    private Button btn2;
    @FXML
    private Button btn1;
    @FXML
    private void handleButtonAction (ActionEvent event)
    {
       // System.out.println("Click mee!!");
        Notifications.create()
                .title("Traitement des demandes")
                .text("Votre demande a été accepté").position(Pos.TOP_RIGHT)
                .showError();
                 
         
        
    }
       /* @FXML
    private void handleButtonAction1 (ActionEvent event)
    {
       // System.out.println("Click mee!!");
        Image l = new Image("file:/C:/Users/imen/Documents/projet/Utopia/AllForKids/src/allforkids/GUI/img/Tick.png");
        Notification.notificationDeConfirmation(event,l);
                
                 
         
        
    }*/

    /**
     * Initializes the controller class.
     */
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher1();
    }
    @FXML
     public void afficher1()
       
       {
              CovoiturageService ps = new CovoiturageService() ; 
          ObservableList<Covoiturage> lp = null;
                  lp=ps.searchIDU(AuthentificationController.LoggedParent.getId_user());
          
          listeR.setCellFactory(new Callback<ListView<Covoiturage>, ListCell<Covoiturage>>() {
              @Override
              public ListCell<Covoiturage> call(ListView<Covoiturage> param) {
                  ListCell<Covoiturage> cell = new ListCell<Covoiturage>() {
                      @Override
                    protected void updateItem(Covoiturage p , boolean bl) {
                        super.updateItem(p, bl);
                        if(p!=null){
                            ReservationService rs = new ReservationService() ; 
                            Reservation r = null;
                                    r=rs.search(p.getId()) ; 
                            if(r!=null)
                           /* ParentService ps = new ParentService() ; 
                            Parent p1 =  ps.searchImg(p.getId_user()) ; */
                           //String im = "file:/C:/Users/imen/Desktop/imen.png" ;    
                  {  Image img = new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia3/AllForKids/src/allforkids/GUI/img/p1.png", 100, 100, true, true, true) ; 
                            ImageView imgV = new ImageView(img) ; 
                            setGraphic(imgV); 
                            setText("Depart : " + p.getDepart() + "\n"+"DateDepart : " + p.getDateDepart() + "\n"+"Destination : " + p.getDestination() + "\n" +"Heure départ : " + p.getHeureD() + "\n"+"Date arrivé : " + p.getDateArrive() + "\n"+"Heure arrivé : " + p.getHeureA() + "\n"+"Nombre de places disponibles : " + p.getNbre_place_dispo() +"\n"+"Nombre de place reservé: " + r.getNbre_place()+ "\n");
                            }  
                        }
                        
                    }
                  } ; return cell ; 
              }
          });
      listeR.setItems(lp);
          
}
 
     @FXML
       public void supprimer(){
    
        CovoiturageService ds=new CovoiturageService();
         ReservationService ps= new ReservationService();
        // listeR.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
      ObservableList<Covoiturage> selectedItems = listeR.getSelectionModel().getSelectedItems();
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setHeaderText("Voulez vous supprimer votre réservation?");
       Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
                        for(Covoiturage s : selectedItems){
                     //       System.out.println(s);
                        //ds.delete(s.getId());
                         ps.delete(s.getId());    
                            System.out.println(ps);   
     
                        }

                    }
          afficher1();
         
    
            }
      
      }
    

