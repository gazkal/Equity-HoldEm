package model.Range;

import model.HandValue.*;
import java.util.ArrayList;

public class Action {
	ArrayList<PairOfCards> pairs;
	ArrayList<PairOfCards> selection; //action selection
	//double percent;
	String action;
	
	public Action() {
		pairs = new ArrayList<PairOfCards>();
		selection = new ArrayList<PairOfCards>();
		action = "";
	}
	
	public Action(PairOfCards pc, String act) {
		pairs = new ArrayList<PairOfCards>();
		selection = new ArrayList<PairOfCards>();
		pairs.add(pc);
		action = act;
		ActionSelection();
	}
	
	public Action(ArrayList<PairOfCards> pcL, String act) {
		pairs = new ArrayList<PairOfCards>();
		selection = new ArrayList<PairOfCards>();
		pairs = pcL;
		action = act;
		ActionSelection();
	}
	
	public Action(String entry) {
		pairs=new ArrayList<PairOfCards>();
		String[] decode=entry.split("-");
		for(int i=0; i<decode.length; i++) {
			pairs.add(new PairOfCards(decode[i]));
		}
	}
	
	public void plusAction(PairOfCards pair, int limit) {
		int first = pair.getV1(), second = pair.getV2();
		Suit suit = pair.getSuit();
		if (pair.isPareja()) { //if pareja
			for (int i = first; i <= limit; i++) { //we only need one of the values cause they're a pareja
				selection.add(new PairOfCards(i, i, suit));
			}
		} else {
			for (int i = second; i < limit; i++) {
				selection.add(new PairOfCards(first, i, suit));
			}
		}
	}
	
	
	public void ActionSelection() { //manage actions +, - , ""
		PairOfCards pair1 = pairs.get(0);
		if (this.action.equals("+")) { 
			if (pair1.isPareja()) {
				plusAction(pair1, 14);
			} else {
				plusAction(pair1, pair1.getV1());
			}
		}
		else if (this.action.equals("-")) {
			PairOfCards pair2 = pairs.get(1);
			Suit pair1Suit = pair1.getSuit(), pair2Suit = pair2.getSuit();
			
			if (pair1.isPareja() && pair2.isPareja()) {
				plusAction(pair2, pair1.getV1());
			}
			else if (pair1Suit == pair2Suit && pair1.getV1() == pair2.getV1()){
				plusAction(pair2, pair1.getV2() + 1);
			} 
			else if (pair1.isPareja() && pair2.getV1() <= pair1.getV1()) {
				plusAction(pair2, pair2.getV1());
				plusAction(new PairOfCards(pair2.getV1(), pair2.getV1(), Suit.NONE), pair1.getV1());
			}
		} else {
			//action is empty, returns a list with the original pair
			if (pair1.getSuit() == Suit.NONE && !pair1.isPareja()) {
				//anadir version suited y non suited a la seleccion
				selection.add(new PairOfCards(pair1.getV1(), pair1.getV2(), Suit.SUITED));
				selection.add(new PairOfCards(pair1.getV1(), pair1.getV2(), Suit.OFFSUITED));
			} else {
				selection = pairs;
			}
		}
	}
	
	public ArrayList<PairOfCards> getselection() {
		return selection;
	}

	public void setSelection(ArrayList<PairOfCards> selection) {
		this.selection = selection;
	}

	public ArrayList<PairOfCards> getPairs() {
		return pairs;
	}

	public void setPairs(ArrayList<PairOfCards> pairs) {
		this.pairs = pairs;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	
}
