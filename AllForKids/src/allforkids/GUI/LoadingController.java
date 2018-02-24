/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class LoadingController implements Initializable {

   
    @FXML
    private AnchorPane splashAnchorPane;

    allforkids su;
    Stage stage;

    public void main(allforkids su, Stage stage) {
        this.su = su;
        this.stage = stage;
    }

    private Screen screen = Screen.getPrimary();
    private Rectangle2D windows = screen.getVisualBounds();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new splash().start();

    }

    class splash extends Thread {

        @Override
        public void run() {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    FadeTransition fadeout = new FadeTransition(Duration.seconds(5), splashAnchorPane);
                    fadeout.setFromValue(1);
                    fadeout.setToValue(0);
                    fadeout.setCycleCount(1);
                    fadeout.play();

                    fadeout.setOnFinished(e -> {
                        try {
                            allforkids.window.close();

                            Stage stage = new Stage();
                            Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
                            Scene scene = new Scene(root);

                           /* stage.initStyle(StageStyle.UNDECORATED);
                            stage.setX(windows.getMinX());
                            stage.setY(windows.getMinY());
                            stage.setWidth(windows.getWidth());
                            stage.setHeight(windows.getHeight());*/

                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException ex) {
                            Logger.getLogger(LoadingController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    });
                }

            });
        }
    }

}
