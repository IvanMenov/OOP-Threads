
public class Deposit extends BankProduct {
	
	public Deposit(String name,int period, double interestRate) {
		super(name, interestRate);
		this.setPeriod(period);
		// TODO Auto-generated constructor stub
	}
	private float moneyGivenMonthly;
	

	public float getMoneyGivenMonthly() {
		return moneyGivenMonthly;
	}
	public void addMoneyGivenMonthly(double moneyDeposited){
		this.moneyGivenMonthly+=moneyDeposited;
		this.setNalichnost(moneyGivenMonthly);
		System.out.println("Deposited money is "+this.getNalichnost()+" lv after paying the monthly interest rate.");
	}
	
	@Override
	public void setNalichnost(double nalichnost) {
		if(nalichnost>0){
			super.setNalichnost(nalichnost);
		}
	}
	

}
