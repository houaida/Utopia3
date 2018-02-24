/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import allforkids.entite.Babysitter;
import allforkids.entite.Produit;
import allforkids.entite.demandetravail;
import allforkids.service.BabysitterService;
import allforkids.service.OffreService;
import allforkids.service.ProduitService;
import allforkids.service.demande_travailService;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ListviewApprouverController implements Initializable {

    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private ListView<demandetravail> liste1;
    @FXML
    private ToggleButton bt1;
    @FXML
    private ToggleButton bt11;
 public static final String ACCOUNT_SID = "AC1b03266295bbba0a1e053cb7f2c4c550";
  public static final String AUTH_TOKEN = "2c12a62349d571be7427e4b55f3774c8";
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherListeProduits() ;
    }
 
    public void afficherListeProduits() 
       {
                  liste1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

         demande_travailService ps1 = new demande_travailService() ;
          ObservableList<demandetravail> lp = ps1.getAll();
          
          liste1.setCellFactory((ListView<demandetravail> param) -> {
              ListCell<demandetravail> cell = new ListCell<demandetravail>() {
                  @Override
                  protected void updateItem(demandetravail p , boolean bl) {
                      super.updateItem(p, bl);
                      if(p!=null){
                          Image img = new Image(p.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
                          
  
                          setText("                                Nom : "+p.getNom()+"\n \n                                Prenom : "
                                  +p.getPrenom()+"\n \n                                Niveau d'étude : "+p.getNiveau_etude()+
                                  "\n \n                                Poste actuel : "+p.getPoste_actuel()+
                                   "\n \n                                Langue : "+p.getLangue());
                      }
                  }
              } ;
              return cell ;
          });
      liste1.setItems(lp); 
}

    @FXML
    private void supprimer(ActionEvent event){
        demande_travailService ds=new demande_travailService();
 ObservableList<demandetravail> selectedItems =  liste1.getSelectionModel().getSelectedItems();
  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setHeaderText("Votre demande a été envoyer veuillez svp attendre notre reponse, merci.");
       Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
                        for(demandetravail s : selectedItems){
                     //       System.out.println(s);
     

                        ds.delete(s.getId_babysitter());
                                        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message
        .creator(new PhoneNumber("+216"+s.getNum_tel()), new PhoneNumber("+19132867957"),
            "Votre demande de travail pour un poste de babysitter a été refusé")
        .create();
                           afficherListeProduits();
                         

                        }

                    }
    }
               
             

            @FXML
    private void ajouter(ActionEvent event) {
         demande_travailService ds=new demande_travailService();
 ObservableList<demandetravail> selectedItems =  liste1.getSelectionModel().getSelectedItems();
  for(demandetravail s : selectedItems){
      BabysitterService bs=BabysitterService.getInstance();
      int id1=s.getId_demandeTravail();
            int id2=s.getId_babysitter();

                             bs.update1(id1);

       ds.delete(id2);
                                        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message
        .creator(new PhoneNumber("+216"+s.getNum_tel()), new PhoneNumber("+19132867957"),
            "Votre demande de travail pour un poste de babysitter a été accepté")
        .create();

                           afficherListeProduits();
            

  }
    }   
            }
        
    

   

   
