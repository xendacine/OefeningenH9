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
    private Gangkaart[][] bord;
    private String naam;
    
    public Spelbord(Gangkaart[][] kaarten) {
        this.bord = kaarten;

    }
    
    public Spelbord(String naam){
        this.naam = naam;

    }
    public Spelbord() {
    }



    public Gangkaart[][] getBord() {
        return bord;
    }
    public Gangkaart[][] getGangkaart() {
        return bord;
    }

    public void setGangkaarten(Gangkaart[][] kaarten) {
        this.bord = kaarten;
    }


    public void setBord(Gangkaart[][] bord) {
        this.bord = bord;
    }
    
    public void maakSpelbord(){
         String[][] bord1 = new String[7][7];
      
      int x = 0;
        while (x < 7) {
            int y = 0;
            while (y < 7) {
                if(x == 0 && y==0 || x==6 && y==0 || x==0 && y==6 || x==6 && y==6){
                      bord1[x][y] = "hoekpunt";}
                
                else if(x%2 == 0 & y%2 ==0){
                   bord1[x][y] = "Tpunt";
                    
                }
                
                else{
                    bord1[x][y] ="leeg";}
                     y++;
                }
                
                 x++;
               
            }

          
        }
    
}
