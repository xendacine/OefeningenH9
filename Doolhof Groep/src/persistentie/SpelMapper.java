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
}