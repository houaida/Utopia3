/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Enseignant;
import allforkids.entite.Evaluation;
import allforkids.service.EnseignantService;

import allforkids.service.EvaluationService;
import java.io.IOException;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class GestionEvaluationController implements Initializable {
     @FXML
    private Button btn1;
      @FXML
    private TextField entrer;
     @FXML
    private TextField idEva;
     @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
     @FXML
    private TextField matiere;
    @FXML
    private TextField moyenne;
    
    
 @FXML
    private TableView<Evaluation> table;
 @FXML
    private TableColumn<Evaluation, Integer> Cid;
    @FXML
    private TableColumn<Evaluation, String> Cnom;
    @FXML
    private TableColumn<Evaluation, String> Cprenom;
    @FXML
    private TableColumn<Evaluation, String> Cmatiere;
    @FXML
    private TableColumn<Evaluation, Float> Cmoyenne;
    @FXML
    private TableColumn<Evaluation, String> Cremarque;
    @FXML
    private Label lbTitulo1;
    @FXML
    private ToggleGroup menu;
    @FXML
    private Button btretour;
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private TextField idEns;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherEva(AuthentificationController.LoggedEnseignant);
         afficher(AuthentificationController.LoggedEnseignant);
    }    
      public void afficher(Enseignant u)
    {
        
        
    
    }
     public void afficherEva(Enseignant u)
       {
           EnseignantService ius = new EnseignantService();
        //System.out.println(u.getId_user());
        idEns.setText(Integer.toString(u.getId_user()));
        System.out.println("iddddddd"+idEns.getText());
            EvaluationService ips = new EvaluationService();
            
            System.out.println("iddd="+idEns.getText());
            Enseignant e=ius.search(Integer.parseInt(idEns.getText()));
            table.setItems(null);
                table.setItems(ips.getAllByIDEns(e.getId_user()));
 Cid.setCellValueFactory(new PropertyValueFactory<>("id_evaluation"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom_enfant"));
          
        Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom_enfant"));
        Cmatiere.setCellValueFactory(new PropertyValueFactory<>("matiere"));
              Cmoyenne.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
              Cremarque.setCellValueFactory(new PropertyValueFactory<>("nom_enseignant"));

       }
    @FXML
     public void ajouter()
     {EnseignantService es=new EnseignantService();
            Enseignant e=es.search(Integer.parseInt(idEns.getText()));
     EvaluationService ps=new EvaluationService();
        Evaluation p= new Evaluation(Integer.parseInt(idEns.getText()),matiere.getText(),Float.parseFloat(moyenne.getText()),e.getNom(),nom.getText(),prenom.getText());
        ps.insert(p);
        nom.clear();
        prenom.clear();
        matiere.clear();
        moyenne.clear();
        
        afficherEva(AuthentificationController.LoggedEnseignant);
        
     }
    @FXML
     public void supprimer()
     {
         int i=table.getSelectionModel().getSelectedItem().getId_evaluation();
         System.out.println(i);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer cette évaluation");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
     EvaluationService ps=new EvaluationService();
        
      ps.delete(i);
      afficherEva(AuthentificationController.LoggedEnseignant);}
        
     }
    @FXML
     public void modifier()
     {
          btn1.setDisable(false);
          idEva.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getId_evaluation()));
     nom.setText(table.getSelectionModel().getSelectedItem().getNom_enfant());
     prenom.setText(table.getSelectionModel().getSelectedItem().getPrenom_enfant());
     matiere.setText(table.getSelectionModel().getSelectedItem().getMatiere());
     moyenne.setText(Float.toString(table.getSelectionModel().getSelectedItem().getMoyenne()));
    
    
     }
    @FXML
     public void mod2()
     {EnseignantService es=new EnseignantService();
            Enseignant p=es.search(Integer.parseInt(idEns.getText()));
     EvaluationService ps=new EvaluationService();
     Evaluation e=new Evaluation(Integer.parseInt(idEva.getText()),Integer.parseInt(idEns.getText()),
     matiere.getText(),Float.parseFloat(moyenne.getText()),p.getNom(),nom.getText(),
    prenom.getText());
     ps.update(e);
     afficherEva(AuthentificationController.LoggedEnseignant);
     }
    @FXML
    public void rechercher()
{
Evaluation e=null;
String nom=entrer.getText();
 EvaluationService ps=new EvaluationService();


        table.setItems(null);
                table.setItems(ps.getAllByName(nom));
 Cid.setCellValueFactory(new PropertyValueFactory<>("id_evaluation"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom_enfant"));
          
        Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom_enfant"));
        Cmatiere.setCellValueFactory(new PropertyValueFactory<>("matiere"));
              Cmoyenne.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
              Cremarque.setCellValueFactory(new PropertyValueFactory<>("nom_enseignant"));
              if(entrer.getText().isEmpty()){
              afficherEva(AuthentificationController.LoggedEnseignant);
              }

}


    @FXML
    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilParent.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void retour(MouseEvent event) {
    }

    
}
