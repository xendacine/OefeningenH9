/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import domein.Speler;
import domein.Taal;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author xendacine
 */
public class UC3 {
    private final DomeinController dc;
    private final DoolhofApp app;
    private Taal taal;
    ResourceBundle tekst;   
    private final Scanner scanner;
    private int aantalSpelers;
    private String naam;
    private String kleur;
    private int geboortejaar;
    private Speler speler;
    private int beurt1;
    public UC3(DomeinController dc,DoolhofApp app,Taal taal)
    {
        this.scanner = new Scanner(System.in);
        this.dc = dc;
        this.app = app;
        this.taal = taal;
        
    }
    
    public void speelSpel(int beurt){
           beurt1 = beurt;
          app.uc4.speelBeurt(beurt1);
          System.out.println("beurt gespeeld");
          Speler huidigeSpeler = dc.bepaalSpelerAanBeurt(beurt);
          if(huidigeSpeler.getDoelkaarten().isEmpty()){
              System.out.println("De winnaar is : "+ huidigeSpeler.getSpelernaam());
          }
          else{
          beurt1++;
          
          dc.bepaalSpelerAanBeurt(beurt1);
          System.out.println("Wilt u het spel bewaren?");
          String antw= scanner.next();
           if("ja".equals(antw) || "yes".equals(antw) || "oui".equals(antw)){
              app.uc6.bewaarSpel();
          }
          else{
              System.out.println("De volgende speler is: "+dc.geefHuidigeSpeler(beurt1));
              speelSpel(beurt1); 
          }
          }
      }
}
