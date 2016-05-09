/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import domein.Taal;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sven V
 */
public class StartUpGui extends Application {
    
    @Override
    public void start(Stage primaryStage) {
                DomeinController dc = new DomeinController();
                Taal taal = new Taal();
                DoolhofApp app = new DoolhofApp(dc,taal);
    } /** Dit start de console versie om een of andere reden**/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
