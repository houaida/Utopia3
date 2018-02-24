/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Enfant;
import allforkids.service.EnfantService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class InscriptionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tfId;
@FXML
    private TextField tfNom;
@FXML
    private TextField tfPrenom;
@FXML
    private TextField tfAge;
    @FXML
    private Button btretour;
    @FXML
    private AnchorPane AnchorPane1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void inscrire(){
    EnfantService ps=new EnfantService();
        Enfant p= new Enfant(Integer.parseInt(tfId.getText()),tfNom.getText(),tfPrenom.getText(),Integer.parseInt(tfAge.getText()));
        ps.insert(p);
        tfNom.clear();
        tfPrenom.clear();
    }

    private void retour(MouseEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeGardJard.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    
}
