
public class Klavishen extends MusicInstrument {

	public Klavishen(String name, int price,String type) throws IllegalNameException, IllegalPriceException {
		super(name, price,type);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void setName(String name) throws IllegalNameException {
		if(name.equals("piano") || name.equals("akordeon")|| name.equals("organ")){
		super.setName(name);
		}else{
			System.out.println("Not a valid name for the type of instrument");
		}
	}
	@Override
	public void setType(String type) {
		if(type.equals("klavishen"))
		super.setType(type);
	}
}
