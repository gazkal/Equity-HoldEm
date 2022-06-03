package model.Equity;

import model.HandValue.Hand;
import model.Range.PairOfCards;

public class Player {
	//each player will have their corresponding equity
	//could use the board in handvalue or create a different class in equity, will see
	//we should be able to randomise the card values of the players >> will be done in PairOfCards class?
	PlayerStats stats;
	Hand h;
	
	int id;
	
	public Player (Hand h, PlayerStats stats, int id) {
		this.h = h;
		this.stats = stats;
		this.id = id;
	}
	
	
	public PlayerStats getCals() {
		return stats;
	}

	public void setCals(PlayerStats stats) {
		this.stats= stats;
	}

	public Hand getpCards() {
		return h;
	}

	public void setH(Hand h) {
		this.h = h;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
