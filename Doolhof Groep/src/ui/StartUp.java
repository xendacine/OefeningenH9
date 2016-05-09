/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import domein.Taal;

/**
 *
 * @author Sven V
 */
public class StartUp {
    
    public static void main(String[] args) 
	{	
                DomeinController dc = new DomeinController();
                Taal taal = new Taal();
                DoolhofApp app = new DoolhofApp(dc,taal);
	} /** Start ook de gewone versie op??**/
}
