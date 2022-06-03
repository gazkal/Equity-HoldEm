package model.HandValue;

public class Draws {
	boolean straight_Gutshot;
	boolean straight_Open;
	boolean flush;
	
	public Draws(){
		straight_Gutshot=false;
		straight_Open=false;
		flush=false;
	}
	
	public void straight_Gutshot() {
		this.straight_Gutshot=true;
	}
	
	public void straight_Open() {
		this.straight_Open=true;
	}
	
	public void flush() {
		this.flush=true;
	}
	
	public String drawsToString() {
		String ret="";
		
		if(this.straight_Gutshot) {
			ret+="- Draw: Straight Gutshot\n";
		}
		if(this.straight_Open) {
			ret+="- Draw: Straight Open-ended\n";
		}
		if(this.flush) {
			ret+="- Draw: Flush\n";
		}
		
		return ret;
	}
}
