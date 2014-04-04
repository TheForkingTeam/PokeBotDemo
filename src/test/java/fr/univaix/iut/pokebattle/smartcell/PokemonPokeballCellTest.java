package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;
import fr.univaix.iut.pokebattle.smartcell.PokemonPokeballCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import fr.univaix.iut.pokebattle.bot.PokeBot;

public class PokemonPokeballCellTest {

	PokeBot pkmn = new PokeBot();
	
	public void setStat() {
		pkmn.getPokeStats().setName("Forkachu");
		pkmn.getPokeStats().setOwner("Rwog");
		pkmn.getPokeStats().setRace("Pikachu");
		try {
			pkmn.getPokeStats().setUser(pkmn.getTwit().showUser(pkmn.getTwit().getScreenName()));
		} catch (IllegalStateException | TwitterException e) {
			System.out.println("ERREUR SET STAT");
			e.printStackTrace();
		}
		pkmn.getPokeStats().setHPmax(50);
		pkmn.getPokeStats().setHPcurr(10);
	}
	
// Tests fonctionnels qui agissent directement sur le compte Twitter
// Donc il vaut mieux les laisser en commentaire sinon ils se lancent
// à chaque sauvegarde par eclipse.
//	
//	@Test
//	public void testPokeballOnAlreadyCaught() {
//		setStat();
//		assertEquals("@needsob @Rwog is my owner!", cell.ask(new Tweet("needsob", "Pokeball!")));
//	}

//	@Test
//	public void testPokeballOnWildPkmn() {
//		setStat();
//		
//		pkmn.getPokeStats().setOwner(null);
//		assertEquals("You caught me !", pkmn.ask(new Tweet("needsob", "Pokeball!")));
//	}	
}
