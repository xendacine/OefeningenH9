/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sven V
 */
public final class Speler  {
    private String naam;
    private int geboortejaar;
    private String kleur;
    private List<DoelKaart> doelkaarten = new ArrayList<>();

   
    
    public Speler(String naam){
        setSpelernaam(naam);
    } /** Default constructor van Speler met parameter naam, deze methode stelt de spelernaam in via de methode setspelernaam**/
    
    /**
     * Default constructor van Speler met parameter naam, deze methode stelt de spelernaam in via de methode setspelernaam
     * @param naam
     * @param geboortejaar
     * @param kleur
     * @param Doelkaarten
     */
    public Speler(String naam, int geboortejaar, String kleur, List<DoelKaart> Doelkaarten){
        
        setSpelernaam(naam);
        setSpelerKleur(kleur);
        setSpelerGeboortejaar(geboortejaar);
        setDoelkaarten(Doelkaarten);
    } /** maakt een speler aan met alle parameters: Naam, geboortejaar, kleur, en doelkaarten
     * deze parameters worden allemaal toegewezen aan de hand van setmethodes.**/
    
    /**
     * maakt een speler aan met alle parameters: Naam, geboortejaar, kleur, en doelkaarten
     * deze parameters worden allemaal toegewezen aan de hand van setmethodes.
     * @return
     */
    public String getSpelernaam() {
        return naam;
    } /** Geeft fde spelernaam terug als een string**/

    /**
     * Geeft fde spelernaam terug als een string
     * @param naam
     */
    public void setSpelernaam(String naam) {
        this.naam = naam;
    } /** stelt de spelernaam in**/

    /**
     * stelt de spelernaam in
     * @return
     */
    public int getSpelerGeboortejaar() {
        return geboortejaar;
    } /** geeft de speler zijn geboortejaar terug in de vorm van een Int**/

    /**
     * geeft de speler zijn geboortejaar terug in de vorm van een Int
     * @param geboortejaar
     */
    public void setSpelerGeboortejaar(int geboortejaar) {
        this.geboortejaar = geboortejaar;
    } /** stelt de speler zijn geboortejaar in, achteraf wijzigen is niet meer mogelijk aangezien dit een final attribuut is. 
     * Mensen worden niet op 2 verschillende dagen geboren, indien de speler dit wenst te wijzigen moet hij een systeembeheerder contacteren**/
   
    /**
     * stelt de speler zijn geboortejaar in, achteraf wijzigen is niet meer mogelijk aangezien dit een final attribuut is.Mensen worden niet op 2 verschillende dagen geboren, indien de speler dit wenst te wijzigen moet hij een systeembeheerder contacteren
     * @return
     */
    public String getSpelerKleur() {
        return kleur;
    } /** geeft de spelerkleur terug in string vorm**/

    /**
     * geeft de spelerkleur terug in string vorm
     * @param kleur
     */
    public void setSpelerKleur(String kleur) {
        this.kleur = kleur;
    } /** laat toe om de speler een kleur toe te wijzen, dit is verplicht maar achteraf niet meer beschikbaar. Wordt niet meer aangeroepen in het programma achteraf wegens Final attribuut,
     * indien de speler van kleur wil wijzigen moet hij een systeembeheerder contacteren**/

    /**
     * laat toe om de speler een kleur toe te wijzen, dit is verplicht maar achteraf niet meer beschikbaar.Wordt niet meer aangeroepen in het programma achteraf wegens Final attribuut,
     * indien de speler van kleur wil wijzigen moet hij een systeembeheerder contacteren
     * @return
     */
    public List<DoelKaart> getDoelkaarten() {
        return doelkaarten;
    } /** geeft een lijst van doelkaarten terug die toebehoren bij een bepaalde speler **/

    /**
     * geeft een lijst van doelkaarten terug die toebehoren bij een bepaalde speler
     * @param doelkaarten
     */
    public void setDoelkaarten(List<DoelKaart> doelkaarten) {
        this.doelkaarten = doelkaarten;
    } /** laat toe om een group van doelkaarten toe te wijzen aan een speler, ook om doelkaarten een bepaalde schat te geven. 
     * Achteraf niet meer wijzigbaar door final attribuut**/
    
}
    

