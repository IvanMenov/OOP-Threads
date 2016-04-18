
public  class Vehicle {
	private String model;
	private Vinetka vinetka;
	private int yearOfProduction;
	
	
	public Vehicle(String model, int year) {
		this.setModel(model);
		this.setYearOfProduction(year);
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		if(model!=null){
			if(model.equalsIgnoreCase("kola") || model.equalsIgnoreCase("avtobus") || model.equalsIgnoreCase("kamion")){
				this.model = model;
			}
		}
		
	}
	public Vinetka getVinetka() {
		return vinetka;
	}
	public void setVinetka(Vinetka vinetka) {
		if(vinetka!=null){
			this.vinetka = vinetka;
		}
	}
	public int getYearOfProduction() {
		return yearOfProduction;
	}
	public void setYearOfProduction(int yearOfProduction) {
		if(yearOfProduction>1990 && yearOfProduction<2017){
			this.yearOfProduction = yearOfProduction;
		}
	}
}
