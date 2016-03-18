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
       
     //dit is een testdeel tot volgende comment om te zien hoe je die array moet aanmaken
        
     String[][] bord2 = new String[7][7];         
     int v = 0;
        while (v < 7) {
            int w = 0;
            while (w < 7) {
                
                if (((w%2 == 1 || v%2 == 1) && (v%2 != w%2))) 
                {
                    int draaihoek = 0 +(int)(Math.random() * ((3 - 0) + 1));
                    int randomNumber = 0 + (int)(Math.random() * ((23 - 0) + 1));
//                    String[] schatLijst = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
//                    String schat = schatLijst[randomNumber];
                    char[] schatLijst = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
                    char schat = schatLijst[randomNumber];
                    bord2[v][w] = new Kruising(draaihoek, v, w, schat);   // fix even dit zodat dit werkt ty 
                   
                }
                else if(((v%2 == 1 && w%2==1))) {
//                    bord2[v][w] = gangkaarten2.get(3).toString();
                    
                }
                else{
                    bord2[v][w] = "leeg";}
                    w++;
                }
                    v++;
            }
        
        //tot hier om te testen hoe je dat moet doen voor die losse array aan te maken 
        String[][] bord1 = new String[7][7];
      
        List<Gangkaart> gangkaarten = new ArrayList<>();
      
        gangkaarten.add(new Hoek(0,0,0,'a',"geel"));
        gangkaarten.add(new Hoek(0,6,0,'b',"blauw")); 
        gangkaarten.add(new Hoek(0,0,6,'c',"rood"));
        gangkaarten.add(new Hoek(0,6,6,'d',"groen"));
        int x = 0;
        while (x < 7) {
            int y = 0;
            while (y < 7) {
                
               if(x == 0 && y==0){
                                   bord1[x][y] = gangkaarten.get(0).toString();
                                   //gangkaarten.add(new Hoek(0,x,y,'a',"geel"));
                                  
               }
               else if(x==6 && y==0){
                   bord1[x][y] = gangkaarten.get(1).toString();
                                  // gangkaarten.add(new Hoek(0,x,y,'b',"blauw"));
               }
                else if(x==0 && y==6){
                   bord1[x][y] = gangkaarten.get(2).toString();
                                   //gangkaarten.add(new Hoek(0,x,y,'c',"rood"));
                                   
               }
                 else if(x==6 && y==6){
                   bord1[x][y] = gangkaarten.get(3).toString();
                                   
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
              return bord2; // OPGELET MOET BORD 1 ZIJN VOOR METHODE NORMAAL TE LATEN LOPEN MAAR STAAT MOMENTEEL OP BORD2 VOOR ANDERE ARRAY TE TESTEN
              
              
            }
}           // gelive even af te blijven ty heb dit zeker en vast nog nodig! 
//    // poging voor de variable hoeken
//     public String[][] maakVariableKaarten()
//     {
//         String[][] bord2 = new String[7][7];
//         
//         List<Gangkaart> gangkaarten = new ArrayList<>();
//         gangkaarten.add(new Hoek(0,0,0,'a',"geel"));
//         gangkaarten.add(new Hoek(0,6,0,'b',"blauw")); 
//         gangkaarten.add(new Hoek(0,0,6,'c',"rood"));
//         gangkaarten.add(new Hoek(0,6,6,'d',"groen"));
//     int v = 0;
//        while (v < 7) {
//            int w = 0;
//            while (w < 7) {
//                
//                if (((w%2 == 1 || v%2 == 1) && (v%2 != w%2))) 
//                {
//                    bord2[v][w] = gangkaarten.get(1).toString();
//                }
//                else if(((v%2 == 1 && w%2==1))) {
//                    bord2[v][w] = gangkaarten.get(2).toString();
//                    
//                }
//                else{
//                    bord2[v][w] = "leeg";}
//                    w++;
//                }
//                    v++;
//            }
//        return bord2;
//        }
//     }
//    
//    

