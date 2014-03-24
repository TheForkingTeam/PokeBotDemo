package fr.univaix.iut.pokebattle.smartcell;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokemonPokeballCell implements SmartCell {
	
	PokeBot pkmn;
	
	public PokemonPokeballCell(PokeBot bot) {
		pkmn = bot;
	}
	
	public String ask(Tweet question) {

		// Test Pokeball    
		if (question.getText().contains("Pokeball!")) {
			
			//Tweet Pokeball NewOwner
			if (pkmn.getOwner() == null) {
				try {
					pkmn.setOwner(question.getScreenName());
				} catch (TwitterException e) {
					e.printStackTrace();
				}
				String caughtrep = "You caught me !";
				return caughtrep;
			}
	            	String Tweet ="@" + question.getScreenName() + " @" + pkmn.getOwner() + " is my owner!";
			return Tweet;
		}
		return "Wut ?";
	}
}
