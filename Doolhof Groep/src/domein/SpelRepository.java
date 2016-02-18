/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;
import persistentie.SpelMapper;

/**
 *
 * @author Sven V
 */
public class SpelRepository {
    
     private final SpelMapper mapper;
    private List<Spel> spel;
    
    public SpelRepository() {
        mapper = new SpelMapper();
        spel = new ArrayList<>();
    }
    
 
    public List<Spel> geefSpellen(){
        return mapper.geefSpellen();
    }
    public Spel getSpel(String spelnaam)
    {
        Spel gevondenSpel = mapper.getSpel(spelnaam);

        return gevondenSpel;
    }
}
