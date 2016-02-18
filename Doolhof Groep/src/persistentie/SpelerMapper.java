/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Speler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sven V
 */
public class SpelerMapper {
    
    public List<Speler> geefSpelers(){
          List<Speler> spelerlijst = new ArrayList<>();
          String speler1 = "speler1";
          Speler gevondenSpeler = new Speler(speler1);
          spelerlijst.add(gevondenSpeler);
          return spelerlijst;
 }
}
