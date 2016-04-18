import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class Demo {
	public static void main(String[] args) {
		
		
		Bank banka= new Bank("DSK", "Sofia");
		Deposit depositShort= new Deposit("Short Deposit", 3, 3);
		Deposit depositShort1= new Deposit("Short Deposit", 3, 3);
		Deposit depositShort2= new Deposit("Short Deposit", 3, 3);
		
		Deposit longDeposit= new Deposit("Long Deposit", 12, 5);
		System.out.println(banka.getName()+"'s initial capital is "+banka.getMoneyInTheBank()+" lv.");
		System.out.println(banka.getName()+"'s initial bank reserve is "+banka.getBankReserve()+" lv.");
		banka.addDeposit(depositShort);
		banka.addDeposit(depositShort1);
		banka.addDeposit(longDeposit);
		banka.addDeposit(depositShort2);
		
		Client ivan= new Client("Ivan", "Sofia", 2000.0, 600);
		Client petar= new Client("Petar", "Plovdiv", 1000, 900);
		Client gosho= new Client("Gosho", "Varna", 560, 1600);
		
		ivan.openDeposit(banka, depositShort);
		ivan.putMoneyInDeposit(500,depositShort , banka);
		petar.openDeposit(banka, depositShort1);
		petar.putMoneyInDeposit(300, depositShort1, banka);
		gosho.openDeposit(banka, longDeposit);
		gosho.putMoneyInDeposit(100,longDeposit, banka);
		
		System.out.println(banka.getMoneyInTheBank()+" lv.in the bank after the deposits.");
		
		banka.payMonthInterestRateDeposits(depositShort);
		banka.payMonthInterestRateDeposits(depositShort1);
		banka.payMonthInterestRateDeposits(longDeposit);
		
		Credit credit= new Credit("Home Credit", 5);
		banka.addCredit(credit);
		ivan.askForCredit(banka, credit, 8, 600);
		ivan.coverCreditExpanses(banka, 80);
		


	}
}
