/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author xendacine
 */
public class StartUpGui extends Application {
    
    @Override
    public void start(Stage primaryStage)
    {
        HoofdPaneel hoofd = new HoofdPaneel(new DomeinController());
        Scene scene = new Scene(hoofd, 500,500);
        
        primaryStage.setTitle("Doolhofapp");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
//    public void start(Stage primaryStage) {
//        Doolhofscherm scherm = 
//                new Doolhofscherm(new DomeinController());
// 
//        Scene scene = new Scene(scherm, 400, 300);
//        
//        primaryStage.setTitle("DoolhofScherm");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
