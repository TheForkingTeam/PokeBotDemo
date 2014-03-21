package fr.univaix.iut.pokebattle.func;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class HashExtractor {
	
	public String[] hashExtract (Tweet twt) {
			int indexhash = 0;
			String[] hashlist = new String[10];
			final Pattern pattern = Pattern.compile("/#(\\w*)/g");
			final Matcher matcher = pattern.matcher(twt.getText());
			while (matcher.find() && indexhash < 10) {
				hashlist[indexhash] = matcher.group();
				indexhash++;
			}
			return hashlist;
	}
}
