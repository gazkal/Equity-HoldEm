package model.Equity;

public enum Round {
	//not sure if we actually need this but it's here for now
	INITIAL(0), PREFLOP(1), FLOP(2), TURN(3), RIVER(4);
	
	int value;
	
	Round (int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
