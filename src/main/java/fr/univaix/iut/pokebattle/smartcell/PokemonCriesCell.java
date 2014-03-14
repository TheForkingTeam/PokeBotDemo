package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

/**
 * Reply to all.
 */
public class PokemonCriesCell implements SmartCell {

	String name;
	String owner; 
	
	// Chaînes déclenchant un cri de pokémon 
	public CharSequence[] HiSet = {"Salut","Wesh","wesh",
							 		"Bonjour","bonjour","salut", "au revoir",
							 		"bye", "Bye", "adieu", "Adieu", "Au revoir"};
	
	public PokemonCriesCell(String nam, String own) {
		name = nam;
		owner = own;
	}
	
    public String ask(Tweet question) {
        if (question.getScreenName() != null ) {
        	if (question.getText().equals("Owner?")) {
        		if (owner != null) {
        			return "@" + question.getScreenName() 
        					+ " @" + this.getDresseur() + " is my owner";
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

    // Getters
    public String getDresseur() {
    	return owner;
    }
    public String getPokemon() {
    	return name;
    }
}
