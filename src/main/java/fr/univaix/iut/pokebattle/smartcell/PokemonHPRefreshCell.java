package fr.univaix.iut.pokebattle.smartcell;

import java.util.Calendar;

import fr.univaix.iut.pokebattle.func.PokeStats;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonHPRefreshCell implements SmartCell {

	PokeStats m_pkmn;
	
	public PokemonHPRefreshCell(PokeStats pk) {
		m_pkmn = pk;
	}

	@Override
	public String ask(Tweet question) {
		long cal = (((Calendar.getInstance().getTime().getTime()/1000))/60);
		long timlast = (((m_pkmn.getLastDate().getTime())/1000)/60);
		long waited = timlast - cal;
		
		if (waited >= 1) {
			// Regen 10% HP
			m_pkmn.setHPcurr((int)Math.round((m_pkmn.getHPmax()*0.1)));
			// Met au max si pv supérieurs au max
			if (m_pkmn.getHPcurr() > m_pkmn.getHPmax())
				m_pkmn.setHPcurr(m_pkmn.getHPmax());
		}
		
		return "next_cell";
	}
}
