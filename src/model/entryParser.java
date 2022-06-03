package model;

import model.Range.*;
import model.HandValue.*;

import java.util.ArrayList;

public class entryParser {
	
	public static ArrayList<Action> bodyParser(String body) {
		String[] aux = body.replaceAll("\\s+","").split(","); //the replaceAll is to remove whitespaces
		String[] aux2 = {""};
		ArrayList<Action> acts = new ArrayList<Action>();
		Action a =  new Action();
		for(int i=0; i<aux.length;i++) {
			if(aux[i].contains("+")) {
				aux2=aux[i].split("\\+"); //+ meta character
				PairOfCards pair1=new PairOfCards(aux2[0]);
				a = new Action (pair1, "+");
				acts.add(a);
			}else if(aux[i].contains("-")) {
				aux2 = aux[i].split("\\-");
				ArrayList<PairOfCards> pL = new ArrayList<PairOfCards>();
				PairOfCards pair1 = new PairOfCards(aux2[0]);
				PairOfCards pair2 = new PairOfCards(aux2[1]);
				if (pair1.getV2() > pair2.getV2()) {
					pL.add(pair1); pL.add(pair2);
				} else {
					pL.add(pair2); pL.add(pair1);
				}
				a = new Action (pL, "-");
				acts.add(a);
			}else {
				PairOfCards pair1=new PairOfCards(aux[i]);
				a = new Action (pair1, "");
				acts.add(a);
			}
		}
		return acts;
	}
	
	public static ArrayList<PairOfCards> pairListParse(String body) {
		String[] aux = body.split(",");
		ArrayList<PairOfCards> pList = new ArrayList<PairOfCards>();
		PairOfCards pair;
		for (int i = 0; i < aux.length; i++) {
			pair = new PairOfCards(aux[i]);
			pList.add(pair);
		}
		return pList;			
	}
	
	public static ArrayList<Card> parseBoardEx3(String body){
		String[] aux = body.split(",");
		ArrayList<Card> boardCards=new ArrayList<Card>();
		for(int i=0;i<aux.length;i++) {
			boardCards.add(new Card(aux[i].charAt(0),aux[i].charAt(1)));
		}
		return boardCards;
	}
}
