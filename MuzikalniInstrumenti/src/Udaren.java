
public class Udaren extends MusicInstrument{

	public Udaren(String name, int price, String type) throws IllegalNameException, IllegalPriceException {
		super(name, price,type);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void setName(String name) throws IllegalNameException {
		if(name.equals("baraban")|| name.equals("tarambuka")|| name.equals("daire")
				|| name.equals("tupan")){
			super.setName(name);
		}else{
			System.out.println("Not valid name for the instrument.");
		}
	}
	@Override
	public void setType(String type) {
		if(type.equals("udaren"))
		super.setType(type);
	}
}	
