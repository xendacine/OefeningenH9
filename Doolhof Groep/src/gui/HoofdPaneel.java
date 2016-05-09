/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import javafx.scene.layout.HBox;

/**
 *
 * @author xendacine
 */
public class HoofdPaneel extends HBox
{
    private DomeinController dc;
    
    public HoofdPaneel(DomeinController dc)
    {
        this.dc = dc;
        buildGui();
    } /** Maakt de default constructor voor een hoofdpaneel aan te maken. **/
    
    private void buildGui()
    {
        DetailPaneel details = new DetailPaneel(dc);
        OverzichtPaneel overzicht = new OverzichtPaneel(dc, details);
        
        this.getChildren().addAll(overzicht, details);
    } /** zoals alle methodes, maakt een overzicht weer, en bouwt de grafische weergave van de gui **/
            
}
