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
        
        
    }
    
    @Override
    public String toString()
    {   
        return "Kruising";
    }
}
