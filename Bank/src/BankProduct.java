
public abstract class BankProduct {
	private static final int MAX_PERCENT = 7;
	private static final int MIN_PERCENT = 0;
	private static final int MAX_PERIOD = 60;
	private static final int MIN_PERIOD = 1;
	private String name;
	private Client client;
	private double yearInterestRate;
	private int period;
	private double nalichnost=0;
	
	public BankProduct(String name, double interestRate) {
		
		this.setName(name);
		this.setYearInterestRate(interestRate);
		
	}
	void setClient(Client client){
		if(client!=null){
			this.client=client;
		}
	}
	
	Client getClient(){
		return this.client;
	}
	public void setName(final String name){
		if(name!=null){
			this.name=name;
		}
	}
	public double getYearInterestRate() {
		return yearInterestRate;
	}
	public void setYearInterestRate(double yearInterestPercent) {
		if(yearInterestPercent>=MIN_PERCENT && yearInterestPercent<=MAX_PERCENT){
			this.yearInterestRate = yearInterestPercent;
			System.out.println("The interest rate is set to "+ yearInterestPercent+" percent.");
		}
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		if(period>=MIN_PERIOD && period<=MAX_PERIOD){
			this.period = period;
		}
	}
	public double getNalichnost() {
		return nalichnost;
	}
	public void setNalichnost(double nalichnost) {
			this.nalichnost = nalichnost;
	}
	public String getName() {
		return this.name;
	}
	
}
