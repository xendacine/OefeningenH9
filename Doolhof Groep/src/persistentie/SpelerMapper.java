/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Speler;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sven V
 */
public class SpelerMapper {
    
    public List<Speler> geefSpelers(){
          List<Speler> spelerlijst = new ArrayList<>();
           try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM speler");
            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {
                    String naam = rs.getString("naam");
                    

                    spelerlijst.add(new Speler(naam));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return spelerlijst;
    }
 
}
