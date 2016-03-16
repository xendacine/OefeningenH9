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
    private int xPositie;
    private int yPositie;
    private char schat;
    
    
    public Gangkaart(int draaihoek, int xPositie, int yPositie, char schat){
        this.draaihoek = draaihoek;
        this.xPositie = xPositie;
        this.yPositie = yPositie;
        this.schat = schat;
    }
    public Gangkaart(int draaihoek,int xPositie, int yPositie){
        this.draaihoek = draaihoek;
        this.xPositie = xPositie;
        this.yPositie = yPositie;
    }
    public int getDraaihoek() {
        return draaihoek;
    }

    public void setDraaihoek(int draaihoek) {
        this.draaihoek = draaihoek;
    }

    public int getxPositie() {
        return xPositie;
    }

    public void setxPositie(int xPositie) {
        this.xPositie = xPositie;
    }

    public int getyPositie() {
        return yPositie;
    }

    public void setyPositie(int yPositie) {
        this.yPositie = yPositie;
    }

    public char getSchat() {
        return schat;
    }

    public void setSchat(char schat) {
        this.schat = schat;
    }
    
    
    
    
}
