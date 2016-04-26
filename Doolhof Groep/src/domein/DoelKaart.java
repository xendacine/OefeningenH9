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
    
    public char schat1;
    
    public DoelKaart(char schat){
       this.schat1 = schat;
    }
   public char getSchat() {
        return schat1;
    }

    public void setSchat(char schat) {
        this.schat1 = schat;
    }
   
    
    @Override
    public String toString(){
        return "Doelkaart: "+schat1;
    }
    }
    

