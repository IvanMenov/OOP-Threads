import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public abstract class Vinetka implements IVinetka{

	private static final int MONTH_OF_FEBRUARY = 2;
	private static final int LAST_DAY_OF_THE_MONTH = 30;
	private static final int FIRST_DAY_OF_THE_MONTH = 1;
	private static final int LAST_DAY_OF_FEBRUARY = 29;
	private static final int LAST_MONTH = 12;
	private static final int FIRST_MONTH = 1;
	private static final int MAX_YEAR_ALLOWED = 2020;
	private static final int MIN_YEAR_ALLOWED = 1999;
	private LocalDate releaseDate;
	private LocalDate validityDate;
	private String validnost;
	protected int cena;
	private String color;
	
	abstract String getColor();
	
	public Vinetka(String validnost) {
		this.setValidnost(validnost);
		Random random = new Random();
		int minDay = (int) LocalDate.of(2016, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2017, 1, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		releaseDate = LocalDate.of(randomDate.getYear(), randomDate.getMonthValue(), randomDate.getDayOfMonth());
		 this.setValidity();
	}
	
	public  int getCena(){
		return this.cena;
	}
	
	abstract public void setCena();
	
	public int getDayReleased() {
		return releaseDate.getDayOfMonth();
	}

	 void setRelease(int dayReleased, int monthRelease, int yearRelease) {
		 int day=0;
		 int month=0;
		 int year=0;
		if(getMonthReleased()==1 ||getMonthReleased()==3 || 
				getMonthReleased()==5 ||getMonthReleased()==7 ||
				getMonthReleased()==8 || getMonthReleased()==10 || getMonthReleased()==12){
			if(dayReleased>=1 && dayReleased<=31){
				day=dayReleased;
			}
		}if(getMonthReleased()!=MONTH_OF_FEBRUARY){
			if(dayReleased>=FIRST_DAY_OF_THE_MONTH && dayReleased<=LAST_DAY_OF_THE_MONTH){
				day=dayReleased;
			}
		}else{
			if(dayReleased>=FIRST_DAY_OF_THE_MONTH && dayReleased<=LAST_DAY_OF_FEBRUARY){
				day=dayReleased;
			}
		}
		if(monthRelease>=FIRST_MONTH && monthRelease<=LAST_MONTH){
			month = monthRelease;
		}
		if(yearRelease>MIN_YEAR_ALLOWED && yearRelease<=MAX_YEAR_ALLOWED){
			year = yearRelease;
		}
		releaseDate=  LocalDate.of(year, month, day);
	}

	public int getMonthReleased() {
		return releaseDate.getMonthValue();
	}

	public int getYearReleased() {
		return releaseDate.getYear();
	}
	
	public int getDayValidity() {
		return validityDate.getDayOfMonth();
	}

	 private void setValidity() {
		 validityDate = LocalDate.of(releaseDate.getYear(), releaseDate.getMonthValue(), releaseDate.getDayOfMonth());
		
		 if(this.getValidnost().equalsIgnoreCase("day")){ 
			 Period oneDay = Period.ofDays(1);
			  validityDate= validityDate.plus(oneDay);		
		 }
		 if(this.getValidnost().equalsIgnoreCase("month")){ 
			 Period oneMonth = Period.ofMonths(1);
			  validityDate= validityDate.plus(oneMonth);		 
		 }
		 if(this.getValidnost().equalsIgnoreCase("year")){ 
			 Period oneYear = Period.ofYears(1);
			  validityDate= validityDate.plus(oneYear);
		 }
		
	 	}

	public int getMonthValidity() {
			return validityDate.getMonthValue();	
	}

	public int getYearValidity() {
		return validityDate.getYear();
	}

	public String getValidnost() {
		return validnost;
	}

	public void setValidnost(String tipVinetka) {
		if(tipVinetka.equalsIgnoreCase("day") || tipVinetka.equalsIgnoreCase("month")|| tipVinetka.equalsIgnoreCase("year")){
			this.validnost = tipVinetka;
		}
	}
}
