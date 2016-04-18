
public class Letter extends MailObject{
	
	private static final int TIME_TO_DELIVER = 1000;
	private static final double FEE_LETTER = 0.5;

	Letter(Citizen giver, Citizen taker){
		this.setGiver(giver);
		this.setTaker(taker);
	}
	@Override
	public double fee() {
		
		return FEE_LETTER;
	}

	@Override
	public int timeItTakesToDeliver() {
		
		return TIME_TO_DELIVER;
	}
	@Override
	public boolean isLetter() {
		
		return true;
	}

}
