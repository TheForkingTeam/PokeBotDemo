package fr.univaix.iut.pokebattle.bot;


import fr.univaix.iut.pokebattle.twitter.Tweet;

public class testConnex {
	public static void main(String[] args) {
		
		PokeBot pkmn = new PokeBot();
		pkmn.getPokeStats().setName("Forkachu");
		pkmn.getPokeStats().setRace("Pikachu");
		pkmn.getPokeStats().setHPmax(50);
		pkmn.getPokeStats().setHPcurr(10);
		
		System.out.println(pkmn.ask(new Tweet("RwogM","Pokeball!")));
	}

}