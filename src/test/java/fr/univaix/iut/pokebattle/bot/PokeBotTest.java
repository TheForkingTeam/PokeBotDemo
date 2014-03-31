package fr.univaix.iut.pokebattle.bot;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;

import twitter4j.TwitterException;

import static org.junit.Assert.assertEquals;

// Utilisation de diverses SmartCells pour voir si le Bot fonctionne.
public class PokeBotTest {
    PokeBot pokeBot = new PokeBot();

    @Test
    public void testSalut() throws IllegalStateException, TwitterException {
        assertEquals("@usertest Hay !", pokeBot.ask(new Tweet("usertest", "Salut, toi !")));
        assertEquals("@usertest Wut ?", pokeBot.ask(new Tweet("usertest","This is not a question.")));
    }
    
    
}
