/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;



import allforkids.entite.Reservation;
import allforkids.service.ReservationService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class ListeReservationController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TableView<Reservation> table;
 @FXML
    private TableColumn<Reservation, Integer> Cid;
 @FXML
    private TableColumn<Reservation, String> Cidu;
 @FXML
    private TableColumn<Reservation, String> Cnbr;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
    }
          @FXML
     public void afficher()
       {
           
            ReservationService ips = new ReservationService();
            table.setItems(null);
             table.setItems(ips.getAll());

         Cid.setCellValueFactory(new PropertyValueFactory<>("id"));
       
        
        Cidu.setCellValueFactory(new PropertyValueFactory<>("id_user"));
      Cnbr.setCellValueFactory(new PropertyValueFactory<>("nbre_place"));
             

       }
        
    }    
    

