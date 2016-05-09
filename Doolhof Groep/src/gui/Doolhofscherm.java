/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;

/**
 *
 * @author xendacine
 */
public class Doolhofscherm extends VBox 
{
    private DomeinController dc;
    private Label lblUitleg, lblKosten;
    private TextArea txaUitleg;
    private TextField txfKosten;
    private ComboBox cboDoolhofscherm;
    private ComboBox cboSelecteerTaal;
    
    public Doolhofscherm(DomeinController dc)
    {
        this.dc = dc;
        buildGui();
    } /** Default constructor die DC aanmaakt en de Buildgui aanroept voor ons doolhofscherm**/
    
    private void buildGui()
    {
        cboDoolhofscherm = new ComboBox();
        cboSelecteerTaal = new ComboBox();
        lblUitleg = new Label("Uitleg:");
        lblKosten = new Label("Kosten:");
        txaUitleg = new TextArea();
        txfKosten = new TextField();
//        String[] talen = dc.kiesTaal();
//        cboSelecteerTaal.setItems(null);
        String[] titels = dc.laadBestaandSpel();    // halloa spelletjes halen hier 
        cboDoolhofscherm.setItems(FXCollections.observableList(Arrays.asList(titels))) ;
        cboDoolhofscherm.setPromptText("Kies een spel uit de lijst");
        
        //eventhandler koppelen aan de combobox
        cboDoolhofscherm.setOnAction
        (
                        //hier komt de event handler!!! anonieme classe xD
                new EventHandler<ActionEvent>()
                        {
                            @Override
                            public void handle(ActionEvent event)
                            {
                                int index = cboDoolhofscherm.getSelectionModel().getSelectedIndex();
                                update(index);
                            }
                        }
        
        );
        
        txaUitleg.setEditable(false);
        txfKosten.setEditable(false);
        
        
        this.getChildren().addAll(cboDoolhofscherm, lblUitleg, txaUitleg, lblKosten, txfKosten);
        
            
                
             
    } /** Meer uitgebreide buildgui voor dit scherm, met selecteerbare elementen en al dan niet editbare velden,
     * dit is ook gelinkt aan de eventhandling klasse in gui**/
    
    public void update(int index)
    {
        String details = "Test-Uitvoer";
        double waarde = 5; //tijdelijke waarde vanuit oefeningen geïnspireerd.
        txaUitleg.setText(details); //dit veld txaUitleg moet weg en vervangen worden door iets nuttigs, want we hebben geen waardes
        txfKosten.setText(String.format("De kost bedraagt %.2f", waarde)); // zelfde uitleg als vorige lijn 
    } /** Kijkt of je bepaalde velden kan updaten, indien dit werkt gaat ook effectief updaten van de velden**/

    
}
