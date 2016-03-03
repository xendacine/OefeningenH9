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
/**
 *
 * @author Sven V
 */
public class DoolhofApp {

   private DomeinController dc;
   private UC1 uc1;
   UC2 uc2;
   private int ingave = 0;
   ResourceBundle tekst;   
   private Scanner scanner = new Scanner(System.in);
   private Taal taal;
   
   public DoolhofApp(DomeinController dc, Taal taal) throws InputMismatchException, IllegalArgumentException {
     this.dc = dc;
     this.taal = taal;
     kiesTaal();
     this.uc1 = new UC1(dc,this, taal);
     this.uc2 = new UC2(dc,this, taal);
     
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
        

        try {
            System.out.println(taal.getTekst().getString("doolhof"));
           
            System.out.println(taal.getTekst().getString("startSpel"));
            System.out.println(taal.getTekst().getString("stop"));

           
            ingave = scanner.nextInt();
        } catch (InputMismatchException ie) {
            ingave = 0;
            scanner.nextLine();
        }
        return ingave;
   }
   
   private void kiesTaal() {
       
       
		boolean controle_taal = false;
    	do 
    	{
    		try
    		{
    			System.out.printf(	"\n%-40s\t%-40s\t%-40s\n%-40s\t%-40s\t%-40s\n" +
						  			"%-40s\t%-40s\t%-40s\n",
						  			"Welkom bij het spel Betoverde Doolhof!",   "Bienvenu au Labyrinthe Enchanté!",
						  			"Welcome at the game Enchanted Maze!",   "---------------------------",
						  			"---------------------------", "---------------------------",
						  			"Kies uw taal (1)", 			  "Choissisez votre langue (2)",
    								"Choose your language (3)"); 
    								ingave = scanner.nextInt();
    								taal.kiesTaal(ingave);
		
    								controle_taal = true;
                                                                
    		}
    		catch(InputMismatchException imme)/* Controle op letters */
    		{
    			System.out.printf("%-40s\t%-40s\t%-40s\n", "Gelieve een geldige keuze in te geven!",
    							  "Veuillez entrez un choix valable!", "Please enter a valid choice!");
    			scanner.nextLine();
    		}
    		catch(IllegalArgumentException iae)/* Controle op selectie */
    		{
    			System.out.println(iae.getMessage());
    			scanner.nextLine();
    		}
                    /* Controle op selectie */
    	}
    	while(!controle_taal);
	}


}
