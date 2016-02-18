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
public class DoolhofApp {

   private DomeinController dc;
   private UC1 uc1;
   String taal;
   ResourceBundle tekst;   
   private Scanner scanner = new Scanner(System.in);
   
   public DoolhofApp(DomeinController dc) throws InputMismatchException, IllegalArgumentException {
     this.dc = dc;
     kiesTaal();
     this.uc1 = new UC1(dc, this, taal);
     
     int keuze;
     
      do {
            keuze = geefKeuze();
            switch (keuze) {
                case 1:
                    uc1.startSpel();
                    break;
                    
                case 2:
                    System.exit(0);
           }
            
   }while (keuze
                != 2);
      
 }
      
   private int geefKeuze() {
        int ingave;

        try {
            System.out.println(tekst.getString("doolhof"));
           
            System.out.println(tekst.getString("startSpel"));
            System.out.println(tekst.getString("stop"));

           
            ingave = scanner.nextInt();
        } catch (InputMismatchException ie) {
            ingave = 0;
            scanner.nextLine();
        }
        return ingave;
   }
   
   private void kiesTaal() {

        int ingave = 0;
        boolean ongeldigeIngave = false;
        do {
            
            try {
                
                System.out.println("1. Press 1 for English.");
                System.out.println("2. Tapes 2 pour français");
                System.out.println("3. Druk op 3 voor Nederlands.");
                System.out.print("[1-3]: ");
                ingave = scanner.nextInt();
                if (ingave < 1 || ingave > 3) {
                    System.out.println("\nEnter a valid value (1-3)\nEntrer une valeur valide (1-3)\nVul een geldige waarde in (1-3)");
                } else {
                    ongeldigeIngave = true;
                }
            } catch (InputMismatchException im) {
                System.out.println("\nEnter a valid value (1-3)\nEntrer une valeur valide (1-3)\nVul een geldige waarde in (1-3)");
                scanner.nextLine();
            }
        } while (ongeldigeIngave != true);
        if (ingave == 1) {
            taal = "en";
        }
        if (ingave == 2) {
            taal = "fr";
        }
        if (ingave == 3) {
            taal = "nl";
        }
        if (ingave < 1 || ingave > 3) {
            kiesTaal();
        }
       Locale currentLocale;
       currentLocale = new Locale(taal);
       tekst = ResourceBundle.getBundle("resourcebundles.Resource", currentLocale);
}
}
