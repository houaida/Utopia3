/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import static allforkids.GUI.AuthentificationController.LoggedParent;
import allforkids.entite.Babysitter;
import allforkids.entite.Enfant;
import allforkids.entite.EnfantJ;
import allforkids.entite.Enseignant;
import allforkids.entite.Garderie;
import allforkids.entite.Parent;
import allforkids.service.BabysitterService;
import allforkids.service.EnfantService;
import allforkids.service.EnseignantService;
import allforkids.service.GarderieService;
import allforkids.service.ParentService;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class InscriptionUserController implements Initializable {
     @FXML
private AnchorPane AnchorPane1;
    @FXML
    private RadioButton Renseignant;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton Rparent;
    @FXML
    private RadioButton Rbabysitter;
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
    private TextField club;
    @FXML
    private TextField cin;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField pseudo;
    @FXML
    private PasswordField mdp;
    @FXML
    private TextField email;
    @FXML
    private TextField adresse;
    @FXML
    private TextField montant;
    @FXML
    private TextField num_tel;
    
  
    @FXML
    private TextField prenom_enfant;
   
    @FXML
    private TextField nom_enfant;
   
    @FXML
    private Label Lnum_tel1;
    @FXML
    private Label Lnum_tel2;
    @FXML
    private Label Lnum_tel3;
    @FXML
    private Label Lnum_tel4;
    @FXML

    private Label Lnum_tel11;
    @FXML
    private Label Lnum_tel12;
    @FXML
    private RadioButton Rgarderie;
    @FXML
    private ToggleGroup etude;
    @FXML
    private RadioButton Rjardin;
     public static EnfantJ LoggedEnfantJ;
     public static Enfant LoggedEnfant;
      public static Parent LoggedParent;
    @FXML
    private AnchorPane an2;
    @FXML
    private AnchorPane an3;
    @FXML
    private Button btV;
    @FXML
    private Button btP;
    private Label Lmdp1;
    @FXML
    private Label Lcin1;
    @FXML
    private DatePicker naissance;
    @FXML
    private TextField imgPath;
    @FXML
    private ImageView imgV;
    @FXML
    private TextField path;
    @FXML
    private Button btBrowse;
    @FXML
    private Label lbimage;
@FXML
     private ComboBox<Integer> comBox3 ; 
    @FXML
    private Label alertCIn;
    @FXML
    private Label alertNum;
    @FXML
    private TextField mdpT;
    @FXML
    private ToggleButton lu;
    @FXML
    private ToggleButton cache;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
            // TODO
            ObservableList<Integer> ol3 = FXCollections.observableArrayList();
        ol3.add(1) ; 
        ol3.add(2) ; 
        ol3.add(3) ; 
        ol3.add(4) ; 
        ol3.add(5) ;
         ol3.add(6) ;
          ol3.add(7) ;
           ol3.add(8) ;
            ol3.add(9) ;
             ol3.add(10) ;
              ol3.add(11) ;
               ol3.add(12) ;
                ol3.add(13) ;
                 ol3.add(14) ;
        comBox3.setItems(ol3);
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
    ToggleGroup etude = new ToggleGroup();
    RadioButton Rgarderie = new RadioButton("select first");
   Rgarderie.setToggleGroup(etude);
   //Rgarderie.setSelected(true);
    RadioButton Rjardin = new RadioButton("select second");
    Rjardin.setToggleGroup(etude);
    etude.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
         @Override
    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
ToggleGroup etude = new ToggleGroup();
         if (etude.getSelectedToggle() != null) {

             System.out.println(etude.getSelectedToggle().getUserData().toString());
             // Do something here with the userData of newly selected radioButton

         }

     } 
});
    }    
     @FXML
    public void afficher() {
     if(Rparent.isSelected()){
         path.setVisible(true);
         btBrowse.setVisible(true);
         lbimage.setVisible(true);
         imgV.setVisible(false);
      imgPath.setDisable(false);
    naissance.setDisable(true);
    num_tel.setDisable(false);
      club.setDisable(true);
      montant.setDisable(false);
     comBox3.setDisable(false);
     prenom_enfant.setDisable(false);
     nom_enfant.setDisable(false);
    an2.setVisible(true);
    an3.setVisible(true);
     btV.setVisible(false);
      btP.setVisible(true);
       cin.clear();
      nom.clear();
      prenom.clear();
      pseudo.clear();
      mdp.clear();
      adresse.clear();
      email.clear();
      montant.clear();
      alertCIn.setText(" ");
       alertNum.setText(" ");
      
     
     }
     
     if(Renseignant.isSelected())
    {imgPath.setDisable(false);
    naissance.setDisable(true);
     num_tel.setDisable(true);
        club.setDisable(false);
        montant.setDisable(false);
        comBox3.setDisable(true);
     prenom_enfant.setDisable(true);
     nom_enfant.setDisable(true);
         an2.setVisible(false);
    an3.setVisible(false);
    btV.setVisible(true);
     btP.setVisible(false);
     alertCIn.setText(" ");
       alertNum.setText(" ");
    
    }
      if(Rbabysitter.isSelected()){
          imgPath.setDisable(false);
    naissance.setDisable(false);
        montant.setDisable(true);
     num_tel.setDisable(false);
      club.setDisable(true);
      comBox3.setDisable(true);
     prenom_enfant.setDisable(true);
     nom_enfant.setDisable(true);
      an2.setVisible(false);
    an3.setVisible(false);
     btV.setVisible(true);
      btP.setVisible(false);
      alertCIn.setText(" ");
       alertNum.setText(" ");
      }
      
    }
    @FXML
    public void inscrire() 
    {
        
     if(Renseignant.isSelected()){
         
         EnseignantService es=new EnseignantService();
         Enseignant e=null;
         Enseignant p4=null;
         e=es.findbyMail(email.getText());
         p4=es.getbyPseudo(pseudo.getText());
        if((controMail(email.getText()))&&(e==null)&&(p4==null)){
            if(mdp.isVisible()){
              Enseignant p=new Enseignant (Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),
      email.getText(),Float.parseFloat(montant.getText()),club.getText(),imgPath.getText());
      EnseignantService ps= new EnseignantService();
      ps.insert(p);
      cin.clear();
      nom.clear();
      prenom.clear();
      pseudo.clear();
      mdp.clear();
     adresse.clear();
      email.clear();
      club.clear();
      num_tel.clear();
      alertCIn.setText(" ");
       alertNum.setText(" ");
       num_tel.setDisable(false);
       afficher();}
            else if(mdpT.isVisible()){
             Enseignant p=new Enseignant (Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdpT.getText(),
      email.getText(),Float.parseFloat(montant.getText()),club.getText(),imgPath.getText());
      EnseignantService ps= new EnseignantService();
      ps.insert(p);
      cin.clear();
      nom.clear();
      prenom.clear();
      pseudo.clear();
      mdp.clear();
     adresse.clear();
      email.clear();
      club.clear();
      num_tel.clear();
      alertCIn.setText(" ");
       alertNum.setText(" ");
       num_tel.setDisable(false);
       afficher();
            
            }
        }
         else{
             if (((p4!=null)&&(!controMail(email.getText())))||((p4!=null)&&(e!=null))){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Pseudo");
            alert.setHeaderText("Pseudo et email invalides");
            Optional<ButtonType> result = alert.showAndWait();
            pseudo.clear();
            email.clear();
            
            }
             else if((!controMail(email.getText()))||(e!=null)){Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Email");
            alert.setHeaderText("Email invalide");
            email.clear();
           Optional<ButtonType> result = alert.showAndWait();
        }
             else if (p4!=null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Pseudo");
            alert.setHeaderText("Pseudo déjà trouvé");
            Optional<ButtonType> result = alert.showAndWait();
            pseudo.clear();
            }
           
        }
        }
    
    if(Rbabysitter.isSelected()){
       
       if(mdp.isVisible()){
      Babysitter p=new Babysitter(Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),
      email.getText(),adresse.getText(),num_tel.getText(),naissance.getEditor().getText(),imgPath.getText());
      BabysitterService ps= new BabysitterService();
      ps.insert(p);
      cin.clear();
      nom.clear();
      prenom.clear();
      pseudo.clear();
      mdp.clear();
     adresse.clear();
      email.clear();
      club.clear();
      num_tel.clear();
      imgPath.clear();
      alertCIn.setText(" ");
       alertNum.setText(" ");
      club.setDisable(false);
      afficher();
             }
    else if(mdpT.isVisible()){
        Babysitter p=new Babysitter(Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdpT.getText(),
      email.getText(),adresse.getText(),num_tel.getText(),naissance.getEditor().getText(),imgPath.getText());
      BabysitterService ps= new BabysitterService();
      ps.insert(p);
      cin.clear();
      nom.clear();
      prenom.clear();
      pseudo.clear();
      mdp.clear();
     adresse.clear();
      email.clear();
      club.clear();
      num_tel.clear();
      imgPath.clear();
      alertCIn.setText(" ");
       alertNum.setText(" ");
      club.setDisable(false);
      afficher();
    }}
    
    }

    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML

    private void listegarderie(ActionEvent event) throws IOException {
       if(Rgarderie.isSelected()){
        if(comBox3.getValue()<5){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Age");
            alert.setHeaderText("votre enfant est trop petit pour s'inscrire à une garderie");
            Optional<ButtonType> result = alert.showAndWait();
           comBox3.setValue(null);
        }else{
        LoggedEnfant = new Enfant();
       
        LoggedEnfant.setNom(nom_enfant.getText());
        LoggedEnfant.setPrenom(prenom_enfant.getText());
        LoggedEnfant.setAge(comBox3.getValue()); 
        LoggedEnfant.setImage(path.getText()); 
        System.out.println(LoggedEnfant.getNom());
        System.out.println("enfant"+LoggedEnfant.getImage());
      
         
      LoggedParent = new Parent();
        LoggedParent.setCin(Integer.parseInt(cin.getText()));
        LoggedParent.setImage(imgPath.getText());
        LoggedParent.setNom(nom.getText());
        LoggedParent.setPrenom(prenom.getText());
         LoggedParent.setPseudo(pseudo.getText());
         if(mdp.isVisible()){
          LoggedParent.setMdp(mdp.getText());}else if (mdpT.isVisible()){ LoggedParent.setMdp(mdpT.getText());}
          LoggedParent.setNum_tel(num_tel.getText());
           LoggedParent.setEmail(email.getText());
        LoggedParent.setMontant(Float.parseFloat(montant.getText())); 
         LoggedParent.setAdresse(adresse.getText());
        System.out.println(LoggedParent.getNom());
        ParentService es=new ParentService();
         Parent e=null;
         Parent p4=null;
         e=es.findbyMail(email.getText());
         p4=es.getbyPseudo(pseudo.getText());
        if((controMail(email.getText()))&&(e==null)&&(p4==null)){
           if(mdp.isVisible()){
        Parent p=new Parent(Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),
      email.getText(),adresse.getText(),Float.parseFloat(montant.getText()),imgPath.getText(),num_tel.getText());
      ParentService ps= new ParentService();
      ps.insert(p);
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeGardJard.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);}
           else if(mdpT.isVisible()){
           Parent p=new Parent(Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdpT.getText(),
      email.getText(),adresse.getText(),Float.parseFloat(montant.getText()),imgPath.getText(),num_tel.getText());
      ParentService ps= new ParentService();
      ps.insert(p);
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeGardJard.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
           }
        
        }else{
           
             if (((p4!=null)&&(!controMail(email.getText())))||((p4!=null)&&(e!=null))){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Pseudo");
            alert.setHeaderText("Pseudo et email invalides");
            Optional<ButtonType> result = alert.showAndWait();
            pseudo.clear();
            email.clear();
            
            }
             else if((!controMail(email.getText()))||(e!=null)){Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Email");
            alert.setHeaderText("Email invalide");
            email.clear();
           Optional<ButtonType> result = alert.showAndWait();
        }
             else if (p4!=null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Pseudo");
            alert.setHeaderText("Pseudo déjà trouvé");
            Optional<ButtonType> result = alert.showAndWait();
            pseudo.clear();
            }
           
        }}}
       else if(Rjardin.isSelected()){
        if(comBox3.getValue()>5){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Age");
            alert.setHeaderText("votre enfant est grand pour s'inscrire à un jardin d'enfant");
            Optional<ButtonType> result = alert.showAndWait();
           comBox3.setValue(null);
        }else{
        LoggedEnfantJ = new EnfantJ();
       
        LoggedEnfantJ.setNom(nom_enfant.getText());
        LoggedEnfantJ.setPrenom(prenom_enfant.getText());
        LoggedEnfantJ.setAge(comBox3.getValue()); 
        LoggedEnfantJ.setImage(path.getText()); 
        System.out.println(LoggedEnfantJ.getNom());
        System.out.println(LoggedEnfantJ.getImage());
      
         
      LoggedParent = new Parent();
        LoggedParent.setCin(Integer.parseInt(cin.getText()));
        LoggedParent.setImage(imgPath.getText());
        LoggedParent.setNom(nom.getText());
        LoggedParent.setPrenom(prenom.getText());
         LoggedParent.setPseudo(pseudo.getText());
         if(mdp.isVisible()){
          LoggedParent.setMdp(mdp.getText());}else if (mdpT.isVisible()){ LoggedParent.setMdp(mdpT.getText());}
           LoggedParent.setEmail(email.getText());
        LoggedParent.setMontant(Float.parseFloat(montant.getText())); 
         LoggedParent.setAdresse(adresse.getText());
        System.out.println(LoggedParent.getNom());
        ParentService es=new ParentService();
         Parent e=null;
         Parent p4=null;
         e=es.findbyMail(email.getText());
         p4=es.getbyPseudo(pseudo.getText());
        if((controMail(email.getText()))&&(e==null)&&(p4==null)){
           if(mdp.isVisible()){
        Parent p=new Parent(Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),
      email.getText(),adresse.getText(),Float.parseFloat(montant.getText()),imgPath.getText(),num_tel.getText());
      ParentService ps= new ParentService();
      ps.insert(p);
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeJardin.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);}
           else if(mdpT.isVisible()){
            Parent p=new Parent(Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdpT.getText(),
      email.getText(),adresse.getText(),Float.parseFloat(montant.getText()),imgPath.getText(),num_tel.getText());
      ParentService ps= new ParentService();
      ps.insert(p);
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeJardin.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
           }
        }else{
           
             if (((p4!=null)&&(!controMail(email.getText())))||((p4!=null)&&(e!=null))){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Pseudo");
            alert.setHeaderText("Pseudo et email invalides");
            Optional<ButtonType> result = alert.showAndWait();
            pseudo.clear();
            email.clear();
            
            }
             else if((!controMail(email.getText()))||(e!=null)){Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Email");
            alert.setHeaderText("Email invalide");
            email.clear();
           Optional<ButtonType> result = alert.showAndWait();
        }
             else if (p4!=null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Pseudo");
            alert.setHeaderText("Pseudo déjà trouvé");
            Optional<ButtonType> result = alert.showAndWait();
            pseudo.clear();
            }
              if(!controlCIN(Integer.parseInt(cin.getText()))){
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Carte d'identité");
            alert.setHeaderText("CIN invalide");
            Optional<ButtonType> result = alert.showAndWait();
            cin.clear();
             }
           
        
        
    }}
    
    }}

 @FXML
    public void actionBrowser(ActionEvent event) throws MalformedURLException{  
        String imageFile;
      
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);
            Image image1 = new Image(imageFile);
            imgV.setImage(image1);
            imgPath.setText(imageFile);
        } else {
            System.out.println("file doesn't exist");
        }
     
        
        }
    @FXML
    public void actionBrowser2(ActionEvent event) throws MalformedURLException{  
        String imageFile;
      
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);
            Image image1 = new Image(imageFile);
            imgV.setImage(image1);
            path.setText(imageFile);
        } else {
            System.out.println("file doesn't exist");
        }
     
        
        }
     @FXML
    public void controlCINPress(){
        
        if((cin.getText()).length()!=8){
        alertCIn.setText("CIN invalide");
        alertCIn.setTextFill(Color.RED);
        }
        else {alertCIn.setTextFill(Color.GREEN);
            alertCIn.setText("CIN valide");
        }
        }
    @FXML
    public void controlNUMPress(){
        
        if((num_tel.getText()).length()!=8){
            alertNum.setTextFill(Color.RED);
        alertNum.setText("numero invalide");
        
        }
        else{  alertNum.setTextFill(Color.GREEN);
            alertNum.setText("numero valide");
       }
        }
    
        public boolean controlCIN(int cin){
        String chaine=Integer.toString(cin);
        if(chaine.length()!=8){
        return false;
        }else return true;
        }
    
    public boolean controMail(String mail){
String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
Pattern pattern = Pattern.compile(masque);
Matcher controler = pattern.matcher(mail);
if (controler.matches()){
return true;
 
}else{
return false;
}

}

    @FXML
    private void lirePass(ActionEvent event) {
        mdpT.setText(mdp.getText());
        mdp.setVisible(false);
        mdpT.setVisible(true);
        lu.setVisible(false);
        cache.setVisible(true);
    }
     @FXML
    private void CacherPass(ActionEvent event) {
        mdp.setText(mdpT.getText());
        mdp.setVisible(true);
        mdpT.setVisible(false);
        cache.setVisible(false);
        lu.setVisible(true);
    }

}

    
    

