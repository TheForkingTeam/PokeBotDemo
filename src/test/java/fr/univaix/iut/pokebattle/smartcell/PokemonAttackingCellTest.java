package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAttackingCellTest {

	String cible = "PkmnDummy";
	String cibleown = "needsob";

	PokeBot pkmn = new PokeBot();
	
	public void setStat() {
		pkmn.getPokeStats().setName("Forkachu");
		pkmn.getPokeStats().setOwner("Rwog");
		pkmn.getPokeStats().setRace("Pikachu");
		pkmn.getPokeStats().setHPmax(50);
		pkmn.getPokeStats().setHPcurr(10);
	}
	
	@Test
	public void testAttackNonProprio() {
		setStat();
		assertEquals("@Rwog is my user", pkmn.ask(new Tweet("nedseb","@Forkachu #attack #foudre @"+cible)));
		
	}
	
	@Test
	public void testAttackProprio() {
		setStat();
		assertEquals("@"+cible+" #attack #foudre! /cc @Rwog @needsob", pkmn.ask(new Tweet("Rwog","@Forkachu #attack #foudre @"+cible+" /cc @"+cibleown)));
	}

}
