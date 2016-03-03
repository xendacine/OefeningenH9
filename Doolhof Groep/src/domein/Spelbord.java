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
public class Spelbord {
    private Vak[][] bord;
    private String naam;
    
    public Spelbord(Vak[][] vakken) {
        this.bord = vakken;

    }
    
    public Spelbord(String naam){
        this.naam = naam;

    }
    public Spelbord() {
    }



    public Vak[][] getBord() {
        return bord;
    }
    public Vak[][] getVakken() {
        return bord;
    }

    public void setVakken(Vak[][] vakken) {
        this.bord = vakken;
    }


    public void setBord(Vak[][] bord) {
        this.bord = bord;
    }
}
