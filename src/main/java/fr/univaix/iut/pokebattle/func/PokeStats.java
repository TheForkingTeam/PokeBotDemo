package fr.univaix.iut.pokebattle.func;

public class PokeStats {

	private String m_Name;
	private String m_Race;
	private String m_Owner;
	private int m_HP_max; 
	private int m_HP_curr;


	// Getters 
	public String getName() {return m_Name;}
	public String getRace() {return m_Race;}
	public String getOwner() {return m_Owner;}
	public int getHPmax() {return m_HP_max;}
	public int getHPcurr() {return m_HP_curr;}


	// Setters
	public void setOwner(String own) {m_Owner = own;}
	public void setName(String nam) {m_Name = nam;}
	public void setRace(String typ) {m_Name = typ;}
	public void setHPmax(int hpmax) {m_HP_max = hpmax;}
	public void setHPcurr(int hpcurr) {m_HP_curr = hpcurr;}
}


