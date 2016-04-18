
public abstract class MailObject {
	private Citizen giver;
	private Citizen taker;
	
	public abstract double fee();
	
	public abstract int timeItTakesToDeliver();
	
	public abstract boolean isLetter();

	public Citizen getGiver() {
		return giver;
	}

	public void setGiver(Citizen giver) {
		if(giver!=null)
		this.giver = giver;
	}

	public Citizen getTaker() {
		return taker;
	}

	public void setTaker(Citizen taker) {
		if(taker!=null)
		this.taker = taker;
	}
}
