/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import static allforkids.GUI.ListviewApprouverController.ACCOUNT_SID;
import static allforkids.GUI.ListviewApprouverController.AUTH_TOKEN;
import allforkids.entite.Babysitter;
import allforkids.entite.Parent;
import allforkids.entite.Reclamation;
import allforkids.entite.demandetravail;
import allforkids.service.BabysitterService;
import allforkids.service.ParentService;
import allforkids.service.ReclamationService;
import allforkids.service.demande_travailService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URL;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ListviewReclamationController implements Initializable {

    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private ListView<Reclamation> liste1;
    @FXML
    private ToggleButton bt1;
public static final String ACCOUNT_SID = "AC8f118de401e49baedc319855cbb14258";
  public static final String AUTH_TOKEN = "433014f1c92f881f5a11b580a8669e08";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  
        afficherListeReclamations() ;

        
    }   

    private void afficherListeReclamations() {
  liste1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
         ParentService ps2 =ParentService.getInstance();
         ReclamationService ps1 =ReclamationService.getInstance();
          ObservableList<Reclamation> lp = ps1.getAll();
          
          liste1.setCellFactory((ListView<Reclamation> param) -> {
              ListCell<Reclamation> cell = new ListCell<Reclamation>() {
                  @Override
                  protected void updateItem(Reclamation p , boolean bl) {
                      super.updateItem(p, bl);
                      if(p!=null){
                            Parent b=new Parent();
                  b=ps2.search(p.getId_parent());
                          
                          Image img = new Image(b.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                                                
                          setGraphic(imgV);
                          
      if(p.getEtat()==0){
          setText("                                Description du probléme: "+p.getDescription()+"\n \n                                Date envoi : "
                                  +p.getDate_envoi()+"\n \n                                Heure de travail : "+p.getHeure_travail()+
                                  "\n \n                                Heure de pointe : "+p.getHeure_pointe()+"                                                   "
                                          + "                                                                                     Non traitée");
                          
                          }
      if(p.getEtat()==1){
                    setText("                                Description du probléme: "+p.getDescription()+"\n \n                                Date envoi : "
                                  +p.getDate_envoi()+"\n \n                                Heure de travail : "+p.getHeure_travail()+
                                  "\n \n                                Heure de pointe : "+p.getHeure_pointe()+"                                                   "
                                          + "                                                                                     Traitée");
                          
}
     
                          
                      }
                  }
              } ;
              return cell ;
          });
      liste1.setItems(lp); 
    }

    @FXML
    private void approuverReclamation(ActionEvent event) {
       
        ReclamationService ds=ReclamationService.getInstance();
        BabysitterService ds1=BabysitterService.getInstance();
        ParentService ds3=new ParentService();

 ObservableList<Reclamation> selectedItems =  liste1.getSelectionModel().getSelectedItems();
  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setHeaderText("Cette réclamation a été traité");
       Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
  for(Reclamation s : selectedItems){
      
           int id2=s.getId_babysitter();
      Babysitter babysitter1=ds1.search(id2);
      Reclamation r=ds.search3(s.getId_reclamation());
      Parent p=ds3.search(s.getId_parent());
                 ds.update2(s.getId_reclamation());

if((r.getDiff_heure()==0)&&(r.getDiff_minute()<=15))
{
  
               

                                        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message
        .creator(new PhoneNumber("+216"+p.getNum_tel()), new PhoneNumber("+12104051270"),
            "On est vraiment désolé Mr/Mme "+p.getNom()+" "+p.getPrenom()+" pour le retard de"+r.getDiff_minute()+" min puisqu'il n'a pas "
                    + "depasser les 15 minutes ça peut étre à cause d'une circulation")
        .create();
    }

else
{
        Babysitter babysitter2=ds1.searchAlerte(id2);
        int alerte=babysitter2.getAlerte();
        System.out.println("pp"+alerte);       
      
                       ds1.update2(id2, alerte+1);

                         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
Message message2 = Message
        .creator(new PhoneNumber("+216"+babysitter1.getNum_tel()), new PhoneNumber("+12104051270"),
            "Mr/Mme "+babysitter1.getNom()+" "+babysitter1.getPrenom()+ " je suis trés deçu par votre service,c'est votre premier retard vous ne devez plus retarder svp,vous devez contacter Mr/Mme "+
             p.getNom()+" pour s'excuser")
        .create();
  
   
     
      if(alerte==2){
                         ds1.update2(id2,alerte+1);

                           Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

   
    Message message3 = Message
        .creator(new PhoneNumber("+216"+babysitter1.getNum_tel()), new PhoneNumber("+12104051270"),
            "Mr/Mme"+babysitter1.getNom()+" "+babysitter1.getPrenom()+ "je suis trés deçu par votre service,c'est votre deuxieme retard vous ne devez plus retarder svp,vous devez contacter Mr/Mme"+
             p.getNom()+" pour s'excuser la prochaine fois vous allez étre supprimer difinitivement!")
        .create();}
     if(alerte==3){
          ds.delete(s.getId_reclamation());
          ds1.delete(s.getId_babysitter());
               }
                                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

               Message message1 = Message
        .creator(new PhoneNumber("+216"+p.getNum_tel()), new PhoneNumber("+12104051270"),
            "On est vraiment désolé Mr/Mme "+p.getNom()+" "+p.getPrenom()+" pour le retard de"+r.getDiff_heure()+" heure et de "+s.getDiff_minute()+"minute "
                    + "nous allons avertir Mr/Mme "+babysitter1.getNom()+" et j'éspére que ça ne reproduirera plus")
        .create();
               
               
  
               

  

    
}
                 afficherListeReclamations();
}

     
    
    }}}

            
    

