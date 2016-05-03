/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Sven V
 */
public final class Spel {

    private String spelnaam;
    private List<Speler> spelers;
    private List<Speler> spelersTijdelijk;
    private List<Speler> spelersGelijk;
    private List<Speler> spelersVolgorde;
    private List<String> spelersNamen;
    private List<DoelKaart> doelkaarten = new ArrayList<>();
    private List<DoelKaart> doelkaartenCopy = new ArrayList<>();
    private List<DoelKaart> doelkaarten2 ;
    private Spelbord spelbord;
    List<Gangkaart> gangkaarten = new ArrayList<>();
    char[] schatLijst = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x'};
    char[] schatLijst2 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x'}; 
    char letter;
    private Speler jongsteSpeler;
    private Speler huidigeSpeler;
    private int jongsteSpelerDatum;
    //private SpelerRepository spelerRepo = new SpelerRepository();
    
    public Spel(String spelnaam) {
      
        setSpelnaam(spelnaam);

    }

    public Spel(Spelbord bord, List<Speler> spelerlijst) {
        spelbord = bord;
        spelers = spelerlijst;
        //this.maakDoelkaarten();
    }

    public String getSpelnaam() {
        return spelnaam;
    }

    public void setSpelnaam(String spelnaam) {
        this.spelnaam = spelnaam;
    }
    
    
   
    public void maakSpelbord() {

     
        
                int draaihoek = 0 + (int) (Math.random() * ((3 - 0) + 1));
              
           
                    spelbord.voegToe(new Hoek(0,"geel"),0,0);
                    spelbord.voegToe(new Hoek(1,"blauw"),0,6);
                    spelbord.voegToe(new Hoek(2,"rood"),6,0);
                    spelbord.voegToe(new Hoek(3,"groen"),6,6);
                    spelbord.voegToe(new Kruising(draaihoek,'a'),0 ,2 );
                    spelbord.voegToe(new Kruising(draaihoek,'b'),0 ,4 );
                    spelbord.voegToe(new Kruising(draaihoek,'c'),2 ,0 ); 
                    spelbord.voegToe(new Kruising(draaihoek,'d'),2 ,2 );
                    spelbord.voegToe(new Kruising(draaihoek,'e'),2 ,4 );
                    spelbord.voegToe(new Kruising(draaihoek,'f'),2 ,6 );
                    spelbord.voegToe(new Kruising(draaihoek,'g'),4 ,0 ); 
                    spelbord.voegToe(new Kruising(draaihoek,'h'),4 ,2 );
                    spelbord.voegToe(new Kruising(draaihoek,'i'),4 ,4 );
                    spelbord.voegToe(new Kruising(draaihoek,'j'),4 ,6 );
                    spelbord.voegToe(new Kruising(draaihoek,'k'),6 ,2 );
                    spelbord.voegToe(new Kruising(draaihoek,'l'),6 ,4 );
                    
                    for(int i = 0; i<10 ; i++){
                        draaihoek = 0 + (int) (Math.random() * ((3 - 0) + 1));
                        gangkaarten.add(new Hoek(draaihoek,"leeg"));
                    }
                    
                    for(int j = 0 ; j<6 ; j++){
                        draaihoek = 0 + (int) (Math.random() * ((3 - 0) + 1));
                        gangkaarten.add(new Hoek(draaihoek,schatLijst[12+j],"leeg"));
                       
                    }
                    
                    for(int k = 0 ; k <12 ; k++){
                        draaihoek = 0 + (int)(Math.random() * ((3 - 0) + 1));
                        gangkaarten.add(new Rechte(draaihoek));
                    }
                    
                    for(int l = 0; l<6 ; l++){
                        draaihoek = 0 + (int)(Math.random() * ((3 - 0) + 1));
                        
                        gangkaarten.add(new Kruising(draaihoek,schatLijst[18+l]));
                        
                        
                    }
                    Collections.shuffle(gangkaarten);
                    
                   int c = 0;
                   
                  while ( c <gangkaarten.size()-1){
                    for(int a = 0 ; a<7 ; a++){
                        
                        for(int b = 0 ; b<7; b++){
                            if((a%2==1) || (b%2==1)){
                              
                              
                                
                                spelbord.voegToe(gangkaarten.get(c), a, b);
                              
                                c++;
                              
                            }
                            
                        }
                        
                    }
                    
                   }

               

        }
    public Gangkaart bepaalLosseGangkaart(){
        return gangkaarten.get(gangkaarten.size()-1);
    }
    
    public void bepaalEersteSpeler(){
        
        spelersTijdelijk = new ArrayList<Speler>();
        spelersNamen = new ArrayList<String>();
        spelersTijdelijk.addAll(spelers);
        jongsteSpelerDatum = 1900;
        for (Speler spelersTijdelijk1 : spelersTijdelijk) {
            if (jongsteSpelerDatum < spelersTijdelijk1.getSpelerGeboortejaar()) {
                jongsteSpelerDatum = spelersTijdelijk1.getSpelerGeboortejaar();
            }
        }
        for (Speler spelersTijdelijk1 : spelersTijdelijk) {
            if (jongsteSpelerDatum == spelersTijdelijk1.getSpelerGeboortejaar()) {
                spelersNamen.add(spelersTijdelijk1.getSpelernaam());
            }
        }
        
        if(spelersNamen.size()>1){
            Collections.sort(spelersNamen);
            for(int l = 0 ; l < spelersTijdelijk.size() ; l++){
            if(spelersTijdelijk.get(l).getSpelernaam().equals(spelersNamen.get(0))){
                jongsteSpeler = spelersTijdelijk.get(l);
            }
        }
        }
        
        else {
            for(int k = 0 ; k < spelersTijdelijk.size() ; k++){
            if(spelersTijdelijk.get(k).getSpelernaam().equals(spelersNamen.get(0))){
                jongsteSpeler = spelersTijdelijk.get(k);
            }
                }
        }
        
    }
    
   public List<Speler> bepaalSpelersVolgorde()
	{
                spelersVolgorde = new ArrayList<Speler>();
                spelersVolgorde.add(0,jongsteSpeler);
                for (int i = spelersTijdelijk.indexOf(jongsteSpeler)+1 ; i < spelersTijdelijk.size() ; i++){
                    spelersVolgorde.add(spelersTijdelijk.get(i));
                }
                for( int j = 0; j <spelersTijdelijk.indexOf(jongsteSpeler) ; j ++ ){
                    spelersVolgorde.add(spelersTijdelijk.get(j));
                }
               
		return spelersVolgorde;
	}
   
   public Speler bepaalSpelerAanBeurt(int beurt)
    {
        int beurtSpeler = (beurt) % spelersVolgorde.size();
        huidigeSpeler = spelersVolgorde.get(beurtSpeler);
        return huidigeSpeler;
    }
   
   public void maakDoelkaarten(){
       
        
        for(int i = 0 ; i < schatLijst2.length ; i ++){
            letter = schatLijst2[i];
            doelkaarten.add(new DoelKaart(letter));
        }
        Collections.shuffle(doelkaarten);
    }
    
    public List<DoelKaart> verdeelDoelkaarten(int aantalSpelers , int i){
        doelkaarten2 = new ArrayList<>();
        doelkaartenCopy.addAll(doelkaarten);
        if(aantalSpelers == 4){
            if(i ==0){
            for (int j = 0 ; j <6 ; j ++){
                doelkaarten2.add(doelkaartenCopy.get(j));
            }
        }
        if( i== 1){
             doelkaarten2.clear();
            for (int j = 6 ; j <12 ; i ++){
               doelkaarten2.add(doelkaartenCopy.get(j));
                
            }
        }
        if( i== 2 ){
            doelkaarten2.clear();
            for (int j = 12 ; j <18 ; j++){
               doelkaarten2.add(doelkaartenCopy.get(j));
                
            }
        }
         if( i== 3){
            doelkaarten2.clear();
            for (int j = 18 ; j <24 ;j ++){
               doelkaarten2.add(doelkaartenCopy.get(j));
                
            }
        }
        }
        if(aantalSpelers == 3){
            if(i ==0){
            for (int j = 0 ; j <8 ; j ++){
                doelkaarten2.add(doelkaartenCopy.get(j));
            }
        }
        if( i== 1){
             doelkaarten2.clear();
            for (int j = 8 ; j <16 ; j ++){
               doelkaarten2.add(doelkaartenCopy.get(j));
                
            }
        }
        if( i== 2 ){
            doelkaarten2.clear();
            for (int j = 16 ; j <24 ; j++){
               doelkaarten2.add(doelkaartenCopy.get(j));
                
            }
        }
        
        }
        if(aantalSpelers == 2){
            if(i ==0){
            for (int j = 0 ; j <12 ; j ++){
                doelkaarten2.add(doelkaartenCopy.get(j));
            }
        }
        if( i== 1){
            doelkaarten2.clear();
            for (int k = 12 ; k <24 ; k ++){
               doelkaarten2.add(doelkaartenCopy.get(k));
                
            }
        
        }
        }
       return doelkaarten2;
       
    }
    
   /* public Gangkaart[][] schuifGangkaartIn(Array[][] bord, Gangkaart Gangkaart, int xSchuif, int ySchuif, int draaihoek)
   {
       Gangkaart[][] tijdelijk = spelbord.bord1;
       ArrayList<Gangkaart> rijtje = new ArrayList<Gangkaart>();
       List<Array>[] rijtje2 = (List<Array>[]) new Array[7];
       
   
       controleerInschuifplek(xSchuif, ySchuif);
       
       if(ySchuif == 0)
       {
           for (int i=0; i<7; i++)
           {
               int shift = 0;
               // move naar rechts
               tijdelijk[0][1] = x++;
               
           }
//           rijtje = tijdelijk[xSchuif][0];
//           tijdelijk[xSchuif][1], tijdelijk[xSchuif][2], tijdelijk[xSchuif][3], tijdelijk[xSchuif][4], tijdelijk[xSchuif][5], tijdelijk[xSchuif][6];
       }
       return Gangkaart[]][];
   }
   
   public void controleerInschuifplek(int xSchuif, int ySchuif)
   {
       
   }*/
   
        
         
    }
