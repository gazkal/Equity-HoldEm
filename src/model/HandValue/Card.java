package model.HandValue;

import java.util.ArrayList;

public class Card {
	Suit suit;
	int cardValue;
	
	public Card(Character cardValue, Character suit){
		this.suit=suitParser(suit);
		this.cardValue= cardValueParser(cardValue);
	}
	
	public Card(int cardValue, Suit suit) {
		this.cardValue=cardValue;
		this.suit=suit;
	}
	
	public int getCardValue() {
		return this.cardValue;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	private Suit suitParser(Character suit) {
		
		switch(suit) {
		
			case 'h':
				return Suit.HEARTS;
			
			case 'd':
				return Suit.DIAMONDS;
			
			case 'c':
				return Suit.CLUBS;
			
			case 's':
				return Suit.SPADES;
		}
		return Suit.X;
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
	
	public Card clone() {
		return new Card(cardValue,suit);
	}
	
	public String toString() {
		String ret="";
		switch(cardValue) {
			case 2: ret+="2";break;
			case 3: ret+="3";break;
			case 4: ret+="4";break;
			case 5: ret+="5";break;
			case 6: ret+="6";break;
			case 7: ret+="7";break;
			case 8: ret+="8";break;
			case 9: ret+="9";break;
			case 10: ret+="T";break;
			case 11: ret+="J";break;
			case 12: ret+="Q";break;
			case 13: ret+="K";break;
			case 14: ret+="A";break;
		}
		switch(this.suit) {
		case HEARTS: ret+="h";break;
		case DIAMONDS: ret+="d";break;
		case CLUBS: ret+="c";break;
		case SPADES: ret+="s";break;
		default:
			break;
		}
		return ret;
	}
	
	
}
