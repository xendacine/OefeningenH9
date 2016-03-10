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
    private int geboortejaar;
    private String kleur;
    
    
    public Speler(String naam){
        setSpelernaam(naam);
    }
    
    public Speler(String naam, int geboortejaar, String kleur){
        
        setSpelernaam(naam);
        setSpelerKleur(kleur);
        setSpelerGeboortejaar(geboortejaar);
    }
    
    
     public String getSpelernaam() {
        return naam;
    }

    public void setSpelernaam(String naam) {
        this.naam = naam;
    }
    public int getSpelerGeboortejaar() {
        return geboortejaar;
    }

    public void setSpelerGeboortejaar(int geboortejaar) {
        this.geboortejaar = geboortejaar;
    }
   

    public String getSpelerKleur() {
        return kleur;
    }

    public void setSpelerKleur(String kleur) {
        this.kleur = kleur;
    }
    
}
    

