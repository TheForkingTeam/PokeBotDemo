package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.func.PokeStats;
import fr.univaix.iut.pokebattle.twitter.Tweet;

/**
 * Reply to all.
 */
public class PokemonCriesCell implements SmartCell {

	PokeStats m_pksts;
	
	// Chaînes déclenchant un cri de pokémon 
	public CharSequence[] HiSet = {"Salut","Wesh","wesh",
							 		"Bonjour","bonjour","salut", "au revoir",
							 		"bye", "Bye", "adieu", "Adieu", "Au revoir"};
	
	public PokemonCriesCell(PokeStats pkstat) {
		m_pksts = pkstat;
	}
	
    public String ask(Tweet question) {
        if (question.getScreenName() != null ) {
        	if (question.getText().contains("Owner")) {
        		if (m_pksts.getOwner() != null) {
        			return "@" + question.getScreenName() 
        					+ " @" + m_pksts.getOwner() + " is my owner";
        			}
        			return "@" + question.getScreenName() 
        					+ " No owner";
        	}
        	for (int i = 0 ; i< HiSet.length; i++ ) {
        		if (question.getText().contains(HiSet[i]))
        			return "@" + question.getScreenName() + " Hay !";
        	}
        	return "@" + question.getScreenName() + " Wut ?";
        }
        return " Wut ?";
    }
}
