/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Admin;
import allforkids.entite.Garderie;
import allforkids.entite.ProprietaireG;
import allforkids.service.AdminService;
import allforkids.service.GarderieService;
import allforkids.service.ProprietaireGService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

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
    @FXML
    private ToggleButton param1;
    @FXML
    private ToggleButton param2;
    @FXML
    private ToggleButton triangle;
    @FXML
    private ToggleButton triangle1;
    @FXML
    private ImageView flou;
    @FXML
    private AnchorPane Param;
    @FXML
    private ToggleButton Compte;
    @FXML
    private ToggleButton Deco;
    @FXML
    private ImageView Tparam;
    @FXML
    private AnchorPane anCompte;
    @FXML
    private JFXTextField Tpseudo;
    @FXML
    private JFXPasswordField Amdp;
    @FXML
    private JFXPasswordField Nmdp;
    @FXML
    private JFXButton annul;
    @FXML
    private JFXButton enregistrer;
    @FXML
    private ToggleButton fermer;

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
        
        String s="file:/C:/wamp/www/ressources/" ; 
        String imageFile =s+a.getImage();
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
                          String s="file:/C:/wamp/www/ressources/" ; 
                          Image img = new Image(s+p.getImage(), 200, 200, true, true, true) ;
                          
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

    @FXML
    private void parametrage(ActionEvent event) {
        Param.setVisible(true);
       Tparam.setVisible(true);
        param1.setVisible(false);
        param2.setVisible(true);
        triangle.setVisible(true);
        triangle1.setVisible(false);
    }

    @FXML
    private void parametrage2(ActionEvent event) {
        Param.setVisible(false);
        Tparam.setVisible(false);
        param2.setVisible(false);
        param1.setVisible(true);
        triangle.setVisible(false);
        triangle1.setVisible(true);
    }

    @FXML
    public void CompteCouleur1(){
    Compte.setTextFill(Color.WHITE);
    }
    @FXML
    public void CompteCouleur2(){
    Compte.setTextFill(Color.BLUE);
    }

    @FXML
    private void Compte(ActionEvent event) {
       flou.setVisible(true);
       anCompte.setVisible(true);
        System.out.println("pseudo:"+AuthentificationController.LoggedProprietaireG.getPseudo());
        Tpseudo.setText(AuthentificationController.LoggedProprietaireG.getPseudo());
        Tpseudo.setDisable(true);
         Tparam.setVisible(false);
       Param.setVisible(false);
    }

    @FXML
     public void DecoCouleur1(){
    Deco.setTextFill(Color.WHITE);
    }
    @FXML
    public void DecoCouleur2(){
    Deco.setTextFill(Color.BLUE);
    }
    

     @FXML
private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) Deco.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    @FXML
    private void annul(ActionEvent event) {
         flou.setVisible(false);
       anCompte.setVisible(false);
        Tparam.setVisible(true);
       Param.setVisible(true);
    }
@FXML
    private void enregistrer(ActionEvent event) {
       
       
        if(Amdp.getText().equals(AuthentificationController.LoggedProprietaireG.getMdp())){
        ProprietaireG a= new ProprietaireG(AuthentificationController.LoggedProprietaireG.getId_user(),AuthentificationController.LoggedProprietaireG.getPseudo(),Nmdp.getText(),AuthentificationController.LoggedProprietaireG.getEmail());
        ProprietaireGService as=new ProprietaireGService();
        as.update(a);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Sécurité");
            alert.setHeaderText("Votre mot de passe a été changé");
            Optional<ButtonType> result = alert.showAndWait();
        Tpseudo.clear();
        Amdp.clear();
            Nmdp.clear();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Mot de passe");
            alert.setHeaderText("Mot de passe incorrecte");
            Optional<ButtonType> result = alert.showAndWait();
            Amdp.clear();
            Nmdp.clear();
        }
    }

    @FXML
    private void fermer(ActionEvent event) {
        flou.setVisible(false);
       anCompte.setVisible(false);
       Tparam.setVisible(true);
       Param.setVisible(true);
    }
}
