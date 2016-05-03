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
    }
     public Gangkaart(int draaihoek){
        this.draaihoek = draaihoek;
     }
     public Gangkaart(){
         
     }
    public int getDraaihoek() {
        return draaihoek;
    }

    public void setDraaihoek(int draaihoek) {
        this.draaihoek = draaihoek;
    }


    public char getSchat() {
        return schat;
    }

    public void setSchat(char schat) {
        this.schat = schat;
    }
    
    
    
    
}
