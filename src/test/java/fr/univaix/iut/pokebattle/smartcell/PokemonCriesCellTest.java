package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonCriesCellTest {
	
	String usertest = "nedseb"; 
    PokemonCriesCell cell = new PokemonCriesCell("Forkachu", "Rwog");

    @Test
    public void testSalut() {
        assertEquals("@"+usertest+" Hay !", cell.ask(new Tweet(usertest, "Hey salut!")));
    }

    @Test
    public void testNotSalut() {
       assertEquals("@"+usertest+" Wut ?", cell.ask(new Tweet(usertest, "N'importe quoi")));
    }
    
    @Test
    public void testReturnNomEleveur() {
    	assertEquals("@"+usertest+" @Rwog is my owner", cell.ask(new Tweet(usertest, "Owner?")));
    }

}
