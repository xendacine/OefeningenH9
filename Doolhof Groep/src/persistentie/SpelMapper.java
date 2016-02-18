/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Spel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sven V
 */
public class SpelMapper {
    
    

     public List<Spel> geefSpellen(){
          List<Spel> spellijst = new ArrayList<>();
          String spel1 = "spel 1";
          Spel gevondenSpel = new Spel(spel1);
          spellijst.add(gevondenSpel);
          return spellijst;
 }
     
     public Spel getSpel(String Spelnaam){
        Spel spel = null;
           return spel;
     }
}
