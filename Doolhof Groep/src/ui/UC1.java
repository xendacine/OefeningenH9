/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import domein.Taal;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;
import ui.UC2;
/**
 *
 * @author Sven V
 */
public class UC1 {
    private final DomeinController dc;
    private final DoolhofApp app;
     private Taal taal;
     ResourceBundle tekst;   
     private final Scanner scanner;
    private String[] spellen;
    private String[] spelers;
    
    
     public UC1(DomeinController dc,DoolhofApp app, Taal taal)
    {
        this.scanner = new Scanner(System.in);
        this.dc = dc;
        this.app = app;
        this.taal = taal;
        
        
    } /** Initialisatie van de Domeincontroller in UC1**/
     
     public void startSpel(){
        int keuze;
         
         
            keuze = geefKeuze();
            switch (keuze) {
                case 1:
                    app.uc2.startNieuwSpel();
                    break;
                case 2:
                   laadBestaandSpel();
                    break;
                case 3:
                    System.exit(0);
           }
            
   
     }/** Maken en gebruiken van de methode startspel, die toelaat om het spel te starten **/
     
     
   private int geefKeuze() {
        int ingave;

        try {
            System.out.println(taal.getTekst().getString("doolhof"));
           
            System.out.println(taal.getTekst().getString("startNieuwSpel"));
            System.out.println(taal.getTekst().getString("startBestaandSpel"));
            System.out.println(taal.getTekst().getString("stop2"));

           
            ingave = scanner.nextInt();
        } catch (InputMismatchException ie) {
            ingave = 0;
            scanner.nextLine();
        }
        return ingave;
   } /** Laat toe om keuze te maken tussen het laden van een bestaand spel, maken van een nieuw spel of stoppen met deze loop **/
      
 
  
  public String laadBestaandSpel(){
        

        spellen = dc.laadBestaandSpel();
        String gekozen;
        if (spellen.length == 0) {
            System.out.println(taal.getTekst().getString("geenGames"));
            gekozen = "geen";
        } else {
            System.out.println(taal.getTekst().getString("mogelijkeGames"));
            for (int i = 0; i < spellen.length; i++) {
                int count = i + 1;
                System.out.println(count + ". " + spellen[i]);

            }
            gekozen = keuzeSpel(spellen);
        }
        return gekozen;
    } /** Laad een bestaand spel in **/
  
  public String keuzeSpel(String[] spellen) {
      
        System.out.println(taal.getTekst().getString("kiesSpel") + spellen.length);
        int spelID;
        
        String gekozen = null;
        spelID = scanner.nextInt();
        if (spelID >= 1 && spelID <= spellen.length) {
            gekozen = spellen[spelID - 1];

        } else {
            keuzeSpel(spellen);
        }
        geefSpelers(spelID);
        return gekozen;
    } /** kiest een spel, met gekozen lengte van aantal spelers, **/
  
  public void geefSpelers(int spelID){
        spelers = dc.getSpelers(spelID);
 
        if (spelers.length == 0) {
            System.out.println(taal.getTekst().getString("geenSpelers"));
            
        } else {
            System.out.println(taal.getTekst().getString("spelers"));
            for (int i = 0; i < spelers.length; i++) {
                int count = i + 1;
                System.out.println(count + ". " + spelers[i]);

            }
           
    }
  }/** Geeft de spelers terug van een spel, dankzij de argumenten SpelId**/
  
  
  
  
    
}
