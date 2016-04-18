
public class Kasa {
	private int money=100;
	
	public Kasa() {
		// TODO Auto-generated constructor stub
	}
	public int getMoney(){
		return this.money;
	}
	public void addMoney(Integer money){
		if(money!=null){
			if(money>0)
			this.money+=money;
		}
	}
}
