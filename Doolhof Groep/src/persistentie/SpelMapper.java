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
 }
     
     public Spel getSpel(String Spelnaam){
        Spel spel = null;

       try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM spel WHERE spelnaam = ?");
            query.setString(1, Spelnaam);

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
}
