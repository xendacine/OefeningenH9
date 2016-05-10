/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Spel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domein.*;
import domein.SpelerRepository;

/**
 *
 * @author Sven V
 */
public class SpelMapper {
    
    

     public List<Spel> geefSpellen(){
          List<Spel> spellijst = new ArrayList<>();
          try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT spelnaam FROM spel");
           
            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {
                    
                    String spelnaam = rs.getString("spelnaam");
                    
                    Spel gevondenSpel = new Spel(spelnaam);

                   spellijst.add(gevondenSpel);
                }
            }
        }catch(SQLException e)
		{
			e.printStackTrace();
		}

        

        return spellijst;
 } /** De mapper geeft hier een lijst met alle spellen terug**/
     
    /**
     * De mapper geeft hier een lijst met alle spellen terug
     * @param Spelnaam
     */
    public Spel getSpel(String Spelnaam){
        Spel spel = null;
        
        
       try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM spel WHERE spelnaam = ?");
            query.setString(1, Spelnaam);
            
            slaSpelersOp();
            try (ResultSet rs = query.executeQuery()) {

                if (rs.next()) {
                    String spelnaam = rs.getString("spelnaam");

                    spel = new Spel(spelnaam);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Fout RuntimeException in de SpelMapper (methode = geefSpel)");
           
        }
         
        return spel;
     } 
     /** Selecteert 1 spel gebaseerd op spelnaam en geeft het spelobject terug **/
    public void slaSpelersOp()
    {
        int speleraantal = SpelerRepository.getAantalSpelers();
//        String spelerNaam1 = "testje";
//        String spelerNaam2 = "testke";
//        String spelerNaam3 = "testjek";
//        int spelID = 3;
//        String kleur1 = "groen";
//        String kleur2 = "rood";
//        String kleur3 = "blauw";
//        int DoelkaartID1 = 2;
//        int DoelkaartID2 = 3;
//        int DoelkaartID3 = 5;
        // gebruikt voor tijdelijke test
        int i=0;
        while(i<= domein.SpelerRepository.getAantalSpelers())
        {
             try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
                PreparedStatement insertSpelerData;
                insertSpelerData = conn.prepareStatement("INSERT INTO speler VALUES (?,?,?,?)");
                insertSpelerData.setString(1, domein.Speler.getSpelernaam());
                insertSpelerData.setInt(2, domein.Spel.getspelID);
                insertSpelerData.setString(3, domein.Speler.getSpelerKleur());
                insertSpelerData.setInt(4, domein.Speler.geefDoelkaarten()); 
                insertSpelerData.executeQuery();
         } catch (SQLException ex) {
             System.err.println("er liep iets fout met de database");
         }
             i++;
        }
//        PreparedStatement insertSpelerData = conn.prepareStatement("INSERT INTO speler VALUES (?, ?, ?, ?");
//        insertSpelerData.setString(1, spelerNaam1);
//        insertSpelerData.setInt(2, spelID);
//        insertSpelerData.setString(3, kleur1);
//        insertSpelerData.setInt(4, DoelkaartID1);
    }
    public void positiegangkaart(int idgangkaart, int draaihoek, boolean schat, int idspelbord, int x, int y){
        try (Connection conn = DriverManager.getConnection (Connectie.JDBC_URL)){
            PreparedStatement posGangOpBord = conn.prepareStatement("SELECT idgangkaart, draaihoek, schat,idspelbord, xpositie, ypositie "
                    + "FROM gangkaart"
                    + "JOIN spelbord ON spelbord.gangkaart_idgangkaart = gangkaart.idgangkaart" 
                    );
            posGangOpBord.setInt(1, idgangkaart);
            posGangOpBord.setInt(2,draaihoek);
            posGangOpBord.setBoolean(3, schat);
            posGangOpBord.setInt(4, idspelbord);
            posGangOpBord.setInt(5, x);
            posGangOpBord.setInt(6, y);
            posGangOpBord.executeQuery();
            
            
        }
        catch (SQLException ex){
            System.err.println("Er liep iets fout met de database");
        }
    }
    public void positieSpeler(String naam, String kleur, String spelnaam, int x, int y, int idspelbord ){
       try (Connection conn = DriverManager.getConnection (Connectie.JDBC_URL)){
            PreparedStatement posSpelerOpBord = conn.prepareStatement("select speler.naam, speler.kleur, spel.spelnaam, spelbord.x, spelbord.y, spelbord.idspelbord\n" +
"from speler\n" +
"JOIN spel ON speler.spelID = spel.spelID\n" +
"JOIN spelbord ON spel.spelID = spelbord.spelbord_spelID" 
                    );
            posSpelerOpBord.setString(1, naam);
            posSpelerOpBord.setString(2, kleur);
            posSpelerOpBord.setString( 3, spelnaam);
            posSpelerOpBord.setInt(4, x);
            posSpelerOpBord.setInt(5, y);
            posSpelerOpBord.setInt(6, idspelbord);
            posSpelerOpBord.executeQuery();
            
        }
        catch (SQLException ex){
            System.err.println("Er liep iets fout met de database");
        }
    }
       public void spelerAanDeBeurt(String naam, boolean aanDeBeurt){
           try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
                PreparedStatement beurt = conn.prepareStatement("SELECT * FROM speler");
                beurt.setString(1, naam );
                beurt.setBoolean(2, aanDeBeurt );
                beurt.executeQuery();
                
                 
                beurt.executeQuery();
         } catch (SQLException ex) {
             System.err.println("er liep iets fout met de database");
         }
       
    }
      public void geboortejaar (String naam, int geboortjeaar){
          try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT naam, geboortejaar from speler ");
            query.setString(1, naam);
            query.setInt(2, geboortjeaar);
            query.executeQuery();
            
            
            
        } catch (SQLException ex) {
            System.err.println("Fout RuntimeException in de SpelMapper (methode = geefSpel)");
           
        }
      }
      public void keuzeTaal (String naam, String taal){
          try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT naam, taal from speler JOIN spel ON speler.spelID = spel.spelID ");
            query.setString(1, naam);
            query.setString(2, taal);
            query.executeQuery();
            
            
            
        } catch (SQLException ex) {
            System.err.println("Fout RuntimeException in de SpelMapper (methode = geefSpel)");
           
        }
      }
          public void aantalBeurten (String spelnaam, int aantalBeurten){
              
          try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT naam, geboortejaar from speler ");
            query.setString(1, spelnaam);
            query.setInt(2, aantalBeurten);
            query.executeQuery();
            
            
            
        } catch (SQLException ex) {
            System.err.println("Fout RuntimeException in de SpelMapper (methode = geefSpel)");
           
        }
      }
          public void vrijeGangkaartBijSpeler (String naam, int spelID, int idspelbord, int idgangkaart){
          try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("select speler.naam, spel.spelID, spelbord.idspelbord, gangkaart.idgangkaart\n" +
"from speler\n" +
"JOIN spel ON speler.spelID = spel.spelID\n" +
"JOIN spelbord ON spel.spelID = spelbord.idspelbord\n" +
"JOIN gangkaart ON spelbord.idGangkaart = gangkaart.idgangkaart ");
            query.setString(1, naam);
            query.setInt(2, spelID);
            query.setInt(3, idspelbord);
            query.setInt(4, idgangkaart);
            query.executeQuery();
            
            
            
        } catch (SQLException ex) {
            System.err.println("Fout RuntimeException in de SpelMapper (methode = geefSpel)");
           
        }
      }
          public void spelbord_spel (int spelID, String spelnaam, int spelbord_spelID){
          try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("select spel.spelID, spel.spelnaam, spelbord.spelbord_spelID\n" +
"from spel\n" +
"JOIN spelbord ON spelbord.spelbord_spelID = spel.spelID ");
            query.setInt(1, spelID);
            query.setString(2, spelnaam);
            query.setInt(3, spelbord_spelID);
            
            query.executeQuery();
            
            
            
        } catch (SQLException ex) {
            System.err.println("Fout RuntimeException in de SpelMapper (methode = geefSpel)");
           
        }
      }
          
          public void normalisatieSpelbord (int idspelbord, int x, int y, int idGangkaart){
          try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("select spelbord.idspelbord, spelbord.x, spelbord.y, spelbord.idGangkaart\n" +
"from spelbord ");
            query.setInt(1, idspelbord);
            query.setInt(2, x);
            query.setInt(3, y);
            query.setInt(4, idGangkaart);
            
            query.executeQuery();
            
            
            
        } catch (SQLException ex) {
            System.err.println("Fout RuntimeException in de SpelMapper (methode = geefSpel)");
           
        }
      } 
          public void normalisatieSpeler(String naam, String kleur, int idDoelkaart, int spelID){
              try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("select naam, kleur,  Doelkaart.idDoelkaart, spel.spelID\n" +
"from speler\n" +
"JOIN Doelkaart ON Doelkaart.idDoelkaart = speler.doelkaartID\n" +
"JOIN spel ON spel.spelID = speler.spelID");
            query.setString(1, naam);
            query.setString(2, kleur);
            query.setInt(3, idDoelkaart);
            query.setInt(4, spelID);
            
            query.executeQuery();
            } catch (SQLException ex) {
            System.err.println("Fout RuntimeException in de SpelMapper (methode = geefSpel)");
           
        }
          }
          public void normalisatieRechte(int idgangkaart, int draaihoek, boolean schat){
               try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("select idgangkaart, draaihoek, gangkaart.schat\n" +
"from gangkaart\n" +
"JOIN rechte ON gangkaart.idgangkaart = rechte.gangkaart_idgangkaart");
            query.setInt(1, idgangkaart);
            query.setInt(2, draaihoek);
            query.setBoolean(3, schat);
   
            
            query.executeQuery();
            } catch (SQLException ex) {
            System.err.println("Fout RuntimeException in de SpelMapper (methode = geefSpel)");
           
        }
          }
          public void normalisatieKruising(int kidgangkaart, int draaihoek, boolean schat){
               try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("select kidgangkaart, draaihoek, gangkaart.schat\n" +
"from gangkaart\n" +
"JOIN kruising ON gangkaart.idGangkaart = kruising.kIdGangkaart");
            query.setInt(1, kidgangkaart);
            query.setInt(2, draaihoek);
            query.setBoolean(3, schat);
   
            
            query.executeQuery();
            } catch (SQLException ex) {
            System.err.println("Fout RuntimeException in de SpelMapper (methode = geefSpel)");
           
        }
          }
          public void normalisatieHoek(int hidgangkaart, int draaihoek, boolean schat){
                 try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("select hidgangkaart, draaihoek, gangkaart.schat\n" +
"from gangkaart\n" +
"JOIN hoek ON gangkaart.idgangkaart = hoek.hIdGangkaart");
            query.setInt(1, hidgangkaart);
            query.setInt(2, draaihoek);
            query.setBoolean(3, schat);
   
            
            query.executeQuery();
            } catch (SQLException ex) {
            System.err.println("Fout RuntimeException in de SpelMapper (methode = geefSpel)");
           
        }
          }
}
}