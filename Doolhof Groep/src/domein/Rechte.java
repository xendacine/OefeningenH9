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
public class Rechte extends Gangkaart {

    public Rechte(int draaihoek) {
        super(draaihoek);
       
    }/** Default constructor van Rechte met variabele Draaihoek
     * Deze constructor roept de default constructor uit Gangkaart aan 
     * Meer bepaald de constructor die volgend type aanmaakt: Gangkaart(int draaihoek)**/
    
    @Override
    public String toString()
    {   
        return "Rechte";
    } /** Verplichte toString methode, 
     * returnt gewoon de rechte **/
    
}
