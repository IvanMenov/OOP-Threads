
public class Demo {
	public static void main(String[] args) {
		
		PetrolStation petrol= new PetrolStation();
		System.out.println("Vinetki in the petrol station:");
		for (int i = 0; i < petrol.getVinetki().length; i++) {
			System.out.println(petrol.getVinetka(i).getColor()+" "+petrol.getVinetka(i).getCena()+" "+petrol.getVinetka(i).getClass());
		}
		System.out.println();
		String[] names={"Ivan", "Angel", "Kiril", "Georgi", "Vasil","Boian","Petar","Dimitar","Nikolay","Ivailo"};
		Driver[] driver= new Driver[5];
		for (int i = 0; i <driver.length ;i++) {
			int randomIndexName= (int)((Math.random()*(10-0)));
			int randomMoney= (int)((Math.random()*(10000-5000))+1000);
			driver[i]= new Driver(names[randomIndexName], randomMoney);
			driver[i].setStation(petrol);
		}
		String[]models ={"kola", "avtobus","kamion"};
		Vehicle[]vehicle = new Vehicle[15];
		for (int i = 0; i < vehicle.length; i++) {
			int randomIndexModel= (int)((Math.random()*(2-0+1)));
			int randomYear= (int)((Math.random()*(2016-1999+1))+1999);
			vehicle[i]= new Vehicle(models[randomIndexModel], randomYear);
		}
		for (int i = 0; i < driver.length; i++) {
			int k=i*3;
			for (int j = k; j < k+3; j++) {
				driver[i].addVehicle(vehicle[j]);
				System.out.println(vehicle[j].getModel()+"- "+vehicle[j].getYearOfProduction()+" given to "+driver[i].getName());
			}
		}
		System.out.println();
		driver[2].buyVinetka(0, "day");
		System.out.println();
		for (int i = 0; i < driver.length; i++) {
			System.out.println(driver[i].getName()+" buys vinetki for:");
			driver[i].buyVinetkaForAll("month");
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < driver.length; i++) {
			System.out.println(driver[i].getName());
			System.out.println("Money left after buying vinetki:"+ driver[i].getMoneyBallance()+" lv.");
			System.out.println(driver[i].getName()+" has: ");
			for (int j = 0; j < driver[i].getVehicles().length; j++) {
				if(driver[i].getVehicle(j)!=null){
					System.out.print(driver[i].getVehicle(j).getModel()+", ");
				}
			}System.out.println();
			System.out.println(driver[i].getName()+"'s vehicles vinetki:");
			driver[i].printExpiredVinetki();
			System.out.println();
		}
		System.out.println("Money received after selling vinetki: "+petrol.getOborot()+" lv.");
		System.out.println("Vinetki left in the petrol station: ");
		for (int i = 0; i < petrol.getVinetki().length; i++) {
			if(petrol.getVinetka(i)!=null){
				System.out.println(petrol.getVinetka(i).getColor()+" "+petrol.getVinetka(i).getCena()+" "+petrol.getVinetka(i).getClass());
			}
		}
		
	}
}
