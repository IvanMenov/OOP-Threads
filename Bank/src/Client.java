import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Вместо клиента да пази списък със своите депозити и кредити, самите кредити/депозити
// имат поле, в което се записва клиента,а списък с депозити/кредити има само в банката.
// Направих го така, защото ми се стори по-близко до действителността да се представи по този начин.

public class Client implements IBankAccount{
	private static final double FACTOR_BANK_RESERVE = 0.9;
	private String name;
	private String address;
	private double moneyBallance;
	private float salary;
	
	public Client(final String name, String address, double moneybalance, float Salary) {
		if(name!=null){
			this.name=name;
		}
		this.setAddress(address);
		this.moneyBallance=moneybalance;
		this.setSalary(Salary);
	}
	public void putMoneyInDeposit(float moneyToDeposit,Deposit deposit,Bank bank){
		if(deposit!=null && bank!=null){
			if(this.getMoneyBallance()>0 && this.getMoneyBallance()>=moneyToDeposit){
				deposit.setNalichnost(moneyToDeposit);
				bank.addMoneyInTheBank(moneyToDeposit);
				bank.addMoneyInTheReserve(moneyToDeposit*FACTOR_BANK_RESERVE);
				this.moneyBallance=this.moneyBallance-moneyToDeposit;
				System.out.println(this.name+" opened a deposit for "+deposit.getNalichnost()+" lv.and a period of "+deposit.getPeriod()+" months.");
			}
		}
	}
	
	public Deposit openDeposit(Bank bank,Deposit deposit){
		if(deposit!=null && bank!=null){
			deposit.setClient(this);
			System.out.println(this.getName()+" opened a new deposit in "+bank.getName());
			return deposit;
		}
		return null;
	}
	
	public void coverCreditExpanses(Bank bank,float fee){
	  if(fee>0){
		for (int i = 0; i < bank.creditsInBank.size(); i++) {
			if(bank.creditsInBank.get(i).getClient().equals(this)){
				bank.creditsInBank.get(i).setMonthlyFee(fee);
				bank.addMoneyInTheBank(fee);
				this.moneyBallance-=fee;
				System.out.println(bank.getMoneyInTheBank()+"lv. in the bank after adding the credit fee of "+fee+" lv");
			}
		}
	  }
	}
	public void askForCredit(Bank bank,Credit credit, int time, double money){
			boolean IsCreditPossible = bank.giveCredit(this, credit, money,time);
			if(IsCreditPossible==true){
				System.out.println(this.getMoneyBallance()+"lv. is the money ballanceof "+this.getName()+" before the credit");
				this.moneyBallance+=credit.getNalichnost();
				System.out.println(credit.getNalichnost()+" lv. credit was given to "+this.name); 
				System.out.println(this.getMoneyBallance()+" lv. is the money balance of "+this.getName()+" after the credit");
			}
		
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(address!=null){
		this.address = address;
		}
	}
	public double getMoneyBallance() {
		return moneyBallance;
	}
	
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		if(salary>0){
		this.salary = salary;
		}
	}
	
	
	
}
