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
    } /** Maakt gewoon een default scherm aan**/

    EventHandling() {
        System.out.println("Event-Handling test Message Class gui.Eventhandling.java");
    } /** Test van de eventhandling met een specifiek bericht om te zien of hij de juiste klasse aanroept.**/
    

    @Override
    public void handle(ActionEvent event) 
    {
        ComboBox box = (ComboBox) event.getSource();
        int index = box.getSelectionModel().getSelectedIndex();
        
        
        
    } /** Maakt de combobox aan en laat toe om een bepaald vakje te selecteren om zo een juiste spel te selecteren gebaseerd 
     * op het hoeveelste element of index je gekozen had, 
     * dit wordt doorgegeven aan geefSpel(int spelID) waarbij spelID = index **/
    
}
