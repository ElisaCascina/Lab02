package it.polito.tdp.alien.model;

import java.util.*;

public class Parola {
	
	String parolaAliena;
	List <String> paroleItaliane= new LinkedList <String>();
	
	
	public Parola(String parolaAliena) {
		super();
		this.parolaAliena = parolaAliena;
	}

	public void addTraduzione(String s) {
		paroleItaliane.add(s);
	}
}
