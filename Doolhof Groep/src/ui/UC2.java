/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import domein.Speler;
import domein.Taal;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Sven V
 */
public class UC2 {
     private final DomeinController dc;
     private final DoolhofApp app;
     private Taal taal;
     ResourceBundle tekst;   
     private final Scanner scanner;
    private int aantalSpelers;
    private String naam;
    private String kleur;
    private int geboortejaar;
    
     public UC2(DomeinController dc,DoolhofApp app,Taal taal)
    {
        this.scanner = new Scanner(System.in);
        this.dc = dc;
        this.app = app;
        this.taal = taal;
        
    }
     
      public void startNieuwSpel(){
        dc.wenstSpelAanTemaken();
        dc.maakSpelbord();
        
          
          boolean controle_spelers = false;
    	do 
    	{
    		try
    		{
    			System.out.printf("Geef het aantal deelnemers in: ");
    			aantalSpelers = scanner.nextInt();
				dc.stelAantalSpelersIn(aantalSpelers);
    			controle_spelers = true;
    		}
    		catch(InputMismatchException imme)/* Controle op letters */
    		{
    			System.out.println("Gelieve een cijfer in te geven!");
    			scanner.nextLine();
    		}
    		catch(IllegalArgumentException iae)/* Controle op aantal spelers */
    		{
    			System.out.println("Gelieve een correct aantal spelers in te geven");
    			scanner.nextLine();
    		}
    	}
    	while(!controle_spelers);
    	
    	geeftGegevensIn();
    			
      }
      
      
      public void geeftGegevensIn(){
          for(int i =0; i<aantalSpelers;i++){
              
                                naam = geefNaam(i);
                                geboortejaar = geefGeboortejaar(i);
                                kleur = geefKleur(i);        
    				
    				dc.maakSpeler(naam,geboortejaar,kleur);
                                
          }
          
          dc.bepaalEersteSpeler();
          String[][] bord = dc.toonSpelbord();
          this.maakSpelBord(bord);
      }
      public String geefNaam(int i){
        System.out.println("Gelieve de naam van speler "+(i+1)+" in te geven:");
        String naam1;
        int naamLengte;
        naam1 = scanner.next();
        naamLengte = naam1.length();

        if (naamLengte < 2) {
            System.out.println("De naam is te kort! ");

            naam1 = geefNaam(i);

        }

        return naam1;
    
      }
      
      public int geefGeboortejaar(int i){
          System.out.println("Geef de geboortejaar in van speler"+(i+1)+":");
          int jaar;
          jaar = scanner.nextInt();
          
          if(jaar>2010 ){
              System.out.println("Je moet minstens 7 jaar zijn!");
              jaar = geefGeboortejaar(i);
          }
          
         if(jaar<1926){
                           System.out.println("Je mag maximaal 90 jaar zijn!");
                           geboortejaar = geefGeboortejaar(i);
         }
          return jaar;
      }
      public String geefKleur(int i){
          System.out.println("Geef de kleur in van speler"+(i+1)+"(rood, geel, groen, blauw):");
          String kleur1= scanner.next();
          
          if((!kleur1.equals("blauw"))){
              if((!kleur1.equals("rood"))){
                  if((!kleur1.equals("groen"))){
                      if((!kleur1.equals("geel"))){
            System.out.println("Kies een juiste kleur!");
                           kleur1 = geefKleur(i);
                      }
                  }
              }
         }
        
           
            return kleur1;
      }
      
      
      
       public void maakSpelBord(String[][]bord){
           
        System.out.println("HET SPELBORD:\n");
        int x = 0;
        while (x < 7) {
            int y = 0;
            while (y < 7) {
                String type = bord[x][y];
                if(type == null){
                    type = "Kruising";
                }
                 switch (type) {
                    case "Kruising":
                        System.out.print("Ts  ");
                        break;
                    case "Hoekpuntgeel":
                        System.out.print("Hg  ");
                        break;
                    case "Hoekpuntblauw":
                        System.out.print("Hb  ");
                        break;
                    case "Hoekpuntrood":
                        System.out.print("Hr  ");
                        break;
                    case "Hoekpuntgroen":
                        System.out.print("Hgr ");
                        break;
                    case "Hoekpuntleeg":
                        System.out.print("H   ");
                        break;
                    case "Hoekpuntleegschat":
                        System.out.print("Hs  ");
                        break;
                    case "Rechte":
                        System.out.print("R   ");
                        break;
                        
                }

                y++;
            }
            x++;
            System.out.print("\n\n");
            

        }
       geefOverzichtSpelers();
    }
       
       public void geefOverzichtSpelers()
    {
    	System.out.printf("meldingDeelnemers\n");
    	
    	List<Speler> spelers = dc.geefOverzichtSpelers();
        
    	for (int i = 0; i < aantalSpelers; i++)
    	{
            
    		System.out.println("\nSpeler " + (i+1) + ": " + spelers.get(i).getSpelernaam() + " met Kleur : " 
                        + spelers.get(i).getSpelerKleur() + "\n Start op : " );
                        String spelerkleur = spelers.get(i).getSpelerKleur();
                        switch(spelerkleur){
                             case "blauw":
                        System.out.print("Het vakje met coordinaten [0,6]");
                        break;
                        case "geel":
                        System.out.print("Het vakje met coordinaten [0,0]");
                        break;
                    case "groen":
                        System.out.print("Het vakje met coordinaten [6,6]");
                        break;
                    case "rood":
                        System.out.print("Het vakje met coordinaten [6,0]");
                        break;
                        }
    	}
    	System.out.println();
    }
       
      

     
     
}
     
