
public class Credit extends BankProduct{
	public Credit(String name, final double interestRate) {
		super(name,interestRate);
		// TODO Auto-generated constructor stub
	}

	private double monthlyFee;
	

	
	public double getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(double monthlyFee) {
		if(monthlyFee>0){
			this.monthlyFee = monthlyFee;
		}
	}
	
	
}
