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
 * @author xendacine
 */
public class UC5 {
    private final DomeinController dc;
    private final DoolhofApp app;
    private Taal taal;
    ResourceBundle tekst;   
    private final Scanner scanner;
    private int aantalSpelers;
    private String naam;
    private String kleur;
    private int geboortejaar;
    private int huidigeSpeler;    
    public UC5(DomeinController dc,DoolhofApp app,Taal taal)
    {
        this.scanner = new Scanner(System.in);
        this.dc = dc;
        this.app = app;
        this.taal = taal;
        
    }/** Initialisatie van de Domeincontroller in UC5**/
    public void speelBeurt(int huidigeSpeler)
    {
        
    }/** hier komt het vervolg op de huidige speler en zijn te spelen beurt **/
}
