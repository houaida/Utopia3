/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Babysitter;
import allforkids.entite.Offre;
import allforkids.entite.Reclamation;
import allforkids.entite.demandetravail;
import allforkids.service.BabysitterService;
import allforkids.service.OffreService;
import allforkids.service.ReclamationService;
import allforkids.service.demande_travailService;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ReclamationController implements Initializable {

    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private TextField idEva;
    @FXML
    private TextField id_garderie;
    @FXML
    private TextField id_user;
 
  @FXML
    private JFXTimePicker heurep=new JFXTimePicker();;
    @FXML
    private JFXTimePicker heuret=new JFXTimePicker();;
    @FXML
    private JFXTextField tcinbs;
    @FXML
    private JFXTextArea tdescription;
    @FXML
    private JFXListView<Reclamation> maliste;
    @FXML
    private ToggleButton bt11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           heurep.setIs24HourView(true);
        heurep.setDefaultColor(Color.valueOf("#ff2e44"));
        heuret.setIs24HourView(true);
        heuret.setDefaultColor(Color.valueOf("#ff2e44"));
                afficherListeReclamation();

        heuret.setConverter(new StringConverter<LocalTime>() {
            private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            @Override
            public String toString(LocalTime object) {
                 if(object==null)
            return "";
        return dtf.format(object);
            
        
        
    }

               @Override
               public LocalTime fromString(String string) {
                   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               }
           });
           heurep.setConverter(new StringConverter<LocalTime>() {
            private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            @Override
            public String toString(LocalTime object) {
                 if(object==null)
            return "";
        return dtf.format(object);
            
        
        
    }

               @Override
               public LocalTime fromString(String string) {
                   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               }
           });}

    @FXML
    private void ajouter(ActionEvent event){
      
        ReclamationService GRec =ReclamationService.getInstance();
        BabysitterService bs=BabysitterService.getInstance();
        Babysitter r=new Babysitter();
        r=bs.search1(Integer.parseInt(tcinbs.getText()));
        System.out.println(r);
        Reclamation rec=new Reclamation(r.getId_user(),tdescription.getText(),Time.valueOf(heuret.getEditor().getText()),Time.valueOf(heurep.getEditor().getText()));
            GRec.insert1(rec,AuthentificationController.LoggedParent.getId_user());
            GRec.update1(AuthentificationController.LoggedParent.getId_user());



    afficherListeReclamation();

    }
        public void afficherListeReclamation() 
       {
         ReclamationService ps1 = ReclamationService.getInstance() ;
         BabysitterService ps2 =BabysitterService.getInstance();
          ObservableList<Reclamation> lp = ps1.getAll1(AuthentificationController.LoggedParent.getId_user());
         

          maliste.setCellFactory((ListView<Reclamation> param) -> {
              ListCell<Reclamation> cell = new ListCell<Reclamation>() {
                  @Override
                  protected void updateItem(Reclamation p , boolean bl) {
                      super.updateItem(p, bl);
                      if(p!=null){
               Babysitter b=new Babysitter();
                          System.out.println(p.getId_babysitter());     
                  b=ps2.search(p.getId_babysitter());
AnchorPane pane=new AnchorPane();
Label label=new Label();
                          Image img = new Image(b.getImage(), 200, 200, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          if(p.getEtat()==0){
                            Image img1 = new Image("file:/C:/Users/user/Desktop/PI/Utopia/AllForKids/src/allforkids/GUI/img/circle-red.png", 20,20, true, true, true) ;
                              ImageView iv = new ImageView(img1);
                         iv.setY(5);
                         iv.setX(150);
                          pane.getChildren().addAll(iv,imgV);
                          }
                          else{
                            Image img1 = new Image("file:/C:/Users/user/Desktop/PI/Utopia/AllForKids/src/allforkids/GUI/img/circle-green.png", 20,20, true, true, true) ;
                              ImageView iv = new ImageView(img1);
                         iv.setY(5);
                         iv.setX(200);
                          pane.getChildren().addAll(iv,imgV);
}
                              
                        
                          setGraphic(pane);
                          
   
                          setText("Le nom du babysitter: "+b.getNom()+"\n \nDescription : "
                                  +p.getDescription()+"\n \nDate d'envoi : "+p.getDate_envoi()+
                                  "\n \nHeure de travail : "+p.getHeure_travail()+
                                   "\n \nHeure de pointe : "+p.getHeure_pointe());
                      }
                  }
              } ;
              return cell ;
          });
      maliste.setItems(lp); 
}

    @FXML
    private void supprimer(ActionEvent event) {
          ReclamationService ds=ReclamationService.getInstance();
 ObservableList<Reclamation> selectedItems =  maliste.getSelectionModel().getSelectedItems();
  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setHeaderText("Cette reclamation a été supprimer");
       Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
                        for(Reclamation s : selectedItems){
                System.out.println(s);
     
     
                        ds.delete(s.getId_reclamation());
                        afficherListeReclamation();
    }
    
   
    
    
}}
}