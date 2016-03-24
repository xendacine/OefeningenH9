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

    

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }
    public Hoek(int draaihoek, int xPositie, int yPositie, char schat, String kleur) {
        super(draaihoek, xPositie, yPositie, schat);
        this.kleur = kleur;
    }
    public Hoek(int draaihoek, int xPositie, int yPositie, String kleur){
        super(draaihoek, xPositie, yPositie);
        setKleur(kleur);
    }
    public Hoek(int draaihoek, int xPositie, int yPositie){
        super(draaihoek, xPositie, yPositie);
    }
    
    @Override
    public String toString()
    {
        
        return "Hoekpunt"+getKleur();
    }
    
}
