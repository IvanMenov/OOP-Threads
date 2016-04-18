
public class VinetkaAvtobus extends Vinetka {
	private static final int YEAR_PRICE_VINETKA_AUTOBUS = 270;
	private static final int MONTH_PRICE_VINETKA_AUTOBUS = 90;
	private static final int DAY_PRICE_VINETKA_AUTOBUS = 9;
	private static final int TIME_TO_STICK_VINETKA = 20;
	static String color="red";
	
	public VinetkaAvtobus(String tipVinetka) {
		super(tipVinetka);
		setCena();
		
	}
	
	 String getColor(){
		return color;
	}
	@Override
	public int stick() {
		return TIME_TO_STICK_VINETKA;
	}

	@Override
	public void setCena() {
		if(super.getValidnost().equalsIgnoreCase("day")){
			this.cena = DAY_PRICE_VINETKA_AUTOBUS;
		}
		if(super.getValidnost().equalsIgnoreCase("month")){
			this.cena=MONTH_PRICE_VINETKA_AUTOBUS;
		}
		if(super.getValidnost().equalsIgnoreCase("year")){
			this.cena=YEAR_PRICE_VINETKA_AUTOBUS;
		}
		
	}

	

	
}
