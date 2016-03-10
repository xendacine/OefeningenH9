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
public final class Spel {
    private String spelnaam;
    private List<Speler> spelers;
    private Spelbord bord;
    public Spel(String spelnaam){
        
        setSpelnaam(spelnaam);
        
        
    }
    public Spel(Spelbord bord, List<Speler> spelerlijst ){
                this.bord = bord;
                this.spelers = spelerlijst;
    }
    
     public String getSpelnaam() {
        return spelnaam;
    }

    public void setSpelnaam(String spelnaam) {
        this.spelnaam = spelnaam;
    }
    
    
}
