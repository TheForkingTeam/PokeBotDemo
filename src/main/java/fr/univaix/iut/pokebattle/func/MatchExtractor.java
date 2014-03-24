package fr.univaix.iut.pokebattle.func;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class MatchExtractor {

	
	// Extrait les mots précédés du caractère donné en paramètre
	// Ex: # pour les hashtags, @ pour les users
	public String[] matchExtract (Tweet twt, String charr) {
			String regexp = charr + "(\\w+)" ;
			int indexhash = 0;
			System.out.println("Tweet reçu : " +twt);
			String[] reslist = new String[10];
			System.out.println("Regexp utilisée : "+regexp);
			Pattern pattern = Pattern.compile(regexp);
			Matcher matcher = pattern.matcher(twt.getText());
			System.out.println("Searching...");
			
			while (matcher.find() && indexhash < 10) {
				System.out.println("Found "+matcher.group());
				reslist[indexhash++] = matcher.group();
				
			}			
			return reslist;
			
			
	}
}