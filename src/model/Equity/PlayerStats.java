package model.Equity;

public class PlayerStats {
	//each player should have this class as an attribute I guess
	int wins, ties;
	double probability;
	
	public PlayerStats () {
		wins = 0;
		ties = 0;
		probability = 0;
	}
	
	public PlayerStats (int wins, int draws, double percentage) {
		wins = 0;
		draws = 0;
		probability = 0;
	}
	
	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getTies() {
		return ties;
	}

	public void setTies(int ties) {
		this.ties = ties;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}
	
}
