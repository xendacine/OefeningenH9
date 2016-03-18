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

    Kruising(int draaihoek, int xPositie, int yPositie, char schat) {
        super(draaihoek, xPositie, yPositie, schat);
        
        
    }
    @Override
    public char getSchat()
    {
        int randomNumber = 0 + (int)(Math.random() * ((23 - 0) + 1));
        char[] schatLijst = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        schat = schatLijst[randomNumber];
        return schat;
    }
    @Override
    public String toString()
    {
        return "Kruising"+getSchat();
    }
}
