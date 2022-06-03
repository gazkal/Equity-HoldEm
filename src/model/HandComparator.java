package model;

import model.HandValue.*;
import java.util.Comparator;

public class HandComparator implements Comparator<Hand> {
	
	private Hand h;
	private String id; //ex 3
	
	public HandComparator() { }
	
	public HandComparator (Hand h, String id) {
		this.h = h;
		this.id = id;
	}
	
	public Hand getH() {
		return h;
	}

	public void setH(Hand h) {
		this.h = h;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int compare(Hand o1, Hand o2) {
		
		if (o1.getPokerHand() == o2.getPokerHand())
            return 0;
        else if (o1.getPokerHand().getNumVal() > o2.getPokerHand().getNumVal())
            return 1;
        else
            return -1;
	}
	
	public static class Comparators {

        public static Comparator<HandComparator> PKHAND = new Comparator<HandComparator>() {
            @Override
            public int compare(HandComparator o1, HandComparator o2) {
            	if (o1.getH().getPokerHand() == o2.getH().getPokerHand())
                    return 0;
                else if (o1.getH().getPokerHand().getNumVal() > o2.getH().getPokerHand().getNumVal())
                    return 1;
                else
                    return -1;
            }
        };
	}
        
	
	/*public int compare(HandComparator o1, HandComparator o2) {
		
		if (o1.getH().getPokerHand() == o2.getH().getPokerHand())
            return 0;
        else if (o1.getH().getPokerHand().getNumVal() > o2.getH().getPokerHand().getNumVal())
            return 1;
        else
            return -1;
	}*/

}