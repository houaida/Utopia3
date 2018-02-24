/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Babysitter;
import allforkids.entite.Enfant;
import allforkids.entite.EnfantJ;
import allforkids.entite.Enseignant;
import allforkids.entite.Evaluation;
import allforkids.entite.Garderie;
import allforkids.entite.JardinEnfant;
import allforkids.entite.Parent;
import allforkids.entite.ProprietaireG;
import allforkids.entite.ProprietaireJ;
import allforkids.service.BabysitterService;
import allforkids.service.EnfantJService;
import allforkids.service.EnfantService;
import allforkids.service.EnseignantService;
import allforkids.service.EvaluationService;
import allforkids.service.GarderieService;
import allforkids.service.JardinEnfantService;
import allforkids.service.ParentService;
import allforkids.service.ProprietaireGService;
import allforkids.service.ProprietaireJService;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class GestionUserController implements Initializable {
@FXML
private RadioButton Renseignant;
@FXML
private RadioButton Rparent;

@FXML
    private AnchorPane AnchorPane1;
 @FXML
    private TableView table;
 @FXML
    private TableColumn Cid_user;
 @FXML
    private TableColumn Ccin;
    @FXML
    private TableColumn Cnom;
    @FXML
    private TableColumn Cprenom;
    @FXML
    private TableColumn Cpseudo;
    @FXML
    private TableColumn Cmdp;
   @FXML
    private TableColumn Cemail;
    @FXML
    private TableColumn Cadresse;
    @FXML
    private TableColumn Cmontant;
    @FXML
    private TableColumn Cnom_club;
    @FXML
    private TableColumn Cnum_tel;
     @FXML
    private TextField entrer;
    @FXML
    private TextField nom;
    @FXML
    private TextField  cin;
    @FXML
    private TextField  num_tel;
    @FXML
    private TextField  prenom;
    @FXML
    private TextField  nom_club;
    @FXML
    private TextField  adresse;
    @FXML
    private TextField  email;
    @FXML
    private TextField  mdp;
    @FXML
    private TextField  pseudo;
    @FXML
    private TextField  montant;
    @FXML
    private TextField id_user;
     @FXML
    private Button btn1;
    @FXML
    private ToggleGroup menu;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton Babysitter;
    @FXML
    private Label Lcin;
    @FXML
    private Label Lnom;
    @FXML
    private Label Lprenom;
    @FXML
    private Label Lpseudo;
    @FXML
    private Label Lmdp;
    @FXML
    private Label Lemail;
    @FXML
    private Label Ladresse;
    @FXML
    private Label Lmontant;
    @FXML
    private Label Lnom_club;
    @FXML
    private Label Lnum_tel;
    @FXML
    private Button btretour;
    @FXML
    private RadioButton RpropG;
    @FXML
    private TableView<Babysitter> table1;
    @FXML
    private TableColumn Cid_user1;
    @FXML
    private TableColumn Ccin1;
    @FXML
    private TableColumn Cnom1;
    @FXML
    private TableColumn Cprenom1;
    @FXML
    private TableColumn Cpseudo1;
    @FXML
    private TableColumn Cmdp1;
    @FXML
    private TableColumn Cemail1;
    @FXML
    private TableColumn Cadresse1;
    @FXML
    private TableColumn Cmontant1;
    @FXML
    private TableColumn Cnom_club1;
    @FXML
    private TableColumn Cnum_tel1;
    @FXML
    private Label personnel;
    @FXML
    private Label inscrit;
    @FXML
    private TableColumn Cnaissance;
    @FXML
    private TableColumn Cnaissance1;
 
    @FXML
    private ImageView imgv1;
    @FXML
    private Label label;
    @FXML
    private TextField imgPath;
    @FXML
    private Button btbrowse;
    @FXML
    private Label Limage;
    @FXML
    private RadioButton RpropJ;
    @FXML
    private ToggleButton ajoutbt;
    @FXML
    private ToggleButton btmod;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
  afficher();
        ToggleGroup group = new ToggleGroup();
    RadioButton Renseignant = new RadioButton("select first");
   Renseignant.setToggleGroup(group);
    Renseignant.setSelected(true);
    RadioButton Rparent = new RadioButton("select second");
    Rparent.setToggleGroup(group);
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
    public void afficher()
    {
    if(Rparent.isSelected())
        
    { ajoutbt.setDisable(true);
    btmod.setDisable(false);
    btbrowse.setVisible(false);
    btn1.setVisible(true);
        cin.setDisable(false);
        adresse.setDisable(false);
       montant.setDisable(false);
       nom_club.setDisable(true);
       num_tel.setDisable(false);
                    Cnom_club.setVisible(false);
              Cnum_tel.setVisible(false);
               Cmontant.setVisible(true);
               Ccin.setVisible(true);
               Cnom.setVisible(true);
          Cprenom.setVisible(true);
          Cadresse.setVisible(true);
        ParentService ps=new ParentService();
    
         table.setItems(null);
                table.setItems(ps.getAll());
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Ccin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          Cnum_tel.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
        Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
              Cadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
              Cmontant.setCellValueFactory(new PropertyValueFactory<>("montant"));
             table.setPrefWidth(690);
              table.setPrefHeight(400);
//False les champs de saisie
       cin.setVisible(true);
       nom.setVisible(true);
       prenom.setVisible(true);
       pseudo.setVisible(true);
       mdp.setVisible(true);
       email.setVisible(true);
       adresse.setVisible(true);
       montant.setVisible(true);
       nom_club.setVisible(true);
       num_tel.setVisible(true);
       imgPath.setVisible(false);
        Cnaissance.setVisible(false);
                Cnaissance1.setVisible(false);
imgv1.setVisible(false);
        inscrit.setVisible(false);
        personnel.setVisible(false);
                table1.setVisible(false);
       //les labels false
       Lcin.setVisible(true);
       Lnom.setVisible(true);
       Lprenom.setVisible(true);
       Lpseudo.setVisible(true);
       Lmdp.setVisible(true);
       Lemail.setVisible(true);
       Ladresse.setVisible(true);
       Lmontant.setVisible(true);
       Lnom_club.setVisible(true);
       Lnum_tel.setVisible(true);
       Limage.setVisible(false);
             
      
                }
    else if(Renseignant.isSelected())
    {Cnaissance.setVisible(false);
                Cnaissance1.setVisible(false);
imgv1.setVisible(false);
        inscrit.setVisible(false);
        personnel.setVisible(false);
                table1.setVisible(false);
         table.setPrefWidth(636);
              table.setPrefHeight(400);
        ajoutbt.setDisable(true);
        btmod.setDisable(false);
      btbrowse.setVisible(false);
       btn1.setVisible(true);
        EnseignantService ps=new EnseignantService();
        cin.setDisable(false);
    montant.setDisable(false);
    adresse.setDisable(true);
    nom_club.setDisable(false);
    num_tel.setDisable(false);
    nom.setDisable(false);
    prenom.setDisable(false);
         table.setItems(null);
         Cnom_club.setVisible(true);
        Cadresse.setVisible(false);
       Cnum_tel.setVisible(false);
      Cmontant.setVisible(true);
       Ccin.setVisible(true);
       Cnom.setVisible(true);
        Cprenom.setVisible(true);
                table.setItems(ps.getAll());
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Ccin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
             
              Cnom_club.setCellValueFactory(new PropertyValueFactory<>("nom_club"));
              Cnum_tel.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
              
        //False les champs de saisie
       cin.setVisible(true);
       nom.setVisible(true);
       prenom.setVisible(true);
       pseudo.setVisible(true);
       mdp.setVisible(true);
       email.setVisible(true);
       adresse.setVisible(true);
       montant.setVisible(true);
       nom_club.setVisible(true);
       num_tel.setVisible(true);
       imgPath.setVisible(false);
       
       //les labels false
       Lcin.setVisible(true);
       Lnom.setVisible(true);
       Lprenom.setVisible(true);
       Lpseudo.setVisible(true);
       Lmdp.setVisible(true);
       Lemail.setVisible(true);
       Ladresse.setVisible(true);
       Lmontant.setVisible(true);
       Lnom_club.setVisible(true);
       Lnum_tel.setVisible(true);
       Limage.setVisible(false);
             
      
     }
    else if(RpropG.isSelected())
    {Cnaissance.setVisible(false);
                Cnaissance1.setVisible(false);
imgv1.setVisible(false);
        inscrit.setVisible(false);
        personnel.setVisible(false);
                table1.setVisible(false);
        ajoutbt.setDisable(false);
     btmod.setDisable(false);
    btbrowse.setVisible(true);
     btn1.setVisible(true);
     
           table.setPrefWidth(270);
             table.setPrefHeight(400);
        ProprietaireGService ps=new ProprietaireGService();
    montant.setDisable(true);
    adresse.setDisable(true);
    nom_club.setDisable(true);
    num_tel.setDisable(true);
    nom.setDisable(true);
    prenom.setDisable(true);
     cin.setDisable(true);
         table.setItems(null);
                table.setItems(ps.getAll());
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
             Cmontant.setVisible(false);
              Cnom_club.setVisible(false);
       Ccin.setVisible(false);
        Cnom.setVisible(false);
          Cprenom.setVisible(false);
           
        Cadresse.setVisible(false);
       Cnum_tel.setVisible(false);
       //False les champs de saisie
       cin.setVisible(true);
       nom.setVisible(true);
       prenom.setVisible(true);
       pseudo.setVisible(true);
       mdp.setVisible(true);
       email.setVisible(true);
       adresse.setVisible(true);
       montant.setVisible(true);
       nom_club.setVisible(true);
       num_tel.setVisible(true);
       imgPath.setVisible(true);
       //les labels false
       Lcin.setVisible(true);
       Lnom.setVisible(true);
       Lprenom.setVisible(true);
       Lpseudo.setVisible(true);
       Lmdp.setVisible(true);
       Lemail.setVisible(true);
       Ladresse.setVisible(true);
       Lmontant.setVisible(true);
       Lnom_club.setVisible(true);
       Lnum_tel.setVisible(true);
       Limage.setVisible(true);
             
     

    }
     else if(RpropJ.isSelected())
    {Cnaissance.setVisible(false);
                Cnaissance1.setVisible(false);
imgv1.setVisible(false);
        inscrit.setVisible(false);
        personnel.setVisible(false);
                table1.setVisible(false);
        ajoutbt.setDisable(false);
     btmod.setDisable(false);
    btbrowse.setVisible(true);
     btn1.setVisible(true);
     
           table.setPrefWidth(270);
             table.setPrefHeight(400);
        ajoutbt.setDisable(false);
     btmod.setDisable(false);
    btbrowse.setVisible(true);
     btn1.setVisible(true);
          table.setPrefWidth(270);
             // table.setPrefHeight(552);
        ProprietaireJService ps=new ProprietaireJService();
    montant.setDisable(true);
    adresse.setDisable(true);
    nom_club.setDisable(true);
    num_tel.setDisable(true);
    nom.setDisable(true);
    prenom.setDisable(true);
     cin.setDisable(true);
         table.setItems(null);
                table.setItems(ps.getAll());
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
             Cmontant.setVisible(false);
              Cnom_club.setVisible(false);
       Ccin.setVisible(false);
        Cnom.setVisible(false);
          Cprenom.setVisible(false);
           
        Cadresse.setVisible(false);
       Cnum_tel.setVisible(false);
       //False les champs de saisie
       cin.setVisible(true);
       nom.setVisible(true);
       prenom.setVisible(true);
       pseudo.setVisible(true);
       mdp.setVisible(true);
       email.setVisible(true);
       adresse.setVisible(true);
       montant.setVisible(true);
       nom_club.setVisible(true);
       num_tel.setVisible(true);
       imgPath.setVisible(true);
       //les labels false
       Lcin.setVisible(true);
       Lnom.setVisible(true);
       Lprenom.setVisible(true);
       Lpseudo.setVisible(true);
       Lmdp.setVisible(true);
       Lemail.setVisible(true);
       Ladresse.setVisible(true);
       Lmontant.setVisible(true);
       Lnom_club.setVisible(true);
       Lnum_tel.setVisible(true);
       Limage.setVisible(true);
             
     

    }
    else if(Babysitter.isSelected())
    {table.setPrefWidth(815);
             table.setPrefHeight(234);
             
        inscrit.setVisible(true);
        personnel.setVisible(true);
         
        table1.setVisible(true);
          
          btn1.setVisible(false);
        BabysitterService ps1=BabysitterService.getInstance();
    adresse.setDisable(false);
    nom_club.setDisable(true);
        montant.setDisable(true);
cin.setDisable(false);
    num_tel.setDisable(false);
     Cnom_club.setVisible(false);
        Cadresse.setVisible(true);
       Cnum_tel.setVisible(true);
       Ccin.setVisible(true);
        Cnom.setVisible(true);
          Cprenom.setVisible(true);
           Cmontant.setVisible(false);
      Cnaissance.setVisible(true);
            Cnaissance1.setVisible(true);
     Cnom_club1.setVisible(false);
           Cmontant1.setVisible(false);

         table.setItems(null);
                table.setItems(ps1.getAll());
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Ccin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
                Cadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
Cnum_tel.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
 Cnaissance.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));

                      Cmontant1.setVisible(false);
                      

       
       //False les champs de saisie
       cin.setVisible(false);
       nom.setVisible(false);
       prenom.setVisible(false);
       pseudo.setVisible(false);
       mdp.setVisible(false);
       email.setVisible(false);
       adresse.setVisible(false);
       montant.setVisible(false);
       nom_club.setVisible(false);
       num_tel.setVisible(false);
       //les labels false
       Lcin.setVisible(false);
       Lnom.setVisible(false);
       Lprenom.setVisible(false);
       Lpseudo.setVisible(false);
       Lmdp.setVisible(false);
       Lemail.setVisible(false);
       Ladresse.setVisible(false);
       Lmontant.setVisible(false);
       Lnom_club.setVisible(false);
       Lnum_tel.setVisible(false);
       table1.setItems(null);
                table1.setItems(ps1.getAll2());
 Cid_user1.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Ccin1.setCellValueFactory(new PropertyValueFactory<>("cin"));
        Cnom1.setCellValueFactory(new PropertyValueFactory<>("nom"));
          Cprenom1.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Cpseudo1.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp1.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail1.setCellValueFactory(new PropertyValueFactory<>("email"));
                Cadresse1.setCellValueFactory(new PropertyValueFactory<>("adresse"));
Cnum_tel1.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
 Cnaissance1.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));
  
    }
    }
    @FXML
    public void ajouter()
    {/*if(Rparent.isSelected())
    {
 ParentService ps=new  ParentService();
         Parent p= new  Parent(Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),email.getText(),adresse.getText(),Float.parseFloat(montant.getText()));
        ps.insert(p);
        nom.clear();
        cin.clear();
        nom.clear();
        prenom.clear();
        pseudo.clear();
        mdp.clear();
        email.clear();
        adresse.clear();
        montant.clear();
        afficher();}
    else if(Renseignant.isSelected())
    { EnseignantService ps=new  EnseignantService();
         Enseignant p= new  Enseignant(Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),email.getText(),Float.parseFloat(montant.getText()),nom_club.getText());
        ps.insert(p);
        nom.clear();
        cin.clear();
        
        prenom.clear();
        pseudo.clear();
        mdp.clear();
        email.clear();
        adresse.clear();
        montant.clear();
        nom_club.clear();
        num_tel.clear();
        afficher();
    
    }*/
      if(RpropG.isSelected())
    { ProprietaireGService ps=new  ProprietaireGService();
        ProprietaireG p= new  ProprietaireG(pseudo.getText(),mdp.getText(),email.getText(),imgPath.getText());
        ps.insert(p);
        
        pseudo.clear();
        mdp.clear();
        email.clear();
        imgPath.clear();
        afficher();
    
    }
      else if(RpropJ.isSelected())
    { ProprietaireJService ps=new  ProprietaireJService();
        ProprietaireJ p= new  ProprietaireJ(pseudo.getText(),mdp.getText(),email.getText(),imgPath.getText());
        ps.insert(p);
        
        pseudo.clear();
        mdp.clear();
        email.clear();
        imgPath.clear();
        afficher();
    
    }
    }
    @FXML
    public void supprimer()
    {
        if(Rparent.isSelected())
    {
   
   TableView<Parent> table1=table;
     int i=table1.getSelectionModel().getSelectedItem().getId_user();
         System.out.println(i);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer ce parent");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
     ParentService ps=new ParentService();
        
      ps.delete(i);
      } afficher();}
     
      else if(Renseignant.isSelected())
    {
   
   TableView<Enseignant> table1=table;
     int i=table1.getSelectionModel().getSelectedItem().getId_user();
         System.out.println(i);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer ce parent");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
     EnseignantService ps=new EnseignantService();
        
      ps.delete(i);
      } afficher();}
        else if(RpropG.isSelected())
    {
        
   TableView<ProprietaireG> table1=table;
     int i=table1.getSelectionModel().getSelectedItem().getId_user();
         System.out.println(i);
         GarderieService gs=new GarderieService();
         Garderie g=gs.searchGard(i);
         EnfantService es=new EnfantService();
         Enfant e=null;
         e=es.searchGard(g.getId_garderie());
        
         es.delete(e.getId_enfant());
   
        //System.out.println(g);
   gs.delete(g.getId_garderie());
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer ce proprietaire");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
     ProprietaireGService ps=new ProprietaireGService();
        
      ps.delete(i);
      } afficher();}
        else if(RpropJ.isSelected())
    {
        
   TableView<ProprietaireJ> table1=table;
     int i=table1.getSelectionModel().getSelectedItem().getId_user();
         System.out.println(i);
         JardinEnfantService gs=new JardinEnfantService();
        JardinEnfant g=gs.searchGard(i);
         EnfantJService es=new EnfantJService();
         EnfantJ e=null;
         e=es.searchGard(g.getId_jardinEnfant());
        if(e!=null)
        {es.delete(e.getId_enfant());}
   
        //System.out.println(g);
   gs.delete(g.getId_jardinEnfant());
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer ce proprietaire");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
     ProprietaireJService ps=new ProprietaireJService();
        
      ps.delete(i);
      } afficher();}
        else if(Babysitter.isSelected())
    {
   
   TableView<Babysitter> table1=table;
     int i=table1.getSelectionModel().getSelectedItem().getId_user();
         System.out.println(i);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer ce babysitter");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
    BabysitterService ps=BabysitterService.getInstance();
    
      ps.delete(i);
      
      } afficher();}
    }
    @FXML
    public void modifier(){
        if(Rparent.isSelected())
    {
    TableView<Parent> table1=table;
     btn1.setDisable(false);
          id_user.setText(Integer.toString(table1.getSelectionModel().getSelectedItem().getId_user()));
          cin.setText(Integer.toString(table1.getSelectionModel().getSelectedItem().getCin()));
     nom.setText(table1.getSelectionModel().getSelectedItem().getNom());
     prenom.setText(table1.getSelectionModel().getSelectedItem().getPrenom());
     pseudo.setText(table1.getSelectionModel().getSelectedItem().getPseudo());
     mdp.setText(table1.getSelectionModel().getSelectedItem().getMdp());
     email.setText(table1.getSelectionModel().getSelectedItem().getEmail());
     montant.setText(Float.toString(table1.getSelectionModel().getSelectedItem().getMontant()));
     adresse.setText(table1.getSelectionModel().getSelectedItem().getAdresse());
     
    }
        else if(Renseignant.isSelected())
    {
    TableView<Enseignant> table1=table;
     btn1.setDisable(false);
          id_user.setText(Integer.toString(table1.getSelectionModel().getSelectedItem().getId_user()));
          cin.setText(Integer.toString(table1.getSelectionModel().getSelectedItem().getCin()));
     nom.setText(table1.getSelectionModel().getSelectedItem().getNom());
     prenom.setText(table1.getSelectionModel().getSelectedItem().getPrenom());
     pseudo.setText(table1.getSelectionModel().getSelectedItem().getPseudo());
     mdp.setText(table1.getSelectionModel().getSelectedItem().getMdp());
     email.setText(table1.getSelectionModel().getSelectedItem().getEmail());
     montant.setText(Float.toString(table1.getSelectionModel().getSelectedItem().getMontant()));
     nom_club.setText(table1.getSelectionModel().getSelectedItem().getNom_club());
    }else if(RpropG.isSelected())
    {
    TableView<ProprietaireG> table1=table;
     btn1.setDisable(false);
          id_user.setText(Integer.toString(table1.getSelectionModel().getSelectedItem().getId_user()));
         
     pseudo.setText(table1.getSelectionModel().getSelectedItem().getPseudo());
     mdp.setText(table1.getSelectionModel().getSelectedItem().getMdp());
     email.setText(table1.getSelectionModel().getSelectedItem().getEmail());
     
    }
        else if(RpropJ.isSelected())
    {
    TableView<ProprietaireJ> table1=table;
     btn1.setDisable(false);
          id_user.setText(Integer.toString(table1.getSelectionModel().getSelectedItem().getId_user()));
         
     pseudo.setText(table1.getSelectionModel().getSelectedItem().getPseudo());
     mdp.setText(table1.getSelectionModel().getSelectedItem().getMdp());
     email.setText(table1.getSelectionModel().getSelectedItem().getEmail());
     
    }
    
    }
    @FXML
     public void mod2()
     {if(Rparent.isSelected())
    {
     ParentService ps=new ParentService();
     Parent e=new Parent(Integer.parseInt(id_user.getText()),Integer.parseInt(cin.getText()),
     nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),email.getText(),adresse.getText(),Float.parseFloat(montant.getText()),num_tel.getText());
     ps.update(e);
     afficher();
            nom.clear();
        cin.clear();
        nom.clear();
        prenom.clear();
        pseudo.clear();
        mdp.clear();
        email.clear();
        adresse.clear();
        montant.clear(); }
      else if(Renseignant.isSelected()){
      EnseignantService ps=new EnseignantService();
     Enseignant e=new Enseignant(Integer.parseInt(id_user.getText()),Integer.parseInt(cin.getText()),
     nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),email.getText(),Float.parseFloat(montant.getText()),nom_club.getText());
     ps.update(e);
     afficher();
     nom.clear();
        cin.clear();
        nom.clear();
        prenom.clear();
        pseudo.clear();
        mdp.clear();
        email.clear();
        adresse.clear();
        montant.clear();
        nom_club.clear();
        num_tel.clear();
      }
     else if(RpropG.isSelected()){
      ProprietaireGService ps=new ProprietaireGService();
     ProprietaireG e=new ProprietaireG(Integer.parseInt(id_user.getText()),pseudo.getText(),mdp.getText(),email.getText());
     ps.update(e);
     afficher();
     
        pseudo.clear();
        mdp.clear();
        email.clear();
        
      }
      else if(RpropJ.isSelected()){
      ProprietaireJService ps=new ProprietaireJService();
     ProprietaireJ e=new ProprietaireJ(Integer.parseInt(id_user.getText()),pseudo.getText(),mdp.getText(),email.getText());
     ps.update(e);
     afficher();
     
        pseudo.clear();
        mdp.clear();
        email.clear();
        
      }
     
     
     }
     
    @FXML
    public void rechercher()
{if(Rparent.isSelected())
    {
Parent e=null;
String nom=entrer.getText();
 ParentService ps=new ParentService();


        table.setItems(null);
                table.setItems(ps.getAllByName(nom));
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Ccin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          
        Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
              Cadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
              Cmontant.setCellValueFactory(new PropertyValueFactory<>("montant"));
             Cnom_club.setVisible(false);
              Cnum_tel.setVisible(false);
                Cadresse.setVisible(true);}
if(Renseignant.isSelected())
    {
Enseignant e=null;
String nom=entrer.getText();
 EnseignantService ps=new EnseignantService();


        table.setItems(null);
                table.setItems(ps.getAllByName(nom));
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Ccin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
              Cmontant.setCellValueFactory(new PropertyValueFactory<>("montant"));
              Cnom_club.setCellValueFactory(new PropertyValueFactory<>("nom_club"));
        Cnom_club.setVisible(true);
        Cadresse.setVisible(false);
       Cnum_tel.setVisible(false);}

               if(entrer.getText().isEmpty()){
              afficher();
              }
               if(RpropG.isSelected())
    {
ProprietaireG e=null;
String nom=entrer.getText();
 ProprietaireGService ps=new ProprietaireGService();


        table.setItems(null);
                table.setItems(ps.getAllByName(nom));
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
             Cmontant.setVisible(false);
              Cnom_club.setVisible(false);
       Ccin.setVisible(false);
        Cnom.setVisible(false);
          Cprenom.setVisible(false);
           
        Cadresse.setVisible(false);
       Cnum_tel.setVisible(false);}

               if(entrer.getText().isEmpty()){
              afficher();
              }
               if(RpropJ.isSelected())
    {
ProprietaireJ e=null;
String nom=entrer.getText();
 ProprietaireJService ps=new ProprietaireJService();


        table.setItems(null);
                table.setItems(ps.getAllByName(nom));
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
             Cmontant.setVisible(false);
              Cnom_club.setVisible(false);
       Ccin.setVisible(false);
        Cnom.setVisible(false);
          Cprenom.setVisible(false);
           
        Cadresse.setVisible(false);
       Cnum_tel.setVisible(false);}

               if(entrer.getText().isEmpty()){
              afficher();
              }
if(Babysitter.isSelected())
    {
Babysitter e=null;
String nom=entrer.getText();
 BabysitterService ps2=BabysitterService.getInstance();


        table.setItems(null);
                table.setItems(ps2.getbyPseudo1(nom));
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Ccin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
                Cadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        Cnom_club.setVisible(true);
        Cadresse.setVisible(false);
       Cnum_tel.setVisible(false);}

               if(entrer.getText().isEmpty()){
              afficher();
              }}

   

    @FXML
    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilAdmin.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    public void actionBrowser(ActionEvent event) throws MalformedURLException{  
        String imageFile;
      
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);
            Image image1 = new Image(imageFile);
           // imgV.setImage(image1);
            imgPath.setText(imageFile);
        } else {
            System.out.println("file doesn't exist");
        }
     
    }

     @FXML
    private void afficherImage2(MouseEvent event) {
        //Checking double click
         if (event.getClickCount() == 1) //Checking double click
       {
                TableView<Babysitter> table2=table;
        imgv1.setImage(null);
        String imageFile1 = table2.getSelectionModel().getSelectedItem().getImage();
                String type= table2.getSelectionModel().getSelectedItem().getType();
        String date = table2.getSelectionModel().getSelectedItem().getDate_naissance();
        String nom = table2.getSelectionModel().getSelectedItem().getNom();
                String prenom = table2.getSelectionModel().getSelectedItem().getPrenom();
               
                


         Image image1 = new Image(imageFile1);
         imgv1.setImage(image1);
                     label.setVisible(true);

         label.setText(nom+" "+prenom+"\n"+date+"\n"+"Role:"+type);
         
         }
    }

    @FXML
    private void afficherImage1(MouseEvent event) {
         if (event.getClickCount() == 1) //Checking double click
       {
            imgv1.setImage(null);
           
            String imageFile = table1.getSelectionModel().getSelectedItem().getImage(); 
              String type= table1.getSelectionModel().getSelectedItem().getType();
        String date = table1.getSelectionModel().getSelectedItem().getDate_naissance();
        String nom = table1.getSelectionModel().getSelectedItem().getNom();
                String prenom = table1.getSelectionModel().getSelectedItem().getPrenom();
               

                Image image1 = new Image(imageFile);
            imgv1.setImage(image1);
            label.setVisible(true);
                     label.setText(nom+" "+prenom+"\n"+date+"\n"+"Role:"+type);

      }
    }}


    

              

  

