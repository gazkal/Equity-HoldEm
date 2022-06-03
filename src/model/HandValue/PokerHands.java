package model.HandValue;

public enum PokerHands {
	ROYAL_FLUSH(10), STRAIGHT_FLUSH(9), FOUR_OF_A_KIND(8), FULL_HOUSE(7), FLUSH(6), STRAIGHT(5), THREE_OF_A_KIND(4), TWO_PAIRS(3), PAIRS(2), HIGH_CARD(1), OVERPAIR(0), TOP_PAIR(-1), MIDDLE_PAIR(-2), WEAK_PAIR(-3);

    private int numVal;

    PokerHands(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
    
    @Override
    public String toString() {
    	switch(this) {
    	case ROYAL_FLUSH:
    		return "Royal flush";
	    case STRAIGHT_FLUSH:
			return "Straight flush";
	    case FOUR_OF_A_KIND:
			return "Four of a kind";
	    case FULL_HOUSE:
			return "Full house";
	    case FLUSH:
			return "Flush";
	    case STRAIGHT:
			return "Straight";
	    case THREE_OF_A_KIND:
			return "Three of a kind";
	    case TWO_PAIRS:
			return "Two pairs";
	    case PAIRS:
			return "Pairs";
	    case HIGH_CARD:
			return "High card";
    	}

    	return "NOT FOUND";
    	
    }
    
}

