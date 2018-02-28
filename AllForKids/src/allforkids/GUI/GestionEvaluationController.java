/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Enfant;
import allforkids.entite.EnfantJ;
import allforkids.entite.Enseignant;
import allforkids.entite.Evaluation;
import allforkids.entite.ProprietaireJ;
import allforkids.service.EnfantJService;
import allforkids.service.EnfantService;
import allforkids.service.EnseignantService;

import allforkids.service.EvaluationService;
import allforkids.service.ProprietaireJService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
    private ToggleGroup menu;
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private TextField idEns;
    @FXML
    private ToggleButton param1;
    @FXML
    private ToggleButton triangle1;
    @FXML
    private ToggleButton triangle;
    @FXML
    private ToggleButton param2;
    @FXML
    private ImageView Tparam;
    @FXML
    private ImageView flou;
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
    @FXML
    private AnchorPane Param;
    @FXML
    private ToggleButton Compte;
    @FXML
    private ToggleButton Deco;
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
     {
         EnfantService pse=new EnfantService();
         EnfantJService psj=new EnfantJService();
         System.out.println("nomenfant:"+nom.getText());
         System.out.println("prenomenfant:"+prenom.getText());
         Enfant en1=null;
                 en1=pse.getbyNomPrenom(nom.getText(), prenom.getText());
          EnfantJ en2=null;
                  en2=psj.getbyNomPrenom(nom.getText(), prenom.getText());
         System.out.println("enfant:"+pse.getbyNomPrenom(nom.getText(), prenom.getText()));
         System.out.println("enfantj:"+psj.getbyNomPrenom(nom.getText(), prenom.getText()));
         
         if(en1!=null)
         {EnseignantService es=new EnseignantService();
            Enseignant e=es.search(Integer.parseInt(idEns.getText()));
     EvaluationService ps=new EvaluationService();
        Evaluation p= new Evaluation(Integer.parseInt(idEns.getText()),matiere.getText(),Float.parseFloat(moyenne.getText()),e.getNom(),nom.getText(),prenom.getText());
        ps.insert(p);
        nom.clear();
        prenom.clear();
        matiere.clear();
        moyenne.clear();
        
        afficherEva(AuthentificationController.LoggedEnseignant);}
         else if(en2!=null)
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
         else{
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("enfant n'existe pas");
            alert.setHeaderText("veuillez vérifier les coordonnées de l'élève");
            Optional<ButtonType> result = alert.showAndWait();
            nom.clear();
            prenom.clear();
         }
        
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
     nom.clear();
     prenom.clear();
     matiere.clear();
     moyenne.clear();
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


    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilParent.fxml"));
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
        System.out.println("pseudo:"+AuthentificationController.LoggedEnseignant.getPseudo());
        Tpseudo.setText(AuthentificationController.LoggedEnseignant.getPseudo());
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
       
       
        if(Amdp.getText().equals(AuthentificationController.LoggedEnseignant.getMdp())){
        Enseignant a= new Enseignant(AuthentificationController.LoggedEnseignant.getId_user(),AuthentificationController.LoggedEnseignant.getPseudo(),Nmdp.getText(),AuthentificationController.LoggedEnseignant.getEmail());
        EnseignantService as=new EnseignantService();
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
