
public class VinetkaKola extends Vinetka {
	private static final int YEAR_PRICE_VINETKA_CAR = 150;
	private static final int MONTH_PRICE_VINETKA_CAR = 50;
	private static final int DAY_PRICE_VINETKA_CAR = 5;
	private static final int TIME_TO_STICK_VINETKA = 5;
	static String color="green";
	
	public VinetkaKola(String tipVinetka) {
		super(tipVinetka);
		this.setCena();
		
	}
	
	String getColor(){
		return color;
	}
	public int stick(){
		return TIME_TO_STICK_VINETKA;
	}
	
	public void setCena() {
		if(super.getValidnost().equalsIgnoreCase("day")){
			this.cena = DAY_PRICE_VINETKA_CAR;
			return;
		}
		if(super.getValidnost().equalsIgnoreCase("month")){
			this.cena=MONTH_PRICE_VINETKA_CAR;
			return;
		}
		if(super.getValidnost().equalsIgnoreCase("year")){
			this.cena=YEAR_PRICE_VINETKA_CAR;
			return;
		}
		
	}

	

	
	
}
