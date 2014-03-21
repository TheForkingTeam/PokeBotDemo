package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;
import fr.univaix.iut.pokebattle.smartcell.PokemonPokeballCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

import org.junit.Test;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.bot.PokeBot;

public class PokemonPokeballCellTest {

	
	PokeBot pkmn = new PokeBot();
	PokemonPokeballCell cell = new PokemonPokeballCell(pkmn);
	

	
	
	@Test
	public void testPokeballOnAlreadyCaught() {
		pkmn.setName("Forkachu");
		try {
			pkmn.setOwner("Rwog");
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		assertEquals("@needsob @Rwog is my owner!", cell.ask(new Tweet("needsob", "Pokeball!")));
	}

	@Test
	public void testPokeballOnWildPkmn() {
		pkmn.setName("Forkachu");
		try {
			pkmn.setOwner(null);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		assertEquals("You caught me !", cell.ask(new Tweet("needsob", "Pokeball!")));
	}
	
}
