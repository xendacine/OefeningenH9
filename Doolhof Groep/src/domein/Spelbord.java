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
    private Gangkaart[][] bord1 = new Gangkaart[7][7];
    private Gangkaart[][] bord2 = new Gangkaart[7][7];
    private Gangkaart nieuweLosseGangkaart;
    Speler speler;
    private SpelerRepository spelerRepo;
   
    
    
    
    
    public Spelbord(String naam){
        this.naam = naam;

    } /** Constructor die spelbord aanmaakt met Parameter Naam**/
    public Spelbord() {
    } /** Lege constructor om een spelbord aan te maken die nog geen naam heeft,
     gebruikt om een tijdelijke lokale versie van een spel te maken vooraleer we het naar de database sturen**/

    /**
     * Lege constructor om een spelbord aan te maken die nog geen naam heeft,
     gebruikt om een tijdelijke lokale versie van een spel te maken vooraleer we het naar de database sturen
     * @return
     */
    public String[][] getBord() {
        return bord;
    } /** Get methode om het bord terug te krijgen **/
    
    /**
     * Get methode om het bord terug te krijgen
     * @param bord1
     */
    public void setBord(Gangkaart[][] bord1){
      
   } /** laat toe om een spelbord aan te maken, set een spelbord gebaseerd op een array van Gangkaarten (Meer bepaald 2 dimentioneel)**/

    /**
     * laat toe om een spelbord aan te maken, set een spelbord gebaseerd op een array van Gangkaarten (Meer bepaald 2 dimentioneel)
     * @param bord
     */
    public void setBord(String[][] bord) {
        this.bord = bord;
    } /** set, en spelbord dat gebaseerd is op een bestaand spelbord**/
    
    public void voegToe(Gangkaart gangkaart,int x , int y){
        
        
        bord1[x][y] = gangkaart;
      
        
    }/** Laat toe om bepaalde gangkaarten toe te voegen aan het spelbord, dit is gebruikt tijdens het inschuiven en het plaatsen van de gangkaarten op het lege spelbord **/
    
        
    
    
   
               
     public String[][] toonSpelbord() 
	{
            
          //  List<Speler> spelerlijstje = spelerRepo.geefSpelers(0);
            String naamGroen = null, naamGeel = null, naamBlauw = null, naamRood = null;
    
            int w=0; 
        /*    while(w<spelerRepo.getAantalSpelers())
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
            }*/
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
           /* spel[0][0]= String.format("%s%s", bord1[0][0].toString(), naamGeel);
                spel[0][6]= String.format("%s%s", bord1[0][6].toString(), naamBlauw);
                spel[6][0]= String.format("%s%s", bord1[6][0].toString(), naamRood);
                spel[6][6]= String.format("%s%s", bord1[6][6].toString(), naamGroen);*/
            }
            // hier moet nog een loop die bepaald welke speler welk kleur heeft
          /*  if(v<=4)
            {
//                spel[0][0]= String.format("%s%s", bord1[0][0].toString(), naamGeel);
//                spel[0][6]= String.format("%s%s", bord1[0][6].toString(), naamBlauw);
//                spel[6][0]= String.format("%s%s", bord1[6][0].toString(), naamRood);
//                spel[6][6]= String.format("%s%s", bord1[6][6].toString(), naamGroen);
                        }*/
                    return spel;
               
	} /** Toont het opgevulde spelbord **/
          public void voegGangkaartIn(Gangkaart losseGangkaart, int x, int y){
               if(x == 0){
                  nieuweLosseGangkaart = bord1[6][y];
             for ( int i = 5 ; i <0 ; i --){
                     
                      bord1[i+1][y]=bord1[i][y];
                  }
              voegToe(losseGangkaart, x ,y);
              }
               if( y== 0){
                   nieuweLosseGangkaart = bord1[x][6] ;
                   for( int i = 5 ; i < 0; i--)
                   {
                       bord1[x][i+1]= bord1[x][i];
                   }
                   voegToe(losseGangkaart, x ,y);
               }
               if(x == 6){
                   nieuweLosseGangkaart =bord1[0][y];
                   for( int i = 1; i < bord1.length  ; i ++){
                       bord1[i-1][y]= bord1[i][y];
                   }
                   voegToe(losseGangkaart, x ,y);
               }
               if( y == 6){
                   nieuweLosseGangkaart = bord1[x][0];
                   for( int i = 1 ; i<bord1.length-1 ; i++){
                       bord1[x][i-1]= bord1[x][i];
                   }
                   voegToe(losseGangkaart, x ,y);
               }  
              
          }/** Voegt de losse gangkaart in en past het bestaande spelbord aan.**/
          
          public Gangkaart nieuweLosseGangkaart(){
              return nieuweLosseGangkaart;
          } /** Zorgt dat de gangkaart die uitgeschoven word hier tijdelijk als nieuwelosse wordt opgeslaan om dan door de andere methode terug aanroepbaar te zijn **/
        
    }
    
    
