/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;
import java.util.Random;
import domein.DoelKaart;


/**
 *
 * @author Sven V
 */
public class Kruising extends Gangkaart{

    Kruising(int draaihoek, char schat) {
        super(draaihoek, schat);
        
        
    } /** Constructor die een kruising aanmaakt met een Draaihoek en een schat 
     * Deze methode roept de Super-Constructor aan omdat er een identieke constructor aanwezig is in de klasse Gangkaart**/
    
    @Override
    public String toString()
    {   
        return "Kruising"+schat;
    } /** Verplichte tostring Methode
     * Geeft een kruising terug en een schat indien het een schat heeft**/ 
}
