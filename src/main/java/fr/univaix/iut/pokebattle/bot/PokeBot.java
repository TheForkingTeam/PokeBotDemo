package fr.univaix.iut.pokebattle.bot;

import fr.univaix.iut.pokebattle.smartcell.PokemonCriesCell;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokeBot implements Bot {
	
	String m_Name = "Forkachu";
	String m_Owner = "Rwog";
	
    private final SmartCell[] smartCells = new SmartCell[]{
            new PokemonCriesCell(m_Name, m_Owner),
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
    
    // Setters
    public void setOwner(String own) {m_Owner = own;} 
    
}
