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
public class Hoek extends Gangkaart {
  private String kleur;
 private boolean heeftSchat = false;
    

    public String getKleur() {
        return kleur;
    }/** Returned de string Kleur, 
     * enkel als deze aanwezig is op de Gangkaart van type Hoek**/
    
    public void setKleur(String kleur) {
        this.kleur = kleur;
    }/** Methode die toelaat voor het instellen van de kleur op een lege gangkaart van het type Gangkaart() of Gangkaart(int draaihoek)
     * Dit is ook toegelaten op het type Gangkaart(int draaihoek, char schat), maar dat is dan enkel toeglaten indien deze kaarten geen 
     * vaste positie hebben op het spelbord 
    **/
    public Hoek(int draaihoek, char schat, String kleur) {
        super(draaihoek, schat);
        this.kleur = kleur;
        this.heeftSchat = true;
        
    }/** Dit is de constructor die een hoek aanmaakt die ook een kleur bevat en een schat, 
     * Deze kaart krijgt een extra variable nl. Boolean heeftSchat, dit is aangemaakt voor het vergemakkelijken van de verdere code in het programma**/
    
    public Hoek(int draaihoek, String kleur) {
        super(draaihoek);
        this.kleur = kleur;
        this.heeftSchat = false;
    }/** Dit is de constructor die een hoek aanmaakt zonder schat. 
     * Verschuifbaar of niet hangt af van de situatie**/
   
    
    @Override
    public String toString()
    {
        if(this.heeftSchat){
        return "Hoekpunt"+getKleur()+schat;
        }
        else{
            return "Hoekpunt"+getKleur();
        }
    }/** Verplichte toString methode die nodig is voor het verwerken van de uitvoer, 
     * hier geeft men de versie HoekPunt terug met kleur, en in het geval van this.heeftSchat = true geeft het ook de Char schat terug, 
     * dit is handig voor de spelers om te zien waar ze zich heen moeten bewegen als ze de bepaalde schat willen behalen uit hun doelkaarten**/
    
}
