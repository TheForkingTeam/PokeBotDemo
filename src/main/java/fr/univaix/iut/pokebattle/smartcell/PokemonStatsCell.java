package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.func.PokeStats;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonStatsCell implements SmartCell{

	PokeStats m_pkst;
	
	public PokemonStatsCell(PokeStats pkmn) {
		m_pkst = pkmn;
	}
	
	public String ask(Tweet question) {
		if (question.getText().contains("#stat")) {
			if (question.getText().contains("#level")) {
				return "@" + question.getScreenName() + " #level=" + m_pkst.getLevel();
			}
		}
		return null;
	}

}
