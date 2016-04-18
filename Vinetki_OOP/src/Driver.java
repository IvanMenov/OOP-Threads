import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
	private static final int MAX_NUMBER_OF_VEHICLES = 10;
	private String name;
	private Vehicle[] vehicles= new Vehicle[MAX_NUMBER_OF_VEHICLES];
	private float moneyBallance;
	private PetrolStation station;
	
	
	public Driver(final String name, float money) {
		if(name!=null && !name.equals("")){
			this.name=name;
		}
		this.setMoneyBallance(money);
	}
	
	public void printExpiredVinetki(){
		LocalDateTime currentDate = LocalDateTime.now();
		int currentDay= currentDate.getDayOfMonth();
		int currentMonth= currentDate.getMonthValue();
		int currentYear= currentDate.getYear();
		System.out.println("current date:"+currentDate.getYear()+" - "+currentDate.getMonthValue()+" - "+currentDate.getDayOfMonth());
		int compare=0;
		for (int i = 0; i < vehicles.length; i++) {
			if(vehicles[i]!=null){
			if(vehicles[i].getVinetka()!=null){
				System.out.println("validity of the vinetka: "+vehicles[i].getVinetka().getYearValidity()+" - "+
				vehicles[i].getVinetka().getMonthValidity()+" - "+vehicles[i].getVinetka().getDayValidity());
				
				LocalDateTime validDate = LocalDateTime.of(vehicles[i].getVinetka().getYearValidity(),
						vehicles[i].getVinetka().getMonthValidity(), vehicles[i].getVinetka().getDayValidity(), 1, 20);
						
				if(currentDate.isAfter(validDate)){
					System.out.println("Validity has expired!");
				}
			}
		}
	}
	}
	public void buyVinetka(int indexVehicle,String validity){
		if(indexVehicle>=0 && indexVehicle<vehicles.length && station!=null &&
				(validity.equalsIgnoreCase("day")|| validity.equalsIgnoreCase("month")||validity.equalsIgnoreCase("year"))){
			if(vehicles[indexVehicle].getVinetka()==null){
				station.sellVinetka(vehicles[indexVehicle], validity);
				station.addOborot(vehicles[indexVehicle].getVinetka().getCena());
				this.setMoneyBallance(moneyBallance-vehicles[indexVehicle].getVinetka().getCena());
				int time=vehicles[indexVehicle].getVinetka().stick();
				System.out.println("It took "+this.getName()+" "+time+" sec. to stick the vinetka.");
				System.out.println(this.getName()+"'s "+vehicles[indexVehicle].getModel()+vehicles[indexVehicle].getYearOfProduction()+" has a "+validity+" vinetka.");
			}
		}
	}
	public void buyVinetkaForAll(String validity){
		if(station!=null && (validity.equalsIgnoreCase("day")||
				validity.equalsIgnoreCase("month")||validity.equalsIgnoreCase("year"))){
			for (int i = 0; i < vehicles.length; i++) {
				if(vehicles[i]!=null){
					if(vehicles[i].getVinetka()==null){
						station.sellVinetka(vehicles[i],validity );
						station.addOborot(vehicles[i].getVinetka().getCena());
						this.setMoneyBallance(moneyBallance-vehicles[i].getVinetka().getCena());
						int time= vehicles[i].getVinetka().stick();
						System.out.println("It took "+this.getName()+" "+time+" sec. to stick the vinetka.");
						System.out.println(vehicles[i].getModel()+"-"+vehicles[i].getYearOfProduction()+" has a "+validity+" vinetka.");
					}else{
						System.out.println(vehicles[i].getModel()+"-"+vehicles[i].getYearOfProduction()+" already has a vinetka.");
						continue;
					}
				}
			}
		}
	}
	public String getName() {
		return name;
	}
	
	public Vehicle getVehicle(int index){
		if(index>=0 && index<getVehicles().length){
				if(vehicles[index]!=null){
					return vehicles[index];
				}
			
		}return null;
	}
	public Vehicle[] getVehicles() {
		return Arrays.copyOf(vehicles, vehicles.length);
	}
	public void addVehicle(Vehicle vehicle) {
		if(vehicle!=null){
			for (int i = 0; i < vehicles.length; i++) {
				if(vehicles[i]==null){
					vehicles[i]=vehicle;
					return;
				}
			}
		}
	}
	public float getMoneyBallance() {
		return moneyBallance;
	}
	public void setMoneyBallance(float moneyBallance) {
		if(moneyBallance>0){
			this.moneyBallance = moneyBallance;
		}
	}
	public PetrolStation getStation() {
		return station;
	}
	public void setStation(PetrolStation station) {
		if(station !=null){
		this.station = station;
		}
	}
	
	
}

