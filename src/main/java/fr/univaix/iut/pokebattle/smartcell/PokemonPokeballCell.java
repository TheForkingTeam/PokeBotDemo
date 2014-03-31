package fr.univaix.iut.pokebattle.smartcell;


import fr.univaix.iut.pokebattle.func.PokeStats;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokemonPokeballCell implements SmartCell {

	PokeStats m_pkstat;

	public PokemonPokeballCell(PokeStats pkstat) {
		m_pkstat = pkstat;
	}

	public String ask(Tweet question) {

		// Test Pokeball    
		if (question.getText().contains("Pokeball!")) {
			//Tweet Pokeball NewOwner

			if (m_pkstat.getOwner() == null) {
				m_pkstat.setOwner(question.getScreenName());
				String caughtrep = "You caught me !";
				return caughtrep;
			}
			String Tweet ="@" + question.getScreenName() + " @" + m_pkstat.getOwner() + " is my owner!";
			return Tweet;
		}
		return "Wut ?";
	}
}
