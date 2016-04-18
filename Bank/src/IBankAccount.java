
public interface IBankAccount {
	public void coverCreditExpanses(Bank bank,float fee);
	public void askForCredit(Bank bank,Credit credit, int time, double money);
	public Deposit openDeposit(Bank bank,Deposit deposit);
	public void putMoneyInDeposit(float moneyToDeposit,Deposit deposit,Bank bank);
}
