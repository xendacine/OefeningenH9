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
    
    public char schat;
    
    public DoelKaart(char schat){
       this.schat = schat;
    }
   public char getSchat() {
        return schat;
    }

    public void setSchat(char schat) {
        this.schat = schat;
    }
   
    
    @Override
    public String toString()
    {   
        return "Doelkaart:"+schat;
    }
    
    }
    

