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
public abstract class Gangkaart {
    private int draaihoek;
    
    public char schat; 
    
    
    public Gangkaart(int draaihoek, char schat){
        this.draaihoek = draaihoek;
        
        this.schat = schat;
    } /** Constructor om Gangkaart met 2 variabelen: draaihoek en schat
     Dit is nodig voor een Gangkaart met een draaihoek EN een schat**/
     public Gangkaart(int draaihoek){
        this.draaihoek = draaihoek;
     } /** Constructor om Gangkaart object aan te maken met 1 variablem: draaihoek; 
      dit is nodig voor een gangkaart zonder schat, maar met een verplichte draaihoek **/
     public Gangkaart(){
         
     }/** Dit is de default constructor voor Gangkaart zonder parameters, 
      noodzakelijk voor het aanmaken van een gangkaart terwijl ze nog niet in het spelbord zit, 
      * dus een leeg object voor instel-doeleinden**/
    public int getDraaihoek() {
        return draaihoek;
    } /** Get methode die de draaihoek returned van de volgende 2 types Gangkaarten
     1:Gangkaart(int draaihoek, char schat)
     2:Gangkaart(int draaihoek)
     
     Maar niet van het type gangkaart:
     1:Gangkaart()**/

    public void setDraaihoek(int draaihoek) {
        this.draaihoek = draaihoek;
    }/** Stelt de draaihoek in voor Gangkaartobjecten**/


    public char getSchat() {
        return schat;
    }/** Geeft de char Schat terug van de gangkaarten die opgemaakt zijn volgens volgend type:
     Gangkaart(int draaihoek, char schat)
     
     Niet mogelijk bij de andere 2 types gangkaarten**/

    public void setSchat(char schat) {
        this.schat = schat;
    }/** Geeft de mogelijkheid om een GangkaartObject een variable schat mee te geven **/
    
    
    
    
    
}
