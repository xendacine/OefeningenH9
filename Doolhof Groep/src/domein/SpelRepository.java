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
    } /** Publieke constructor die een spelrepository aanmaakt **/
    
 
    public List<Spel> laadBestaandSpel(){
        return mapper.geefSpellen();
    } /** Dit geeft een lijst met spelen terug, om zo de bestaande spelen te kunnen selecteren en laden**/
    public Spel getSpel(String spelnaam)
    {
        Spel gevondenSpel = mapper.getSpel(spelnaam);

        return gevondenSpel;
    } /** om dan achteraf (na laadBestaandSpel() ) het gekozen spel terug te geven en de info te tonen  **/
}
