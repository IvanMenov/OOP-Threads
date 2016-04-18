import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public  class Bank {
	private static final int NUMBER_OF_MONTHS = 12;
	private String name;
	private String address;
	private ArrayList<Deposit> depositsInBank= new ArrayList<Deposit>();
	 ArrayList<Credit> creditsInBank= new ArrayList<Credit>();
	private double moneyInTheBank=1000;
	private float bankReserve;
	
	public Bank(final String name, final String address) {
		if(name!=null){
			this.name=name;
		}
		if(address!=null){
			this.address=address;
		}
	}
	public String getName(){
		return this.name;
	}
	public float getBankReserve(){
		return this.bankReserve;
	}
	public void addCredit(Credit credit){
		if(credit!=null){
			this.creditsInBank.add(credit);
		}
	}
	
	public boolean giveCredit(Client client,Credit credit,double creditAmount,int period){
		if(creditAmount<this.bankReserve){
			double fee= 0;
			for (int index = 0; index < creditsInBank.size(); index++) {
				if(creditsInBank.get(index).equals(credit)){
					fee+=creditsInBank.get(index).getMonthlyFee();
				}break;
			}
			if(fee<client.getSalary()/2){
				 credit.setClient(client);
				 credit.setPeriod(period);
				 credit.setNalichnost(creditAmount);
				 this.moneyInTheBank-=creditAmount;
				 
			}
			
			System.out.println(credit.getNalichnost()+" lv. credit was given to "+client.getName()+" for "+period+" months.");
			return true;
		}else{
			System.out.println("Cannot give the credit");
			creditsInBank.remove(credit);
			return false;
		}
	}
	public void addDeposit( Deposit deposit){
		if(deposit!=null){
			depositsInBank.add(deposit);
		}
		
	}
	double calculateMonthInterestRateDeposits(Deposit deposit){
		if(deposit!=null){
			double yearRate= deposit.getYearInterestRate();
			double monthRate= yearRate/NUMBER_OF_MONTHS;
			return monthRate;
		}
		return 0;
	}
	public void payMonthInterestRateDeposits(Deposit deposit){
		for (int i = 0; i < this.depositsInBank.size(); i++) {
			if(depositsInBank.get(i)!=null){
				if(depositsInBank.get(i).equals(deposit)){
					double monthRate= calculateMonthInterestRateDeposits(depositsInBank.get(i));
					double money=depositsInBank.get(i).getNalichnost()*monthRate;
					depositsInBank.get(i).addMoneyGivenMonthly(money);
					this.moneyInTheBank=this.moneyInTheBank-(money);
					depositsInBank.get(i).setNalichnost(depositsInBank.get(i).getMoneyGivenMonthly());
					System.out.println(money+" lv. is the interest paid to "+
							depositsInBank.get(i).getClient().getName());
					System.out.println(this.getMoneyInTheBank()+" lv money in the bank left after payment of the deposit interest. ");
				
				}
			}
			else{
				return;
			}
		}
		
	}
	public double getMoneyInTheBank() {
		return moneyInTheBank;
	}

	public void addMoneyInTheBank(double moneyInTheBank) {
		if(moneyInTheBank>0){
			this.moneyInTheBank += moneyInTheBank;
		}
	}	
	public void addMoneyInTheReserve(double money){
		this.bankReserve+=money;
	}
}
