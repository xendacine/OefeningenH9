/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

/**
 *
 * @author xendacine
 */
public class EventHandling implements EventHandler<ActionEvent>
{
    private Doolhofscherm scherm;
    
    public EventHandling(Doolhofscherm scherm)
    {
        this.scherm = scherm;
    }

    EventHandling() {
        System.out.println("juuuuu");
    }
    

    @Override
    public void handle(ActionEvent event) 
    {
        ComboBox box = (ComboBox) event.getSource();
        int index = box.getSelectionModel().getSelectedIndex();
        
        
        
    }
    
}
