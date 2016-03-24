/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import java.util.Arrays;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

/**
 *
 * @author xendacine
 */
public class OverzichtPaneel extends VBox
{
    private DomeinController dc;
    private DetailPaneel details;
    private ListView<String> lijst;
    
    public OverzichtPaneel(DomeinController dc, DetailPaneel details)
    {
        this.dc = dc;
        this.details = details;
        buildGui();
    }
    
    private void buildGui()
    {
        lijst = new ListView<>();
        String[] alleSpelen = dc.laadBestaandSpel();
        lijst.setItems(FXCollections.observableList(Arrays.asList(alleSpelen)));
        
        lijst.getSelectionModel().selectedIndexProperty().addListener
        (
            new ChangeListener()    //event handling voor change event
            {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) 
            {
                int index = (int) newValue;
                
                String[] info = dc.getSpelers(index);
                details.update(info);
            }

            }
        );
        this.getChildren().addAll(new Label("Overzicht:"), lijst);
        this.setPadding(new Insets(25,5,25,5));
        this.setSpacing(10);
    }
}
