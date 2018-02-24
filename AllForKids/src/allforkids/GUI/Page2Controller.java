/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Admin;
import allforkids.entite.Covoiturage;
import allforkids.entite.Reservation;
import allforkids.service.CovoiturageService;
import allforkids.service.ReservationService;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class Page2Controller implements Initializable {
 @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ToggleButton gestionUtilisateur;
    @FXML
    private ToggleButton gestionProduit;
    @FXML
    private ToggleButton retire;
    @FXML
    private ToggleButton gestionOffre;
    @FXML
    private ToggleButton gestionUtilisateur1;
    @FXML
    private TextField id_user;
    @FXML
    private ImageView profil;
    @FXML
    private Label pseudo;
     @FXML
    private ToggleButton page1;
    @FXML
    private ToggleButton page2;
    @FXML
    private JFXListView<Covoiturage> liste;
    @FXML
    private JFXListView<Covoiturage> listeR;
    @FXML
    private ToggleButton fleche2;
    @FXML
    private ToggleButton fleche1;
    @FXML
    private BorderPane anB;
    @FXML
    private ToggleButton gestionReclamation;
    @FXML
    private ToggleButton gestionReclamation1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AnchorPane1.setPrefSize(1329,866);
               afficherListeCovoiturage();
        afficherUser(AuthentificationController.LoggedAdmin);
        afficherListeReservation();
    }    
    private void afficherUser(Admin a) {
        pseudo.setText(a.getPseudo());
        
        
        String imageFile =a.getImage();
        Image img=new Image(imageFile,280,280,true,true,true);
        profil.setImage(img);
        final Circle clip = new Circle(60, 60, 55);
        profil.setClip(clip);
    }
    
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
                            Image img = new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/28308637_1258699480931726_1081687478_n.png", 100, 100, true, true, true) ; 
                            ImageView imgV = new ImageView(img) ; 
                            setGraphic(imgV); 
                            setText("Depart : " + p.getDepart() + "\n"+"DateDepart : " + p.getDateDepart() + "\n"+"Destination : " + p.getDestination() + "\n" +"Heure départ : " + p.getHeureD() + "\n"+"Date arrivé : " + p.getDateArrive() + "\n"+"Heure arrivé : " + p.getHeureA() + "\n"+"Nombre de places disponibles : " + p.getNbre_place_dispo() );
                               
                        }
                        
                    }
                  } ; return cell ; 
              }
          });
      liste.setItems(lp);
           
       }

public void afficherListeReservation()
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
                            System.out.println("iddd:"+p.getId_user());
                            Reservation r = rs.search1(p.getId_user()); 
                            //System.out.println("rrrr:"+r);
                            System.out.println(r);
                           /* ParentService ps = new ParentService() ; 
                            Parent p1 =  ps.searchImg(p.getId_user()) ; */
                           //String im = "file:/C:/Users/imen/Desktop/imen.png" ;    
                            Image img = new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/28236357_1769461659772238_2102816472_n.png", 100, 100, true, true, true) ; 
                            ImageView imgV = new ImageView(img) ; 
                            setGraphic(imgV); 
                            setText("Depart : " + p.getDepart() + "\n"+"DateDepart : " + p.getDateDepart() + "\n"+"Destination : " + p.getDestination() + "\n" +"Heure départ : " + p.getHeureD() + "\n"+"Date arrivé : " + p.getDateArrive() + "\n"+"Heure arrivé : " + p.getHeureA() + "\n"+"Nombre de places disponibles : " + p.getNbre_place_dispo() + "\n"+"Nombre de place reservé: " + r.getNbre_place()+ "\n");
                               
                        }
                        
                    }
                  } ; return cell ; 
              }
          });
      listeR.setItems(lp);
    
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
    private void retirer(ActionEvent event) {
         AnchorPane2.setVisible(false);
        retire.setVisible(false);
    }
    @FXML
    private void page1(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilAdmin.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void page2(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Page2.fxml"));
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
    private void gestionReclamation(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListviewReclamation.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        
    }

    @FXML
    private void gestionDemande(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("demandeTravail.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void gestionOffre(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("OffreDemandeComp.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
        
}
