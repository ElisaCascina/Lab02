package it.polito.tdp.alien.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Model {
	
	private Map <String, Parola> mappaP;
		
	public Model() {
		mappaP= new HashMap<String, Parola>();
	}

	
	public void addParola(String parAl, String parTr) {
		int trovata=0;
		for (Parola p: mappaP.values()) 
			if(p.parolaAliena.equals(parAl)) { //caso in cui parolaAliena già salvata e quindi devo aggiungere 1 traduzione
				p.addTraduzione(parTr);
				trovata=1;
			}
		if(trovata==0) { //caso in cui parolaAliena non ancora salvata
			Parola pTemp=new Parola(parAl);
			mappaP.put(parAl, pTemp);
			pTemp.addTraduzione(parTr);
		}	
		
	}
	
	public  Collection<String> findParola(String parAl) {
		Parola p;
		if(mappaP.containsKey(parAl)) {
			p=mappaP.get(parAl);
			return p.paroleItaliane;
		}
		return null;
	}
	
	public boolean controlloCaratteri(String s) {
		if(s.matches("[a-zA-Z ]+"))
			return true;
		return false;
	}
	
	public void clearDictionary() {
		mappaP.clear();
	}

}
