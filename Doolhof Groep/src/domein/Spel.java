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
    public void maakSpelbord2()
        {   
        Gangkaart[][] bord = new Gangkaart[7][7];
        char[] shatLijst = {};
        int positieInLijst = 0;
        
        
        //alle hoekkaarten leggen (met kleurtjes)
        bord[0][0] = new Hoek(0,0,2,"geel");
        bord[0][6] = new Hoek(0,6,2,"groen");
        bord[6][0] = new Hoek(6,0,2,"blauw");
        bord[6][6] = new Hoek(6,6,2,"rood");



        //alle vaste kaarten leggen									//vaste kaarten liggen ook altijd op dezelfde plaats, dus kan
        bord[0][2] = new Kruising(0,0,2,'a');                                                           //je deze ook hard coderen (positie, draaihoek, enzoverder)
        bord[0][4] = new Kruising(0,0,4,'b');                                                           //je moet wel elke kaart nog een schat geven
																
        bord[2][0] = new Kruising(0,2,0,'c');								//nu kan je hier bij elke kaart, van bij de eerste te beginnen natuurlijk	
        bord[2][2] = new Kruising(0,2,2,'d');								//de volgende schat in de lijst toevoegen, door simpelweg schatLijst.get(positieInLijst);
        bord[2][4] = new Kruising(0,2,4,'e');								//op te roepen. Zo ga je telkens de volgende schat uit de geschudde lijst nemen, en
        bord[2][6] = new Kruising(0,2,6,'f');								//is het spel altijd random. niet vergeten om elke keer positieInLijst++ te doen, of 
                                                                                                        //je legt elke keer dezelfde schat
        bord[4][0] = new Kruising(0,4,0,'g');
        bord[4][2] = new Kruising(0,4,2,'h');
        bord[4][4] = new Kruising(0,4,4,'i');
        bord[4][6] = new Kruising(0,4,6,'j');

        bord[6][2] = new Kruising(0,6,2,'k');
        bord[6][4] = new Kruising(0,6,4,'l');

        //arraylist van de kaarten
        ArrayList kaarten = new ArrayList();                                                            //let op, voeg bij de 12 kaarten met schat nog de 
        kaarten.add(new Gangkaart(Kruising(0,1,2,'f'));                                                 // overige schatten toe uit de shattenlijst! 
        kaarten.add();                                                                                  //tot alle 34 losse kaarten erin zitten                
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        
        kaarten.add();
        kaarten.add();
        kaarten.add();
        kaarten.add();
        
        //dan pas alle losse kaarten leggen
        for(int i = 0; i < 7; i++){
	for(int j = 0; j < 7; j++){
		if(i%2 == 0){
			if(j%2 != 0){
				bord[i][j] = volgendeKaart;						//volgende kaart uit de kaarten arraylist, dit kan je eventueel
			}                                                                               //op dezelfde manier doen als bij de schattenlijst
		} else {
			bord[i][j] = volgendeKaart;
		}
	}
}


//nu heb je een compleet spelbord, waar alle schatten op het bord liggen
//de laatste (overblijvende) kaart uit de kaartenarray is de vrije gangkaart

        }
     public String[][] maakSpelbord(){
       
     //dit is een testdeel tot volgende comment om te zien hoe je die array moet aanmaken
        
    /* String[][] bord2 = new String[7][7];         
     int v = 0;
        while (v < 7) {
            int w = 0;
            while (w < 7) {
                
                if (((w%2 == 1 || v%2 == 1) && (v%2 != w%2))) 
                {
                    int draaihoek = 0 +(int)(Math.random() * ((3 - 0) + 1));
                    int randomNumber = 0 + (int)(Math.random() * ((23 - 0) + 1));
                    char[] schatLijst = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
                    char schat = schatLijst[randomNumber];
                    /*bord2[v][w] = new Kruising(draaihoek, v, w, schat).toString();
                   
                }
                else if(((v%2 == 1 && w%2==1))) {
//                    bord2[v][w] = gangkaarten2.get(3).toString();
                    
                }
                else{
                    bord2[v][w] = "leeg";}
                    w++;
                }
                    v++;
            }*/
        
        //tot hier om te testen hoe je dat moet doen voor die losse array aan te maken 
        String[][] bord1 = new String[7][7];
        
        char[] schatLijst = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x'};
        
        
        List<Gangkaart> gangkaarten = new ArrayList<>();
        
        /*gangkaarten.add(new Hoek(0,0,0,"geel"));
        gangkaarten.add(new Hoek(1,6,0,"blauw")); 
        gangkaarten.add(new Hoek(2,0,6,"rood"));
        gangkaarten.add(new Hoek(3,6,6,"groen"));*/
       
        int v = 0;
        while (v < 7) {
            int w = 0;
            while (w < 7) {
                    int draaihoek = 0 +(int)(Math.random() * ((3 - 0) + 1));
                    int randomNumber = 0 + (int)(Math.random() * ((schatLijst.length-1) + 1));
                    
                    char schat = schatLijst[randomNumber];
                
                if(v==0 && w==0){
                    gangkaarten.add(new Hoek(0,v,w,"geel"));
                }
               else if(v==6 && w==0){
                    gangkaarten.add(new Hoek(1,v,w,"blauw")); 
               }
                else if(v==0 && w==6){
                    gangkaarten.add(new Hoek(2,v,w,"rood"));
                                   
               }
                 else if(v==6 && w==6){
                    gangkaarten.add(new Hoek(3,v,w,"groen"));
               }
                
                 else if(v%2 == 0 & w%2 ==0){
                     
                         gangkaarten.add(new Kruising(draaihoek,v,w,schat));
                         
                         
                         
                         for(int i =  0; i< schatLijst.length ; i++){
                             if(schatLijst[i]==schat)
                                 break;
                            for (int t=i;t<schatLijst.length-1;t++){
                             schatLijst[t]=schatLijst[t+1];
                            } 
                             schatLijst = java.util.Arrays.copyOfRange(schatLijst,0, schatLijst.length-1);
                         
                     }
                 }
                
                 else {
                     gangkaarten.add(new Hoek(3,v,w,"leeg"));
                     int e = 0;
                     int c = 0;
                     int d = 0;
                     int f = 0;
                     int g = 0;
                     // c is de losse hoek teller zonder schat(10), d is de teller van de 6 hoeken met schat 
                             // e is de teller van de 12 rechte zonder schat
                             // f is de teller van de 6 t met schat 
                             // g is de maximale teller 34 stuks 
                     while (g<34) // totale lijst max 34 stuks
                     {
                         int h = 0 +(int)(Math.random() * ((3 - 0) + 1));// generate a random cyfer 0 tot en met 3
                         if(h==0 && c < 10)
                         {
                             gangkaarten.add(new Hoek(draaihoek, v,w, "leeg"));
                             c++;
                             g++;
                         }
                         else{
                             if(h==1 && d<6)
                             {
                                 gangkaarten.add(new Hoek(draaihoek,v,w,schat,"leeg"));
                                 d++;
                                 g++;
                             }
                             else{
                                 if(h==2 && e<12)
                                 {
                                     gangkaarten.add(new Rechte(draaihoek,v,w));
                                     e++;
                                     g++;
                                 }
                                 else{
                                     if(h==3 && f<6)
                                     {
                                         gangkaarten.add(new Kruising(draaihoek,v,w,schat));
                                         f++;
                                         g++;
                                     }
                                     
                                         
                                 }
                                 
                             }
                                 }// ander stukje als losse hoek over de 10 zit 
                     }
                 }
                 
                 
                      w++; 
                 }
                 
            v++;
            }
          
            
        

        int x = 0;
        while (x < 7) {
            int y = 0;
            while (y < 7) {
                 
                for(int i =0; i <gangkaarten.size(); i++){
                  if(x == gangkaarten.get(i).getxPositie() && y == gangkaarten.get(i).getyPositie()){
                                   bord1[x][y] = gangkaarten.get(i).toString();
                                   //gangkaarten.add(new Hoek(0,x,y,'a',"geel"));
               
                         }
                 /*else{
                    bord1[x][y] = gangkaarten.get(i).toString();}*/
                         }       
               /*else if(x==6 && y==0){
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
                }*/
                
                
                         
                     y++;
                     
                
            }
                 x++;
               
            }
              return bord1; // OPGELET MOET BORD 1 ZIJN VOOR METHODE NORMAAL TE LATEN LOPEN MAAR STAAT MOMENTEEL OP BORD2 VOOR ANDERE ARRAY TE TESTEN
              
              
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
    