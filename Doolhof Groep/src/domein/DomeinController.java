/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

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
        String[] spellen = new String[spelerlijst.size()];
        Iterator<Speler> spelerIterator = spelerlijst.iterator();
        while (spelerIterator.hasNext()) {
            Speler gevondenSpeler = spelerIterator.next();
            String spelnaam = gevondenSpeler.getSpelernaam();
            spellen[count] = spelnaam;
            count++;
        }
        return spellen;
   }
   
   public void kiesTaal(int ingave){
       taal.kiesTaal(ingave);  
               }
   
}
