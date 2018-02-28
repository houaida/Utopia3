/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Produit;
import allforkids.entite.Quiz;
import allforkids.entite.UQuiz;
import allforkids.service.ProduitService;
import allforkids.service.QuizService;
import allforkids.service.UQuizService;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class QuizController implements Initializable {


    private Label lb;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ToggleButton gestionPrduit;
    @FXML
    private ToggleButton retire;
    @FXML
    private ToggleButton clubs;
    @FXML
    private ToggleButton fleche2;
    @FXML
    private ToggleButton fleche1;
    @FXML
    private ToggleButton evenements;
    @FXML
    private Label lbq;
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Label lb3;
    @FXML
    private Label lbq2;
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private RadioButton r1;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton r2;
    @FXML
    private RadioButton r3;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        QuizService qs=new QuizService();
      Quiz  q=null;
        q=qs.findbyEtat(1);
        
    lbq.setText(q.getQuestion());
    lb1.setText(q.getRep1());
    lb2.setText(q.getRep2());
    lb3.setText(q.getRep3());
           ToggleGroup group = new ToggleGroup();
    RadioButton r1 = new RadioButton("select first");
   r1.setToggleGroup(group);
    
    RadioButton r2 = new RadioButton("select second");
    r2.setToggleGroup(group);
    group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
         @Override
    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
ToggleGroup group = new ToggleGroup();
         if (group.getSelectedToggle() != null) {

             System.out.println(group.getSelectedToggle().getUserData().toString());
             // Do something here with the userData of newly selected radioButton

         }

     } 
});
        
    }
    

    @FXML
    private void ConseilsGoogle(ActionEvent event) {
    }

    @FXML
    private void gotoDemandeTravail(MouseEvent event) {
    }

    @FXML
    private void boutique(ActionEvent event) {
    }

    @FXML
    private void retirer(ActionEvent event) {
    }

    @FXML
    private void Evaluation(ActionEvent event) {
    }

    @FXML
    private void onclickCov(ActionEvent event) {
    }

    @FXML
    private void clubs(ActionEvent event) {
    }

    @FXML
    private void aff1(ActionEvent event) {
    }

    @FXML
    private void aff2(ActionEvent event) {
    }

    @FXML
    private void evenements(ActionEvent event) {
    }

    @FXML
    private void quiz(ActionEvent event) {
    }

    @FXML
    private void resultat(ActionEvent event) throws IOException {
        
      
         QuizService qs=new QuizService();
      Quiz  q=null;
        q=qs.findbyEtat(1);
         UQuizService uqs=new UQuizService();
         UQuiz uq=null;
         uq=new UQuiz(AuthentificationController.LoggedParent.getId_user(),q.getId_quiz());
    uqs.insert(uq);
        Produit m=MaxProduit();
        if(q.getRepC().equals(lb1.getText())&&(r1.isSelected())){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Félicitation");
            alert.setHeaderText("Bravo vous avez gagné avec AllForKids ce produit:"+m.toString());
            Optional<ButtonType> result = alert.showAndWait();
            ProduitService prs=new ProduitService();
            prs.updateQuantite(m);
             AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilParent.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        }
        else if(q.getRepC().equals(lb2.getText())&&(r2.isSelected()))
        {Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         alert.setTitle("Félicitation");
            alert.setHeaderText("Bravo vous avez gagné avec AllForKids ce produit:"+m.toString());
            Optional<ButtonType> result = alert.showAndWait();
            ProduitService prs=new ProduitService();
            prs.updateQuantite(m);
             AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilParent.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        }
        else if(q.getRepC().equals(lb3.getText())&&(r3.isSelected()))
        {Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         alert.setTitle("Félicitation");
            alert.setHeaderText("Bravo vous avez gagné avec AllForKids ce produit:"+m.toString());
            Optional<ButtonType> result = alert.showAndWait();
            ProduitService prs=new ProduitService();
            prs.updateQuantite(m);
             AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilParent.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        }
        else{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         alert.setTitle("Malheureusement");
            alert.setHeaderText("vous avez perdu à la prochaine cher parent");
            Optional<ButtonType> result = alert.showAndWait();
             AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilParent.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        }}
    
        public Produit MaxProduit(){
        ProduitService ps=new ProduitService();
        
         ObservableList<Produit> produits= ps.getAll();
         
         Produit max=null;
         int i=0;
         
         for(Produit p:produits){
         if(p.getQuantite()>=i){
         max=p;
         i=p.getQuantite();
         }
         
         }
         return max;
        }
    
}
