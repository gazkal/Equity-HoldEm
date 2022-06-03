package model.HandValue;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import model.CardComparator;



public class Board {
	static final int BOARD_SIZE=5;
	private int nCards;
	private ArrayList<Card> cardList;
	
	public Board() {
		this.cardList=new ArrayList<Card>();
		this.nCards=0;
	}
	
	public Board(ArrayList<Card> cardList) {
		this.cardList=cardList;
		nCards=cardList.size();
	}
	
	public void addCard(Card card) {
		this.cardList.add(card);
		this.nCards++;
	}
	
	public void prepareCall(ArrayList<Card> cardList) {
		Card vector[][]=new Card[14][4];
		for(int i=0; i<BOARD_SIZE; i++) {
			vector[cardList.get(i).getCardValue()][cardList.get(i).getSuit().getValue()]=cardList.get(i);
		}
	}
	
	public void mejorJugada5Cartas(ArrayList<Card> cardList) {
		
	}
	
	public boolean isFlush(ArrayList<Card> cardList, Draws draws) {
		int hearts=0,diamonds=0, clubs=0, spades=0;
		for(int i=0; i<BOARD_SIZE; i++) {
			if(cardList.get(i).getSuit()==Suit.HEARTS)
				hearts++;
			else if(cardList.get(i).getSuit()==Suit.DIAMONDS)
				diamonds++;
			else if(cardList.get(i).getSuit()==Suit.CLUBS)
				clubs++;
			else if(cardList.get(i).getSuit()==Suit.SPADES)
				spades++;
		}
		
		for(int i=0; i<4; i++) {
			if(hearts==BOARD_SIZE) {
				return true;
			}
			else if(diamonds==BOARD_SIZE) {
				return true;
			}
			else if(clubs==BOARD_SIZE) {
				return true;
			}
			else if(spades==BOARD_SIZE) {
				return true;
			}
			else if(hearts==BOARD_SIZE-1) {
				draws.flush();
			}
			else if(diamonds==BOARD_SIZE-1) {
				draws.flush();
			}
			else if(clubs==BOARD_SIZE-1) {
				draws.flush();
			}
			else if(spades==BOARD_SIZE-1) {
				draws.flush();
			}
			
		}
		return false;
	}
	
	public void isRoyalFlush(ArrayList<Card> cardList) {
		boolean cont=true;
		while (cont) {
			
		}
	}
	
	public ArrayList<Card> clone(ArrayList<Card> cardList){
		ArrayList<Card> cards=new ArrayList<Card>();
		for(int i=0; i<cardList.size();i++) {
			cards.add(cardList.get(i).clone());
		}
		return cards;
	}
	
	public Hand whatIHave() {
		Collections.sort(cardList, new CardComparator());
		int straightCounter=0;
		boolean gutshot=false;
		int pair=0;
		boolean three=false;
		boolean flush=false;
		boolean cont=false;
		ArrayList<Hand> hands=new ArrayList<Hand>();
		ArrayList<Card> cards=new ArrayList<Card>();
		ArrayList<Card> cards2Pairs=new ArrayList<Card>();
		Draws draws=new Draws();
		int consecutives=0;
		int consecutivesMax=0;
		if(cardList.get(0).getCardValue()==2 && cardList.get(cardList.size()-1).getCardValue()==14) {
			consecutives=1;
		}
		
		for(int i=1; i< nCards; i++) {
			//Caso en el que se buscan igualdades
			if(cardList.get(i).getCardValue()==cardList.get(i-1).getCardValue()) {
				if(pair>0 && cont) {
					cards.add(cardList.get(i));
					hands.add(new Hand(PokerHands.THREE_OF_A_KIND, clone(cards)));
					if(three) {
						cards.add(cardList.get(i));
						hands.add(new Hand(PokerHands.FOUR_OF_A_KIND, clone(cards)));
					}
					three=true;
					pair--; //resolver full house on three of a kind
				}
				cards.add(cardList.get(i-1));
				cards.add(cardList.get(i));
				cards2Pairs.add(cardList.get(i));
				cards2Pairs.add(cardList.get(i-1));
				hands.add(new Hand(PokerHands.PAIRS, clone(cards)));
				cont=true;
				pair++;
			}
			else {
				cont=false;
				if(cardList.get(i).getCardValue()==cardList.get(i-1).getCardValue()+1){
					straightCounter++;
					consecutives++;
				}
				else if(cardList.get(i).getCardValue()==cardList.get(i-1).getCardValue()+2){
					gutshot=true;
					straightCounter++;
				}else {
					if(consecutives>consecutivesMax) {
						consecutivesMax=consecutives;
					}
					consecutives=0;
						
				}
			}
		}
		
		if(isFlush(cardList, draws)) {
			hands.add(new Hand(PokerHands.FLUSH, cardList));
			flush=true;
		}
		
		if(pair>1 && three) {
			cards.clear();
			hands.add(new Hand(PokerHands.FULL_HOUSE, cardList));
		}
		
		
		boolean linked=false;
		if(cardList.get(0).getCardValue()==2 && cardList.get(cardList.size()-1).getCardValue()==14) {
			linked=true;
			straightCounter++;
		}
		if(cardList.get(0).getCardValue()==3 && cardList.get(cardList.size()-1).getCardValue()==14 && cardList.get(cardList.size()-2).getCardValue()!=13) {
			straightCounter++;
			gutshot=true;
		}
		
		if(straightCounter==4 && !gutshot && !linked) {
			if(flush) {
				if(cardList.get(4).getCardValue()==14)
					hands.add(new Hand(PokerHands.ROYAL_FLUSH, cardList));
				else
					hands.add(new Hand(PokerHands.STRAIGHT_FLUSH, cardList));
			}
			else {
				hands.add(new Hand(PokerHands.STRAIGHT, cardList));
			}
		}
		
		if(consecutives>consecutivesMax) {
			consecutivesMax=consecutives;
		}
		
		if(straightCounter==3 || (linked && straightCounter==4)) {
			if(gutshot) {
				draws.straight_Gutshot();
			}else if(consecutivesMax==3) {
				draws.straight_Open();
			}
		}
		
		if(pair>1) {
			hands.add(new Hand(PokerHands.TWO_PAIRS, cards2Pairs));
		}
		else {
			cards.clear();
			cards.add(cardList.get(4));
			hands.add(new Hand(PokerHands.HIGH_CARD, clone(cards)));
		}
		
		Collections.sort(hands, new HandComparator());
		hands.get(hands.size()-1).setDraws(draws);
		return hands.get(hands.size()-1);
		
		
	}

	public int getnCards() {
		return nCards;
	}

	public void setnCards(int nCards) {
		this.nCards = nCards;
	}
	
	public String printCards() {
		String ret="";
		for(int i=0; i<cardList.size();i++) {
			ret+=cardList.get(i).toString();
		}
		return ret;
	}
	
	
	
}