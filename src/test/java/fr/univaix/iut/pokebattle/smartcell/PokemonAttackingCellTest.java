package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAttackingCellTest {

	String cible = "PkmnDumm";
	String name = "nedseb";
	String name2 = "Rwog";
	
	PokeBot pkmn = new PokeBot();
	
	PokemonAttackingCell cell = new PokemonAttackingCell(pkmn);
	@Test
	public void testAttackNonProprio() {
		assertEquals("@Rwog is my user", cell.ask(new Tweet("nedseb","@Forkachu #attack #foudre @"+cible)));
	}
	
	@Test
	public void testAttackProprio() {
		assertEquals("@"+cible+" #attack #foudre! /cc @Rwog", cell.ask(new Tweet("Rwog","@Forkachu #attack #foudre @"+cible)));
		System.out.println(cell.ask(new Tweet("Rwog","@Forkachu #attack #foudre @"+cible)));
	}

}
