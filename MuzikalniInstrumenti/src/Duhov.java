
public class Duhov extends MusicInstrument {

	public Duhov(String name, int price, String type) throws IllegalNameException, IllegalPriceException {
		super(name, price,type);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void setName(String name) throws IllegalNameException {
		if(name.equals("trompet")|| name.equals("trombon") || name.equals("tuba")
				|| name.equals("klarinet") || name.equals("fleita")){
		super.setName(name);
		}
		else{
			System.out.println("Not a valid name for the type of instrument.");
		}
	}
	@Override
	public void setType(String type) {
		if(type.equals("duhov"))
		super.setType(type);
	}
}
