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
import domein.*;

/**
 *
 * @author xendacine
 */
public class UC4 {
    private final DomeinController dc;
    private final DoolhofApp app;
    private Taal taal;
    ResourceBundle tekst;  
    private Spelbord spelbord;
    private final Scanner scanner;
    private int aantalSpelers;
    private String naam;
    private String kleur;
    private int geboortejaar;
    private int huidigeSpeler; 
    private Spel spel;
    private boolean draaien = false;
    private Gangkaart losseGangkaart;
    private String[][] bord;
    public UC4(DomeinController dc,DoolhofApp app,Taal taal)
    {
        this.scanner = new Scanner(System.in);
        this.dc = dc;
        this.app = app;
        this.taal = taal;
        
    }/** Initialisatie van de Domeincontroller in UC4**/
    public void speelBeurt(int beurt)
    {   draaien = false;
        boolean oneven = false;
        int x= 0;
        int y= 0;
        if( beurt ==0){
            losseGangkaart = dc.geefLosseGangkaart();
        }
        else{
        losseGangkaart = dc.nieuweLosseGangkaart();
         }
        bord = dc.toonSpelbord();
        app.uc2.maakSpelBord(bord);
        System.out.println("De losse gangkaart : " + losseGangkaart.toString());
         while(!oneven){
        System.out.println("De te zoeken schat:"+dc.bepaalSpelerAanBeurt(beurt).getDoelkaarten().get(0).toString());
        System.out.println("Waar wilt u de losse gangkaart in voegen?(links(l), rechts(r),onder(o) of boven(b)");
        String input = scanner.next();
       
        if("l".equals(input)|| "g".equals(input)){
                    y = 0;
                    System.out.println("In welke rij wenst u in te schuiven?");
                    x = scanner.nextInt();
                    if(x %2 != 0){
                        oneven = true;
                    }
                     else{
                      System.out.println("Gelieve een geldige rij in te geven!");
                  }
                    
         }
        if("r".equals(input)|| "d".equals(input)){
                   y = 6;
                   System.out.println("In welke rij wenst u in te schuiven?");
                    x = scanner.nextInt();
                    if(x %2 != 0){
                        oneven = true;
                    }
                     else{
                      System.out.println("Gelieve een geldige rij in te geven!");
                  }
        }
        
        if("o".equals(input)|| "u".equals(input) || "s".equals(input)){
                  x = 6;
                  System.out.println("In welke kolom wenst u in te schuiven?");
                  y = scanner.nextInt();
                   if(y %2 != 0){
                        oneven = true;
                    }
                    else{
                      System.out.println("Gelieve een geldige kolom in te geven!");
                  }
        }
        if("b".equals(input)||"d".equals(input)||"t".equals(input)) {
                 x = 0;
                 System.out.println("In welke kolom wenst u in te schuiven?");
                 y = scanner.nextInt();
                  if(y %2 != 0){
                        oneven = true;
                    }
                  else{
                      System.out.println("Gelieve een geldige kolom in te geven!");
                  }
        }
        }
         while(!draaien){
         System.out.println("Wenst u de gangkaart te draaien?(y/n)");
         String input1 = scanner.next();
         if("y".equals(input1)){
         draaiGangkaart(losseGangkaart);
         }
         else 
             draaien = true;
             voegGangkaartIn(losseGangkaart, x , y);
             
         }
         
         
        
    } /** Deze methode vraagt de speler waar hij zijn kaart wil inschuiven, en schuift dit ook in, samen met de bijhorende controlemethodes.**/
    
    public void draaiGangkaart(Gangkaart losseGangkaart){
        System.out.println("Hoe moet de gangkaart gedraaid worden?");
         int draaihoek = scanner.nextInt();
        losseGangkaart.setDraaihoek(draaihoek);
        System.out.println(losseGangkaart.toString()+ " met draaihoek" + losseGangkaart.getDraaihoek());
    } /** Deze methode vraagt of de speler de gangkaart wil draaien vooraleer hij hem gaat invoegen.**/
    public void voegGangkaartIn(Gangkaart losseGangkaart, int x , int y){
        
            
             dc.schuifGangkaartIn(losseGangkaart,x, y);
              
        
    } /** Deze methode voegt de al gedraaide gangkaart dan effectief in het bord in**/
}
