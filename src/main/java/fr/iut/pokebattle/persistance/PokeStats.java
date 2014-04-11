package fr.iut.pokebattle.persistance;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import twitter4j.User;

@Entity
@NamedQueries({
	@NamedQuery(name = PokeStats.FIND_BY_NOM, query = "SELECT p FROM PokeStats p WHERE p.m_Name = :fnom")
	})
public class PokeStats {

	public static final String FIND_BY_NOM = "findPokemonByNom";
	
	@Id
	private String m_Name   = null;
	@Column(length=50)
	private String m_Race   = null;
	@Column(length=50)
	private String m_Owner  = null;
	@Column
	private int m_level     = 1;
	@Column
	private int m_xp	    = 0;
	@Column
	private int m_HP_max; 
	@Column
	private int m_HP_curr;
	@Column
	private boolean m_dispo = true;
	@Column
	private int m_timewait = 0;
	@Temporal(TemporalType.DATE)
	private Date m_lastact = Calendar.getInstance().getTime();
	@Column(length=2000)
	private String m_attaques;

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
	public int getLevel() {return m_level;}
	public int getXp() {return m_xp;}
	public boolean isDispo(){ return m_dispo;}
	public int getTimeWait(){ return m_timewait;}
	public Date getLastDate() {return m_lastact; }
	
	// Setters
	public void setOwner(String own) {m_Owner = own;}
	public void setName(String nam) {m_Name = nam;}
	public void setRace(String typ) {m_Race = typ;}
	public void setHPmax(int hpmax) {m_HP_max = hpmax;}
	public void setHPcurr(int hpcurr) {m_HP_curr = hpcurr;}
	public void setXp(int newxp) {m_xp = newxp;}
	public void setLevel(int newlvl) {m_level = newlvl;}
	public void setDispo(boolean bool){ m_dispo = bool;}
	public void setLastDate(Date laaast) {m_lastact = laaast; }
}