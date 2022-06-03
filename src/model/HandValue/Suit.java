package model.HandValue;

public enum Suit {
	HEARTS(1), DIAMONDS(2), CLUBS(3), SPADES(4), X(5), SUITED(6), OFFSUITED(7), NONE(8);

	int value;
	
	Suit(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
