
public class Strunen extends MusicInstrument {

	public Strunen(String name, int price,String type) throws IllegalNameException, IllegalPriceException {
		super(name, price,type);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void setName(String name) throws IllegalNameException {
		if(name.equals("cigulka")|| name.equals("viola") || name.equals("kontrabas")
				|| name.equals("kitara") || name.equals("arfa") || name.equals("gudulka")){
			super.setName(name);
		}else{
			System.out.println("Not a string instrument.");
		}
	}
	@Override
	public void setType(String type) {
	if(type.equals("strunen"))
		super.setType(type);
	}
}
