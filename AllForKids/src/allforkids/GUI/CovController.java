/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Covoiturage;
import allforkids.entite.Parent;
import allforkids.entite.Reservation;
import allforkids.service.CovoiturageService;

import allforkids.service.ReservationService;
import java.io.IOException;
//import java.awt.Image;
import java.util.logging.Logger;
import java.net.URL;
import java.text.ParseException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
//import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class CovController implements Initializable {
    @FXML
   private ComboBox<String> depart;
    @FXML
    private TextField nbr;
      @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private DatePicker date_depart;
    @FXML
    private DatePicker datearrivee;
   @FXML
     private ComboBox<String> destination ; 
    
    @FXML
    private TextField idu;
    @FXML
    private TextField afficher_entry;
    @FXML
    private TextField id;
    @FXML
    private TextField heureD;
    @FXML
    private TextField heureA;
    @FXML 
    private ListView liste ;
     @FXML 
    private ListView listeR ;
     private Button btn1;
     @FXML
    private TextField np;
     @FXML
     private Label nbr1;
       @FXML
    private TableView<Covoiturage> table;
     @FXML
    private TableColumn<Covoiturage,String> Cd;
    @FXML
    private TableColumn<Covoiturage, String> Cd1;
    @FXML
    private TableColumn<Covoiturage, String> Cdepart;
        @FXML
    private TableColumn<Covoiturage, String> Carrive;
    @FXML
    private TableColumn<Covoiturage, String> Chd;
    @FXML
    private TableColumn<Covoiturage, String> Cha;
      @FXML
    private TableColumn<Covoiturage, Integer> Cnbr;
        @FXML
    private TableColumn<Covoiturage, Integer> Cid;
    @FXML
    private TableColumn<Covoiturage, Integer> Cidu;
    @FXML
    private AnchorPane tab;
    @FXML
    private Button boutton;
   @FXML
    private TextField nouv;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ToggleButton gestionPrduit;
    @FXML
    private ToggleButton retire;
    @FXML
    private ToggleButton fleche2;
    @FXML
    private ToggleButton fleche1;
    @FXML
    private AnchorPane anB;
    @FXML
    private ToggleButton modifier;
    @FXML
    private ToggleButton supprimer;
    @FXML
    private ToggleGroup menu1;
    @FXML
    private Button btretour;
    private ListView<Covoiturage> listeR1;
    
 
     
   
    /**
     * Initializes the controller class.
     */
    //public static Parent LoggedParent;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         afficher(AuthentificationController.LoggedParent);
         afficherCov(AuthentificationController.LoggedParent);
        
         ObservableList<String> ol = FXCollections.observableArrayList();
        ol.add("Tunis") ; 
        ol.add("Marsa") ; 
        ol.add("Ariana") ; 
        ol.add("Ben Arous") ;
        ol.add("Sidi bou said") ;
        ol.add("Kram") ;
        ol.add("Radess") ;
        ol.add("Megrine") ;
        ol.add("Carthage") ;
        ol.add("Manar") ;
         ol.add("Manzah") ;
         ol.add("Monfleury") ; 
          
        
         
        destination.setItems(ol);
           
        ObservableList<String> ol1 = FXCollections.observableArrayList();
         ol1.add("Tunis") ; 
        ol1.add("Marsa") ; 
        ol1.add("Ariana") ; 
        ol1.add("Ben Arous") ;
        ol1.add("Sidi bou said") ;
        ol1.add("Kram") ;
        ol1.add("Radess") ;
        ol1.add("Megrine") ;
        ol1.add("Carthage") ;
        ol1.add("Manar") ;
         ol1.add("Manzah") ;
         ol1.add("Monfleury") ; 
        
        depart.setItems(ol1);
        
         afficherListeCovoiturage() ;
        
         afficherListeReservation();
        // LoggedParent = new Parent();
          // afficherApprouver();
        
       
    }   
 
   

    @FXML
    private void ajouter() throws ParseException {
        CovoiturageService ps=new CovoiturageService();
       // int i=Integer.parseInt(idu.getText());
       // int u=Integer.parseInt(nbr.getText());
       if(!depart.getValue().equals(destination.getValue())){
        Covoiturage p= new Covoiturage(depart.getValue(),date_depart.getEditor().getText(),heureD.getText(),destination.getValue(),datearrivee.getEditor().getText(),heureA.getText(),Integer.parseInt(nbr.getText()));
       ps.insert1(p,AuthentificationController.LoggedParent.getId_user());
       // ps.insert(p);
        depart.setValue(null);
        destination.setValue(null);
        nbr.clear();
        date_depart.setValue(null);
        datearrivee.setValue(null);
        idu.clear();
        heureD.clear();
        heureA.clear();
         afficherCov(AuthentificationController.LoggedParent);}else{
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ville ");
            alert.setHeaderText("veuillez verifier la ville départ et ville destination");
            Optional<ButtonType> result = alert.showAndWait();
            
       
       }
    }
      
    

  
    

    

    @FXML
    private void supprimer(ActionEvent event) {
         int i=table.getSelectionModel().getSelectedItem().getId();
        // System.out.println(i);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer ce covoiturage");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
 
        CovoiturageService ps=new CovoiturageService();
      ps.delete(i);
      afficherCov(AuthentificationController.LoggedParent);}
        
        
    }
    
    @FXML
        public void afficherListeCovoiturage()
       {
          CovoiturageService ps = new CovoiturageService() ; 
          ObservableList<Covoiturage> lp = ps.getAll() ; 
          
          liste.setCellFactory(new Callback<ListView<Covoiturage>, ListCell<Covoiturage>>() {
              @Override
              public ListCell<Covoiturage> call(ListView<Covoiturage> param) {
                  ListCell<Covoiturage> cell = new ListCell<Covoiturage>() {
                      @Override
                    protected void updateItem(Covoiturage p , boolean bl) {
                        super.updateItem(p, bl);
                        if(p!=null){
                           /* ParentService ps = new ParentService() ; 
                            Parent p1 =  ps.searchImg(p.getId_user()) ; */
                           //String im = "file:/C:/Users/imen/Desktop/imen.png" ;    

                            Image img = new Image("file:/C:/wamp/www/ressources/imencov.jpg", 100, 100, true, true, true) ; 

                            //Image img = new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia3/AllForKids/src/allforkids/GUI/img/cov.png", 100, 100, true, true, true) ; 

                            ImageView imgV = new ImageView(img) ; 
                            setGraphic(imgV); 
                            setText("Depart : " + p.getDepart() + "\n"+"DateDepart : " + p.getDateDepart() + "\n"+"Destination : " + p.getDestination() + "\n" +"Heure dÃ©part : " + p.getHeureD() + "\n"+"Date arrivÃ© : " + p.getDateArrive() + "\n"+"Heure arrivÃ© : " + p.getHeureA() + "\n"+"Nombre de places disponibles : " + p.getNbre_place_dispo() );
                               
                        }
                        
                    }
                  } ; return cell ; 
              }
          });
      liste.setItems(lp);
           
       }
        
    @FXML
      public void modifier()
     {
          btn1.setDisable(false);
           id.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getId()));
           idu.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getId_user())); 
          depart.setValue(table.getSelectionModel().getSelectedItem().getDepart());
          destination.setValue(table.getSelectionModel().getSelectedItem().getDestination());
          date_depart.getEditor().setText((table.getSelectionModel().getSelectedItem().getDateDepart()));
          heureD.setText(table.getSelectionModel().getSelectedItem().getHeureD());
          datearrivee.getEditor().setText((table.getSelectionModel().getSelectedItem().getDateArrive()));
          heureA.setText(table.getSelectionModel().getSelectedItem().getHeureA());
          nbr.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getNbre_place_dispo()));
          
    
     }
     public void mod2()
     {
    CovoiturageService ps=new CovoiturageService();
     //Covoiturage e= new Covoiturage(Integer.parseInt(id.getText()),Integer.parseInt(iduser.getText()),depart.getValue(),date_depart.getEditor().getText(),heureD.getText(),destination.getValue(),datearrivee.getEditor().getText(),heureA.getText(),Integer.parseInt(nbr.getText()));
      Covoiturage e= new Covoiturage(Integer.parseInt(id.getText()),Integer.parseInt(idu.getText()),depart.getValue(),date_depart.getEditor().getText(),heureD.getText(),destination.getValue(),datearrivee.getEditor().getText(),heureA.getText(),Integer.parseInt(nbr.getText()));
     ps.update(e);
      
    afficherCov(AuthentificationController.LoggedParent);
     }
        public void afficherCov(Parent u)
       {
           
           //id_parent.setext(u.getId_user);
           
          CovoiturageService as=new CovoiturageService();
          //Covoiturage b= as.search(u.getId_user());
          int i=u.getId_user();
          table.setItems(as.search1(i));
          
           ObservableList<Covoiturage> liste=as.search1(u.getId_user());
           for(Covoiturage c :liste)
           { System.out.println("le covoiturage :"+c);}
         Cd.setCellValueFactory(new PropertyValueFactory<>("depart"));
         Cd1.setCellValueFactory(new PropertyValueFactory<>("destination"));
         Cdepart.setCellValueFactory(new PropertyValueFactory<>("dateDepart"));
         Carrive.setCellValueFactory(new PropertyValueFactory<>("dateArrive"));
         Cha.setCellValueFactory(new PropertyValueFactory<>("heureA"));
         Chd.setCellValueFactory(new PropertyValueFactory<>("heureD"));
         Cnbr.setCellValueFactory(new PropertyValueFactory<>("nbre_place_dispo"));
         Cid.setCellValueFactory(new PropertyValueFactory<>("id"));
         Cidu.setCellValueFactory(new PropertyValueFactory<>("id_user"));
          
       }
          public void afficher(Parent u)
       {
           
          idu.setText(Integer.toString(u.getId_user()));
           /*CovoiturageService as=new CovoiturageService();
           Covoiturage b= as.search(AuthentificationController.LoggedParent.getId_user());
           System.out.println(b);*/
       }
            /*  public void afficherListeReservation()
       {
          listeR.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); 
          CovoiturageService ps = new CovoiturageService() ; 
          ObservableList<Covoiturage> lp = ps.getAll() ; 
          
          listeR.setCellFactory(new Callback<ListView<Covoiturage>, ListCell<Covoiturage>>() {
              @Override
              public ListCell<Covoiturage> call(ListView<Covoiturage> param) {
                  ListCell<Covoiturage> cell = new ListCell<Covoiturage>() {
                      @Override
                    protected void updateItem(Covoiturage p , boolean bl) {
                        super.updateItem(p, bl);
                        if(p!=null){
                            System.out.println(p.getId_user());
                            ReservationService rs = new ReservationService() ; 
                            Reservation r = rs.search1(AuthentificationController.LoggedParent.getId_user()) ; 
                            System.out.println(r);
                           /* ParentService ps = new ParentService() ; 
                            Parent p1 =  ps.searchImg(p.getId_user()) ; */
                           //String im = "file:/C:/Users/imen/Desktop/imen.png" ;    

                           /* Image img = new Image("file:/C:/wamp/www/ressources/reservation.png", 100, 100, true, true, true) ; */

                          //  Image img = new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia3/AllForKids/src/allforkids/GUI/reserv.png", 100, 100, true, true, true) ; 

                           /* ImageView imgV = new ImageView(img) ; 
                            setGraphic(imgV); 
                            setText("Depart : " + p.getDepart() + "\n"+"DateDepart : " + p.getDateDepart() + "\n"+"Destination : " + p.getDestination() + "\n" +"Heure dÃ©part : " + p.getHeureD() + "\n"+"Date arrivÃ© : " + p.getDateArrive() + "\n"+"Heure arrivÃ© : " + p.getHeureA() + "\n"+"Nombre de places disponibles : " + p.getNbre_place_dispo() + "\n"+"Nombre de place reservÃ©: " + r.getNbre_place()+ "\n");
                               
                        }
                        
                    }
                  } ; return cell ; 
              }
          });
      listeR.setItems(lp);
   
}*/
    @FXML
          public void afficherListeReservation()
       {
          listeR.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); 
          ReservationService ps = new ReservationService() ; 
          ObservableList<Reservation> lp = ps.search1(AuthentificationController.LoggedParent.getId_user());
          
          listeR.setCellFactory(new Callback<ListView<Reservation>, ListCell<Reservation>>() {
              @Override
              public ListCell<Reservation> call(ListView<Reservation> param) {
                  ListCell<Reservation> cell = new ListCell<Reservation>() {
                      @Override
                    protected void updateItem(Reservation p , boolean bl) {
                        super.updateItem(p, bl);
                        if(p!=null){
                            System.out.println(p.getId_user());
                            CovoiturageService rs = new CovoiturageService() ; 
                            Covoiturage r = rs.searchCo(p.getIdC()) ; 
                            System.out.println(r);
                            /*ParentService ps = new ParentService() ; 
                            Parent p1 =  ps.searchImg(p.getId_user()) ; */
                             //String im = "file:/C:/Users/imen/Desktop/imen.png" ;    

                            Image img = new Image("file:/C:/wamp/www/ressources/reservation.png", 100, 100, true, true, true) ; 

                          //  Image img = new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia3/AllForKids/src/allforkids/GUI/reserv.png", 100, 100, true, true, true) ; 

                            ImageView imgV = new ImageView(img) ; 
                            setGraphic(imgV); 
                            setText("Depart : " + r.getDepart() + "\n"+"DateDepart : " + r.getDateDepart() + "\n"+"Destination : " + r.getDestination() + "\n" +"Heure dÃ©part : " + r.getHeureD() + "\n"+"Date arrivÃ© : " + r.getDateArrive() + "\n"+"Heure arrivÃ© : " + r.getHeureA() + "\n"+"Nombre de places disponibles : " + r.getNbre_place_dispo() + "\n"+"Nombre de place reservÃ©: " + p.getNbre_place()+ "\n");
                               
                        }
                        
                    }
                  } ; return cell ; 
              }
          });
      listeR.setItems(lp);
   
}
/*******************************Reservation*****************************************/
            @FXML
            private void supprimer1(ActionEvent event){
        CovoiturageService ds=new CovoiturageService();
         ReservationService ps= new ReservationService();
        // listeR.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
      ObservableList<Reservation> selectedItems = listeR.getSelectionModel().getSelectedItems();
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setHeaderText("Voulez vous supprimer votre rÃ©servation?");
       Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
                        for(Reservation s : selectedItems){
                     //       System.out.println(s);
                        //ds.delete(s.getId());
                            ps.delete(s.getId());    
                       
                        }
                            

                    }
         afficherListeReservation(); 
    
            }
@FXML
    public void rechercher()
{
Covoiturage e=null;
String nom=afficher_entry.getText();
 CovoiturageService ps=new CovoiturageService();


        table.setItems(null);
                table.setItems(ps.findbyVille(nom));
  Cd.setCellValueFactory(new PropertyValueFactory<>("depart"));
         Cd1.setCellValueFactory(new PropertyValueFactory<>("destination"));
         Cdepart.setCellValueFactory(new PropertyValueFactory<>("dateDepart"));
         Carrive.setCellValueFactory(new PropertyValueFactory<>("dateArrive"));
         Cha.setCellValueFactory(new PropertyValueFactory<>("heureA"));
         Chd.setCellValueFactory(new PropertyValueFactory<>("heureD"));
         Cnbr.setCellValueFactory(new PropertyValueFactory<>("nbre_place_dispo"));
         Cid.setCellValueFactory(new PropertyValueFactory<>("id"));
         Cidu.setCellValueFactory(new PropertyValueFactory<>("id_user"));
              
              if(afficher_entry.getText().isEmpty()){
              afficherCov(AuthentificationController.LoggedParent);
              }}
    
          @FXML
            public void ajouter2(){
                ReservationService ps= new ReservationService();
               
               Reservation p= new Reservation(AuthentificationController.LoggedParent.getId_user(),Integer.parseInt(np.getText()));
                ObservableList<Covoiturage> selectedItems = liste.getSelectionModel().getSelectedItems();
              {
                        for(Covoiturage s : selectedItems){
                            if(s.getNbre_place_dispo()<Integer.parseInt(np.getText()))
                            {
                                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                                 alert1.setHeaderText("Nombre de place ajouté invalide!");
                                 Optional<ButtonType> result1 = alert1.showAndWait();
                                 if (result1.get() == ButtonType.OK){
                                       np.clear();
                                 }
                                
                            }
                            else{ Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                      alert.setHeaderText("Votre rÃ©servation a Ã©tÃ© ajoutÃ©!");
                    Optional<ButtonType> result = alert.showAndWait();
                 if (result.get() == ButtonType.OK)
                     {  ps.insert1(p,s.getId());}
                       
                         }
        }
           
        np.clear();
        
         
            }
            }
               @FXML
            private void modifier1(ActionEvent event){
              
             /*   ReservationService ps= new ReservationService();
                
                 Reservation p= new Reservation(AuthentificationController.LoggedParent.getId_user(),Integer.parseInt(nouv.getText()));
                 ObservableList<Covoiturage> selectedItems = listeR.getSelectionModel().getSelectedItems();
                 {
                     for(Covoiturage s : selectedItems)
                           
                        i=s.getId();
                         
                    }
                    ps.update(p,s.getId());
                            System.out.println("imeeeen"+ps);        
                            afficherListeReservation();
                            nouv.clear();
          
            }*/ 
   
            }
            
    @FXML
           public void modifier2()
           {
               ReservationService ps= new ReservationService();
              
                ObservableList<Reservation> selectedItems = listeR.getSelectionModel().getSelectedItems();
              
                        for(Reservation s : selectedItems){
                            CovoiturageService cs=new CovoiturageService();
                            Covoiturage c=cs.searchCo(s.getIdC());
                            int a=Integer.parseInt(nouv.getText());
                           // System.out.println("aaaa:"+a);
                            //System.out.println("cccc:"+c.getNbre_place_dispo());
                            if(c.getNbre_place_dispo()<a)
                            {
                                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                                 alert1.setHeaderText("Nombre de place ajouté invalide!");
                                 Optional<ButtonType> result1 = alert1.showAndWait();
                                 if (result1.get() == ButtonType.OK){
                                       nouv.clear();
                                 }
                                
                            }
                            else{ Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                      alert.setHeaderText("Votre réservation a été modifier!");
                    Optional<ButtonType> result = alert.showAndWait();
                 if (result.get() == ButtonType.OK)
                     {  Reservation p= new Reservation(s.getId(),AuthentificationController.LoggedParent.getId_user(),Integer.parseInt(nouv.getText()),s.getIdC());
                         ps.update1(p,c.getId());
                        System.out.println(ps);}
                            
                         }
        }
           
        nouv.clear();
           afficherListeReservation();  
         
            
           }

    @FXML
    private void afficher(ActionEvent event) {
        AnchorPane2.setVisible(true);
       retire.setVisible(true);
    }

    @FXML
    private void gotoDemandeTravail(MouseEvent event) {
    }

    @FXML
    private void boutique(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("listViewTest.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void retirer(ActionEvent event) {
        AnchorPane2.setVisible(false);
        retire.setVisible(false);
    }

    @FXML
    private void onclickCov(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Cov.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void aff1(ActionEvent event) {
        anB.setVisible(true);
        fleche2.setVisible(false);
        fleche1.setVisible(true);
    }

    @FXML
    private void aff2(ActionEvent event) {
         anB.setVisible(false);
        fleche2.setVisible(true);
        fleche1.setVisible(false);
    }

    @FXML
    private void Reclamation(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void ListeOffre(ActionEvent event) {
    }

    @FXML
    private void Demandes(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("demande.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void ServiceAllForKids(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("babysitterPersonnel.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

   

    @FXML
    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AcceuilParent.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    
}

            

