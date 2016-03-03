/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;
import persistentie.SpelMapper;
import persistentie.SpelerMapper;

/**
 *
 * @author Sven V
 */
public class SpelerRepository {
    
    private final SpelerMapper mapper;
    private List<Speler> speler;
    
     public SpelerRepository() {
        mapper = new SpelerMapper();
        speler = new ArrayList<>();
    }
    
    public List<Speler> geefSpelers(int spelID){
        return mapper.geefSpelers(spelID);
    }
}
