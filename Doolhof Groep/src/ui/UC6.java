/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import domein.Taal;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Sven V
 */
public class UC6 {
    private final DomeinController dc;
     private final DoolhofApp app;
     private Taal taal;
     ResourceBundle tekst;   
     private final Scanner scanner;
    
    
    public UC6(DomeinController dc,DoolhofApp app,Taal taal)
    {
        this.scanner = new Scanner(System.in);
        this.dc = dc;
        this.app = app;
        this.taal = taal;
        
    }/** Initialisatie van de Domeincontroller in UC6**/
    
    public void bewaarSpel(){
        System.out.println("Geef een naam voor het spel:");
         String spelnaam = scanner.next();
        //if(spelnaam= 8)  {
            
     //   }      
    } /** Hier wordt de lokale versie van het spel (al dan niet met gespeelde beurten) opgeslaan in de externe databank voor verder gebruik.**/
}
