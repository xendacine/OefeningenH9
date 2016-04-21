/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author xendacine
 */

public class WelkomController extends VBox
{
@FXML
private TextField txfInvoer;
@FXML
private Button btnEng;
@FXML
private Button btnFr;
@FXML
private Button btnNl;
@FXML
private TextArea txaUitvoer1;
@FXML
private TextArea txaUitvoer2;

public WelkomController()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Oef5.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try 
        {
            loader.load();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Scherm kan niet geladen worden");
            throw new RuntimeException();
        }
    }
}

