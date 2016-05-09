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
    private List<DoelKaart> doelkaarten = new ArrayList<>();;
    private DomeinController dc;
   
   
     public SpelerRepository() {
        mapper = new SpelerMapper();
        spelers = new ArrayList<Speler>();
       
    } /** Default constructor van SpelerRepository, gebruikt de attributen mapper en spelers **/
    
    public List<Speler> geefSpelers(int spelID){
        return mapper.geefSpelers(spelID);
    } /** geeft een lijst van spelerobjecten terug gebaseerd op de Id van het spel**/
     public List<Speler> geefSpelers(){
        return spelers;
    } /**  geeft gewoon een lijst van alle spelers in de database terug (exclusief het spelID)**/
    public int getAantalSpelers() {	return aantalSpelers; } /** geeft de hoeveelheid spelers terug van het spel**/

    public void setAantalSpelers(int aantal)
	{	
		if (aantal >= 2 && aantal <= 4)
			this.aantalSpelers = aantal;
		else 
			throw new IllegalArgumentException("invalidAantalSpelers");
	} /** stelt de hoeveelheid spelers in, het checkt dus hoeveel verschillende spelers we gaan ingeven dankzij de scanner met de vraag: geef aantal spelers in **/
        
     public void maakSpeler(String naam, int geboortejaar, String kleur, List<DoelKaart> doelkaarten) 
	{ 
                
                
                
		Speler speler = new Speler(naam,geboortejaar,kleur,doelkaarten);
		
		
                    
                    spelers.add(speler); } /** **/
                    
    /** maakt een speler aan voor een spel, niet een speler object maken, maar wel een speler in een spel met parameters naam, geboortejaar en kleur en doelkaarten
     *
     * @param naam
     * @return 
     */
    public boolean bestaatSpelerMetNaam(String naam) 
	{
		if(spelers.size() == 0)
			return false;

			for(Speler speler:spelers)		
			{
				if (speler.getSpelernaam().equals(naam))
					return true;
			}
			return false;
	}  /** Deze methode checkt of er al een speler bestaat met de naam die ingegeven wordt, zodat de database niet vastloopt bij het ophalen van spelers in een spel.**/
        
        public boolean bestaatKleur(String kleur) 
	{
		if(spelers.size() == 0)
			return false;

			for(Speler speler:spelers)		
			{
				if (speler.getSpelerKleur().equals(kleur))
					return true;
			}
			return false;
	}  /** Dezse methode checkt of het ingevoerde kleur ook een kleur is die toegelaten is, en of deze kleur nog niet bezet is**/ 
        
         public List<DoelKaart> getDoelkaarten() {
        return doelkaarten;
    } /** Geeft een lijst van alle doelkaarten terug**/

    public void setDoelkaarten(List<DoelKaart> doelkaarten) {
        this.doelkaarten = doelkaarten;
    } /** stelt in de lijst met doelkaarten de bepaalde doelkaarten in.**/
}
