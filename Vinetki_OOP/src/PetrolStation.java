import java.util.Arrays;

public class PetrolStation {
	private static final int MAX_NUMBER_VINETKI = 150;
	private float oborot;
	private Vinetka[] vinetki= new Vinetka[MAX_NUMBER_VINETKI];
	
	public PetrolStation() {
		generateAndAddVinetki();
		sortVinetki(vinetki);
	}
	
	public void sellVinetka(Vehicle vehicle, String validity){
		int index=0;
		if(vehicle!=null && validity!=null){
			for ( index = 0; index < vinetki.length; index++) {
				if(vinetki[index]!=null){
					if(vehicle.getModel().equalsIgnoreCase("kola")){
						if(vinetki[index] instanceof VinetkaKola){
							if(vinetki[index].getValidnost().equalsIgnoreCase(validity)){
							break;
							}
						}
					}if(vehicle.getModel().equalsIgnoreCase("avtobus")){
						if(vinetki[index] instanceof VinetkaAvtobus){
							if(vinetki[index].getValidnost().equalsIgnoreCase(validity)){
							break;
							}
						}
					}if(vehicle.getModel().equalsIgnoreCase("kamion")){
						if(vinetki[index] instanceof VinetkaKamion){
							if(vinetki[index].getValidnost().equalsIgnoreCase(validity)){
							 break;
							}
						}
					}
				}
			}
			vehicle.setVinetka(vinetki[index]);
			vinetki[index]=null;
			return;
			
		}
	}
	private void sortVinetki(Vinetka[]vinetki){
		if(vinetki!=null){
			for (int index = 0; index < vinetki.length; index++) {
				boolean isSorted=true;
				for (int innerIndex = 0; innerIndex < vinetki.length-1-index; innerIndex++) {
					if(vinetki[innerIndex]!=null && vinetki[innerIndex+1]!=null){
						if(vinetki[innerIndex].getCena()>vinetki[innerIndex+1].getCena()){
							Vinetka temp= this.vinetki[innerIndex];
							this.vinetki[innerIndex]= this.vinetki[innerIndex+1];
							this.vinetki[innerIndex+1]=temp;
							isSorted=false;
						}
					}
					
				}if(isSorted==true){
					return;
				}
				}		
		}
	}
	
	private void generateAndAddVinetki(){
		Vinetka v=null;
		String[]dateValidity={"day","month","year"};
		int randomValidity=0;
		for (int i = 0; i < vinetki.length; i++) {
			int random = (int)((Math.random()*(3-1+1))+1);
			switch (random) {
			case 1:
				randomValidity=(int)((Math.random()*(2-0+1)));
				Vinetka zaKola= new VinetkaKola(dateValidity[randomValidity]);
				addVinetka(zaKola);
				break;
			case 2:
				randomValidity=(int)((Math.random()*(2-0+1)));
				Vinetka zaKamion= new VinetkaKamion(dateValidity[randomValidity]);
				addVinetka(zaKamion);
				break;
			case 3:
				randomValidity=(int)((Math.random()*(2-0+1)));
				Vinetka zaAvtobus= new VinetkaAvtobus(dateValidity[randomValidity]);
				addVinetka(zaAvtobus);
				break;
			
			default:
				break;		
			}	
		}
	}
	
	public float getOborot() {
		return oborot;
	}
	public void addOborot(float oborot) {
		this.oborot += oborot;
	}
	public Vinetka getVinetka(int index) {
		if(index>=0 && index<this.vinetki.length){
		return vinetki[index];
		}
		else{
			return null;
		}
	}
	public Vinetka[] getVinetki(){
		return Arrays.copyOf(this.vinetki, this.vinetki.length);
	}
	public void addVinetka(Vinetka vinetki) {
		if(vinetki!=null){
			for (int i = 0; i < this.vinetki.length; i++) {
				if(this.vinetki[i]==null){
					this.vinetki[i]=vinetki;
					return;
				}
			}
		}
	}

	
	
	
}
