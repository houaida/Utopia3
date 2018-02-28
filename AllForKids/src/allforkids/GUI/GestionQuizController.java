/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Garderie;
import allforkids.entite.Produit;
import allforkids.entite.Quiz;
import allforkids.service.GarderieService;
import allforkids.service.QuizService;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class GestionQuizController implements Initializable {

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
    private ToggleButton gestionReclamation;
    @FXML
    private ToggleGroup menu;
    @FXML
    private Button btretour;
    @FXML
    private Label lbDebut;
    @FXML
    private JFXTextField tfTheme;
    @FXML
    private JFXTextField tfQuestion;
    @FXML
    private JFXTextField pathImage;
    @FXML
    private JFXTextField tfRep1;
    @FXML
    private JFXTextField tfRep2;
    @FXML
    private JFXTextField tfRep3;
    @FXML
    private JFXTextField tfRepC;
    @FXML
    private AnchorPane aperçu;
    @FXML
    private Label lbquestion;
    @FXML
    private Label lbrep1;
    @FXML
    private Label lbrep2;
    @FXML
    private Label lbrep3;
    @FXML
    private ImageView img;
    @FXML
    private JFXListView<Quiz> listeQ;
    @FXML
    private AnchorPane AnchorPane1;
    
public String id=" " ; 
    @FXML
    private JFXTextField etat;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listeQ.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    showDetails(newValue);
                    Apercu(newValue);
                });
        afficher2();
        etat.setText("0");
        etat.setDisable(true);
    }    
    public void showDetails(Quiz e){
        //int id = e.getId_produit() ; 
        id=Integer.toString(e.getId_quiz());
        tfTheme.setText(e.getTheme());
       
       tfQuestion.setText(e.getQuestion());
        tfRep1.setText(e.getRep1());
         tfRep2.setText(e.getRep2());
          tfRep3.setText(e.getRep3());
           tfRepC.setText(e.getRepC());
        pathImage.setText(e.getImage());
        
        
        
    }
    public void Apercu(Quiz e){
        //int id = e.getId_produit() ; 
        //id=Integer.toString(e.getId_quiz());
        //tfTheme.setText(e.getTheme());
       
       lbquestion.setText(e.getQuestion());
        lbrep1.setText(e.getRep1());
         lbrep2.setText(e.getRep2());
          lbrep3.setText(e.getRep3());
           String s="file:/C:/wamp/www/ressources/";
          String imageFile1 =s+e.getImage();
        Image image1 = new Image(imageFile1);
         
        img.setImage(image1);
        
        
        
        
    }

   @FXML
    private void afficher(ActionEvent event) {
         AnchorPane2.setVisible(true);
       retire.setVisible(true);
    }

    @FXML
    private void gestionUtilisateur(ActionEvent event) throws IOException {
          AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionUser.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        
    }
    @FXML
    private void gotoDemandeTravail(MouseEvent event) {
    }

    @FXML
    private void gestionProduit(ActionEvent event) throws IOException {
          AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("listeProduits.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    @FXML
    private void retirer(ActionEvent event) {
         AnchorPane2.setVisible(false);
        retire.setVisible(false);
    }

   @FXML
    private void gestionOffre(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("OffreDemandeComp.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

   @FXML
    private void approbation(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListviewApprouver.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        
    }

   @FXML
    private void gestionReclamation(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListviewReclamation.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        
    }

    @FXML
    private void gestionQuiz(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionQuiz.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        
    }

    @FXML
    private void ajouter(ActionEvent event) {
        QuizService ps=new QuizService();
        Quiz p= new Quiz(tfTheme.getText(),pathImage.getText(),tfQuestion.getText(),tfRep1.getText(),tfRep2.getText(),tfRep3.getText(),tfRepC.getText(),Integer.parseInt(etat.getText()));
        ps.insert(p);
        tfTheme.clear();
        tfQuestion.clear();
        tfRep1.clear();
      
     tfRep2.clear();
     tfRep3.clear();
     tfRepC.clear();
        afficher2();
    }

    @FXML
    private void modifier(ActionEvent event) {
         QuizService ps=new QuizService();
    Quiz e=new Quiz(Integer.parseInt(id),tfTheme.getText(),pathImage.getText(),
     tfQuestion.getText(),tfRep1.getText(),tfRep2.getText(),tfRep3.getText(),tfRepC.getText(),Integer.parseInt(etat.getText()));
     ps.update(e);
     afficher2();
    }

    @FXML
    private void supprimer(ActionEvent event) {
        int i=listeQ.getSelectionModel().getSelectedItem().getId_quiz();
         System.out.println(i);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer ce quiz");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
     QuizService ps=new QuizService();
        
      ps.delete(i);
      afficher2();}
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
          AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilAdmin.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        
    }
public void afficher2()
       {
          /* if(listeQ.getSelectionModel().getSelectedItem().getId_quiz()!=0){
           tfTheme.setText(listeQ.getSelectionModel().getSelectedItem().getTheme());
            tfQuestion.setText(listeQ.getSelectionModel().getSelectedItem().getQuestion());
             pathImage.setText(listeQ.getSelectionModel().getSelectedItem().getImage());
              tfRep1.setText(listeQ.getSelectionModel().getSelectedItem().getRep1());
               tfRep2.setText(listeQ.getSelectionModel().getSelectedItem().getRep2());
                tfRep3.setText(listeQ.getSelectionModel().getSelectedItem().getRep3());
                 tfRepC.setText(listeQ.getSelectionModel().getSelectedItem().getRepC());
           }
           else {
            tfTheme.setText("");
            tfQuestion.setText("");
             pathImage.setText("");
              tfRep1.setText("");
               tfRep2.setText("");
                tfRep3.setText("");
                 tfRepC.setText("");
           }*/
          QuizService ps = new QuizService() ;
          ObservableList<Quiz> lp = ps.getAll(); 
          
          listeQ.setCellFactory((ListView<Quiz> param) -> {
              ListCell<Quiz> cell = new ListCell<Quiz>() {
                  @Override
                  protected void updateItem(Quiz p , boolean bl) {
                      super.updateItem(p, bl);
                      
                      if(p!=null){
                           String s="file:/C:/wamp/www/ressources/";
                          Image img = new Image(s+p.getImage(), 200, 200, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
                          
                          setText(" theme : "+p.getTheme()+"\n question : "+p.getQuestion()+"\n réponse 1 : "+p.getRep1()+"\n réponse 2 : "+p.getRep2()+"\n réponse 3 : "+p.getRep3()+"\n réponse correcte : "+p.getRepC());
                      }
                  }
              } ; return cell ;
          });
      listeQ.setItems(lp);
           
       } 
    @FXML
    private void actionBrowse(ActionEvent event) throws MalformedURLException {
        String imageFile;
      
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);
            Image image1 = new Image(imageFile);
            //imgV.setImage(image1);
            pathImage.setText(imageFile);
        } else {
            System.out.println("file doesn't exist");
        }
    }

    @FXML
    private void confirmer(ActionEvent event) {
          QuizService ps=new QuizService();
          Quiz q=null;
                  q=ps.findbyEtat(1);
          if(q!=null){
              ps.update2(q);
           Quiz e=new Quiz(Integer.parseInt(id),tfTheme.getText(),pathImage.getText(),
     tfQuestion.getText(),tfRep1.getText(),tfRep2.getText(),tfRep3.getText(),tfRepC.getText(),1);
     ps.update(e);
          }else{
    Quiz e=new Quiz(Integer.parseInt(id),tfTheme.getText(),pathImage.getText(),
     tfQuestion.getText(),tfRep1.getText(),tfRep2.getText(),tfRep3.getText(),tfRepC.getText(),1);
     ps.update(e);}
    }
    
}
