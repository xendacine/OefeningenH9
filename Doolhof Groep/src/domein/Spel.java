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
public final class Spel {
    private String spelnaam;
    
    
    public Spel(String spelnaam){
        
        setSpelnaam(spelnaam);
        
        
    }
    
     public String getSpelnaam() {
        return spelnaam;
    }

    public void setSpelnaam(String spelnaam) {
        this.spelnaam = spelnaam;
    }
    
    
}
