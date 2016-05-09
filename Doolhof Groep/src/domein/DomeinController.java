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
    } /** public element van Domeincontroller die de locale veriabelen aanmaakt, 
     * (Lokaal opgeslagen element van de Spelers, en een lokale versie van de spelerrepository **/
    
  
   
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

    } /** Methode laadbestaandSpel, geeft array  van Strings terug die bestaan uit Spelnaam**/
   
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
   } /** Get methode getSpelers die een String-array terug geeft, hij geeft een array van spelerObjecten terug **/
   
   public void kiesTaal(int ingave){
       taal.kiesTaal(ingave);  
               } /** Nodig voor het ingeven van taal, men moet kijken naar de resourcebundles 
                * voor de bepaalde woorden weer te geven, gebaseerd op de output.**/
   
  
   public void wenstSpelAanTemaken(){
       spelbord = new Spelbord();
       spelerlijst = spelerRepo.geefSpelers();
       spel = new Spel(spelbord,spelerlijst);
       spel.maakDoelkaarten();
   }/** Methode die in actie treed op het moment dat speler kiest voor de optie:" Maak nieuw spel",
    * creeërt een lokale versie van een spel die we in een andere methode de mogelijkheid geven om te pushen naar de database
    * of zelfs op te slaan. Deze versie wordt niet opgeslaan op het moment dat het programma crasht/ afgesloten 
    * wordt voor dat de speler klikt op opslaan.**/
   
   public void maakSpelbord(){
      spel.maakSpelbord();
   } /** Maakspelbord creeërt een versie van 7*7 groot, die we later opvullen in een andere methode met gangkaarten. **/
   
   public String[][] toonSpelbord(){
     
      return spelbord.toonSpelbord();
   } /**  Geeft een visuele weergave terug van de 7*7 array van gangkaarten**/
   public void stelAantalSpelersIn(int aantal)
	{
		spelerRepo.setAantalSpelers(aantal);
	}/** Stelt de instellingen van de lokal Repository bij, 
         Meer bepaald het aantal spelers; dit is belangrijk voor verschillende testen mee uit te voeren voor de crashes bij verschillende delers bij 
         verschillende speleraantallen.
         De effectieve code bevindt zich in de klasse SpelerRepositoy**/ 
   
   public void maakSpeler(String naam,int geboortejaar, String kleur, List<DoelKaart> doelkaarten) 
	{
		spelerRepo.maakSpeler(naam,geboortejaar,kleur, doelkaarten);
	} /** Maakt een lokale / publieke speler aan (In de huidige status een lokale speler, die dan later gepushed kan worden naar de publieke database
         deze speler gaat verloren indien het programma vroegtijdig wordt agesloten / crasht zonder dat de gebruiker op opslaan heeft geklikt. 
         De effectieve code bevindt zich in de klasse SpelerRepository**/
  
   public void bepaalEersteSpeler(){
       spel.bepaalEersteSpeler();
   } /** Deze methode bepaalt de eerste speler gebaseerd op de geboortedatum, 
    de effectieve code bevindt zich in de klasse spel en wordt daar verder uitgewerkt. **/
   
   public List<Speler> geefOverzichtSpelers(){
       return spelerlijst = spel.bepaalSpelersVolgorde();
   } /** Deze methode werkt samen met de klasse spel, 
    zorgt voor een return List die bestaat uit speler-objecten. 
    Dit is belangrijk bij methodes die overzichten bepalen, en bij de GUI**/
  
   
    public Speler bepaalSpelerAanBeurt(int beurt)
    {
        return spel.bepaalSpelerAanBeurt(beurt);
    }/** dit is een DC methode die 
     De effectieve code bevindt zich in de klasse spel**/
     
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
    /** Kijkt of er niet al een speler bestaat met de naam X, 
     * ter validatie om duplicaten te vermijden**/
    
    
    public boolean bestaatKleur(String kleur){
        
    
    return spelerRepo.bestaatKleur(kleur);}/**Kijkt of de bepaalde kleur ook een mogelijkheid is die geselecteerd mag worden **/
    
    
    public List<DoelKaart> verdeelDoelkaarten(int aantalSpelers, int i){
        return spel.verdeelDoelkaarten(aantalSpelers, i);
    }/**Verdeelt de doelkaarten on de spelers **/
    
    public Gangkaart geefLosseGangkaart(){
        return spel.bepaalLosseGangkaart();
    }/** Geeft de enige losse gangkaart weer**/
    public void schuifGangkaartIn(Gangkaart losseGangkaart, int x , int y){
        spelbord.voegGangkaartIn(losseGangkaart, x, y);
    }/** Laat toe om de losse gangkaart in te voegen op coordinaten "X,Y" en zo te laten verschuiven**/
    
    public Gangkaart nieuweLosseGangkaart(){
        return spelbord.nieuweLosseGangkaart();
    }/** Bepaalt welke gangkaart er uit wordt geschoven, en stelt deze in als de nieuwe losse gangkaart, 
     * zodat de methode geeflossegangkaart deze terug kan weergeven **/
}