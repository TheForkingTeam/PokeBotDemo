package fr.univaix.iut.pokebattle.smartcell;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import fr.univaix.iut.pokebattle.func.MatchExtractor;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.iut.pokebattle.persistance.PokeStats;
public class PokemonAttackingCell implements SmartCell {

	PokeStats m_pkstat;
	Twitter m_tw;
	public PokemonAttackingCell(PokeStats stats, Twitter twt) {
		m_pkstat = stats;
		m_tw = twt;
	}


	@Override
	public String ask(Tweet question) {

		//Recup target
		MatchExtractor meuh = new MatchExtractor();
		String[] usess = meuh.matchExtract(question.getText(), "@");
		//usess[0] = le pkmn / usess[1] = la cible / usess[2] = owner de la cible

		if (question.getText().contains("#attack")) {
			System.out.println("in attack");
			if (m_pkstat.getOwner() == null) {
				System.out.println("in no user");
				return "@" + question.getScreenName()+ " Nobody can tell me what to do ! *middle finger*...*runs away*";
			}
			if ( m_pkstat.getOwner() != question.getScreenName()) {
				System.out.println("wrong user");
				System.out.println("getOwn :" + m_pkstat.getOwner());
				System.out.println("@+getScreen :" + "@"+question.getScreenName());
				return "@" + question.getScreenName() + " @" +m_pkstat.getOwner() + " is my user";
			}
			else {
				System.out.println("in ok user");
				return   usess[1] + " #attack #foudre! /cc @" + m_pkstat.getOwner() +" "+ usess[2] ;
			}

		}

		return "last_cell";

	}

}
