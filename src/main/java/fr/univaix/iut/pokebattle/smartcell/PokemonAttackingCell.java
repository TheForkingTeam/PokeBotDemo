package fr.univaix.iut.pokebattle.smartcell;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import twitter4j.HashtagEntity;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.pokebattle.func.HashExtractor;

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
		HashExtractor hash = new HashExtractor();
		String[] hachis = hash.hashExtract(question);
		
		//Recup target
		Pattern patterntarget = Pattern.compile("@(\\w+)");
		Matcher matchertarget = patterntarget.matcher(question.getText());
		String targetname = "";
		while (matchertarget.find()) {
			targetname = matchertarget.group();
		}
		
		if (question.getText().contains("#attack") && powner == question.getScreenName()) {
			return targetname+" #attack #foudre! /cc @"+powner;
		}
		return "@"+powner+" is my user";
	}

}
