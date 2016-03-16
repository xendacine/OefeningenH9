/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sven V
 */
public final class Spel {
    private String spelnaam;
    private List<Speler> spelers;
    private Spelbord bord;
   // char[] schatlijst = {'a','b','c','d','e','f';'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public Spel(String spelnaam){
        
        setSpelnaam(spelnaam);
        
        
    }
    public Spel(Spelbord bord, List<Speler> spelerlijst ){
                this.bord = bord;
                this.spelers = spelerlijst;
    }
    
     public String getSpelnaam() {
        return spelnaam;
    }

    public void setSpelnaam(String spelnaam) {
        this.spelnaam = spelnaam;
    }
     public String[][] maakSpelbord(){
       
      String[][] bord1 = new String[7][7];
      
      List<Gangkaart> gangkaarten = new ArrayList<>();
      
     gangkaarten.add(new Hoek(0,0,0,'a',"geel"));
     gangkaarten.add(new Hoek(0,6,0,'b',"blauw")); 
     
       int x = 0;
        while (x < 7) {
            int y = 0;
            while (y < 7) {
                
               if(x == 0 && y==0){
                                   bord1[x][y] = gangkaarten.get(0).toString();
                                   //gangkaarten.add(new Hoek(0,x,y,'a',"geel"));
                                  
               }
               else if(x==6 && y==0){
                   bord1[x][y] = new Hoek(0,x,y,'a',"blauw").toString();
                                   gangkaarten.add(new Hoek(0,x,y,'b',"blauw"));
               }
                else if(x==0 && y==6){
                   bord1[x][y] = new Hoek(0,x,y,'a',"rood").toString();
                                   gangkaarten.add(new Hoek(0,x,y,'c',"rood"));
                                   
               }
                 else if(x==6 && y==6){
                   bord1[x][y] = new Hoek(0,x,y,'a',"groen").toString();
                                   gangkaarten.add(new Hoek(0,x,y,'d',"groen"));
               }
               else if(x%2 == 0 & y%2 ==0){
                                bord1[x][y] = "Tpunt";
                                gangkaarten.add(new Kruising(0,x,y,'e'));
                }
                
                else{
                    bord1[x][y] ="leeg";}
                     y++;
                }
                
                 x++;
               
            }
              return bord1;
            }
     
    
    
    
    
}
