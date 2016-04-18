
public class VinetkaKamion extends Vinetka {
	private static final int YEAR_PRICE_VINETKA_KAMION = 210;
	private static final int MONTH_PRICE_VINETKA_KAMION = 70;
	private static final int DAY_PRICE_VINETKA_KAMION = 7;
	private static final int TIME_TO_STICK_VINETKA = 10;
	static String color="blue";
	
	public VinetkaKamion(String tipVinetka) {
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
			this.cena = DAY_PRICE_VINETKA_KAMION;
		}
		if(super.getValidnost().equalsIgnoreCase("month")){
			this.cena=MONTH_PRICE_VINETKA_KAMION;
		}
		if(super.getValidnost().equalsIgnoreCase("year")){
			this.cena=YEAR_PRICE_VINETKA_KAMION;
		}
		
	}

	

	

}
