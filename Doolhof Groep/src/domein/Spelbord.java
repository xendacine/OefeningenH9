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
    private String[][] bord;
    private String naam;
    private char[] schatlijst;
    private DoelKaart doelkaart;
    private Gangkaart[] gangkaarten;
    
    
    
    public Spelbord(String[][] kaarten) {
        this.bord = kaarten;

    }
    
    public Spelbord(String naam){
        this.naam = naam;

    }
    public Spelbord() {
    }



    public String[][] getBord() {
        return bord;
    }
     public String[][] getVakken() {
        return bord;
    }

    public void setVakken(String[][] vakken) {
        this.bord = vakken;
    }
   


    public void setBord(String[][] bord) {
        this.bord = bord;
    }
    
    
    
    
    
   
               
          public String[][] toonSpelbord() 
	{
		String[][] bord1 = getBord();
                return bord1; 
	}	
        
    }
    
    
