//package fr.univaix.iut.pokebattle.bot;
//
//import fr.univaix.iut.pokebattle.func.MatchExtractor;
//import twitter4j.*;
//
//public class testConnex {
//	public static void main(String[] args) {
//		
//		Twitter twit = new TwitterFactory().getSingleton();
//		User usr = null;
//		try {
//			usr = twit.showUser(twit.getScreenName());
//		} catch (IllegalStateException | TwitterException e) {
//			System.out.println("E1");
//			e.printStackTrace();
//		}
//		System.out.println(usr.getScreenName());
//		System.out.println(usr.getDescription());
//		System.out.println(usr.getURL());
//		
//		MatchExtractor meuh = new MatchExtractor();
//		System.out.println(meuh.matchExtract(usr.getDescription(),"@")[0]);
//	
//		try {
//			PokeBot pkmn = new PokeBot();
//			System.out.println(pkmn.getName());
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//
//}