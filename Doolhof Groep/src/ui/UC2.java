/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import domein.Taal;
import java.util.Arrays;
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
    
    
    
     public UC2(DomeinController dc,DoolhofApp app,Taal taal)
    {
        this.scanner = new Scanner(System.in);
        this.dc = dc;
        this.app = app;
        this.taal = taal;
        
    }
     
      public void startNieuwSpel(){
          
      String[][] bord = new String[7][7];
      
      int x = 0;
        while (x < 7) {
            int y = 0;
            while (y < 7) {
                if(x == 0 && y==0 || x==6 && y==0 || x==0 && y==6 || x==6 && y==6){
                      bord[x][y] = "Hoekpunt";}
                
                else if(x%2 == 0 & y%2 ==0){
                   bord[x][y] = "Tpunt";
                    
                }
                
                else{
                    bord[x][y] ="leeg";}
                     y++;
                }
                
                 x++;
               
            }

           maakSpelBord(bord);
        }
      
       public void maakSpelBord(String[][]bord){
        System.out.println("HET SPELBORD:\n");
        int y = 0;
        while (y < 7) {
            int x = 0;
            while (x < 7) {
                String type = bord[x][y];
                switch (type) {
                    case "Tpunt":
                        System.out.print("T ");
                        break;
                    case "Hoekpunt":
                        System.out.print("H ");
                        break;
                    case "leeg":
                        System.out.print("  ");
                        break;
                    
                }

                x++;
            }
            y++;
            System.out.print("\n");
            

        }

    }

     
     
}
     
