/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import java.util.List;

/**
 *
 * @author Sven V
 */

public class Spelbord {
    
    private String naam;
    private char[] schatlijst;
    private String[][] bord;
    Gangkaart[][] bord1 = new Gangkaart[7][7];
    Speler speler;
    private SpelerRepository spelerRepo;
   
    
    
    
    
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
        
        
        bord1[x][y] = gangkaart;
      
        
    }
    
        
    
    
   
               
          public String[][] toonSpelbord() 
	{
            
            List<Speler> spelerlijstje = spelerRepo.geefSpelers(0);
            String naamGroen = null, naamGeel = null, naamBlauw = null, naamRood = null;
    
            int w=0; 
            while(w<=spelerRepo.getAantalSpelers())
            {
                if(speler.getSpelerKleur()=="groen") {
                    naamGroen = speler.getSpelernaam();
                } else {
                    if(speler.getSpelerKleur()=="geel") {
                        naamGeel = speler.getSpelernaam();
                    } else {
                        if(speler.getSpelerKleur()=="blauw") {
                            naamBlauw = speler.getSpelernaam();
                        } else {
                            naamRood = speler.getSpelernaam();
                        }
                    }
                }
               w++;     
            }
            int v = 0;
            String spel[][] = new String[7][7];
            int x = 0;
        while (x < 7) {
            int y = 0;
            while (y < 7) {
//                    if(x==0||y==0)
//                            spel[x][y]= String.format("%s %s %s", bord1[x][y].toString(), (String)SpelerRepository.getSpeler(1), );
//                    bord1[x][y].toString()+ (String) domein.Speler.getSpelernaam();   
                          spel[x][y]= bord1[x][y].toString();
                    
                    y++;
                }
            x++;
            spel[0][0]= String.format("%s%s", bord1[0][0].toString(), naamGeel);
                spel[0][6]= String.format("%s%s", bord1[0][6].toString(), naamBlauw);
                spel[6][0]= String.format("%s%s", bord1[6][0].toString(), naamRood);
                spel[6][6]= String.format("%s%s", bord1[6][6].toString(), naamGroen);
            }
            // hier moet nog een loop die bepaald welke speler welk kleur heeft
            if(v<=4)
            {
//                spel[0][0]= String.format("%s%s", bord1[0][0].toString(), naamGeel);
//                spel[0][6]= String.format("%s%s", bord1[0][6].toString(), naamBlauw);
//                spel[6][0]= String.format("%s%s", bord1[6][0].toString(), naamRood);
//                spel[6][6]= String.format("%s%s", bord1[6][6].toString(), naamGroen);
                        }
                    return spel;
               
	}	
        
    }
    
    
