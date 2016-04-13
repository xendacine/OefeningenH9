/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import domein.Speler;
import java.util.ArrayList;
import java.util.List;
import persistentie.SpelMapper;
import persistentie.SpelerMapper;

/**
 *
 * @author Sven V
 */
public class SpelerRepository {
    
    private final SpelerMapper mapper;
    private List<Speler> spelers;
    private int aantalSpelers;
    
     public SpelerRepository() {
        mapper = new SpelerMapper();
        spelers = new ArrayList<Speler>();
    }
    
    public List<Speler> geefSpelers(int spelID){
        return mapper.geefSpelers(spelID);
    }
     public List<Speler> geefSpelers(){
        return spelers;
    }
    public int getAantalSpelers() {	return aantalSpelers; }

    public void setAantalSpelers(int aantal)
	{	
		if (aantal >= 2 && aantal <= 4)
			this.aantalSpelers = aantal;
		else 
			throw new IllegalArgumentException("invalidAantalSpelers");
	}
        
     public void maakSpeler(String naam, int geboortejaar, String kleur) 
	{
		Speler speler = new Speler(naam,geboortejaar,kleur);
		
		if(!bestaatSpelerMetNaam(naam)) {
                    if(!bestaatKleur(kleur)){
                    
                    spelers.add(speler); }
                    else {
                        throw new IllegalArgumentException("Kleur is al gekozen!");
                    }
                }
		else 
			throw new IllegalArgumentException("dubbeleNaam");
	}
	
	private boolean bestaatSpelerMetNaam(String naam) 
	{
		if(spelers.size() == 0)
			return false;

			for(Speler speler:spelers)		
			{
				if (speler.getSpelernaam().equals(naam))
					return true;
			}
			return false;
	}  
        
        private boolean bestaatKleur(String kleur) 
	{
		if(spelers.size() == 0)
			return false;

			for(Speler speler:spelers)		
			{
				if (speler.getSpelerKleur().equals(kleur))
					return true;
			}
			return false;
	}   
}
