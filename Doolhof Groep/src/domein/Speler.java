/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

/**
 *
 * @author Sven V
 */
public final class Speler {
    private String naam;
    
    
    public Speler(String naam){
        
        setSpelernaam(naam);
        
        
    }
    
     public String getSpelernaam() {
        return naam;
    }

    public void setSpelernaam(String naam) {
        this.naam = naam;
    }
    
    
}
    

