package fr.univaix.iut.pokebattle.smartcell;

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
				pkmn.setOwner(question.getScreenName());
				String caughtrep = "You caught me !";
				return caughtrep;
			}
	            	String Tweet ="@" + question.getScreenName() + " @" + pkmn.getOwner() + " is my owner!";
			return Tweet;
		}
		return "Wut ?";
	}
}
