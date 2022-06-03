package model.HandValue;

import java.util.ArrayList;

public class Hand {
	ArrayList<Card> cards;
	PokerHands pokerHand;
	Draws draws;
	
	public Hand(PokerHands pokerHand, ArrayList<Card> cards) {
		this.cards=cards;
		this.pokerHand=pokerHand;
	}
	
	public void setPokerHand(PokerHands pokerHand) {
		this.pokerHand = pokerHand;
	}
	
	public void setDraws(Draws draws) {
		this.draws=draws;
	}

	public PokerHands getPokerHand() {
		return pokerHand;
	}
	
	@SuppressWarnings("static-access")
	public String toString() {
		String ret=pokerHand.toString();
		if(pokerHand==pokerHand.FOUR_OF_A_KIND || pokerHand==pokerHand.THREE_OF_A_KIND || pokerHand==pokerHand.PAIRS) {
			
			switch(cards.get(0).getCardValue()) {
			case 2:
				ret+=" of Two";
				break;
			case 3:
				ret+=" of Three";
				break;
			case 4:
				ret+=" of Four";
				break;
			case 5:
				ret+=" of Five";
				break;
			case 6:
				ret+=" of Six";
				break;
			case 7:
				ret+=" of Seven";
				break;
			case 8:
				ret+=" of Eight";
				break;
			case 9:
				ret+=" of Nine";
				break;
			case 10:
				ret+=" of Ten";
				break;
			case 11:
				ret+=" of Jack";
				break;
			case 12:
				ret+=" of Queen";
				break;
			case 13:
				ret+=" of King";
				break;
			case 14:
				ret+=" of Ace";
				break;
			}
		}
		ret+="\n";
		if(draws!=null) {
			ret+=draws.drawsToString();
		}
		return ret;
	}
}
