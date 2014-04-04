package fr.univaix.iut.pokebattle.func;

import twitter4j.User;

public class PokeStats {

	private String m_Name=null;
	private String m_Race=null;
	private String m_Owner=null;
	private int m_HP_max; 
	private int m_HP_curr;
	
	private User m_usr;

	private static PokeStats instance = null;
	 
	// Singleton
	public static PokeStats getInstance()
	{			
		if (instance == null) { 	
			instance = new PokeStats();	
		}
		return instance;
	}

	// Getters 
	public String getName() {return m_Name;}
	public String getRace() {return m_Race;}
	public String getOwner() {return m_Owner;}
	public int getHPmax() {return m_HP_max;}
	public int getHPcurr() {return m_HP_curr;}
	public User getUser() {return m_usr;}


	// Setters
	public void setOwner(String own) {m_Owner = own;}
	public void setName(String nam) {m_Name = nam;}
	public void setRace(String typ) {m_Race = typ;}
	public void setHPmax(int hpmax) {m_HP_max = hpmax;}
	public void setHPcurr(int hpcurr) {m_HP_curr = hpcurr;}
	public void setUser(User ussr) {m_usr = ussr;}
}


