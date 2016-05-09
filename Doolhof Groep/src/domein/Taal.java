/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Sven V
 */
public class Taal {
    private ResourceBundle tekst; 	

	public void kiesTaal(int ingave) throws IllegalArgumentException
	{	
		switch(ingave) 
		{
			case 1: tekst = ResourceBundle.getBundle
					("resourcebundles.Resource", new Locale("nl")); break;
			case 2: tekst = ResourceBundle.getBundle
					("resourcebundles.Resource", new Locale("fr")); break;
			case 3: tekst = ResourceBundle.getBundle
					("resourcebundles.Resource", new Locale("en")); break;
			default: throw new IllegalArgumentException
					("Gelieve een geldige keuze in te geven!		" +
					 "Veuillez entrez un choix valable!		" +
					 "Please enter a valid choice!");
		}
	} /** Dit is de methode die toelaat dat de gebruiker in het begin van het programma een taal kiest, 
         * momenteel enkel in console versie want GUI loopt achter op schema doordat ik werk moet overnemen van andere groepsleden**/
	public ResourceBundle getTekst() { return tekst; } /** geeft de tekst weer uit de resourcebundles die overeenkomt met de bepaalde woorden**/
	public void setTekst(ResourceBundle tekst) { this.tekst = tekst; } /** stelt de taal in en geeft de juiste bijhorende tekst weer**/
}


