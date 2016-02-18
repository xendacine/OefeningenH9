/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Sven V
 */
public class UC1 {
    private final DomeinController dc;
     private final DoolhofApp app;
     String taal;
     ResourceBundle tekst;   
     private final Scanner scanner;
    private String[] spellen;
    private String[] spelers;
    
    
     public UC1(DomeinController dc, DoolhofApp app,String taal)
    {
        this.scanner = new Scanner(System.in);
        this.dc = dc;
        this.app = app;
        this.taal = taal;
        Locale currentLocale;
        currentLocale = new Locale(taal);
        tekst = ResourceBundle.getBundle("resourcebundles.Resource", currentLocale);
    }
     
     public void startSpel(){
        int keuze;
         
         do {
            keuze = geefKeuze();
            switch (keuze) {
                case 1:
                   startNieuwSpel();
                    break;
                case 2:
                   laadBestaandSpel();
                case 3:
                    System.exit(0);
           }
            
   }while (keuze
                != 2);
     }
     
     
   private int geefKeuze() {
        int ingave;

        try {
            System.out.println(tekst.getString("doolhof"));
           
            System.out.println(tekst.getString("startNieuwSpel"));
            System.out.println(tekst.getString("startBestaandSpel"));
            System.out.println(tekst.getString("stop2"));

           
            ingave = scanner.nextInt();
        } catch (InputMismatchException ie) {
            ingave = 0;
            scanner.nextLine();
        }
        return ingave;
   }
      
  public void startNieuwSpel(){
      String spelNaam;
      
      System.out.println(tekst.getString("spelNaam"));
      spelNaam = scanner.next();
    // uc2.startNieuwSpel(spelNaam);
  }   
  
  public String laadBestaandSpel(){
        

        spellen = dc.getSpellen();
        String gekozen;
        if (spellen.length == 0) {
            System.out.println("Er zijn geen opgeslagen spellen");
            gekozen = "geen";
        } else {
            System.out.println("De mogelijke spellen zijn :");
            for (int i = 0; i < spellen.length; i++) {
                int count = i + 1;
                System.out.println(count + ". " + spellen[i]);

            }
            gekozen = keuzeSpel(spellen);
        }
        return gekozen;
    }
  
  public String keuzeSpel(String[] spellen) {
        System.out.println("kies een spel: 1-" + spellen.length);
        int keuze;
        int[] aantal;
        String gekozen = null;
        keuze = scanner.nextInt();
        if (keuze >= 1 && keuze <= spellen.length) {
            gekozen = spellen[keuze - 1];

        } else {
            keuzeSpel(spellen);
        }
        geefSpelers();
        return gekozen;
    }
  
  public void geefSpelers(){
        spelers = dc.getSpelers();
 
        if (spelers.length == 0) {
            System.out.println("Er zijn geen spelers");
            
        } else {
            System.out.println("De spelers zijn :");
            for (int i = 0; i < spelers.length; i++) {
                int count = i + 1;
                System.out.println(count + ". " + spelers[i]);

            }
           
    }
  }
  
  
    
}
