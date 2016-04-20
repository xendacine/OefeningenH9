/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

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
    private Spelbord spelbord;
    List<Gangkaart> gangkaarten = new ArrayList<>();
    char[] schatLijst = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x'};
   // char[] schatLijst2 = {'m', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x'};
    private Speler jongsteSpeler;
    private int jongsteSpelerDatum;
    //private SpelerRepository spelerRepo = new SpelerRepository();
    
    public Spel(String spelnaam) {
      
        setSpelnaam(spelnaam);

    }

    public Spel(Spelbord bord, List<Speler> spelerlijst) {
        spelbord = bord;
        spelers = spelerlijst;
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
                    Gangkaart vrijeGangkaart = gangkaarten.get(gangkaarten.size()-1);
                   int c = 0;
                   
                  while ( c <gangkaarten.size()-2){
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
    
    public void bepaalEersteSpeler(){
        
        spelersTijdelijk = new ArrayList<Speler>();
        spelersNamen = new ArrayList<String>();
        spelersTijdelijk.addAll(spelers);
        jongsteSpelerDatum = 1900;
        for(int i = 0 ; i< spelersTijdelijk.size() ; i++){
            if( jongsteSpelerDatum<spelersTijdelijk.get(i).getSpelerGeboortejaar()){
                jongsteSpelerDatum = spelersTijdelijk.get(i).getSpelerGeboortejaar();
                
            }
           
            }
        for(int j =0 ; j< spelersTijdelijk.size(); j++){
            if(jongsteSpelerDatum == spelersTijdelijk.get(j).getSpelerGeboortejaar()){
                spelersNamen.add(spelersTijdelijk.get(j).getSpelernaam());
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
               /* for(int m = spelersTijdelijk.size()-1; m > spelersTijdelijk.indexOf(jongsteSpeler)  ; m --){
  
                    spelersTijdelijk.remove(spelersTijdelijk.get(m));
                }
                spelersVolgorde.addAll(spelersTijdelijk);*/
		return spelersVolgorde;
	}
   
   
         public List<Speler> jongsteSpeler(List<Speler> spelerlijst){
         List a = new ArrayList();       int nrJongste = 0;   
         int jongsteSpeler = 1900;                                                         // lijst om paar lijnen verder de jongste speler in op te slaan.
         for (int i = 0; i < spelerlijst.size();i++ ){                                       // overlopen spelerlijst
                                                                                                // iedereen is swso jonger dan geboortejaar 1900 
             if(spelerlijst.get(i).getSpelerGeboortejaar() > jongsteSpeler)                         // vgl met jongste speler die aangepast wordt in deze forlus
             {
                 {
                 jongsteSpeler = spelerlijst.get(i).getSpelerGeboortejaar();
                 a.add(0,spelerlijst.get(i));}    
                 nrJongste = i;
// jongste speler word op rang 0 opgeslagen in de a. lijst.
//                 if ( i == spelerlijst.size()){                                         // bij de laatste speler 
//                     for (int j = 0; j < spelerlijst.size(); j++){                      // spelerlijst opnieuw overlopen  want programma weet waarschijnlijk niet welke waarde 
//                                                                                        // is opgeslagen als jongste speler
//                         
//                     if(spelerlijst.get(j).equals(a.get(0))){                           // als de speler (met attributen) gelijk is aan de jongste speler
//                         
//                     spelerlijst.remove(spelerlijst.get(i));                            // word deze verwijdert. 
//                     }
//                     spelerlijst.add(0, (Speler) a.get(0));                             // de jongste speler bovenaan toevoegen aan de spelerlijst. 
//                                                                                        // → zou deze verdwenen zijn nadat ik hem heb verwijdert uit de spelerlijst
//                     
//                    
//                     }
                 }
             }
         for (int j  = nrJongste+1; j < spelerlijst.size();j++){
             a.add(spelerlijst.get(j));
             for (int k = 0; k < nrJongste;k++){
                 a.add(spelerlijst.get(k));
             }
             
         }
         return a;
         }
         
    }
