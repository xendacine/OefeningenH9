/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import domein.Spel;
import domein.SpelRepository;
import domein.Spelbord;
import domein.Speler;
import domein.SpelerRepository;
import domein.Taal;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Sven V
 */
public class DomeinController {
    private Spel spel;
    private final SpelRepository spelRepo;
    private final SpelerRepository spelerRepo;
    private List<Spel> spelLijst;
    private List<Speler> spelerlijst;
    private Taal taal;
    private Spelbord spelbord;
    private Speler huidigeSpeler ;
    public DomeinController() {
        
    
        spelRepo = new SpelRepository();
        spelerRepo = new SpelerRepository();
    }
    
  
   
   public String[] laadBestaandSpel() {
        int count = 0;
        spelLijst = spelRepo.laadBestaandSpel();
        String[] spellen = new String[spelLijst.size()];
        Iterator<Spel> spelIterator = spelLijst.iterator();
        while (spelIterator.hasNext()) {
            Spel gevondenSpel = spelIterator.next();
            String spelnaam = gevondenSpel.getSpelnaam();
            spellen[count] = spelnaam;
            count++;
        }
        return spellen;

    }
   
   public String[] getSpelers(int spelID) {
       int count = 0 ;
       spelerlijst = spelerRepo.geefSpelers(spelID);
        String[] spelers = new String[spelerlijst.size()];
        Iterator<Speler> spelerIterator = spelerlijst.iterator();
        while (spelerIterator.hasNext()) {
            Speler gevondenSpeler = spelerIterator.next();
            String spelnaam = gevondenSpeler.getSpelernaam();
            spelers[count] = spelnaam;
            count++;
        }
        return spelers;
   }
   
   public void kiesTaal(int ingave){
       taal.kiesTaal(ingave);  
               }
   
  
   public void wenstSpelAanTemaken(){
       spelbord = new Spelbord();
       spelerlijst = spelerRepo.geefSpelers();
       spel = new Spel(spelbord,spelerlijst);
       spel.maakDoelkaarten();
   }
   public void maakSpelbord(){
      spel.maakSpelbord();
   }
   
   public String[][] toonSpelbord(){
     
      return spelbord.toonSpelbord();
   }
   public void stelAantalSpelersIn(int aantal)
	{
		spelerRepo.setAantalSpelers(aantal);
	}
   
   public void maakSpeler(String naam,int geboortejaar, String kleur, List<DoelKaart> doelkaarten) 
	{
		spelerRepo.maakSpeler(naam,geboortejaar,kleur, doelkaarten);
	}
  
   public void bepaalEersteSpeler(){
       spel.bepaalEersteSpeler();
   }
   
   public List<Speler> geefOverzichtSpelers(){
       return spelerlijst = spel.bepaalSpelersVolgorde();
   }
  
   
    public Speler bepaalSpelerAanBeurt(int beurt)
    {
        return spel.bepaalSpelerAanBeurt(beurt);
    }
     
    /** Geeft aan welke speler in
     * @param beurt deze beurt mag spelen.
     * @return  */
    public String geefHuidigeSpeler(int beurt)
    {                                
        huidigeSpeler = this.bepaalSpelerAanBeurt(beurt);
        return huidigeSpeler.getSpelernaam();
    }
    public boolean bestaatSpeler(String naam){
        
    
    return spelerRepo.bestaatSpelerMetNaam(naam);}
    
    
    public boolean bestaatKleur(String kleur){
        
    
    return spelerRepo.bestaatKleur(kleur);}
    
    public List<DoelKaart> verdeelDoelkaarten(int aantalSpelers, int i){
        return spel.verdeelDoelkaarten(aantalSpelers, i);
    }
}