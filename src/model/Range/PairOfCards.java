package model.Range;

import model.HandValue.*;

public class PairOfCards {
	
	Suit suit; //anadido para manejar las entradas sin tipo, por ejemplo AT sera ATs y ATo y tambien para los siguientes apartados
	boolean pareja;
	int v1;
	int v2;
	
	public PairOfCards(String s) {
		this.v1 = cardValueParser(s.charAt(0));
		this.v2 = cardValueParser(s.charAt(1));
		if (v1 == v2) {
			this.pareja = true;
		} else {
			this.pareja = false;
		}
		if (s.contains("s")) {
			suit=Suit.SUITED;
		}else if (s.contains("o")){
			suit = Suit.OFFSUITED;
		} else {
			suit = Suit.NONE;
		}
	}
	
	public PairOfCards(int v1, int v2, Suit suited) {
		if(v1<v2) {
			this.v1=v2;
			this.v2=v1;
		}else {
			this.v1=v1;
			this.v2=v2;
		}
		if (v1 == v2) pareja = true;
		this.suit=suited;
	}
	
	private int cardValueParser(Character cardValue) {
		
		switch(cardValue) {
			case '2': return 2;
			case '3': return 3;
			case '4': return 4;
			case '5': return 5;
			case '6': return 6;
			case '7': return 7;
			case '8': return 8;
			case '9': return 9;
			case 'T': return 10;
			case 'J': return 11;
			case 'Q': return 12;
			case 'K': return 13;
			case 'A': return 14;
		}
		return 1;
	}
	
	

	public Suit getSuit() {
		return suit;
	}

	public void setSuited(Suit suited) {
		this.suit = suited;
	}

	public boolean isPareja() {
		return pareja;
	}

	public void setPareja(boolean pareja) {
		this.pareja = pareja;
	}

	public int getV1() {
		return v1;
	}

	public void setV1(int v1) {
		this.v1 = v1;
	}

	public int getV2() {
		return v2;
	}

	public void setV2(int v2) {
		this.v2 = v2;
	}
	
}
