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
    }
    

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }
    public Hoek(int draaihoek, char schat, String kleur) {
        super(draaihoek, schat);
        this.kleur = kleur;
        this.heeftSchat = true;
        
    }
    
    public Hoek(int draaihoek, String kleur) {
        super(draaihoek);
        this.kleur = kleur;
    }
   
    
    @Override
    public String toString()
    {
        if(this.heeftSchat)
        return "Hoekpunt"+getKleur()+"schat";
        
        else{
            return "Hoekpunt"+getKleur();
        }
    }
    
}
