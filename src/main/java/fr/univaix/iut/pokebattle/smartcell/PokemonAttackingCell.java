package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.func.MatchExtractor;
import fr.univaix.iut.pokebattle.func.PokeStats;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAttackingCell implements SmartCell {

	PokeStats m_pkstat;
	
	public PokemonAttackingCell(PokeStats stats) {
		m_pkstat = stats;
	}
	
	
	@Override
	public String ask(Tweet question) {
		
		//Recup target
		MatchExtractor meuh = new MatchExtractor();
		String[] usess = meuh.matchExtract(question.getText(), "@");
		//usess[0] = le pkmn / usess[1] = la cible / usess[2] = owner de la cible
		if (question.getText().contains("#attack") && m_pkstat.getOwner() == question.getScreenName()) {
			return usess[1] + " #attack #foudre! /cc @"
					+ m_pkstat.getOwner() +" "+ usess[2] ;
		}
		return "@" + m_pkstat.getOwner() + " is my user";
		
	}

}
