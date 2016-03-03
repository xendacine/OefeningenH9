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
public class UC2 {
     private final DomeinController dc;
     private final DoolhofApp app;
     private Taal taal;
     ResourceBundle tekst;   
     private final Scanner scanner;
    
    
    
     public UC2(DomeinController dc, DoolhofApp app,Taal taal)
    {
        this.scanner = new Scanner(System.in);
        this.dc = dc;
        this.app = app;
        this.taal = taal;
        
    }
     
      public void startNieuwSpel(){
      String spelNaam;
      
      System.out.println(taal.getTekst().getString("spelNaam"));
      spelNaam = scanner.next();
    
  }   
     
}
     
