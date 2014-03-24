package fr.univaix.iut.pokebattle.smartcell;

import twitter4j.HashtagEntity;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.func.MatchExtractor;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAttackingCell implements SmartCell {

	String pname;
	String powner;
	HashtagEntity[] hashtable;
	
	public PokemonAttackingCell(PokeBot pkmn) {
		pname = pkmn.getName();
		powner = pkmn.getOwner();
	}
	
	
	@Override
	public String ask(Tweet question) {
		
		//Recup target
		MatchExtractor meuh = new MatchExtractor();
		String[] usess = meuh.matchExtract(question, "@");
		System.out.println(usess[0] + usess[1] + usess[2]);
		//usess[0] = le pkmn / usess[1] = la cible / usess[2] = owner de la cible
		
		if (question.getText().contains("#attack") && powner == question.getScreenName()) {
			return usess[1]+" #attack #foudre! /cc @"+powner+" "+usess[2] ;
		}
		return "@"+powner+" is my user";
		
	}

}
