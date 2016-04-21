/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author xendacine
 */
public class DetailPaneel extends GridPane
{
    private DomeinController dc;
    private TextField txfSpelernaam, txfSpeler2, txfSpeler3, txfSpeler4;
    
    public DetailPaneel(DomeinController dc)
    {
        this.dc = dc;
        buildGui();
    }
    
    private void buildGui()
    {
        
        txfSpelernaam = new TextField();
        txfSpeler2 = new TextField();
        txfSpeler3 = new TextField();
        txfSpelernaam.setEditable(false);
        txfSpeler2.setEditable(false);
        txfSpeler3.setEditable(false);
//        txfSpeler4.setEditable(false);
        this.add(new Label("Details"),0,0,1,1);
        this.add(new Label("SpelerScore: "), 0, 1);
        this.add(txfSpelernaam, 1,1);
        this.add(new Label("naam2"), 0,2);
        this.add(txfSpeler2, 1, 2);
        
        
        this.setPadding(new Insets(25,5,25,5));
        this.setVgap(20);
        this.setHgap(5);
    }
    public void update(String[] info)
    {
        txfSpelernaam.setText("hey");
//        txfSpeler2.setText(info[1]);
//        txfSpeler3.setText(info[2]);
    }
}
