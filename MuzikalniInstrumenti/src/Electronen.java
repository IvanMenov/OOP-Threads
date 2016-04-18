
public class Electronen extends MusicInstrument {

	public Electronen(String name, int price,String type) throws IllegalNameException, IllegalPriceException {
		super(name, price,type);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void setName(String name) throws IllegalNameException {
		if(name.equals("sintezator")|| name.equals("bas-kitara") || name.equals("electricheska cigulka")){
		super.setName(name);
		}
		else{
			System.out.println("Not a valid name for the type of instrument.");
		}
	}
	@Override
	public void setType(String type) {
		if(type.equals("electronen"))
		super.setType(type);
	}
}
