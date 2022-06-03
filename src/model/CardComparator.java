package model;

import model.HandValue.*;
import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		
		if (o1.getCardValue() == o2.getCardValue())
            return 0;
        else if (o1.getCardValue() > o2.getCardValue())
            return 1;
        else
            return -1;
	}

}
