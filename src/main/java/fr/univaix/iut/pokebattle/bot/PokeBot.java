package fr.univaix.iut.pokebattle.bot;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import fr.univaix.iut.pokebattle.func.*;
import fr.univaix.iut.pokebattle.smartcell.*;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokeBot implements Bot {
	private Twitter m_Twit;
	private PokeStats m_Stats;

	public PokeBot() {
		m_Stats = new PokeStats();
	}

	private final SmartCell[] smartCells = new SmartCell[]{
			new PokemonCriesCell(m_Stats),
			new PokemonAttackingCell(m_Stats),
			new PokemonPokeballCell(m_Stats),
			new PokemonKOAlertCell(m_Stats),
	};


	@Override
	public String ask(Tweet question) {
		for (SmartCell cell : smartCells) {
			String answer = cell.ask(question);
			if (answer != null) {
				return answer;
			}
		}
		return null;
	}

	// Getters 
	public String getName() {return m_Stats.getName();}
	public String getOwner() {return m_Stats.getOwner();}
	public int getHPmax() {return m_Stats.getHPmax();}
	public int getHPcurr() {return m_Stats.getHPcurr();}
	public Twitter getTwit() {return m_Twit;}
	
	public PokeStats getPokeStats() {return m_Stats;}
	

	// Setters
	public void setTwitter(Twitter twit) {
		try {
			m_Twit = twit;
			MatchExtractor match = new MatchExtractor();
			User usr = twit.showUser(twit.getScreenName());

			m_Stats.setName(twit.getScreenName());

			m_Stats.setOwner(match.matchExtract(usr.getDescription(), "@")[0]);
			m_Stats.setRace("Pikachu");
			m_Stats.setHPmax(50);
			m_Stats.setHPcurr(49);
		} catch (IllegalStateException | TwitterException e) {
			System.out.println("Problème setTwitter() !");
			e.printStackTrace();
		}
	}

}
