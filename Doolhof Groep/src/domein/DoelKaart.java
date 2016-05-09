/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.Iterator;

/**
 *
 * @author xendacine
 */
public class DoelKaart 
{
    
    public char schat1; 
    
    public DoelKaart(char schat){ 
       this.schat1 = schat;
    } /** dit is publieke constructor voor doelkaart met enkel meegegeven schat**/
   public char getSchat() {
        return schat1;
    } /** Get methode voor schat terug te krijgen  **/

    public void setSchat(char schat) {
        this.schat1 = schat;
    } /** set methode om een schat toe te wijzen aan een doelkaart**/
   
    
    @Override
    public String toString(){
        return "Doelkaart: "+schat1;
    }  /**verplichte toString die noodzakelijk is voor het weergeven van de doelkaarten bij het overzicht van de doelkaarten per speler**/
    }
    

