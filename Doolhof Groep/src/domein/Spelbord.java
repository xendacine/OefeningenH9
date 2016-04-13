/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sven V
 */
public class Spelbord {
    
    private String naam;
    private char[] schatlijst;
    private String[][] bord;
    String[][] bord1 = new String[7][7];
    
   
    
    
    
    
    public Spelbord(String naam){
        this.naam = naam;

    }
    public Spelbord() {
    }



    public String[][] getBord() {
        return bord;
    }
    
  
   


    public void setBord(String[][] bord) {
        this.bord = bord;
    }
    
    public void voegToe(Gangkaart gangkaart,int x , int y){
        
        
        bord1[x][y] = gangkaart.toString();
      
        
    }
    
    
    
    
   
               
          public String[][] toonSpelbord() 
	{
		return bord1;
               
	}	
        
    }
    
    
