package fr.univaix.iut.pokebattle.bot;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.func.Profile;
import fr.univaix.iut.pokebattle.smartcell.PokemonAttackingCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonCriesCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonPokeballCell;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokeBot implements Bot {
	
	String m_Name = "Forkachu";
	String m_Type = "Pikachu";
	String m_Owner = "Rwog";
	String m_Desc = "#pokebattle - #pokemon - ";
	
    private final SmartCell[] smartCells = new SmartCell[]{
            new PokemonCriesCell(this),
            new PokemonAttackingCell(this),
            new PokemonPokeballCell(this)
    };

    
    @Override
    public String ask(Tweet question) {
        for (SmartCell cell : smartCells) {
            String answer = cell.ask(question);
            if (answer != null) {
                return answer;
            }
        }
        return null;
    }

    // Getters 
    public String getName() {return m_Name;}
    public String getOwner() {return m_Owner;}
    public String getDescription() {return m_Desc; }
    
    // Setters
    public void setOwner(String own) throws TwitterException {
    	m_Owner = own; 
    	Profile.UpdateOwner(this, own);
    
    }
    public void setName(String nam) {m_Name = nam;}
    public void setDesc(String Desc) { m_Desc = Desc;}
}
