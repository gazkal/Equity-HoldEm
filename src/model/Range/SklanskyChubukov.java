package model.Range;

import model.HandValue.*;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SklanskyChubukov {
	ArrayList<PairOfCards> ranks;
	final String sklanskyRankings = "AA,KK,AKs,QQ,AKo,JJ,AQs,TT,AQo,99,AJs,88,ATs,AJo,77,66,ATo,A9s,55,A8s,KQs,44,A9o,A7s,KJs,A5s,A8o,A6s,A4s,33,KTs,A7o,A3s,KQo,A2s,A5o,A6o,A4o,KJo,QJs,A3o,22,K9s,A2o,KTo,QTs,K8s,K7s,JTs,K9o,K6s,QJo,Q9s,K5s,K8o,K4s,QTo,K7o,K3s,Q8s,K2s,Q6o,J9s,K5o,Q9o,JTo,K4o,Q7s,T9s,Q6s,K3o,J8s,Q5s,K2o,Q8o,Q4s,Q3s,J9o,T8s,J7s,Q7o,Q2s,K6o,98s,Q5o,T9o,J8o,J6s,J5s,T7s,Q4o,J4s,J7o,Q3o,97s,T8o,J3s,T6s,Q2o,87s,J2s,J6o,T7o,98o,96s,J5o,T5s,T4s,86s,J4o,T3s,T6o,97o,95s,76s,J3o,T2s,87o,85s,96o,J2o,T5o,94s,75s,65s,T4o,93s,86o,84s,95o,T3o,76o,92s,74s,T2o,54s,85o,64s,83s,94o,75o,82s,93o,73s,53s,65o,84o,92o,63s,43s,72s,54o,74o,83o,52s,64o,62s,82o,42s,53o,63o,73o,32s,72o,43o,52o,62o,32o,42o";
	
	public SklanskyChubukov() {
		this.ranks = new ArrayList<PairOfCards>();
		this.ranks = entryParser.pairListParse(sklanskyRankings);
	}
	
	//calculate the percentage
	double calcPercent (int equal, int suited, int offsuited) {
		double aux = equal * 6 + suited * 4 + offsuited * 12;
		return (aux / 1326) * 100; 
	}
	
	//returns a list of all the pairs lower or equal than the given percentage
	public ArrayList<PairOfCards> percentToList (double p) {
		PairOfCards pair;
		ArrayList<PairOfCards> pList = new ArrayList<PairOfCards>();
		int equal = 0, suited = 0, offsuited = 0;
		int i = 0;
		boolean done = false;
		while (!done && i < 169) {
			pair = ranks.get(i);
			if (pair.isPareja()) {
				equal++;
			} 
			else if (pair.getSuit() == Suit.SUITED) {
				suited++;
			} 
			else if (pair.getSuit() == Suit.OFFSUITED) {
				offsuited++;
			}
			
			if (calcPercent(equal, suited, offsuited) <= p) {
				pList.add(pair);
			} else {
				done = true;
			}
			i++;
		}
		return pList;
	}
	
	double ListToPercent (ArrayList<PairOfCards> pList) {
		PairOfCards pair;
		double percent = 0;
		int equal = 0, suited = 0, offsuited = 0;
		for (int i = 0; i < pList.size(); i++) {
			pair = pList.get(i);
			if (pair.isPareja()) {
				equal++;
			} 
			else if (pair.getSuit() == Suit.SUITED) {
				suited++;
			} 
			else if (pair.getSuit() == Suit.OFFSUITED) {
				offsuited++;
			}
			percent += calcPercent(equal, suited, offsuited);
		}
		return percent;
	}
	
	//we'll need to get a bunch of cards partiendo de una porcentaje and vice versa
	
	
	
	//useful function if we're asked to sort by different criterias
	//if asked for different rankings, we could use a Double array for each ranking
	//do not call this function, it's only here to generate an ordered string
	public void sortRankings () {
		Map<String, Double> map = new HashMap<String, Double>();
		
		//AA
		map.put("AA", 999.0);
		map.put("AKs", 277.0);
		map.put("AQs", 137.0);
		map.put("AJs", 91.6);
		map.put("ATs", 69.5);
		map.put("A9s", 52.0);
		map.put("A8s", 44.9);
		map.put("A7s", 39.5);
		map.put("A6s", 35.3);
		map.put("A5s", 36.1);
		map.put("A4s", 33.3);
		map.put("A3s", 31.1);
		map.put("A2s", 29.0);
		
		//KK
		map.put("AKo", 166.0);
		map.put("KK", 477.0);
		map.put("KQs", 43.3);
		map.put("KJs", 36.3);
		map.put("KTs", 31.4);
		map.put("K9s", 23.9);
		map.put("K8s", 19.9);
		map.put("K7s", 18.6);
		map.put("K6s", 17.4);
		map.put("K5s", 16.1);
		map.put("K4s", 15.0);
		map.put("K3s", 14.1);
		map.put("K2s", 13.3);
		
		//QQ
		map.put("AQo", 96.0);
		map.put("KQo", 29.3);
		map.put("QQ", 239.0);
		map.put("QJs", 24.7);
		map.put("QTs", 21.9);
		map.put("Q9s", 16.2);
		map.put("Q8s", 13.3);
		map.put("Q7s", 11.3);
		map.put("Q6s", 10.9);
		map.put("Q5s", 10.1);
		map.put("Q4s", 9.4);
		map.put("Q3s", 8.8);
		map.put("Q2s", 8.3);
		
		//JJ
		map.put("AJo", 68.1);
		map.put("KJo", 25.4);
		map.put("QJo", 16.4);
		map.put("JJ", 159.0);
		map.put("JTs", 18.0);
		map.put("J9s", 12.8);
		map.put("J8s", 10.3);
		map.put("J7s", 8.5);
		map.put("J6s", 7.3);
		map.put("J5s", 7.0);
		map.put("J4s", 6.4);
		map.put("J3s", 6.0);
		map.put("J2s", 5.5);
		
		//TT
		map.put("ATo", 53.1);
		map.put("KTo", 22.4);
		map.put("QTo", 14.8);
		map.put("JTo", 11.5);
		map.put("TT", 120.0);
		map.put("T9s", 11.2);
		map.put("T8s", 8.7);
		map.put("T7s", 7.0);
		map.put("T6s", 5.9);
		map.put("T5s", 4.9);
		map.put("T4s", 4.6);
		map.put("T3s", 4.2);
		map.put("T2s", 3.7);
		
		//99
		map.put("A9o", 40.8);
		map.put("K9o", 17.8);
		map.put("Q9o", 11.7);
		map.put("J9o", 8.8);
		map.put("T9o", 7.4);
		map.put("99", 95.7);
		map.put("98s", 7.6);
		map.put("97s", 6.1);
		map.put("96s", 5.0);
		map.put("95s", 4.1);
		map.put("94s", 3.2);
		map.put("93s", 3.0);
		map.put("92s", 2.6);
		
		//88
		map.put("A8o", 35.4);
		map.put("K8o", 15.2);
		map.put("Q8o", 9.9);
		map.put("J8o", 7.4);
		map.put("T8o", 6.0);
		map.put("98o", 5.1);
		map.put("88", 79.6);
		map.put("87s", 5.5);
		map.put("86s", 4.5);
		map.put("85s", 3.6);
		map.put("84s", 2.8);
		map.put("83s", 2.2);
		map.put("82s", 2.0);
		
		//77
		map.put("A7o", 31.3);
		map.put("K7o", 14.2);
		map.put("Q7o", 8.5);
		map.put("J7o", 6.3);
		map.put("T7o", 5.1);
		map.put("97o", 4.2);
		map.put("87o", 3.7);
		map.put("77", 67.4);
		map.put("76s", 4.1);
		map.put("75s", 3.2);
		map.put("74s", 2.5);
		map.put("73s", 2.0);
		map.put("72s", 1.6);
		
		//66
		map.put("A6o", 28.0);
		map.put("Q6o", 13.3);
		map.put("K6o", 8.1);
		map.put("J6o", 5.3);
		map.put("T6o", 4.2);
		map.put("96o", 3.5);
		map.put("86o", 3.0);
		map.put("76o", 2.7);
		map.put("66", 57.6);
		map.put("65s", 3.1);
		map.put("64s", 2.3);
		map.put("63s", 1.8);
		map.put("62s", 1.5);
		
		//55
		map.put("A5o", 28.2);
		map.put("K5o", 12.3);
		map.put("Q5o", 7.5);
		map.put("J5o", 5.0);
		map.put("T5o", 3.4);
		map.put("95o", 2.8);
		map.put("85o", 2.4);
		map.put("75o", 2.1);
		map.put("65o", 1.9);
		map.put("55", 49.3);
		map.put("54s", 2.4);
		map.put("53s", 1.9);
		map.put("52s", 1.5);
		
		//44
		map.put("A4o", 25.9);
		map.put("K4o", 11.4);
		map.put("Q4o", 6.8);
		map.put("J4o", 4.4);
		map.put("T4o", 3.1);
		map.put("94o", 2.1);
		map.put("84o", 1.8);
		map.put("74o", 1.6);
		map.put("64o", 1.5);
		map.put("54o", 1.6);
		map.put("44", 40.9);
		map.put("43s", 1.7);
		map.put("42s", 1.4);
		
		//33
		map.put("A3o", 24.2);
		map.put("K3o", 10.6);
		map.put("Q3o", 6.2);
		map.put("J3o", 3.9);
		map.put("T3o", 2.7);
		map.put("93o", 2.0);
		map.put("83o", 1.5);
		map.put("73o", 1.3);
		map.put("63o", 1.3);
		map.put("53o", 1.3);
		map.put("43o", 1.1);
		map.put("33", 32.7);
		map.put("32s", 1.2);
		
		//22
		map.put("A2o", 22.5);
		map.put("K2o", 10.0);
		map.put("Q2o", 5.6);
		map.put("J2o", 3.44);
		map.put("T2o", 2.4);
		map.put("92o", 1.8);
		map.put("82o", 1.4);
		map.put("72o", 1.1);
		map.put("62o", 1.0);
		map.put("52o", 1.0);
		map.put("42o", 0.9);
		map.put("32o", 0.9);
		map.put("22", 24.0);
		///DONE///
		
		RankComparator rc = new RankComparator(map);
        TreeMap<String, Double> sorted_map = new TreeMap<String, Double>(rc);
        sorted_map.putAll(map);
        List<String> ranks = new ArrayList<String>(sorted_map.keySet());
        String sortedRanks="";
        for (int i = 0; i < ranks.size(); i++) {
        	sortedRanks += ranks.get(i); 
        	if (i != ranks.size() - 1) {
        		sortedRanks += ",";
        	}
        }
		
	}
	
	
	
	
}
